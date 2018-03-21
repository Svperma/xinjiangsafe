package com.dsib.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dsib.common.Pagination;
import com.dsib.dao.GgKindMapper;
import com.dsib.entity.GgAmountRate;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyMain;
import com.dsib.entity.PolicyManager;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.InsurePolicyService;
import com.dsib.service.QyMypolicyService;
import com.dsib.util.StringUtil;

@Controller
@SessionAttributes({ "pagination", "resultMap", "resultList", "result" })
@RequestMapping("/mypolicy")
public class QyMypolicyMainController extends BaseController {

	@Resource(name = "QyMyPolicy")
	private QyMypolicyService qymypolicy;

	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggUserCorpService;

	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;

	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	
	@Resource
	private GgKindMapper ggKindMapper;
	
	@RequestMapping("/mypolicyinit")
	public ModelAndView mypolicyinit() {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String user = ggUser.getUserCode();
		Pagination pagination = new Pagination();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("user", user);
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(user);
		conditionMap.put("identifiNo", ggUserCorp.getBusinessLicenseNo());
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = qymypolicy
				.getqymypolicy(pagination);
		pagination.setResultList(resultList);
		session.removeAttribute("his");
		mad.addObject(pagination);
		mad.setViewName("/qiye/mypolicy/mypolicyResult");
		return mad;
	}

