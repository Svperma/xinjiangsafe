package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.BigDecimalHolder;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dsib.common.Pagination;
import com.dsib.dao.GuPolicyEmployeeMapper;
import com.dsib.dao.GuPolicyInsuredMapper;
import com.dsib.dao.GuPolicyItemKindMapper;
import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.dao.GuWebClientMapper;
import com.dsib.entity.GgAmountRate;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;
import com.dsib.entity.GgInsuranceDetail;
import com.dsib.entity.GgInsuranceDetailKey;
import com.dsib.entity.GgInsureConfig;
import com.dsib.entity.GgKind;
import com.dsib.entity.GgKindPrice;
import com.dsib.entity.GgKindPriceKey;
import com.dsib.entity.GgPaymentConfig;
import com.dsib.entity.GgRisk;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GpMainOrder;
import com.dsib.entity.GpOrderDetail;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyFee;
import com.dsib.entity.GuPolicyInsurePremium;
import com.dsib.entity.GuPolicyInsurePremiumKey;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyItemKindKey;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;
import com.dsib.entity.PolicyManager;
import com.dsib.inter.Apply;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgInsureConfigService;
import com.dsib.service.GgPaymentConfigService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GpMainOrderService;
import com.dsib.service.GpOrderDetailService;
import com.dsib.service.GuInterfaceService;
import com.dsib.service.GuPolicyInsuredService;
import com.dsib.service.GuPolicyItemKindService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.InsurePolicyService;
import com.dsib.service.JobWebServiceClientService;
import com.dsib.service.QyMycheckService;
import com.dsib.service.QyMypolicyService;
import com.dsib.service.ToJudgeService;
import com.dsib.submitInterface.SubmitInsureUtil;
import com.dsib.submitInterface.SubmitPayment;
import com.dsib.util.BigDecimalUtils;
import com.dsib.util.DateUtils;
import com.dsib.util.JiSuanPremiumUtil;
import com.dsib.util.StringUtil;
import com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleRequest;
import com.dsib.webService.AZX.bean.common.xsd.ApplicantEhm;
import com.dsib.webService.AZX.bean.common.xsd.InsuredEhm;
import com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm;
import com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm;
import com.dsib.webService.AZX.bean.common.xsd.MainEhm;
import com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleResponse;
import com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortType;
import com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortTypeProxy;
import com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteRequest;
import com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteResponse;
import com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServicePortType;
import com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServicePortTypeProxy;

/**
 * 投保专用
 */
