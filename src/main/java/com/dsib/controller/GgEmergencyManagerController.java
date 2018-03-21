package com.dsib.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgEmergencyManagerService;

@Controller
@RequestMapping("/Emergency")
@SessionAttributes({ "pagination", "businessList", "sourceList" })
public class GgEmergencyManagerController extends BaseController {
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "GgEmergencyManagerService")
	private GgEmergencyManagerService ggEmergencyService;

	@RequestMapping("/initPage")
	public ModelAndView initPage(Pagination pagination) {
		ModelAndView mad = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("emType", null);
		map.put("docSource", null);
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = ggEmergencyService
				.getEmergency(pagination);
		pagination.setResultList(list);
		GgCode ggCode = new GgCode();
		ggCode.setCodeType("BusinessClass");
		// 行业类型
		List<GgCode> businessList = ggCodeService.getGgCodeByObj(ggCode);
		ggCode.setCodeType("DocSource");
		// 文件来源
		List<GgCode> sourceList = ggCodeService.getGgCodeByObj(ggCode);
		mad.setViewName("/jianguan/emergency/ManagerResult");
		mad.addObject("pagination", pagination);
		mad.addObject("sourceList", sourceList);
		mad.addObject("businessList", businessList);
		return mad;
	}

	/**
	 * 应急管理列表
	 * 
	 * @param session
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/emergencylist", method = RequestMethod.GET, produces = "application/*;chartset=utf-8")
	public ModelAndView maininfo(HttpSession session, Pagination pagination) {
		ModelAndView mav = new ModelAndView();
		try {
			String emType = request.getParameter("emType");
			String docSource = request.getParameter("docSource");
			Map<String, Object> pm = new HashMap<String, Object>();
			pm.put("emType", emType);
			pm.put("docSource", docSource);
			pagination.setQueryCondition(pm);
			List<Map<String, Object>> list_emergency = ggEmergencyService
					.getEmergency(pagination);
			pagination.setResultList(list_emergency);
			mav.addObject("pagination", pagination);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("/jianguan/emergency/manager");
	}

}
