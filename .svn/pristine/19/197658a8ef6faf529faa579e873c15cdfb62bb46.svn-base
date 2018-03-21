package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgUser;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgEvaluaService;
import com.dsib.service.GgNoticeService;
import com.dsib.util.StringUtil;

@Controller
@RequestMapping("/myConsult")
@SessionAttributes("pagination")
public class GgEvaluaController extends BaseController {

	@Autowired
	private GgEvaluaService ggEvaluaService;

	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "ggNoticeService")
	private GgNoticeService ggNoticeService;

	/**
	 * 咨询/投诉 初始化
	 * 
	 * @author hslt
	 * @param session
	 * @return
	 */
	@RequestMapping("/getConplainAndFeedback")
	public ModelAndView getConplainAndFeedback(HttpSession session) {
		ModelAndView mad = new ModelAndView();
		GgUser user = (GgUser) session.getAttribute("ggUser");
		// 获取条件
		Pagination pagination = new Pagination();
		GgCode code = new GgCode();
		code.setCodeType("userInd");
		code.setCodeCode(user.getUserInd());
		List<GgCode> userInd = ggCodeService.getGgCodeByObjOtherCompany(code);

		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userCode", user.getUserCode());
		pagination.setQueryCondition(conditionMap);
		List<GgEvaluate> list1 = ggEvaluaService
				.getComplainAndFeedback(pagination);
		pagination.setResultList(list1);
		mad.addObject("pagination", pagination);
		mad.addObject("userInd", userInd);
		mad.setViewName("/qiye/MyConsult/MyConsultReport");
		return mad;
	}

	@RequestMapping(value = "/getGare")
	public void getGare(@RequestBody JSONObject obj,
			HttpServletResponse response) throws Exception {
		String userInd = obj.getString("userInd");
		GgUser u = (GgUser)session.getAttribute("ggUser");
		if(userInd.equals("4")){
			userInd="3";
		}else if(userInd.equals("3")){
			userInd="4";
		}
		GgUser user = new GgUser();
		user.setUserInd(userInd);
		user.setUserCode(u.getUserCode());
		user.setCounty(u.getCounty());
		List<GgUser> UserInd = ggNoticeService.selectNotice4User(user);
		if (UserInd.size() == 0) {
			user.setUserInd(userInd);
			user.setUserCode(u.getUserCode());
			user.setComLevel(u.getComLevel());
			user.setCity(u.getCity());
			UserInd = ggNoticeService.selectNotice4User(user);
		}else if (UserInd.size() == 0){
			user.setUserInd(userInd);
			user.setUserCode(u.getUserCode());
			user.setComLevel(u.getComLevel());
			user.setProvince(u.getProvince());
			UserInd = ggNoticeService.selectNotice4User(user);
		}

		String noticeUserList = "";
		noticeUserList = JSON.toJSONString(UserInd);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(noticeUserList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/sendConsult", method = RequestMethod.POST)
	public ModelAndView sendNoticeUser() {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		GgEvaluate ggEvaluate = new GgEvaluate();

		GgUser us = (GgUser) session.getAttribute("ggUser");

		String hfexample = request.getParameter("hfexample");//
		String attributeId = request.getParameter("attr");// 操作类型5咨询3投诉
		String contentSource = request.getParameter("contentSource");// 内容
		/* 截取字符串并遍历 */
		String[] str = hfexample.split(";"); // 截取
		for (int i = 0; i < str.length; i++) {
			/* 随机生成一个32位id，存入通知表中主键 */
			String uuid = StringUtil.getUUID();
			/** 通知表 */
			ggEvaluate.setSeriesNo(uuid);// 序号
			ggEvaluate.setBeEvaluator(us.getUserCode());// 被评价人
			if (attributeId.equals("5")) {
				ggEvaluate.setItem("5");// item类型5是咨询6是投诉
			}
			if (attributeId.equals("3")) {
				ggEvaluate.setItem("6");// item类型5是咨询6是投诉
			}
			ggEvaluate.setContent(contentSource);// 咨询内容
			ggEvaluate.setEvaluator(str[i]);// ‘我’咨询/投诉的对方
			ggEvaluate.setEvaluateTime(new Date());// 咨询时间为当前发送时间
			ggEvaluate.setAttributeId(attributeId);// 区分：5是咨询3是投诉
			ggEvaluate.setProvince(us.getProvince());
			ggEvaluate.setCity(us.getCity());
			ggEvaluate.setCounty(us.getCounty());
			ggEvaluaService.insertSendConsult(ggEvaluate);
		}
		GgCode code = new GgCode();
		code.setCodeType("userInd");
		code.setCodeCode(us.getUserInd());
		List<GgCode> userInd = ggCodeService.getGgCodeByObjOtherCompany(code);

		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userCode", us.getUserCode());
		conditionMap.put("attributeId", attributeId);
		pagination.setQueryCondition(conditionMap);
		List<GgEvaluate> list1 = ggEvaluaService.selectZixun(pagination);
		pagination.setResultList(list1);

		mav.addObject("pagination", pagination);
		mav.addObject("userInd", userInd);
		mav.setViewName("/qiye/MyConsult/MyConsultContion");
		return mav;
	}

	@RequestMapping(value = "/selectZixun")
	public ModelAndView selectZixun(
			@RequestParam(value = "attr") String attributeId) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		try {
			GgEvaluate eva = new GgEvaluate();
			eva.setAttributeId(attributeId);
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("attributeId", attributeId);
			map.put("userCode", ggUser.getUserCode());
			pagination.setQueryCondition(map);
			List<GgEvaluate> list1 = ggEvaluaService.selectZixun(pagination);
			pagination.setResultList(list1);
			mad.addObject("pagination", pagination);
			mad.setViewName("/qiye/MyConsult/MyConsultContion");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}

	/**
	 * 我的投诉/咨询 翻页
	 * 
	 * @author hslt
	 * @return
	 */
	@RequestMapping("/myConsultContinue")
	public ModelAndView myConsultContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = null;
		pagination = (Pagination) session.getAttribute("pagination");
		GgUser user = (GgUser) session.getAttribute("ggUser");
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("attributeId", ((GgEvaluate) pagination.getResultList().get(0))
				.getAttributeId());
		map.put("userCode", user.getUserCode());
		pagination.setQueryCondition(map);
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = ggEvaluaService
				.getMyConsultContinuePaginations(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/qiye/MyConsult/MyConsultContion");
		return mad;
	}
}
