package com.dsib.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgUser;
import com.dsib.service.GcClaimService;
import com.dsib.service.GgCodeService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.GgTroubleService;
import com.dsib.service.GgUserCorpService;

@Controller
@SessionAttributes({ "pagination", "ggAccident" })
@RequestMapping("/troublehandle")
public class TroubleHandeleController extends BaseController {

	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService guPolicyMainService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService corpService;
	@Resource(name = "gcClaimService")
	private GcClaimService claimService;
	@Resource(name = "ggTroubleService")
	private GgTroubleService troubleService;

	@RequestMapping("/troubleinit")
	public ModelAndView troubleinit(Pagination pagination) {
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
		map.put("bussiness", null);
		map.put("beginDate", null);
		map.put("endDate", null);
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
		pagination.setQueryCondition(map);
		List<Map<String, Object>> lister = troubleService
				.getTroublehandle(pagination);
		GgCode code = new GgCode();
		code.setCodeType("BusinessClass");
		List<GgCode> list = ggCodeService.getGgCodeByObj(code);
		Map totalMap = corpService.getUserCorpCount(map);
		Map<String, Object> lossMap = claimService.getLossSum(map);
		Map resMap = guPolicyMainService.getChartCount(map);
		resMap.put("TOTALCOUNT", totalMap.get("TOTALCOUNT"));
		resMap.put("LOSSAMOUNT", lossMap.get("LOSSAMOUNT"));
		mad.addObject("bcList", list == null ? new ArrayList<GgCode>() : list);
		mad.addObject("chartMap", resMap);
		pagination.setResultList(lister);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/troublehandle/troublehandleResult");
		return mad;
	}

	@RequestMapping("/troublequery")
	public ModelAndView troublequery(HttpServletRequest request,
			Pagination pagination) throws SQLException, ParseException {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String begindate = request.getParameter("beginDate");
		String enddate = request.getParameter("endDate");
		String business = request.getParameter("name");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap
				.put("business", business.equals("请输入企业名称") ? "" : business);
		conditionMap.put("beginDate", begindate.equals("请输入开始日期") ? ""
				: begindate);
		conditionMap.put("endDate", enddate.equals("请输入截止日期") ? "" : enddate);
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> lister = troubleService
				.getTroublehandle(pagination);
		pagination.setResultList(lister);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/troublehandle/troublehandleResult");
		return mad;
	}

	@RequestMapping("/troubleshow")
	public ModelAndView troubleshow(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String id = request.getParameter("id");
		System.out.println("获取当前id" + id);
		Map<String, Object> gtaccident = troubleService.getShow(id);
		mad.addObject("gtaccident", gtaccident);
		mad.setViewName("/jianguan/troublehandle/troublehandleShow");
		return mad;
	}
}
