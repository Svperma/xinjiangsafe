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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dsib.common.Pagination;
import com.dsib.dao.GgUserMapper;
import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.dao.GuWebClientMapper;
import com.dsib.entity.GgAmountRate;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;
import com.dsib.entity.GgInsureConfig;
import com.dsib.entity.GgKind;
import com.dsib.entity.GgKindPrice;
import com.dsib.entity.GgKindPriceKey;
import com.dsib.entity.GgRisk;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyFee;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;
import com.dsib.entity.PolicyManager;
import com.dsib.service.GcClaimService;
import com.dsib.service.GgAdministrationService;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgInsureConfigService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GpOrderDetailService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.InsurePolicyService;
import com.dsib.service.QyMycheckService;
import com.dsib.service.QyMypolicyService;
import com.dsib.service.ToJudgeService;
import com.dsib.submitInterface.SubmitInsureAfterUtil;
import com.dsib.submitInterface.SubmitInsureUtil;
import com.dsib.submitInterface.SubmitPayment;
import com.dsib.util.CheckImprotPolicy;
import com.dsib.util.DateUtils;
import com.dsib.util.FileUtil;
import com.dsib.util.Md5Util;
import com.dsib.util.StringUtil;
import com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleResponse;
import com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteResponse;

/**
 * 经济公司用户专用
 */
@Controller
@RequestMapping("/policyUser")
@SessionAttributes("pagination")
public class PolicyUserController extends BaseController {

	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggUserCorpService;
	@Resource(name = "QyMyPolicy")
	private QyMypolicyService qymypolicy;
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
	@Resource(name = "ggCodeService")
	private GgCodeService codeService;
	@Resource(name = "qymychecked")
	private QyMycheckService mychecked;
	@Resource(name = "tojudge")
	private ToJudgeService tojudge;
	
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;
	
	@Resource(name = "ggInsureConfigService")
	private GgInsureConfigService ggInsureConfigService;
	
	@Autowired
	private SubmitInsureUtil submitInsure;
	
	@Autowired
	private GuWebClientMapper client ;
	
	@Autowired
	private SubmitPayment submitPayment;
	
	@Resource(name = "gpOrderDetailService")
	private GpOrderDetailService detailService;
	
	@Autowired
	private SubmitInsureAfterUtil insureAfter;
	
