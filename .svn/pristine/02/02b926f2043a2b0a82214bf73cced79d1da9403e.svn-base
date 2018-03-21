package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
import com.dsib.entity.GGovexpert;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEvaluateDangers;
import com.dsib.entity.GgSubscribe;
import com.dsib.entity.GgUser;
import com.dsib.entity.GovOrgan;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgEmployeeService;
import com.dsib.service.GgEvaluateDangersService;
import com.dsib.service.GgSubscribeService;
import com.dsib.service.GgovExpertService;
import com.dsib.service.GovOrganService;
import com.dsib.util.FileUtil;
import com.dsib.util.StringUtil;

@Controller
@RequestMapping("/subScribe")
@SessionAttributes({ "pagination", "StatusEndding", "list_organ" })
public class GgSubscribeController extends BaseController {
	@Resource(name = "ggemployeeService")
	private GgEmployeeService ggemployeeService;
	@Resource(name = "ggEvaluateDangersService")
	private GgEvaluateDangersService ggEvaluateDangersService;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "govOrganService")
	private GovOrganService govOrganService;
	@Resource(name = "ggSubscribeService")
	private GgSubscribeService ggSubscribeService;
	@Resource(name = "ggovExpertService")
	private GgovExpertService govExpertService;

	@RequestMapping(value = "/Record")
	public ModelAndView Record() {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		GgUser us = (GgUser) session.getAttribute("ggUser");
		String userCode = us.getUserCode();
		String userInd = us.getUserInd();
		/**
		 * 查询除了企业之外的三方评估机构
		 */
		GgCode code = new GgCode();
		code.setCodeType("userInd");
		code.setCodeCode(userInd);
		List<GgCode> list_userInd = ggCodeService
				.getGgCodeByObjOtherCompany(code);

		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("userCode", userCode);
		pm.put("userInd", userInd);
		pagination.setQueryCondition(pm);
		List<GgEvaluateDangers> evaluateDangers = ggEvaluateDangersService
				.selectEva(pagination);

		pagination.setResultList(evaluateDangers);
		mav.setViewName("/qiye/investigate/InveStigateReport");
		mav.addObject("pagination", pagination);
		mav.addObject("list_userInd", list_userInd);
		session.setAttribute("evaluateDangers",
				evaluateDangers == null ? new GgEvaluateDangers()
						: evaluateDangers);
		session.setAttribute("list_userInd",
				list_userInd == null ? new GgEvaluateDangers() : list_userInd);
		return mav;
	}

	@RequestMapping(value = "/StatusEndding", method = RequestMethod.GET)
	public ModelAndView StatusEndding(HttpSession session,
			@RequestParam(value = "id") String id) {
		ModelAndView mav = new ModelAndView();
		GgEvaluateDangers ggEva = new GgEvaluateDangers();
		ggEva.setId(id);
		List<GgEvaluateDangers> StatusEndding = ggEvaluateDangersService
				.selectCheckDetails(ggEva);
		mav.addObject(
				"StatusEndding",
				StatusEndding == null ? new GgEvaluateDangers() : StatusEndding
						.get(0));
		mav.setViewName("/qiye/investigate/StatusEndding");
		return mav;
	}

	@RequestMapping(value = "/statusSubmit", method = RequestMethod.POST)
	public ModelAndView riskRatingInsertDetails(MultipartFile docAddress) {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		GgEvaluateDangers ggEvaluateDangers = new GgEvaluateDangers();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		String userCode = gguser.getUserCode();
		String userInd = gguser.getUserInd();

		String statusContent = request.getParameter("statusContent");// 整改内容
		String endid = request.getParameter("endId");// id
		/** 生成一个32位的随机数ID */
		String uuid = StringUtil.getUUID();
		// 整改资料数据地址
		String path = FileUtil.uploadFile(docAddress, request);

		/**
		 * 根据id更新需要整改的数据的整改状态
		 */
		ggEvaluateDangers.setId(endid);
		ggEvaluateDangers.setStatus("2");
		ggEvaluateDangersService.updateEvaStatus(ggEvaluateDangers);
		/** 评估危险源表 */
		ggEvaluateDangers.setId(uuid);// 随机数id
		ggEvaluateDangers.setUserCode(userCode);// ggusercorp表中的usercode
		ggEvaluateDangers.setEvaluator(userCode);// 页面的orgowner评估人
		ggEvaluateDangers.setUserInd(userInd);// 评估人类型-1政府2企业3保险公司4第三方
		ggEvaluateDangers.setStatusContent(statusContent);// 整改内容
		ggEvaluateDangers.setDocAddress(path);// 整改资料
		ggEvaluateDangers.setStatus("2");// 整改状态，默认为0（未整改）2整改完成
		ggEvaluateDangers.setCheckMan(userCode);// 整改负责人（企业自整改）
		ggEvaluateDangers.setCompleteDate(new Date());// 整改完成时间（提交整改的当前时间）
		ggEvaluateDangers.setRemark(endid);// remark字段存储整改所需的数据的ID

		ggEvaluateDangersService.insertEvaStatus(ggEvaluateDangers);

		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("userCode", userCode);
		pm.put("userInd", userInd);
		pagination.setQueryCondition(pm);
		List<GgEvaluateDangers> evaluateDangers = ggEvaluateDangersService
				.selectEva(pagination);
		pagination.setResultList(evaluateDangers);
		mav.setViewName("/qiye/investigate/InveStigateReport");
		mav.addObject("pagination", pagination);
		return mav;
	}

	@RequestMapping(value = "/selectEvaChecking", method = RequestMethod.GET)
	public ModelAndView selectChecking() {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		try {
			String userInd = request.getParameter("userInd");

			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("userInd", userInd.equals("请选择评估类型") ? "" : userInd);
			map.put("userCode", ggUser.getUserCode());
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list_summit = ggEvaluateDangersService
					.selectEvaChecking(pagination);
			pagination.setResultList(list_summit);
			session.setAttribute("pagination", pagination);
			mad.setViewName("/qiye/investigate/InveStigateContion");
			mad.addObject("pagination", pagination);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}

	@RequestMapping(value = "/addInveStigate", method = RequestMethod.GET)
	public ModelAndView addInveStigate(Pagination pagination) {
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		try {
			String userCode = ggUser.getUserCode();

			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("userCode", userCode);
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list_organ = govOrganService
					.addInveStigateByOrgan(pagination);

			pagination.setResultList(list_organ);
			session.setAttribute("pagination", pagination);
			session.setAttribute("list_organ", list_organ);
			mad.addObject("pagination", pagination);
			mad.addObject("list_organ", list_organ == null ? new GovOrgan()
					: list_organ);
			mad.setViewName("/qiye/investigate/addInveStigate");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}

	@RequestMapping(value = "/getGare")
	public void getGare(@RequestBody JSONObject obj,
			HttpServletResponse response) throws Exception {
		String orgCode = obj.getString("orgCode");

		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();

		GovOrgan govOrgan = new GovOrgan();
		if (orgCode != null && !"".equals(orgCode)) {
			govOrgan.setOrgCode(orgCode);
			govOrgan.setBusinessType(userCode);
		}
		List<GovOrgan> govOrgans = govOrganService
				.selectGovorganByCode(govOrgan);
		String govOrganList = "";
		session.setAttribute("province", govOrgans.get(0).getProvince());
		session.setAttribute("city", govOrgans.get(0).getCity());
		session.setAttribute("county", govOrgans.get(0).getCounty());
		session.setAttribute("businessType", govOrgans.get(0).getBusinessType());
		session.setAttribute("langUage", govOrgans.get(0).getLangUage());
		govOrganList = JSON.toJSONString(govOrgans);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(govOrganList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/inveStigateSubmit")
	public void inveStigateSubmit(@RequestBody JSONObject obj,
			HttpServletResponse response) throws Exception {
		String orgCode = obj.getString("orgCode");
		String evaDate = obj.getString("evaDate");

		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();

		GgSubscribe scribe = new GgSubscribe();
		/** 生成一个32位的随机数ID */
		String uuid = StringUtil.getUUID();
		SimpleDateFormat evadate = new SimpleDateFormat("yyyy-MM-dd");
		Date evaluaDate = evadate.parse(evaDate);

		GovOrgan govOrgan = new GovOrgan();
		Date nowdate = new Date();
		govOrgan.setOrgCode(orgCode);
		govOrgan.setBusinessType(userCode);
		List<GovOrgan> govOrgans = govOrganService
				.selectGovorganByCode(govOrgan);

		scribe.setId(uuid);
		scribe.setUserCode(user.getUserCode());
		scribe.setUserName(user.getUserName());
		scribe.setProvince(govOrgans.get(0).getProvince());
		scribe.setCity(govOrgans.get(0).getCity());
		scribe.setCounty(govOrgans.get(0).getCounty());
		scribe.setAddress(govOrgans.get(0).getAddress());
		scribe.setLinkName(govOrgans.get(0).getOrgOwner());
		scribe.setTelePhone(govOrgans.get(0).getPhone());
		scribe.setMobile(govOrgans.get(0).getPhone());
		scribe.setOrgCode(orgCode);
		scribe.setOrgName(govOrgans.get(0).getOrgName());
		scribe.setSubScribeDate(nowdate);
		scribe.setEvaluatDate(evaluaDate);
		scribe.setEvaluatTion("0");// 评估状态默认为0：未评估
		scribe.setFlag("1");// 预约人类型：1机构2专家

		boolean list = ggSubscribeService.insertInveStigate(scribe);
		System.out.println(list);
		String govOrganList = "";
		govOrganList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(govOrganList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/inveStigateExpertSubmit")
	public void inveStigateExpertSubmit(@RequestBody JSONObject obj,
			HttpServletResponse response) throws Exception {
		String expCode = obj.getString("expcode");
		String evaDate = obj.getString("evaDate");

		GgUser user = (GgUser) session.getAttribute("ggUser");
		String userCode = user.getUserCode();

		GgSubscribe scribe = new GgSubscribe();
		/** 生成一个32位的随机数ID */
		String uuid = StringUtil.getUUID();
		SimpleDateFormat evadate = new SimpleDateFormat("yyyy-MM-dd");
		Date evaluaDate = evadate.parse(evaDate);

		Date nowdate = new Date();
		GGovexpert govExpert = new GGovexpert();
		govExpert.setExpcode(expCode);
		List<GGovexpert> govExpertByExpCode = govExpertService
				.selectGovorganByCode(govExpert);

		scribe.setId(uuid);
		scribe.setUserCode(user.getUserCode());
		scribe.setUserName(user.getUserName());
		scribe.setProvince(govExpertByExpCode.get(0).getProvince());
		scribe.setCity(govExpertByExpCode.get(0).getCity());
		scribe.setCounty(govExpertByExpCode.get(0).getCounty());
		scribe.setAddress(govExpertByExpCode.get(0).getAddress());
		scribe.setLinkName(govExpertByExpCode.get(0).getExName());
		scribe.setTelePhone(govExpertByExpCode.get(0).getPhone());
		scribe.setMobile(govExpertByExpCode.get(0).getPhone());
		scribe.setOrgCode(govExpertByExpCode.get(0).getExpcode());
		scribe.setOrgName(govExpertByExpCode.get(0).getExName());
		scribe.setSubScribeDate(nowdate);
		scribe.setEvaluatDate(evaluaDate);
		scribe.setEvaluatTion("0");// 评估状态默认为0：未评估
		scribe.setFlag("2");// 预约人类型：1机构2专家

		boolean list = ggSubscribeService.insertInveStigate(scribe);
		System.out.println(list);
		String govOrganList = "";
		govOrganList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(govOrganList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/sendGovOrganByOrgCode")
	public ModelAndView sendGovOrganByOrgCode(
			@RequestParam(value = "orgCode", required = false) String orgCode,
			@RequestParam(value = "expCode", required = false) String expCode) {
		ModelAndView mav = new ModelAndView();
		GgUser user = (GgUser) session.getAttribute("ggUser");
		if (orgCode != null && expCode == null) {
			GovOrgan govOrgan = new GovOrgan();
			govOrgan.setBusinessType(user.getUserCode());
			govOrgan.setOrgCode(orgCode);
			List<GovOrgan> govOrganByOrgCode = govOrganService
					.selectGovorganByCode(govOrgan);
			session.setAttribute("govOrganByOrgCode", govOrganByOrgCode.get(0));
			mav.addObject("govOrganByOrgCode", govOrganByOrgCode);
			mav.setViewName("/qiye/investigate/addInveStigateContion");
		}
		if (expCode != null && orgCode == null) {
			GGovexpert govExpert = new GGovexpert();
			govExpert.setExpcode(expCode);
			List<GGovexpert> govExpertByExpCode = govExpertService
					.selectGovorganByCode(govExpert);
			session.setAttribute("govExpertByExpCode",
					govExpertByExpCode.get(0));
			mav.addObject("govOrganByOrgCode", govExpertByExpCode);
			mav.setViewName("/qiye/investigate/addInveStigateExpertContion");
		}
		return mav;
	}
}
