package com.dsib.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GgUserCorpMapper;
import com.dsib.dao.GgUserMapper;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEvaluateDangers;
import com.dsib.entity.GgNotice;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyMain;
import com.dsib.inter.BizInfo;
import com.dsib.inter.HttpRequestUtils;
import com.dsib.service.GcClaimService;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgEmployeeService;
import com.dsib.service.GgEvaluateDangersService;
import com.dsib.service.GgNoticeService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GgUserService;
import com.dsib.service.GuInterfaceService;
import com.dsib.service.GuPolicyInsuredService;
import com.dsib.service.GuPolicyItemKindService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.util.FileUtil;
import com.dsib.util.Md5Util;
import com.dsib.util.StringUtil;

@Controller
@RequestMapping("/usercorp")
@SessionAttributes({ "pagination", "countMap", "intValue", "content", "source",
		"result", "list_safe" })
public class GgUserCorpController extends BaseController {
	private static final String List = null;
	@Autowired
	GgUserMapper userMapper;
	@Autowired
	GgUserCorpMapper userCorpMapper;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService corpService;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService guPolicyMainService;
	@Resource(name = "gcClaimService")
	private GcClaimService claimService;
	@Resource(name = "ggUserService")
	private GgUserService userService;

	@Resource(name = "GuInterface")
	private GuInterfaceService guinter;
	@Resource(name = "ggemployeeService")
	private GgEmployeeService ggemployeeService;
	@Resource(name = "ggNoticeService")
	private GgNoticeService ggNoticeService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService MainService;
	
	@Resource
	private GuPolicyItemKindService itemKindService;
	
	@Resource
	private GuPolicyInsuredService insuredService;
	
	@Resource
	private GgEvaluateDangersService evaluateDangersService;
	
	/**
	 * 页面初始化
	 * 
	 * @author jjx
	 * @param pagination
	 * @param inte
	 * @return
	 */
	@RequestMapping("/initPage")
	public ModelAndView initPage(Pagination pagination, Integer inte) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		Map<String, Object> map = new HashMap<String, Object>();
		GgCode code = new GgCode();

		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		if ("1".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
		} else if ("2".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
			map.put("city", ggUser.getCity());
		} else if ("3".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
			map.put("city", ggUser.getCity());
			map.put("county", ggUser.getCounty());
		}
		pagination.setQueryCondition(map);
		List<Map<String, Object>> corpBy_userCodeCount = corpService.getCorpBy_userCodeCount(pagination);
		List<Map<String, Object>> list = corpService.getCorpBy_userCode1(pagination);
		// 统计数据
//		Integer countNo = new Integer(integerCount);
//		int intValue = countNo.intValue();
		if (comLevel.equals("0")) {
			code.setCodeType("Province");
		}else if (comLevel.equals("1")) {
			code.setRemark(ggUser.getProvince());
			code.setCodeType("City");
			
		}else if (comLevel.equals("2")) {
			code.setRemark(ggUser.getCity());
			code.setCodeType("County");
		}
		List<GgCode> ggCodeByObj = ggCodeService.getGgCodeByObj(code);

