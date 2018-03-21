package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GcClaim;
import com.dsib.entity.GcClaimProve;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.QyMyclaimService;
import com.dsib.submitInterface.SubmitClaimUtil;
import com.dsib.util.FileUtil;
import com.dsib.util.StringUtil;
import com.dsib.webService.AZX.ClaimGet.dto.common.xsd.MainEhm;
import com.dsib.webService.AZX.ClaimGet.dto.xsd.ClaimGetRequest;
import com.dsib.webService.AZX.ClaimGet.dto.xsd.ClaimGetResponse;
import com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType;
import com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortTypeProxy;
import com.sun.tools.javac.util.Convert;

@Controller
@SessionAttributes({ "pagination", "resultMap" })
@RequestMapping("/myclaim")
public class QyMyclaimController extends BaseController {

	@Resource(name = "QyMyclaimService")
	private QyMyclaimService myclaim;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggusercorpservice;
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;
	
	@Autowired
	private SubmitClaimUtil claimUtil;

	/**
	 * 企业用户"我的理赔"跳转至此
	 * @return
	 */
	@RequestMapping("/myclaimInit")
	public ModelAndView getMyclaimInit() {
		ModelAndView mad = new ModelAndView();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		String userCode = gguser.getUserCode();
		Pagination pagination = new Pagination();
		Map<String, Object> conditional = new HashMap<String, Object>();
		conditional.put("INSUREDCODE", userCode);
		pagination.setQueryCondition(conditional);
		List<Map<String, Object>> claimInit = myclaim.getClaimInitlize(pagination);
		pagination.setResultList(claimInit);
		mad.addObject(pagination);
		mad.setViewName("/qiye/myclaim/myclaimResult");
		return mad;
	}

	@RequestMapping("/myclaimQuery")
	public ModelAndView getMyclaimQuery() {
		ModelAndView mad = new ModelAndView();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		String userCode = gguser.getUserCode();
		String policyno = request.getParameter("POLICYNO");
		String languagec = request.getParameter("languagec");
		Map<String, Object> conditional = new HashMap<String, Object>();
		conditional.put("POLICYNO", policyno.equals("请输入保单号") ? "" : policyno);
		conditional.put("languagec", languagec);
		conditional.put("INSUREDCODE", userCode);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditional);
		List<Map<String, Object>> resultList = myclaim.getClaimInit(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/qiye/myclaim/myclaimResult");
		return mad;
	}

