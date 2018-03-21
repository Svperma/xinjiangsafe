package com.dsib.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgInsureConfig;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgInsureConfigService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.InsurePolicyService;
import com.dsib.service.QyMycheckService;
import com.dsib.service.QyMypolicyService;
import com.dsib.util.FileUtil;
import com.dsib.util.StringUtil;

@Controller
@RequestMapping("/policyinfo")
@SessionAttributes({ "pagination", "countMap", "insurerList", "detailMap" })
public class PolicyInfoController extends BaseController {

	@Autowired
	private GuPolicyMainService guPolicyMainService;
	@Resource(name = "ggInsureConfigService")
	private GgInsureConfigService ggInsureConfigService;
	@Resource(name = "qymychecked")
	private QyMycheckService mychecked;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;

	@Resource(name = "QyMyPolicy")
	private QyMypolicyService qymypolicy;
	
	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	
	/**
	 * 初始化监管用户"保险信息"
	 * @return
	 */
	@RequestMapping("/policyInfo")
	public ModelAndView policyInfo() {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String comLevel = ggUser.getComLevel();
		Map<String, String> map = new HashMap<String, String>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		map.put("classCode", null);
		// 查询保险公司
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setRiskCode("0901");
		if ("1".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
			ggInsureConfig.setAreaCode(ggUser.getProvince());
		} else if ("2".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
			map.put("city", ggUser.getCity());
			ggInsureConfig.setAreaCode(ggUser.getCity());
		} else if ("3".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
			map.put("city", ggUser.getCity());
			map.put("county", ggUser.getCounty());
			ggInsureConfig.setAreaCode(ggUser.getCounty());
		}

		String pageNo = StringUtils.isEmpty(request.getParameter("pageNo")) ? "1" : request.getParameter("pageNo");
		Pagination pagination = new Pagination(Integer.valueOf(pageNo));
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = guPolicyMainService
				.getPolicyInfo(pagination);
		List<GgInsureConfig> insurerList = ggInsureConfigService
				.getInsurance(ggInsureConfig);
		// 统计数据
		Map<String, BigDecimal> countMap = new HashMap<String, BigDecimal>();
		countMap.put("enterprise", new BigDecimal("0"));
		countMap.put("premium", new BigDecimal("0"));
		countMap.put("preventFee", new BigDecimal("0"));
		countMap.put("payAmount", new BigDecimal("0"));
		countMap.put("assistance", new BigDecimal("0"));
		countMap.put("suggestion", new BigDecimal("0"));
//		if (list != null && !"".equals(list)) {
//			for (int i = 0, n = list.size(); i < n; i++) {
//				Map<String, Object> item = list.get(i);
//				countMap.put(
//						"enterprise",
//						countMap.get("enterprise").add(
//								(BigDecimal) item.get("ENTERPRISE")));
//				countMap.put(
//						"premium",
//						countMap.get("premium").add(
//								(BigDecimal) item.get("PREMIUM")));
//				countMap.put(
//						"preventFee",
//						countMap.get("preventFee").add(
//								(BigDecimal) item.get("PREVENTFEE")));
//				countMap.put(
//						"payAmount",
//						countMap.get("payAmount").add(
//								(BigDecimal) item.get("PAYAMOUNT")));
//				countMap.put(
//						"assistance",
//						countMap.get("assistance").add(
//								(BigDecimal) item.get("ASSISTANCE")));
//				countMap.put(
//						"suggestion",
//						countMap.get("suggestion").add(
//								(BigDecimal) item.get("SUGGESTION")));
//			}
//		}
		pagination.setResultList(list);
		mad.setViewName("/jianguan/policyinfo/policyInfoCondition");
		mad.addObject("pagination", pagination);
		mad.addObject("countMap", countMap);
		mad.addObject("insurerList", insurerList);
		return mad;
	}