		// 原本
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		mad.addObject("intValue", corpBy_userCodeCount);
		mad.addObject("ggCodeByObj", ggCodeByObj);
		mad.setViewName("/jianguan/enterprise/MaininfoResult");
		return mad;
	}

	/**
	 * 企业状况列表
	 * 
	 * @author jjx
	 * @param session
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/maindetails")
	public ModelAndView maininfo(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		try {
			String province = request.getParameter("hidden_province1");
			String city = request.getParameter("hidden_city1");
			String county = request.getParameter("hidden_county1");
			String classCode = request.getParameter("classCode");
			String companyName = request.getParameter("companyName");
			String businessLicenseNo = request
					.getParameter("businessLicenseNo");
			Map<String, Object> pm = new HashMap<String, Object>();
			pm.put("province", province);
			pm.put("city", city);
			pm.put("county", county);
			pm.put("classCode", classCode);
			pm.put("companyName", companyName.equals("请输入需要查询的企业名") ? ""
					: companyName);
			pm.put("businessLicenseNo",
					businessLicenseNo.equals("请输入组织机构代码") ? ""
							: businessLicenseNo);
			pagination.setQueryCondition(pm);
			List<Map<String, Object>> list_userCorp = corpService
					.getCorpBy_userCode1(pagination);
			session.setAttribute("list_userCorp", list_userCorp);
			pagination.setResultList(list_userCorp);
			mav.addObject("pagination", pagination);
			mav.setViewName("/jianguan/enterprise/maininfo");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mav;
	}

	/**
	 * 企业状况详情
	 * 
	 * @author jjx
	 * @param session
	 * @param userCode
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView mainDetails(HttpSession session,
			@RequestParam(value = "userCode") String userCode,
			@RequestParam(value = "businessNo") String businessNo) {
		Map<String, Object> pm = new HashMap<String, Object>();
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		pm.put("userCode", userCode);
		pm.put("businessNo", businessNo);
		pagination.setQueryCondition(pm);
		
		List<Map<String, Object>> list_userCorp  = corpService
					.get_Main_itemBy_userCode(pagination); // 通过userCode查出唯一“对象”，封装成集合
		//用户代码或者保单的订单号是空的  清空查询回来的数据
		if(StringUtil.isEmpty(userCode) && StringUtil.isEmpty(businessNo)) {
			Map<String, Object> map = list_userCorp.get(0);
			Set<Entry<String, Object>> entrySet = map.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				entry.setValue("");
			}
		}
		List<GuPolicyItemKind> list_code = corpService
				.getBusinessNo(businessNo);
		session.setAttribute("userCorp",
				list_userCorp.isEmpty() ? new GgUserCorp() : list_userCorp.get(0));
		mav.addObject("pagination", pagination);
		mav.addObject("businessNo", businessNo);
		session.setAttribute("list_code", list_code);
		String ffff = request.getParameter("busi");
		if("1".equals(ffff)){
			return new ModelAndView("/dsmanager/details");
		}else{
			return new ModelAndView("/jianguan/enterprise/details");
		}
	}
	
	/**
	 * 公司和公司的保险信息
	 * @param userCode
	 * @param businessNo
	 * @return
	 */
	@RequestMapping("/corpAndItem")
	public ModelAndView corpAndItem(String userCode, String businessNo) {
		ModelAndView mav = new ModelAndView();
		
		GgUserCorp userCorp = corpService.getData(userCode);
		
		GuPolicyMain policyMain = guPolicyMainService.selectByPrimaryKey(businessNo);
		
		GuPolicyInsuredKey insuredKey = new GuPolicyInsuredKey();
		insuredKey.setBusinessno(businessNo);
		insuredKey.setSeriesno(2L);
		GuPolicyInsured insured = insuredService.selectByPrimaryKey(insuredKey);
		
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(businessNo);
		List<GuPolicyItemKind> itemKinds = itemKindService.selectListByBusinessNo(guPolicyItemKind);
		for (GuPolicyItemKind itemKind : itemKinds) {
			String key = "itemKind" + itemKind.getKindcode();
			mav.addObject(key, itemKind);
		}
		
		mav.addObject("userCorp", userCorp);
		mav.addObject("policyMain", policyMain);
		mav.addObject("insured", insured);
		mav.addObject("itemKinds", itemKinds);
		mav.setViewName("/jianguan/enterprise/details");
		return mav;
	}
	
	

	/**
	 * 报表下载
	 * 
	 * @param response
	 */
	@RequestMapping("/exportToExcel")
	public void exportExcel(HttpServletResponse response,
			HttpServletRequest request) {
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String classCode = request.getParameter("classCode");
		String companyName = request.getParameter("companyName");
		String businessLicenseNo = request.getParameter("businessLicenseNo");
		// 查询条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("classCode", classCode);
		conditionMap.put("companyName", companyName.equals("请输入需要查询的企业名") ? ""
				: companyName);
		conditionMap.put("businessLicenseNo",
				businessLicenseNo.equals("请输入组织机构代码") ? "" : businessLicenseNo);
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(conditionMap);
		// 查询信息
		List<Map<String, Object>> list_corp = corpService
				.getUserCorpToExc(adapter);
		//
		List<String> companyNameList = new ArrayList<String>();
		conditionMap.put("companyName", companyNameList);
		adapter.setQueryCondition(conditionMap);
		// 标题
		String[] titles = new String[] { "COMPANYNAME:企业名称",
				"SAFETYLICENSENO:安全生产许可证号", "SAFETYLICESEDATE:许可证有效期至",
				"ENDDATE:保险单状态", "CLASSCODE:企业类型", "STANDARDLEVEL:安全标准化等级",
				"UNITAMOUNT:责任限额(万元/人)", "SUMAMOUNT:每次事故责任限额(万元)" };
		// 内容
		List<Map<String, Object>> lists = list_corp;
		// 类型
		Class clas = Map.class;
		// sheet名
		String sheetName = "企业状况";
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}

	/**
	 * 查询评估内容
	 * 
	 * @author jjx
	 * @param response
	 * @return
	 * 
	 */
	@RequestMapping(value = "/getContent", method = RequestMethod.GET)
	public void getContent(HttpServletResponse response,
			@RequestParam(value = "userCode") String userCode) {
		try {
			List<Map<String, Object>> list = corpService.getContent(userCode);
			String result = JSON.toJSONString(list);
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(result);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 查询危险源
	 * 
	 * @author jjx
	 * @param response
	 * @param userCode
	 */
	@RequestMapping(value = "/getSource", method = RequestMethod.GET)
	public void getDanger(HttpServletResponse response,
			@RequestParam(value = "userCode") String userCode) {
		try {
			List<Map<String, Object>> source = corpService.get_Source(userCode); // 通过userCode查出
			response.setCharacterEncoding("utf-8"); // 字符编码
			response.setContentType("text/html;charset=UTF-8");

			String str = JSONArray.toJSONString(source);
			PrintWriter writer = response.getWriter();
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 请输入要查询的企业名
	 * 
	 * @param response
	 * @param userCorp
	 */
	@RequestMapping(value = "/getCompanyName")
	public void getCompanyName(HttpServletResponse response,
			@RequestParam String companyName) {
		try {
			List<GgUserCorp> list = corpService.getCompanyName(companyName);
			String result = JSON.toJSONString(list);
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(result);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * qiye企业信息
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/initData", method = RequestMethod.GET)
	public ModelAndView initData(GgUserCorp ggUserCorp) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 查询企业信息
		ggUserCorp = corpService.getData(ggUser.getUserCode());
		if (ggUserCorp == null) {
			/**行业大类*/
			GgCode code = new GgCode();
			code.setCodeType("IndustryCategories");
			List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
			/**企业规模*/
			code = new GgCode();
			code.setCodeType("EnterpriseScale");
			List<GgCode> list_classSize = ggCodeService.getGgCodeByObj(code);// 4
			// 安全标准化等级
			GgCode code1 = new GgCode();
//			String standardLevel = ggUserCorp.getStandardLevel();
			code1.setCodeType("StandardLevel");
			List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);

			// 企业风险状况
			code = new GgCode();
			code.setCodeType("riskLevel");
			List<GgCode> list_riskLevel = ggCodeService.getGgCodeByObj(code);
			
			mad.addObject("list_classCode",
					list_classCode == null ? new ArrayList<GgCode>()
							: list_classCode);
			mad.addObject("list_safe", list_safe == null ? new ArrayList<GgCode>()
					: list_safe);
			mad.addObject("list_classSize",
					list_classSize == null ? new ArrayList<GgCode>()
							: list_classSize);
			mad.addObject("list_riskLevel",
					list_riskLevel == null ? new ArrayList<GgCode>()
							: list_riskLevel);
			mad.addObject("ggUser", ggUser == null ? new GgUser()
			: ggUser);
			mad.setViewName("/enterprise/info/mainInfo");
			return mad;
		}
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		map.put("userCode", null);
		map.put("userCode", ggUser.getUserCode());

		GgCode code = new GgCode();

		String Pro = ggUser.getProvince();
		code.setCodeType("Province");
		code.setCodeCode(Pro);
		List<GgCode> list_pro = ggCodeService.getGgCodeByObj(code);

		String cit = ggUser.getCity();
		code.setCodeType("City");
		code.setCodeCode(cit);
		List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);

		String county = ggUser.getCounty();
		code.setCodeType("County");
		code.setCodeCode(county);
		List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);
		// 获取行业大类
		code = new GgCode();
		String classCode = ggUserCorp.getClassCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
		// 获取经营范围
		code.setCodeType("IndustryType");
		code.setRemark(classCode);
		List<GgCode> list_businessClass = ggCodeService.getGgCodeByObj(code);// 20
		// 安全标准化等级
		GgCode code1 = new GgCode();
		String standardLevel = ggUserCorp.getStandardLevel();
		code1.setCodeType("StandardLevel");
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);

		// 企业规模
		code = new GgCode();
		code.setCodeType("EnterpriseScale");
		List<GgCode> list_classSize = ggCodeService.getGgCodeByObj(code);
		// 企业风险状况
		code = new GgCode();
		code.setCodeType("riskLevel");
		List<GgCode> list_riskLevel = ggCodeService.getGgCodeByObj(code);

		mad.addObject("ggusercorp", ggUserCorp == null ? new GgUserCorp()
				: ggUserCorp);
		mad.addObject("list_pro", list_pro == null ? new ArrayList<GgCode>()
				: list_pro);
		mad.addObject("list_city", list_city == null ? new ArrayList<GgCode>()
				: list_city);
		mad.addObject("list_county",
				list_county == null ? new ArrayList<GgCode>() : list_county);
		mad.addObject("list_classCode",
				list_classCode == null ? new ArrayList<GgCode>()
						: list_classCode);
		mad.addObject("list_businessClass",
				list_businessClass == null ? new ArrayList<GgCode>()
						: list_businessClass);
		mad.addObject("list_safe", list_safe == null ? new ArrayList<GgCode>()
				: list_safe);
		mad.addObject("list_classSize",
				list_classSize == null ? new ArrayList<GgCode>()
						: list_classSize);
		mad.addObject("list_riskLevel",
				list_riskLevel == null ? new ArrayList<GgCode>()
						: list_riskLevel);
		mad.setViewName("/enterprise/info/mainInfo");
		return mad;
	}

	/**
	 * qiye更新企业信息
	 * 
	 * @param ggusercorp
	 * @return
	 */
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public ModelAndView updateInfo(HttpSession session, GgUserCorp ggusercorp,
			@RequestParam MultipartFile[] corpImages) {
		ModelAndView mad = new ModelAndView();

		try {
			if (corpImages != null && corpImages.length > 0) {
				for (int i = 0; i < corpImages.length; i++) {
					String fiString = corpImages[i].getOriginalFilename();
					if (fiString == null || "".equals(fiString)) {
						continue;
					}
					if (i == 0) {
						ggusercorp.setBusinessLicenseImage(FileUtil.uploadFile(
								corpImages[i], request));
					} else if (i == 1) {
						ggusercorp.setSafetyLicenseImage(FileUtil.uploadFile(
								corpImages[i], request));
					} else if (i == 2) {
						ggusercorp.setStandardLevelImage(FileUtil.uploadFile(
								corpImages[i], request));
					} /*else {
						ggusercorp.setTax(FileUtil.uploadFile(corpImages[i],
								request));
					}*/
				}
			}

			String businessLicenseDate = request.getParameter("bLicenseDate");
			String safetyLiceseDate = request.getParameter("sLiceseDate");
			// 格式化
			SimpleDateFormat busdate = new SimpleDateFormat("yyyy-MM-dd");
			Date busDate = busdate.parse(businessLicenseDate);
			Date safeDate = busdate.parse(safetyLiceseDate);

			ggusercorp.setBusinessLicenseDate(busDate);
			ggusercorp.setSafetyLiceseDate(safeDate);
			ggusercorp.setValidStatus("1");
			GgUserCorp tempUser = corpService.selectByPrimaryKey(ggusercorp.getUserCode());
			if(tempUser!=null){
				corpService.updateUserCorp(ggusercorp);
				
				// 更新GgUser表中相关字段
				GgUser ggUser = new GgUser();
				ggUser.setUserCode(ggusercorp.getUserCode());
				ggUser.setProvince(ggusercorp.getProvince());
				ggUser.setCity(ggusercorp.getCity());
				ggUser.setCounty(ggusercorp.getCounty());
				ggUser.setLinkName(ggusercorp.getLinkName());
				ggUser.setAddress(ggusercorp.getCompanyAddress());
				ggUser.setTelePhone(ggusercorp.getTelephone());
				ggUser.setMobile(ggusercorp.getMobile());
				ggUser.setUserName(ggusercorp.getCompanyName());
				userService.updateUser(ggUser);
				session.setAttribute("ggUser", ggUser);
				return  initData(new GgUserCorp());
			}else{
				corpService.insertUserCorp(ggusercorp);

				// 更新GgUser表中相关字段
				GgUser ggUser = new GgUser();
				ggUser.setUserCode(ggusercorp.getUserCode());
				ggUser.setProvince(ggusercorp.getProvince());
				ggUser.setCity(ggusercorp.getCity());
				ggUser.setCounty(ggusercorp.getCounty());
				ggUser.setLinkName(ggusercorp.getLinkName());
				ggUser.setAddress(ggusercorp.getCompanyAddress());
				ggUser.setTelePhone(ggusercorp.getTelephone());
				ggUser.setMobile(ggusercorp.getMobile());
				ggUser.setUserName(ggusercorp.getCompanyName());
				userService.updateUser(ggUser);
				session.setAttribute("ggUser", ggUser);

				Pagination pagination = new Pagination();
				GgNotice notice = new GgNotice();
				// 获取登录对象
				Date enddate = MainService.getDate(ggUser.getUserCode());
				Integer integerCount = ggemployeeService.getNum(ggUser.getUserCode());
				pagination.setQueryCondition(ggUser.getUserCode());
				List<Map<String, Object>> list = ggNoticeService.noticeList(pagination);

				GgUserCorp ggUserCorp = corpService.selectByPrimaryKey(ggUser
						.getUserCode());
				String corpStatus = "1";
				if (ggUserCorp == null || ggUserCorp.equals("")) {
					corpStatus = "0";
				}
				// 显示未读信息
				notice.setMarkRead("0");
				notice.setRecipient(ggUser.getUserCode());
				Integer notices = ggNoticeService.getCountByNotice(notice);
				// 原本
				pagination
						.setResultList((list == null || list.size() < 0) ? new ArrayList<Map<String, Object>>()
								: list);
				mad.addObject("pagination", pagination);
				mad.addObject("Num", (integerCount == null ? 0 : integerCount));
				mad.addObject("enddate", enddate == null ? "" : enddate);
				mad.addObject("notices", notices == null ? new ArrayList<Integer>()
						: notices);
				mad.addObject("corpStatus", corpStatus);
				mad.addObject("ggUserCorpIsHave", ggUserCorp);
				session.setAttribute("notices", notices);
				if (ggUserCorp != null) {
					mad.setViewName("/enterprise/enterpriseMainPage");
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mad;
	}
	/**
	 * qiye更新刚注册的企业信息
	 * 
	 * @param ggusercorp
	 * @return
	 */
	@RequestMapping(value = "/updateRegisterInfo", method = RequestMethod.POST)
	public ModelAndView updateRegisterInfo(HttpSession session, GgUserCorp ggusercorp,
			@RequestParam MultipartFile businessLicenImg,
			@RequestParam MultipartFile safetyLicenseImg,
			@RequestParam MultipartFile standardLevelImg/*,
			@RequestParam MultipartFile turnoverExl*/) {
		ModelAndView mad = new ModelAndView();
		
		try {
			String userCode = request.getParameter("userCode");//获取登录的账号
			String companyName = request.getParameter("companyName");//企业名
			String corpration = request.getParameter("corpration");//法人
			String linkName = request.getParameter("linkName");//联系人
			String companyAddress = request.getParameter("companyAddress");//联系地址
			String mobile = request.getParameter("mobile");//
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");
			String fax = request.getParameter("fax");//传真
			String post = request.getParameter("post");//邮编
			String province = request.getParameter("province");
			String city = request.getParameter("city");
			String county = request.getParameter("county");
			String classCode = request.getParameter("classCode");//行业大类
			String businessClass = request.getParameter("businessClass");//经营范围
			String classSize = request.getParameter("classSize");//企业规模
			String businessLicenseNo = request.getParameter("businessLicenseNo");//营业执照号
			String businessLicenImgPath = FileUtil.uploadFile(businessLicenImg, request);//保存businessLicenImg营业执照图片
			String businessLicenseDate = request.getParameter("bLicenseDate");//营业执照有效期
			String safetyLicenseNo = request.getParameter("safetyLicenseNo");//安全生产许可证号
			String safetyLicenseImgPath = FileUtil.uploadFile(safetyLicenseImg, request);//保存safetyLicenseImg安全生产许可证图片
			String safetyLiceseDate = request.getParameter("sLiceseDate");//安全生产许可证有效期
			String standardLevel = request.getParameter("standardLevel");//安全标准化等级
			String standardLevelImgPath = FileUtil.uploadFile(standardLevelImg, request);//保存standardLevelImg安全标准化等级证书
//			String riskLevel = request.getParameter("");//风险状况
//			String turnover = request.getParameter("turnover");//上年度营业额
//			String turnoverExlPath = FileUtil.uploadFile(turnoverExl, request);//保存turnoverExl税务报表
			
			// 格式化两个日期格式
			SimpleDateFormat busdate = new SimpleDateFormat("yyyy-MM-dd");
			Date busDate = busdate.parse(businessLicenseDate);
			if(!"".equals(safetyLiceseDate)){
				Date safeDate = busdate.parse(safetyLiceseDate);
				ggusercorp.setSafetyLiceseDate(safeDate);
			}else{
				ggusercorp.setSafetyLiceseDate(new Date());
			}
			//格式化营业额为integer
//			Integer newTurnover = null;
//			if (turnover != null && !"".equals(turnover)) {
//				newTurnover= Integer.valueOf(turnover);
//			}
			/**放入参数到对像中*/
			ggusercorp.setUserCode(userCode);
			ggusercorp.setCompanyName(companyName);
			ggusercorp.setCorpration(corpration);
			ggusercorp.setLinkName(linkName);
			ggusercorp.setCompanyAddress(companyAddress);
			ggusercorp.setMobile(mobile);
			ggusercorp.setTelephone(telephone);
			ggusercorp.setEmail(email);
			ggusercorp.setFax(fax);
			ggusercorp.setPost(post);
			ggusercorp.setProvince(province);
			ggusercorp.setCity(city);
			ggusercorp.setCounty(county);
			ggusercorp.setClassCode(classCode);
			ggusercorp.setBusinessClass(businessClass);
			ggusercorp.setClassSize(classSize);
			ggusercorp.setBusinessLicenseNo(businessLicenseNo);
			ggusercorp.setBusinessLicenseImage(businessLicenImgPath);
			ggusercorp.setBusinessLicenseDate(busDate);
			ggusercorp.setSafetyLicenseNo(safetyLicenseNo);
			ggusercorp.setSafetyLicenseImage(safetyLicenseImgPath);
			ggusercorp.setStandardLevel(standardLevel);
			ggusercorp.setStandardLevelImage(standardLevelImgPath);
			ggusercorp.setRiskLevel("0");
//			ggusercorp.setTurnover(newTurnover);
//			ggusercorp.setTax(turnoverExlPath);
			ggusercorp.setValidStatus("1");
			
			GgUserCorp userCorp = corpService.selectByBusinessLicenseNo(businessLicenseNo);
			if(null == userCorp) {
				corpService.insertUserCorp(ggusercorp);//根据"社会统一信用代码"查库里是否有公司信息,没有直接添加一条
			}else {
				/**
				 * 一.有的话,修改公司信息,主要的是把公司信息里的userCode 改成现在的用户的代码,
				 * 相当于把批量导入保单时导入的公司信息关联上现在注册的用户.
				 * 
				 * 二.同时还要把公司的"评价信息"(GGEVALUATEDANAGERS表)的userCode 修改成现在注册公司的userCode
				 */
				GgEvaluateDangers eva = new GgEvaluateDangers();
				eva.setUserCode(userCorp.getUserCode());
				List<GgEvaluateDangers> evaluateDangers = evaluateDangersService.selectiveEvaluateDangers(eva);
				if(null == evaluateDangers) {
					evaluateDangers = new ArrayList<GgEvaluateDangers>();
				}
				corpService.updateUserCode_userCorpAndEvaluateDangers(userCode, ggusercorp, evaluateDangers);
			}
			
				
				// 更新GgUser表中相关字段
				GgUser ggUser = new GgUser();
				ggUser.setUserCode(userCode);
				ggUser.setProvince(province);
				ggUser.setCity(city);
				ggUser.setCounty(county);
				ggUser.setLinkName(linkName);
				ggUser.setAddress(companyAddress);
				ggUser.setTelePhone(telephone);
				ggUser.setMobile(mobile);
				ggUser.setUserName(companyName);
				userService.updateUser(ggUser);
				
				GgUser user = userMapper.getUser(userCode);
				session.setAttribute("ggUser", user);
				
				Pagination pagination = new Pagination();
				GgNotice notice = new GgNotice();
				// 获取登录对象
				Date enddate = MainService.getDate(userCode);
				Integer integerCount = ggemployeeService.getNum(userCode);
				pagination.setQueryCondition(userCode);
				List<Map<String, Object>> list = ggNoticeService.noticeList(pagination);
				
				GgUserCorp ggUserCorp = corpService.selectByPrimaryKey(userCode);
				String corpStatus = "1";
				if (ggUserCorp == null || ggUserCorp.equals("")) {
					corpStatus = "0";
				}
				// 显示未读信息
				notice.setMarkRead("0");
				notice.setRecipient(userCode);
				Integer notices = ggNoticeService.getCountByNotice(notice);
				// 原本
				pagination.setResultList((list == null || list.size() < 0) ? new ArrayList<Map<String, Object>>() : list);
				mad.addObject("pagination", pagination);
				mad.addObject("Num", (integerCount == null ? 0 : integerCount));
				mad.addObject("enddate", enddate == null ? "" : enddate);
				mad.addObject("notices", notices == null ? new ArrayList<Integer>() : notices);
				mad.addObject("corpStatus", corpStatus);
				mad.addObject("ggUserCorpIsHave", ggUserCorp);
				session.setAttribute("notices", notices);
				mad.setViewName("/enterprise/enterpriseMainPage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mad;
	}
	

	@RequestMapping("/UsercorpContinue")
	public ModelAndView evaluateReportUsercorpContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = corpService.getUsercorpContinue(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/jianguan/enterprise/maininfo");
		return mad;
	}
	/**
	 * 根据"社会统一信用代码"判断是否已存在企业
	 * @param businessNo
	 * @param businessLicenseNoold
	 * @param writer
	 */
	@RequestMapping(value = "/checkBusinessNo")
	public void checkBusinessNo(@RequestParam String businessNo,
			@RequestParam String businessLicenseNoold, PrintWriter writer) {
		String checkStatus = "yes";
		if (businessNo.equals(businessLicenseNoold)) {
			checkStatus = "no";
		}else {
			GgUserCorp ggUserCorp = userCorpMapper.getBusinessLicenseNo(businessNo);//根据"社会统一信用代码"查出一条公司信息
			if(null != ggUserCorp) {
				String userCode = ggUserCorp.getUserCode();
				GgUser businessLicenseNo_haveUser = userService.getObject(userCode);//公司不为空,根据公司的用户代码(userCode)查一条用户信息
				if(null == businessLicenseNo_haveUser) {
					writer.write(JSON.toJSONString(ggUserCorp));//如果用户信息是空的,把已有的的公司信息传到前台
					writer.flush();
					writer.close();
					return;
				}
			}
			if (ggUserCorp == null) {
				if (businessNo.equals("")) {
					checkStatus = "isNoHave";
				}else {
					checkStatus = "no";
				}
			}
		}
		writer.write(JSON.toJSONString(checkStatus));
		writer.flush();
		writer.close();
	}
	@RequestMapping(value = "/checkSafeNo")
	public void checkSafeNo(@RequestParam String safeNo,@RequestParam String safetyLicenseNoold, PrintWriter writer) {
		String checkStatus = "yes";
		if (safetyLicenseNoold.equals(safeNo)) {
			checkStatus = "no";
		}else  {
			GgUserCorp ggUserCorp = userCorpMapper.getsafetyLicenseNo(safeNo);
			if (ggUserCorp == null) {
				if (safeNo.equals("")) {
					checkStatus = "isNoHave";
				}else {
					checkStatus = "no";
				}
			}		
		}
		writer.write(JSON.toJSONString(checkStatus));
		writer.flush();
		writer.close();
	}
	@RequestMapping(value = "/checkUserName")
	public void checkUserName(@RequestParam String userName,@RequestParam String companyNameold, PrintWriter writer) {
		String checkStatus = "yes";
		if (companyNameold.equals(userName)) {
			checkStatus = "no";
		}else {
			GgUserCorp ggusercorp = userCorpMapper.getUserName(userName);
			if (ggusercorp == null) {
				if (userName.equals("")) {
					checkStatus = "isNoHave";
				}else {
					checkStatus = "no";
				}
			}
		}
		writer.write(JSON.toJSONString(checkStatus));
		writer.flush();
		writer.close();
	}
	@RequestMapping("/forget")
	public void doRegister( @RequestBody JSONObject js,  PrintWriter out) {
        String userCode = js.getString("userCode");
        String password = js.getString("password");
        String telePhone = js.getString("telePhone");
        String ckCode = js.getString("ckCode");
		GgUser ggUser =new GgUser();
		ggUser.setUserCode(userCode);
		ggUser.setPassword(Md5Util.md5(password));
		String randomStr = (String) session.getAttribute("randomStr");
		String result = "";
		if (ckCode.equals(randomStr)) {

		  userService.updateNewUser(ggUser); 
			
			result = "success";

		}else {
			result = "codeError";
		}

		out.write(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

	@RequestMapping( value="/checkTelePhone" , consumes = "application/json", method = RequestMethod.POST )
	public void checkTelePhone(@RequestBody JSONObject js , PrintWriter out ){
		String telePhone = js.getString("telePhone");
		String userCode =  js.getString("userCode");
        GgUserCorp  ggUserCorp =corpService.checkTelePhone(telePhone);
		String checkStatus =  "";
		if (ggUserCorp != null  && userCode.equals(ggUserCorp.getUserCode())) {
			checkStatus ="yes" ;
		}else{
			checkStatus ="no";
		}
		out.write(JSON.toJSONString(checkStatus));
		out.flush();
		out.close();
	}

}