	/***
	 * 点击报案存数据库方法
	 * @author HSLT
	 * @param js
	 * @param printwriter
	 */
	@RequestMapping(value = "/myclaimreported", consumes = "application/json", method = RequestMethod.POST)
	public void myclaimreported(@RequestBody JSONObject js) {
		String companyCode = js.getString("userCode");//被保险人代码
		String policyNo = js.getString("policyNo");//保单号
		String sumPerson = js.getString("sumPerson");//总人数
		String startDate = js.getString("startDate");//开始日期
		String endDate = js.getString("endDate");//结束日期
		/**下列数据不可为空*/
		String userName = js.getString("userName");//报案人姓名
		String phone = js.getString("phone");//报案的联系电话
		String openDate = js.getString("openDate");//出险时间
		String amount = js.getString("amount");//估损金额
		String address = js.getString("address");//出险地点
		String yuanyin = js.getString("yuanyin");//出险原因
		
		String result = "";
		PrintWriter printwriter = null;
		try {
			//转化date类型格式
			response.setContentType("application/json;charset=utf-8");
			printwriter = response.getWriter();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date staDate = sim.parse(startDate);
			Date eDate = sim.parse(endDate);
			Date oDate = sim.parse(openDate);
			
			//根据出现时间查询报案信息,如果有不能重复提交
			GcClaim gcclaim = new GcClaim();
			gcclaim.setPolicyNo(policyNo);
			gcclaim.setLossDate(oDate);
			List<GcClaim> gcclaims = myclaim.getClaimByLossDateAndPolicyNo(gcclaim);
			if(gcclaims.size()<=0) {
				
				double am = Double.parseDouble(amount);
				/**	用出险时间和开始、结束日期对比，大于开始，小于结束，即为有效，否则“出险日期不在赔付范围内” * */
				if ((oDate.getTime() > staDate.getTime() )&&(oDate.getTime() < eDate.getTime())) {
					// 创建对象	生成报案号、赔案号
					GcClaim claim = new GcClaim();
					GuPolicyMain gupolicymain = guPolicyMainMapper.selectByPolicyNo(policyNo);
					claim.setBaoAnNo(StringUtil.getBusinessNo());//报案号
					claim.setPeiAnNo("");//赔案号
					claim.setPolicyNo(policyNo);//保单号
					claim.setLossAmount(am);//损失金额
					claim.setLossCause(yuanyin);//出险原因
					claim.setLossDate(oDate);//出险时间
					claim.setRiskCode(gupolicymain.getRiskCode());//险种代码
					claim.setBusinessNo(gupolicymain.getBusinessNo());//业务号
					claim.setLossLocaiton(address);//出险地点
					claim.setCreaterCode("");//受理人
					claim.setStatus("1");//理赔状态
					claim.setProvince(gupolicymain.getProvince());//省
					claim.setCity(gupolicymain.getCity());//市
					claim.setCounty(gupolicymain.getCounty());//区县
					claim.setInsurerCode(gupolicymain.getInsurerCode());//保险公司
					claim.setBaoanDate(new Date());//报案时间为当前日期
					claim.setLinkName(userName);//报案人
					claim.setLinkPhone(phone);//报案人手机号
					
					ClaimGetResponse service = claimUtil.claimGet(claim);
					
					/**
					 * "保单号"应该判断,
					 */
					if("1".equals(service.getResponseCode()) /*&&
							StringUtil.isNotEmpty(service.getReportNo())*/){
						// 数据增添进对象中
						
						myclaim.setClaimInsert(claim);
						GcClaim claime = new GcClaim();
						claime.setBaoAnNo(StringUtils.isEmpty(service.getReportNo()) ==
								true ? "0" : service.getReportNo());//报案号
						claime.setBusinessNo(gupolicymain.getBusinessNo());//条件1 businessno
						claime.setLossCause(yuanyin);//条件2 原因
//						myclaim.baoanNo(claime);//修改报案号
						result = "succee";
					}else {
						result = StringUtils.isEmpty(service.getResponseMessage()) ==
								true ? "failed" : service.getResponseMessage();
					}
					
				}else {
					result = "chaochufanwei";//“出险日期不在赔付范围内”
				}
			}else {
				result = "请勿重复提交!";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		printwriter.write(JSON.toJSONString(result));
	}

	
	/**
	 * 绿报案跳转至此
	 * @param printwriter
	 */
	@RequestMapping(value = "/myclaimOfQuery", consumes = "application/json", method = RequestMethod.POST)
	public void myclaimOfQuery(PrintWriter printwriter) {
		String result = "";
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		GuPolicyMain gu = new GuPolicyMain();
		
		String userCode = gguser.getUserCode();
		gu.setInsuredCode(userCode);//被保险人代码
		//根据对象查询是否存在有效的保单
		List<GuPolicyMain> resultMap = myclaim.selectByGuPolicyMain(gu);
		
		if (resultMap.size()>0) {
			result = "isHave";
		}else {
			result = "meiyouyouxiaobaodanbunengbaoan";
		}
		printwriter.write(JSON.toJSONString(result));
	}
	
	@RequestMapping("/claimShow")
	public ModelAndView getClaimShow() {
		ModelAndView mad = new ModelAndView();
		String businessno = request.getParameter("businessno");
		List<Map<String, Object>> resultMap = myclaim.getClaimShow(businessno);
		mad.addObject("resultMap", resultMap);
		mad.setViewName("/qiye/myclaim/myclaimShow");
		return mad;
	}

	@RequestMapping(value = "/claimchuan", method = RequestMethod.POST)
	public ModelAndView claimchuan(MultipartFile ACCIDENTPORT, MultipartFile DEATHPORT, MultipartFile DISABLITY) {
		ModelAndView mad = new ModelAndView();
		String accidentport = FileUtil.uploadFile(ACCIDENTPORT, request);
		String deathport = FileUtil.uploadFile(DEATHPORT, request);
		String disablity = FileUtil.uploadFile(DISABLITY, request);
		Map<String, Object> result = new HashMap<String, Object>();
		String id = request.getParameter("id");
		result = myclaim.chakan(id);
		GcClaimProve gcClaimPro = new GcClaimProve();
		gcClaimPro.setAccidentPort(accidentport);
		gcClaimPro.setBaoanNo(id);
		gcClaimPro.setDeathPort(deathport);
		gcClaimPro.setDisabLity(disablity);
		if (result == null) {
			myclaim.getClaimchuan(gcClaimPro);
		} else {
			myclaim.xiugai(gcClaimPro);
		}
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		List<Map<String, Object>> resultList = myclaim.getClaimInit(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/qiye/myclaim/myclaimResult");
		return mad;
	}

	@RequestMapping(value = "/myclaimtalk")
	public void myclaimtalk(@RequestBody GgEvaluate js,PrintWriter printWrite) {
		GgUser user = (GgUser) session.getAttribute("ggUser");
		String result = "";
		
		String userCode = user.getUserCode();
		String bananno = js.getBeEvaluator();
		Map<String, Object> reusultMap = myclaim.getClaimInsurance(bananno); // 获取保险公司，省，市，区
		String serce = js.getRemark();
		String policy = js.getFlag();
		String textname = js.getContent();
		Integer serces = Integer.parseInt(serce.substring(0, 1));
		Integer policys = Integer.parseInt(policy.substring(0, 1));
		String source = String.valueOf(serces + "-" + policys);
		
		List<Map<String, Object>> count = myclaim.talkcount(String.valueOf(reusultMap.get("INSURERCODE")));
		if (count.size() > 0) {
			result = "isHavePingjia";
		}/*else if ((textname == null)|| (textname.equals(""))) {
			result = "textnameIsNull";//评价内容为空的提示
		}*/else{
			if (serces >= 4) {
				myclaim.mySerce();
			}
			if (policys >= 4) {
				myclaim.myPolicy();
			}
			GgEvaluate ggEvaluate = new GgEvaluate();
			ggEvaluate.setSeriesNo(StringUtil.getBusinessNo());
			ggEvaluate.setScore(source); // 评价总分
			ggEvaluate.setBeEvaluator(String.valueOf(reusultMap.get("INSURERCODE"))); // 被评价人
			// -----保险公司
			ggEvaluate.setEvaluator(userCode); // 评价人
			ggEvaluate.setContent(textname);
			ggEvaluate.setProvince(String.valueOf(reusultMap.get("PROVINCE")));
			ggEvaluate.setCity(String.valueOf(reusultMap.get("CITY")));
			ggEvaluate.setCounty(String.valueOf(reusultMap.get("COUNTY")));
			myclaim.myCheckTalk(ggEvaluate);
			result = "success";
		}
		try {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	
	}

	@RequestMapping("/myclaimexcel")
	public void getMyclaimExcel(ConditionAdapter adapter, HttpServletRequest request, HttpServletResponse response) {
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		String userCode = gguser.getUserCode();
		String policyno = request.getParameter("POLICYNO");
		String languagec = request.getParameter("languagec");
		Map<String, Object> conditional = new HashMap<String, Object>();
		conditional.put("POLICYNO", policyno.equals("请输入保单号") ? "" : policyno);
		conditional.put("languagec", languagec);
		conditional.put("INSUREDCODE", userCode);
		adapter.setQueryCondition(conditional);
		List<Map<String, Object>> resultList = myclaim.getClaimExcel(adapter);
		Iterator iterator = resultList.iterator();
		while (iterator.hasNext()) {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, Object> resultMap = (Map<String, Object>) iterator.next();
			resultMap.put("LOSSDATE", sim.format(resultMap.get("LOSSDATE")));
			String stat = String.valueOf(resultMap.get("STATUS"));
			if (stat.equals("1")) {
				resultMap.put("STATUS", "报案");
			} else if (stat.equals("2")) {
				resultMap.put("STATUS", "勘察");
			} else if (stat.equals("3")) {
				resultMap.put("STATUS", "定损核损");
			} else if (stat.equals("4")) {
				resultMap.put("STATUS", "赔付");
			} else if (stat.equals("5")) {
				resultMap.put("STATUS", "完成");
			}
		}
		String[] titles = new String[] { "INSUREDNAME:被保险人", "POLICYNO:保单号", "PEIANNO:赔案号", "PAYAMOUNT:赔款金额(元)", "LOSSDATE:出险时间", "LOSSCAUSE:出险原因",
				"INSURERCODE:保险公司", "STATUS:状态" };
		List<Map<String, Object>> lists = resultList;
		Class cla = Map.class;
		String sheetName = "我的理赔信息";
		FileUtil.exportToExcel(titles, lists, cla, sheetName, response);
	}

	@RequestMapping("/myclaimPagin")
	public ModelAndView mypolicyPagin(@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = myclaim.getClaimInitPagination(pagination);
		mad.addObject(pagination);
		mad.setViewName("/qiye/myclaim/myclaimResult");
		return mad;
	}

	@RequestMapping(value = "/myclaimshowTalk")
	public ModelAndView showtalk() {
		ModelAndView mad = new ModelAndView();
		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();
		String bananno = request.getParameter("baoanno");
		Map<String, Object> reusultMap = myclaim.getClaimInsurance(bananno);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("BEEVALUATOR", String.valueOf(reusultMap.get("INSURERCODE")));
		List<Map<String, Object>> count = myclaim.talkcount(String.valueOf(reusultMap.get("INSURERCODE")));
		Iterator it = count.iterator();
		int pointcounty = 0;
		double sercecount = 0;
		double policycounty = 0;
		while (it.hasNext()) {
			Map<String, Object> countMap = (Map<String, Object>) it.next();
			//int point = Integer.parseInt(String.valueOf(countMap.get("SERIESNO")));
			pointcounty ++;
			String str = String.valueOf(countMap.get("SCORE"));
			String[] qiege = str.split("-");
			sercecount += Double.parseDouble(String.valueOf(qiege[0]));
			policycounty += Double.parseDouble(String.valueOf(qiege[1]));
		}
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
 		resultList = myclaim.historytalk(map);
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
			dou = (sercecount + policycounty) / (pointcounty*2);

		}
		
		mad.addObject("sumSize", pointcounty);
		mad.addObject("sumCount", dou);
		mad.addObject("BeEvaluator",bananno);
		mad.addObject("list_ggevaluate",resultList);
		mad.setViewName("/qiye/myclaim/myclaimShowUp");
		return mad;
		/*
		Map<String, Object> counentry = new HashMap<String, Object>();
		counentry.put("pointcounty", pointcounty);
		counentry.put("dou", df.format(dou));
		resultList.add(counentry);
		 * PrintWriter print = null;
		 * try {
			response.setCharacterEncoding("UTF-8");
			print = response.getWriter();
			print.write(JSONArray.toJSONString(resultList));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			print.flush();
			print.close();
		}*/

	}
	/**
	 * @author HSLT
	 * 点击绿报案按钮方法
	 * @return
	 */
	@RequestMapping("/myclaimOfInsert")
	public ModelAndView myclaimOfInsert() {
		ModelAndView mad = new ModelAndView();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		GcClaim gc = new GcClaim();
		GuPolicyMain gu = new GuPolicyMain();
		String userCode = gguser.getUserCode();
		gu.setInsuredCode(userCode);//被保险人代码
		//根据对象查询是否存在有效的保单
		List<GuPolicyMain> resultMap = myclaim.selectByGuPolicyMain(gu);
//		pagination.setResultList(list);
		mad.addObject("gupolicymainList", resultMap);
		mad.setViewName("/qiye/myclaim/MyClaimInsert");
		return mad;
	}
}