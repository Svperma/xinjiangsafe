package com.dsib.controller;

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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgUser;
import com.dsib.entity.Gupreventfeedetail;
import com.dsib.service.GcClaimService;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgCommonwealService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.util.FileUtil;

@Controller
@SessionAttributes({ "pagination", "result", "resMap" })
@RequestMapping("/weal")
public class GgCommonwealController extends BaseController {

	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService guPolicyMainService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService corpService;
	@Resource(name = "gcClaimService")
	private GcClaimService claimService;
	@Resource(name = "GgCommonweal")
	private GgCommonwealService commonweal;

	@RequestMapping("/wealinit")
	public ModelAndView getWeal() {
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

		Pagination pagination = new Pagination();
		pagination.setQueryCondition(map);
		GgCode code = new GgCode();
		code.setCodeType("BusinessClass");
		Map<String, Object> result = commonweal.getCommonsumQuery(pagination);
		List<Map<String, Object>> resultList = commonweal
				.getCommonwealQuery(pagination);
		List<GgCode> list = ggCodeService.getGgCodeByObj(code);
		Map totalMap = corpService.getUserCorpCount(map);
		Map<String, Object> lossMap = claimService.getLossSum(map);
		Map resMap = guPolicyMainService.getChartCount(map);
		resMap.put("TOTALCOUNT", totalMap.get("TOTALCOUNT"));
		resMap.put("LOSSAMOUNT", lossMap.get("LOSSAMOUNT"));
		mad.addObject("bcList", list == null ? new ArrayList<GgCode>() : list);
		mad.addObject("chartMap", resMap);
		pagination.setResultList(resultList);
		// System.out.println(session.getAttribute("pagination"));
		mad.addObject(pagination);
		mad.addObject("result", result);
		mad.setViewName("/jianguan/commonweal/commonwealResult");
		return mad;
	}

	@RequestMapping("/insertqian")
	public ModelAndView insertQian() {
		ModelAndView mad = new ModelAndView();
		List<Map<String, Object>> resultList = commonweal.getqian();
		mad.addObject("result", resultList);
		mad.setViewName("/jianguan/commonweal/commonwealInsert");
		return mad;
	}

	@RequestMapping("/wealquery")
	public ModelAndView getWealQuery(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String begindate = request.getParameter("beginDate");
		String enddate = request.getParameter("endDate");
		String active = request.getParameter("active");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("beginDate", begindate.equals("请输入开始日期") ? ""
				: begindate);
		conditionMap.put("endDate", enddate.equals("请输入截止日期") ? "" : enddate);
		conditionMap.put("active", active.equals("请输入需要查询的名称") ? "" : active);
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(conditionMap);
		Map<String, Object> result = commonweal.getCommonsumQuery(pagination);
		List<Map<String, Object>> resultList = commonweal
				.getCommonwealQuery(pagination);
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.addObject("result", result);
		mad.setViewName("/jianguan/commonweal/commonwealResult");
		return mad;
	}

	@RequestMapping(value = "/wealinsert", method = RequestMethod.POST)
	public ModelAndView getWealInsert(MultipartFile USERPROVEIN) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			GgUser ggUser = (GgUser) session.getAttribute("ggUser");
			String Province = ggUser.getProvince();
			String City = ggUser.getCity();
			String COUNTY = ggUser.getCounty();

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String tem = sdf.format(date);
			String LANGUAGEH = request.getParameter("languageh");
			String PAYAMOUNTIN = request.getParameter("PAYAMOUNTIN");
			String PAYDATEIN = request.getParameter("beginDate");
			String PRINCIPALIN = request.getParameter("PRINCIPALIN");
			String DUEBANKIN = request.getParameter("DUEBANKIN");
			String SHROFFNUMBERIN = request.getParameter("SHROFFNUMBERIN");
			String ACCEPTORIN = request.getParameter("ACCEPTORIN");
			Gupreventfeedetail gu = new Gupreventfeedetail();
			gu.setCostcode(LANGUAGEH);
			gu.setPaymount(PAYAMOUNTIN);
			String file = FileUtil.uploadFile(USERPROVEIN, request);
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			Date time = sim.parse(PAYDATEIN);
			gu.setShroffnumber(SHROFFNUMBERIN);
			gu.setPaydate(time);
			gu.setPrincipal(PRINCIPALIN);
			gu.setDuebank(DUEBANKIN);
			gu.setUserprove(file);
			gu.setAcceptor(ACCEPTORIN);
			gu.setId(tem);
			gu.setProvince(Province);
			gu.setCity(City);
			gu.setCounty(COUNTY);
			gu.setNowDate(new Date());
			gu.setCostname(LANGUAGEH);
			commonweal.getCommonInsert(gu);
			Pagination pagination = (Pagination) session
					.getAttribute("pagination");
			Map<String, Object> result = commonweal
					.getCommonsumQuery(pagination);
			List<Map<String, Object>> resultList = commonweal
					.getCommonwealQuery(pagination);

			pagination.setResultList(resultList);
			mad.addObject(pagination);
			mad.addObject("result", result);
			mad.setViewName("/jianguan/commonweal/commonwealResult");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mad;
	}

	@RequestMapping("/wealshow")
	public ModelAndView getWealSbow(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String id = request.getParameter("id");
		Map<String, Object> resMap = commonweal.getCommonShow(id);
		mad.addObject("resMap", resMap);
		mad.setViewName("/jianguan/commonweal/commonwealShow");
		return mad;
	}

	@RequestMapping("/wealToExcel")
	public void getWealToExcel(ConditionAdapter adapter,
			HttpServletRequest request, HttpServletResponse response) {
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String active = request.getParameter("active");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("beginDate", beginDate.equals("请输入开始日期") ? ""
				: beginDate);
		conditionMap.put("endDate", endDate.equals("请输入截止日期") ? "" : endDate);
		conditionMap.put("active", active.equals("请输入需要查询的名称") ? "" : active);
		adapter.setQueryCondition(conditionMap);
		List<Map<String, Object>> resultList = commonweal
				.getCommonwealExel(adapter);
		Iterator iter = resultList.iterator();
		while (iter.hasNext()) {
			Map<String, Object> i = (Map<String, Object>) iter.next();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			i.put("PAYDATE", sim.format(i.get("PAYDATE")));
		}

		// 标题
		String[] titles = new String[] { "ACCEPTOR:使用单位", "PAYDATE:使用日期",
				"PAYAMOUNT:使用金额(元)", "COSTNAME:使用项目名称" };
		// 内容

		List<Map<String, Object>> lists = resultList;
		// 类型
		Class cla = Map.class;
		String sheetName = "事故预防信息";
		FileUtil.exportToExcel(titles, lists, cla, sheetName, response);
	}

	@RequestMapping("/wealpage")
	public ModelAndView weakpage(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = commonweal.getCommonwealPage(pagination);
		mad.addObject(pagination);
		mad.setViewName("/jianguan/commonweal/commonwealResult");
		return mad;
	}
}