package com.dsib.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.common.Pagination;
import com.dsib.entity.GgUser;
import com.dsib.service.GgovExpertService;
import com.dsib.service.GovOrganService;

@Controller
@RequestMapping("/organ")
@SessionAttributes("pagination")
public class GovOrganController extends BaseController {

	@Resource(name = "govOrganService")
	private GovOrganService govOrganService;
	@Resource(name = "ggovExpertService")
	private GgovExpertService ggovExpertService;

	@RequestMapping(value = "/govOrganOrGovExpert", method = RequestMethod.GET, produces = "application/*;chartset=UTF-8")
	public ModelAndView userCorpInfo() {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");

		String userCode = ggUser.getUserCode();

		String orgName = request.getParameter("orgName");
		String orgClass = request.getParameter("orgClass");
		String orgOrganOrExpert = request.getParameter("orgOrganOrExpert");

		Map<String, String> map = new HashMap<String, String>();
		try {
			if (orgClass.equals("请选择等级") || "1".equals(orgClass)) {
				map.put("province", null);
				map.put("city", null);
				map.put("county", null);
			} else if ("2".equals(orgClass)) {
				map.put("province", ggUser.getProvince());
			} else if ("3".equals(orgClass)) {
				map.put("province", ggUser.getProvince());
				map.put("city", ggUser.getCity());
			} else if ("4".equals(orgClass)) {
				map.put("province", ggUser.getProvince());
				map.put("city", ggUser.getCity());
				map.put("county", ggUser.getCounty());
			}
			map.put("orgName", orgName.equals("请输入要查询的机构或专家") ? "" : orgName);
			map.put("orgOrganOrExpert", orgOrganOrExpert);
			map.put("userCode", userCode);

			if (orgOrganOrExpert.equals("1")) {
				pagination.setQueryCondition(map);
				List<Map<String, Object>> list_organ = govOrganService
						.addInveStigateByOrgan(pagination);
				pagination.setQueryCondition(map);
				pagination.setResultList(list_organ);
				mad.addObject("pagination", pagination);
				mad.setViewName("/qiye/investigate/addInveStigateList");
			}
			if (orgOrganOrExpert.equals("0")) {
				pagination.setQueryCondition(map);
				List<Map<String, Object>> list_expert = ggovExpertService
						.addInveStigateByExpert(pagination);
				pagination.setQueryCondition(map);
				pagination.setResultList(list_expert);
				mad.addObject("pagination", pagination);
				mad.setViewName("/qiye/investigate/addInveStigateExpertList");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mad.addObject("pagination", pagination);
		return mad;
	}

	@RequestMapping("/yuyueListContinue")
	public ModelAndView yuyueListContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		String userCode = gguser.getUserCode();

		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		Map queryCondition = (Map) pagination.getQueryCondition();
		String orgOrganOrExpert = (String) queryCondition
				.get("orgOrganOrExpert");
		if (orgOrganOrExpert.equals("1")) {
			List<Map<String, Object>> list_organ = govOrganService
					.addInveStigateByOrgan(pagination);
			pagination.setResultList(list_organ);
			mad.addObject("pagination", pagination);
			mad.setViewName("/qiye/investigate/addInveStigateList");
		}
		if (orgOrganOrExpert.equals("0")) {
			List<Map<String, Object>> list_expert = ggovExpertService
					.addInveStigateByExpert(pagination);
			pagination.setResultList(list_expert);
			mad.addObject("pagination", pagination);
			mad.setViewName("/qiye/investigate/addInveStigateExpertList");
		}
		return mad;
	}
}