	/**
	 * 监管用户==>"保险信息"==>"查询"
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryPolicy")
	public ModelAndView queryPolicy(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String classCode = request.getParameter("classCode");
		String businessClass = request.getParameter("businessClass");
		String insurance = request.getParameter("insurance");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		// 查询条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("classCode", classCode);
		conditionMap.put("businessClass", businessClass);
		conditionMap.put("beginDate", beginDate);
		conditionMap.put("endDate", endDate);
		conditionMap.put("insurance", insurance);
		// 构造分页对象
		String pageNo = StringUtils.isEmpty(request.getParameter("pageNo")) ? "1" : request.getParameter("pageNo");
		Pagination pagination = new Pagination(Integer.valueOf(pageNo));
		pagination.setQueryCondition(conditionMap);
		// 查询数据
		List<Map<String, Object>> list = null;
		list = guPolicyMainService.getPolicyInfo(pagination);
		// 统计数据
		Map<String, BigDecimal> countMap = new HashMap<String, BigDecimal>();
		countMap.put("enterprise", new BigDecimal("0"));
		countMap.put("premium", new BigDecimal("0"));
		countMap.put("preventFee", new BigDecimal("0"));
		countMap.put("payAmount", new BigDecimal("0"));
		countMap.put("assistance", new BigDecimal("0"));
		countMap.put("suggestion", new BigDecimal("0"));

		mad.addObject("countMap", countMap);
		mad.setViewName("/jianguan/policyinfo/policyInfoResult");

		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		return mad;
	}
	
	/**
	 * 保险信息分页
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/policyInfoContinue")
	public ModelAndView policyInfoContinue(String pageNo) {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		List<Map<String, Object>> list = guPolicyMainService.getPolicyInfo(pagination);
		pagination.setResultList(list);
		session.setAttribute("pagination", pagination);
		mav.setViewName("/jianguan/policyinfo/policyInfoResult");
		return mav;
	}

	@RequestMapping("/queryClaim")
	public ModelAndView queryClaim(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String classCode = request.getParameter("businessClass");
		String insurance = request.getParameter("insurance");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		// 查询条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("classCode", classCode);
		conditionMap.put("beginDate", beginDate.equals("请输入开始日期") ? ""
				: beginDate);
		conditionMap.put("endDate", endDate.equals("请输入截止日期") ? "" : endDate);
		conditionMap.put("insurance", insurance);
		// 构造分页对象
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		// 查询数据
		List<Map<String, Object>> list = null;
		list = guPolicyMainService.getClaimMain(pagination);
		mad.setViewName("/jianguan/policyinfo/claimInfoResult");
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		return mad;
	}

	/**
	 * 赔案详情
	 * 
	 * @return
	 */
	@RequestMapping("/claimDetail")
	public ModelAndView claimDetail() {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String county = request.getParameter("county");
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		Map<String, Object> conditionMap = (Map<String, Object>) pagination
				.getQueryCondition();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> list = guPolicyMainService
				.claimDetail(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		mad.setViewName("/jianguan/policyinfo/claimDetail");
		return mad;
	}

	/**
	 * 赔案明细分页
	 * 
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/claimDetailContinue")
	public ModelAndView claimDetailContinue(@RequestParam String pageNo) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = guPolicyMainService.getEnterprises(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/jianguan/policyinfo/claimDetail");
		return mad;
	}

	/**
	 * 查看详情
	 * 
	 * @param businessNo
	 * @return
	 */
	@RequestMapping("/viewDetail")
	public ModelAndView viewDetail(@RequestParam String businessNo) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> map = guPolicyMainService.viewDetail(businessNo);
		mad.addObject("detailMap", map);
		mad.setViewName("/jianguan/policyinfo/viewDetail");
		return mad;
	}

	/**
	 * 企业明细
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/enterpriseDetail")
	public ModelAndView enterpriseDetail(
			@RequestParam(name = "insurerCode") String insurerCode,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = (Map<String, Object>) (((Pagination) session
				.getAttribute("pagination")).getQueryCondition());
		conditionMap.put("insurance", insurerCode);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		pagination = guPolicyMainService.getEnterprises(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/jianguan/policyinfo/enterpriseDetail");
		return mad;
	}

	/**
	 * 企业明细 翻页
	 * 
	 * @return
	 */
	@RequestMapping("/enterpriseDetailContinue")
	public ModelAndView enterpriseDetailContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = guPolicyMainService.getEnterprises(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/jianguan/policyinfo/enterpriseDetail");
		return mad;
	}