@Controller
@RequestMapping("/insurePolicy")
@SessionAttributes("pagination")
public class InsurerPolicyController extends BaseController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));// true:允许输入空值，false:不能为空值

	}

	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	@Resource(name = "ggInsureConfigService")
	private GgInsureConfigService ggInsureConfigService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggUserCorpService;
	@Resource(name = "QyMyPolicy")
	private QyMypolicyService qymypolicy;
	@Resource(name = "GuInterface")
	private GuInterfaceService guinter;
	@Resource(name = "tojudge")
	private ToJudgeService tojudge;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "qymychecked")
	private QyMycheckService mychecked;
	@Resource(name = "ggPaymentConfigService")
	private GgPaymentConfigService ggPaymentConfigService;
	@Resource(name = "gpMainOrderService")
	private GpMainOrderService gpMainOrderService;
	@Resource(name = "gpOrderDetailService")
	private GpOrderDetailService detailService;

	@Autowired
	private GuWebClientMapper client;

	@Autowired
	private SubmitInsureUtil submitInsure;

	@Autowired
	private SubmitPayment submitPayment;

	@Resource
	private GuPolicyMainMapper guPolicyMainMapper;

	@Autowired
	private JiSuanPremiumUtil jisuan;

	@Resource
	private GuPolicyItemKindMapper guPolicyItemKindMapper;

	@Resource
	private GuPolicyInsuredService insuredService;

	@Resource
	private GuPolicyInsuredMapper insuredMapper;

	@Resource
	private GuPolicyEmployeeMapper employeeMapper;

	@RequestMapping("/getAreaPlan")
	// 查询地区可投保的险种
	public String getAreaPlan(HttpServletRequest request, Model model) {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		List<GgRisk> ggRisks = insurePolicyService.findKind4Aera(ggUser);
		List<GgRisk> ggRiskList = new ArrayList<GgRisk>();
		if (ggRisks.size() > 0) {// 判断该地区是否有可投保险种
			GgRisk ggRisk = ggRisks.get(0);
			ggRiskList.add(ggRisk);
			for (int i = 1; i < ggRisks.size(); i++) {// 判断多险种重复
				GgRisk temp = ggRisks.get(i);
				for (int j = 0; j < ggRiskList.size(); j++) {
					if (!ggRiskList.get(j).getRiskcode()
							.equals(temp.getRiskcode())) {
						ggRiskList.add(temp);
					}
				}
			}
		}
		// model.addAttribute("ggRisks", ggRiskList);
		String Acode = ggRiskList.get(0).getAreacode();
		String Rcode = ggRiskList.get(0).getRiskcode();
		model.addAttribute("Acode", Acode);
		model.addAttribute("Rcode", Rcode);
		return "getRiskPolicy";
	}

	@RequestMapping("/getInsure")
	// 根据用户选择的险种查询可投保的保险公司
	public void getInsure(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String riskCode = obj.getString("riskCode");
		String areaCode = obj.getString("areaCode");
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setRiskCode(riskCode);
		ggInsureConfig.setAreaCode(areaCode);
		List<GgInsureConfig> ggInsureConfigs = ggInsureConfigService
				.getInsurance(ggInsureConfig);
		String insureList = "";
		insureList = JSON.toJSONString(ggInsureConfigs);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(insureList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/getInsureText")
	// 查询用户选择的保险公司详情
	public void getInsureText(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String insureCode = obj.getString("insureCode");
		String riskCode = obj.getString("riskCode");
		GgInsuranceDetailKey ggInsuranceDetailKey = new GgInsuranceDetailKey();
		ggInsuranceDetailKey.setInsurancecode(insureCode);
		ggInsuranceDetailKey.setRiskcode(riskCode);
		GgInsuranceDetail ggInsuranceDetail = insurePolicyService
				.selectByPrimaryKey(ggInsuranceDetailKey);
		List<GgInsuranceDetail> details = new ArrayList<GgInsuranceDetail>();
		details.add(ggInsuranceDetail);
		String insureTextList = "";
		insureTextList = JSON.toJSONString(details);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(insureTextList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 我同意跳转至ci
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getPoilcying")
	// 根据用户选择的保险公司进入投保页面
	public String getPoilcying(HttpServletRequest request, Model model) {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(ggUser
				.getUserCode());
		String riskCode = request.getParameter("riskCode");
		String areaCode = request.getParameter("areaCode");
		String insureCode = request.getParameter("insureCode");

		PolicyManager policyManager = new PolicyManager();
		policyManager.setRiskCode(riskCode);
		policyManager.setAreaCode(areaCode);
		policyManager.setInsureCode(insureCode);
		// policyManager.setPepSum(String.valueOf(ggUserCorp.getEmCount()));
		policyManager.setPepSum("0");
		GgAmountRate ggAmountRate = new GgAmountRate();
		ggAmountRate.setScale(ggUserCorp.getClassSize());
		ggAmountRate.setAmounttype("sumAmountV");
		List<GgAmountRate> ggAmountRateList = insurePolicyService
				.getAmountList(ggAmountRate);
		String startDate = "";
		String endDate = "";
		String tempDate = "";
		GuPolicyMain main = new GuPolicyMain();
		main.setOperatorCode(ggUser.getUserCode());
		main.setUnderWriteFlag("3");
		main.setPayFlag("1");
		List<GuPolicyMain> list = insurePolicyService.selectRenewalFlag(main);
		if (list.size() > 0) {
			Date endtime = list.get(0).getEndDate();
			Date sysdate = new Date(); // 获取系统时间
			Date date = null;
			if (endtime.after(sysdate) || endtime.equals(sysdate)) { // 上单保险结束时间在系统时间之后-----在保期间内------续保日期应为保单的结束日期
				Calendar time = Calendar.getInstance();
				time.setTime(endtime);
				time.add(Calendar.DAY_OF_MONTH, 1);
				startDate = StringUtil.date2String(time.getTime());
				tempDate = startDate;
				time.add(Calendar.YEAR, 1);
				time.add(Calendar.DAY_OF_MONTH, -1);
				endDate = StringUtil.date2String(time.getTime());
			} else { // 上单保险结束时间在系统时间之前------不在保险期间内------续保日期应在当前系统时间之后
				Calendar time = Calendar.getInstance();
				time.setTime(sysdate);
				time.add(Calendar.DAY_OF_MONTH, 1);
				startDate = StringUtil.date2String(time.getTime());
				time.add(Calendar.YEAR, 1);
				time.add(Calendar.DAY_OF_MONTH, -1);
				endDate = StringUtil.date2String(time.getTime());
			}
		} else {// 新单
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(cal.DATE, 1);
			startDate = StringUtil.date2String(cal.getTime());
			Calendar curr = Calendar.getInstance();
			curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
			date = curr.getTime();
			endDate = StringUtil.date2String(date);
		}
		String pepSums = "";
		GgEmployee ggEmployee = new GgEmployee();
		ggEmployee.setUserCode(ggUser.getUserCode());
		List<GgEmployee> ggEmployeeList = insurePolicyService
				.getGgEmployeeList(ggEmployee);
		for (int i = 0; i < ggEmployeeList.size(); i++) {
			pepSums += ggEmployeeList.get(i).getEmName() + ","
					+ ggEmployeeList.get(i).getIdentityNo() + ";";
		}
		policyManager.setPepSum(String.valueOf(ggEmployeeList.size()));
		request.setAttribute("pepSums", pepSums);
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		model.addAttribute("list_classCode",
				list_classCode == null ? new ArrayList<GgCode>()
						: list_classCode);
		model.addAttribute("list_safe",
				list_safe == null ? new ArrayList<GgCode>() : list_safe);
		model.addAttribute("ggAmountRateList", ggAmountRateList);
		model.addAttribute("policyManager", policyManager);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("tempDate", tempDate);
		model.addAttribute("ggUserCorp", ggUserCorp);
		return "getPolicying";
	}

	@RequestMapping("/getGuSon")
	// 查询保单包含员工
	public String getGuSon(HttpServletRequest request, Model model) {
		GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
		String businessno = request.getParameter("businessno");
		guPolicyEmployee.setBusinessNo(businessno);
		List<GuPolicyEmployee> ggEmployeeList = insurePolicyService
				.findEmployeeList(guPolicyEmployee);
		model.addAttribute("ggEmployeeList", ggEmployeeList);
		return "showGuPep";
	}

	@RequestMapping("/checkUser")
	// 查询企业是否已完善信息
	public void checkUser(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(ggUser
				.getUserCode());
		String result = "";
		if (ggUserCorp != null) {
			result = "1";
		}
		List<GuPolicyMain> guPolicyMains = insurePolicyService
				.checkPolicyHas(ggUser.getUserCode());
		if (guPolicyMains.size() > 0) {
			result = "2";
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(JSON.toJSONString(result));
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/getMySon")
	// 查询企业所有员工
	public String getMySon(HttpServletRequest request, Model model) {
		String busNo = "";
		try {
			busNo = java.net.URLDecoder.decode(request.getParameter("gobibi"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("------------------编码转换失败!--------------------");
		}
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgEmployee ggEmployee = new GgEmployee();
		ggEmployee.setUserCode(ggUser.getUserCode());
		List<GgEmployee> ggEmployeeList = insurePolicyService
				.getGgEmployeeList(ggEmployee);
		String[] busNos = busNo.split(";");
		if (busNos.length > 1) {
			for (int i = 0; i < busNos.length; i++) {
				String[] temp = busNos[i].split(",");
				int flag = 0;
				for (int j = 0; j < ggEmployeeList.size(); j++) {
					if (temp[1].equals(ggEmployeeList.get(j).getIdentityNo())) {
						ggEmployeeList.get(j).setValidStatus("6");
						flag = 1;
					}
				}
				if (flag == 0) {
					GgEmployee employee = new GgEmployee();
					employee.setEmName(temp[0]);
					employee.setIdentityNo(temp[1]);
					employee.setValidStatus("6");
					ggEmployeeList.add(employee);
					// flag=1;
				}
			}
		}
		model.addAttribute("ggEmployeeList", ggEmployeeList);
		return "showGPep";
	}

	@RequestMapping("/getInManager")
	// 查询保险公司详细信息
	public String getInManager(HttpServletRequest request, Model model) {
		String riskCode = request.getParameter("riskCode");
		String insurancecode = request.getParameter("insureCode");
		GgInsuranceDetailKey ggInsuranceDetailKey = new GgInsuranceDetailKey();
		ggInsuranceDetailKey.setInsurancecode(insurancecode);
		ggInsuranceDetailKey.setRiskcode(riskCode);
		GgInsuranceDetail ggInsuranceDetail = insurePolicyService
				.selectByPrimaryKey(ggInsuranceDetailKey);
		request.setAttribute("ggInsurance", ggInsuranceDetail);
		return "showInsure" + insurancecode;
	}

	@RequestMapping("/getPingJia")
	// 查询保险公司评价
	public String getPingJia(HttpServletRequest request, Model model) {
		String riskCode = request.getParameter("riskCode");
		String insurancecode = request.getParameter("insureCode");
		request.setAttribute("riskCode", riskCode);
		request.setAttribute("insurancecode", insurancecode);
		return "queryPJtj";
	}

	@RequestMapping("/getPing")
	// 查询保险公司评价
	public ModelAndView getPing(HttpServletRequest request, Model model) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String riskCode = request.getParameter("riskCode");
		String insurancecode = request.getParameter("insurancecode");
		String languagec = request.getParameter("languagec");
		conditionMap.put("insurancecode", insurancecode);
		conditionMap.put("languagec", languagec);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = insurePolicyService
				.getPingJia(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/insurePolicy/queryPingjia");
		return mad;
	}

	// 查询保险公司评价
	@RequestMapping("/getPingCo")
	public ModelAndView getPingCo(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		pagination = (Pagination) insurePolicyService.getPingJiaCC(pagination);
		mad.addObject(pagination);
		mad.setViewName("/insurePolicy/queryPingjia");
		return mad;
	}

	/**
	 * 下一步跳转至此
	 * 
	 * @param request
	 * @param policyManager
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPlaceValueBatch")
	// 根据用户选择的方案计算保费(批量计算)
	public String getPlaceValueBatch(HttpServletRequest request,
			PolicyManager policyManager, Model model) throws Exception {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(ggUser
				.getUserCode());
		String riskCode = request.getParameter("riskCode");
		String areaCode = request.getParameter("areaCode");
		// 经营类型安全标准化重新获取
		String TempClassCode = request.getParameter("classCode");
		String TempBusinessClass = request.getParameter("businessClass");
		String TempStandardLevel = request.getParameter("standardLevel");
		// 获取可投保的保险公司
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setRiskCode(riskCode);
		ggInsureConfig.setAreaCode(areaCode);
		List<GgInsureConfig> ggInsureConfigs = ggInsureConfigService
				.getInsurance(ggInsureConfig);
		List<GgInsuranceDetail> ggInsuranceDetailList = new ArrayList<GgInsuranceDetail>();
		String startDate = DateUtils.format(policyManager.getStartDate(),
				"yyyy-MM-dd");
		String endDate = DateUtils.format(policyManager.getEndDate(),
				"yyyy-MM-dd");
		Double sanamount = Double.valueOf(request.getParameter("sanamount"));
		List<GuPolicyInsurePremium> guPolicyInsurePremiumList = new ArrayList<GuPolicyInsurePremium>();
		String businessNo = new Long(new Date().getTime()).toString();
		businessNo = businessNo
				+ Long.toString(getRandom(100000000, 999999999));
		businessNo = businessNo.substring(0, 20);
		// 循环查询保险公司计算保费
		for (int son = 0; son < ggInsureConfigs.size(); son++) {

			// 获取保险公司评分
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("BEEVALUATOR", ggInsureConfigs.get(son)
					.getInsuranceCode());
			List<Map<String, Object>> count = mychecked
					.talkcount(ggInsureConfigs.get(son).getInsuranceCode());
			Iterator it = count.iterator();
			double pointcounty = 0;
			double sercecount = 0;
			double policycounty = 0;
			while (it.hasNext()) {
				Map<String, Object> countMap = (Map<String, Object>) it.next();
				int point = Integer.parseInt(String.valueOf(countMap
						.get("SERIESNO")));
				pointcounty += point;
				String str = String.valueOf(countMap.get("SCORE"));
				String[] qiege = str.split("-");
				if (qiege.length > 1) {
					sercecount += Double.parseDouble(String.valueOf(qiege[0]));
					policycounty += Double
							.parseDouble(String.valueOf(qiege[1]));
				} else {
					sercecount += Double.parseDouble(String.valueOf(qiege[0]));
				}
			}
			double dou = 0;
			DecimalFormat df = new DecimalFormat("#.00");
			if (pointcounty != 0) {
				dou = (sercecount + policycounty) / (pointcounty * 0.5);
			}
			// 获取评分结束
			GuPolicyInsurePremium guPolicyInsurePremium = new GuPolicyInsurePremium();
			guPolicyInsurePremium.setBusinessNo(businessNo);
			GgInsuranceDetailKey ggInsuranceDetailKey = new GgInsuranceDetailKey();
			ggInsuranceDetailKey.setInsurancecode(ggInsureConfigs.get(son)
					.getInsuranceCode());
			ggInsuranceDetailKey.setRiskcode(riskCode);
			GgInsuranceDetail ggInsuranceDetail = insurePolicyService
					.selectByPrimaryKey(ggInsuranceDetailKey);
			if (dou != 0.0) {
				ggInsuranceDetail.setFlag(df.format(dou));// 总评分
			} else {
				ggInsuranceDetail.setFlag("0");// 总评分
			}
			if ("1".equals(ggInsureConfigs.get(son).getFlag())) {// 人工报价
				ggInsuranceDetail.setRemark("待报价");
				ggInsuranceDetailList.add(ggInsuranceDetail);
				guPolicyInsurePremium.setValNo(String.valueOf(son));
				guPolicyInsurePremium.setInsureCode(ggInsuranceDetail
						.getInsurancecode());
				guPolicyInsurePremiumList.add(guPolicyInsurePremium);
				continue;
			}
			if ("2".equals(ggInsureConfigs.get(son).getFlag())) {// 自动直接出单
				ggInsuranceDetail.setClause("2");// 提交投保单后去缴费
			}
			if ("3".equals(ggInsureConfigs.get(son).getFlag())) {// 自动核保出结果
				ggInsuranceDetail.setClause("3");// 提交投保单后提交自动核保接口
			}
			if ("4".equals(ggInsureConfigs.get(son).getFlag())) {// 人工核保出结果
				ggInsuranceDetail.setClause("4");// 提交投保单后提交人工核保接口
			}
			// 获取险别费率
			GgKind ggKind = new GgKind();
			ggKind.setRiskcode(policyManager.getRiskCode());
			ggKind.setAreacode(policyManager.getAreaCode());
			ggKind.setKindename(TempBusinessClass);
			ggKind.setInsurancecode(ggInsuranceDetail.getInsurancecode());
			List<GgKind> ggKindList = insurePolicyService.getGgKindList(ggKind);
			// 基本保费
			GgKindPriceKey ggKindPriceKey = new GgKindPriceKey();
			ggKindPriceKey.setAreacode(policyManager.getAreaCode());
			ggKindPriceKey.setRiskcode(policyManager.getRiskCode());
			ggKindPriceKey.setInsurecode(ggInsuranceDetail.getInsurancecode());
			ggKindPriceKey.setIndustrycode(TempBusinessClass);
			ggKindPriceKey.setScalecode("0");
			GgKindPrice ggKindPrice = insurePolicyService
					.selectByPrimaryKey(ggKindPriceKey);
			BigDecimal price = ggKindPrice.getPrice();
			// 获取每人限额费率
			GgAmountRate ggAmountRate = new GgAmountRate();
			ggAmountRate.setAmount(policyManager.getAmount());
			ggAmountRate.setAmounttype("amount");
			ggAmountRate.setInsurecode(ggInsuranceDetail.getInsurancecode());
			GgAmountRate ggAmountRateTemp = insurePolicyService
					.selectByType(ggAmountRate);
			Double amountRate = Double.valueOf(ggAmountRateTemp.getRate());// 每人费率
			// 获取累计限额费率
			Double sumAmountRate = 1.00;// 累计费率
			// 安全标准化等级费率
			GgAmountRate ggAmountRate2 = new GgAmountRate();
			ggAmountRate2.setAmounttype("安全标准化等级");
			ggAmountRate2.setScale(TempStandardLevel);
			ggAmountRateTemp = insurePolicyService.selectByType(ggAmountRate2);
			Double standardLevelRate = Double.valueOf(ggAmountRateTemp
					.getRate());// 安全标准化费率
			// 短期费率
			double shortRate = 1.0;
			int dayFlag = getDaydiff(startDate, endDate);
			if ("630003".equals(ggUserCorp.getBusinessClass())) {
				double[] shortArray = { 0, 0.20, 0.30, 0.40, 0.50, 0.60, 0.70,
						0.75, 0.80, 0.85, 0.90, 0.95 };
				shortRate = Math.floor(dayFlag / 12) + shortArray[dayFlag % 12]; // 短期费率
			}
			// 企业事故率折扣
			Double lossRate = 1.00;
			// 续保折扣
			Double renewalRate = 1.00;
			// 保费计算start
			BigDecimal premium = new BigDecimal("0.00");// 主险保费
			BigDecimal sumPremium = new BigDecimal("0.00");// 总保费
			Double tempRate = amountRate * shortRate;// 主险费率 -->每人基本费率 * 短期费率
			// 计算主险保费
			price = price.multiply(BigDecimal.valueOf(tempRate)); // 未加优惠系数的基本保费-->行业基本保费
																	// * 主险费率
			double adjust = standardLevelRate * lossRate * renewalRate;
			adjust = new BigDecimal(adjust).setScale(4,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			if (adjust > 1.2)
				adjust = 1.2;// 优惠系数不能大于1.2
			if (adjust < 0.8)
				adjust = 0.8;
			premium = price.multiply(BigDecimal.valueOf(adjust)).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			sumPremium = premium.multiply(BigDecimal.valueOf(Double
					.valueOf(policyManager.getPepSum())));
			// 计算附加险保费
			double tempPremium = 0.00;
			for (int i = 0; i < ggKindList.size(); i++) {
				GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
				double tempPrice = 0.00;
				if (i == 0) {// 主险
					tempPrice = BigDecimal
							.valueOf(
									Double.valueOf(policyManager.getSumAmount()))
							.multiply(
									new BigDecimal(ggKindList.get(i)
											.getDescription()))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					tempPrice = tempPrice * adjust;
					guPolicyItemKind.setActualpremium(BigDecimal
							.valueOf(tempPrice));
					guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
							.getActualpremium());
					continue;
				}
				if ("on".equals(policyManager.getItemOne()) && i == 1) {
					tempPrice = BigDecimal
							.valueOf(Double.valueOf(sanamount))
							.multiply(
									new BigDecimal(ggKindList.get(i)
											.getDescription()))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					tempPrice = tempPrice * adjust;
					tempPrice = new BigDecimal(tempPrice).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
					guPolicyItemKind.setActualpremium(BigDecimal
							.valueOf(tempPrice));
					tempPremium += guPolicyItemKind.getActualpremium()
							.doubleValue();
					guPolicyInsurePremium.setItemkindOne(BigDecimal
							.valueOf(tempPrice));
				}
				if ("on".equals(policyManager.getItemTwo()) && i == 2) {
					tempPrice = BigDecimal
							.valueOf(
									Double.valueOf(policyManager.getSumAmount()))
							.multiply(
									new BigDecimal(ggKindList.get(i)
											.getDescription()))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					tempPrice = tempPrice * adjust * 0.3;
					tempPrice = new BigDecimal(tempPrice).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
					guPolicyItemKind.setActualpremium(BigDecimal
							.valueOf(tempPrice));
					guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
							.getActualpremium());
					tempPremium += guPolicyItemKind.getActualpremium()
							.doubleValue();
					guPolicyInsurePremium.setItemkindTwo(BigDecimal
							.valueOf(tempPrice));
				}
				if ("on".equals(policyManager.getItemThree()) && i == 3) {
					tempPrice = BigDecimal
							.valueOf(
									Double.valueOf(policyManager.getSumAmount()))
							.multiply(
									new BigDecimal(ggKindList.get(i)
											.getDescription()))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					tempPrice = tempPrice * adjust * 0.3;
					tempPrice = new BigDecimal(tempPrice).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
					guPolicyItemKind.setActualpremium(BigDecimal
							.valueOf(tempPrice));
					guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
							.getActualpremium());
					tempPremium += guPolicyItemKind.getActualpremium()
							.doubleValue();
					guPolicyInsurePremium.setItemkindThree(BigDecimal
							.valueOf(tempPrice));
				}
				if ("on".equals(policyManager.getItemFour()) && i == 4) {
					tempPrice = BigDecimal
							.valueOf(
									Double.valueOf(policyManager.getSumAmount()))
							.multiply(
									new BigDecimal(ggKindList.get(i)
											.getDescription()))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					tempPrice = tempPrice * adjust * 0.05;
					tempPrice = new BigDecimal(tempPrice).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
					guPolicyItemKind.setActualpremium(BigDecimal
							.valueOf(tempPrice));
					guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
							.getActualpremium());
					tempPremium += guPolicyItemKind.getActualpremium()
							.doubleValue();
					guPolicyInsurePremium.setItemkindFour(BigDecimal
							.valueOf(tempPrice));
				}
			}
			if (tempPremium != 0.00)
				sumPremium = sumPremium.add(BigDecimal.valueOf(tempPremium));
			sumPremium = sumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
			ggInsuranceDetail.setRemark(sumPremium.toString());
			ggInsuranceDetailList.add(ggInsuranceDetail);
			guPolicyInsurePremium.setValNo(String.valueOf(son));
			guPolicyInsurePremium.setSumPremium(sumPremium);
			guPolicyInsurePremium.setPremium(premium.multiply(BigDecimal
					.valueOf(Double.valueOf(policyManager.getPepSum()))));
			guPolicyInsurePremium.setInsureCode(ggInsuranceDetail
					.getInsurancecode());
			guPolicyInsurePremium.setFlag("1");
			guPolicyInsurePremiumList.add(guPolicyInsurePremium);
		}
		// 人工核保报价单start
		// 跟单主表传值
		GuPolicyMain guPolicyMainT = new GuPolicyMain();
		GuPolicyFee guPolicyFeeT = new GuPolicyFee();
		guPolicyMainT.setBusinessNo(businessNo);
		guPolicyMainT.setRiskCode(policyManager.getRiskCode());
		// if (renewalFlag.size() > 0) {// 上一年保单号
		// guPolicyMain.setPreviousPolicyNo(renewalFlag.get(renewalFlag.size() -
		// 1).getPolicyNo());
		// }
		guPolicyMainT.setPlanCode(policyManager.getAreaCode() + "-" + "TEMP-"
				+ policyManager.getAmount() + "-"
				+ policyManager.getSumAmount());
		guPolicyMainT.setAppliCode(ggUser.getUserCode());
		guPolicyMainT.setAppliName(ggUserCorp.getCompanyName());
		guPolicyMainT.setAppliAddress(ggUserCorp.getCompanyAddress());
		guPolicyMainT.setInsuredName(ggUserCorp.getCompanyName());
		guPolicyMainT.setInsuredAddress(ggUserCorp.getCompanyAddress());
		guPolicyMainT.setInsuredCode(ggUser.getUserCode());
		guPolicyMainT.setStartDate(policyManager.getStartDate());
		guPolicyMainT.setEndDate(policyManager.getEndDate());
		// guPolicyMainT.setCurrency("CNY");
		guPolicyMainT
				.setSumAmount(Double.valueOf(policyManager.getSumAmount()));
		guPolicyMainT.setDisCount(1.00);
		guPolicyMainT.setArgueSolution(policyManager.getToTalk());
		guPolicyMainT.setArbitBoardName(policyManager.getToTalkName());
		guPolicyMainT.setOperatorCode(ggUser.getUserCode());
		guPolicyMainT.setOperateDate(new Date());
		guPolicyMainT.setUnderWriteFlag("5");// 报价标识
		guPolicyMainT.setPayFlag("0");
		guPolicyMainT.setProvince(ggUserCorp.getProvince());
		guPolicyMainT.setCity(ggUserCorp.getCity());
		guPolicyMainT.setCounty(ggUserCorp.getCounty());
		guPolicyMainT.setUnderWriteName(ggUserCorp.getStandardLevelImage());
		// 跟单费率表传值
		GuPolicyAdjustRate guPolicyAdjustRateT = new GuPolicyAdjustRate();
		String tempVlaue = "1.00";
		guPolicyAdjustRateT.setBusinessno(businessNo);
		guPolicyAdjustRateT.setAmountadjust(tempVlaue);
		guPolicyAdjustRateT.setSumamountadjust(tempVlaue);
		guPolicyAdjustRateT.setRenewalrate(tempVlaue);
		guPolicyAdjustRateT.setShortrate(tempVlaue);
		guPolicyAdjustRateT.setLossrate(tempVlaue);
		guPolicyAdjustRateT.setStandardlevelrate(tempVlaue);
		// 跟单fee表传值
		guPolicyFeeT.setBusinessno(businessNo);
		guPolicyFeeT.setRiskcode(policyManager.getRiskCode());
		// 跟单限额表传值
		List<GuPolicyLimit> guPolicyLimitListT = new ArrayList<GuPolicyLimit>();
		GuPolicyLimit guPolicyLimitT = new GuPolicyLimit();
		guPolicyLimitT.setBusinessno(businessNo);
		guPolicyLimitT.setRiskcode(policyManager.getRiskCode());
		guPolicyLimitT.setLimitno(1L);
		guPolicyLimitT.setLimitfee(new BigDecimal(policyManager.getAmount()));
		guPolicyLimitT.setLimitcode("001");// 用该字段存限额
		guPolicyLimitT.setLimitdescription("从业人员责任限额");
		guPolicyLimitListT.add(guPolicyLimitT);
		GuPolicyLimit guPolicyLimit1T = new GuPolicyLimit();
		guPolicyLimit1T.setBusinessno(businessNo);
		guPolicyLimit1T.setRiskcode(policyManager.getRiskCode());
		guPolicyLimit1T.setLimitno(2L);
		guPolicyLimit1T.setLimitfee(new BigDecimal(policyManager.getAmount()));
		guPolicyLimit1T.setLimitcode("002");
		guPolicyLimit1T.setLimitdescription("第三者责任限额");
		guPolicyLimitListT.add(guPolicyLimit1T);
		GuPolicyLimit guPolicyLimit2T = new GuPolicyLimit();
		guPolicyLimit2T.setBusinessno(businessNo);
		guPolicyLimit2T.setRiskcode(policyManager.getRiskCode());
		guPolicyLimit2T.setLimitno(3L);
		guPolicyLimit2T.setLimitfee(new BigDecimal(Double.valueOf(policyManager
				.getSumAmount()) * 0.3));
		guPolicyLimit2T.setLimitcode("003");
		guPolicyLimit2T.setLimitdescription("救援费用责任限额");
		guPolicyLimitListT.add(guPolicyLimit2T);
		GuPolicyLimit guPolicyLimit3T = new GuPolicyLimit();
		guPolicyLimit3T.setBusinessno(businessNo);
		guPolicyLimit3T.setRiskcode(policyManager.getRiskCode());
		guPolicyLimit3T.setLimitno(4L);
		guPolicyLimit3T.setLimitfee(new BigDecimal(Double.valueOf(policyManager
				.getSumAmount()) * 0.05));
		guPolicyLimit3T.setLimitcode("004");
		guPolicyLimit3T.setLimitdescription("法律费用责任限额");
		guPolicyLimitListT.add(guPolicyLimit3T);
		List<GuPolicyInsured> guPolicyInsuredListT = new ArrayList<GuPolicyInsured>();
		GuPolicyInsured guPolicyInsuredT = new GuPolicyInsured();
		guPolicyInsuredT.setIdentitynumber(policyManager
				.getAlBusinessLicenseNo());
		guPolicyInsuredT.setEmail(policyManager.getInEmail());
		guPolicyInsuredT.setLinkname(policyManager.getInLinkName());
		guPolicyInsuredT.setPhonenumber(policyManager.getInTelePhone());
		guPolicyInsuredT.setInsuredname(policyManager.getInName());
		guPolicyInsuredT.setInsuredaddress(policyManager.getInAddress());
		guPolicyInsuredT.setInsuredcode(ggUserCorp.getUserCode());
		guPolicyInsuredT.setBusinessno(businessNo);
		guPolicyInsuredT.setRiskcode(policyManager.getRiskCode());
		guPolicyInsuredT.setInsuredflag(String.valueOf(1L));
		guPolicyInsuredT.setSeriesno(1L);
		guPolicyInsuredListT.add(guPolicyInsuredT);
		GuPolicyInsured guPolicyInsured1T = new GuPolicyInsured();
		guPolicyInsured1T.setIdentitynumber(policyManager
				.getAlBusinessLicenseNo());
		guPolicyInsured1T.setEmail(policyManager.getAlEmail());
		guPolicyInsured1T.setLinkname(policyManager.getAlLinkName());
		guPolicyInsured1T.setPhonenumber(policyManager.getAlTelePhone());
		guPolicyInsured1T.setInsuredname(policyManager.getAlName());
		guPolicyInsured1T.setInsuredaddress(policyManager.getAlAddress());
		guPolicyInsured1T.setInsuredcode(ggUserCorp.getUserCode());
		guPolicyInsured1T.setBusinessno(businessNo);
		guPolicyInsured1T.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured1T.setInsuredflag(String.valueOf(1L));
		guPolicyInsured1T.setSeriesno(2L);
		guPolicyInsured1T.setPolicyno(TempStandardLevel);
		guPolicyInsured1T.setRemark(TempClassCode);
		guPolicyInsured1T.setFlag(TempBusinessClass);
		guPolicyInsured1T.setInsuredtype(policyManager.getAlSafetyLicenseNo());
		guPolicyInsuredListT.add(guPolicyInsured1T);
		// 处理跟单人员表start
		String[] pepList = request.getParameter("pepSums").split(";");
		List<GuPolicyEmployee> guPolicyEmployeeListT = new ArrayList<GuPolicyEmployee>();
		for (int q = 0; q < pepList.length; q++) {
			GuPolicyEmployee guPolicyEmployeeT = new GuPolicyEmployee();
			String[] tempList = pepList[q].split(",");
			guPolicyEmployeeT.setBusinessNo(businessNo);
			guPolicyEmployeeT.setPepNo(String.valueOf(q));
			guPolicyEmployeeT.setPepName(tempList[0]);
			guPolicyEmployeeT.setPepIdentityNo(tempList[1]);
			guPolicyEmployeeListT.add(guPolicyEmployeeT);
		}
		guPolicyMainT.setCurrency(String.valueOf(pepList.length));// 投保人数
		// 处理跟单人员表end
		// 附加险生成逻辑
		List<GuPolicyItemKind> guPolicyItemKindListT = new ArrayList<GuPolicyItemKind>();
		GgKind ggKind = new GgKind();
		ggKind.setRiskcode(policyManager.getRiskCode());
		ggKind.setAreacode("TEMP");
		ggKind.setKindename("TEMP");
		ggKind.setInsurancecode("TEMP");
		List<GgKind> ggKindList = insurePolicyService.getGgKindList(ggKind);
		for (int i = 0; i < ggKindList.size(); i++) {
			GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
			guPolicyItemKind.setBusinessno(businessNo);
			guPolicyItemKind.setKindcode(ggKindList.get(i).getKindcode());
			guPolicyItemKind.setKindname(ggKindList.get(i).getKindcname());
			guPolicyItemKind.setStartdate(policyManager.getStartDate());
			guPolicyItemKind.setEnddate(policyManager.getEndDate());
			guPolicyItemKind.setRiskcode(policyManager.getRiskCode());
			guPolicyItemKind.setAmount(new BigDecimal(policyManager
					.getSumAmount()));
			guPolicyItemKind.setUnitamount(new BigDecimal(policyManager
					.getAmount()));
			if (i == 0) {// 主险
				guPolicyItemKindListT.add(guPolicyItemKind);
				continue;
			}
			if ("on".equals(policyManager.getItemOne()) && i == 1) {// 附加第三者为单独的限额
				guPolicyItemKind.setAmount(BigDecimal.valueOf(sanamount));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				guPolicyItemKindListT.add(guPolicyItemKind);
			}
			if ("on".equals(policyManager.getItemTwo()) && i == 2) {
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				guPolicyItemKindListT.add(guPolicyItemKind);
			}
			if ("on".equals(policyManager.getItemThree()) && i == 3) {
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				guPolicyItemKindListT.add(guPolicyItemKind);
			}
			if ("on".equals(policyManager.getItemFour()) && i == 4) {
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.05));
				guPolicyItemKindListT.add(guPolicyItemKind);
			}
		}
		session.setAttribute("guPolicyMainT", guPolicyMainT);
		session.setAttribute("guPolicyItemKindListT", guPolicyItemKindListT);
		session.setAttribute("guPolicyLimitListT", guPolicyLimitListT);
		session.setAttribute("guPolicyInsuredListT", guPolicyInsuredListT);
		session.setAttribute("guPolicyFeeT", guPolicyFeeT);
		session.setAttribute("guPolicyAdjustRateT", guPolicyAdjustRateT);
		session.setAttribute("guPolicyEmployeeListT", guPolicyEmployeeListT);
		session.setAttribute("guPolicyInsurePremiumList",
				guPolicyInsurePremiumList);
		// 人工核保报价单end
		request.setAttribute("ggInsuranceDetailList", ggInsuranceDetailList);
		startDate = DateUtils
				.format(policyManager.getStartDate(), "yyyy/MM/dd");
		endDate = DateUtils.format(policyManager.getEndDate(), "yyyy/MM/dd");
		String pepList2 = request.getParameter("pepSums");
		model.addAttribute("pepList", pepList2);
		model.addAttribute("policyManager", policyManager);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("sanamount", sanamount);
		model.addAttribute("TempClassCode", TempClassCode);
		model.addAttribute("TempBusinessClass", TempBusinessClass);
		model.addAttribute("TempStandardLevel", TempStandardLevel);
		return "showValue";
	}

	private int count = 0;

	@RequestMapping("/insertPolicyTemp")
	// 插入报价单
	public String insertPolicyTemp(HttpServletRequest request, Model model) {
		GuPolicyMain guPolicyMain = (GuPolicyMain) session
				.getAttribute("guPolicyMainT");
		GuPolicyFee guPolicyFee = (GuPolicyFee) session
				.getAttribute("guPolicyFeeT");
		GuPolicyAdjustRate guPolicyAdjustRate = (GuPolicyAdjustRate) session
				.getAttribute("guPolicyAdjustRateT");
		List<GuPolicyItemKind> guPolicyItemKindList = (List<GuPolicyItemKind>) session
				.getAttribute("guPolicyItemKindListT");
		List<GuPolicyLimit> guPolicyLimitList = (List<GuPolicyLimit>) session
				.getAttribute("guPolicyLimitListT");
		List<GuPolicyInsured> guPolicyInsuredList = (List<GuPolicyInsured>) session
				.getAttribute("guPolicyInsuredListT");
		List<GuPolicyEmployee> guPolicyEmployeeList = (List<GuPolicyEmployee>) session
				.getAttribute("guPolicyEmployeeListT");
		List<GuPolicyInsurePremium> guPolicyInsurePremiumList = (List<GuPolicyInsurePremium>) session
				.getAttribute("guPolicyInsurePremiumList");
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String judge = "";
		for (int j = 0; j < guPolicyInsurePremiumList.size(); j++) {
			if (StringUtils
					.isEmpty((guPolicyInsurePremiumList.get(j).getFlag()))) {
				ManualUnderwriteRequest inseuranceSingle = new ManualUnderwriteRequest();
				inseuranceSingle.setRequestType("12");
				inseuranceSingle.setPrimaryKey(guPolicyMain.getBusinessNo());
				MainEhm mainEhm = new MainEhm();// 投保单主信息模块
				ApplicantEhm applicantEhm = new ApplicantEhm();// 投保人模块 对象
				InsuredEhm insuredEhm = new InsuredEhm();// 被保险人模块 对象
				ItemKindEhm itemKindEhm = new ItemKindEhm();// 险别信息模块
				ItemKindEhm[] itemKindEhmArray = null;
				InsuredSubjectEhm insuredSubject = new InsuredSubjectEhm();// 标的信息模块
				InsuredSubjectEhm[] insuredSubjectArray = null;
				mainEhm.setSystemCode("AZBX");// 系统来源
				mainEhm.setPreviousPolicyNo(guPolicyMain.getPreviousPolicyNo());// 续保单时去年保单号码
				mainEhm.setStartDate(sim.format(guPolicyMain.getStartDate()));// 起保时间
				mainEhm.setEndDate(sim.format(guPolicyMain.getEndDate()));// 终保日期
				mainEhm.setArgueSolution(guPolicyMain.getArgueSolution());// 争议结局方式
				mainEhm.setArbitBoardName(guPolicyMain.getArbitBoardName());// 仲裁委员会名称
				mainEhm.setOperatorCode(guPolicyMain.getOperatorCode());// 平台操作页面
				GgUserCorp user = guinter.getUserCorp(guPolicyMain
						.getInsuredCode());// 查询被保险人信息
				mainEhm.setOperatorCompany(user.getCompanyName());// 平台操作员机构
				Date date = new Date();
				mainEhm.setOperateDate(sim.format(date));// 平台操作时间
				if (guPolicyMain.getSignDate() != null) {
					mainEhm.setSignDate(sim.format(guPolicyMain.getSignDate()));// 签单日期
				}
				mainEhm.setRenewalFlag(guPolicyMain.getRenewalFlag());// 是否续保
				mainEhm.setSumAmount(String.valueOf(guPolicyMain.getSumAmount()));// 总限额
				mainEhm.setDisCount(String.valueOf(guPolicyMain.getDisCount()));// 总折扣率
				mainEhm.setSpreadsheetPremium(String.valueOf(guPolicyMain
						.getSpreadsheetPremium()));// 试算保费
				mainEhm.setActualPremium(String.valueOf(guPolicyMain
						.getActualPremium()));// 实际保费
				mainEhm.setSpecialProvisions(guPolicyMain
						.getSpecialprovisions());// 特殊约定
				mainEhm.setInsuredNumber(String.valueOf(guPolicyEmployeeList
						.size()));// 标的人数
				mainEhm.setInsurerCode(guPolicyInsurePremiumList.get(j)
						.getInsureCode());// 保险公司代码
				// mainEhm.setInsurerCode("ZHLHCX");
				mainEhm.setProvince(guPolicyMain.getProvince()); // 省
				mainEhm.setCity(guPolicyMain.getCity()); // 市
				mainEhm.setCounty(guPolicyMain.getCounty()); // 区县
				// 投保人信息
				applicantEhm.setAppliName(user.getCompanyName());
				applicantEhm.setIdentifyNumber(user.getBusinessLicenseNo());
				applicantEhm.setCertificateno(user.getSafetyLicenseNo());
				applicantEhm.setSafetyLevel(user.getStandardLevel());
				applicantEhm.setAddressName(user.getCompanyAddress());
				applicantEhm.setLinkerName(user.getLinkName());
				applicantEhm.setPostCode(user.getPost());
				applicantEhm.setPhone(user.getTelephone());
				applicantEhm.setMobile(user.getMobile());
				applicantEhm.setEmail(user.getEmail());
				applicantEhm.setClassCode(user.getClassCode());
				applicantEhm.setBusinessClass(user.getBusinessClass());
				applicantEhm.setProvince(user.getProvince());
				applicantEhm.setCity(user.getCity());
				applicantEhm.setCounty(user.getCounty());
				applicantEhm.setScale(user.getClassSize());
				// 被保险人信息
				insuredEhm.setInsuredName(user.getCompanyName());
				insuredEhm.setIdentifyNumber(user.getBusinessLicenseNo());
				insuredEhm.setCertificateno(user.getSafetyLicenseNo());
				insuredEhm.setSafetyLevel(user.getSumstandardLevel());
				insuredEhm.setAddressName(user.getCompanyAddress());
				insuredEhm.setLinkerName(user.getLinkName());
				insuredEhm.setPostCode(user.getPost());
				insuredEhm.setPhone(user.getTelephone());
				insuredEhm.setMobile(user.getMobile());
				insuredEhm.setEmail(user.getEmail());
				insuredEhm.setClassCode(user.getClassCode());
				insuredEhm.setBusinessClass(user.getBusinessClass());
				insuredEhm.setProvince(user.getProvince());
				insuredEhm.setCity(user.getCity());
				insuredEhm.setCounty(user.getCounty());
				insuredEhm.setScale(user.getClassSize());
				// 险别信息
				itemKindEhmArray = new ItemKindEhm[guPolicyItemKindList.size()];
				for (int i = 0; i < guPolicyItemKindList.size(); i++) {
					itemKindEhm = new ItemKindEhm();
					itemKindEhm.setKindCode(guPolicyItemKindList.get(i)
							.getKindcode());
					itemKindEhm.setKindName(guPolicyItemKindList.get(i)
							.getKindname());
					itemKindEhm.setAmount(String.valueOf(guPolicyItemKindList
							.get(i).getAmount()));
					itemKindEhm.setPremium(String.valueOf(guPolicyItemKindList
							.get(i).getActualpremium()));
					itemKindEhm.setRate(String.valueOf(guPolicyItemKindList
							.get(i).getRate()));
					itemKindEhm
							.setDeductible(String.valueOf(guPolicyItemKindList
									.get(i).getDiscount()));
					itemKindEhm.setEachtimelimit(String
							.valueOf(guPolicyItemKindList.get(i).getAmount()));
					itemKindEhm.setEchLimitAmount(String
							.valueOf(guPolicyItemKindList.get(i)
									.getUnitamount()));
					itemKindEhm.setSumAmountlimit(String
							.valueOf(guPolicyItemKindList.get(i).getAmount()));
					itemKindEhmArray[i] = itemKindEhm;

				}
				// 标的人模块
				insuredSubjectArray = new InsuredSubjectEhm[guPolicyEmployeeList
						.size()];
				for (int i = 0; i < guPolicyEmployeeList.size(); i++) {
					insuredSubject = new InsuredSubjectEhm();
					insuredSubject.setInsuredObjectPerNo(String.valueOf(i));
					insuredSubject.setInsuredObjectPerName(guPolicyEmployeeList
							.get(i).getPepName());
					insuredSubject.setInsuredObjectPerIdentifyType("1");
					insuredSubject
							.setInsuredObjectPerIdentifyNumber(guPolicyEmployeeList
									.get(i).getPepIdentityNo());
					insuredSubjectArray[i] = insuredSubject;
				}
				inseuranceSingle.setApplicantEhm(applicantEhm);
				inseuranceSingle.setInsuredEhm(insuredEhm);
				inseuranceSingle.setInsuredSubjectEhmArray(insuredSubjectArray);
				inseuranceSingle.setMainEhm(mainEhm);
				inseuranceSingle.setItemKindEhmArray(itemKindEhmArray);

				AZXManualUnderwriteServicePortType sp = new AZXManualUnderwriteServicePortTypeProxy();
				ManualUnderwriteResponse service = null;
				// ManualUnderwriteResponse service = new
				// ManualUnderwriteResponse();
				try {
					service = sp.service(inseuranceSingle);
				} catch (Exception e) {
					e.printStackTrace();
				}
				judge = service.getResponseCode();
				if ("1".equals(judge)) {
					guPolicyInsurePremiumList.get(j).setFlag("2");
				}
			}
		}
		insurePolicyService.insertAll(guPolicyMain, guPolicyFee,
				guPolicyAdjustRate, guPolicyItemKindList, guPolicyLimitList,
				guPolicyInsuredList, guPolicyEmployeeList,
				guPolicyInsurePremiumList);
		return "/qiye/mypolicy/mypolicyCondition";// 跳转至我的订单
	}

	@RequestMapping("/getThisPreumin")
	// 报价单报价查询选择
	public String getThisPreumin(HttpServletRequest request, Model model) {
		String businessno = request.getParameter("businessno");
		GuPolicyInsurePremiumKey guPolicyInsurePremiumKey = new GuPolicyInsurePremiumKey();
		guPolicyInsurePremiumKey.setBusinessNo(businessno);
		List<GuPolicyInsurePremium> guPolicyInsurePremiumList = insurePolicyService
				.findInsurePremiumList(guPolicyInsurePremiumKey);
		model.addAttribute("guPolicyInsurePremiumList",
				guPolicyInsurePremiumList);
		return "showPreumin";
	}

	@RequestMapping("/getThisType")
	// 报价单确定报价
	public String getThisType(HttpServletRequest request, Model model) {
		String businessNo = request.getParameter("businessNo");
		String insureCode = request.getParameter("insureCodes");
		String valNo = request.getParameter("valNo");
		GuPolicyInsurePremiumKey key = new GuPolicyInsurePremiumKey();
		key.setBusinessNo(businessNo);
		key.setValNo(valNo);
		GuPolicyInsurePremium guPolicyInsurePremium = insurePolicyService
				.selectByPrimaryKey(key);
		GuPolicyMain guPolicyMain = insurePolicyService
				.selectByPrimaryKey3(businessNo);
		guPolicyMain.setSpreadsheetPremium(guPolicyInsurePremium
				.getSumPremium().doubleValue());
		guPolicyMain.setActualPremium(guPolicyInsurePremium.getSumPremium()
				.doubleValue());
		guPolicyMain.setInsurerCode(insureCode);
		String planCode = guPolicyMain.getPlanCode();
		planCode = planCode.replace("TEMP", insureCode);
		guPolicyMain.setPlanCode(planCode);
		guPolicyMain.setUnderWriteFlag("1");
		GuPolicyFee guPolicyFee = insurePolicyService
				.selectByPrimaryKey(businessNo);
		guPolicyFee
				.setSpreadsheetpremium(guPolicyInsurePremium.getSumPremium());
		guPolicyFee.setActualpremium(guPolicyInsurePremium.getSumPremium());
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(businessNo);
		List<GuPolicyItemKind> guPolicyItemKindlist = insurePolicyService
				.selectListByBusinessNo(guPolicyItemKind);
		for (int i = 0; i < guPolicyItemKindlist.size(); i++) {
			if ("0901001".equals(guPolicyItemKindlist.get(i).getKindcode())) {
				guPolicyItemKindlist.get(i).setActualpremium(
						guPolicyInsurePremium.getPremium());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(
						guPolicyInsurePremium.getPremium());
			}
			if ("0901002".equals(guPolicyItemKindlist.get(i).getKindcode())) {
				guPolicyItemKindlist.get(i).setActualpremium(
						guPolicyInsurePremium.getItemkindOne());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(
						guPolicyInsurePremium.getItemkindOne());
			}
			if ("0901003".equals(guPolicyItemKindlist.get(i).getKindcode())) {
				guPolicyItemKindlist.get(i).setActualpremium(
						guPolicyInsurePremium.getItemkindTwo());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(
						guPolicyInsurePremium.getItemkindTwo());
			}
			if ("0901004".equals(guPolicyItemKindlist.get(i).getKindcode())) {
				guPolicyItemKindlist.get(i).setActualpremium(
						guPolicyInsurePremium.getItemkindThree());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(
						guPolicyInsurePremium.getItemkindThree());
			}
			if ("0901005".equals(guPolicyItemKindlist.get(i).getKindcode())) {
				guPolicyItemKindlist.get(i).setActualpremium(
						guPolicyInsurePremium.getItemkindFour());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(
						guPolicyInsurePremium.getItemkindFour());
			}
		}
		insurePolicyService.updateTempBean(guPolicyMain, guPolicyFee,
				guPolicyItemKindlist);
		return "showSuccess";
	}

	/**
	 * 确认投保跳至此
	 * 
	 * @param request
	 * @param policyManager
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPlaceValue")
	// 根据用户选择的方案计算保费
	public String getPlaceValue(HttpServletRequest request,
			PolicyManager policyManager, Model model) throws Exception {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(ggUser
				.getUserCode());
		String status = request.getParameter("status");// 1.重新提交保单 ;2.续保
		// 生成业务号
		String businessNo = StringUtil.getBusinessNo();
		// 经营类型安全标准化重新获取
		String TempClassCode = request.getParameter("TempClassCode");
		String TempBusinessClass = request.getParameter("TempBusinessClass");
		String TempStandardLevel = request.getParameter("TempStandardLevel");
		if (!"".equals(status) && status != null) {
			TempClassCode = request.getParameter("classCode");
			TempBusinessClass = request.getParameter("businessClass");
			TempStandardLevel = request.getParameter("standardLevel");
		}
		// 获取险别费率
		GgKind ggKind = new GgKind();
		ggKind.setRiskcode(policyManager.getRiskCode());
		ggKind.setAreacode(policyManager.getAreaCode());
		ggKind.setKindename(TempBusinessClass);
		ggKind.setInsurancecode(policyManager.getInsureCode());
		List<GgKind> ggKindList = insurePolicyService.getGgKindList(ggKind);

		// 获取每人限额费率
		GgAmountRate ggAmountRate = new GgAmountRate();
		ggAmountRate.setAmount(policyManager.getAmount());
		ggAmountRate.setAmounttype("amount");
		ggAmountRate.setInsurecode(policyManager.getInsureCode());
		GgAmountRate ggAmountRateTemp = insurePolicyService
				.selectByType(ggAmountRate);
		Double amountRate = Double.valueOf(ggAmountRateTemp.getRate());// 每人费率
		// 获取累计限额费率
		Double sumAmountRate = 1.00;// 累计费率
		// 安全标准化等级费率
		GgAmountRate ggAmountRate2 = new GgAmountRate();
		ggAmountRate2.setAmounttype("安全标准化等级");
		ggAmountRate2.setScale(TempStandardLevel);
		ggAmountRateTemp = insurePolicyService.selectByType(ggAmountRate2);
		Double standardLevelRate = Double.valueOf(ggAmountRateTemp.getRate());// 安全标准化费率
	
		//安全等级费率
		double adjust = jisuan.getAdjust(TempStandardLevel);

		BigDecimal sumMainPremium = jisuan.getSumMainPremium2(policyManager);
		// 计算附加险保费
		List<GuPolicyItemKind> guPolicyItemKindList = new ArrayList<GuPolicyItemKind>();
		double tempPremium = 0.00;
		Double sanamount = Double.valueOf(policyManager.getSanamount());
		for (int i = 0; i < ggKindList.size(); i++) {
			GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
			guPolicyItemKind.setBusinessno(businessNo);
			guPolicyItemKind.setKindcode(ggKindList.get(i).getKindcode());
			guPolicyItemKind.setKindname(ggKindList.get(i).getKindcname());
			Date startDate = DateUtils.formatStartDate(policyManager.getStartDate());
			guPolicyItemKind.setStartdate(startDate);
			Date endDate = DateUtils.formatEndDate(policyManager.getEndDate());
			guPolicyItemKind.setEnddate(endDate);
			guPolicyItemKind.setRiskcode(policyManager.getRiskCode());
			guPolicyItemKind.setAmount(new BigDecimal(policyManager
					.getSumAmount()));
			guPolicyItemKind.setUnitamount(new BigDecimal(policyManager
					.getAmount()));
			if (i == 0) {// 主险

				guPolicyItemKind.setActualpremium(sumMainPremium);
				guPolicyItemKind.setSpreadsheetpremium(sumMainPremium);
				double mainSumRate = jisuan.getMainSumRate(policyManager);
				guPolicyItemKind.setRate(BigDecimal.valueOf(mainSumRate));
				guPolicyItemKindList.add(guPolicyItemKind);
				continue;
			}
			if ("on".equals(policyManager.getItemOne()) && i == 1) {
				BigDecimal sanZhePremium = jisuan.getSanZhePremium2(sanamount,
						adjust, ggKindList.get(i));
				guPolicyItemKind.setActualpremium(sanZhePremium);
				guPolicyItemKind.setSpreadsheetpremium(sanZhePremium);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(sanamount));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				double sanZheRate = jisuan.getSanZheRate(adjust,
						ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(sanZheRate));
				guPolicyItemKind.setRemark("500");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium()
						.doubleValue();
				policyManager.setItemOne(sanZhePremium.toString());
			}
			if ("on".equals(policyManager.getItemTwo()) && i == 2) {
				BigDecimal yiLiaoPremium = jisuan
						.getYiLiaoPremium2(policyManager.getSumAmount(),
								adjust, ggKindList.get(i));
				guPolicyItemKind.setActualpremium(yiLiaoPremium);
				guPolicyItemKind.setSpreadsheetpremium(yiLiaoPremium);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getSumAmount()) * 0.3));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				double yiLiaoRate = jisuan.getYiLiaoRate(adjust,
						ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(yiLiaoRate));
				guPolicyItemKind.setRemark("500");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium()
						.doubleValue();
				policyManager.setItemTwo(yiLiaoPremium.toString());
			}
			if ("on".equals(policyManager.getItemThree()) && i == 3) {
				double jiuYuanPremium = jisuan
						.getJiuYuanPremium(policyManager.getSumAmount(),
								adjust, ggKindList.get(i));
				BigDecimal jiuYuanPremium2 = BigDecimal.valueOf(jiuYuanPremium);
				guPolicyItemKind.setActualpremium(jiuYuanPremium2);
				guPolicyItemKind.setSpreadsheetpremium(jiuYuanPremium2);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getSumAmount()) * 0.3));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				double jiuYuanRate = jisuan.getJiuYuanRate(adjust,
						ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(jiuYuanRate));
				guPolicyItemKind.setRemark("2000");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium()
						.doubleValue();
				policyManager.setItemThree(jiuYuanPremium2.toString());
			}
			if ("on".equals(policyManager.getItemFour()) && i == 4) {
				BigDecimal faLvPremium = jisuan
						.getFaLvPremium2(policyManager.getSumAmount(), adjust,
								ggKindList.get(i));
				guPolicyItemKind.setActualpremium(faLvPremium);
				guPolicyItemKind.setSpreadsheetpremium(faLvPremium);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getSumAmount()) * 0.05));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.05));
				double faLvRate = jisuan.getFaLvRate(adjust, ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(faLvRate));
				guPolicyItemKind.setRemark("500");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium()
						.doubleValue();
				policyManager.setItemFour(faLvPremium.toString());
			}
		}
		BigDecimal sumPremium = sumMainPremium.add(BigDecimal.valueOf(tempPremium));//总保费
		sumPremium = sumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);

		BigDecimal accidentPreventFee = sumPremium.multiply(BigDecimal.valueOf(0.1));//事故预防费 保费* 0.1
		policyManager.setPr(sumMainPremium.toString());
		policyManager.setSumPr(StringUtil.number2CNMontrayUnit(sumPremium));
		// 保费计算end
		// 跟单主表传值
		GuPolicyMain guPolicyMain = new GuPolicyMain();
		guPolicyMain.setBusinessNo(businessNo);
		guPolicyMain.setRiskCode(policyManager.getRiskCode());
		// if (renewalFlag.size() > 0) {// 上一年保单号
		// guPolicyMain.setPreviousPolicyNo(renewalFlag.get(renewalFlag.size() -
		// 1).getPolicyNo());
		// }
		guPolicyMain.setPlanCode(policyManager.getAreaCode() + "-"
				+ policyManager.getInsureCode() + "-"
				+ policyManager.getAmount() + "-"
				+ policyManager.getSumAmount());
		guPolicyMain.setAppliCode(ggUser.getUserCode());
		guPolicyMain.setAppliName(ggUserCorp.getCompanyName());
		guPolicyMain.setAppliAddress(ggUserCorp.getCompanyAddress());
		guPolicyMain.setInsuredName(ggUserCorp.getCompanyName());
		guPolicyMain.setInsuredAddress(ggUserCorp.getCompanyAddress());
		guPolicyMain.setInsuredCode(ggUserCorp.getUserCode());
		guPolicyMain.setStartDate(DateUtils.formatStartDate(policyManager
				.getStartDate()));
		guPolicyMain.setEndDate(DateUtils.formatEndDate(policyManager
				.getEndDate()));
		guPolicyMain.setCurrency("CNY");
		guPolicyMain.setSumAmount(Double.valueOf(policyManager.getSumAmount()));
		guPolicyMain.setDisCount(adjust);
		guPolicyMain.setSpreadsheetPremium(sumPremium.doubleValue());
		guPolicyMain.setActualPremium(sumPremium.doubleValue());
		guPolicyMain.setArgueSolution(policyManager.getToTalk());
		guPolicyMain.setArbitBoardName(policyManager.getToTalkName());
		guPolicyMain.setOperatorCode(ggUser.getUserCode());
		guPolicyMain.setOperateDate(new Date());
		guPolicyMain.setUnderWriteFlag("1");
		guPolicyMain.setPayFlag("0");
		guPolicyMain.setInsurerCode(policyManager.getInsureCode());
		guPolicyMain.setProvince(ggUserCorp.getProvince());
		guPolicyMain.setCity(ggUserCorp.getCity());
		guPolicyMain.setCounty(ggUserCorp.getCounty());
		guPolicyMain.setAccidentPreventFee(accidentPreventFee);
		guPolicyMain.setUnderWriteName(ggUserCorp.getStandardLevelImage());
		guPolicyMain.setSignDate(new Date());
		// 跟单费率表传值
		GuPolicyAdjustRate guPolicyAdjustRate = new GuPolicyAdjustRate();
		guPolicyAdjustRate.setBusinessno(businessNo);
		guPolicyAdjustRate.setAmountadjust(amountRate.toString());
		guPolicyAdjustRate.setSumamountadjust(String.valueOf(sumAmountRate));
		// 续保折扣
		Double renewalRate = 1.00;
		guPolicyAdjustRate.setRenewalrate(String.valueOf(renewalRate));
		// 短期费率
		double shortRate = jisuan.getShortRate(policyManager.getStartDate(),
				policyManager.getEndDate());
		guPolicyAdjustRate.setShortrate(String.valueOf(shortRate));
		// 企业事故率折扣
		Double lossRate = 1.00;
		guPolicyAdjustRate.setLossrate(String.valueOf(lossRate));
		guPolicyAdjustRate.setStandardlevelrate(String
				.valueOf(standardLevelRate));
		// 跟单fee表传值
		GuPolicyFee guPolicyFee = new GuPolicyFee();
		guPolicyFee.setBusinessno(businessNo);
		guPolicyFee.setRiskcode(policyManager.getRiskCode());
		guPolicyFee.setActualpremium(sumMainPremium);
		guPolicyFee.setSpreadsheetpremium(sumMainPremium);
		// 跟单限额表传值
		List<GuPolicyLimit> guPolicyLimitList = new ArrayList<GuPolicyLimit>();
		GuPolicyLimit guPolicyLimit = new GuPolicyLimit();
		guPolicyLimit.setBusinessno(businessNo);
		guPolicyLimit.setRiskcode(policyManager.getRiskCode());
		guPolicyLimit.setLimitno(1L);
		guPolicyLimit.setLimitfee(new BigDecimal(policyManager.getAmount()));
		guPolicyLimit.setLimitcode("001");// 用该字段存限额
		guPolicyLimit.setLimitdescription("从业人员责任限额");
		guPolicyLimitList.add(guPolicyLimit);
		GuPolicyLimit guPolicyLimit1 = new GuPolicyLimit();
		guPolicyLimit1.setBusinessno(businessNo);
		guPolicyLimit1.setRiskcode(policyManager.getRiskCode());
		guPolicyLimit1.setLimitno(2L);
		guPolicyLimit1.setLimitfee(new BigDecimal(policyManager.getAmount()));
		guPolicyLimit1.setLimitcode("002");
		guPolicyLimit1.setLimitdescription("第三者责任限额");
		guPolicyLimitList.add(guPolicyLimit1);
		GuPolicyLimit guPolicyLimit2 = new GuPolicyLimit();
		guPolicyLimit2.setBusinessno(businessNo);
		guPolicyLimit2.setRiskcode(policyManager.getRiskCode());
		guPolicyLimit2.setLimitno(3L);
		guPolicyLimit2.setLimitfee(new BigDecimal(Double.valueOf(policyManager
				.getSumAmount()) * 0.3));
		guPolicyLimit2.setLimitcode("003");
		guPolicyLimit2.setLimitdescription("救援费用责任限额");
		guPolicyLimitList.add(guPolicyLimit2);
		GuPolicyLimit guPolicyLimit3 = new GuPolicyLimit();
		guPolicyLimit3.setBusinessno(businessNo);
		guPolicyLimit3.setRiskcode(policyManager.getRiskCode());
		guPolicyLimit3.setLimitno(4L);
		guPolicyLimit3.setLimitfee(new BigDecimal(Double.valueOf(policyManager
				.getSumAmount()) * 0.05));
		guPolicyLimit3.setLimitcode("004");
		guPolicyLimit3.setLimitdescription("法律费用责任限额");
		guPolicyLimitList.add(guPolicyLimit3);

		List<GuPolicyInsured> guPolicyInsuredList = new ArrayList<GuPolicyInsured>();

		GuPolicyInsured guPolicyInsured1 = new GuPolicyInsured();
		guPolicyInsured1.setIdentitynumber(policyManager
				.getAlBusinessLicenseNo());
		guPolicyInsured1.setEmail(policyManager.getAlEmail());
		guPolicyInsured1.setLinkname(policyManager.getAlLinkName());
		guPolicyInsured1.setPhonenumber(policyManager.getAlTelePhone());
		guPolicyInsured1.setInsuredname(policyManager.getAlName());
		guPolicyInsured1.setInsuredaddress(policyManager.getAlAddress());
		guPolicyInsured1.setInsuredcode(ggUserCorp.getUserCode());
		guPolicyInsured1.setBusinessno(businessNo);
		guPolicyInsured1.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured1.setInsuredflag(String.valueOf(1L));
		guPolicyInsured1.setSeriesno(1L);
		guPolicyInsured1.setPolicyno(TempStandardLevel);
		guPolicyInsured1.setRemark(TempClassCode);
		guPolicyInsured1.setFlag(TempBusinessClass);
		guPolicyInsured1.setInsuredtype(policyManager.getAlSafetyLicenseNo());
		guPolicyInsuredList.add(guPolicyInsured1);

		GuPolicyInsured guPolicyInsured2 = new GuPolicyInsured();
		guPolicyInsured2.setIdentitynumber(policyManager
				.getInBusinessLicenseNo());
		guPolicyInsured2.setEmail(policyManager.getInEmail());
		guPolicyInsured2.setLinkname(policyManager.getInLinkName());
		guPolicyInsured2.setPhonenumber(policyManager.getInTelePhone());
		guPolicyInsured2.setInsuredname(policyManager.getInName());
		guPolicyInsured2.setInsuredaddress(policyManager.getInAddress());
		guPolicyInsured2.setInsuredcode(ggUserCorp.getUserCode());
		guPolicyInsured2.setBusinessno(businessNo);
		guPolicyInsured2.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured2.setInsuredflag(String.valueOf(1L));
		guPolicyInsured2.setSeriesno(2L);
		guPolicyInsured2.setPolicyno(policyManager.getStandardLevel());
		guPolicyInsured2.setRemark(policyManager.getClassCode());
		guPolicyInsured2.setFlag(policyManager.getBusinessClass());
		guPolicyInsured2.setInsuredtype(policyManager.getInSafetyLicenseNo());
		guPolicyInsuredList.add(guPolicyInsured2);

		if (policyManager.getItemOne() == null
				|| "".equals(policyManager.getItemOne()))
			policyManager.setItemOne("未投保");
		if (policyManager.getItemTwo() == null
				|| "".equals(policyManager.getItemTwo()))
			policyManager.setItemTwo("未投保");
		if (policyManager.getItemThree() == null
				|| "".equals(policyManager.getItemThree()))
			policyManager.setItemThree("未投保");
		if (policyManager.getItemFour() == null
				|| "".equals(policyManager.getItemFour()))
			policyManager.setItemFour("未投保");
		// 处理跟单人员表start
		String[] pepList = request.getParameter("pepSums").split(";");
		List<GuPolicyEmployee> guPolicyEmployeeList = new ArrayList<GuPolicyEmployee>();
		for (int q = 0; q < pepList.length; q++) {
			GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
			String[] tempList = pepList[q].split(",");
			guPolicyEmployee.setBusinessNo(businessNo);
			guPolicyEmployee.setPepNo(String.valueOf(q));
			guPolicyEmployee.setPepName(tempList[0]);
			guPolicyEmployee.setPepIdentityNo(tempList[1]);
			guPolicyEmployeeList.add(guPolicyEmployee);
		}
		guPolicyMain.setCurrency(String.valueOf(pepList.length));
		// 处理跟单人员表end
		String sumamount = policyManager.getSumAmount();
		request.setAttribute("sumamount", sumamount);
		Map<String, Object> policy = new HashMap<String, Object>();
		session.setAttribute("guPolicyMain", guPolicyMain);
		session.setAttribute("guPolicyItemKindList", guPolicyItemKindList);
		session.setAttribute("guPolicyLimitList", guPolicyLimitList);
		session.setAttribute("guPolicyInsuredList", guPolicyInsuredList);
		session.setAttribute("guPolicyFee", guPolicyFee);
		session.setAttribute("guPolicyAdjustRate", guPolicyAdjustRate);
		session.setAttribute("guPolicyEmployeeList", guPolicyEmployeeList);
		policy.put("businessNO", businessNo);
		policy.put("status", status);
		model.addAttribute("businessNO", businessNo);
		model.addAttribute("status", status);
		model.addAttribute("policyManager", policyManager);
		String startDate = DateUtils.format(policyManager.getStartDate(),
				"yyyy年MM月dd");
		String endDate = DateUtils.format(policyManager.getEndDate(),
				"yyyy年MM月dd");
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("sanamount", sanamount / 10000);
		model.addAttribute("policy", policy);
		model.addAttribute("zbf", sumMainPremium);
		// 获取行业大类
		GgCode code = new GgCode();
		code = new GgCode();
		String classCode = TempClassCode;
		code.setCodeType("IndustryCategories");
		code.setCodeCode(TempClassCode);
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
		// 获取经营范围
		code.setCodeType("IndustryType");
		code.setRemark(classCode);
		code.setCodeCode(TempBusinessClass);
		List<GgCode> list_businessClass = ggCodeService.getGgCodeByObj(code);// 20
		// 安全标准化等级
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		code1.setCodeCode(TempStandardLevel);
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		model.addAttribute("TempClassCode", list_classCode.get(0)
				.getCodeCName());
		model.addAttribute("TempBusinessClass", list_businessClass.get(0)
				.getCodeCName());
		model.addAttribute("TempStandardLevel", list_safe.get(0).getCodeCName());
		// String paymentFlag = request.getParameter("paymentFlag");
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setInsuranceCode(policyManager.getInsureCode());
		String paymentFlag = ggInsureConfigService.getInsurance(ggInsureConfig)
				.get(0).getFlag();
		model.addAttribute("paymentFlag", paymentFlag);
		return "showPolicyByInsure";
	}

	/**
	 * 企业用户重新提交保单后修改资料,需要重新更改数据库以及重新计算保费
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping("/resubmitAfterUpdateForm")
	public String resubmitAfterUpdateForm(PolicyManager policyManager)
			throws Exception {
		String businessno = request.getParameter("businessNOee");
		GuPolicyMain policyMain = guPolicyMainMapper
				.selectByPrimaryKey(businessno);// 需要从原policyMain中取一些数据
		/** 重新计算保费 **/
		double adjust = jisuan.getAdjust(policyManager.getStandardLevel());// 优惠系数
		// 获取险别及费率
		GgKind ggKindKey = new GgKind();
		ggKindKey.setRiskcode(policyManager.getRiskCode());
		ggKindKey.setAreacode(policyManager.getAreaCode());
		ggKindKey.setKindename(policyManager.getBusinessClass());
		ggKindKey.setInsurancecode(policyManager.getInsureCode());
		List<GgKind> kindList = insurePolicyService.getGgKindList(ggKindKey);
		// 把查出来的险别及费率转换成map,GgKind的kindCode(险别代码)作为key.
		Map<String, GgKind> kindMap = new HashMap<String, GgKind>();
		for (GgKind kind : kindList) {
			kindMap.put(kind.getKindcode(), kind);
		}
		// 删除险别跟单表(GuPolicyItemKind)中所有业务号(businessNo)的跟单信息
		GuPolicyItemKindKey delItemKindKey = new GuPolicyItemKindKey();
		delItemKindKey.setBusinessno(businessno);
		guPolicyItemKindMapper.deleteByPrimaryKey(delItemKindKey);
		// 用户选择的险别(代码)封装到set集合中
		Set<String> selectItemKindSet = new HashSet<String>();
		selectItemKindSet.add("0901001");
		selectItemKindSet.add(policyManager.getItemOne());
		selectItemKindSet.add(policyManager.getItemTwo());
		selectItemKindSet.add(policyManager.getItemThree());
		selectItemKindSet.add(policyManager.getItemFour());
		selectItemKindSet.remove(null);
		// 统计总保费
		Double sumPremium = 0.00;
		// 添加险别
		for (String selectItemKindCode : selectItemKindSet) {
			if ("0901001".equals(selectItemKindCode)) {
				// 主险保费
				policyManager.setProvince(policyMain.getProvince());
				policyManager.setCity(policyMain.getCity());
				policyManager.setCounty(policyMain.getCounty());
				Double sumMainPremium = jisuan.getSumMainPremium(policyManager);
				// 主险险别信息
				GgKind mainKind = kindMap.get(selectItemKindCode);
				// 组织主险的bean
				GuPolicyItemKind mainItemKindBean = organicMainKindBean(
						policyManager, businessno, sumMainPremium, mainKind);
				// 添加入库
				guPolicyItemKindMapper.insertSelective(mainItemKindBean);
				// 把主险保费加到总保费
				sumPremium += sumMainPremium;
			}
			if ("0901002".equals(selectItemKindCode)) {
				// 计算三者保费
				double sanZhePremium = jisuan.getSanZhePremium(
						Double.valueOf(policyManager.getSanamount()), adjust,
						kindMap.get(selectItemKindCode));
				// 三者险别信息
				GgKind sanZheKind = kindMap.get(selectItemKindCode);
				// 组织三者险别bean
				GuPolicyItemKind sanZheItemKindBean = organicSanZheItemKindBean(
						policyManager, businessno, sanZhePremium, sanZheKind);
				// 添加入库
				guPolicyItemKindMapper.insertSelective(sanZheItemKindBean);
				// 把三者加到统计总保费上
				sumPremium += sanZhePremium;
			}
			if ("0901003".equals(selectItemKindCode)) {
				// 计算医疗保费
				double yiLiaoPremium = jisuan.getYiLiaoPremium(
						policyManager.getSumAmount(), adjust,
						kindMap.get(selectItemKindCode));
				// 医疗险别信息
				GgKind yiLiaoKind = kindMap.get(selectItemKindCode);
				// 组织医疗bean
				GuPolicyItemKind yiLiaoItemKindBean = organicYiLiaoBean(
						policyManager, businessno, yiLiaoPremium, yiLiaoKind);
				// 添加入库
				guPolicyItemKindMapper.insertSelective(yiLiaoItemKindBean);
				// 把医疗加到统计总保费上
				sumPremium += yiLiaoPremium;
			}
			if ("0901004".equals(selectItemKindCode)) {
				// 计算救援保费
				double jiuYuanPremium = jisuan.getJiuYuanPremium(
						policyManager.getSumAmount(), adjust,
						kindMap.get(selectItemKindCode));
				// 救援险别信息
				GgKind jiuYuanKind = kindMap.get(selectItemKindCode);
				// 组织救援bean
				GuPolicyItemKind jiuYuanItemKindBean = organicYiLiaoBean(
						policyManager, businessno, jiuYuanPremium, jiuYuanKind);
				// 添加入库
				guPolicyItemKindMapper.insertSelective(jiuYuanItemKindBean);
				// 把救援加到统计总保费上
				sumPremium += jiuYuanPremium;
			}
			if ("0901005".equals(selectItemKindCode)) {
				// 计算法律保费
				double faLvPremium = jisuan.getFaLvPremium(
						policyManager.getSumAmount(), adjust,
						kindMap.get(selectItemKindCode));
				// 法律险别信息
				GgKind faLvKind = kindMap.get(selectItemKindCode);// 法律险别
				// 组织法律bean
				GuPolicyItemKind faLvItemKindBean = organicFaLvItemKindBean(
						policyManager, businessno, faLvPremium, faLvKind);
				// 添加入库
				guPolicyItemKindMapper.insertSelective(faLvItemKindBean);
				// 把法律加到统计总保费上
				sumPremium += faLvPremium;
			}
		}
		// 在修改跟单主信息的总保额总保费信息
		policyMain.setAppliName(policyManager.getAlName());
		policyMain.setAppliAddress(policyManager.getAlAddress());
		policyMain.setInsuredName(policyManager.getInName());
		policyMain.setInsuredAddress(policyManager.getInAddress());
		policyMain.setStartDate(DateUtils.formatStartDate(policyManager
				.getStartDate()));
		policyMain.setEndDate(DateUtils.formatEndDate(policyManager
				.getEndDate()));
		policyMain.setSumAmount(Double.valueOf(policyManager.getSumAmount()));
		policyMain.setDisCount(adjust);
		policyMain.setSpreadsheetPremium(sumPremium);
		policyMain.setActualPremium(sumPremium);
		policyMain.setArgueSolution(policyManager.getToTalk());
		policyMain.setArbitBoardName(policyManager.getToTalkName());
		guPolicyMainMapper.updateByPrimaryKeySelective(policyMain);

		// 更改关系人的信息
		GuPolicyInsuredKey key = new GuPolicyInsuredKey();
		key.setBusinessno(businessno);
		key.setSeriesno(1L);// 投保人
		GuPolicyInsured alInsured = insuredMapper.selectByPrimaryKey(key);
		key.setSeriesno(2L);// 被保险人
		GuPolicyInsured inInsured = insuredMapper.selectByPrimaryKey(key);

		alInsured.setInsuredname(policyManager.getAlName());
		alInsured.setInsuredaddress(policyManager.getAlAddress());
		alInsured.setLinkname(policyManager.getAlLinkName());
		alInsured.setPhonenumber(policyManager.getAlTelePhone());
		alInsured.setEmail(policyManager.getAlEmail());
		insuredMapper.updateByPrimaryKeySelective(alInsured);// 修改投保人信息

		inInsured.setPolicyno(policyManager.getStandardLevel());
		inInsured.setInsuredname(policyManager.getInName());
		inInsured.setEmail(policyManager.getInEmail());
		inInsured.setPhonenumber(policyManager.getInTelePhone());
		inInsured.setLinkname(policyManager.getInLinkName());
		inInsured.setInsuredaddress(policyManager.getInAddress());
		inInsured.setRemark(policyManager.getClassCode());// 存行业大类
		inInsured.setFlag(policyManager.getBusinessClass());// 被保人经营范围(行业小类)
		inInsured.setIdentitynumber(policyManager.getInBusinessLicenseNo());
		inInsured.setInsuredtype(policyManager.getInSafetyLicenseNo());
		inInsured.setPolicyno(policyManager.getStandardLevel());// 存被保人安全等级
		insuredMapper.updateByPrimaryKeySelective(inInsured);

		return "redirect:/insurePolicy/checkPolicy?businessNo=" + businessno;
	}

	/**
	 * 组织法律itemKindbean,用于持久化到数据库
	 * 
	 * @param policyManager
	 * @param businessno
	 * @param faLvPremium
	 * @param faLvKind
	 * @return
	 */
	private GuPolicyItemKind organicFaLvItemKindBean(
			PolicyManager policyManager, String businessno, double faLvPremium,
			GgKind faLvKind) {
		GuPolicyItemKind guPolicyItemKindTemp = new GuPolicyItemKind();
		guPolicyItemKindTemp.setBusinessno(businessno);// 放入通用的业务号
		guPolicyItemKindTemp.setRiskcode(policyManager.getRiskCode());// 放入通用的险种代码
		guPolicyItemKindTemp.setStartdate(policyManager.getStartDate());// 开始日期
		guPolicyItemKindTemp.setEnddate(policyManager.getEndDate());// 结束日期
		guPolicyItemKindTemp.setKindcode(faLvKind.getKindcode());// 放入法律的险别代码
		guPolicyItemKindTemp.setKindname(faLvKind.getKindcname());// 放入法律的险别的中文名称
		guPolicyItemKindTemp.setSpreadsheetpremium(BigDecimal
				.valueOf(faLvPremium));// 放入计算好的法律险保费
		guPolicyItemKindTemp.setActualpremium(BigDecimal.valueOf(faLvPremium));// 放入实际保费
		guPolicyItemKindTemp.setAmount(BigDecimalUtils.valueOf(
				policyManager.getSanamount())
				.multiply(BigDecimal.valueOf(0.05)));// 法律险总保额为主险5%
		guPolicyItemKindTemp.setUnitamount(BigDecimalUtils.valueOf(
				policyManager.getAmount()).multiply(BigDecimal.valueOf(0.05)));// 法律险每人保额为主险5%
		return guPolicyItemKindTemp;
	}

	/**
	 * 组织三者的itemkindBean,用于持久化到数据库
	 * 
	 * @param policyManager
	 * @param businessno
	 * @param sanZhePremium
	 * @param sanZheKind
	 * @return
	 */
	private GuPolicyItemKind organicSanZheItemKindBean(
			PolicyManager policyManager, String businessno,
			double sanZhePremium, GgKind sanZheKind) {
		GuPolicyItemKind guPolicyItemKindTemp = new GuPolicyItemKind();
		guPolicyItemKindTemp.setBusinessno(businessno);// 放入通用的业务号
		guPolicyItemKindTemp.setRiskcode(policyManager.getRiskCode());// 放入通用的险种代码
		guPolicyItemKindTemp.setStartdate(policyManager.getStartDate());// 开始日期
		guPolicyItemKindTemp.setEnddate(policyManager.getEndDate());// 结束日期
		guPolicyItemKindTemp.setKindcode(sanZheKind.getKindcode());// 放入三者的险别代码
		guPolicyItemKindTemp.setKindname(sanZheKind.getKindcname());// 放入三者的险别的中文名称
		guPolicyItemKindTemp.setSpreadsheetpremium(BigDecimal
				.valueOf(sanZhePremium));// 放入计算好的三者险保费
		guPolicyItemKindTemp
				.setActualpremium(BigDecimal.valueOf(sanZhePremium));// 放入实际保费
		guPolicyItemKindTemp.setAmount(BigDecimalUtils.valueOf(policyManager
				.getSanamount()));// 三者险总保额
		guPolicyItemKindTemp.setUnitamount(BigDecimalUtils
				.valueOf(policyManager.getAmount()));// 三者险每人保额与主险一致
		return guPolicyItemKindTemp;
	}

	/**
	 * 组织主险的itemkindBean,用于持久化到数据库
	 * 
	 * @param policyManager
	 * @param businessno
	 * @param sumMainPremium
	 * @param mainKind
	 * @return
	 */
	private GuPolicyItemKind organicMainKindBean(PolicyManager policyManager,
			String businessno, Double sumMainPremium, GgKind mainKind) {
		GuPolicyItemKind guPolicyItemKindTemp = new GuPolicyItemKind();
		guPolicyItemKindTemp.setBusinessno(businessno);// 放入通用的业务号
		guPolicyItemKindTemp.setRiskcode(policyManager.getRiskCode());// 放入通用的险种代码
		guPolicyItemKindTemp.setStartdate(policyManager.getStartDate());// 开始日期
		guPolicyItemKindTemp.setEnddate(policyManager.getEndDate());// 结束日期
		guPolicyItemKindTemp.setKindcode(mainKind.getKindcode());// 放入主险的险别代码
		guPolicyItemKindTemp.setKindname(mainKind.getKindcname());// 放入主险的险别的中文名称
		guPolicyItemKindTemp.setSpreadsheetpremium(BigDecimal
				.valueOf(sumMainPremium));// 放入计算好的主险保费
		guPolicyItemKindTemp.setActualpremium(BigDecimal
				.valueOf(sumMainPremium));// 放入实际保费
		guPolicyItemKindTemp.setAmount(BigDecimalUtils.valueOf(policyManager
				.getSumAmount()));// 主险总保额
		guPolicyItemKindTemp.setUnitamount(BigDecimalUtils
				.valueOf(policyManager.getAmount()));// 主险每人保额
		return guPolicyItemKindTemp;
	}

	/**
	 * 组织医疗的javabean用于持久化到数据库,救援的组织方法和医疗的一样.(没有其他问题前先用这一个组织方法)
	 * 
	 * @param policyManager
	 * @param businessno
	 * @param yiLiaoPremium
	 * @param yiLiaoOrJiuYuanKind
	 * @return
	 */
	private GuPolicyItemKind organicYiLiaoBean(PolicyManager policyManager,
			String businessno, double yiLiaoOrJiuYuanPremium,
			GgKind yiLiaoOrJiuYuanKind) {

		GuPolicyItemKind guPolicyItemKindTemp = new GuPolicyItemKind();
		guPolicyItemKindTemp.setBusinessno(businessno);// 放入通用的业务号
		guPolicyItemKindTemp.setRiskcode(policyManager.getRiskCode());// 放入通用的险种代码
		guPolicyItemKindTemp.setStartdate(policyManager.getStartDate());// 开始日期
		guPolicyItemKindTemp.setEnddate(policyManager.getEndDate());// 结束日期
		guPolicyItemKindTemp.setKindcode(yiLiaoOrJiuYuanKind.getKindcode());// 放入医疗的险别代码
		guPolicyItemKindTemp.setKindname(yiLiaoOrJiuYuanKind.getKindcname());// 放入医疗的险别的中文名称
		guPolicyItemKindTemp.setSpreadsheetpremium(BigDecimal
				.valueOf(yiLiaoOrJiuYuanPremium));// 放入计算好的医疗险保费
		guPolicyItemKindTemp.setActualpremium(BigDecimal
				.valueOf(yiLiaoOrJiuYuanPremium));// 放入实际保费
		guPolicyItemKindTemp
				.setAmount(BigDecimalUtils
						.valueOf(policyManager.getSanamount()).multiply(
								BigDecimal.valueOf(0.3)));// 医疗险总保额为主险30%
		guPolicyItemKindTemp.setUnitamount(BigDecimalUtils.valueOf(
				policyManager.getAmount()).multiply(BigDecimal.valueOf(0.3)));// 医疗险每人保额为主险30%

		return guPolicyItemKindTemp;
	}

	@RequestMapping("/checkPolicy")
	public ModelAndView checkPolicy(String businessNo) {

		ModelAndView mad = new ModelAndView();

		GuPolicyInsuredKey insuredKey = new GuPolicyInsuredKey();
		insuredKey.setBusinessno(businessNo);
		insuredKey.setSeriesno(1L);
		// 投保人
		GuPolicyInsured alInsured = insuredMapper
				.selectByPrimaryKey(insuredKey);
		// 被保险人
		insuredKey.setSeriesno(2L);
		GuPolicyInsured inInsured = insuredMapper
				.selectByPrimaryKey(insuredKey);
		// 员工信息
		GuPolicyEmployee policyEmployee = new GuPolicyEmployee();
		policyEmployee.setBusinessNo(businessNo);
		List<GuPolicyEmployee> employeeList = employeeMapper
				.findEmployeeList(policyEmployee);
		// 投保的险种
		GuPolicyItemKind policyItemKind = new GuPolicyItemKind();
		policyItemKind.setBusinessno(businessNo);
		List<GuPolicyItemKind> itemKindList = guPolicyItemKindMapper
				.selectListByBusinessNo(policyItemKind);
		for (GuPolicyItemKind itemKind : itemKindList) {
			mad.addObject("itemKind" + itemKind.getKindcode(), itemKind);
		}
		// 跟单主信息
		GuPolicyMain policyMain = guPolicyMainMapper
				.selectByPrimaryKey(businessNo);
		String spreadsheetPremium = StringUtil.number2CNMontrayUnit(BigDecimal
				.valueOf(policyMain.getSpreadsheetPremium()));

		mad.addObject("spreadsheetPremium", spreadsheetPremium);
		mad.addObject("policyMain", policyMain);
		mad.addObject("employeeList", employeeList);
		mad.addObject("alInsured", alInsured);
		mad.addObject("inInsured", inInsured);
		mad.setViewName("showPolicy");
		return mad;
	}

	/**
	 * 企业用户重新提交保单的时候的最后一步"提交保单"
	 * 
	 * @return
	 */
	@RequestMapping("/resubmitPolicy")
	public String resubmitPolicy(String businessNO, String insureCode) {
		/**
		 * paymentFlag是gginsuranceDetail里的CLAUSE,作用:1是自动核保出单需要跳转"缴费",
		 * 无则是需要提交审核出结果,然后在发送出单请求.
		 */
		GgInsureConfig configKey = new GgInsureConfig();
		configKey.setInsuranceCode(insureCode);
		String paymentFlag = ggInsureConfigService.getInsurance(configKey)
				.get(0).getFlag();

		GuPolicyMain guPolicyMain = guPolicyMainMapper
				.selectByPrimaryKey(businessNO);// main

		GuPolicyItemKind guPolicyItemKindKey = new GuPolicyItemKind();
		guPolicyItemKindKey.setBusinessno(businessNO);
		List<GuPolicyItemKind> guPolicyItemKindList = guPolicyItemKindMapper
				.selectListByBusinessNo(guPolicyItemKindKey);// itemKinds

		GuPolicyEmployee guPolicyEmployeeKey = new GuPolicyEmployee();
		guPolicyEmployeeKey.setBusinessNo(businessNO);
		List<GuPolicyEmployee> guPolicyEmployeeList = employeeMapper
				.findEmployeeList(guPolicyEmployeeKey);// employees

		if ("2".equals(paymentFlag)) {// 自动核保出单
			/*
			 * if("YGBX".equals(guPolicyMain.getInsurerCode()))
			 * {//阳光保险(YGBX)的每人限额40万(包括)以上的走自动核保出结果 BigDecimal unitAmount =
			 * null; for (GuPolicyItemKind itemKind : guPolicyItemKindList) {
			 * if("0901001".equals(itemKind.getKindcode())) { unitAmount =
			 * itemKind.getUnitamount(); } }
			 * if(unitAmount.compareTo(BigDecimal.valueOf(400000.0)) == 1) {
			 * return manualUnderwriteUtil(guPolicyMain, guPolicyItemKindList,
			 * guPolicyEmployeeList); } }
			 */
			return "showSuccess";
		}
		if ("3".equals(paymentFlag)) {// 提交自动核保接口 出结果

			return autoUnderwriterResultUtil(guPolicyMain,
					guPolicyItemKindList, guPolicyEmployeeList);

		}
		if ("4".equals(paymentFlag)) {// 提交人工核保接口 审核

			return manualUnderwriteUtil(guPolicyMain, guPolicyItemKindList,
					guPolicyEmployeeList);

		}
		return "showError";
	}

	private int getDaydiff(String startDate, String endDate) {
		int startD = Integer.valueOf(startDate.substring(8, 10));
		int startM = Integer.valueOf(startDate.substring(5, 7));
		int startY = Integer.valueOf(startDate.substring(0, 4));
		int endD = Integer.valueOf(endDate.substring(8, 10));
		int endM = Integer.valueOf(endDate.substring(5, 7));
		int endY = Integer.valueOf(endDate.substring(0, 4));
		if (endD >= startD) {
			return (endY - startY) * 12 + (endM - startM) + 1;
		} else {
			return (endY - startY) * 12 + (endM - startM);
		}
	}

	private long getRandom(final long min, final long max) {
		Random rand = new Random();
		long tmp = Math.abs(rand.nextInt());
		return tmp % (max - min + 1) + min;

	}

	/**
	 * 提交投保单跳至此
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertPolicy")
	// 根据用户选择的保险公司插入投保单
	public String insertPolicy(HttpServletRequest request, Model model) {

		/**
		 * paymentFlag是gginsuranceDetail里的CLAUSE,作用:1是自动核保出单需要跳转"缴费",
		 * 无则是需要提交审核出结果,然后在发送出单请求.
		 */
		String paymentFlag = request.getParameter("paymentFlag");
		GuPolicyMain guPolicyMain = (GuPolicyMain) session
				.getAttribute("guPolicyMain");
		GuPolicyFee guPolicyFee = (GuPolicyFee) session
				.getAttribute("guPolicyFee");
		GuPolicyAdjustRate guPolicyAdjustRate = (GuPolicyAdjustRate) session
				.getAttribute("guPolicyAdjustRate");
		List<GuPolicyItemKind> guPolicyItemKindList = (List<GuPolicyItemKind>) session
				.getAttribute("guPolicyItemKindList");
		List<GuPolicyLimit> guPolicyLimitList = (List<GuPolicyLimit>) session
				.getAttribute("guPolicyLimitList");
		List<GuPolicyInsured> guPolicyInsuredList = (List<GuPolicyInsured>) session
				.getAttribute("guPolicyInsuredList");
		List<GuPolicyEmployee> guPolicyEmployeeList = (List<GuPolicyEmployee>) session
				.getAttribute("guPolicyEmployeeList");

		/**
		 * 保险公司配置方案的flag是2的 和阳光保险每人限额小于等于40万的都是自动核保并出单,核保状态系统直接给"3"已通过
		 */
		if ("2".equals(paymentFlag)) {// 保险公司配置方案是"2" 的

			guPolicyMain.setUnderWriteFlag("3");// 审核状态设置为"3"

			/*if ("YGBX".equals(guPolicyMain.getInsurerCode())) {
				BigDecimal unitAmount = null;
				for (GuPolicyItemKind itemKind : guPolicyItemKindList) {
					if ("0901001".equals(itemKind.getKindcode())) {
						unitAmount = itemKind.getUnitamount();
					}
				}
				if (unitAmount.compareTo(BigDecimal.valueOf(400000.0)) == 1) {// 阳光保险公司的大于四十万的设置成"1"待审核
					guPolicyMain.setUnderWriteFlag("1");
				}
			}*/
		}

		/** 添加全部跟单信息入库 **/
		insurePolicyService.insertAll(guPolicyMain, guPolicyFee,
				guPolicyAdjustRate, guPolicyItemKindList, guPolicyLimitList,
				guPolicyInsuredList, guPolicyEmployeeList);

		String businessNOee = request.getParameter("businessNO");
		String status = request.getParameter("status");// 1.重新递交保单 // 2.续保
		if ("1".equals(status)) {// 重新投保
			// tojudge.deletePolicy(businessNOee);
			GuPolicyMain main = insurePolicyService
					.selectByPrimaryKey3(businessNOee);
			main.setUnderWriteFlag("6");
			insurePolicyService.updateByPrimaryKeySelective(main);
		}
		if ("2".equals(status)) {// 续交保费
			String result = tojudge.selectPolicy(businessNOee);
			Map<String, Object> checkMap = new HashMap<String, Object>();
			checkMap.put("PREVIOUSPOLICYNO", result);
			checkMap.put("BUSINESSNO", businessNOee);
			tojudge.updatePolicy(checkMap);
		}
		if ("2".equals(paymentFlag)) {// 自动核保出单
			/*if ("YGBX".equals(guPolicyMain.getInsurerCode())) {// 阳光保险(YGBX)的每人限额40万(包括)以上的走自动核保出结果
				BigDecimal unitAmount = null;
				for (GuPolicyItemKind itemKind : guPolicyItemKindList) {
					if ("0901001".equals(itemKind.getKindcode())) {
						unitAmount = itemKind.getUnitamount();
					}
				}
				if (unitAmount.compareTo(BigDecimal.valueOf(400000.0)) == 1) {
					return manualUnderwriteUtil(guPolicyMain,
							guPolicyItemKindList, guPolicyEmployeeList);
				}
			}*/
			return "showSuccess";
		}
		if ("3".equals(paymentFlag)) {// 提交自动核保接口 出结果

			return autoUnderwriterResultUtil(guPolicyMain,
					guPolicyItemKindList, guPolicyEmployeeList);

		}
		if ("4".equals(paymentFlag)) {// 提交人工核保接口 审核

			return manualUnderwriteUtil(guPolicyMain, guPolicyItemKindList,
					guPolicyEmployeeList);

		}
		return "showError";
	}

	/**
	 * 提交人工核保接口 审核工具
	 * 
	 * @param guPolicyMain
	 * @param guPolicyItemKindList
	 * @param guPolicyEmployeeList
	 * @return
	 */
	private String manualUnderwriteUtil(GuPolicyMain guPolicyMain,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyEmployee> guPolicyEmployeeList) {
		ManualUnderwriteResponse service = new ManualUnderwriteResponse();
		try {
			service = submitInsure.manualUnderwriting(guPolicyMain,
					guPolicyItemKindList, guPolicyEmployeeList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String requestType = service.getResponseCode();
		if ("0".equals(requestType)) {
			String proposal = service.getProposalNo();
			String sign = service.getSendDateTime();
			Date signTime = null;
			try {
				SimpleDateFormat sim = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				signTime = sim.parse(sign);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			// Map<String,Object> condition = new HashMap<String,Object>();
			// condition.put("buseiness" , guPolicyMain.getBusinessNo());
			// condition.put("signTime", signTime);
			// condition.put("proposal", proposal);
			// detailService.updateproposal(condition);
			GuPolicyMain record = new GuPolicyMain();
			record.setBusinessNo(guPolicyMain.getBusinessNo());
			record.setSignDate(signTime);
			record.setProposalNo(proposal);
			record.setUnderWriteFlag("1");
			guPolicyMainMapper.updateByPrimaryKeySelective(record);
			return "showSuccess";
		} else {
			Map<String, Object> censor = new HashMap<String, Object>();
			censor.put("underdirections", service.getResponseName());// 返回失败显示错误信息
			censor.put("business", guPolicyMain.getBusinessNo());// 可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
			censor.put("underwriteflag", "2");
			client.updateCensor(censor);
			return "showError";
		}
	}

	/**
	 * 处理自动核保出结果的工具
	 * 
	 * @param guPolicyMain
	 * @param guPolicyItemKindList
	 * @param guPolicyEmployeeList
	 * @return
	 */
	private String autoUnderwriterResultUtil(GuPolicyMain guPolicyMain,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyEmployee> guPolicyEmployeeList) {
		InsuranceSingleResponse res = new InsuranceSingleResponse();
		try {
			res = submitInsure.autoUnderwriting(guPolicyMain,
					guPolicyItemKindList, guPolicyEmployeeList);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> censor = new HashMap<String, Object>();
			censor.put("underdirections", "系统繁忙,请稍后再试.");// 其他错误原因
			censor.put("business", guPolicyMain.getBusinessNo());// 可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
			censor.put("underwriteflag", "2");
			client.updateCensor(censor);
			return "showError";
		}
		String requestType = res.getResponseCode();
		if ("0".equals(requestType)) {
			String proposal = res.getProposalNo();
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("buseiness", guPolicyMain.getBusinessNo());
			condition.put("signTime", new Date());
			condition.put("proposal", proposal);
			detailService.updateproposal(condition);

			return "showSuccess";
		} else {
			Map<String, Object> censor = new HashMap<String, Object>();
			censor.put("underdirections", res.getResponseName());// 其他错误原因
			censor.put("business", guPolicyMain.getBusinessNo());// 可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
			censor.put("underwriteflag", "2");
			client.updateCensor(censor);
			return "showError";
		}
	}

	@RequestMapping("/getDateYear")
	// 判断两个日期是否大于一年
	public void getDateYear(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String startDate = obj.getString("startDate");
		String endDate = obj.getString("endDate");
		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
			Date start = sim.parse(startDate);
			Date end = sim.parse(endDate);
			boolean flag = new StringUtil().isOneYear(start, end);
			String dateFlag = "";
			if (flag) {
				dateFlag = "1";
			} else {
				dateFlag = "0";
			}
			dateFlag = JSON.toJSONString(dateFlag);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter write = response.getWriter();
			write.write(dateFlag);
			write.flush();
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date())));
		// System.out.println(new Date("2017-05-06 12:33:33"));
	}
}
