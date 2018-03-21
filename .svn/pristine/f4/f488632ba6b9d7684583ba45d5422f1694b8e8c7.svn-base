package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgAmountRate;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyEndorse;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.PolicyManager;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.InsurePolicyService;
import com.dsib.service.QyMycheckService;
import com.dsib.service.QyMypolicyService;
import com.dsib.util.FileUtil;
import com.dsib.util.StringUtil;

@Controller
@SessionAttributes({ "pagination", "resultAddMap", "resultMap", "yearedMap", "policyManager" })
@RequestMapping("/mycheck")
public class QyMycheckController extends BaseController {

	@Resource(name = "qymychecked")
	private QyMycheckService mychecked;

	@Resource(name = "QyMyPolicy")
	private QyMypolicyService mypolicy;

	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggUserCorpService;

	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;

	/**
	 * 企业用户"我的保单"调转至此
	 * @param request
	 * @return
	 */
	@RequestMapping("/mycheckinit")
	public ModelAndView mycheckinit(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("insuredname", userCode);
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(userCode);
		conditionMap.put("identifiNo", ggUserCorp.getBusinessLicenseNo());
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = mychecked.getmypolicyInit(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/qiye/mycheck/mycheckResult");
		return mad;
	}

	@RequestMapping("/mycheckquery")
	public ModelAndView mycheckquery(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();
		String POLICYNO = request.getParameter("POLICYNO");
		String languagec = request.getParameter("languagec");
		String check = languagec.equals("") ? "" : languagec;
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("POLICYNO", POLICYNO.equals("请输入保单号") ? "" : POLICYNO);
		conditionMap.put("insuredname", userCode);
		conditionMap.put("status", check);
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(userCode);
		conditionMap.put("identifiNo", ggUserCorp.getBusinessLicenseNo());
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = mychecked.getmypolicyInit(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/qiye/mycheck/mycheckResult");
		return mad;
	}

	@RequestMapping("/mycheckinitPagin")
	public ModelAndView mycheckinitPain(@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = mychecked.getmypolicyInitPagination(pagination);
		mad.addObject(pagination);
		mad.setViewName("/qiye/mycheck/mycheckResult");
		return mad;
	}

	@RequestMapping(value = "/mychecktalk", consumes = "application/json", method = RequestMethod.POST)
	public void mychecktalk(PrintWriter printWrite) {

		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();
		String userProvince = user.getProvince();
		String userCty = user.getCity();
		String userCounty = user.getCounty();
		String serce = null;
		String policy = null;
		String textname = null;
		String business = null;
		try {

			serce = new String(request.getParameter("serce"));
			policy = new String(request.getParameter("policy"));
			textname = new String(request.getParameter("textname"));
			business = new String(request.getParameter("business")); // 用于查询保险公司条件

		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer serces = Integer.parseInt(serce.substring(0, 1));
		Integer policys = Integer.parseInt(policy.substring(0, 1));
		Map<String, Object> resultMap = mypolicy.getmypolicyshow(business); // 查询保险公司名字
		String insurercode = (String) resultMap.get("INSURERCODE");
		// 需要的条件

		String source = String.valueOf(serces + "-" + policys);
		if (serces >= 4) {
			mychecked.myserce();
		}
		if (policys >= 4) {
			mychecked.policy();
		}

		// 对类传值
		GgEvaluate ggEvaluate = new GgEvaluate();
		ggEvaluate.setSeriesNo(StringUtil.getBusinessNo());
		ggEvaluate.setScore(source); // 评价总分
		ggEvaluate.setBeEvaluator(insurercode); // 被评价人 -----保险公司
		ggEvaluate.setEvaluator(userCode); // 评价人
		ggEvaluate.setContent(textname);
		ggEvaluate.setProvince(userProvince);
		ggEvaluate.setCity(userCty);
		ggEvaluate.setCounty(userCounty);
		mychecked.mychecktalk(ggEvaluate);

	}

	@RequestMapping("/mycheckrenwal")
	// 投保单续保
	public ModelAndView mycheckrenwal(Model model) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(ggUser.getUserCode());
		GgAmountRate ggAmountRate = new GgAmountRate();
		ggAmountRate.setScale(ggUserCorp.getClassSize());
		ggAmountRate.setAmounttype("sumAmountV");
		List<GgAmountRate> ggAmountRateList = insurePolicyService.getAmountList(ggAmountRate);
		String buiness = request.getParameter("businessno");
		// 初始化续保时间
		Map<String, Object> resultMap = mypolicy.getmypolicyshow(buiness);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		Date endtime = (Date) resultMap.get("ENDDATE");
		Date sysdate = new Date(); // 获取系统时间
		Date date = null;
		String tempDate = "";
		if (endtime.after(sysdate) || endtime.equals(sysdate)) { // 上单保险结束时间在系统时间之后-----在保期间内------续保日期应为保单的结束日期
			Calendar time = Calendar.getInstance();
			time.setTime(endtime);
			time.add(Calendar.DAY_OF_MONTH, 1);
			resultMap.put("ENDDATE", time.getTime());
			tempDate = StringUtil.date2String(time.getTime());
			time.add(Calendar.YEAR, 1);
			time.add(Calendar.DAY_OF_MONTH, -1);
			resultMap.put("ENDEND", time.getTime());

		} else { // 上单保险结束时间在系统时间之前------不在保险期间内------续保日期应在当前系统时间之后
			Calendar time = Calendar.getInstance();
			time.setTime(sysdate);
			time.add(Calendar.DAY_OF_MONTH, 1);
			resultMap.put("ENDDATE", time.getTime());
			time.add(Calendar.YEAR, 1);
			time.add(Calendar.DAY_OF_MONTH, -1);
			resultMap.put("ENDEND", time.getTime());
		}
		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(buiness);
		guPolicyInsuredKey.setSeriesno(1L);
		GuPolicyInsured guPolicyInsured = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		guPolicyInsuredKey.setSeriesno(2L);
		GuPolicyInsured guPolicyInsured1 = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		request.setAttribute("inPep", guPolicyInsured);
		request.setAttribute("alPep", guPolicyInsured1);
		// 获取行业大类
		GgCode code = new GgCode();
		String classCode = guPolicyInsured1.getRemark();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
		mad.addObject("TempClassCode",guPolicyInsured1.getRemark());
		// 获取经营范围
		code.setCodeType("IndustryType");
		code.setRemark(classCode);
		List<GgCode> list_businessClass = ggCodeService.getGgCodeByObj(code);// 20
		mad.addObject("TempBusinessClass",guPolicyInsured1.getFlag());
		// 安全标准化等级
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		mad.addObject("TempStandardLevel",guPolicyInsured1.getPolicyno());
		mad.addObject("list_classCode",
				list_classCode == null ? new ArrayList<GgCode>()
						: list_classCode);
		mad.addObject("list_businessClass",
				list_businessClass == null ? new ArrayList<GgCode>()
						: list_businessClass);
		mad.addObject("list_safe", list_safe == null ? new ArrayList<GgCode>()
				: list_safe);
		request.setAttribute("tempDate", tempDate);
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(buiness);
		List<GuPolicyItemKind> guPolicyItemKinds = insurePolicyService.selectListByBusinessNo(guPolicyItemKind);
		PolicyManager policyManager = new PolicyManager();
		String sanAmount = "";
		for (int i = 0; i < guPolicyItemKinds.size(); i++) {
			GuPolicyItemKind temp = guPolicyItemKinds.get(i);
			if ("0901002".equals(temp.getKindcode()))
				policyManager.setItemOne("1");
			if ("0901002".equals(temp.getKindcode()))
				sanAmount = String.valueOf(temp.getAmount());
			if ("0901003".equals(temp.getKindcode()))
				policyManager.setItemTwo("1");
			if ("0901004".equals(temp.getKindcode()))
				policyManager.setItemThree("1");
			if ("0901005".equals(temp.getKindcode()))
				policyManager.setItemFour("1");
		}
		GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
		guPolicyEmployee.setBusinessNo(buiness);
		List<GuPolicyEmployee> ggEmployeeList = insurePolicyService.findEmployeeList(guPolicyEmployee);
		String tempPep = "";
		for (int j = 0; j < ggEmployeeList.size(); j++) {
			GuPolicyEmployee employee = ggEmployeeList.get(j);
			tempPep += employee.getPepName() + "," + employee.getPepIdentityNo() + ";";
		}
		request.setAttribute("tempPep", tempPep);
		request.setAttribute("sanAmount", sanAmount);
		request.setAttribute("policyManagerItem", policyManager);
		List<Map<String, Object>> resultAddMap = mychecked.mycheckadditional(buiness);
		Map<String, Object> yearedMap = mychecked.mycheckyeared(buiness);
		String plan = (String) yearedMap.get("PLANCODE");
		yearedMap.put("status", 2);// 1.重新提交；2续保
		yearedMap.put("businessNo", buiness);
		String[] plans;
		plans = plan.split("-");
		yearedMap.put("areaCode", plans[0]);
		yearedMap.put("insureCode", plans[1]);
		yearedMap.put("riskCode", yearedMap.get("RISKCODE"));
		mad.addObject("ggAmountRateList", ggAmountRateList);
		mad.addObject("policyManager", yearedMap);
		mad.addObject("resultAddMap", resultAddMap);// 附加险种查询
		mad.addObject("resultMap", resultMap);// 主险种和时间的查询
		mad.setViewName("/qiye/mycheck/mycheckRenwal");
		return mad;

	}

	@RequestMapping("/mycheckToExcel")
	public void getmycheckToExcel(ConditionAdapter adapter, HttpServletRequest request, HttpServletResponse response) {
		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();
		String POLICYNO = request.getParameter("POLICYNO");
		String languagec = request.getParameter("languagec");
		String check = languagec.equals("") ? "" : languagec;
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("POLICYNO", POLICYNO.equals("请输入保单号") ? "" : POLICYNO);
		conditionMap.put("insuredname", userCode);
		conditionMap.put("status", check);
		adapter.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = mychecked.getmycheckExcel(adapter);
		Iterator iterator = resultList.iterator();
		while (iterator.hasNext()) {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, Object> resultMap = (Map<String, Object>) iterator.next();
			String stat = String.valueOf(resultMap.get("STATUS"));
			if (stat.equals("1")) {
				resultMap.put("STATUS", "有效");
			} else {
				resultMap.put("STATUS", "无效");
			}
			resultMap.put("STARTDATE", sim.format(resultMap.get("STARTDATE")));
			resultMap.put("ENDDATE", sim.format(resultMap.get("ENDDATE")));
		}
		// 标题
		String[] titles = new String[] { "POLICYNO:保单号", "INSUREDNAME:被保险人", "STARTDATE:起保日期", "ENDDATE:终保日期", "SUMAMOUNT:保险金额(万元)",
				"SPREADSHEETPREMIUM:总保费(元)", "INSURERCODE:保险公司", "STATUS:状态" };
		List<Map<String, Object>> lists = resultList;
		Class cla = Map.class;
		String sheetName = "我的保单";
		FileUtil.exportToExcel(titles, lists, cla, sheetName, response);
	}

	@RequestMapping(value = "/mycheckshowTalk", consumes = "application/json", method = RequestMethod.GET)
	public void mycheckshowTalk() {
		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();
		String business = request.getParameter("business");
		Map<String, Object> resultMap = mypolicy.getmypolicyshow(business); // 查询保险公司名字
		String insurercode = (String) resultMap.get("INSURERCODE");
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("EVALUATOR", userCode);
		condition.put("BEEVALUATOR", insurercode);
		List<Map<String, Object>> count = mychecked.talkcount(/*insurercode,*/userCode);
		Iterator it = count.iterator();
		double pointcounty = 0;
		double sercecount = 0;
		double policycounty = 0;
		while (it.hasNext()) {
			Map<String, Object> countMap = (Map<String, Object>) it.next();
			int point = Integer.parseInt(String.valueOf(countMap.get("SERIESNO")));
			pointcounty += point;
			String str = String.valueOf(countMap.get("SCORE"));
			String[] qiege = str.split("-");
			sercecount += Double.parseDouble(String.valueOf(qiege[0]));
			policycounty += Double.parseDouble(String.valueOf(qiege[1]));
		}
		List<Map<String, Object>> resultList = mychecked.historytalk(condition);
		Iterator iterator = resultList.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> ite = (Map<String, Object>) iterator.next();

			String str = String.valueOf(ite.get("SCORE"));
			String[] qiege = str.split("-");
			if (qiege.length >= 2) {
				ite.put("serce", qiege[0]);
				ite.put("policy", qiege[1]);
			}
		}
		double dou = 0;
		DecimalFormat df = new DecimalFormat("#.00");
		if (pointcounty != 0) {
			dou = (sercecount + policycounty) / (pointcounty);

		}
		Map<String, Object> counentry = new HashMap<String, Object>();
		counentry.put("pointcounty", pointcounty);
		counentry.put("dou", df.format(dou));
		resultList.add(counentry);
		PrintWriter print = null;
		try {
			response.setCharacterEncoding("UTF-8");
			print = response.getWriter();
			print.write(JSONArray.toJSONString(resultList));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			print.flush();
			print.close();
		}

	}
	/***
	 * 点击“我的保单”页面的评价按钮，跳转的方法
	 * @author HSLT
	 * @param insurerCode
	 * @return
	 */
	@RequestMapping(value="/mycheckShowUp",produces = "application/*;chartset=utf-8")
	public ModelAndView mycheckShowUp(String insurerCode) {
		//先根据保险公司代码查询出“我”给这个保险公司是否有过评价
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String userCode = ggUser.getUserCode();
		GgEvaluate ggevaluate = new GgEvaluate();
		ggevaluate.setBeEvaluator(insurerCode);
		ggevaluate.setItem("1");
		List<GgEvaluate> list_ggevaluate = mychecked.selectInsuredCode(ggevaluate);
		int sumSize = 0;//初始化条数
		String sumCount = "0";//初始化综合评分
		if (list_ggevaluate.size()>0 ) {
			String fuwu = "";//初始化一个“服务态度”评价等级
			String jisong = "";//初始化一个“保单寄送”评价等级
			double sumfuwu = 0.00;
			double sumjisong = 0.00;
			for (int i = 0; i < list_ggevaluate.size(); i++) {
				String[] split = list_ggevaluate.get(i).getScore().split("-");
				if(split.length>1){
					fuwu = split[0];
					jisong = split[1];
					list_ggevaluate.get(i).setRemark(fuwu);
					list_ggevaluate.get(i).setFlag(jisong);
					sumfuwu += Double.parseDouble(fuwu);
					sumjisong += Double.parseDouble(jisong);
				}else{
					fuwu = split[0];
					list_ggevaluate.get(i).setRemark(fuwu);
					sumfuwu += Double.parseDouble(fuwu);
				}
			}
			DecimalFormat format = new DecimalFormat("#.00");
//			sumCount = format.format((sumfuwu+sumjisong)/(list_ggevaluate.size()*2));//评分
			sumCount = format.format((sumfuwu+sumjisong)/(list_ggevaluate.size()));//评分
			sumSize = list_ggevaluate.size();//条数
		}
		mad.addObject("sumSize", sumSize);//综合评价条数
		mad.addObject("sumCount", sumCount);//综合评价评分
		mad.addObject("BeEvaluator", insurerCode);//保险公司代码
		mad.addObject("list_ggevaluate", list_ggevaluate);//
		mad.setViewName("/qiye/mycheck/mycheckShowUp");
		return mad;
	}
	
	@RequestMapping(value = "/mycheckSumbitUp", method = RequestMethod.POST)
	public void mycheckSumbitUp(PrintWriter printWrite,@RequestBody GgEvaluate ggEvaluate) {

		String remark = ggEvaluate.getRemark();
//		String flag = ggEvaluate.getFlag();
		String content = ggEvaluate.getContent();
		String beEvaluator = ggEvaluate.getBeEvaluator();
		
		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();
		String userProvince = user.getProvince();
		String userCty = user.getCity();
		String userCounty = user.getCounty();
		
		GgEvaluate ggevaluate = new GgEvaluate();
		ggevaluate.setEvaluator(userCode);
		ggevaluate.setBeEvaluator(beEvaluator);
		ggevaluate.setItem("1");
		List<GgEvaluate> list_ggevaluate = mychecked.selectInsuredCode(ggevaluate);
		
		String returnString = "";
		if (list_ggevaluate.size() > 0) {
			returnString = "isHavePingjia";//已经评价过该保险公司
		}else {
				//把服务和效率的字段拼接成一个字段存入
//				String source = String.valueOf(remark + "-" + flag);
				String source = String.valueOf(remark);
				ggEvaluate.setSeriesNo(StringUtil.getBusinessNo());
				ggEvaluate.setBeEvaluator(beEvaluator); // 被评价人 -----保险公司
				ggEvaluate.setItem("1");
				ggEvaluate.setContent(content);
				ggEvaluate.setScore(source); // 评价总分
				ggEvaluate.setEvaluator(userCode); // 评价人
				ggEvaluate.setEvaluateTime(new Date());
				ggEvaluate.setAttributeId("1");
				ggEvaluate.setProvince(userProvince);
				ggEvaluate.setCity(userCty);
				ggEvaluate.setCounty(userCounty);
				mychecked.myCheckTalkInsert(ggEvaluate);
				
				returnString = "success";
		}
		printWrite.write(returnString);
	}
	
	@RequestMapping(value="/mycheckApply", consumes = "application/json;chartset=utf-8", method=RequestMethod.POST)
	public void mycheckApply(@RequestBody JSONObject js){
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String content = js.getString("content");
		String businessno = js.getString("businessno");
		String startDate = js.getString("startDate");
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date today = new Date();
		Map<String,Object> condition = new HashMap<String, Object>();
		condition.put("specialprovisions", content);
		condition.put("business", businessno);
		condition.put("starDate",date);
		
		GuPolicyEndorse guPolicyEndorse = new GuPolicyEndorse();
		guPolicyEndorse.setBuseiness(businessno);
		guPolicyEndorse.setUpdatedate(today);
		guPolicyEndorse.setSpecialprovisions(content);
		guPolicyEndorse.setInsuredcode(ggUser.getUserCode());
		guPolicyEndorse.setEndorsedate(date);
		guPolicyEndorse.setPayflag("1");
		guPolicyEndorse.setFlag("0");
		guPolicyEndorse.setOperator(ggUser.getUserCode());
		mychecked.sperialPro(condition,guPolicyEndorse);
		try {
			PrintWriter pw = response.getWriter();
			pw.write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}