package com.dsib.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgUser;
import com.dsib.service.GcClaimService;
import com.dsib.service.GgCodeService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GgovExpertService;

@Controller
@SessionAttributes({ "pagination", "resultList", "company" })
@RequestMapping("/exper")
public class GgExperController extends BaseController {

	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService GuPolicyMainService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService corpService;
	@Resource(name = "gcClaimService")
	private GcClaimService claimService;
	@Resource(name = "ggovExpertService")
	private GgovExpertService expertService;

	@RequestMapping("/experinit")
	public ModelAndView experinit(Pagination pagination) {
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
		map.put("classCode", null);
		map.put("organ", null);
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
		List<Map<String, Object>> resultList = expertService
				.getGgEXperQuery(pagination);
		GgCode code = new GgCode();
		code.setCodeType("BusinessClass");
		List<GgCode> list = ggCodeService.getGgCodeByObj(code);
		Map totalMap = corpService.getUserCorpCount(map);
		Map<String, Object> lossMap = claimService.getLossSum(map);
		Map resMap = GuPolicyMainService.getChartCount(map);
		resMap.put("TOTALCOUNT", totalMap.get("TOTALCOUNT"));
		resMap.put("LOSSAMOUNT", lossMap.get("LOSSAMOUNT"));
		mad.addObject("bcList", list == null ? new ArrayList<GgCode>() : list);
		mad.addObject("chartMap", resMap);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/experresource/experresourceResult");
		return mad;
	}

	@RequestMapping("/experquery")
	public ModelAndView experquery(HttpServletRequest request) {
		ModelAndView md = new ModelAndView();
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String businessClass = request.getParameter("businessClass");
		String languageh = request.getParameter("languageh");
		String organ = request.getParameter("organ");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("classcode", businessClass.equals("企业类型") ? ""
				: businessClass);
		conditionMap
				.put("languageh", languageh.equals("行业大类") ? "" : languageh);
		conditionMap.put("organ", organ.equals("请输入机构名称") ? "" : organ);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = expertService
				.getGgEXperQuery(pagination);
		pagination.setResultList(resultList);
		md.addObject(pagination);
		md.setViewName("/jianguan/experresource/experresourceResult");
		return md;
	}

	@RequestMapping("/experShow")
	public ModelAndView experShow(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		String OrganCode = request.getParameter("ORGCODE");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("OrgCode", OrganCode);
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = expertService
				.getExpertShow(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.addObject("resulteList", resultList.get(0));
		mad.setViewName("/jianguan/experresource/experresourceShow");
		return mad;

	}

	@RequestMapping("/experDel")
	public ModelAndView experDel(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String OrgCode = request.getParameter("ORGCODE");
		expertService.getGgExperDel(OrgCode);
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		List<Map<String, Object>> resultList = expertService
				.getGgEXperQuery(pagination);
		pagination.setResultList(resultList);
		mad.addObject("pagination", pagination);
		mad.setViewName("/jianguan/experresource/experresourceResult");
		return mad;
	}

	@RequestMapping("/expercompany")
	public ModelAndView expercompant(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		String OrgCode = request.getParameter("ORGCODE");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("OrgCode", OrgCode);
		pagination.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = expertService
				.getGgExpercommpany(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/experresource/experresourcecompany");
		return mad;
	}

	@RequestMapping("/expertalk")
	public ModelAndView expertalk(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		String OrgCode = request.getParameter("ORGCODE");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("OrgCode", OrgCode);
		pagination.setQueryCondition(conditionMap);
		List<GgEvaluate> resultList = expertService.getGgExperTalk(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/experresource/experresourceTalk");
		return mad;
	}

	@RequestMapping("/experpage")
	public ModelAndView experpage(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = expertService.getGgExperPage(pagination);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/experresource/experresourceResult");
		return mad;
	}

	@RequestMapping("/scoppage")
	public ModelAndView scoppage(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = expertService.getGgScopPage(pagination);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/experresource/experresourcecompany");
		return mad;
	}
}