	@RequestMapping("/mypolicyquery")
	public ModelAndView mypolicquery(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String user = ggUser.getUserCode();
		String insuredcode = request.getParameter("insuredcode");
		String languagec = request.getParameter("languagec");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("insuredcode", insuredcode.equals("请输入被保险人") ? ""
				: insuredcode);
		conditionMap.put("languagec", languagec);
		conditionMap.put("user", user);
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(user);
		conditionMap.put("identifiNo", ggUserCorp.getBusinessLicenseNo());
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = qymypolicy
				.getqymypolicy(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/qiye/mypolicy/mypolicyResult");
		return mad;
	}

	/**
	 * 投保单查看
	 * @param request
	 * @return
	 */
	@RequestMapping("/mypolicyshow")
	//投保单查看
	public ModelAndView mypolicyshow(HttpServletRequest request) {
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
		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(businessno);
		guPolicyInsuredKey.setSeriesno(1L);
		GuPolicyInsured guPolicyInsured = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		guPolicyInsuredKey.setSeriesno(2L);
		GuPolicyInsured guPolicyInsured1 = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		request.setAttribute("inPep", guPolicyInsured);
		request.setAttribute("alPep", guPolicyInsured1);
		//总保费
		Object obj = resultMap.get("SPREADSHEETPREMIUM");
		double tempbapfei = Double.valueOf(obj.toString());
		String zongbaofei = new StringUtil().number2CNMontrayUnit(BigDecimal.valueOf(tempbapfei));
		request.setAttribute("zongbaofei", zongbaofei);
		request.setAttribute("zbf", tempbapfei);
		// 获取行业大类
		GgCode code = new GgCode();
		code = new GgCode();
		String classCode = guPolicyInsured1.getRemark();
		code.setCodeType("IndustryCategories");
		code.setCodeCode(guPolicyInsured1.getRemark());
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
		// 获取经营范围
		code.setCodeType("IndustryType");
		code.setRemark(classCode);
		code.setCodeCode(guPolicyInsured1.getFlag());
		List<GgCode> list_businessClass = ggCodeService.getGgCodeByObj(code);// 20
		// 安全标准化等级
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		code1.setCodeCode(guPolicyInsured1.getPolicyno());
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		request.setAttribute("TempClassCode", list_classCode.get(0).getCodeCName());
		request.setAttribute("TempBusinessClass", list_businessClass.get(0).getCodeCName());
		request.setAttribute("TempStandardLevel", list_safe.get(0).getCodeCName());
		request.setAttribute("TempSafetyLicenseNo", guPolicyInsured1.getInsuredtype());
		//是否存在批单
		Map<String,Object> resultSpecial = qymypolicy.showSpecial(businessno);
		mad.addObject("resultMap", resultMap);
		mad.addObject("special",resultSpecial);
		mad.addObject(pagination);
		request.setAttribute("businessno", businessno);
		mad.setViewName("/qiye/mypolicy/mypolicyShow");
		return mad;
	}

	@RequestMapping("/mypolicyPagin")
	public ModelAndView mypolicyPagin(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = qymypolicy.getqymypolicyPagination(pagination);
		mad.addObject(pagination);
		mad.setViewName("/qiye/mypolicy/mypolicyResult");
		return mad;
	}

	/**
	 * 企业用户投保单失败后点击"重新提交"按钮
	 * @param model
	 * @return
	 */
	@RequestMapping("/mypolicyrenwal")
	// 投保单重新提交
	public ModelAndView mypolicyrenwal(Model model) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(ggUser
				.getUserCode());
		GgAmountRate ggAmountRate = new GgAmountRate();
		ggAmountRate.setScale(ggUserCorp.getClassSize());
		ggAmountRate.setAmounttype("sumAmountV");
		List<GgAmountRate> ggAmountRateList = insurePolicyService
				.getAmountList(ggAmountRate);
		String buiness = request.getParameter("businessno");
		// 初始化续保时间
		Map<String, Object> resultMap = qymypolicy.getMypolicyNOShow(buiness);
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		Date startTime = (Date)resultMap.get("STARTDATE");
		Date sysdate = new Date(); // 获取系统时间
		
		if(startTime.before(sysdate)) {
			Calendar time = Calendar.getInstance();
			time.setTime(sysdate);
			time.add(Calendar.DATE, 1);
			resultMap.put("STARTDATE", time.getTime());
			time.add(Calendar.YEAR, 1);
			time.add(Calendar.DATE, -1);
			resultMap.put("ENDDATE", time.getTime());
		}


		//保险人被保险人信息
		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(buiness);
		guPolicyInsuredKey.setSeriesno(1L);//投保人
		GuPolicyInsured guPolicyInsured = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		guPolicyInsuredKey.setSeriesno(2L);//被保险人
		GuPolicyInsured guPolicyInsured1 = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		request.setAttribute("alPep", guPolicyInsured);
		request.setAttribute("inPep", guPolicyInsured1);
		
		
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
		
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(buiness);
		List<GuPolicyItemKind> guPolicyItemKinds = insurePolicyService
				.selectListByBusinessNo(guPolicyItemKind);
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
		List<GuPolicyEmployee> ggEmployeeList = insurePolicyService
				.findEmployeeList(guPolicyEmployee);
		String tempPep = "";
		for (int j = 0; j < ggEmployeeList.size(); j++) {
			GuPolicyEmployee employee = ggEmployeeList.get(j);
			tempPep += employee.getPepName() + ","
					+ employee.getPepIdentityNo() + ";";
		}
		request.setAttribute("tempPep", tempPep);
		request.setAttribute("sanAmount", sanAmount);
		request.setAttribute("policyManagerItem", policyManager);
		
		List<Map<String, Object>> resultAddMap = qymypolicy
				.myPolicyAdditional(buiness);
		Map<String, Object> yearedMap = qymypolicy.myPolicyyeared(buiness);
		String plan = (String) yearedMap.get("PLANCODE");
		String[] plans;
		plans = plan.split("-");
		mad.addObject("areaCode", plans[0]);
		mad.addObject("insureCode", plans[1]);
		mad.addObject("riskCode", yearedMap.get("RISKCODE"));
		mad.addObject("status", 1);// 1.重新提交；2续保
		mad.addObject("businessNo", buiness);
		
//		mad.addObject("ggAmountRateList", ggAmountRateList);
//		mad.addObject("policyManager", yearedMap);
//		mad.addObject("resultAddMap", resultAddMap);// 附加险种查询
		mad.addObject("resultMap", resultMap);// 主险种和时间的查询
		mad.setViewName("/qiye/mycheck/mycheckRenwal");
		return mad;
	}
}
