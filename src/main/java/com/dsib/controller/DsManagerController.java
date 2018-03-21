package com.dsib.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.tools.tree.ThisExpression;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GgUserMapper;
import com.dsib.dao.GuPolicyEmployeeMapper;
import com.dsib.dao.GuPolicyInsurePremiumMapper;
import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GgAmountRate;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgCompanySum;
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
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;
import com.dsib.entity.PolicyManager;
import com.dsib.inter.Apply;
import com.dsib.service.GcClaimService;
import com.dsib.service.GgAdministrationService;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgCommonwealService;
import com.dsib.service.GgInsureConfigService;
import com.dsib.service.GgPaymentConfigService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GpMainOrderService;
import com.dsib.service.GpOrderDetailService;
import com.dsib.service.GuPolicyInsuredService;
import com.dsib.service.GuPolicyItemKindService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.InsurePolicyService;
import com.dsib.service.JobWebServiceClientService;
import com.dsib.service.QyMycheckService;
import com.dsib.service.QyMypolicyService;
import com.dsib.submitInterface.SubmitInsureAfterUtil;
import com.dsib.submitInterface.SubmitInsureUtil;
import com.dsib.util.CheckImprotPolicy;
import com.dsib.util.DateUtils;
import com.dsib.util.FileUtil;
import com.dsib.util.JiSuanPremiumUtil;
import com.dsib.util.Md5Util;
import com.dsib.util.StringUtil;
import com.dsib.webService.AZX.bean.common.xsd.ApplicantEhm;
import com.dsib.webService.AZX.bean.common.xsd.InsuredEhm;
import com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm;
import com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm;
import com.dsib.webService.AZX.bean.common.xsd.MainEhm;
import com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleRequest;
import com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleResponse;
import com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortType;
import com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortTypeProxy;
import com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteResponse;
import com.dsib.webService.AZX.manualUnderwriteAfterSingle.dto.xsd.ManualUnderwriteAfterSingleRequest;
import com.dsib.webService.AZX.manualUnderwriteAfterSingle.dto.xsd.ManualUnderwriteAfterSingleResponse;
import com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortType;
import com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortTypeProxy;
import com.yeepay.Configuration;
import com.yeepay.PaymentForOnlineService;

/**
 * 经济公司用户专用
 */
@Controller
@RequestMapping("/dsmanager")
@SessionAttributes({"pagination","summation"})
public class DsManagerController extends BaseController {

	@Autowired
	GuPolicyMainMapper mainMapper;
	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggUserCorpService;
	@Resource(name = "QyMyPolicy")
	private QyMypolicyService qymypolicy;
	@Resource(name = "ggCodeService")
	private GgCodeService codeService;
	@Resource(name = "ggAdministration")
	private GgAdministrationService administr;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService guPolicyMainService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService corpService;
	@Resource(name = "gcClaimService")
	private GcClaimService claimService;
	@Resource(name = "qymychecked")
	private QyMycheckService mychecked;
	
	@Resource(name = "ggInsureConfigService")
	private GgInsureConfigService ggInsureConfigService;
	
	@Resource(name = "GgCommonweal")
	private GgCommonwealService commonweal;
	@Resource(name = "JobWebService")
	private JobWebServiceClientService webService;
	@Resource(name = "ggPaymentConfigService")
	private GgPaymentConfigService ggPaymentConfigService;
	@Resource(name = "gpMainOrderService")
	private GpMainOrderService gpMainOrderService;
	@Resource(name = "gpOrderDetailService")
	private GpOrderDetailService detailService;
	@Autowired
	GgUserMapper userMapper;
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;
	
	@Resource(name = "guPolicyInsuredService")
	private GuPolicyInsuredService guPolicyInsuredService;//关系人信息
	
	@Resource
	private GuPolicyEmployeeMapper employeeMapper;
	
	@Resource(name = "guPolicyItemKindService")
	private GuPolicyItemKindService guPolicyItemKindService;
	
	@Resource
	private JiSuanPremiumUtil jiSuan;
	
	@Resource(name="JobWebService")
	JobWebServiceClientService client;
	
	@Autowired
	private SubmitInsureAfterUtil insureAfter;
	
	@Autowired
	private SubmitInsureUtil submitInsure;
	
	@Autowired
	private GuPolicyInsurePremiumMapper guPolicyInsurePremiumMapper;
	
	private Logger log = Logger.getLogger(DsManagerController.class);
	