	@Autowired
	GuPolicyMainMapper mainMapper;
	
	

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
	@Autowired
	GgUserMapper userMapper;
	/**
	 * 保险公司用户登录后初始化
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping("/initPolicy")
	public ModelAndView initPolicy(Pagination pagination) {
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
		mad.setViewName("/policyUser/mainPage");
		return mad;
	}
	
	//保单批量导入
	@RequestMapping("/goBBBBB")
	public String goBBBBB(HttpServletRequest request, Model model){
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GgInsureConfig ggConfig = new GgInsureConfig();
		ggConfig.setAreaCode(ggUser.getProvince());
		ggConfig.setRiskCode("0901");
//		List<GgInsureConfig> list_ggConfig = ggInsureConfigService.getInsurance(ggConfig);
//		request.setAttribute("list_CICompanycode",list_ggConfig);
		return "gobatch";
	}
	
	@RequestMapping(value="/checkPolicyExl", method = RequestMethod.POST) 
	public void checkPolicyExl(@RequestParam(value = "excelPath", required = false) MultipartFile file,
			HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException{
			GgUser ggUser = (GgUser) session.getAttribute("ggUser");
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
            			 continue;
            		 }
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
//        			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            		 Date startD = sdf.parse(getValue(startDate));
//            		 Date endD = sdf.parse(getValue(endDate));
        			 Date startD = DateUtils.formatStartDate(getValue(startDate));
         			 Date endD = DateUtils.formatEndDate(getValue(endDate));
        			 GuPolicyMain guPolicyMain = new GuPolicyMain(businessNo, getValue(policyNo), "0901", "批量导入保单", 
        					 getValue(appliName), getValue(appliAddress), getValue(insuredName), getValue(insuredAddress), 
        					 startD, endD, getValue(EMCOUNT), Double.valueOf(getValue(zhuMeiCi)), 1.00, Double.valueOf(getValue(sumBaoFei)),
        					 new Date(), "3", "1", ggUser.getAddress(), getValue(province).substring(getValue(province).length()-6), 
        					 getValue(city).substring(getValue(city).length()-6), getValue(county).substring(getValue(county).length()-6),
        					 "1");
        			 list.add(guPolicyMain);
        			 GuPolicyInsured guPolicyInsured = new GuPolicyInsured("8004", "0901", getValue(safeNumber)
        					 , getValue(appliName), getValue(appliAddress), getValue(businesscccCode), getValue(appliLinkName)
        					 , getValue(appliPhoneNo), /*getValue(appleEmail)*/"", getValue(businessType).substring(getValue(businessType).length()-6),
        					 getValue(jobType).substring(getValue(jobType).length()-6));
        			 guPolicyInsured.setBusinessno(businessNo);
        			 guPolicyInsured.setSeriesno(1L);
        			 listInsured.add(guPolicyInsured);
        			 GuPolicyInsured guPolicyInsured2 = new GuPolicyInsured("8004", "0901", getValue(safeNumber)
        					 , getValue(insuredName), getValue(insuredAddress), getValue(businesscccCode), getValue(insuredLinkName)
        					 , getValue(insuredPhoneNo), /*getValue(insuredEmail)*/"", getValue(businessType).substring(getValue(businessType).length()-6),
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
	 * 校验数据
	 * @param hssfRow
	 * @return
	 */
	private String checkPolicy(HSSFRow hssfRow,int rowNum){
		StringBuffer resultStr = new StringBuffer(100);
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
//			 HSSFCell fuSanXianE = hssfRow.getCell(23);
//			 HSSFCell fuSanBaoFei = hssfRow.getCell(24);
//			 HSSFCell fuYiLiaoXianE = hssfRow.getCell(25);
//			 HSSFCell fuYiLiaoBaoFei = hssfRow.getCell(26);
//			 HSSFCell fuJiuYuanXianE = hssfRow.getCell(27);
//			 HSSFCell fuJiuYuanBaoFei = hssfRow.getCell(28);
//			 HSSFCell fuFaLvXianE = hssfRow.getCell(29);
//			 HSSFCell fuFaLvBaoFei = hssfRow.getCell(30);
		 HSSFCell sumBaoFei = hssfRow.getCell(31);
		 HSSFCell EMCOUNT = hssfRow.getCell(32);
		 if(policyNo==null){
			 resultStr.append("第"+rowNum+"行保单号不能为空;");
		 }else{
			 GuPolicyMain guPolicyMain = guPolicyMainMapper.selectByPolicyNo(getValue(policyNo));
			 if(guPolicyMain!=null){
				 resultStr.append("第"+rowNum+"行保单号系统已存在;");
			 }
		 }
		 if(startDate==null){
			 resultStr.append("第"+rowNum+"行起保日期不能为空;");
		 }else{
			//日期格式校验
			String startD = getValue(startDate);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	        try{    
	        	Date date = sdf1.parse(startD);
	        }catch(Exception e){
	        	resultStr.append("第"+rowNum+"行起保日期格式错误;");
	        }
		 }
		 if(endDate==null){
			 resultStr.append("第"+rowNum+"行终保日期不能为空;");
		 }else{
				//日期格式校验
				String endD = getValue(endDate);
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		        try{    
		        	Date date = sdf1.parse(endD);
		        }catch(Exception e){
		        	resultStr.append("第"+rowNum+"行终保日期格式错误;");
		        }
			 }
		 if(appliName==null){
			 resultStr.append("第"+rowNum+"行投保人姓名不能为空;");
		 }
		 if(appliAddress==null){
			 resultStr.append("第"+rowNum+"行投保人地址不能为空;");
		 }
		 if(appliPhoneNo==null){
			 resultStr.append("第"+rowNum+"行投保人联系电话不能为空;");
		 }
		 if(appliLinkName==null){
			 resultStr.append("第"+rowNum+"行投保联系人姓名不能为空;");
		 }
//			 if(appleEmail==null){
//				 resultStr.append("第"+rowNum+"行投保联系人电子邮箱不能为空;");
//			 }
		 if(insuredName==null){
			 resultStr.append("第"+rowNum+"行被保险人姓名不能为空;");
		 }
		 if(insuredAddress==null){
			 resultStr.append("第"+rowNum+"行被保险人地址不能为空;");
		 }
		 if(insuredPhoneNo==null){
			 resultStr.append("第"+rowNum+"行被保险人联系电话不能为空;");
		 }
		 if(insuredLinkName==null){
			 resultStr.append("第"+rowNum+"行被保险联系人姓名不能为空;");
		 }
//			 if(insuredEmail==null){
//				 resultStr.append("第"+rowNum+"行被保险人电子邮箱不能为空;");
//			 }
		 if(province==null){
			 resultStr.append("第"+rowNum+"行归属省不能为空;");
		 }else{
			 if(getValue(province).length()<6){
				 resultStr.append("第"+rowNum+"行归属省格式不正确;");
			 }
		 }
		 if(city==null){
			 resultStr.append("第"+rowNum+"行归属市不能为空;");
		 }else{
			 if(getValue(city).length()<6){
				 resultStr.append("第"+rowNum+"行归属市格式不正确;");
			 }
		 }
		 if(county==null){
			 resultStr.append("第"+rowNum+"行归属区县不能为空;");
		 }else{
			 if(getValue(county).length()<6){
				 resultStr.append("第"+rowNum+"行归属区县格式不正确;");
			 }
		 }
		 if(jobType==null){
			 resultStr.append("第"+rowNum+"行行业类别不能为空;");
		 }else{
			 if(getValue(jobType).length()<6){
				 resultStr.append("第"+rowNum+"行行业类别格式不正确;");
			 }
		 }
		 if(businessType==null){
			 resultStr.append("第"+rowNum+"行经营范围不能为空;");
		 }else{
			 if(getValue(businessType).length()<6){
				 resultStr.append("第"+rowNum+"行经营范围格式不正确;");
			 }
		 }
		 if(businesscccCode==null){
			 resultStr.append("第"+rowNum+"行社会统一信用代码不能为空;");
		 }
		 if(safeNumber==null){
			 resultStr.append("第"+rowNum+"行安全生产许可证号不能为空;");
		 }
		 Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"); 
		 if(zhuMeiRen==null){
			 resultStr.append("第"+rowNum+"行主险每人限额不能为空;");
		 }else{
			 Matcher isNum = pattern.matcher(getValue(zhuMeiRen));
			 if(!isNum.matches()){
				 resultStr.append("第"+rowNum+"行主险每人限额必须为数字;");
			 }
		 }
		 if(zhuMeiCi==null){
			 resultStr.append("第"+rowNum+"行主险每次限额不能为空;");
		 }else{
			 Matcher isNum = pattern.matcher(getValue(zhuMeiCi));
			 if(!isNum.matches()){
				 resultStr.append("第"+rowNum+"行主险每次限额必须为数字;");
			 }
		 }
		 if(zhuBaofei==null){
			 resultStr.append("第"+rowNum+"行主险保费不能为空;");
		 }
		 if(sumBaoFei==null){
			 resultStr.append("第"+rowNum+"行总保费不能为空;");
		 }
		 if(EMCOUNT==null){
			 resultStr.append("第"+rowNum+"行投保人数不能为空;");
		 }
		return resultStr.toString();
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
		admin.setUserInd("4");
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
		mad.setViewName("/policyUser/administrationCondition");
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
		conditionMap.put("userInd", "4");
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
		List<Map<String, Object>> resultList = administr.getAdminQueryPolicy(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/policyUser/administrationResult");
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
		mad.setViewName("/policyUser/adminsitrationShow");
		return mad;
	}
	
	//用户查询结果显示
	@RequestMapping("/admindel")
	public ModelAndView admindel(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String UserCode = request.getParameter("UserCode");
		administr.setAdminStatus(UserCode);
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		List<Map<String, Object>> resultList = administr.getAdminQueryPolicy(pagination);
		pagination.setResultList(resultList);
		mad.addObject("pagination", pagination);
		mad.setViewName("/policyUser/administrationResult");
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
		List<Map<String, Object>> resultList = administr.getAdminQueryPolicy(pagination);
		pagination.setResultList(resultList);
		mad.addObject("pagination", pagination);
		mad.setViewName("/policyUser/administrationResult");
		return mad;
	}

	@RequestMapping("/adminpage")
	public ModelAndView adminpage(@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = administr.getAdminpage(pagination);
		mad.addObject(pagination);
		mad.setViewName("/policyUser/administrationResult");
		return mad;
	}
	
	//保险公司用户查询投保单
	@RequestMapping("/mypolicyqueryPolicy")
	public ModelAndView mypolicyqueryPolicy(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String insuredcode = request.getParameter("insuredcode");
		String languagec = request.getParameter("languagec");
		GgUser user = (GgUser) session.getAttribute("ggUser");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(insuredcode==null){
			insuredcode="";
		}
		conditionMap.put("insuredcode", insuredcode.equals("请输入被保险人") ? ""
				: insuredcode);
		conditionMap.put("languagec", languagec);
//		if("1".equals(user.getComLevel())){
//			conditionMap.put("province", user.getProvince());
//		}
//		if("2".equals(user.getComLevel())){
//			conditionMap.put("city", user.getCity());
//		}
//		if("3".equals(user.getComLevel())){
//			conditionMap.put("county", user.getCounty());
//		}
		if("1".equals(user.getComLevel())){
			conditionMap.put("GodLevel", user.getAddress());
		}else{
			if("4".equals(user.getUserInd())&&"0".equals(user.getFlag())){//管理员权限才可以查看自己添加的业务员
				conditionMap.put("USERLEFLAG", user.getUserCode());
			}else{
				conditionMap.put("MYUSERCODE", user.getUserCode());
			}
		}
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = qymypolicy
				.getqymypolicyPolicy(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/policyUser/mypolicyResult");
		return mad;
	}
	
	@RequestMapping("/mypolicyPolicyPagin")
	public ModelAndView mypolicyPolicyPagin(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = qymypolicy.getqymypolicyPolicyPagination(pagination);
		mad.addObject(pagination);
		mad.setViewName("/policyUser/mypolicyResult");
		return mad;
	}
	
	//保险公司用户查询保单
	@RequestMapping("/mycheckqueryPolicy")
	public ModelAndView mycheckqueryPolicy(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		GgUser user = (GgUser) session.getAttribute("ggUser");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		if("1".equals(user.getComLevel())){
			conditionMap.put("province", user.getProvince());
		}
		if("2".equals(user.getComLevel())){
			conditionMap.put("city", user.getCity());
		}
		if("3".equals(user.getComLevel())){
			conditionMap.put("county", user.getCounty());
		}
		String languagec = request.getParameter("languagec");
		if("1".equals(languagec)){
			conditionMap.put("status", languagec);
		}
		if("0".equals(languagec)){
			conditionMap.put("status1", languagec);
		}
		conditionMap.put("INCODE", user.getAddress());
		String POLICYNO = request.getParameter("POLICYNO");
		if(!"请输入保单号".equals(POLICYNO)&&POLICYNO!=null){
			conditionMap.put("POLICYNO", POLICYNO);
		}
		String languageb = request.getParameter("languageb");
		if("1".equals(languageb)){
			if("1".equals(user.getComLevel())){
				conditionMap.put("GodLevel1", user.getAddress());
			}else{
				if("4".equals(user.getUserInd())&&"0".equals(user.getFlag())){//管理员权限才可以查看自己添加的业务员
					conditionMap.put("USERLEFLAG1", user.getUserCode());
				}else{     
					conditionMap.put("MYUSERCODE1", user.getUserCode());
				}
			}
		}else if("0".equals(languageb)){
			conditionMap.put("INCODE0", user.getAddress());
		}else{
			if("1".equals(user.getComLevel())){
				conditionMap.put("GodLevel", user.getAddress());
			}else{
				if("4".equals(user.getUserInd())&&"0".equals(user.getFlag())){//管理员权限才可以查看自己添加的业务员
					conditionMap.put("USERLEFLAG", user.getUserCode());
				}else{     
					conditionMap.put("MYUSERCODE", user.getUserCode());
				}
			}
		}
		List<Map<String, Object>> resultList = mychecked.getmypolicyInitPolicy(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/policyUser/mycheckResult");
		return mad;
	}
	
	@RequestMapping("/mycheckinitPolicyPagin")
	public ModelAndView mycheckinitPolicyPagin(@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = mychecked.getmypolicyInitPolicyPagination(pagination);
		mad.addObject(pagination);
		mad.setViewName("/policyUser/mycheckResult");
		return mad;
	}
	
	//投保单查看
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
		mad.addObject("tempUser", tempUser);
		request.setAttribute("inPep", guPolicyInsured);
//		mad.addObject("resultMap", resultMap);
		session.setAttribute("resultMap", resultMap);
		mad.addObject(pagination);
		request.setAttribute("businessno", businessno);
		mad.setViewName("/policyUser/mypolicyShow");
		return mad;
	}
	
	//投保单注销
	@RequestMapping("/delPolicy")
	public ModelAndView delPolicy(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String businessno = request.getParameter("businessno");
		GuPolicyMain guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessno);
		guPolicyMain.setUnderWriteFlag("6");
		insurePolicyService.updateByPrimaryKeySelective(guPolicyMain);
		mad.setViewName("/policyUser/showSuccess");
		return mad;
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
//		mad.addObject("resultMap", resultMap);
		session.setAttribute("resultMap", resultMap);
		request.setAttribute("standardLevelImg", guPolicyMain.getUnderWriteName());
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
		mad.setViewName("/policyUser/mycheckRenwal");
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
		if("1".equals(ggUser.getComLevel())){
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
			list_city = ggCodeService.getGgCodeByObj(codeT);
			codeT.setCodeType("County");
			codeT.setCodeCode(null);
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
		}
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
	 * 保险公司业务用户投保下一步调至此
	 * @param request
	 * @param policyManager
	 * @param model
	 * @param standardLevelImg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPlaceValue")
	// 根据用户选择的方案计算保费
	public String getPlaceValue(HttpServletRequest request,
			PolicyManager policyManager, Model model,@RequestParam MultipartFile standardLevelImg) throws Exception {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		GuPolicyMain guPolicyMain = new GuPolicyMain();
		GuPolicyFee guPolicyFee = new GuPolicyFee();
		GgUserCorp tempUser = new GgUserCorp();
		tempUser.setCompanyName(request.getParameter("inName"));
		tempUser.setLinkName(request.getParameter("inLinkName"));
		tempUser.setCompanyAddress(request.getParameter("inAddress"));
		tempUser.setEmail(request.getParameter("inEmail"));
		tempUser.setTelephone(request.getParameter("inTelePhone"));
		tempUser.setProvince(request.getParameter("province"));
		tempUser.setCity(request.getParameter("city"));
		tempUser.setCounty(request.getParameter("county").trim());
		tempUser.setClassCode(request.getParameter("classCode"));
		tempUser.setBusinessClass(request.getParameter("businessClass"));
		tempUser.setBusinessLicenseNo(request.getParameter("alBusinessLicenseNo"));
		tempUser.setStandardLevel(request.getParameter("standardLevel"));
		tempUser.setSafetyLicenseNo(request.getParameter("alSafetyLicenseNo"));
		GuPolicyAdjustRate guPolicyAdjustRate = new GuPolicyAdjustRate();
		String businessNO = request.getParameter("businessNOee");
		String status = request.getParameter("status");// 1.重新提交保单 ;2.续保
		// 生成业务号
		String businessNo = new Long(new Date().getTime()).toString();
		businessNo = businessNo
				+ Long.toString(getRandom(100000000, 999999999));
		businessNo = businessNo.substring(0, 20);
		// 获取险别费率
		GgUser tempU = new GgUser();
		tempU.setProvince(tempUser.getProvince());
		tempU.setCity(tempUser.getCity());
		tempU.setCounty(tempUser.getCounty());
		List<GgRisk> ggRisks = insurePolicyService.findKind4Aera(tempU);
		GgKind ggKind = new GgKind();
		ggKind.setRiskcode(policyManager.getRiskCode());
		ggKind.setAreacode(ggRisks.get(0).getAreacode());
		ggKind.setKindename(tempUser.getBusinessClass());
		ggKind.setInsurancecode(ggUser.getAddress());
		List<GgKind> ggKindList = insurePolicyService.getGgKindList(ggKind);
		// 基本保费
		GgKindPriceKey ggKindPriceKey = new GgKindPriceKey();
		ggKindPriceKey.setAreacode(ggRisks.get(0).getAreacode());
		ggKindPriceKey.setRiskcode(policyManager.getRiskCode());
		ggKindPriceKey.setInsurecode(ggUser.getAddress());
		ggKindPriceKey.setIndustrycode(tempUser.getBusinessClass());
		ggKindPriceKey.setScalecode("0");
		GgKindPrice ggKindPrice = insurePolicyService
				.selectByPrimaryKey(ggKindPriceKey);
		BigDecimal price = ggKindPrice.getPrice();
		// 获取每人限额费率
		GgAmountRate ggAmountRate = new GgAmountRate();
		ggAmountRate.setAmount(policyManager.getAmount());
		ggAmountRate.setAmounttype("amount");
		ggAmountRate.setInsurecode(ggUser.getAddress());
		GgAmountRate ggAmountRateTemp = insurePolicyService
				.selectByType(ggAmountRate);
		Double amountRate = Double.valueOf(ggAmountRateTemp.getRate());// 每人费率
		// 获取累计限额费率
		Double sumAmountRate = 1.00;// 累计费率
		// 安全标准化等级费率
		GgAmountRate ggAmountRate2 = new GgAmountRate();
		ggAmountRate2.setAmounttype("安全标准化等级");
		ggAmountRate2.setScale(tempUser.getStandardLevel());
		ggAmountRateTemp = insurePolicyService.selectByType(ggAmountRate2);
		Double standardLevelRate = Double.valueOf(ggAmountRateTemp.getRate());// 安全标准化费率
		// 短期费率
		double shortRate = 1.0;
		String startDate = DateUtils.format(policyManager.getStartDate(),
				"yyyy-MM-dd");
		String endDate = DateUtils.format(policyManager.getEndDate(),
				"yyyy-MM-dd");
		int dayFlag = getDaydiff(startDate, endDate);
		if("630003".equals(tempUser.getBusinessClass())){
			double[] shortArray = { 0, 0.20, 0.30, 0.40, 0.50, 0.60, 0.70, 0.75,
					0.80, 0.85, 0.90, 0.95 };
			shortRate = Math.floor(dayFlag / 12) + shortArray[dayFlag % 12]; // 短期费率
		}
		// 企业事故率折扣
		Double lossRate = 1.00;
		// 续保折扣
		Double renewalRate = 1.00;
		// 保费计算start
		BigDecimal premium = new BigDecimal("0.00");// 主险保费
		BigDecimal sumPremium = new BigDecimal("0.00");// 总保费
		Double tempRate = amountRate * shortRate;// 主险费率
		// 计算主险保费
		price = price.multiply(BigDecimal.valueOf(tempRate)); // 未加优惠系数的基本保费
		double adjust = standardLevelRate * lossRate * renewalRate;
		adjust = new BigDecimal(adjust).setScale(4, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		if (adjust > 1.2)adjust = 1.2;// 优惠系数不能大于1.2
		if (adjust < 0.8)adjust = 0.8;
		premium = price.multiply(BigDecimal.valueOf(adjust)).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		sumPremium = premium.multiply(BigDecimal.valueOf(Double.valueOf(policyManager.getPepSum())));
		policyManager.setSumAmount(String.valueOf(Double.valueOf(policyManager.getAmount())*Double.valueOf(policyManager.getPepSum())));
		// 计算附加险保费
		List<GuPolicyItemKind> guPolicyItemKindList = new ArrayList<GuPolicyItemKind>();
		double tempPremium = 0.00;
		Double sanamount = Double.valueOf(request.getParameter("sanamount"));
		for (int i = 0; i < ggKindList.size(); i++) {
			GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
			double tempPrice = 0.00;
			guPolicyItemKind.setBusinessno(businessNo);
			guPolicyItemKind.setKindcode(ggKindList.get(i).getKindcode());
			guPolicyItemKind.setKindname(ggKindList.get(i).getKindcname());
			guPolicyItemKind.setStartdate(policyManager.getStartDate());
			guPolicyItemKind.setEnddate(policyManager.getEndDate());
			guPolicyItemKind.setRiskcode(policyManager.getRiskCode());
			guPolicyItemKind.setAmount(new BigDecimal(policyManager.getSumAmount()));
			guPolicyItemKind.setUnitamount(new BigDecimal(policyManager.getAmount()));
			if (i == 0) {// 主险
				guPolicyItemKind.setActualpremium(premium.multiply(BigDecimal.valueOf(Double.valueOf(policyManager.getPepSum()))));
				guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
						.getActualpremium());
				guPolicyItemKindList.add(guPolicyItemKind);
				continue;
			}
			if ("on".equals(policyManager.getItemOne()) && i == 1) {
				tempPrice = BigDecimal.valueOf(Double.valueOf(sanamount)).multiply(new BigDecimal(ggKindList.get(i).getDescription())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				tempPrice = tempPrice*adjust;
				tempPrice = new BigDecimal(tempPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				guPolicyItemKind.setActualpremium(BigDecimal.valueOf(tempPrice));
				guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
						.getActualpremium());
				guPolicyItemKind.setAmount(BigDecimal.valueOf(sanamount));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()) * 0.3));
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium()
						.doubleValue();
				policyManager.setItemOne(String.valueOf(guPolicyItemKind
						.getSpreadsheetpremium()));
			}
			if ("on".equals(policyManager.getItemTwo()) && i == 2) {
				tempPrice = BigDecimal.valueOf(Double.valueOf(policyManager.getSumAmount())).multiply(new BigDecimal(ggKindList.get(i).getDescription())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				tempPrice = tempPrice*adjust*0.3;
				tempPrice = new BigDecimal(tempPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				guPolicyItemKind.setActualpremium(BigDecimal.valueOf(tempPrice));
				guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
						.getActualpremium());
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double.valueOf(policyManager.getSumAmount()) * 0.3));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()) * 0.3));
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium()
						.doubleValue();
				policyManager.setItemTwo(String.valueOf(guPolicyItemKind
						.getSpreadsheetpremium()));
			}
			if ("on".equals(policyManager.getItemThree()) && i == 3) {
				tempPrice = BigDecimal.valueOf(Double.valueOf(policyManager.getSumAmount())).multiply(new BigDecimal(ggKindList.get(i).getDescription())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				tempPrice = tempPrice*adjust*0.3;
				tempPrice = new BigDecimal(tempPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				guPolicyItemKind.setActualpremium(BigDecimal.valueOf(tempPrice));
				guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
						.getActualpremium());
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double.valueOf(policyManager.getSumAmount()) * 0.3));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()) * 0.3));
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium()
						.doubleValue();
				policyManager.setItemThree(String.valueOf(guPolicyItemKind
						.getSpreadsheetpremium()));
			}
			if ("on".equals(policyManager.getItemFour()) && i == 4) {
				tempPrice = BigDecimal.valueOf(Double.valueOf(policyManager.getSumAmount())).multiply(new BigDecimal(ggKindList.get(i).getDescription())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				tempPrice = tempPrice*adjust*0.05;
				tempPrice = new BigDecimal(tempPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				guPolicyItemKind.setActualpremium(BigDecimal.valueOf(tempPrice));
				guPolicyItemKind.setSpreadsheetpremium(guPolicyItemKind
						.getActualpremium());
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double.valueOf(policyManager.getSumAmount()) * 0.05));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double.valueOf(policyManager.getAmount()) * 0.05));
				guPolicyItemKindList.add(guPolicyItemKind);
				tempPremium += guPolicyItemKind.getActualpremium().doubleValue();
				policyManager.setItemFour(String.valueOf(guPolicyItemKind.getSpreadsheetpremium()));
			}
		}
		if (tempPremium != 0.00)
			sumPremium = sumPremium.add(BigDecimal.valueOf(tempPremium));
		sumPremium = sumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal accidentPreventFee = sumPremium.multiply(BigDecimal.valueOf(0.1));
		policyManager.setPr(premium.multiply(BigDecimal.valueOf(Double.valueOf(policyManager.getPepSum()))).toString());