	/**
	 * 援助金明细
	 * 
	 * @return
	 */
	@RequestMapping("/assistanceDetail")
	public ModelAndView assistanceDetail(
			@RequestParam(name = "insurerCode") String insurerCode,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		// 获取条件
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		@SuppressWarnings("unchecked")
		Map<String, Object> conditionMap = (Map<String, Object>) pagination
				.getQueryCondition();
		conditionMap.put("insurance", insurerCode);
		pagination.setQueryCondition(conditionMap);
		pagination = guPolicyMainService.getAssistaces(pagination);
		mad.setViewName("/jianguan/policyinfo/assistanceDetail");
		mad.addObject("pagination", pagination);
		return mad;
	}

	/**
	 * 援助金明细翻页
	 * 
	 * @return
	 */
	@RequestMapping("/assistanceDetailContinue")
	public ModelAndView assistanceDetailContinue(
			@RequestParam(name = "pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		// 获取条件
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = guPolicyMainService.getAssistaces(pagination);
		mad.setViewName("/jianguan/policyinfo/assistanceDetail");
		mad.addObject("pagination", pagination);
		return mad;
	}

	/**
	 * 反馈
	 */
	@RequestMapping("/getConplainAndFeedback")
	public ModelAndView getConplainAndFeedback(
			@RequestParam(name = "insurerCode") String insurerCode,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		// 获取条件
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		@SuppressWarnings("unchecked")
		Map<String, Object> conditionMap = (Map<String, Object>) pagination
				.getQueryCondition();
		conditionMap.put("insurance", insurerCode);
		pagination.setQueryCondition(conditionMap);
		List<GgEvaluate> list = guPolicyMainService
				.getComplainAndFeedback(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		mad.setViewName("/jianguan/policyinfo/complainAndFeedback");
		return mad;
	}

	@RequestMapping("/exportExcel")
	/**
	 * 导报表
	 * @param response
	 */
	public void exportExcel(HttpServletResponse response,
			HttpServletRequest request) {
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String classCode = request.getParameter("classCode");
		String insurance = request.getParameter("insurance");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		// 查询条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("classCode", classCode);
		conditionMap.put("beginDate", beginDate);
		conditionMap.put("endDate", endDate);
		conditionMap.put("insuracne", insurance);
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(conditionMap);
		// 查询保单信息
		List<Map<String, Object>> mainList = guPolicyMainService
				.policyToExcel(adapter);
		// 存放各保险公司代码
		List<String> insuranceList = new ArrayList<String>();
		Map<String, Object> mainResultMap = null;
		if (mainList != null && mainList.size() > 0) {
			for (int i = 0, n = mainList.size(); i < n; i++) {
				mainResultMap = mainList.get(i);
				insuranceList.add((String) mainResultMap.get("INSURERCODE"));
			}
		}
		// 企业报表需要查询多个保险公司的信息
		conditionMap.put("insuracne", insuranceList);
		adapter.setQueryCondition(conditionMap);
		// 企业明细
		List<Map<String, Object>> enterpriseList = guPolicyMainService
				.enterprisesExcel(adapter);
		//
		List<Map<String, Object>> assistanceList = guPolicyMainService
				.assistancesExcel(adapter);
		// 标题
		Object[] titles = new Object[3];
		titles[0] = new String[] { "INSURER:保险公司名称", "AREA:地区",
				"ENTERPRISE:承保企业数", "PREMIUM:保费（元）", "PREVENTFEE:事故预防费用（元）",
				"PAYAMOUNT:赔款总额（元）", "ASSISTANCE:援助金（元）", "SUGGESTION:投诉及反馈" };
		titles[1] = new String[] { "COMNAME:企业名称", "PROVINCE:省", "CITY:市",
				"COUNTY:区县", "INSURER:保险公司名称", "BETWEENDATE:保险期间",
				"PREMIUM:保费（元）", "UNITAMOUNT:每人赔偿限额（万元）",
				"AMOUNT:每次事故及累计赔偿限额（万元）" };
		titles[2] = new String[] { "COMNAME:援助企业", "PROVINCE:省", "CITY:市",
				"COUNTY:区县", "INSURER:保险公司名称", "HAPPENDATE:援助时间",
				"ASSISTANCE:援助金额（万元）" };
		// 内容
		Object[] lists = new Object[3];
		lists[0] = mainList;
		lists[1] = enterpriseList;
		lists[2] = assistanceList;
		// 类型
		Class[] clas = new Class[3];
		clas[0] = Map.class;
		clas[2] = Map.class;
		clas[1] = Map.class;
		// sheet名
		Object[] sheetName = new Object[3];
		sheetName[0] = "保险信息";
		sheetName[1] = "企业明细";
		sheetName[2] = "援助金明细";
		FileUtil.exportMultiToExcel(titles, lists, clas, sheetName, "保险信息",response);
	}
	@RequestMapping("/getPolicyList")
	public ModelAndView getPolicyList() {
 		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		// 条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		String flag = ggUser.getFlag();
		if("1".equals(flag)){
			map.put("yewuguishu", ggUser.getUserCode());
		}else{
			if ("1".equals(comLevel)) {
				// 省级用户
				map.put("province", ggUser.getProvince());
			} else if ("2".equals(comLevel)) {
				// 市
				map.put("province", ggUser.getProvince());
				map.put("city", ggUser.getCity());
			} else if ("3".equals(comLevel)) {
				map.put("province", ggUser.getProvince());
				map.put("city", ggUser.getCity());
				map.put("county", ggUser.getCounty());
			}
		}
		GgCode code = new GgCode();
		String Pro = ggUser.getProvince();
		code.setCodeType("Province");
		code.setCodeCode(Pro);
		List<GgCode> province = ggCodeService.getGgCodeByObj(code);
		String cit = ggUser.getCity();
		code.setCodeType("City");
		code.setCodeCode(cit);
		List<GgCode> city = ggCodeService.getGgCodeByObj(code);
		String coun = ggUser.getCounty();
		code.setCodeType("County");
		code.setCodeCode(coun);
		List<GgCode> county = ggCodeService.getGgCodeByObj(code);
		session.setAttribute("province", province.get(0));
		session.setAttribute("city", city.get(0));
		session.setAttribute("county", county.get(0));
		/** 查询行业大类 **/
		GgCode code1 = new GgCode();
		code1.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code1);
		Pagination pagination = new Pagination();
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = mychecked.getmypolicyInitjg(pagination);
		pagination.setResultList(list);
		
		//总合计
		List<Map<String, String>> summations = mychecked.getMyPolicyInitJgNotPage(map);
		Map<String, String> summation = summations.get(0);
		
		
		mad.addObject("pagination",pagination);
		mad.addObject("list_classCode",list_classCode);
		mad.addObject("list_CICompanycode",list_ggConfig);
		
		session.setAttribute("summation", summation);
		
		mad.setViewName("/jianguan/mycheckCondition");
		return mad;
	}
	/**
	 * 监管部门查询保单初始页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/mycheckinitjg")
	public ModelAndView mycheckinitjg(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String comLevel = ggUser.getComLevel();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		String flag = ggUser.getFlag();
		if("1".equals(flag)){
			map.put("yewuguishu", ggUser.getUserCode());
		}else{
			if ("1".equals(comLevel)) {
				// 省级用户
				map.put("province", ggUser.getProvince());
			} else if ("2".equals(comLevel)) {
				// 市
				map.put("province", ggUser.getProvince());
				map.put("city", ggUser.getCity());
			} else if ("3".equals(comLevel)) {
				map.put("province", ggUser.getProvince());
				map.put("city", ggUser.getCity());
				map.put("county", ggUser.getCounty());
			}
		}
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		List<Map<String, Object>> resultList = mychecked.getmypolicyInitjg(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/mycheckResult");
		return mad;
	}
	/**
	 * 监管部门查询按钮
	 * @param request
	 * @return
	 */
	@RequestMapping("/mycheckqueryjg")
	public ModelAndView mycheckqueryjj(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String POLICYNO = request.getParameter("POLICYNO");
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String whyInsure = request.getParameter("whyInsure");//保单状态
		
		String reservation = request.getParameter("reservation");//保险起期条件
		String startDate = null;
		String endDate = null; 
		if(StringUtil.isNotEmpty(reservation)) {
			 startDate = reservation.substring(0,10);
			 endDate = reservation.substring(13);
		}
		String reservation1 = request.getParameter("reservation1");//保险止期条件
		String startDate1 = null;
		String endDate1 = null; 
		if(StringUtil.isNotEmpty(reservation1)) {
			startDate1 = reservation1.substring(0,10);
			endDate1 = reservation1.substring(13);
		}
		String renshu1 = request.getParameter("renshu1");//最小人数条件
		String renshu2 = request.getParameter("renshu2");//最大人数条件
		String baofei1 = request.getParameter("baofei1");//最小保费条件
		String baofei2 = request.getParameter("baofei2");//最大保费条件
		String everone1 = request.getParameter("everone1");//最小每人保额条件
		String everone2 = request.getParameter("everone2");//最大没人保额条件
		String companyName = request.getParameter("companyName");//公司名称条件
		
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String flag = ggUser.getFlag();
		if("1".equals(flag)){
			conditionMap.put("yewuguishu", ggUser.getUserCode());
		}else{
			conditionMap.put("province", province.equals("选择省份") ? "" : province);
			conditionMap.put("city", city.equals("选择城市") ? "" : city);
			conditionMap.put("county", county.equals("选择区县") ? "" : county);
		}
		conditionMap.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		conditionMap.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		conditionMap.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		conditionMap.put("POLICYNO", POLICYNO.equals("请输入保单号") ? "" : POLICYNO);
		
		conditionMap.put("startDate",startDate);
		conditionMap.put("endDate",endDate);
		conditionMap.put("startDate1",startDate1);
		conditionMap.put("endDate1",endDate1);
		conditionMap.put("renshu1",renshu1 );
		conditionMap.put("renshu2",renshu2 );
		conditionMap.put("baofei1",baofei1 );
		conditionMap.put("baofei2",baofei2 );
		conditionMap.put("everone1",everone1 );
		conditionMap.put("everone2", everone2);
		conditionMap.put("companyName",companyName );
		
		if("1".equals(whyInsure)){
			conditionMap.put("statusT", whyInsure);
		}
		if("0".equals(whyInsure)){
			conditionMap.put("statusF", whyInsure);
		}
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = mychecked.getmypolicyInitjg(pagination);
		pagination.setResultList(resultList);
		
		//总合计
		List<Map<String, String>> summations = mychecked.getMyPolicyInitJgNotPage(conditionMap);
		Map<String, String> summation = summations.get(0);
		
		mad.addObject(pagination);
		mad.addObject("summation",summation);
		mad.setViewName("/jianguan/mycheckResult");
		return mad;
	}
	/**
	 * 监管用户保单查询上下页
	 * @param pageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/mycheckinitjgPain")
	public ModelAndView mycheckinitjgPain(@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = mychecked.getmypolicyInitjgPagination(pagination);
		
		Map<String, Object> queryCondition = (Map<String, Object>) pagination.getQueryCondition();
		
		//总合计
		List<Map<String, String>> summations = mychecked.getMyPolicyInitJgNotPage(queryCondition);
		Map<String, String> summation = summations.get(0);
		session.setAttribute("summation", summation);
		
		mad.addObject(pagination);
		mad.setViewName("/jianguan/mycheckResult");
		return mad;
	}
	
	/**
	 * 经济公司导出保单
	 * @param response
	 * @param request
	 */
	@RequestMapping("/exportPolicy")
	public void exportPolicy(HttpServletResponse response,HttpServletRequest request) {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String POLICYNO = request.getParameter("POLICYNO");
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String whyInsure = request.getParameter("whyInsure");//保单状态
		
		String reservation = request.getParameter("reservation");//保险起期条件
		String startDate = null;
		String endDate = null; 
		if(StringUtil.isNotEmpty(reservation)) {
			 startDate = reservation.substring(0,10);
			 endDate = reservation.substring(13);
		}
		String reservation1 = request.getParameter("reservation1");//保险止期条件
		String startDate1 = null;
		String endDate1 = null; 
		if(StringUtil.isNotEmpty(reservation1)) {
			startDate1 = reservation1.substring(0,10);
			endDate1 = reservation1.substring(13);
		}
		String renshu1 = request.getParameter("renshu1");//最小人数条件
		String renshu2 = request.getParameter("renshu2");//最大人数条件
		String baofei1 = request.getParameter("baofei1");//最小保费条件
		String baofei2 = request.getParameter("baofei2");//最大保费条件
		String everone1 = request.getParameter("everone1");//最小每人保额条件
		String everone2 = request.getParameter("everone2");//最大没人保额条件
		String companyName = request.getParameter("companyName");//公司名称条件
		
		
		conditionMap.put("province", province.equals("选择省份") ? "" : province);
		conditionMap.put("city", city.equals("选择城市") ? "" : city);
		conditionMap.put("county", county.equals("选择区县") ? "" : county);
		conditionMap.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		conditionMap.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		conditionMap.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		conditionMap.put("POLICYNO", POLICYNO.equals("请输入保单号") ? "" : POLICYNO);
		
		conditionMap.put("startDate",startDate);
		conditionMap.put("endDate",endDate);
		conditionMap.put("startDate1",startDate1);
		conditionMap.put("endDate1",endDate1);
		conditionMap.put("renshu1",renshu1 );
		conditionMap.put("renshu2",renshu2 );
		conditionMap.put("baofei1",baofei1 );
		conditionMap.put("baofei2",baofei2 );
		conditionMap.put("everone1",everone1 );
		conditionMap.put("everone2", everone2);
		conditionMap.put("companyName",companyName );
		
		
		if("1".equals(whyInsure)){
			conditionMap.put("statusT", whyInsure);
		}
		if("0".equals(whyInsure)){
			conditionMap.put("statusF", whyInsure);
		}
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(conditionMap);
		// 查询信息
		List<Map<String, Object>> list = mychecked.exportPolicy(adapter);
		// 标题
		String[] titles = new String[] {"POLICYNO:保单号","PROVINCE:省","CITY:城市","COUNTY:区县","INSURERCODE:保险公司",
				"GUISHU:业务归属机构","ORDERNAME:业务员","STARTDATE:起保日期","ENDDATE:终保日期","SIGNDATE:签单日期","SPREADSHEETPREMIUM:总保费",
				"CLASSCODE:行业大类", "BUSINESSCODE:行业小类","INSUREDNAME:被保险人", "EMCOUNT:投保人数","FLAG:业务归属角色"
				};
		// 内容
		List<Map<String, Object>> lists = list;
		// 类型
		Class clas = Map.class;
		// sheet名
		String sheetName = "保单统计";
		
		FileUtil.setIsTotal(true);//触发合计行
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}
	

	String SPECIALPROVISIONS = "";
	//监管用户看保单
	@RequestMapping("/mypolicyshowP")
	public ModelAndView mypolicyshowP(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String businessno = request.getParameter("businessno");
		Map<String, Object> resultMap = qymypolicy.getmypolicyshow(businessno);
		Pagination pagination = new Pagination();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("businessno", businessno);
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = qymypolicy
				.getmypolicyappend(pagination);
		pagination.setResultList(resultList);
		GuPolicyMain guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessno);
		resultMap.put("EMCOUNT", guPolicyMain.getCurrency());
		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(businessno);
		guPolicyInsuredKey.setSeriesno(1L);
		GuPolicyInsured guPolicyInsured = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		//总保费
		Object obj = resultMap.get("SPREADSHEETPREMIUM");
		double tempbapfei = Double.valueOf(obj.toString());
		String zongbaofei = new StringUtil().number2CNMontrayUnit(BigDecimal.valueOf(tempbapfei));
		request.setAttribute("zongbaofei", zongbaofei);
		request.setAttribute("zbf", tempbapfei);
		request.setAttribute("standardLevelImg", guPolicyMain.getUnderWriteName());
		GgUserCorp tempUser = new GgUserCorp();
		tempUser.setEmail(guPolicyInsured.getEmail());
		tempUser.setLinkName(guPolicyInsured.getLinkname());
		tempUser.setCompanyName(guPolicyInsured.getInsuredname());
		tempUser.setTelephone(guPolicyInsured.getPhonenumber());
		tempUser.setBusinessLicenseNo(guPolicyInsured.getIdentitynumber());
		tempUser.setCompanyAddress(guPolicyInsured.getInsuredaddress());
		tempUser.setStandardLevel(guPolicyInsured.getPolicyno());
		tempUser.setClassCode(guPolicyInsured.getRemark());
		tempUser.setBusinessClass(guPolicyInsured.getFlag());
		tempUser.setSafetyLicenseNo(guPolicyInsured.getInsuredtype());
		GgCode code = new GgCode();
		code.setCodeType("Province");
		code.setCodeCode(guPolicyMain.getProvince());
		List<GgCode> list_pro = ggCodeService.getGgCodeByObj(code);
		code.setCodeType("City");
		code.setCodeCode(guPolicyMain.getCity());
		List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
		code.setCodeType("County");
		code.setCodeCode(guPolicyMain.getCounty());
		List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);
		// 获取行业大类
		code = new GgCode();
		String classCode = tempUser.getClassCode();
		code.setCodeType("IndustryCategories");
		code.setCodeCode(tempUser.getClassCode());
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
		// 获取经营范围
		code.setCodeType("IndustryType");
		code.setRemark(classCode);
		code.setCodeCode(tempUser.getBusinessClass());
		List<GgCode> list_businessClass = ggCodeService.getGgCodeByObj(code);// 20
		// 安全标准化等级
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		code1.setCodeCode(tempUser.getStandardLevel());
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		mad.addObject("list_pro", list_pro == null ? "": list_pro.get(0).getCodeCName());
		mad.addObject("list_city", list_city == null ? "": list_city.get(0).getCodeCName());
		mad.addObject("list_county", list_county.isEmpty() == true ? "" : list_county.get(0).getCodeCName());
		mad.addObject("list_classCode", list_classCode.isEmpty() ? "": list_classCode.get(0).getCodeCName());
		mad.addObject("list_businessClass",list_businessClass.isEmpty() ? "": list_businessClass.get(0).getCodeCName());
		mad.addObject("list_safe", list_safe == null ? "": list_safe.get(0).getCodeCName());
//		mad.addObject("list_pro", list_pro == null ? new ArrayList<GgCode>()
//				: list_pro);
//		mad.addObject("list_city", list_city == null ? new ArrayList<GgCode>()
//				: list_city);
//		mad.addObject("list_county",
//				list_county == null ? new ArrayList<GgCode>() : list_county);
//		mad.addObject("list_classCode",
//				list_classCode == null ? new ArrayList<GgCode>()
//						: list_classCode);
//		mad.addObject("list_businessClass",
//				list_businessClass == null ? new ArrayList<GgCode>()
//						: list_businessClass);
//		mad.addObject("list_safe", list_safe == null ? new ArrayList<GgCode>()
//				: list_safe);
		String evaluator = request.getParameter("evaluator");
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("bussino", businessno);
		condition.put("evaluator", evaluator);//批单号
		List<Map<String,Object>> apply  = mychecked.getApply(condition);
		if(apply.size()>0){
			SPECIALPROVISIONS = String.valueOf(apply.get(0).get("SPECIALPROVISIONS"));
			mad.addObject("special",apply.get(0));
		}
		mad.addObject("tempUser", tempUser);
		request.setAttribute("inPep", guPolicyInsured);
//		mad.addObject("resultMap", resultMap);
		session.setAttribute("resultMap", resultMap);
		mad.addObject(pagination);
		request.setAttribute("businessno", businessno);
		mad.setViewName("/jianguan/mypolicyShowP");
		return mad;
	}
	
}
