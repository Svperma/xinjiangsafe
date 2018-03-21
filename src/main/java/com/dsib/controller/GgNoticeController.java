package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.dsib.entity.GgNotice;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgNoticeService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GgEmployeeService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.util.StringUtil;

@Controller
@RequestMapping("/noticeList")
@SessionAttributes({ "pagination", "Num", "enddate", "corpStatus" })
public class GgNoticeController extends BaseController {
	@Resource(name = "ggemployeeService")
	private GgEmployeeService ggemployeeService;
	@Resource(name = "ggNoticeService")
	private GgNoticeService ggNoticeService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService corpService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService MainService;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;

	/**
	 * “发送消息”按钮后台代码
	 * 
	 * @author hslt
	 * @param session
	 * @param userCode
	 * @param companyName
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
	public ModelAndView sendMessage(HttpSession session,
			@RequestParam(value = "userCode", required = false) String userCode) {
		ModelAndView mav = new ModelAndView();

		Pagination pagination = new Pagination();
		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("userCode", userCode);
		pagination.setQueryCondition(pm);
		List<Map<String, Object>> notice = ggNoticeService
				.selectList(pagination);
		session.setAttribute("notoce", notice == null ? new GgNotice() : notice);
		pagination.setResultList(notice);
		mav.setViewName("/jianguan/jsp/ggNoticeSwim");
		mav.addObject("pagination", pagination);
		return mav;
	}

	/**
	 * @author hslt
	 * @param pagination
	 * @param ggNotice
	 * @param ggusercorp
	 * @param ggEvaluateDangers
	 * @param ggUser
	 * @return
	 */
	@RequestMapping(value = "/sendNotice", method = RequestMethod.POST)
	public ModelAndView sendNotice(Pagination pagination, GgNotice ggNotice) {
		ModelAndView mav = new ModelAndView();
		String userCode = request.getParameter("userCode");// 企业代码
		String userInd = request.getParameter("userIn");// 企业类型
		String title = request.getParameter("title");// 标题
		String contentSource = request.getParameter("contentSource");// 内容
		/* 随机生成一个id，存入通知表中主键 */
		String uuid = StringUtil.getUUID();
		/** 通知表 */
		GgUser us = (GgUser) session.getAttribute("ggUser");
		ggNotice.setSeriesNo(uuid);// 序号
		ggNotice.setTitle(title);// 标题
		ggNotice.setContentSource(contentSource);// 内容
		ggNotice.setPublisher(us.getUserCode());// 发布人
		ggNotice.setPublishTime(new Date());// 发布时间
		ggNotice.setRecipient(userCode);// 接收人
		ggNotice.setStatus("1");// 状态
		ggNotice.setMarkRead("0");
		ggNoticeService.insertList(ggNotice);

		List<Map<String, Object>> list_corp = ggNoticeService
				.queryListAll(pagination);
		pagination.setResultList(list_corp);

		mav.setViewName("/jianguan/jsp/ggNotice");
		mav.addObject("pagination", pagination);
		return mav;
	}

	@RequestMapping(value = "/sendNoticeUser", method = RequestMethod.POST)
	public ModelAndView sendNoticeUser() {
		ModelAndView mav = new ModelAndView();
		Pagination pagination = new Pagination();
		GgNotice ggNotice = new GgNotice();

		GgUser us = (GgUser) session.getAttribute("ggUser");

		String hfexample = request.getParameter("hfexample");//
		String title = request.getParameter("title");// 标题
		String contentSource = request.getParameter("contentSource");// 内容
		/* 截取字符串并遍历 */
		String[] str = hfexample.split(";"); // 截取
		for (int i = 0; i < str.length; i++) {
			/* 随机生成一个id，存入通知表中主键 */
			String uuid = StringUtil.getUUID();
			/** 通知表 */
			ggNotice.setSeriesNo(uuid);// 序号
			ggNotice.setTitle(title);// 标题
			ggNotice.setPublisher(us.getUserCode());// 发布人
			ggNotice.setPublishTime(new Date());// 发布时间
			/** 反编译接收人 */
			/*
			 * List<GgNotice> recipient =
			 * ggNoticeService.selectRecipientDesc(str[i]);
			 */

			ggNotice.setRecipient(str[i]);// 接收人
			ggNotice.setStatus("1");// 状态
			ggNotice.setContentSource(contentSource);// 内容
			ggNotice.setMarkRead("0");
			ggNoticeService.insertList(ggNotice);
		}
		pagination = new Pagination();
		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("reci", "0");
		pm.put("userCode", us.getUserCode());
		pagination.setQueryCondition(pm);
		List<Map<String, Object>> list_corp = ggNoticeService
				.queryListSend(pagination);
		pagination.setResultList(list_corp);

		mav.setViewName("/jianguan/jsp/ggNotice");
		mav.addObject("pagination", pagination);
		return mav;
	}

