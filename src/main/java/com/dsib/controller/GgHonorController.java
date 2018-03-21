package com.dsib.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.common.Pagination;
import com.dsib.entity.GgHonor;
import com.dsib.entity.GgUser;
import com.dsib.service.GgHonorService;
import com.dsib.util.FileUtil;
import com.dsib.util.StringUtil;

@Controller
@RequestMapping("/honor")
@SessionAttributes("pagination")
public class GgHonorController extends BaseController {
	@Resource(name = "ggHonorService")
	private GgHonorService ggHonorService;

	// 初始化
	@RequestMapping(value = "/initialization")
	public ModelAndView Record() {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		GgUser us = (GgUser) session.getAttribute("ggUser");
		String userCode = us.getUserCode();

		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("userCode", userCode);
		pagination.setQueryCondition(pm);
		List<Map<String, Object>> selectAll = ggHonorService
				.selectAll(pagination);

		pagination.setResultList(selectAll);
		mav.addObject("pagination", pagination);
		mav.setViewName("/qiye/honor/MyHonorReport");
		return mav;
	}

	// 查询
	@RequestMapping(value = "/selectClass", method = RequestMethod.GET)
	public ModelAndView selectChecking() {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		try {
			String honorCode = request.getParameter("honorCode");

			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("honorCode", honorCode.equals("请选择评估类型") ? "" : honorCode);
			map.put("userCode", ggUser.getUserCode());
			pagination.setQueryCondition(map);
			List<Map<String, Object>> selectQueryByHonorCode = ggHonorService
					.selectQueryByHonorCode(pagination);
			pagination.setResultList(selectQueryByHonorCode);
			mad.addObject("pagination", pagination);
			mad.setViewName("/qiye/honor/MyHonorList");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}

	// 逻辑删除
	@RequestMapping(value = "/deleteById", method = RequestMethod.GET)
	public ModelAndView deleteById() {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		GgHonor honor = new GgHonor();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String userCode = ggUser.getUserCode();
		try {
			String id = request.getParameter("id");
			honor.setId(id);
			honor.setUserCode(userCode);
			ggHonorService.deleteById(honor);

			Map<String, Object> pm = new HashMap<String, Object>();
			pm.put("userCode", userCode);
			pagination.setQueryCondition(pm);
			List<Map<String, Object>> selectAll = ggHonorService
					.selectAll(pagination);
			pagination.setResultList(selectAll);
			mad.addObject("pagination", pagination);
			mad.setViewName("/qiye/honor/MyHonorList");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}

	@RequestMapping(value = "/addHonor", method = RequestMethod.POST)
	public ModelAndView addHonor(MultipartFile docAddress) {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		GgHonor ggHonor = new GgHonor();
		try {
			String honor = request.getParameter("honor");// 荣誉名称
			String getate = request.getParameter("getDate");// 获得荣誉日期
			String postUtil = request.getParameter("postUtil");// 颁发荣誉单位
			String classCode = request.getParameter("classCode");// 颁发荣誉级别
			String endDate = request.getParameter("endDate");// 荣誉有效期

			/** 生成一个32位的随机数ID */
			String uuid = StringUtil.getUUID();
			/** 获取当前用户 **/
			GgUser gguser = (GgUser) session.getAttribute("ggUser");
			String userCode = gguser.getUserCode();
			// 保存证书地址
			String path = FileUtil.uploadFile(docAddress, request);
			// 格式化获得荣誉日期
			SimpleDateFormat evadate = new SimpleDateFormat("yyyy-MM-dd");
			Date getDate = evadate.parse(getate);
			// 荣誉有效期，如果是永久性的，输入forever的日期，否则取输入的日期
			String forever = "9999-12-31";
			Date date = new Date();
			if (endDate.equals("0")) {
				Date postDate = evadate.parse(forever);
				ggHonor.setValidityDate(postDate);
				ggHonor.setValidity("1");
				if (postDate.getTime() > date.getTime()) {
					ggHonor.setValidity("1");
				} else {
					ggHonor.setValidity("0");
				}
			} else {
				String poate = request.getParameter("postDate");// 荣誉有效期
				Date postDate = evadate.parse(poate);
				ggHonor.setValidityDate(postDate);
				ggHonor.setValidity("1");
				if (postDate.getTime() > date.getTime()) {
					ggHonor.setValidity("1");
				} else {
					ggHonor.setValidity("0");
				}
			}

			/** 荣誉表 */
			ggHonor.setId(uuid);
			ggHonor.setUserCode(userCode);// 得奖单位代码
			ggHonor.setHonor(honor);// 荣誉名称
			ggHonor.setGetDate(getDate);// 得奖日期
			ggHonor.setPostUtil(postUtil);// 颁发单位
			ggHonor.setRewardsClassCode(classCode);// 颁发级别
			ggHonor.setCentralizeAddress(path);// 证书地址

			ggHonorService.addHonor(ggHonor);

			Map<String, Object> pm = new HashMap<String, Object>();
			pm.put("userCode", userCode);
			pagination.setQueryCondition(pm);
			List<Map<String, Object>> selectAll = ggHonorService
					.selectAll(pagination);
			pagination.setResultList(selectAll);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("pagination", pagination);
		mav.setViewName("/qiye/honor/MyHonorList");
		return mav;
	}

	@RequestMapping("/MyHonorPagination")
	public ModelAndView myConsultContinue(
			@RequestParam("pageNo") String pageNo, HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = null;
		pagination = (Pagination) session.getAttribute("pagination");
		GgUser user = (GgUser) session.getAttribute("ggUser");
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("userCode", user.getUserCode());
		pagination.setQueryCondition(map);
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = ggHonorService.getMyHonorPagination(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/qiye/honor/MyHonorList");
		return mad;
	}
}