//		policyManager.setSumPr(sumPremium.toString());
		policyManager.setSumPr(new StringUtil().number2CNMontrayUnit(sumPremium));
		// 保费计算end
		// 跟单主表传值
		guPolicyMain.setBusinessNo(businessNo);
		guPolicyMain.setRiskCode(policyManager.getRiskCode());
//		if (renewalFlag.size() > 0) {// 上一年保单号
//			guPolicyMain.setPreviousPolicyNo(renewalFlag.get(renewalFlag.size() - 1).getPolicyNo());
//		}
		guPolicyMain.setPlanCode(ggRisks.get(0).getAreacode() + "-"
				+ ggUser.getAddress() + "-"
				+ policyManager.getAmount() + "-"
				+ policyManager.getSumAmount());
		guPolicyMain.setAppliCode(ggUser.getUserCode());
		guPolicyMain.setAppliName(tempUser.getCompanyName());
		guPolicyMain.setAppliAddress(tempUser.getCompanyAddress());
		guPolicyMain.setInsuredName(tempUser.getCompanyName());
		guPolicyMain.setInsuredAddress(tempUser.getCompanyAddress());
		guPolicyMain.setInsuredCode(ggUser.getUserCode());
		guPolicyMain.setStartDate(policyManager.getStartDate());
		guPolicyMain.setEndDate(policyManager.getEndDate());
		guPolicyMain.setCurrency("CNY");
		guPolicyMain.setSumAmount(Double.valueOf(policyManager.getSumAmount()));
		guPolicyMain.setDisCount(adjust);
		guPolicyMain.setSpreadsheetPremium(sumPremium.doubleValue());
		guPolicyMain.setArgueSolution(policyManager.getToTalk());
		guPolicyMain.setArbitBoardName(policyManager.getToTalkName());
		guPolicyMain.setOperatorCode(ggUser.getUserCode());
		guPolicyMain.setOperateDate(new Date());
		guPolicyMain.setUnderWriteFlag("3");
		guPolicyMain.setPayFlag("0");
		guPolicyMain.setInsurerCode(ggUser.getAddress());
		guPolicyMain.setProvince(tempUser.getProvince());
		guPolicyMain.setCity(tempUser.getCity());
		guPolicyMain.setCounty(tempUser.getCounty());
		guPolicyMain.setAccidentPreventFee(accidentPreventFee);
		guPolicyMain.setRemark(ggUser.getUpdator());
		guPolicyMain.setFlag("1");//保险公司业务标志
		String fiString = standardLevelImg.getOriginalFilename();
		if (fiString != null && !"".equals(fiString)) {//安全标准化等级证
			guPolicyMain.setUnderWriteName(FileUtil.uploadFile(standardLevelImg, request));
		}
		// 跟单费率表传值
		guPolicyAdjustRate.setBusinessno(businessNo);
		guPolicyAdjustRate.setAmountadjust(amountRate.toString());
		guPolicyAdjustRate.setSumamountadjust(String.valueOf(sumAmountRate));
		guPolicyAdjustRate.setRenewalrate(String.valueOf(renewalRate));
		guPolicyAdjustRate.setShortrate(String.valueOf(shortRate));
		guPolicyAdjustRate.setLossrate(String.valueOf(lossRate));
		guPolicyAdjustRate.setStandardlevelrate(String
				.valueOf(standardLevelRate));
		// 跟单fee表传值
		guPolicyFee.setBusinessno(businessNo);
		guPolicyFee.setRiskcode(policyManager.getRiskCode());
		guPolicyFee.setActualpremium(sumPremium);
		guPolicyFee.setSpreadsheetpremium(sumPremium);
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
		GuPolicyInsured guPolicyInsured = new GuPolicyInsured();
		guPolicyInsured.setIdentitynumber(policyManager.getAlBusinessLicenseNo());
		guPolicyInsured.setEmail(policyManager.getInEmail());
		guPolicyInsured.setLinkname(policyManager.getInLinkName());
		guPolicyInsured.setPhonenumber(policyManager.getInTelePhone());
		guPolicyInsured.setInsuredname(policyManager.getInName());
		guPolicyInsured.setInsuredaddress(policyManager.getInAddress());
		guPolicyInsured.setInsuredcode(ggUser.getUserCode());
		guPolicyInsured.setBusinessno(businessNo);
		guPolicyInsured.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured.setInsuredflag(String.valueOf(1L));
		guPolicyInsured.setSeriesno(1L);
		guPolicyInsured.setPolicyno(tempUser.getStandardLevel());
		guPolicyInsured.setRemark(tempUser.getClassCode());
		guPolicyInsured.setFlag(tempUser.getBusinessClass());
		guPolicyInsured.setInsuredtype(tempUser.getSafetyLicenseNo());
		guPolicyInsuredList.add(guPolicyInsured);
		
		GuPolicyInsured guPolicyInsured1 = new GuPolicyInsured();
		guPolicyInsured1.setIdentitynumber(policyManager.getAlBusinessLicenseNo());
		guPolicyInsured1.setEmail(policyManager.getInEmail());
		guPolicyInsured1.setLinkname(policyManager.getInLinkName());
		guPolicyInsured1.setPhonenumber(policyManager.getInTelePhone());
		guPolicyInsured1.setInsuredname(policyManager.getInName());
		guPolicyInsured1.setInsuredaddress(policyManager.getInAddress());
		guPolicyInsured1.setInsuredcode(ggUser.getUserCode());
		guPolicyInsured1.setBusinessno(businessNo);
		guPolicyInsured1.setRiskcode(policyManager.getRiskCode());
		guPolicyInsured1.setInsuredflag(String.valueOf(1L));
		guPolicyInsured1.setSeriesno(2L);
		guPolicyInsured1.setPolicyno(tempUser.getStandardLevel());
		guPolicyInsured1.setRemark(tempUser.getClassCode());
		guPolicyInsured1.setFlag(tempUser.getBusinessClass());
		guPolicyInsured1.setInsuredtype(tempUser.getSafetyLicenseNo());
		guPolicyInsuredList.add(guPolicyInsured1);
		if (policyManager.getItemOne() == null || "".equals(policyManager.getItemOne()))
			policyManager.setItemOne("未投保");
		if (policyManager.getItemTwo() == null|| "".equals(policyManager.getItemTwo()))
			policyManager.setItemTwo("未投保");
		if (policyManager.getItemThree() == null|| "".equals(policyManager.getItemThree()))
			policyManager.setItemThree("未投保");
		if (policyManager.getItemFour() == null|| "".equals(policyManager.getItemFour()))
			policyManager.setItemFour("未投保");
		//处理跟单人员表start
		String[] pepList = request.getParameter("pepSums").split(";");
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
		guPolicyMain.setCurrency(String.valueOf(pepList.length));
		//处理跟单人员表end
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
		session.setAttribute("status", status);
		session.setAttribute("businessNO", businessNO);
		policy.put("businessNO", businessNO);
		policy.put("status", status);
		model.addAttribute("policyManager", policyManager);
		startDate = DateUtils.format(policyManager.getStartDate(),
				"yyyy年MM月dd");
		endDate = DateUtils.format(policyManager.getEndDate(),
				"yyyy年MM月dd");
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("sanamount", sanamount/10000);
		model.addAttribute("policy", policy);
		GgCode code = new GgCode();
		code.setCodeType("Province");
		code.setCodeCode(tempUser.getProvince());
		List<GgCode> list_pro = ggCodeService.getGgCodeByObj(code);
		code.setCodeType("City");
		code.setCodeCode(tempUser.getCity());
		List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
		code.setCodeType("County");
		code.setCodeCode(tempUser.getCounty());
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
		model.addAttribute("list_pro", list_pro);
		model.addAttribute("list_city", list_city);
		model.addAttribute("list_county", list_county);
		model.addAttribute("list_classCode", list_classCode);
		model.addAttribute("list_businessClass",list_businessClass);
		model.addAttribute("list_safe", list_safe);
		model.addAttribute("tempUser", tempUser);
		model.addAttribute("zbf", sumPremium);
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
	 * 业务员提交保单跳转至此
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertPolicyEnd")
	// 根据用户选择的保险公司插入投保单
	public String insertPolicyEnd(HttpServletRequest request, Model model) {
		
		GgUser user = (GgUser) session.getAttribute("ggUser");
		
		//业务员信息
		String province = user.getProvince();//业务员所在省
		String city = user.getCity();//业务员所在市
		String county = user.getCounty();//业务员所在区县
		String linkName = user.getLinkName();//业务员名称
		String phone = user.getTelePhone();//业务员手机号
		String affiliation = county;
		if(StringUtils.isEmpty(county) || "null".equals(county)) {
			affiliation = city;
			if(StringUtils.isEmpty(city) || "null".equals(county)) {
				affiliation = province;
			}
		}
		String salesmanInfo = affiliation + "," + linkName + "," + phone;//业务员信息:归属 + 名称+ 手机号
		
		//储存所有的投保信息
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
		List<GuPolicyEmployee> guPolicyEmployeeList = (List<GuPolicyEmployee>) session.getAttribute("guPolicyEmployeeList");
		String businessNOee = guPolicyMain.getBusinessNo();
		String status = (String) session.getAttribute("status");// 1.重新递交保单 // 2.续保
		
		// 调用带有事务的插入方法
		insurePolicyService.insertAll(guPolicyMain, guPolicyFee, guPolicyAdjustRate, guPolicyItemKindList, guPolicyLimitList, guPolicyInsuredList,guPolicyEmployeeList);
		if ("1".equals(status)) {// 修改保单
			guPolicyMain = insurePolicyService.selectByPrimaryKey3(businessNOee);
			guPolicyMain.setUnderWriteFlag("6");
			guPolicyMain.setUpdateDate(new Date());
			GgUser ggUser = (GgUser) session.getAttribute("ggUser");
			guPolicyMain.setUpdatorCode(ggUser.getUserCode());
//			insurePolicyService.deleteByPrimaryKey2(businessNOee);
			insurePolicyService.updateByPrimaryKeySelective(guPolicyMain);
		 }
		

		//获取保险公司投保方式 1:待报价 2:自动出单 3:自动出结果 4:人工出结果
		GgInsureConfig ggInsureConfig = new GgInsureConfig();
		ggInsureConfig.setInsuranceCode(guPolicyMain.getInsurerCode());
		String flag = ggInsureConfigService.getInsurance(ggInsureConfig).get(0).getFlag();
		
		 if("2".equals(flag)){
			 return submitPayment.goToPayment(guPolicyMain);
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
		
		
		return "showSuccess";
	}
	
	/**
	 * 保险公司投保失败,重新提交保单
	 * @param businessno
	 * @return
	 */
	@RequestMapping(value = "/policyUserResubmit")
	public String policyUserResubmit(String businessno) {
		
		String flag = "showError";
		try {
			GuPolicyMain m = mainMapper.selectByPrimaryKey(businessno);
			if (m.getProposalNo() != null) {
				flag = insureAfter.underWriteAfter(businessno) == 1 ? "showSuccess" : "showError";
			}else {
				flag = insureAfter.insuranceSingle(businessno) == 1 ? "showSuccess" : "showError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "showError";
		}
		
		return flag;
	}
	
	@RequestMapping(value = "/getEndDate")
	public void getEndDate(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String StartDate = obj.getString("StartDate");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		Date startDate;
		try {
			startDate = sf.parse(StartDate);
			Calendar time = Calendar.getInstance();
			time.setTime(startDate);
			time.add(Calendar.YEAR, 1); 
			time.add(Calendar.DAY_OF_MONTH, -1);
			String endDate = sf.format(time.getTime());
			String EndDate = JSON.toJSONString(endDate);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter write = response.getWriter();
			write.write(EndDate);
			write.flush();
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/checkPepExl", method = RequestMethod.POST) 
	public void checkPepExl(@RequestParam(value = "excelPath", required = false) MultipartFile file,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
			HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheet = wb.getSheetAt(0);
            StringBuffer sb = new StringBuffer();
            for(int i = sheet.getFirstRowNum();i<sheet.getLastRowNum();i++){
                HSSFRow row = sheet.getRow(i+1);
                Iterator cells = row.cellIterator();
                while(cells.hasNext()){
                    HSSFCell cell = (HSSFCell) cells.next();
                    if(!cells.hasNext()) {
                    	sb.append(getValue(cell));
                    }else{
                    	sb.append(getValue(cell)+",");
                    }
                }
                sb.append(";");
            }
            System.out.println(sheet.getLastRowNum());
            System.out.println(sb.toString());
            GuPolicyMain guPolicyMain = new GuPolicyMain();
            guPolicyMain.setBusinessNo(String.valueOf(sheet.getLastRowNum()));
            guPolicyMain.setSpecialprovisions(sb.toString());
            List<GuPolicyMain> list = new ArrayList<GuPolicyMain>();
            list.add(guPolicyMain);
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
	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
           // 返回数值类型的值
           DecimalFormat df = new DecimalFormat("0"); 
           return String.valueOf(df.format(hssfCell.getNumericCellValue()));
        } else {
              // 返回字符串类型的值
           return String.valueOf(hssfCell.getStringCellValue().trim());
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
			if(flag){
				dateFlag = "1";
			}else{
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
}