	/**
	 * 经济用户登录后初始化
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping("/initManager")
	public ModelAndView initManager(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
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
		mad.addObject("province", province);
		mad.addObject("city", city);
		mad.addObject("county", county);
		mad.setViewName("/dsmanager/mainPage");
		return mad;
	}
	
	//投保单审核查看
	@RequestMapping("/mypolicyshow")
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
		GuPolicyMain guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessno);
		resultMap.put("EMCOUNT", guPolicyMain.getCurrency());
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(guPolicyMain.getAppliCode());
		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(businessno);
		guPolicyInsuredKey.setSeriesno(1L);
		GuPolicyInsured guPolicyInsured = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		guPolicyInsuredKey.setSeriesno(2L);
		GuPolicyInsured guPolicyInsured1 = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
		//总保费
		Object obj = resultMap.get("SPREADSHEETPREMIUM");
		double tempbapfei = Double.valueOf(obj.toString());
		String zongbaofei = new StringUtil().number2CNMontrayUnit(BigDecimal.valueOf(tempbapfei));
		request.setAttribute("zongbaofei", zongbaofei);
		request.setAttribute("standardLevelImg", guPolicyMain.getUnderWriteName());
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
		request.setAttribute("inPep", guPolicyInsured);
		request.setAttribute("alPep", guPolicyInsured1);
		request.setAttribute("tempUserCorp", ggUserCorp);
		mad.addObject("resultMap", resultMap);
		mad.addObject(pagination);
		request.setAttribute("businessno", businessno);
		mad.setViewName("/dsmanager/mypolicyShow");
		return mad;
	}
	
	//投保单审核
	@RequestMapping("/michelangelo")
	public String michelangelo(HttpServletRequest request, Model model){
		String businessno = request.getParameter("businessno");
		String shyj = request.getParameter("shyj");
		String flag = request.getParameter("flag");
		GuPolicyMain guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessno);
		guPolicyMain.setUnderWriteFlag(flag);
		guPolicyMain.setUnderDirections(shyj);
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		guPolicyMain.setUnderWriteCode(ggUser.getUserCode());
		insurePolicyService.updateByPrimaryKeySelective(guPolicyMain);
		return "/insurePolicy/showSuccess";
	}
	
	/**
	 * 模糊查询企业,经纪公司业务员录单款速查询投保人名称
	 * @param obj
	 * @param response
	 */
	@RequestMapping(value = "/getNameAndCode")
	public void getNameAndCode(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String companyName = obj.getString("remark");
		List<GgUserCorp> list = ggUserCorpService.getUserLikeName(companyName);
		String codeList = "";
		codeList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(codeList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取企业信息
	@RequestMapping(value = "/getwodexinxi")
	public void getwodexinxi(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String companyName = obj.getString("remark");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(companyName);
		String pepSums = "";
		GgEmployee ggEmployee = new GgEmployee();
		ggEmployee.setUserCode(companyName);
		List<GgEmployee> ggEmployeeList = insurePolicyService.getGgEmployeeList(ggEmployee);
		for(int i=0;i<ggEmployeeList.size();i++){
			pepSums+=ggEmployeeList.get(i).getEmName()+","+ggEmployeeList.get(i).getIdentityNo()+";";
		}
		ggUserCorp.setFlag(String.valueOf(ggEmployeeList.size()));
		ggUserCorp.setRemark(pepSums);
		
		List<GgUserCorp> list = new ArrayList<GgUserCorp>();
		list.add(ggUserCorp);
		String codeList = "";
		codeList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(codeList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//插入用户
	@RequestMapping(value = "/admininsert", consumes = "application/json", method = RequestMethod.POST)
	public void admininsert(@RequestBody GgUser ggUser, PrintWriter writer) throws ParseException {
		GgUser tempUser = (GgUser) session.getAttribute("ggUser");
		String userCode = ggUser.getUserCode();
		String passWord = Md5Util.md5(ggUser.getPassword());
		String userName = ggUser.getUserName();
		String division = ggUser.getDivision();
		String flag = ggUser.getFlag();
		String province = ggUser.getProvince();
		String city = ggUser.getCity();
		String county = ggUser.getCounty();
		String comLevel = ggUser.getComLevel();
		String telePhone = ggUser.getTelePhone();
		String linkName = ggUser.getLinkName();
		String query = userCode;
		String result = "";
		GgUser user = userMapper.getUser(query);
		GgUser admin = new GgUser();
		long l = System.currentTimeMillis();
		Date time = new Date(l);
		admin.setUserCode(userCode);
		admin.setPassword(passWord);
		admin.setUserName(userName);
		admin.setDivision(division);
		admin.setFlag(flag);
		admin.setProvince(province);
		admin.setCity(city);
		admin.setCounty(county);
		admin.setUpdateDate(time);
		admin.setComLevel(comLevel);
		admin.setTelePhone(telePhone);
		admin.setLinkName(linkName);
		admin.setAddress(tempUser.getAddress());//所属保险公司
		admin.setUpdator(tempUser.getUserCode());//上级代码
		admin.setUserInd("3");
		if (user == null) {
			administr.getAdminsert(admin);
			result = "success";
		} else {
			result = "falsess";
		}
		writer.write(JSON.toJSONString(result));
	}
	
	@RequestMapping("/adminSelect")
	public ModelAndView adminSelect(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
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
		mad.setViewName("/dsmanager/administrationCondition");
		return mad;
	}
	
	//用户查询
	@RequestMapping("/adminquery")
	public ModelAndView adminquery(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String UserName = request.getParameter("UserName");
		String userType = request.getParameter("userType");
		Pagination pagination = new Pagination();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("userType", userType);
		if(UserName==null){
			conditionMap.put("UserName", "");
		}else{
			conditionMap.put("UserName", UserName);
		}
		conditionMap.put("SelectCode", ggUser.getUserCode());
		if("1".equals(ggUser.getComLevel())){
			conditionMap.put("SelectLv", ggUser.getAddress());
		}else{
			conditionMap.put("SelectLvL", ggUser.getAddress());
		}
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = administr.getAdminQueryJj(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/dsmanager/administrationResult");
		return mad;

	}
	
	
	@RequestMapping("/adminedit")
	public ModelAndView adminedit(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		String UserCode = request.getParameter("UserCode");
		GgUser gguser = administr.getAdminEditNew(UserCode);
		List<Map<String, Object>> opption = administr.Criteria();
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("level", comLevel);
		mad.addObject("levele", level);
		mad.addObject("opption", opption);
//		mad.addObject("gguser", gguser);
		session.setAttribute("gguser", gguser);
		mad.setViewName("/dsmanager/adminsitrationShow");
		return mad;
	}
	
	//用户查询结果显示
	@RequestMapping("/admindel")
	public ModelAndView admindel(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String UserCode = request.getParameter("UserCode");
		administr.setAdminStatus(UserCode);
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		List<Map<String, Object>> resultList = administr.getAdminQuery(pagination);
		pagination.setResultList(resultList);
		mad.addObject("pagination", pagination);
		mad.setViewName("/dsmanager/administrationResult");
		return mad;
	}
	
	@RequestMapping("/adminupdate")
	public ModelAndView admintupdate(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String USERCODE = request.getParameter("USERCODE");
		String USERNAME = request.getParameter("USERNAME");
		String PROVINCE = request.getParameter("province1");
		String CITY = request.getParameter("city1");
		String COUNTY = request.getParameter("county1");
		String TELEPHONE = request.getParameter("TELEPHONE");
		String LINKNAME = request.getParameter("LINKNAME");
		String FLAG = request.getParameter("FLAG");
		String division = request.getParameter("division");
		String comLevel = request.getParameter("discopy");
		GgUser user = new GgUser();
		user.setUserCode(USERCODE);
		user.setUserName(USERNAME);
		user.setProvince(PROVINCE);
		user.setCity(CITY);
		user.setCounty(COUNTY);
		user.setTelePhone(TELEPHONE);
		user.setLinkName(LINKNAME);
		user.setFlag(FLAG);
		user.setComLevel(comLevel);
		user.setDivision(division);
		administr.getAdminUpdate(user);
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		List<Map<String, Object>> resultList = administr.getAdminQuery(pagination);
		pagination.setResultList(resultList);
		mad.addObject("pagination", pagination);
		mad.setViewName("/dsmanager/administrationResult");
		return mad;
	}
	
	
	/**
	 * 经济公司查询保单页面初始
	 * @return
	 */
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
		List<GgCode> list_classCode = codeService.getGgCodeByObj(code1);
		Pagination pagination = new Pagination();
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = mychecked.getmypolicyInitjj(pagination);
		pagination.setResultList(list);
		
		//总合计
		List<Map<String, String>> summations = mychecked.getMyPolicyInitJgNotPage(map);
		Map<String, String> summation = summations.get(0);
		
		mad.addObject("pagination",pagination);
		mad.addObject("list_classCode",list_classCode);
		mad.addObject("list_CICompanycode",list_ggConfig);
		
		mad.addObject("summation", summation);
		
		mad.setViewName("/dsmanager/mycheckCondition");
		return mad;
	}
	
	//保单批量导入
	@RequestMapping("/goBBBBB")
	public String goBBBBB(HttpServletRequest request, Model model){
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		request.setAttribute("list_CICompanycode",list_ggConfig);
		return "gobatch";
	}
	
	@Transactional()
	@RequestMapping(value="/checkPolicyExl", method = RequestMethod.POST) 
	public void checkPolicyExl(@RequestParam(value = "excelPath", required = false) MultipartFile file,
			HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException{
			String inserdCodes = request.getParameter("insurerCode");
			HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheet = wb.getSheetAt(0);
            List<GuPolicyMain> list = new ArrayList<GuPolicyMain>();
            List<GuPolicyItemKind> listItem = new ArrayList<GuPolicyItemKind>();
            List<GuPolicyInsured> listInsured = new ArrayList<GuPolicyInsured>();
            List<GgUserCorp> userCorps = new ArrayList<GgUserCorp>();
            PolicyManager policyManager = new PolicyManager();
            String resultStr = "";
            
            CheckImprotPolicy checkImprotPolicy = new CheckImprotPolicy();
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            	HSSFRow hssfRow = sheet.getRow(rowNum);
            	if (hssfRow != null) {
            		String result = checkImprotPolicy.checkPolicy(hssfRow,rowNum,session,guPolicyMainMapper);
            		if(result.length()>0){
            			resultStr=resultStr+result;
            		}
            	}
            }
            if(resultStr.length() <= 0) {
            	for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            		HSSFRow hssfRow = sheet.getRow(rowNum);
            		if (hssfRow != null) {
            			HSSFCell policyNo = hssfRow.getCell(0);
            			HSSFCell startDate = hssfRow.getCell(1);
            			HSSFCell endDate = hssfRow.getCell(2);
            			HSSFCell appliName = hssfRow.getCell(3);
            			HSSFCell appliAddress = hssfRow.getCell(4);
            			HSSFCell appliPhoneNo = hssfRow.getCell(5);
            			HSSFCell appliLinkName = hssfRow.getCell(6);
            			HSSFCell appleEmail = hssfRow.getCell(7);
            			HSSFCell insuredName = hssfRow.getCell(8);
            			HSSFCell insuredAddress = hssfRow.getCell(9);
            			HSSFCell insuredPhoneNo = hssfRow.getCell(10);
            			HSSFCell insuredLinkName = hssfRow.getCell(11);
            			HSSFCell insuredEmail = hssfRow.getCell(12);
            			HSSFCell province = hssfRow.getCell(13);
            			HSSFCell city = hssfRow.getCell(14);
            			HSSFCell county = hssfRow.getCell(15);
            			HSSFCell jobType = hssfRow.getCell(16);
            			HSSFCell businessType = hssfRow.getCell(17);
            			HSSFCell businesscccCode = hssfRow.getCell(18);
            			HSSFCell safeNumber = hssfRow.getCell(19);
            			HSSFCell zhuMeiRen = hssfRow.getCell(20);
            			HSSFCell zhuMeiCi = hssfRow.getCell(21);
            			HSSFCell zhuBaofei = hssfRow.getCell(22);
            			HSSFCell fuSanXianE = hssfRow.getCell(23);
            			HSSFCell fuSanBaoFei = hssfRow.getCell(24);
            			HSSFCell fuYiLiaoXianE = hssfRow.getCell(25);
            			HSSFCell fuYiLiaoBaoFei = hssfRow.getCell(26);
            			HSSFCell fuJiuYuanXianE = hssfRow.getCell(27);
            			HSSFCell fuJiuYuanBaoFei = hssfRow.getCell(28);
            			HSSFCell fuFaLvXianE = hssfRow.getCell(29);
            			HSSFCell fuFaLvBaoFei = hssfRow.getCell(30);
            			HSSFCell sumBaoFei = hssfRow.getCell(31);
            			HSSFCell EMCOUNT = hssfRow.getCell(32);
            			// 生成业务号
            			String businessNo = new Long(new Date().getTime()).toString();
            			businessNo = businessNo
            					+ Long.toString(getRandom(100000000, 999999999));
            			businessNo = businessNo.substring(0, 20);
//            			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            			Date startD = sdf.parse(getValue(startDate));
//            			Date endD = sdf.parse(getValue(endDate));
            			Date startD = DateUtils.formatStartDate(getValue(startDate));
            			Date endD = DateUtils.formatEndDate(getValue(endDate));
            			GuPolicyMain guPolicyMain = new GuPolicyMain(businessNo, getValue(policyNo), "0901", "批量导入保单", 
            					getValue(appliName), getValue(appliAddress), getValue(insuredName), getValue(insuredAddress), 
            					startD, endD, getValue(EMCOUNT), Double.valueOf(getValue(zhuMeiCi)), 1.00, Double.valueOf(getValue(sumBaoFei)),
            					new Date(), "3", "1", inserdCodes, getValue(province).substring(getValue(province).length()-6), 
            					getValue(city).substring(getValue(city).length()-6), getValue(county).substring(getValue(county).length()-6),
            					"1");
            			list.add(guPolicyMain);
            			GuPolicyInsured guPolicyInsured = new GuPolicyInsured("8004", "0901", getValue(safeNumber)
            					, getValue(appliName), getValue(appliAddress), getValue(businesscccCode), getValue(appliLinkName)
            					, getValue(appliPhoneNo), "", getValue(businessType).substring(getValue(businessType).length()-6),
            					getValue(jobType).substring(getValue(jobType).length()-6));
            			guPolicyInsured.setBusinessno(businessNo);
            			guPolicyInsured.setSeriesno(1L);
            			listInsured.add(guPolicyInsured);
            			GuPolicyInsured guPolicyInsured2 = new GuPolicyInsured("8004", "0901", getValue(safeNumber)
            					, getValue(insuredName), getValue(insuredAddress), getValue(businesscccCode), getValue(insuredLinkName)
            					, getValue(insuredPhoneNo), "", getValue(businessType).substring(getValue(businessType).length()-6),
            					getValue(jobType).substring(getValue(jobType).length()-6));
            			guPolicyInsured2.setBusinessno(businessNo);
            			guPolicyInsured2.setSeriesno(2L);
            			listInsured.add(guPolicyInsured2);
            			GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind("0901", 
            					BigDecimal.valueOf(Double.valueOf(getValue(zhuBaofei))), 
            					BigDecimal.valueOf(Double.valueOf(getValue(zhuBaofei))), 
            					BigDecimal.valueOf(Double.valueOf(getValue(zhuMeiCi))), 
            					BigDecimal.valueOf(Double.valueOf(getValue(zhuMeiRen))));
            			guPolicyItemKind.setBusinessno(businessNo);
            			guPolicyItemKind.setKindcode("0901001");
            			listItem.add(guPolicyItemKind);
            			if(fuSanXianE!=null&&fuSanXianE.getCellType()!=3){
            				GuPolicyItemKind guPolicyItemKind2 = new GuPolicyItemKind("0901", 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuSanBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuSanBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuSanXianE))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuSanXianE))));
            				guPolicyItemKind2.setBusinessno(businessNo);
            				guPolicyItemKind2.setKindcode("0901002");
            				listItem.add(guPolicyItemKind2);
            			}
            			if(fuYiLiaoXianE!=null&&fuYiLiaoXianE.getCellType()!=3){
            				GuPolicyItemKind guPolicyItemKind3 = new GuPolicyItemKind("0901", 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuYiLiaoBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuYiLiaoBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuYiLiaoXianE))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuYiLiaoXianE))));
            				guPolicyItemKind3.setBusinessno(businessNo);
            				guPolicyItemKind3.setKindcode("0901003");
            				listItem.add(guPolicyItemKind3);
            			}
            			if(fuJiuYuanXianE!=null&&fuJiuYuanXianE.getCellType()!=3){
            				GuPolicyItemKind guPolicyItemKind4 = new GuPolicyItemKind("0901", 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuJiuYuanBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuJiuYuanBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuJiuYuanXianE))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuJiuYuanXianE))));
            				guPolicyItemKind4.setBusinessno(businessNo);
            				guPolicyItemKind4.setKindcode("0901004");
            				listItem.add(guPolicyItemKind4);
            			}
            			if(fuFaLvXianE!=null&&fuFaLvXianE.getCellType()!=3){
            				GuPolicyItemKind guPolicyItemKind5 = new GuPolicyItemKind("0901", 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuFaLvBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuFaLvBaoFei))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuFaLvXianE))), 
            						BigDecimal.valueOf(Double.valueOf(getValue(fuFaLvXianE))));
            				guPolicyItemKind5.setBusinessno(businessNo);
            				guPolicyItemKind5.setKindcode("0901005");
            				listItem.add(guPolicyItemKind5);
            			}
            			
            			//组织出公司信息
            			GgUserCorp userCorp = getUserCorp(guPolicyMain, guPolicyInsured2);
            			userCorps.add(userCorp);
            		}
            	}
            }
            if(list.size()>0){
            	/**检查保单号是否有重复的**/
            	List<String> policyNos = new ArrayList<String>();
            	for (GuPolicyMain main : list) {
					policyNos.add(main.getPolicyNo());
				}
            	//将list放入set中对其去重  
                Set<String> set = new HashSet<>(policyNos);  
          
                //获得list与set的差集  
                Collection rs = CollectionUtils.disjunction(policyNos,set);  
                //将collection转换为list  
                List<String> policyNo2 = new ArrayList<>(rs); 
                if(!policyNo2.isEmpty()) {
                	Set<String> rePolicyNo = new HashSet<>(policyNo2);  
                	StringBuffer sb = new StringBuffer();
                	for (String string : rePolicyNo) {
                		sb.append("重复的保单号如下:\n");
                		sb.append(string + "\n");
                	}
                	resultStr += sb.toString();
                }
                
            	/**保单号不重复的**/
            	if(StringUtils.isEmpty(resultStr)) {
            		insurePolicyService.insertBatchPolicy(list,listInsured,listItem,userCorps);
            	}
            	
            }
            if(resultStr.length()>0){
            	policyManager.setInAddress(resultStr);
            	policyManager.setInBusinessLicenseNo("1"); 
            }else{
            	policyManager.setInBusinessLicenseNo("2");
            }
    		String pt = JSON.toJSONString(policyManager);
    		response.setCharacterEncoding("utf-8");
    		response.setContentType("text/html");
    		try {
    			PrintWriter write = response.getWriter();
    			write.write(pt);
    			write.flush();
    			write.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	}
	
	/**
	 * 从批量导入保单的保单里获取公司信息
	 * @param main
	 * @param insured
	 * @return
	 */
	private GgUserCorp getUserCorp(GuPolicyMain main ,GuPolicyInsured insured) {
		GgUserCorp userCorp = new GgUserCorp();
		userCorp.setBusinessLicenseDate(new Date(864000L*1000L*365L*5L));
		userCorp.setUserCode(System.currentTimeMillis() + RandomStringUtils.random(5,true,false));
		userCorp.setCompanyName(main.getInsuredName().replace(" ", ""));
		userCorp.setCompanyAddress(main.getInsuredAddress());
		userCorp.setSafetyLiceseDate(new Date(864000L*1000L*365L*5L));
		userCorp.setLinkName(insured.getLinkname());
		userCorp.setClassCode(insured.getRemark());
		userCorp.setBusinessClass(insured.getFlag());
		userCorp.setProvince(main.getProvince());
		userCorp.setCity(main.getCity());
		userCorp.setCounty(main.getCounty());
		userCorp.setCorpration(null);
		userCorp.setEmCount(null);
		userCorp.setTelephone(null);
		userCorp.setMobile(insured.getPhonenumber());
		userCorp.setEmail(insured.getEmail());
		userCorp.setFax(null);
		userCorp.setPost(null);
		userCorp.setBusinessLicenseNo(insured.getIdentitynumber().replace(" ", ""));
		userCorp.setBusinessLicenseImage(null);
		userCorp.setSafetyLicenseNo(insured.getInsuredtype());
		userCorp.setSafetyLicenseImage(null);
		userCorp.setTurnover(null);
		userCorp.setTax(null);
		userCorp.setRemark(null);
		userCorp.setStandardLevelImage(null);
		userCorp.setRiskLevel("0");
		userCorp.setFlag(null);
		userCorp.setFaithLevel(null);
		userCorp.setStandardLevel(null);
		userCorp.setSumstandardLevel(null);
		userCorp.setClassSize(null);
		userCorp.setValidStatus("1");
		return userCorp;
	}
	
	/**
	 * 获取excel小格里面的值
	 * @param hssfCell
	 * @return
	 */
	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
           // 返回数值类型的值
           DecimalFormat df = new DecimalFormat("0"); 
           return String.valueOf(df.format(hssfCell.getNumericCellValue()));
        }else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_FORMULA) {
    		double numericCellValue = 0;
    		String plainString = null;
			try {
				numericCellValue = hssfCell.getNumericCellValue();
				BigDecimal bd1 = new BigDecimal(numericCellValue);
		        plainString = bd1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
			} catch (Exception e) { 
				e.printStackTrace();
				return "ERROR";
			}
    	    return StringUtils.isEmpty(plainString) == true ? "" : plainString.replace(" ", "");
        } else {
              // 返回字符串类型的值
           return String.valueOf(hssfCell.getStringCellValue().replace(" ", ""));
        }
   }
	
	/**
	 * 经纪公司查询 已缴费 或者  审核已通过  但是没有保单号的失败单,或者
	 * @param request
	 * @return
	 */
	//经济公司查询保单
	@RequestMapping("/mycheckinitjj")
	public ModelAndView mycheckinitjj(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = mychecked.getmypolicyInitjj(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/dsmanager/mycheckResult");
		return mad;
	}
	
	/**
	 * 经济公司条件查询保单
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/mycheckqueryjj")
	public ModelAndView mycheckqueryjj(HttpServletRequest request) throws ParseException {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String POLICYNO = trim(request.getParameter("POLICYNO"));
		String province = trim(request.getParameter("province1"));
		String city = trim(request.getParameter("city1"));
		String county = trim(request.getParameter("county1"));
		String classCode = trim(request.getParameter("classCode"));//行业大类
		String businessClass = trim(request.getParameter("businessClass"));//行业小类
		String inserdCode = trim(request.getParameter("inserdCode"));//保险公司
		String whyInsure = trim(request.getParameter("whyInsure"));//保单状态
		
		String reservation = trim(request.getParameter("reservation"));//保险起期条件
		String startDate = null;
		String endDate = null; 
		if(StringUtil.isNotEmpty(reservation)) {
			 startDate = reservation.substring(0,10);
			 endDate = reservation.substring(13);
		}
		String reservation1 = trim(request.getParameter("reservation1"));//保险止期条件
		String startDate1 = null;
		String endDate1 = null; 
		if(StringUtil.isNotEmpty(reservation1)) {
			startDate1 = reservation1.substring(0,10);
			endDate1 = reservation1.substring(13);
		}
		String renshu1 = trim(request.getParameter("renshu1"));//最小人数条件
		String renshu2 = trim(request.getParameter("renshu2"));//最大人数条件
		String baofei1 = trim(request.getParameter("baofei1"));//最小保费条件
		String baofei2 = trim(request.getParameter("baofei2"));//最大保费条件
		String everone1 = trim(request.getParameter("everone1"));//最小每人保额条件
		String everone2 = trim(request.getParameter("everone2"));//最大没人保额条件
		String companyName = trim(request.getParameter("companyName"));//公司名称条件
		
		
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
		List<Map<String, Object>> resultList = mychecked.getmypolicyInitjj(pagination);
		pagination.setResultList(resultList);
		
		//总合计
		List<Map<String, String>> summations = mychecked.getMyPolicyInitJgNotPage(conditionMap);
		Map<String, String> summation = summations.get(0) == null ? new HashMap<String,String>() : summations.get(0);
		
		mad.addObject(pagination);
		
		mad.addObject("summation", summation);
		mad.setViewName("/dsmanager/mycheckResult");
		return mad;
	}
	
	private String trim(String s) {
		if(StringUtils.isEmpty(s)) {
			return "";
		}
		return s.trim();
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
		
		FileUtil.setIsTotal(true);
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}
	
	/**
	 * 上下页
	 * @param pageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/mycheckinitjjPain")
	public ModelAndView mycheckinitjjPain(@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo)); 
		pagination = mychecked.getmypolicyInitjjPagination(pagination);
		
		Object queryCondition = pagination.getQueryCondition();
		System.out.println(queryCondition);
		//总合计
//		List<Map<String, String>> summations = mychecked.getMyPolicyInitJgNotPage(queryCondition);
//		Map<String, String> summation = summations.get(0);
		
		mad.addObject(pagination);
//		mad.addObject("summation", summation);
		mad.setViewName("/dsmanager/mycheckResult");
		return mad;
	}

	//经纪公司查询批单条件
	@RequestMapping("/correctQuery")
	public ModelAndView correctQuery(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
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
		/** 查询行业大类 **/
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = codeService.getGgCodeByObj(code);
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = mychecked.correctQuery(pagination);
		if(list!=null){
			java.util.Iterator<Map<String, Object>> it =  list.iterator();
			while(it.hasNext()){
				Map<String,Object> resultMap = it.next();
				if(String.valueOf(resultMap.get("SPRE")).length()>10){
					String spre = String.valueOf(resultMap.get("SPRE")).substring(0, 10);
					resultMap.put("spreSuo", spre);
				}
				resultMap.put("spreSuo", resultMap.get("SPRE"));
			}
		}
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.addObject("list_classCode",list_classCode);
		mad.addObject("list_CICompanycode",list_ggConfig);
		mad.setViewName("/dsmanager/correctQuery");
		return mad;
	}
	
	//经纪公司查询批单信息
	@RequestMapping("/correctQueryResult")
	public ModelAndView correctQueryResult(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String qiyeming = request.getParameter("qiyeming");//企业名称
		String xinyongdaima = request.getParameter("xinyongdaima");//统一信用代码
		String whyInsure = request.getParameter("whyInsure");//是否投保
		Pagination pagination = new Pagination();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		map.put("companyName", qiyeming.equals("请输入企业名称") ? "" : qiyeming);
		map.put("businesslicenseNo", xinyongdaima.equals("请输入保单号") ? "" : xinyongdaima);
		if("0".equals(whyInsure)){
			map.put("whyInsureT", "f");
		}
		if("1".equals(whyInsure)){
			map.put("whyInsureF", "a");
		}
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = mychecked.correctQuery(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.setViewName("/dsmanager/correctQueryResult");
		return mad;
	}
	
	//经纪公司查询批单翻页
	@RequestMapping("/correctQueryContinue")
	public ModelAndView correctQueryContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = mychecked.correctQueryContinue(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/dsmanager/correctQueryResult");
		return mad;
	}
	
	//经济公司导出批单报表
	@RequestMapping("/exportCorrect")
	public void exportCorrect(HttpServletResponse response,HttpServletRequest request) {
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String qiyeming = request.getParameter("qiyeming");//企业名称
		String xinyongdaima = request.getParameter("xinyongdaima");//统一信用代码
		String whyInsure = request.getParameter("whyInsure");//是否投保
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询条件
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		map.put("companyName", qiyeming.equals("请输入企业名称") ? "" : qiyeming);
		map.put("businesslicenseNo", xinyongdaima.equals("请输入保单号") ? "" : xinyongdaima);
		if("0".equals(whyInsure)){
			map.put("whyInsureT", "f");
		}
		if("1".equals(whyInsure)){
			map.put("whyInsureF", "a");
		}
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(map);
		// 查询信息
		List<Map<String, Object>> list = mychecked.exportCorrect(adapter);
		// 标题
		String[] titles = new String[] {"POLICYNO:保单号","PROVINCE:省","CITY:城市","COUNTY:区县","INSURERCODE:保险公司",
				"GUISHU:业务归属机构","ORDERNAME:业务员","STARTDATE:起保日期","ENDDATE:终保日期","SIGNDATE:签单日期","SPREADSHEETPREMIUM:总保费",
				"CORRECTPREMIUM:批改保费","CORRECTNO:批单号","CORRECTDATE:批改日期","SPECIALPROVISIONS:批单说明","CLASSCODE:行业大类", 
				"BUSINESSCODE:行业小类","INSUREDNAME:被保险人", "EMCOUNT:投保人数","FLAG:业务归属角色"
				};
		// 内容
		List<Map<String, Object>> lists = list;
		// 类型
		Class clas = Map.class;
		// sheet名
		String sheetName = "批单状况报表";
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}
	
	//经纪公司查询理赔条件
	@RequestMapping("/claimQuery")
	public ModelAndView claimQuery(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
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
		/** 查询行业大类 **/
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = codeService.getGgCodeByObj(code);
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.claimQuery(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.addObject("list_classCode",list_classCode);
		mad.addObject("list_CICompanycode",list_ggConfig);
		mad.setViewName("/dsmanager/claimQuery");
		return mad;
	}
	
	//经纪公司查询理赔信息
	@RequestMapping("/claimQueryResult")
	public ModelAndView claimQueryResult(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String qiyeming = request.getParameter("qiyeming");//企业名称
		String xinyongdaima = request.getParameter("xinyongdaima");//统一信用代码
		String whyInsure = request.getParameter("whyInsure");//是否投保
		Pagination pagination = new Pagination();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		map.put("companyName", qiyeming.equals("请输入企业名称") ? "" : qiyeming);
		map.put("businesslicenseNo", xinyongdaima.equals("请输入保单号") ? "" : xinyongdaima);
		if("0".equals(whyInsure)){
			map.put("whyInsureT", "f");
		}
		if("1".equals(whyInsure)){
			map.put("whyInsureF", "a");
		}
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.claimQuery(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.setViewName("/dsmanager/claimQueryResult");
		return mad;
	}
	
	//经纪公司查询理赔翻页
	@RequestMapping("/claimQueryContinue")
	public ModelAndView claimQueryContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = commonweal.claimQueryContinue(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/dsmanager/claimQueryResult");
		return mad;
	}
	
	//经济公司导出理赔报表
	@RequestMapping("/exportClaim")
	public void exportClaim(HttpServletResponse response,HttpServletRequest request) {
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String qiyeming = request.getParameter("qiyeming");//企业名称
		String xinyongdaima = request.getParameter("xinyongdaima");//统一信用代码
		String whyInsure = request.getParameter("whyInsure");//是否投保
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询条件
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		map.put("companyName", qiyeming.equals("请输入企业名称") ? "" : qiyeming);
		map.put("businesslicenseNo", xinyongdaima.equals("请输入保单号") ? "" : xinyongdaima);
		if("0".equals(whyInsure)){
			map.put("whyInsureT", "f");
		}
		if("1".equals(whyInsure)){
			map.put("whyInsureF", "a");
		}
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(map);
		// 查询信息
		List<Map<String, Object>> list = commonweal.exportClaim(adapter);
		// 标题
		String[] titles = new String[] {"POLICYNO:保单号","PEIANNO:赔案号","INSUREDNAME:企业名称",
				"PROVINCE:省","CITY:城市","COUNTY:区县","INSURERCODE:保险公司",
				"CLASSCODE:行业大类", "BUSINESSNO:行业小类","LOSSAMOUNT:损失金额","LOSSCAUSE:损失原因",
				"LOSSDATE:出险时间","LOSSLOCAITON:出险地点","CREATERCODE:受理人","CREATEDATE:受理时间","PAYAMOUNT:赔付金额"
				,"STATUS:状态","CLOSEDATE:结案日期","BAOANDATE:报案时间","LOSSDETAIL:损失情况","LINKNAME:联系人","LINKPHONE:联系方式"};
		// 内容
		List<Map<String, Object>> lists = list;
		// 类型
		Class clas = Map.class;
		// sheet名
		String sheetName = "理赔状况报表";
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}
	
	//综合报表
	@RequestMapping("/garbageReportForm")
	public ModelAndView garbageReportForm(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
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
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		mad.addObject("pagination",pagination);
		mad.addObject("list_CICompanycode",list_ggConfig);
		mad.setViewName("/dsmanager/garbageExport");
		return mad;
	}
	
	//经济公司导出综合报表
	@RequestMapping("/exportGarbage")
	public void exportGarbage(HttpServletResponse response,HttpServletRequest request) {
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String appliName = request.getParameter("startDate");//开始
		String insuredName = request.getParameter("endDate");//结束
		// 查询条件
		GuPolicyMain guPolicyMain = new GuPolicyMain();
		guPolicyMain.setProvince(province.equals("选择省份") ? "" : province);
		guPolicyMain.setCity(city.equals("选择城市") ? "" : city);
		guPolicyMain.setCounty(county.equals("选择区县") ? "" : county);
		guPolicyMain.setInsurerCode(inserdCode.equals("保险公司") ? "" : inserdCode);
		guPolicyMain.setAppliName(appliName.equals("选择开始日期") ? "" : appliName);
		guPolicyMain.setInsuredName(insuredName.equals("选择结束日期") ? "" : insuredName);
		try {
			OutputStream out = response.getOutputStream();
			//创建工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			//创建新的一页
			WritableSheet sheet = workbook.createSheet("综合报表", 0);
			//构造表头
			WritableFont bold = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);//设置字体种类和黑体显示,字体为Arial,字号大小为10,采用黑体显示
	        WritableCellFormat titleFormate = new WritableCellFormat(bold);//生成一个单元格样式控制对象
	        titleFormate.setAlignment(jxl.format.Alignment.CENTRE);//单元格中的内容水平方向居中
	        titleFormate.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//单元格的内容垂直方向居中
	        titleFormate.setBackground(jxl.format.Colour.YELLOW2); // 设置单元格的背景颜色
	        titleFormate.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //设置边框 
	        sheet.setRowView(0, 500, false);//设置第一行的高度
	        sheet.setRowView(1, 400, false);//设置第一行的高度
	        sheet.setColumnView(0, 15);
	        sheet.setColumnView(1, 15);
	        sheet.setColumnView(2, 15);
	        sheet.setColumnView(3, 15);
	        sheet.setColumnView(4, 15);
	        sheet.setColumnView(5, 15);
	        sheet.setColumnView(6, 15);
	        sheet.setColumnView(7, 15);
	        sheet.setColumnView(8, 15);
	        sheet.setColumnView(9, 15);
	        sheet.setColumnView(10, 15);
	        sheet.setColumnView(11, 15);
	        sheet.setColumnView(12, 15);
	        sheet.setColumnView(13, 15);
	        sheet.setColumnView(14, 15);
	        sheet.setColumnView(15, 15);
	        sheet.setColumnView(16, 15);
	        Label title=new Label(0,0,"保险公司",titleFormate);
	        Label title1=new Label(1,0,"省",titleFormate);
	        Label title2=new Label(2,0,"市",titleFormate);
	        Label title3=new Label(3,0,"区县",titleFormate);
	        Label title4=new Label(4,0,"保险公司业务",titleFormate);
	        Label title5=new Label(4,1,"企业数",titleFormate);
	        Label title6=new Label(5,1,"保单数",titleFormate);
	        Label title8=new Label(6,1,"保费金额(元)",titleFormate);
	        Label title9=new Label(7,1,"佣金金额(元)",titleFormate);
	        Label title10=new Label(8,0,"经纪公司业务",titleFormate);
	        Label title11=new Label(8,1,"企业数",titleFormate);
	        Label title12=new Label(9,1,"保单数",titleFormate);
	        Label title14=new Label(10,1,"保费金额(元)",titleFormate);
	        Label title15=new Label(11,1,"佣金金额(元)",titleFormate);
	        Label title16=new Label(12,0,"企业自投",titleFormate);
	        Label title17=new Label(12,1,"企业数",titleFormate);
	        Label title18=new Label(13,1,"保单数",titleFormate);
	        Label title20=new Label(14,1,"保费金额(元)",titleFormate);
	        Label title21=new Label(15,1,"佣金金额(元)",titleFormate);
	        Label title22=new Label(16,0,"事故预防费(元)",titleFormate);
	        sheet.addCell(title);
	        sheet.addCell(title1);
	        sheet.addCell(title2);
	        sheet.addCell(title3);
	        sheet.addCell(title4);
	        sheet.addCell(title5);
	        sheet.addCell(title6);
	        sheet.addCell(title8);
	        sheet.addCell(title9);
	        sheet.addCell(title10);
	        sheet.addCell(title11);
	        sheet.addCell(title12);
	        sheet.addCell(title14);
	        sheet.addCell(title15);
	        sheet.addCell(title16);
	        sheet.addCell(title17);
	        sheet.addCell(title18);
	        sheet.addCell(title20);
	        sheet.addCell(title21);
	        sheet.addCell(title22);
	        sheet.mergeCells(0, 0, 0, 1);//添加合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，第四个参数是终止行
	        sheet.mergeCells(1, 0, 0, 1);
	        sheet.mergeCells(2, 0, 0, 1);
	        sheet.mergeCells(3, 0, 0, 1);
	        sheet.mergeCells(4, 0, 7, 0);
	        sheet.mergeCells(8, 0, 11, 0);
	        sheet.mergeCells(12, 0, 15, 0);
	        sheet.mergeCells(16, 0, 0, 1);
	        // 查询信息
			List<Map<String, Object>> list = insurePolicyService.exportJuck(guPolicyMain);//全部
			guPolicyMain.setFlag("1");
			List<Map<String, Object>> list1 = insurePolicyService.exportJuck(guPolicyMain);//保险公司
			guPolicyMain.setUnderWriteFlag("0");
			guPolicyMain.setFlag("");
			List<Map<String, Object>> list2 = insurePolicyService.exportJuck(guPolicyMain);//经纪公司
			guPolicyMain.setUnderWriteFlag("");
			guPolicyMain.setFlag("");
			guPolicyMain.setPayFlag("2");
			List<Map<String, Object>> list3 = insurePolicyService.exportJuck(guPolicyMain);//企业自投
	        if(list.size()>0){
	        	for(int i=0;i<list.size();i++){
	        		Label row1 = new Label(0, i+2, (String) list.get(i).get("INSURERNAME"));
	        		sheet.addCell(row1);
	        		GgCode code = new GgCode();
		    		if(province!=null){
		    			code.setCodeType("Province");
		    			code.setCodeCode(guPolicyMain.getProvince());
		    			List<GgCode> list_pro = ggCodeService.getGgCodeByObj(code);
		    			Label row2 = new Label(1, i+2, list_pro.get(0).getCodeCName());
		    			sheet.addCell(row2);
		    		}
		    		if(city!=null&&!"选择城市".equals(city)){
		    			code.setCodeType("City");
		    			code.setCodeCode(guPolicyMain.getCity());
		    			List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
		    			Label row3 = new Label(2, i+2, list_city.get(0).getCodeCName());
		    			sheet.addCell(row3);
		    		}
		    		if(county!=null&&!"选择区县".equals(county)){
		    			code.setCodeType("County");
		    			code.setCodeCode(guPolicyMain.getCounty());
		    			List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);
		    			Label row4 = new Label(3, i+2, list_county.get(0).getCodeCName());
		    			sheet.addCell(row4);
		    		}
		    		for(int j=0;j<list1.size();j++){
		    			if(((String) list.get(i).get("INSURERNAME")).equals(((String) list1.get(j).get("INSURERNAME")))){
		    				BigDecimal tempValue = (BigDecimal) list1.get(j).get("ZONGBAOFEI");
		    				double temp1 = tempValue.doubleValue()*0.17;
		    				Label row5 = new Label(4, i+2, String.valueOf(list1.get(j).get("COMPANYSUM")));
		    				sheet.addCell(row5);
		    				Label row6 = new Label(5, i+2, String.valueOf(list1.get(j).get("POLICYSUM")));
		    				sheet.addCell(row6);
		    				Label row7 = new Label(6, i+2, String.valueOf(list1.get(j).get("ZONGBAOFEI")));
		    				sheet.addCell(row7);
		    				Label row8 = new Label(7, i+2, String.valueOf(temp1));
		    				sheet.addCell(row8);
		    			}
		    		}
		    		for(int k=0;k<list2.size();k++){
		    			if(((String) list.get(i).get("INSURERNAME")).equals(((String) list2.get(k).get("INSURERNAME")))){
		    				BigDecimal tempValue1 = (BigDecimal) list2.get(k).get("ZONGBAOFEI");
		    				double temp2 = tempValue1.doubleValue()*0.25;
		    				Label row9 = new Label(8, i+2, String.valueOf(list2.get(k).get("COMPANYSUM")));
		    				sheet.addCell(row9);
		    				Label row10 = new Label(9, i+2, String.valueOf(list2.get(k).get("POLICYSUM")));
		    				sheet.addCell(row10);
		    				Label row11 = new Label(10, i+2, String.valueOf(list2.get(k).get("ZONGBAOFEI")));
		    				sheet.addCell(row11);
		    				Label row12 = new Label(11, i+2, String.valueOf(temp2));
		    				sheet.addCell(row12);
		    			}
		    		}
		    		for(int x=0;x<list3.size();x++){
		    			if(((String) list.get(i).get("INSURERNAME")).equals(((String) list3.get(x).get("INSURERNAME")))){
		    				BigDecimal tempValue2 = (BigDecimal) list3.get(x).get("ZONGBAOFEI");
		    				double temp3 = tempValue2.doubleValue()*0.25;
		    				Label row13 = new Label(12, i+2, String.valueOf(list3.get(x).get("COMPANYSUM")));
		    				sheet.addCell(row13);
		    				Label row14 = new Label(13, i+2, String.valueOf(list3.get(x).get("POLICYSUM")));
		    				sheet.addCell(row14);
		    				Label row15 = new Label(14, i+2, String.valueOf(list3.get(x).get("ZONGBAOFEI")));
		    				sheet.addCell(row15);
		    				Label row16 = new Label(15, i+2, String.valueOf(temp3));
		    				sheet.addCell(row16);
		    			}
		    		}
		    		BigDecimal tempValuef = (BigDecimal) list.get(i).get("ZONGBAOFEI");
    				double tempf = tempValuef.doubleValue()*0.1;
		    		Label row17 = new Label(16, i+2, String.valueOf(tempf));
		    		sheet.addCell(row17);
	        	}
	        }
	        String fileName = "综合报表.xls";
	        String ieType = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest().getHeader("USER-AGENT");
	        if (ieType.indexOf("Firefox") > 0) {
				response.setHeader("Content-disposition", "attachment;fileName=\""
						+ new String(fileName.getBytes("GB2312"), "ISO-8859-1")
						+ "\"");
			} else {
				response.setHeader("Content-disposition", "attachment;fileName=\""
						+ URLEncoder.encode(fileName, "UTF-8") + "\"");
			}
			response.setContentType("application/msexcel;charset=UTF-8");
			workbook.write();
			workbook.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//经纪公司评价管理
	@RequestMapping("/pingjiaguanli")
	public ModelAndView pingjiaguanli(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = insurePolicyService.getPingJia(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.addObject("list_CICompanycode",list_ggConfig);
		mad.setViewName("/dsmanager/pingjiaguanli");
		return mad;
	}
	@RequestMapping("/getPing")
	// 查询保险公司评价
	public ModelAndView getPing(HttpServletRequest request, Model model) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String insurancecode = request.getParameter("inserdCode");
		String languagec = request.getParameter("languagec");
		conditionMap.put("insurancecode", insurancecode);
		conditionMap.put("languagec", languagec);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = insurePolicyService.getPingJia(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/dsmanager/queryPingjia");
		return mad;
	}
	
	// 查询保险公司评价
	@RequestMapping("/pingjiaContinue")
	public ModelAndView pingjiaContinue(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		pagination = (Pagination) insurePolicyService.getPingJiaCC(pagination);
		mad.addObject(pagination);
		mad.setViewName("/dsmanager/queryPingjia");
		return mad;
	}
	
	//经纪公司管理事故预防费
	@RequestMapping("/prometheus")
	public ModelAndView prometheus(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.findpromthous(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.setViewName("/dsmanager/promthous");
		return mad;
	}
	
	//经纪公司管理事故预防费结果
	@RequestMapping("/promthousResult")
	public ModelAndView promthousResult(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String flag = request.getParameter("languagec");
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		if("1".equals(flag)){
			map.put("flag", flag);
		}
		if("2".equals(flag)){
			map.put("flag2", flag);
		}
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.findpromthous(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.setViewName("/dsmanager/promthousResult");
		return mad;
	}
	
	//经纪公司管理事故预防费结果
	@RequestMapping("/promthousContinue")
	public ModelAndView promthousContinue(@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = commonweal.findpromthousContinue(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/dsmanager/promthousResult");
		return mad;
	}
	
	//事故预防费确认
	@RequestMapping("/addpromthous")
	public ModelAndView addpromthous(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String businessno = request.getParameter("businessno");
		commonweal.quePromthous(businessno);
		mad.setViewName("/dsmanager/showSuccess");
		return mad;
	}
	
	//经纪公司查询企业
	@RequestMapping("/companyQuery")
	public ModelAndView companyQuery(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
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
		/** 查询行业大类 **/
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = codeService.getGgCodeByObj(code);
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.companyQuery(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.addObject("list_classCode",list_classCode);
		mad.addObject("list_CICompanycode",list_ggConfig);
		mad.setViewName("/dsmanager/companyQuery");
		return mad;
	}

	//经纪公司查询企业
	@RequestMapping("/companyQueryResult")
	public ModelAndView companyQueryResult(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String qiyeming = request.getParameter("qiyeming");//企业名称
		String xinyongdaima = request.getParameter("xinyongdaima");//统一信用代码
		String whyInsure = request.getParameter("whyInsure");//是否投保
		Pagination pagination = new Pagination();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		map.put("companyName", qiyeming.equals("请输入企业名称") ? "" : qiyeming);
		map.put("businesslicenseNo", xinyongdaima.equals("请输入信用代码") ? "" : xinyongdaima);
		if("0".equals(whyInsure)){
			map.put("whyInsureT", "f");
		}
		if("1".equals(whyInsure)){
			map.put("whyInsureF", "a");
		}
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.companyQuery(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.setViewName("/dsmanager/companyQueryResult");
		return mad;
	}
	//经纪公司查询企业翻页
	@RequestMapping("/companyContinue")
	public ModelAndView companyContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
//		pagination = commonweal.companyQueryContinue(pagination);
		List<Map<String, Object>> list = commonweal.companyQuery(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
//		mad.setViewName("/dsmanager/preventive_costResult");
		mad.setViewName("/dsmanager/companyQueryResult");
		return mad;
	}
	
	//经济公司导出企业
	@RequestMapping("/exportCompany")
	public void exportCompany(HttpServletResponse response,HttpServletRequest request) {
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		String qiyeming = request.getParameter("qiyeming");//企业名称
		String xinyongdaima = request.getParameter("xinyongdaima");//统一信用代码
		String whyInsure = request.getParameter("whyInsure");//是否投保
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询条件
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		map.put("companyName", qiyeming.equals("请输入企业名称") ? "" : qiyeming);
		map.put("businesslicenseNo", xinyongdaima.equals("请输入信用代码") ? "" : xinyongdaima);
		if("0".equals(whyInsure)){
			map.put("whyInsureT", "f");
		}
		if("1".equals(whyInsure)){
			map.put("whyInsureF", "a");
		}
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(map);
		// 查询信息
		List<Map<String, Object>> list = commonweal.exportCompany(adapter);
		// 标题
		String[] titles = new String[] {"COMPANYNAME:企业名称","COMPANYADDRESS:地址",
				"LINKNAME:联系人","TELEPHONE:联系方式","BUSINESSLICENSENO:信用代码",
				"PROVINCE:省","CITY:城市","COUNTY:区县","INSURERCODE:保险公司",
				"CLASSCODE:行业大类", "BUSINESSNO:行业小类", "EMCOUNT:企业人数","APPLICODE:是否投保"
				};
		// 内容
		List<Map<String, Object>> lists = list;
		// 类型
		Class clas = Map.class;
		// sheet名
		String sheetName = "企业投保状况";
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}
	
	/**
	 * 经济公司查询投保单查询条件页面
	 * @return
	 */
	@RequestMapping("/getPeoplist")
	public ModelAndView getPeoplist() {
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
		List<GgCode> list_classCode = codeService.getGgCodeByObj(code1);
		Pagination pagination = new Pagination();
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = qymypolicy.getqymypolicyjj(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.addObject("list_classCode",list_classCode);
		mad.addObject("list_CICompanycode",list_ggConfig);
		mad.setViewName("/dsmanager/mypolicyCondition");
		return mad;
	}
	
	/**
	 * 经纪公司查询投保单
	 * @param request
	 * @return
	 */
	@RequestMapping("/mypolicyqueryjj")
	public ModelAndView mypolicqueryjj(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String insuredcode = request.getParameter("insuredcode");
		String languagec = request.getParameter("languagec");
		String languagea = request.getParameter("languagea");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
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
		conditionMap.put("inserdCode", inserdCode.equals("请选择保险公司") ? "" : inserdCode);
		conditionMap.put("insuredcode", insuredcode.equals("请输入企业名称") ? "": insuredcode);
		conditionMap.put("languagec", languagec);
		conditionMap.put("languagea", languagea);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = qymypolicy.getqymypolicyjj(pagination);
		
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/dsmanager/mypolicyResult");
		return mad;
	}
	
	@RequestMapping("/mypolicyjjPagin")
	public ModelAndView mypolicyjjPagin(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = qymypolicy.getqymypolicyjjPagination(pagination);
		mad.addObject(pagination);
		mad.setViewName("/dsmanager/mypolicyResult");
		return mad;
	}
	String SPECIALPROVISIONS = "";
	//经纪公司投保单查看
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
		request.setAttribute("standardLevelImg", guPolicyMain.getUnderDirections());
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
		mad.addObject("list_county", list_county == null ? "" : list_county.get(0).getCodeCName());
		mad.addObject("list_classCode", list_classCode == null ? "": list_classCode.get(0).getCodeCName());
		mad.addObject("list_businessClass",list_businessClass == null ? "": list_businessClass.get(0).getCodeCName());
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
		mad.setViewName("/dsmanager/mypolicyShowP");
		return mad;
	}
	
	//审核批单成功
	@RequestMapping( value="/myapplyAudit", consumes = "application/json")
	public void  myapplyAudit(@RequestBody JSONObject js){
		String bussiness = request.getParameter("id");
		String advice = js.getString("advice");
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("businessNo", bussiness);
		condition.put("special",SPECIALPROVISIONS);
		condition.put("advice", advice);
		try {
			PrintWriter pw = response.getWriter();
			mychecked.auditing(condition);
			pw.write(JSONObject.toJSONString("success"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//审核批单不通过
	@RequestMapping(value="myapplyAudited" , consumes = "application/json")
	public void myapplyAudited(@RequestBody JSONObject js){
		String  bussiness = request.getParameter("id");
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("businessNo", bussiness);
		condition.put("special",SPECIALPROVISIONS);
		try {
			PrintWriter pw = response.getWriter();
			mychecked.audited(condition);
			pw.write(JSONObject.toJSONString("success"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//提交金额、和批单
	@RequestMapping(value="/myapplygenerate",consumes = "application/json")
	public void myapplygenerate(@RequestBody JSONObject js){
		String endorsement = js.getString("endorsement");
		String calculation = js.getString("calculation");
		String  bussiness = request.getParameter("id");
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("businessNo", bussiness);
		condition.put("special",SPECIALPROVISIONS);
		condition.put("endorsement", endorsement);
		condition.put("calculation", calculation);
		try {
			PrintWriter pw = response.getWriter();
			mychecked.aditnumber(condition);
			pw.write(JSONObject.toJSONString("success"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/myapplydefary",consumes="application/json")
	public void myapplydefary(@RequestBody JSONObject js){
		String bussiness = js.getString("id");
		String endorsement = js.getString("endorsement");
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("businessNo", bussiness);
		condition.put("endorsement",endorsement);
		try {
			PrintWriter pw = response.getWriter();
			mychecked.defary(condition);
			pw.write(JSONObject.toJSONString("success"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//投保单修改
	@RequestMapping("/modfyPolicy")
	public ModelAndView modfyPolicy(HttpServletRequest request, Model model){
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String buiness = request.getParameter("businessno");
		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(buiness);
		guPolicyInsuredKey.setSeriesno(1L);
		GuPolicyInsured guPolicyInsured = insurePolicyService.selectByPrimaryKey(guPolicyInsuredKey);
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
		GgAmountRate ggAmountRate = new GgAmountRate();
		ggAmountRate.setScale(tempUser.getClassSize());
		ggAmountRate.setAmounttype("sumAmountV");
		List<GgAmountRate> ggAmountRateList = insurePolicyService
				.getAmountList(ggAmountRate);
		// 初始化续保时间
		Map<String, Object> resultMap = qymypolicy.getMypolicyModfy(buiness);
		GuPolicyMain guPolicyMain = insurePolicyService.selectByPrimaryKey3(buiness);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		Date endtime = guPolicyMain.getEndDate();
		Date sysdate = new Date(); // 获取系统时间+
		Date date = null;
		if (endtime.after(sysdate) || endtime.equals(sysdate)) { // 上单保险结束时间在系统时间之后-----在保期间内------续保日期应为保单的结束日期
			Calendar time = Calendar.getInstance();
			time.setTime(endtime);
			time.add(Calendar.DAY_OF_MONTH, 1);
			resultMap.put("ENDDATE", time.getTime());
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
		tempUser.setCity(guPolicyMain.getCity());
		GgCode code = new GgCode();
		code.setCodeType("Province");
		code.setCodeCode(guPolicyMain.getProvince());
		List<GgCode> list_pro = ggCodeService.getGgCodeByObj(code);
		code.setCodeCode(null);
		code.setCodeType("City");
		code.setRemark(guPolicyMain.getProvince());
		List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
		code.setCodeType("County");
		code.setRemark(guPolicyMain.getCity());
		List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);
		mad.addObject("TempCity",guPolicyMain.getCity());
		mad.addObject("TempCounty",guPolicyMain.getCounty());
		// 获取行业大类
		code = new GgCode();
		String classCode = tempUser.getClassCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
		mad.addObject("TempClassCode",tempUser.getClassCode());
		// 获取经营范围
		code.setCodeType("IndustryType");
		code.setRemark(classCode);
		List<GgCode> list_businessClass = ggCodeService.getGgCodeByObj(code);// 20
		mad.addObject("TempBusinessClass",tempUser.getBusinessClass());
		// 安全标准化等级
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		mad.addObject("TempStandardLevel",tempUser.getStandardLevel());
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
		mad.addObject("tempUser", tempUser);
		request.setAttribute("inPep", guPolicyInsured);
//			mad.addObject("resultMap", resultMap);
		session.setAttribute("resultMap", resultMap);
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(buiness);
		List<GuPolicyItemKind> guPolicyItemKinds = insurePolicyService.selectListByBusinessNo(guPolicyItemKind);
		PolicyManager policyManager = new PolicyManager();
		String sanAmount = "";
		for(int i=0;i<guPolicyItemKinds.size();i++){
			GuPolicyItemKind temp = guPolicyItemKinds.get(i);
			if("0901002".equals(temp.getKindcode()))policyManager.setItemOne("1");
			if("0901002".equals(temp.getKindcode()))sanAmount=String.valueOf(temp.getAmount());
			if("0901003".equals(temp.getKindcode()))policyManager.setItemTwo("1");
			if("0901004".equals(temp.getKindcode()))policyManager.setItemThree("1");
			if("0901005".equals(temp.getKindcode()))policyManager.setItemFour("1");
		}
		GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
		guPolicyEmployee.setBusinessNo(buiness);
		List<GuPolicyEmployee> ggEmployeeList = insurePolicyService.findEmployeeList(guPolicyEmployee);
		String tempPep = "";
		for(int j=0;j<ggEmployeeList.size();j++){
			GuPolicyEmployee employee = ggEmployeeList.get(j);
			tempPep+=employee.getPepName()+","+employee.getPepIdentityNo()+";";
		}
		request.setAttribute("tempPep", tempPep);
		request.setAttribute("sanAmount", sanAmount);
		request.setAttribute("standardLevelImg", guPolicyMain.getUnderWriteName());
		request.setAttribute("policyManagerItem", policyManager);
		List<Map<String, Object>> resultAddMap = qymypolicy
				.myPolicyAdditional(buiness);
		Map<String, Object> yearedMap = qymypolicy.myPolicyyeared(buiness);
		String plan = (String) yearedMap.get("PLANCODE");
		String[] plans;
		plans = plan.split("-");
		yearedMap.put("areaCode", plans[0]);
		yearedMap.put("insureCode", plans[1]);
		yearedMap.put("riskCode", yearedMap.get("RISKCODE"));
		yearedMap.put("status", 1);// 1.重新提交；2续保
		yearedMap.put("businessNo", buiness);
		mad.addObject("ggAmountRateList", ggAmountRateList);
		mad.addObject("policyManager", yearedMap);
		mad.addObject("resultAddMap", resultAddMap);// 附加险种查询
		mad.addObject("resultMap", resultMap);// 主险种和时间的查询
		mad.setViewName("/dsmanager/mycheckRenwal");
		return mad;
	}
	
	@RequestMapping("/insertPolicy")
	// 保险公司保单录入
	public String insertPolicy(HttpServletRequest request, Model model) {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgUserCorp ggUserCorp = ggUserCorpService.selectByPrimaryKey(ggUser
				.getUserCode());
		String areaCode = request.getParameter("areaCode");
		GgCode codeT = new GgCode();
		List<GgCode> list_pro = new ArrayList<GgCode>();
		List<GgCode> list_city = new ArrayList<GgCode>();
		List<GgCode> list_county = new ArrayList<GgCode>();
		
		codeT.setCodeType("Province");
		codeT.setCodeCode(ggUser.getProvince());
		list_pro = ggCodeService.getGgCodeByObj(codeT);
		
		codeT.setCodeType("City");
		codeT.setCodeCode(ggUser.getCity());
		codeT.setRemark(ggUser.getProvince());
		list_city = ggCodeService.getGgCodeByObj(codeT);
		
		codeT.setCodeType("County");
		codeT.setCodeCode(null);
//		codeT.setRemark(ggUser.getCity());
		codeT.setRemark(list_city.get(0).getCodeCode());
		list_county = ggCodeService.getGgCodeByObj(codeT);
		
		/*if("1".equals(ggUser.getComLevel())){
			codeT.setCodeType("Province");
			codeT.setCodeCode(ggUser.getProvince());
			list_pro = ggCodeService.getGgCodeByObj(codeT);
			codeT.setCodeType("City");
			codeT.setCodeCode(null);
			codeT.setRemark(ggUser.getProvince());
			list_city = ggCodeService.getGgCodeByObj(codeT);
		}else if("2".equals(ggUser.getComLevel())){
			codeT.setCodeType("Province");
			codeT.setCodeCode(ggUser.getProvince());
			list_pro = ggCodeService.getGgCodeByObj(codeT);
			codeT.setCodeType("City");
			codeT.setCodeCode(ggUser.getCity());
			codeT.setRemark(ggUser.getProvince());
			list_city = ggCodeService.getGgCodeByObj(codeT);
			codeT.setCodeType("County");
			codeT.setCodeCode(null);
//			codeT.setRemark(ggUser.getCity());
			codeT.setRemark(ggUser.getCity());
			list_county = ggCodeService.getGgCodeByObj(codeT);
		}else{
			codeT.setCodeType("Province");
			codeT.setCodeCode(ggUser.getProvince());
			list_pro = ggCodeService.getGgCodeByObj(codeT);
			codeT.setCodeType("City");
			codeT.setCodeCode(ggUser.getCity());
			list_city = ggCodeService.getGgCodeByObj(codeT);
			codeT.setCodeType("County");
			codeT.setCodeCode(ggUser.getCounty());
			list_county = ggCodeService.getGgCodeByObj(codeT);
		}*/
		model.addAttribute("list_pro", list_pro == null ? new ArrayList<GgCode>()
				: list_pro);
		model.addAttribute("list_city", list_city == null ? new ArrayList<GgCode>()
				: list_city);
		model.addAttribute("list_county", list_county == null ? new ArrayList<GgCode>()
				: list_county);
		PolicyManager policyManager = new PolicyManager();
		policyManager.setRiskCode("0901");
		policyManager.setAreaCode(areaCode);
		policyManager.setInsureCode(ggUser.getAddress());
		policyManager.setPepSum("0");
		String startDate = "";
		String endDate = "";
		String tempDate = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.DATE, 1);
		startDate = StringUtil.date2String(cal.getTime());
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
		date = curr.getTime();
		endDate = StringUtil.date2String(date);
		tempDate = startDate;
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		model.addAttribute("list_classCode",
				list_classCode == null ? new ArrayList<GgCode>()
						: list_classCode);
		model.addAttribute("list_safe", list_safe == null ? new ArrayList<GgCode>()
				: list_safe);
		model.addAttribute("policyManager", policyManager);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("tempDate", tempDate);
		model.addAttribute("ggUserCorp", ggUserCorp);
		return "getPolicying";
	}
	@RequestMapping("/conmpanyEdit")
	// 地区企业总数查询
	public String conmpanyEdit(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionAdapter adapter = new ConditionAdapter();
		map.put("level", "1");
		adapter.setQueryCondition(map);
		List<Map<String, Object>> list = insurePolicyService.selectCompanySum(adapter);
		map.put("level", "2");
		List<Map<String, Object>> list2 = insurePolicyService.selectCompanySum(adapter);
		int sum = 0;
		for(int i=0;i<list2.size();i++){
			sum = sum + Integer.valueOf((String) list2.get(i).get("COMPANY_SUM"));
		}
		request.setAttribute("xinjiang", sum);
		request.setAttribute("chengshi", list2);
		return "getCompanyS";
	}
	
	@RequestMapping("/conmpanyQQQ")
	// 地区的区县查询
	public String conmpanyQQQ(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionAdapter adapter = new ConditionAdapter();
		String codetape = request.getParameter("codes");
		map.put("level", "2");
		map.put("codes", codetape.substring(0, 4));
		adapter.setQueryCondition(map);
		List<Map<String, Object>> list = insurePolicyService.selectCompanySum(adapter);
		map.put("level", "3");
		List<Map<String, Object>> list2 = insurePolicyService.selectCompanySum(adapter);
		request.setAttribute("xinjiang", list);
		request.setAttribute("chengshi", list2);
		return "getCompanyE";
	}
	
	@RequestMapping("/conmpanySumAdd")
	// 地区的区县数据维护
	public String conmpanySumAdd(HttpServletRequest request, Model model) {
		String zongshu = request.getParameter("zongshu");
		String areaCode = request.getParameter("areaCode");
		String[] sumes = request.getParameterValues("sumes");
		String[] codeCode = request.getParameterValues("codeCode");
		GgCompanySum ggCompanySum = new GgCompanySum();
		for(int i=0;i<sumes.length;i++){
			ggCompanySum.setAreaCode(codeCode[i]);
			ggCompanySum.setCompanySum(sumes[i]);
			insurePolicyService.updateByPrimaryKeySelective(ggCompanySum);
		}
		ggCompanySum.setAreaCode(areaCode);
		ggCompanySum.setCompanySum(zongshu);
		insurePolicyService.updateByPrimaryKeySelective(ggCompanySum);
		return "showSuccess";
	}
	
	/**
	 * 投保单注销
	 * @param request
	 * @return
	 */
	@RequestMapping("/delPolicy")
	public ModelAndView delPolicy(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String businessno = request.getParameter("businessno");
		GuPolicyMain guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessno);
		guPolicyMain.setUnderWriteFlag("6");
		insurePolicyService.updateByPrimaryKeySelective(guPolicyMain);
		mad.setViewName("/dsmanager/showSuccess");
		return mad;
	}
	
	//评价删除
	@RequestMapping("/delPingJia")
	public ModelAndView delPingJia(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String businessno = request.getParameter("businessno");
		insurePolicyService.delPingjia(businessno);
		mad.setViewName("/dsmanager/showSuccess");
		return mad;
	}
	
	/**
	 * 查看报价
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getThisPreumin")
	// 报价单报价查询选择
	public String getThisPreumin(HttpServletRequest request, Model model) {
		String businessno = request.getParameter("businessno");
		GuPolicyInsurePremiumKey guPolicyInsurePremiumKey = new GuPolicyInsurePremiumKey();
		guPolicyInsurePremiumKey.setBusinessNo(businessno);
		List<GuPolicyInsurePremium> guPolicyInsurePremiumList = insurePolicyService.findInsurePremiumList(guPolicyInsurePremiumKey);
		model.addAttribute("guPolicyInsurePremiumList", guPolicyInsurePremiumList);
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
		GuPolicyInsurePremium guPolicyInsurePremium = insurePolicyService.selectByPrimaryKey(key);
		GuPolicyMain guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessNo);
		guPolicyMain.setSpreadsheetPremium(guPolicyInsurePremium.getSumPremium().doubleValue());
		guPolicyMain.setActualPremium(guPolicyInsurePremium.getSumPremium().doubleValue());
		guPolicyMain.setInsurerCode(insureCode);
		String planCode = guPolicyMain.getPlanCode();
		planCode = planCode.replace("TEMP", insureCode);
		guPolicyMain.setPlanCode(planCode);
		guPolicyMain.setUnderWriteFlag("3");
		GuPolicyFee guPolicyFee = insurePolicyService.selectByPrimaryKey(businessNo);
		guPolicyFee.setSpreadsheetpremium(guPolicyInsurePremium.getSumPremium());
		guPolicyFee.setActualpremium(guPolicyInsurePremium.getSumPremium());
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(businessNo);
		List<GuPolicyItemKind> guPolicyItemKindlist = insurePolicyService.selectListByBusinessNo(guPolicyItemKind);
		for(int i=0;i<guPolicyItemKindlist.size();i++){
			if("0901001".equals(guPolicyItemKindlist.get(i).getKindcode())){
				guPolicyItemKindlist.get(i).setActualpremium(guPolicyInsurePremium.getPremium());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(guPolicyInsurePremium.getPremium());
			}
			if("0901002".equals(guPolicyItemKindlist.get(i).getKindcode())){
				guPolicyItemKindlist.get(i).setActualpremium(guPolicyInsurePremium.getItemkindOne());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(guPolicyInsurePremium.getItemkindOne());
			}
			if("0901003".equals(guPolicyItemKindlist.get(i).getKindcode())){
				guPolicyItemKindlist.get(i).setActualpremium(guPolicyInsurePremium.getItemkindTwo());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(guPolicyInsurePremium.getItemkindTwo());
			}
			if("0901004".equals(guPolicyItemKindlist.get(i).getKindcode())){
				guPolicyItemKindlist.get(i).setActualpremium(guPolicyInsurePremium.getItemkindThree());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(guPolicyInsurePremium.getItemkindThree());
			}
			if("0901005".equals(guPolicyItemKindlist.get(i).getKindcode())){
				guPolicyItemKindlist.get(i).setActualpremium(guPolicyInsurePremium.getItemkindFour());
				guPolicyItemKindlist.get(i).setSpreadsheetpremium(guPolicyInsurePremium.getItemkindFour());
			}
		}
		insurePolicyService.updateTempBean(guPolicyMain,guPolicyFee,guPolicyItemKindlist);
		return "showSuccess";
	}
	
	@RequestMapping("/getMySon")
	// 查询企业所有员工
	public String getMySon(HttpServletRequest request, Model model) {
		String busNo = "";
		try {
			busNo = java.net.URLDecoder.decode(request.getParameter("gobibi"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("------------------编码转换失败!--------------------");
		}
		List<GgEmployee> ggEmployeeList = new ArrayList<GgEmployee>();
		String[] busNos = busNo.split(";");
		if(busNos.length>1){
			for(int i=0;i<busNos.length;i++){
				String[] temp = busNos[i].split(",");
				int flag = 0;
				for(int j=0;j<ggEmployeeList.size();j++){
					if(temp[1].equals(ggEmployeeList.get(j).getIdentityNo())){
						ggEmployeeList.get(j).setValidStatus("6");
						flag = 1;
					}
				}
				if(flag==0){
					GgEmployee employee = new GgEmployee();
					employee.setEmName(temp[0]);
					employee.setIdentityNo(temp[1]);
					employee.setValidStatus("6");
					ggEmployeeList.add(employee);
//					flag=1;
				}
			}
		}
		model.addAttribute("ggEmployeeList", ggEmployeeList);
		return "showPep";
	}
	
	/**
	 * 经纪公司业务员 保单录入-->下一步
	 * @param request
	 * @param policyManager
	 * @param model
	 * @param standardLevelImg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPlaceValueBatch")
	// 根据用户选择的方案计算保费(批量计算)
	public String getPlaceValueBatch(HttpServletRequest request,
			PolicyManager policyManager, Model model,@RequestParam MultipartFile standardLevelImg) throws Exception {


		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		
		session.setAttribute("policyManager", policyManager);
		session.setAttribute("standardLevelImg", standardLevelImg);//安全生产等级证照片
		session.setAttribute("pepSums", request.getAttribute("pepSums"));//从业人员信息
		
		
		
		//生成保单号
		String businessNo = new Long(new Date().getTime()).toString();
		businessNo += Long.toString(getRandom(100000000, 999999999));
		businessNo = businessNo.substring(0, 20);

		// 获取险种
		GgUser tempU = new GgUser();
		tempU.setProvince(policyManager.getProvince());
		tempU.setCity(policyManager.getCity());
		tempU.setCounty(policyManager.getCounty());
		List<GgRisk> ggRisks = insurePolicyService.findKind4Aera(tempU);
		
		//优惠系数
		double adjust = jiSuan.getAdjust(policyManager.getStandardLevel());
		

		//获取可投保的保险公司
//		String riskCode = "0901";
//		policyManager.setRiskCode(riskCode);
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
//		ggInsureConfig.setRiskCode(riskCode);
		ggInsureConfig.setRiskCode(policyManager.getRiskCode());
		ggInsureConfig.setAreaCode(ggRisks.get(0).getAreacode());
		List<GgInsureConfig> ggInsureConfigs = ggInsureConfigService.getInsurance(ggInsureConfig);
	
		/**
		 * 组织保险公司明细和总价位(GgInsuranceDetail)  和    保险公司费用跟单表(GuPolicyInsurePremium)
		 */
		//循环查询保险公司计算保费
		List<GgInsuranceDetail> ggInsuranceDetailList = new ArrayList<GgInsuranceDetail>();//保险公司报价显示页面用
		//保险公司价位表
		List<GuPolicyInsurePremium> guPolicyInsurePremiumList = new ArrayList<GuPolicyInsurePremium>();
		
		for(int son=0;son<ggInsureConfigs.size();son++){
			
			//获取保险公司明细(13家的第"son"家)(用于showValue页面显示保险公司及总给英)
			GgInsuranceDetailKey ggInsuranceDetailKey = new GgInsuranceDetailKey();
			ggInsuranceDetailKey.setInsurancecode(ggInsureConfigs.get(son).getInsuranceCode());
			ggInsuranceDetailKey.setRiskcode(ggInsureConfigs.get(son).getRiskCode());
			GgInsuranceDetail ggInsuranceDetail = insurePolicyService.selectByPrimaryKey(ggInsuranceDetailKey);
			
			//组织保险费用跟单表
			GuPolicyInsurePremium guPolicyInsurePremium = new GuPolicyInsurePremium(); 
			guPolicyInsurePremium.setBusinessNo(businessNo);
			guPolicyInsurePremium.setValNo(String.valueOf(son));
			guPolicyInsurePremium.setInsureCode(ggInsuranceDetail.getInsurancecode());
			
			if("1".equals(ggInsureConfigs.get(son).getFlag())){//人工报价
				//组织showValue页面的总保额和保险公司信息
				ggInsuranceDetail.setRemark("待报价");
				ggInsuranceDetailList.add(ggInsuranceDetail);
				
				//组织保险费用跟单表
				guPolicyInsurePremiumList.add(guPolicyInsurePremium);
				continue;
			}

			// 计算附加险保费
			double allPremium = 0.00;
			
			GgKind ggKind = new GgKind();
  			ggKind.setRiskcode(policyManager.getRiskCode());
			ggKind.setAreacode(ggRisks.get(0).getAreacode());
			ggKind.setKindename(policyManager.getBusinessClass());
			ggKind.setInsurancecode(ggInsuranceDetail.getInsurancecode());
			List<GgKind> ggKindList = insurePolicyService.getGgKindList(ggKind); // 获取险别费率
			for (int i = 0; i < ggKindList.size(); i++) {
				
				if (i == 0) {// 主险
					//每人主险保费
					policyManager.setInsureCode(ggInsureConfigs.get(son).getInsuranceCode());
					BigDecimal everyoneMainPremium  = jiSuan.getEveryoneMainPremium(policyManager);
					//主险总保费
					BigDecimal mainPremium = everyoneMainPremium.multiply(
											BigDecimal.valueOf(Double.valueOf(policyManager.getPepSum()))) ;
					allPremium += Double.valueOf(mainPremium.toString());
					
					guPolicyInsurePremium.setPremium(mainPremium);
					continue;
				}
				if ("on".equals(policyManager.getItemOne()) && i == 1) {//三者
					Double sanamount = Double.valueOf(request.getParameter("sanamount"));//三者总限额
					double sanZhePremium = jiSuan.getSanZhePremium(sanamount, adjust, ggKindList.get(i));
					allPremium += sanZhePremium ;
					
					guPolicyInsurePremium.setItemkindOne(BigDecimal.valueOf(sanZhePremium));
				}
				if ("on".equals(policyManager.getItemTwo()) && i == 2) {//医疗
					double yiLiaoPremium = jiSuan.getYiLiaoPremium(
							policyManager.getSumAmount(), adjust, ggKindList.get(i));
					allPremium += yiLiaoPremium ;
					
					guPolicyInsurePremium.setItemkindTwo(BigDecimal.valueOf(yiLiaoPremium));
				}
				if ("on".equals(policyManager.getItemThree()) && i == 3) {//救援
					double jiuYuanPremium = jiSuan.getJiuYuanPremium(
							policyManager.getSumAmount(), adjust, ggKindList.get(i));
					allPremium += jiuYuanPremium;
					
					guPolicyInsurePremium.setItemkindThree(BigDecimal.valueOf(jiuYuanPremium));
				}
				if ("on".equals(policyManager.getItemFour()) && i == 4) {//法律
					double faLvPremium = jiSuan.getFaLvPremium(
							policyManager.getSumAmount(), adjust, ggKindList.get(i));
					allPremium += faLvPremium ;
					
					guPolicyInsurePremium.setItemkindFour(BigDecimal.valueOf(faLvPremium));
				}
				
			}
		
			String strAllPremium = (BigDecimal.valueOf(allPremium)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
			ggInsuranceDetail.setRemark(strAllPremium);
			ggInsuranceDetailList.add(ggInsuranceDetail);
			
			guPolicyInsurePremium.setSumPremium(BigDecimal.valueOf(allPremium));
			guPolicyInsurePremium.setFlag("1");
			guPolicyInsurePremiumList.add(guPolicyInsurePremium);
		}
		
		/*****组织保险公司明细和总价位(GgInsuranceDetail)  和    保险公司费用跟单表(GuPolicyInsurePremium)END*****/
		
		request.setAttribute("ggInsuranceDetailList", ggInsuranceDetailList);
		session.setAttribute("guPolicyInsurePremiumList", guPolicyInsurePremiumList);
	
		return "showValue";
	}
	
	/**
	 * 插入报价单(提交报价)
	 * @param request
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertPolicyTemp")
	public String insertPolicyTemp(HttpServletRequest request, Model model)  {
		
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		
		MultipartFile standardLevelImg = (MultipartFile) session.getAttribute("standardLevelImg");
		
		PolicyManager policyManager = (PolicyManager) session.getAttribute("policyManager");
		
		List<GuPolicyInsurePremium> guPolicyInsurePremiumList
			=  (List<GuPolicyInsurePremium>) session.getAttribute("guPolicyInsurePremiumList");
		
		//取报价表里生成的业务号
		String businessNo = guPolicyInsurePremiumList.get(0).getBusinessNo();
		
		// 获取险种
		GgUser tempU = new GgUser();
		tempU.setProvince(policyManager.getProvince());
		tempU.setCity(policyManager.getCity());
		tempU.setCounty(policyManager.getCounty());
		List<GgRisk> ggRisks = insurePolicyService.findKind4Aera(tempU);
		
		/**
		 * 组织guPolicyMain表(保单主信息表)
		 */
		// 跟单主表传值
		GuPolicyMain guPolicyMain = new GuPolicyMain();
		guPolicyMain.setBusinessNo(businessNo);
//		guPolicyMainT.setProposalNo();
//		guPolicyMainT.setPolicyNo();
//		if (renewalFlag.size() > 0) {// 上一年保单号
//			guPolicyMain.setPreviousPolicyNo(renewalFlag.get(renewalFlag.size() - 1).getPolicyNo());
//		}
//		guPolicyMainT.setPayBillNo(payBillNo);
//		guPolicyMainT.setClassCode(classCode);
		guPolicyMain.setRiskCode(policyManager.getRiskCode());//险种代码
		//地区代码-保险公司代码-每人主限额-总主限额
		guPolicyMain.setPlanCode(ggRisks.get(0).getAreacode() + "-"
				+ "TEMP" + "-"
				+ policyManager.getAmount() + "-"
				+ policyManager.getSumAmount());
		
		guPolicyMain.setAppliCode("");
		guPolicyMain.setAppliName(policyManager.getAlName());
		guPolicyMain.setAppliAddress(policyManager.getAlAddress());
		
		guPolicyMain.setInsuredCode("");
		guPolicyMain.setInsuredName(policyManager.getInName());
		guPolicyMain.setInsuredAddress(policyManager.getInAddress());
		
		try {
			guPolicyMain.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.parse(sim.format(policyManager.getStartDate()) + " 00:00:00"));
			guPolicyMain.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.parse(sim.format(policyManager.getEndDate()) + " 23:59:59"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		guPolicyMain.setCurrency(policyManager.getPepSum());//投保人数
		guPolicyMain.setSumAmount(Double.valueOf(policyManager.getSumAmount()));//总保额
//		guPolicyMainT.setDisCount(adjust);//总折扣率
//		guPolicyMainT.setSumDiscount(sumDiscount);//总折扣金额
//		guPolicyMainT.setSpreadsheetPremium(spreadsheetPremium);//试算保费
//		guPolicyMainT.setActualPremium(actualPremium);//实际保费
//		guPolicyMainT.setSumPremium(sumPremium);//总保费
//		guPolicyMainT.setSumSubPrem(sumSubPrem);//附加险总保费
		guPolicyMain.setArgueSolution(policyManager.getToTalk());//争议方式:1:诉讼2:仲裁
		guPolicyMain.setArbitBoardName(policyManager.getToTalkName());//仲裁委员会名称
//		guPolicyMainT.setEndorseTimes(endorseTimes);//批改次数
//		guPolicyMainT.setInsureTimes(insureTimes);//投保次数
		guPolicyMain.setOperatorCode(ggUser.getUserCode());//操作人
		guPolicyMain.setOperateDate(new Date());//操作时间
//		guPolicyMainT.setSignDate(signDate);//签单时间
//		guPolicyMainT.setUpdatorCode(updatorCode);//更新人
//		guPolicyMainT.setUpdateDate(updateDate);//更新时间
//		guPolicyMainT.setUnderWriteCode(underWriteCode);//核保人代码
		String fiString = standardLevelImg.getOriginalFilename();
		if (fiString != null && !"".equals(fiString)) {//安全标准化等级证
			guPolicyMain.setUnderWriteName(FileUtil.uploadFile(standardLevelImg, request));//核保人名称(暂存被保人安全等级证照片地址)
		}
//		guPolicyMainT.setUnderWriteEndDate(underWriteEndDate);//核保日期
//		guPolicyMainT.setUnderDirections(underDirections);//核保意见
		guPolicyMain.setUnderWriteFlag("5");//核保状态(1:待审核)
		guPolicyMain.setPayFlag("0");//支付状态
//		guPolicyMainT.setRenewalFlag(renewalFlag);//续保 0否1是
//		guPolicyMainT.setInsurerCode(policyManager.getInsureCode());//保险公司代码
		guPolicyMain.setProvince(policyManager.getProvince());
		guPolicyMain.setCity(policyManager.getCity());
		guPolicyMain.setCounty(policyManager.getCounty());
//		guPolicyMainT.setCorrectPremium(correctPremium);//批改保费
//		guPolicyMainT.setCorrectNo(correctNo);//批改号
//		guPolicyMainT.setCorrectDate(correctDate);//批改日期
		guPolicyMain.setFlag("0");//经济公司业务标志
		guPolicyMain.setRemark(ggUser.getUpdator());//暂存上级代码
//		guPolicyMainT.setAccidentPreventFee();//事故预防费
//		guPolicyMainT.setSpecialprovisions(specialprovisions);//特殊约定
		
		/*****组织guPolicyMain表(保单主信息表)END*****/
		
		/**
		 * 组织跟单GuPolicyInsured表(关系人表)
		 */
		List<GuPolicyInsured> guPolicyInsuredList = new ArrayList<GuPolicyInsured>();
		//投保人信息
		GuPolicyInsured guPolicyInsured = new GuPolicyInsured();
		guPolicyInsured.setBusinessno(businessNo);
		guPolicyInsured.setPolicyno("");
		guPolicyInsured.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured.setSeriesno(1L);
		guPolicyInsured.setInsuredtype(policyManager.getAlSafetyLicenseNo());
		guPolicyInsured.setInsuredcode("");
		guPolicyInsured.setInsuredname(policyManager.getAlName());
		guPolicyInsured.setInsuredaddress(policyManager.getAlAddress());
		guPolicyInsured.setInsuredflag(String.valueOf(1L));
//				guPolicyInsuredT.setIdentitytype(identitytype);//证件类型无
		guPolicyInsured.setIdentitynumber(policyManager.getAlBusinessLicenseNo());
		guPolicyInsured.setLinkname(policyManager.getAlLinkName());
		guPolicyInsured.setPhonenumber(policyManager.getAlTelePhone());
		guPolicyInsured.setEmail(policyManager.getAlEmail());
		guPolicyInsured.setFlag("");
		guPolicyInsured.setRemark("");
		guPolicyInsuredList.add(guPolicyInsured);
		//被保险人信息
		GuPolicyInsured guPolicyInsured1 = new GuPolicyInsured();
		guPolicyInsured1.setBusinessno(businessNo);
		guPolicyInsured1.setPolicyno(policyManager.getStandardLevel());
		guPolicyInsured1.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured1.setSeriesno(2L);
		guPolicyInsured1.setInsuredtype(policyManager.getInSafetyLicenseNo());
		guPolicyInsured1.setInsuredcode("");
		guPolicyInsured1.setInsuredname(policyManager.getInName());
		guPolicyInsured1.setInsuredaddress(policyManager.getInAddress());
		guPolicyInsured1.setInsuredflag(String.valueOf(1L));
//				guPolicyInsured1T.setIdentitytype(identitytype);//证件类型无
		guPolicyInsured1.setIdentitynumber(policyManager.getInBusinessLicenseNo());
		guPolicyInsured1.setLinkname(policyManager.getInLinkName());
		guPolicyInsured1.setPhonenumber(policyManager.getInTelePhone());
		guPolicyInsured1.setEmail(policyManager.getInEmail());
		guPolicyInsured1.setFlag(policyManager.getBusinessClass());
		guPolicyInsured1.setRemark(policyManager.getClassCode());
		guPolicyInsuredList.add(guPolicyInsured1);
		
		/****组织跟单GuPolicyInsured表(关系人表)END*****/
		
		/**
		 * 处理跟单GuPolicyEmployee表(人员表)
		 */
//		String[] pepList = request.getParameter("pepSums").split(";");
//		String[] pepList = ((String)session.getAttribute("pepSums")).split(";");
		String[] pepList = policyManager.getPepSums().split(";");
		List<GuPolicyEmployee> guPolicyEmployeeList = new ArrayList<GuPolicyEmployee>();
		for(int q=0;q<pepList.length;q++){
			GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
			String[] tempList = pepList[q].split(",");
			guPolicyEmployee.setBusinessNo(businessNo);
			guPolicyEmployee.setPepNo(String.valueOf(q));
			guPolicyEmployee.setPepName(tempList[0]);
			guPolicyEmployee.setPepIdentityNo(tempList[1]);
			guPolicyEmployeeList.add(guPolicyEmployee);
		}
		
		/****处理跟单GuPolicyEmployee表(人员表)END****/
		
		
//		GuPolicyMain guPolicyMain = (GuPolicyMain) session.getAttribute("guPolicyMainT");
//		GuPolicyFee guPolicyFee = (GuPolicyFee) session.getAttribute("guPolicyFeeT");
//		GuPolicyAdjustRate guPolicyAdjustRate = (GuPolicyAdjustRate) session.getAttribute("guPolicyAdjustRateT");
//		List<GuPolicyItemKind> guPolicyItemKindList = (List<GuPolicyItemKind>) session.getAttribute("guPolicyItemKindListT");
//		List<GuPolicyLimit> guPolicyLimitList = (List<GuPolicyLimit>) session.getAttribute("guPolicyLimitListT");
//		List<GuPolicyInsured> guPolicyInsuredList 
//			= (List<GuPolicyInsured>) session.getAttribute("guPolicyInsuredListT");
//		List<GuPolicyEmployee> guPolicyEmployeeList
//			= (List<GuPolicyEmployee>) session.getAttribute("guPolicyEmployeeListT");
//		List<GuPolicyInsurePremium> guPolicyInsurePremiumList
//			= (List<GuPolicyInsurePremium>) session.getAttribute("guPolicyInsurePremiumList");
		
//		for(int i = 0 ; i < guPolicyInsurePremiumList.size() ; i++) {
//			guPolicyInsurePremiumMapper.insert(guPolicyInsurePremiumList.get(i));
//		}
		
		// 调用带有事务的插入方法
//		insurePolicyService.insertAll(guPolicyMain, guPolicyFee, guPolicyAdjustRate, guPolicyItemKindList,
//								guPolicyLimitList, guPolicyInsuredList,guPolicyEmployeeList,guPolicyInsurePremiumList);
		insurePolicyService.insertAll(guPolicyMain, null, null, null,
				null, guPolicyInsuredList,guPolicyEmployeeList,guPolicyInsurePremiumList);
//		return "showSuccess";
//		return "/qiye/mypolicy/mypolicyCondition";//跳转至我的订单
		return "/dsmanager/mypolicyCondition";//跳转至我的订单
	} 
	@RequestMapping("/claimShow")
	// 查看理赔详情
	public String claimShow(HttpServletRequest request, Model model) {
		String businessno = request.getParameter("businessno");
		Pagination pagination = new Pagination();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("policyno", businessno.equals("选择省份") ? "" : businessno);
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.claimListQuery(pagination);
		pagination.setResultList(list);
		request.setAttribute("pagination",pagination);
		return "showclaim";
	}
	
	/**
	 * 经纪公司业务员 确认投保跳至此
	 * @param request
	 * @param policyManager
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getPlaceValue")
	// 根据用户选择的方案计算保费
	public String getPlaceValue(HttpServletRequest request,
			/*PolicyManager policyManager,*/ Model model) throws Exception {
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");//用户信息
		
		String insureCode = request.getParameter("insureCode");//要投保的保险公司代码
		
		//从session中获取保险公司价位集合表
		List<GuPolicyInsurePremium> guPolicyInsurePremiumList
			= (List<GuPolicyInsurePremium>) session.getAttribute("guPolicyInsurePremiumList");
		
		GuPolicyInsurePremium guPolicyInsurePremium = null;//取出用户选择的保险公司价目表
		for(GuPolicyInsurePremium g : guPolicyInsurePremiumList) {
			if(insureCode.equals(g.getInsureCode())) {
				guPolicyInsurePremium = g;
				break;
			}
		}
		
		MultipartFile standardLevelImg = (MultipartFile) session.getAttribute("standardLevelImg");//安全生产等级证照片
		
		PolicyManager policyManager = (PolicyManager) session.getAttribute("policyManager");//从保单录入页面获取policyManager
		policyManager.setInsureCode(insureCode);//需要用policyManager计算某个保险公司的保费,所以放上某个保险公司的代码
		
		//优惠系数
		double adjust = jiSuan.getAdjust(policyManager.getStandardLevel());
		
		//生成保单号
		String businessNo = guPolicyInsurePremium.getBusinessNo();
		
		// 获取险别费率(险种)
		GgUser tempU = new GgUser();
		tempU.setProvince(policyManager.getProvince());
		tempU.setCity(policyManager.getCity());
		tempU.setCounty(policyManager.getCounty());
		List<GgRisk> ggRisks = insurePolicyService.findKind4Aera(tempU);
		
		
		/**
		 * 组织guPolicyItemKind表(险别表)
		 */
		List<GuPolicyItemKind> guPolicyItemKindList = new ArrayList<GuPolicyItemKind>();
		
		//获取险别种类(险种的小险种:如安责险-->主险,三者,医疗,救援,法律)
		GgKind ggKind = new GgKind();
		ggKind.setRiskcode(policyManager.getRiskCode());
		ggKind.setAreacode(ggRisks.get(0).getAreacode());
		ggKind.setKindename(policyManager.getBusinessClass());
		ggKind.setInsurancecode(policyManager.getInsureCode());
		List<GgKind> ggKindList = insurePolicyService.getGgKindList(ggKind);
		
		for(int i = 0 ; i < ggKindList.size() ; i++ ) {
			GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
			guPolicyItemKind.setBusinessno(businessNo);
//			guPolicyItemKind.setPolicyno(policyno);//还没提交保单所以没有保单号
			guPolicyItemKind.setRiskcode(policyManager.getRiskCode());
			guPolicyItemKind.setStartdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.parse(sim.format(policyManager.getStartDate()) + " 00:00:00"));
			guPolicyItemKind.setEnddate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.parse(sim.format(policyManager.getEndDate()) + " 23:59:59"));
			guPolicyItemKind.setKindcode(ggKindList.get(i).getKindcode());
			guPolicyItemKind.setKindname(ggKindList.get(i).getKindcname());
			
			if (i == 0) {// 主险
				//每人主险保费
				BigDecimal everyone = jiSuan.getEveryoneMainPremium(policyManager);
				guPolicyItemKind.setSpreadsheetpremium(guPolicyInsurePremium.getPremium()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setActualpremium(guPolicyInsurePremium.getPremium()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setAmount(new BigDecimal(policyManager.getSumAmount())
						.setScale(2, BigDecimal.ROUND_HALF_UP));
//				guPolicyItemKind.setRate(rate);//费率?应该存什么费率?
//				guPolicyItemKind.setDiscount(discount);//折扣?
				guPolicyItemKind.setUnitamount(new BigDecimal(policyManager.getAmount())
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setUnitpremium(everyone.setScale(2, BigDecimal.ROUND_HALF_UP));//每人保费
//				guPolicyItemKind.setQuantity(quantity);?
//				guPolicyItemKind.setFlag(flag);?
//				guPolicyItemKind.setRemark(remark);?
				guPolicyItemKindList.add(guPolicyItemKind);
				
				policyManager.setPr(guPolicyInsurePremium.getPremium().toString());
			}
			if ("on".equals(policyManager.getItemOne()) && i == 1) {//附加第三者为单独的限额
//				double sanZhePremium = jiSuan.getSanZhePremium(Double.valueOf(policyManager.getSanamount()), adjust, ggKindList.get(i));
//				sumPrice += sanZhePremium;
				guPolicyItemKind.setSpreadsheetpremium(guPolicyInsurePremium.getItemkindOne()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setActualpremium(guPolicyInsurePremium.getItemkindOne()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setAmount(new BigDecimal(policyManager.getSanamount())
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()))
						.setScale(2, BigDecimal.ROUND_HALF_UP));
//				guPolicyItemKind.setUnitpremium(everyone);//每人保费
				guPolicyItemKindList.add(guPolicyItemKind);
				
				policyManager.setItemOne(guPolicyInsurePremium.getItemkindOne().toString());
			}
			if ("on".equals(policyManager.getItemTwo()) && i == 2) {//医疗
//				double yiLiaoPremium = jiSuan.getYiLiaoPremium(policyManager.getSumAmount(), adjust, ggKindList.get(i));
//				sumPrice += yiLiaoPremium;
				guPolicyItemKind.setSpreadsheetpremium(guPolicyInsurePremium.getItemkindTwo()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setActualpremium(guPolicyInsurePremium.getItemkindTwo()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setAmount(new BigDecimal(Double.valueOf(policyManager.getSumAmount()) * 0.3)
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()) * 0.3)
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKindList.add(guPolicyItemKind);
				
				policyManager.setItemTwo(guPolicyInsurePremium.getItemkindTwo().toString());
			}
			if ("on".equals(policyManager.getItemThree()) && i == 3) {//救援
//				double jiuYuanPremium = jiSuan.getJiuYuanPremium(policyManager.getSumAmount(), adjust, ggKindList.get(i));
//				sumPrice += jiuYuanPremium;
				guPolicyItemKind.setSpreadsheetpremium(guPolicyInsurePremium.getItemkindThree()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setActualpremium(guPolicyInsurePremium.getItemkindThree()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setAmount(new BigDecimal(Double.valueOf(policyManager.getSumAmount()) * 0.3)
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()) * 0.3)
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKindList.add(guPolicyItemKind);
				
				policyManager.setItemThree(guPolicyInsurePremium.getItemkindThree().toString());
			}
			if ("on".equals(policyManager.getItemFour()) && i == 4) {//法律
//				double faLvPremium = jiSuan.getFaLvPremium(policyManager.getSumAmount(), adjust, ggKindList.get(i));
//				sumPrice += faLvPremium;
				guPolicyItemKind.setSpreadsheetpremium(guPolicyInsurePremium.getItemkindFour()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setActualpremium(guPolicyInsurePremium.getItemkindFour()
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setAmount(new BigDecimal(Double.valueOf(policyManager.getSumAmount()) * 0.05)
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()) * 0.05)
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				guPolicyItemKindList.add(guPolicyItemKind);
				
				policyManager.setItemFour(guPolicyInsurePremium.getItemkindFour().toString());
			}
		
			
		}
		
		session.setAttribute("guPolicyItemKindList", guPolicyItemKindList);
		/******组织guPolicyItemKind表END*******/
		
		/**
		 * 组织guPolicyMain表(保单主信息表)
		 */
		// 跟单主表传值
		GuPolicyMain guPolicyMain = new GuPolicyMain();
		guPolicyMain.setBusinessNo(businessNo);
//		guPolicyMainT.setProposalNo();
//		guPolicyMainT.setPolicyNo();
//		if (renewalFlag.size() > 0) {// 上一年保单号
//			guPolicyMain.setPreviousPolicyNo(renewalFlag.get(renewalFlag.size() - 1).getPolicyNo());
//		}
//		guPolicyMainT.setPayBillNo(payBillNo);
//		guPolicyMainT.setClassCode(classCode);
		guPolicyMain.setRiskCode(policyManager.getRiskCode());//险种代码
		//地区代码-保险公司代码-每人主限额-总主限额
		guPolicyMain.setPlanCode(ggRisks.get(0).getAreacode() + "-"
				+ policyManager.getInsureCode() + "-"
				+ policyManager.getAmount() + "-"
				+ policyManager.getSumAmount());
		
		guPolicyMain.setAppliCode("");
		guPolicyMain.setAppliName(policyManager.getAlName());
		guPolicyMain.setAppliAddress(policyManager.getAlAddress());
		
		guPolicyMain.setInsuredCode("");
		guPolicyMain.setInsuredName(policyManager.getInName());
		guPolicyMain.setInsuredAddress(policyManager.getInAddress());
		
		guPolicyMain.setStartDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.parse(sim.format(policyManager.getStartDate()) + " 00:00:00"));
		guPolicyMain.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.parse(sim.format(policyManager.getEndDate()) + " 23:59:59"));
		guPolicyMain.setCurrency(policyManager.getPepSum());//投保人数
		guPolicyMain.setSumAmount(Double.valueOf(policyManager.getSumAmount()));//总保额
		guPolicyMain.setDisCount(adjust);//总折扣率
//		guPolicyMainT.setSumDiscount(sumDiscount);//总折扣金额
		guPolicyMain.setSpreadsheetPremium(guPolicyInsurePremium.getSumPremium()
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());//试算保费
		guPolicyMain.setActualPremium(guPolicyInsurePremium.getSumPremium()
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());//实际保费
//		guPolicyMainT.setSumPremium(sumPremium);//总保费
//		guPolicyMainT.setSumSubPrem(sumSubPrem);//附加险总保费
		guPolicyMain.setArgueSolution(policyManager.getToTalk());//争议方式:1:诉讼2:仲裁
		guPolicyMain.setArbitBoardName(policyManager.getToTalkName());//仲裁委员会名称
//		guPolicyMainT.setEndorseTimes(endorseTimes);//批改次数
//		guPolicyMainT.setInsureTimes(insureTimes);//投保次数
		guPolicyMain.setOperatorCode(ggUser.getUserCode());//操作人
		guPolicyMain.setOperateDate(new Date());//操作时间
//		guPolicyMainT.setSignDate(signDate);//签单时间
//		guPolicyMainT.setUpdatorCode(updatorCode);//更新人
//		guPolicyMainT.setUpdateDate(updateDate);//更新时间
//		guPolicyMainT.setUnderWriteCode(underWriteCode);//核保人代码
		String fiString = standardLevelImg.getOriginalFilename();
		if (fiString != null && !"".equals(fiString)) {//安全标准化等级证
			guPolicyMain.setUnderWriteName(FileUtil.uploadFile(standardLevelImg, request));//核保人名称(暂存被保人安全等级证照片地址)
		}
//		guPolicyMainT.setUnderWriteEndDate(underWriteEndDate);//核保日期
//		guPolicyMainT.setUnderDirections(underDirections);//核保意见
		guPolicyMain.setUnderWriteFlag("1");//核保状态(1:待审核)
		guPolicyMain.setPayFlag("0");//支付状态
//		guPolicyMainT.setRenewalFlag(renewalFlag);//续保 0否1是
		guPolicyMain.setInsurerCode(policyManager.getInsureCode());//保险公司代码
		guPolicyMain.setProvince(policyManager.getProvince());
		guPolicyMain.setCity(policyManager.getCity());
		guPolicyMain.setCounty(policyManager.getCounty());
//		guPolicyMainT.setCorrectPremium(correctPremium);//批改保费
//		guPolicyMainT.setCorrectNo(correctNo);//批改号
//		guPolicyMainT.setCorrectDate(correctDate);//批改日期
		guPolicyMain.setFlag("0");//经济公司业务标志
		guPolicyMain.setRemark(ggUser.getUpdator());//暂存上级代码
		guPolicyMain.setAccidentPreventFee(guPolicyInsurePremium.getSumPremium().multiply(new BigDecimal("0.1"))
				.setScale(2, BigDecimal.ROUND_HALF_UP));//事故预防费
//		guPolicyMainT.setSpecialprovisions(specialprovisions);//特殊约定
		
		session.setAttribute("guPolicyMain", guPolicyMain);
		/*****组织guPolicyMain表(保单主信息表)END*****/
	
		/**
		 * 组织guPolicyFee表(保单费用表)
		 */
		// 跟单fee表传值-------------这个信息也是不全的需要到具体投某个保险公司的时候才能确定
		GuPolicyFee guPolicyFee = new GuPolicyFee();
		guPolicyFee.setBusinessno(businessNo);
		guPolicyFee.setRiskcode(policyManager.getRiskCode());//险种代码
//		guPolicyFeeT.setPolicyno("");//暂时无保单号
//		guPolicyFeeT.setCurrency(currency);//币种代码
		guPolicyFee.setAmount(BigDecimal.valueOf(Double.valueOf(policyManager.getSumAmount())));//总保额
		guPolicyFee.setSpreadsheetpremium(guPolicyInsurePremium.getSumPremium()
				.setScale(2, BigDecimal.ROUND_HALF_UP));//试算保费
		guPolicyFee.setActualpremium(guPolicyInsurePremium.getSumPremium()
				.setScale(2, BigDecimal.ROUND_HALF_UP));//实际保费
		
		session.setAttribute("guPolicyFee", guPolicyFee);
		/*****组织guPolicyFee表(保单费用表)END******/
		
		
		/**
		 *  跟单guPolicyAdjustRate表(费率表)
		 */
		GuPolicyAdjustRate guPolicyAdjustRate = new GuPolicyAdjustRate();
		
		guPolicyAdjustRate.setBusinessno(businessNo);
		
		Double everyoneRate = jiSuan.getEveryoneRate(policyManager.getAmount(), policyManager.getInsureCode());
		guPolicyAdjustRate.setAmountadjust(everyoneRate.toString());//每人费率
		
		guPolicyAdjustRate.setSumamountadjust("1.00");//累计费率
		
		Double shortRate = jiSuan.getShortRate(policyManager.getStartDate(), policyManager.getEndDate());
		guPolicyAdjustRate.setShortrate(shortRate.toString());//短期费率
		
		guPolicyAdjustRate.setRenewalrate("1.00");//续保折扣
		guPolicyAdjustRate.setLossrate("1.00");//企业事故折扣费率
		
		Double safeLevelRate = jiSuan.getSafeLevelRate(policyManager.getStandardLevel());
		guPolicyAdjustRate.setStandardlevelrate(safeLevelRate.toString());//安全等级标准费率
		
		session.setAttribute("guPolicyAdjustRate", guPolicyAdjustRate);
		/********跟单guPolicyAdjustRate表(费率表)END**********/
		
		
		/**
		 * 跟单guPolicyLimit表(限额表)
		 */
		List<GuPolicyLimit> guPolicyLimitList = new ArrayList<GuPolicyLimit>();
		GuPolicyLimit guPolicyLimit = new GuPolicyLimit();
		guPolicyLimit.setBusinessno(businessNo);
		guPolicyLimit.setRiskcode(policyManager.getRiskCode());//险种代码
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
		
		session.setAttribute("guPolicyLimitList", guPolicyLimitList);
		/*****跟单guPolicyLimit表(限额表)END*******/
		
		
		/**
		 * 组织跟单GuPolicyInsured表(关系人表)
		 */
		List<GuPolicyInsured> guPolicyInsuredList = new ArrayList<GuPolicyInsured>();
		//投保人信息
		GuPolicyInsured guPolicyInsured = new GuPolicyInsured();
		guPolicyInsured.setBusinessno(businessNo);
		guPolicyInsured.setPolicyno("");
		guPolicyInsured.setRiskcode("-");
		guPolicyInsured.setSeriesno(1L);
		guPolicyInsured.setInsuredtype(policyManager.getInSafetyLicenseNo());
		guPolicyInsured.setInsuredcode("");
		guPolicyInsured.setInsuredname(policyManager.getInName());
		guPolicyInsured.setInsuredaddress(policyManager.getInAddress());
		guPolicyInsured.setInsuredflag(String.valueOf(1L));
//				guPolicyInsuredT.setIdentitytype(identitytype);//证件类型无
		guPolicyInsured.setIdentitynumber(policyManager.getInBusinessLicenseNo());
		guPolicyInsured.setLinkname(policyManager.getInLinkName());
		guPolicyInsured.setPhonenumber(policyManager.getInTelePhone());
		guPolicyInsured.setEmail(policyManager.getInEmail());
		guPolicyInsured.setFlag("");
		guPolicyInsured.setRemark("");
		guPolicyInsuredList.add(guPolicyInsured);
		//被保险人信息
		GuPolicyInsured guPolicyInsured1 = new GuPolicyInsured();
		guPolicyInsured1.setBusinessno(businessNo);
		guPolicyInsured1.setPolicyno(policyManager.getStandardLevel());
		guPolicyInsured1.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured1.setSeriesno(2L);
		guPolicyInsured1.setInsuredtype(policyManager.getAlSafetyLicenseNo());
		guPolicyInsured1.setInsuredcode("");
		guPolicyInsured1.setInsuredname(policyManager.getAlName());
		guPolicyInsured1.setInsuredaddress(policyManager.getAlAddress());
		guPolicyInsured1.setInsuredflag(String.valueOf(1L));
//				guPolicyInsured1T.setIdentitytype(identitytype);//证件类型无
		guPolicyInsured1.setIdentitynumber(policyManager.getAlBusinessLicenseNo());
		guPolicyInsured1.setLinkname(policyManager.getAlLinkName());
		guPolicyInsured1.setPhonenumber(policyManager.getAlTelePhone());
		guPolicyInsured1.setEmail(policyManager.getAlEmail());
		guPolicyInsured1.setFlag(policyManager.getBusinessClass());
		guPolicyInsured1.setRemark(policyManager.getClassCode());
		guPolicyInsuredList.add(guPolicyInsured1);
		
		session.setAttribute("guPolicyInsuredList", guPolicyInsuredList);
		/****组织跟单GuPolicyInsured表(关系人表)END*****/
		
		/**
		 * 处理跟单GuPolicyEmployee表(人员表)
		 */
//		String[] pepList = request.getParameter("pepSums").split(";");
//		String[] pepList = ((String)session.getAttribute("pepSums")).split(";");
		String[] pepList = policyManager.getPepSums().split(";");
		List<GuPolicyEmployee> guPolicyEmployeeList = new ArrayList<GuPolicyEmployee>();
		for(int q=0;q<pepList.length;q++){
			GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
			String[] tempList = pepList[q].split(",");
			guPolicyEmployee.setBusinessNo(businessNo);
			guPolicyEmployee.setPepNo(String.valueOf(q));
			guPolicyEmployee.setPepName(tempList[0]);
			guPolicyEmployee.setPepIdentityNo(tempList[1]);
			guPolicyEmployeeList.add(guPolicyEmployee);
		}
		
		session.setAttribute("guPolicyEmployeeList", guPolicyEmployeeList);
		/****处理跟单GuPolicyEmployee表(人员表)END****/
		
		
		GgCode code = new GgCode();
		code.setCodeType("Province");
		code.setCodeCode(policyManager.getProvince());
		List<GgCode> list_pro = ggCodeService.getGgCodeByObj(code);
		code.setCodeType("City");
		code.setCodeCode(policyManager.getCity());
		List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
		code.setCodeType("County");
		code.setCodeCode(policyManager.getCounty());
		List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);
		// 获取行业大类
		code = new GgCode();
		String classCode = policyManager.getClassCode();
		code.setCodeType("IndustryCategories");
		code.setCodeCode(policyManager.getClassCode());
		List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
		// 获取经营范围
		code.setCodeType("IndustryType");
		code.setRemark(classCode);
		code.setCodeCode(policyManager.getBusinessClass());
		List<GgCode> list_businessClass = ggCodeService.getGgCodeByObj(code);// 20
		// 安全标准化等级
		GgCode code1 = new GgCode();
		code1.setCodeType("StandardLevel");
		code1.setCodeCode(policyManager.getStandardLevel());
		List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);
		
		request.setAttribute("list_pro", list_pro);
		request.setAttribute("list_city", list_city);
		request.setAttribute("list_county",list_county);
		request.setAttribute("list_classCode", list_classCode);
		request.setAttribute("list_businessClass", list_businessClass);
		request.setAttribute("list_safe", list_safe);
		
		BigDecimal sumPremium = guPolicyInsurePremium.getSumPremium();
		String uppercasSumPremium = StringUtil.number2CNMontrayUnit(sumPremium);
		request.setAttribute("zbf", sumPremium.setScale(2, BigDecimal.ROUND_HALF_UP));//总保费
		policyManager.setSumPr(uppercasSumPremium);//总保费大写
	
		return "showPolicy";
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
	 * 经纪公司提交投保单跳转至ci
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertPolicyEnd")
	// 根据用户选择的保险公司插入投保单
	public String insertPolicyEnd(HttpServletRequest request, Model model) {
		String paymentFlag = request.getParameter("paymentFlag");
		GuPolicyMain guPolicyMain = (GuPolicyMain) session.getAttribute("guPolicyMain");
		
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setInsuranceCode(guPolicyMain.getInsurerCode());
		String flag = ggInsureConfigService.getInsurance(ggInsureConfig).get(0).getFlag();
		
		if("2".equals(flag)){
			guPolicyMain.setUnderWriteFlag("3");
		}
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
		List<GuPolicyEmployee> guPolicyEmployeeList = (List<GuPolicyEmployee>) session.getAttribute("guPolicyEmployeeList");
		
		String businessNOee = (String) session.getAttribute("businessNO");
		String status = (String) session.getAttribute("status");// 1.重新递交保单 // 2.续保
//		String businessNOee = request.getParameter("businessNOee");
//		String status = request.getParameter("status");// 1.重新递交保单 // 2.续保
		// 调用带有事务的插入方法
		insurePolicyService.insertAll(guPolicyMain, guPolicyFee, guPolicyAdjustRate, 
					guPolicyItemKindList, guPolicyLimitList, guPolicyInsuredList,guPolicyEmployeeList);
		if ("1".equals(status)) {// 修改保单
			guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessNOee);
			guPolicyMain.setUnderWriteFlag("6");
			guPolicyMain.setUpdateDate(new Date());
			GgUser ggUser = (GgUser) session.getAttribute("ggUser");
			guPolicyMain.setUpdatorCode(ggUser.getUserCode());
//			insurePolicyService.deleteByPrimaryKey2(businessNOee);
			insurePolicyService.updateByPrimaryKeySelective(guPolicyMain);
		 }
		
		
		 if("2".equals(flag)){
			 Map<String, Object> conditionMap = new HashMap<String, Object>();
				conditionMap.put("paymentCardType", "03");
				List<GgPaymentConfig> list = ggPaymentConfigService
						.getPayCom(conditionMap);

				List<GpMainOrder> mainList = gpMainOrderService
						.selectByBusinessNo(guPolicyMain.getBusinessNo());
				List<GpOrderDetail> orderDetail = detailService
						.selectByMainInMerchantOrderNo(guPolicyMain.getBusinessNo());

				if (orderDetail.size() > 0) {
					detailService.deleteByBusinessNo(guPolicyMain.getBusinessNo());
				}
				if (mainList.size() > 0) {
					gpMainOrderService.deleteByBusinessNo(guPolicyMain.getBusinessNo());
				}
				
				String merchantNo = Apply.proread("p1_MerId");
				
				// 插入订单主表
				GpMainOrder gpMainOrder = new GpMainOrder();
				gpMainOrder.setBusinessNo(guPolicyMain.getBusinessNo());
				gpMainOrder.setMerchantNo(merchantNo);
				gpMainOrder.setMerchantOrderNo(String.valueOf(new Date().getTime()));
				gpMainOrder.setUpdateTime(new Date());
				gpMainOrderService.insertMainOrder(gpMainOrder);
				// 插入订单明细表
				GpOrderDetail detail = new GpOrderDetail();
				detail.setBusinessNo(gpMainOrder.getMerchantOrderNo());
				detail.setOrderNo(gpMainOrder.getMerchantOrderNo());
				detail.setDealDate(new Date());
				detail.setOrderCurrency("CNY");
				detail.setOrderAmount(guPolicyMain.getSpreadsheetPremium());
				detailService.insertOrederDetail(detail);
				session.setAttribute("resultList", list);
				session.setAttribute("gpOrderDetail", detail);
				session.setAttribute("businessNo", guPolicyMain.getBusinessNo());
				return "/payment/preparePay";
		 }
		 if("3".equals(flag)) {//提交自动核保接口  出结果
			 	InsuranceSingleResponse service = new InsuranceSingleResponse();
				try {
					 service = submitInsure.autoUnderwriting(guPolicyMain,guPolicyItemKindList, guPolicyEmployeeList);
				} catch (Exception e) {
					e.printStackTrace();
					Map<String,Object> censor = new HashMap<String, Object>();
	     			censor.put("underdirections", "系统繁忙,请稍后再试.");//其他错误原因
	     			censor.put("business", guPolicyMain.getBusinessNo());//可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
	     			censor.put("underwriteflag", "2");
	     			client.updateCensor(censor);
					return "showError";
				}
				String requestType = service.getResponseCode();
				if("0".equals(requestType)){
					String proposal = service.getProposalNo();
					Map<String,Object> condition = new HashMap<String,Object>();
					condition.put("buseiness" , guPolicyMain.getBusinessNo());
					condition.put("signTime", new Date());
					condition.put("proposal", proposal);
					detailService.updateproposal(condition);
				
					return "showSuccess";
				}else{
					Map<String,Object> censor = new HashMap<String, Object>();
	     			censor.put("underdirections", service.getResponseName());//其他错误原因
	     			censor.put("business", guPolicyMain.getBusinessNo());//可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
	     			censor.put("underwriteflag", "2");
	     			client.updateCensor(censor);
					return "showError";
				}
				
		 }
		 if("4".equals(flag)){//提交人工核保接口 审核出结果
			 
			 ManualUnderwriteResponse service = new ManualUnderwriteResponse();
				try {
					 service = submitInsure.manualUnderwriting(
							 guPolicyMain,
							 guPolicyItemKindList,
							 guPolicyEmployeeList);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
				String requestType = service.getResponseCode();
				if("0".equals(requestType)){
					String proposal = service.getProposalNo();
					String sign = service.getSendDateTime();
					Date signTime = null;
					try {
						SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						signTime = sim.parse(sign);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Map<String,Object> condition = new HashMap<String,Object>();
					condition.put("buseiness" , guPolicyMain.getBusinessNo());
					condition.put("signTime", signTime);
					condition.put("proposal", proposal);
					detailService.updateproposal(condition);
					return "showSuccess";
				}else{
					Map<String,Object> censor = new HashMap<String, Object>();
	     			censor.put("underdirections", service.getResponseName());//返回失败显示错误信息
	     			censor.put("business", guPolicyMain.getBusinessNo());//可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
	     			censor.put("underwriteflag", "2");
	     			client.updateCensor(censor);
					return "showError";
				}
				
			 
		 }
		return "showError";
	}
	
	@RequestMapping(value = "/getArea")
	public void getArea(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String remark = obj.getString("remark");
		List<GgCode> list = codeService.getGgCodeList(remark);
		String areaList = "";
		areaList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(areaList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getClassCode")
	public void getClassCode(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String remark = obj.getString("remark");
		List<GgCode> list = codeService.getIndustryCode(remark);
		String codeList = "";
		codeList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(codeList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getGgCodeByObj")
	public void getGgCodeByObj(GgCode ggCode, HttpServletResponse response) {
		List<GgCode> list = codeService.getGgCodeByObj(ggCode);
		String codeList = "";
		codeList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(codeList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 经纪公司预防事故费查询初始化
	 * @author HSLT
	 * @return
	 */
	@RequestMapping("/preventive")
	public ModelAndView getWeal() {
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
		/** 查询行业大类 **/
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list_classCode = codeService.getGgCodeByObj(code);
		
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.selectDsManager_commonweal(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		
		/** 查询保险公司名称 **/
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
		
		mad.addObject("list_classCode",list_classCode);
		mad.addObject("list_CICompanycode",list_ggConfig);
		code = new GgCode();
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
		mad.setViewName("/dsmanager/preventive_cost");
		return mad;
	}
	
	/***
	 * 经纪公司用户事故预防费点击“查询”方法
	 * @author HSLT
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryPreventive")
	public ModelAndView queryPreventive(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		Pagination pagination = new Pagination();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = commonweal.selectDsManager_commonweal(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination",pagination);
		mad.setViewName("/dsmanager/preventive_costResult");
		return mad;

	}
	/**
	 * 报表下载
	 * @author HSLT
	 * @param response
	 */
	@RequestMapping("/exportToExcel")
	public void exportExcel(HttpServletResponse response,HttpServletRequest request) {
		String province = request.getParameter("province1");
		String city = request.getParameter("city1");
		String county = request.getParameter("county1");
		String classCode = request.getParameter("classCode");//行业大类
		String businessClass = request.getParameter("businessClass");//行业小类
		String inserdCode = request.getParameter("inserdCode");//保险公司
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询条件
		map.put("province", province.equals("选择省份") ? "" : province);
		map.put("city", city.equals("选择城市") ? "" : city);
		map.put("county", county.equals("选择区县") ? "" : county);
		map.put("classCode", classCode.equals("选择行业大类") ? "" : classCode);
		map.put("businessClass", businessClass.equals("选择行业小类") ? "" : businessClass);
		map.put("inserdCode", inserdCode.equals("保险公司") ? "" : inserdCode);
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(map);
		// 查询信息
		List<Map<String, Object>> list_Preventive = commonweal.getDsManagerPreventiveToExc(adapter);
		// 标题
		String[] titles = new String[] {
				"PROVINCE:省","CITY:城市","COUNTY:区县","INSURERCODE:保险公司", "POLICYNO:保单号",
				"CLASSCODE:行业大类", "BUSINESSNO:行业小类", "SPREADSHEETPREMIUM:保费金额(元)","ACCIDENTPREVENTFEE:预防费用总金额(元)"
				};
		// 内容
		List<Map<String, Object>> lists = list_Preventive;
		// 类型
		Class clas = Map.class;
		// sheet名
		String sheetName = "预防费用状况";
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}
	
	/***
	 * 经纪公司预防费分页
	 * @author HSLT
	 * @param pageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/PreventiveContinue")
	public ModelAndView evaluateReportUsercorpContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = commonweal.getPreventiveContinue(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/dsmanager/preventive_costResult");
		return mad;
	}

	/**
	 * 经纪公司线下出单调用接口
	 * @return
	 */
	@RequestMapping("/underLine")
	public ModelAndView underLine(){
		ModelAndView mad = new ModelAndView();
		String businessnos = request.getParameter("businessno");
		
		//获取保险公司投保方式 1:待报价 2:自动出单 3:自动出结果 4:人工出结果
		GuPolicyMain guPolicyMain = mainMapper.selectByPrimaryKey(businessnos);
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setInsuranceCode(guPolicyMain.getInsurerCode());
		String flag = ggInsureConfigService.getInsurance(ggInsureConfig).get(0).getFlag();
		
		int successOrFailed = 0; //0失败  1:成功

		if("2".equals(flag)) {//提交自动接口出单接口
			GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
			guPolicyItemKind.setBusinessno(businessnos);
			guPolicyItemKind.setKindcode("0901001");
			List<GuPolicyItemKind> selectListByBusinessNo = 
					guPolicyItemKindService.selectListByBusinessNo(guPolicyItemKind);
			BigDecimal unitamount = selectListByBusinessNo.get(0).getUnitamount();
			
//			if("YGBX".equals(guPolicyMain.getInsurerCode())) {//阳光保险(YGBX)的每人限额40万(包括)以上的走自动核保出结果
//				 if(unitamount.compareTo(BigDecimal.valueOf(400000.0)) == 1) {
//					 successOrFailed = insureAfter.underWriteAfter(businessnos);
//				 }else {
//					 successOrFailed = insureAfter.insuranceSingle(businessnos);
//				 }
//			}else {
				successOrFailed = insureAfter.insuranceSingle(businessnos);
//			}
			
		}
		if("3".equals(flag) || "4".equals(flag)) { 
			successOrFailed = insureAfter.underWriteAfter(businessnos);
		}
		
		if(1 == successOrFailed ){
			mad.setViewName("/insurePolicy/showSuccess");
		}else{
			mad.setViewName("/insurePolicy/showError");
		}
		return mad;
	}
	

	@RequestMapping("/getPolicying")
	public String getPoilcying(HttpServletRequest request, Model model) {
		
		String buiness = request.getParameter("businessno");
		
		// 初始化续保时间
		Map<String, Object> resultMap = qymypolicy.getMypolicyNOShow(buiness);
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		Date endtime = (Date) resultMap.get("ENDDATE");
		Date sysdate = new Date(); // 获取系统时间

		Date date = null;
		if (endtime.after(sysdate) || endtime.equals(sysdate)) { // 上单保险结束时间在系统时间之后-----在保期间内------续保日期应为保单的结束日期
			Calendar time = Calendar.getInstance();
			time.setTime(endtime);
			time.add(Calendar.DAY_OF_MONTH, 1);
			resultMap.put("ENDDATE", time.getTime());
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
		
		
		
		
		GuPolicyMain guPolicyMain = guPolicyMainMapper.selectByPrimaryKey(buiness);//保险单主信息
		
		GuPolicyInsuredKey key = new GuPolicyInsuredKey();//投保人key
		key.setBusinessno(buiness);
		key.setSeriesno((long) 1);
		GuPolicyInsured toubaoren = guPolicyInsuredService.selectByPrimaryKey(key);//投保人
		
		GuPolicyInsuredKey key2 = new GuPolicyInsuredKey();//被保人key
		key2.setBusinessno(buiness);
		key2.setSeriesno((long) 2);
		GuPolicyInsured beibaoren = guPolicyInsuredService.selectByPrimaryKey(key2);//被保人
		
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();//被保人下的险别
		guPolicyItemKind.setBusinessno(buiness);
		List<GuPolicyItemKind> itemKinds = guPolicyItemKindService.selectListByBusinessNo(guPolicyItemKind);	
		
		
		model.addAttribute("guPolicyMain", guPolicyMain);
	
		return "getPolicying";
		
	}
	

	

	/**
	 * 经纪公司修改完保单提交出单接口
	 * 
	 */
	@RequestMapping("/callBack")
	public String callBack() {
		
		String flag = "showError";
		
		String businessnos = (String) request.getParameter("businessno");
		
		try {
			GuPolicyMain m = mainMapper.selectByPrimaryKey(businessnos);
			if (m.getProposalNo()!=null) {
				flag = insureAfter.underWriteAfter(businessnos) == 1 ? "showSuccess" : "showError";
			}else {
				flag = insureAfter.insuranceSingle(businessnos) == 1 ? "showSuccess" : "showError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "showError";
		}
		
		return flag;
	}

	/**
	 * 经纪公司业务"重新提交"跳转至此
	 * @param businessno
	 * @return
	 */
	@RequestMapping("/dsResubmit")
	public String dsResubmit(@RequestParam String businessno) {
		String message = "showError";
		GuPolicyMain guPolicyMain = guPolicyMainMapper.selectByPrimaryKey(businessno);
		
		//保险公司的配置标识 flag : 投保的流程(详见数据库gginsureConfig-->flag)
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setInsuranceCode(guPolicyMain.getInsurerCode());
		String flag = ggInsureConfigService.getInsurance(ggInsureConfig).get(0).getFlag();
		
		//支付状态 0:未缴费 1:已缴费
		String payFlag = guPolicyMain.getPayFlag();
		
		if("2".equals(flag) ){
			if("0".equals(payFlag)) {
				
				Map<String, Object> conditionMap = new HashMap<String, Object>();
				conditionMap.put("paymentCardType", "03");
				List<GgPaymentConfig> list = ggPaymentConfigService
						.getPayCom(conditionMap);
				
				List<GpMainOrder> mainList = gpMainOrderService
						.selectByBusinessNo(guPolicyMain.getBusinessNo());
				List<GpOrderDetail> orderDetail = detailService
						.selectByMainInMerchantOrderNo(guPolicyMain.getBusinessNo());
				
				if (orderDetail.size() > 0) {
					detailService.deleteByBusinessNo(guPolicyMain.getBusinessNo());
				}
				if (mainList.size() > 0) {
					gpMainOrderService.deleteByBusinessNo(guPolicyMain.getBusinessNo());
				}
				
				String merchantNo = Apply.proread("p1_MerId");
				
				// 插入订单主表
				GpMainOrder gpMainOrder = new GpMainOrder();
				gpMainOrder.setBusinessNo(guPolicyMain.getBusinessNo());
				gpMainOrder.setMerchantNo(merchantNo);
				gpMainOrder.setMerchantOrderNo(String.valueOf(new Date().getTime()));
				gpMainOrder.setUpdateTime(new Date());
				gpMainOrderService.insertMainOrder(gpMainOrder);
				// 插入订单明细表
				GpOrderDetail detail = new GpOrderDetail();
				detail.setBusinessNo(gpMainOrder.getMerchantOrderNo());
				detail.setOrderNo(gpMainOrder.getMerchantOrderNo());
				detail.setDealDate(new Date());
				detail.setOrderCurrency("CNY");
				detail.setOrderAmount(guPolicyMain.getSpreadsheetPremium());
				detailService.insertOrederDetail(detail);
				session.setAttribute("resultList", list);
				session.setAttribute("gpOrderDetail", detail);
				session.setAttribute("businessNo", guPolicyMain.getBusinessNo());
				return "/payment/preparePay";
			}else {
				return insureAfter.insuranceSingle(businessno) == 1 ? "showSuccess" : "showError";
			}
		 }
		 if("3".equals(flag)) {//提交自动核保接口  出结果
			 	InsuranceSingleResponse service = new InsuranceSingleResponse();
				try {
					 service = submitInsure.autoUnderwriting(businessno);
				} catch (Exception e) {
					e.printStackTrace();
					Map<String,Object> censor = new HashMap<String, Object>();
	     			censor.put("underdirections", "系统繁忙,请稍后再试.");//其他错误原因
	     			censor.put("business", guPolicyMain.getBusinessNo());//可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
	     			censor.put("underwriteflag", "2");
	     			client.updateCensor(censor);
					return "showError";
				}
				String requestType = service.getResponseCode();
				if("0".equals(requestType)){
					String proposal = service.getProposalNo();
					Map<String,Object> condition = new HashMap<String,Object>();
					condition.put("buseiness" , guPolicyMain.getBusinessNo());
					condition.put("signTime", new Date());
					condition.put("proposal", proposal);
					detailService.updateproposal(condition);
					
					//修改审核状态"1"通过
					GuPolicyMain guPolicyMain2 = new GuPolicyMain();
					guPolicyMain2.setBusinessNo(businessno);
					guPolicyMain2.setUnderWriteFlag("1");
					guPolicyMainService.updateByPrimaryKeySelective(guPolicyMain2);
				
					return "showSuccess";
				}else{
					Map<String,Object> censor = new HashMap<String, Object>();
	     			censor.put("underdirections", service.getResponseName());//其他错误原因
	     			censor.put("business", guPolicyMain.getBusinessNo());//可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
	     			censor.put("underwriteflag", "2");
	     			client.updateCensor(censor);
					return "showError";
				}
				
		 }
		 if("4".equals(flag)){//提交人工核保接口 审核出结果
			 
			 ManualUnderwriteResponse service = new ManualUnderwriteResponse();
				try {
					 service = submitInsure.manualUnderwriting(businessno);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
				String requestType = service.getResponseCode();
				if("0".equals(requestType)){
					String proposal = service.getProposalNo();
					String sign = service.getSendDateTime();
					Date signTime = null;
					try {
						SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						signTime = sim.parse(sign);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Map<String,Object> condition = new HashMap<String,Object>();
					condition.put("buseiness" , guPolicyMain.getBusinessNo());
					condition.put("signTime", signTime);
					condition.put("proposal", proposal);
					detailService.updateproposal(condition);
					
					//修改审核状态"1"待审核
					GuPolicyMain guPolicyMain2 = new GuPolicyMain();
					guPolicyMain2.setBusinessNo(businessno);
					guPolicyMain2.setUnderWriteFlag("1");
					guPolicyMainService.updateByPrimaryKeySelective(guPolicyMain2);
					
					return "showSuccess";
				}else{
					Map<String,Object> censor = new HashMap<String, Object>();
	     			censor.put("underdirections", service.getResponseName());//返回失败显示错误信息
	     			censor.put("business", guPolicyMain.getBusinessNo());//可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
	     			censor.put("underwriteflag", "2");
	     			client.updateCensor(censor);
					return "showError";
				}
			 
		 }
		
		return message;
	}
	
	/**
	 *  判断两个日期是否大于一年  ,附加判断公司是否有有效保单
	 * @param obj
	 * @param response
	 */
	@RequestMapping("/getDateYear")
	public void getDateYear(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String startDate = obj.getString("startDate");
		String endDate = obj.getString("endDate");
		String alName = obj.getString("alName");
		String alBusinessLicenseNo = obj.getString("alBusinessLicenseNo");
		
		//根据公司名称alName 和  统一社会信用代码 查找是否已经有有效保单
		List<String> havePolicyByIdentityNumber = guPolicyMainService.isHavePolicyByIdentityNumber(alBusinessLicenseNo);
		
		try {
			
			//判断日期
			SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
			Date start = sim.parse(startDate);
			Date end = sim.parse(endDate);
			boolean flag = new StringUtil().isOneYear(start, end);
			String dateFlag = "";
			if(!flag){
				dateFlag = "1";
			}
			
			if(havePolicyByIdentityNumber.size() > 0) {
				dateFlag = "2";
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
	

}