	/**
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	@RequestMapping("/querySendNotice")
	public ModelAndView querySendNotice(
			@RequestParam(value = "userCode", required = false) String userSendCode) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		String userInd = ggUser.getUserInd();
		Map<String, String> map = new HashMap<String, String>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		if ("1".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
		} else if ("2".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
			map.put("city", ggUser.getCity());
		} else if ("3".equals(comLevel)) {
			map.put("province", ggUser.getProvince());
			map.put("city", ggUser.getCity());
			map.put("county", ggUser.getCounty());
		}
		if (userSendCode == null) {
			map.put("userCode", ggUser.getUserCode());
			map.put("markRead", "0");
		}
		if (userSendCode != null) {
			map.put("userSendCode", userSendCode);
			map.put("sendUser", ggUser.getUserCode());
		}
		map.put("comLevel", ggUser.getComLevel());

		pagination.setQueryCondition(map);

		GgCode code = new GgCode();
		code.setCodeType("userInd");
		List<GgCode> list_userInd = ggCodeService.getGgCodeByObj(code);

		// 获取用户名称
		GgUser user = new GgUser();

		List<Map<String, Object>> noticeUser = ggNoticeService
				.getNoticeUser(pagination);

		List<Map<String, Object>> list_corp = ggNoticeService
				.queryListAll(pagination);
		pagination.setResultList(list_corp);

		if (userInd.equals("1")) {
			mad.setViewName("/jianguan/jsp/ggNoticeReport");
			mad.addObject("pagination", pagination);
			mad.addObject("noticeUser", noticeUser);
			mad.addObject("list_userInd", list_userInd);
			session.setAttribute("noticeUser", noticeUser);
			session.setAttribute("list_userInd", list_userInd);
			session.setAttribute("list_noticeAll", list_corp == null ? ""
					: list_corp);
			session.setAttribute("pagination", pagination);
		} else if (userInd.equals("2")) {
			mad.setViewName("/qiye/notices/ggNoticeReport");
			mad.addObject("pagination", pagination);
			mad.addObject("noticeUser", noticeUser);
			mad.addObject("list_userInd", list_userInd);
			session.setAttribute("noticeUser", noticeUser);
			session.setAttribute("list_userInd", list_userInd);
			session.setAttribute("list_noticeAll", list_corp == null ? ""
					: list_corp);
			session.setAttribute("pagination", pagination);
		}
		return mad;
	}

	@RequestMapping(value = "/selectNotice", method = RequestMethod.POST)
	public ModelAndView selectNotice(HttpSession session, GgNotice ggNotice,
			HttpServletRequest request) {

		String reci = request.getParameter("reci");
		String Readtype = request.getParameter("Readtype");
		String publisher = request.getParameter("publisher");
		String recipient = request.getParameter("recipient");
		String startNoticeDate = request.getParameter("startNoticeDate");
		String endNoticeDate = request.getParameter("endNoticeDate");

		GgUser ggUser = (GgUser) session.getAttribute("ggUser");

		String userInd = ggUser.getUserInd();
		ModelAndView mav = new ModelAndView();
		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("publisher", publisher);
		pm.put("recipient", recipient.equals("请输入接收人名称") ? "" : recipient);
		pm.put("startNoticeDate", startNoticeDate.equals("请输入开始日期") ? ""
				: startNoticeDate);
		pm.put("endNoticeDate", endNoticeDate.equals("请输入截止日期") ? ""
				: endNoticeDate);
		pm.put("Readtype", Readtype.equals("消息类型") ? "" : Readtype);
		pm.put("reci", reci);
		pm.put("user", ggUser.getUserCode());

		Pagination pagination = new Pagination();
		pagination.setQueryCondition(pm);

		// 查询数据
		List<Map<String, Object>> oneNotice = ggNoticeService
				.selectNotice(pagination);
		if (userInd.equals("1")) {
			session.setAttribute("oneNotice",
					oneNotice == null ? new GgNotice() : oneNotice);
			pagination.setResultList(oneNotice);
			mav.addObject("pagination", pagination);
			mav.setViewName("/jianguan/jsp/ggNotice");
		} else if (userInd.equals("2")) {
			session.setAttribute("oneNotice",
					oneNotice == null ? new GgNotice() : oneNotice);
			pagination.setResultList(oneNotice);
			mav.addObject("pagination", pagination);
			mav.setViewName("/qiye/notices/ggNotice");
		}
		return mav;
	}

	@RequestMapping(value = "/noticeDetails", method = RequestMethod.GET)
	public ModelAndView noticeDetails(HttpSession session, GgNotice ggNotice,
			@RequestParam(value = "seriesNo") String seriesNo,
			@RequestParam(value = "recipient") String recipient,
			@RequestParam(value = "markRead") String markRead) {
		ModelAndView mav = new ModelAndView();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		String userInd = gguser.getUserInd();
		Pagination pagination = new Pagination();
		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("seriesNo", seriesNo);
		pm.put("markRead", markRead);
		pagination.setQueryCondition(pm);
		List<Map<String, Object>> oneNotice = ggNoticeService
				.querySeriesNo(pagination);
		if (markRead.equals("0") && recipient.equals(gguser.getUserCode())) {
			ggNoticeService.updateMarkRead(ggNotice);
		}
		if (userInd.equals("1")) {
			pagination.setResultList(oneNotice);
			session.setAttribute("oneNotice",
					oneNotice == null ? new GgNotice() : oneNotice);
			session.setAttribute("pagination",
					pagination == null ? new Pagination() : pagination);
			mav.addObject("pagination", pagination);
			mav.setViewName("/jianguan/jsp/ggNoticeDetails");
		} else if (userInd.equals("2")) {
			pagination.setResultList(oneNotice);
			session.setAttribute("oneNotice",
					oneNotice == null ? new GgNotice() : oneNotice);
			session.setAttribute("pagination",
					pagination == null ? new Pagination() : pagination);
			mav.addObject("pagination", pagination);
			mav.setViewName("/qiye/notices/ggNoticeDetails");
		}
		return mav;
	}

	/**
	 * 企业用户登录后初始化
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/initData", method = RequestMethod.GET)
	public ModelAndView initData() {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		GgNotice notice = new GgNotice();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");

		Date enddate = MainService.getDate(ggUser.getUserCode());
		Integer integerCount = ggemployeeService.getNum(ggUser.getUserCode());
		pagination.setQueryCondition(ggUser.getUserCode());
		List<Map<String, Object>> list = ggNoticeService.noticeList(pagination);

		GgUserCorp ggUserCorp = corpService.selectByPrimaryKey(ggUser
				.getUserCode());
		String corpStatus = "1";
		if (ggUserCorp == null || ggUserCorp.equals("")) {
			corpStatus = "0";
		}
		// 显示未读信息
		notice.setMarkRead("0");
		notice.setRecipient(ggUser.getUserCode());
		Integer notices = ggNoticeService.getCountByNotice(notice);
		// 原本
		pagination
				.setResultList((list == null || list.size() < 0) ? new ArrayList<Map<String, Object>>()
						: list);
		mad.addObject("pagination", pagination);
		mad.addObject("Num", (integerCount == null ? 0 : integerCount));
		mad.addObject("enddate", enddate == null ? "" : enddate);
		mad.addObject("notices", notices == null ? new ArrayList<Integer>()
				: notices);
		mad.addObject("corpStatus", corpStatus);
		session.setAttribute("ggUserCorpIsHave", ggUserCorp);
		session.setAttribute("notices", notices);
		if (ggUserCorp != null) {
			mad.setViewName("/enterprise/enterpriseMainPage");
		}else {

			/**行业大类*/
			GgCode code = new GgCode();
			code.setCodeType("IndustryCategories");
			List<GgCode> list_classCode = ggCodeService.getGgCodeByObj(code);// 4
			/**企业规模*/
			code = new GgCode();
			code.setCodeType("EnterpriseScale");
			List<GgCode> list_classSize = ggCodeService.getGgCodeByObj(code);// 4
			// 安全标准化等级
			GgCode code1 = new GgCode();
//			String standardLevel = ggUserCorp.getStandardLevel();
			code1.setCodeType("StandardLevel");
			List<GgCode> list_safe = ggCodeService.getGgCodeByObj(code1);

			// 企业风险状况
			code = new GgCode();
			code.setCodeType("riskLevel");
			List<GgCode> list_riskLevel = ggCodeService.getGgCodeByObj(code);
			//省市区县
			code = new GgCode();
			code.setCodeType("Province");
			code.setCodeCode("650000");
			List<GgCode> list_pro = ggCodeService.getGgCodeByObj(code);
			code = new GgCode();
			code.setCodeType("City");
			List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
			code = new GgCode();
			code.setCodeType("County");
			List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);
			
			mad.addObject("list_classCode", list_classCode == null ? new ArrayList<GgCode>() : list_classCode);
			mad.addObject("list_safe", list_safe == null ? new ArrayList<GgCode>() : list_safe);
			mad.addObject("list_classSize", list_classSize == null ? new ArrayList<GgCode>() : list_classSize);
			mad.addObject("list_riskLevel", list_riskLevel == null ? new ArrayList<GgCode>() : list_riskLevel);
			mad.addObject("list_pro", list_pro == null ? new ArrayList<GgCode>() : list_pro);
			mad.addObject("list_city", list_city == null ? new ArrayList<GgCode>() : list_city);
			mad.addObject("list_county", list_county == null ? new ArrayList<GgCode>() : list_county);
			mad.addObject("ggUser", ggUser == null ? new GgUser()
			: ggUser);
			mad.setViewName("/qiye/mainInfo");
			return mad;
		
		}
		return mad;
	}

	/**
	 * 企业用户登录后，点击首页
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping("/noticeInfos")
	public ModelAndView noticeInfos(Pagination pagination) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");

		Date enddate = MainService.getDate(ggUser.getUserCode());
		Integer integerCount = ggemployeeService.getNum(ggUser.getUserCode());
		pagination.setQueryCondition(ggUser.getUserCode());
		List<Map<String, Object>> list = ggNoticeService.noticeList(pagination);
		// 原本
		pagination
				.setResultList((list == null || list.size() < 0) ? new ArrayList<Map<String, Object>>()
						: list);
		mad.addObject("pagination", pagination);
		mad.addObject("Num", (integerCount == null ? 0 : integerCount));
		mad.addObject("enddate", enddate == null ? "" : enddate);
		mad.setViewName("/enterprise/shouye");
		return mad;
	}

	/**
	 * 消息中心 翻页
	 * 
	 * @return
	 */
	@RequestMapping("/noticeContinue")
	public ModelAndView noticeContinue(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		String userInd = gguser.getUserInd();

		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));

		pagination = ggNoticeService.getNoticeContinue(pagination);
		mad.addObject("pagination", pagination);
		if (userInd.equals("1")) {
			mad.setViewName("/jianguan/jsp/ggNotice");
		} else if (userInd.equals("2")) {
			mad.setViewName("/qiye/notices/ggNotice");
		}
		return mad;
	}

	/**
	 * 企业用户登录首页 翻页
	 * 
	 * @param pageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/noticePage")
	public ModelAndView noticePage(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = ggNoticeService.getNoticePage(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/enterprise/shouye");
		return mad;
	}

	/**
	 * 添加消息的查询方法
	 * 
	 * @author hslt
	 */
	@RequestMapping(value = "/getGare")
	public void getGare(@RequestBody JSONObject obj,
			HttpServletResponse response) throws Exception {
		String userInd = obj.getString("userInd");
//		String userCode = obj.getString("userCode");
		GgUser u = (GgUser) session.getAttribute("ggUser");
		GgUser user = new GgUser();
		List<GgUser> NoticeUserInd = null;
		if (userInd != null && !"".equals(userInd)) {
			if (userInd.equals("2")) {
				user.setUserInd(userInd);
				user.setUserCode(u.getUserCode());
			}else {
				user.setUserInd(userInd);
				user.setUserCode(u.getUserCode());
				user.setComLevel(u.getComLevel());
				user.setCounty(u.getCounty());
			}
			NoticeUserInd = ggNoticeService.selectNotice4User(user);
		}
		/*if (NoticeUserInd.size() == 0) {
			user.setUserInd(userInd);
			user.setUserCode(u.getUserCode());
			user.setComLevel(u.getComLevel());
			user.setCity(u.getCity());
			NoticeUserInd = ggNoticeService.selectNotice4User(user);
		}else if (NoticeUserInd.size() == 0){
			user.setUserInd(userInd);
			user.setUserCode(u.getUserCode());
			user.setComLevel(u.getComLevel());
			user.setProvince(u.getProvince());
			NoticeUserInd = ggNoticeService.selectNotice4User(user);
		}*/
		String noticeUserList = "";

		noticeUserList = JSON.toJSONString(NoticeUserInd);
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
}
