package com.dsib.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dsib.common.ConditionAdapter;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgCompanySum;
import com.dsib.entity.GgNotice;
import com.dsib.entity.GgUser;
import com.dsib.service.GcClaimService;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgCommonwealService;
import com.dsib.service.GgNoticeService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.InsurePolicyService;
import com.sun.tools.internal.ws.processor.model.Model;

@Controller
@SessionAttributes({ "province", "city", "county", "bcList", "chartMap",
		"noticeList", "count" })
@RequestMapping("/publish")
public class PublishController extends BaseController {

	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService GuPolicyMainService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService corpService;
	@Resource(name = "gcClaimService")
	private GcClaimService claimService;
	@Resource(name = "ggNoticeService")
	private GgNoticeService ggNoticeService;
	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	@Resource
	private GgCommonwealService commonwealService;

//	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@RequestMapping("/initPage")
	public ModelAndView initPage(GgNotice notice) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		String userInd = ggUser.getUserInd();
		String flag = ggUser.getFlag();
		GgCode province = null;
		GgCode city = null;
		GgCode county = null;
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		map.put("classCode", null);
		map.put("beginDate", null);
		map.put("endDate", null);
		String areaCode = "";
		if ("1".equals(comLevel)) {
			// 省级用户
			province = ggCodeService.getGgCode(ggUser.getProvince());
			map.put("province", province.getCodeCode());
			areaCode = province.getCodeCode();
		} else if ("2".equals(comLevel)) {
			// 市
			province = ggCodeService.getGgCode(ggUser.getProvince());
			city = ggCodeService.getGgCode(ggUser.getCity());
			map.put("province", province.getCodeCode());
			map.put("city", city.getCodeCode());
			areaCode = city.getCodeCode();
		} else if ("3".equals(comLevel)) {
			province = ggCodeService.getGgCode(ggUser.getProvince());
			city = ggCodeService.getGgCode(ggUser.getCity());
			county = ggCodeService.getGgCode(ggUser.getCounty());
			map.put("province", province.getCodeCode());
			map.put("city", city.getCodeCode());
			map.put("county", county.getCodeCode());
			areaCode = county.getCodeCode();
		}
		// GgNotice notice = new GgNotice();
		notice.setMarkRead("0");
		notice.setRecipient(ggUser.getUserCode());
		Integer notices = ggNoticeService.getCountByNotice(notice);
		//获取行业大类
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list = ggCodeService.getGgCodeByObj(code);
		//获取企业总数
//		Map totalMap = corpService.getUserCorpCount(map);
//		Map<String, Object> lossMap = claimService.getLossSum(map);
		
		//premium(总保费),preventFee(事故预防费),appliCount(企业总数)
		Map resMap = GuPolicyMainService.getChartCount(map);
		Map preventFee = GuPolicyMainService.getPreventFee(map);//总事故预防费
		double sumUsePreventFee = commonwealService.getSumUsePreventFee(map);//总使用的事故预防费用
		
		if(null == preventFee) {
			preventFee = new HashMap<>();
		}
		BigDecimal prevent = (BigDecimal) preventFee.get("PREVENTFEE");
		
		
		resMap.put("PREVENTFEE",String.valueOf(prevent));
//		resMap.put("TOTALCOUNT", totalMap.get("TOTALCOUNT"));
		if("1".equals(comLevel)){
			Map<String, Object> map2 = new HashMap<String, Object>();
			ConditionAdapter adapter = new ConditionAdapter();
			adapter.setQueryCondition(map2);
			map2.put("level", "2");
			List<Map<String, Object>> list2 = insurePolicyService.selectCompanySum(adapter);
			int sum = 0;
			for(int i=0;i<list2.size();i++){
				sum = sum + Integer.valueOf((String) list2.get(i).get("COMPANY_SUM"));
			}
			resMap.put("TOTALCOUNT", sum);
		}else{
			GgCompanySum sum = insurePolicyService.selectByPrimaryKeyC(areaCode);
			resMap.put("TOTALCOUNT", sum == null ? 1:sum.getCompanySum());
		}
//		resMap.put("LOSSAMOUNT", lossMap.get("LOSSAMOUNT"));
		resMap.put("LOSSAMOUNT", sumUsePreventFee);

		if (userInd.equals("1")) {
			mad.addObject("province", province == null ? new GgCode()
					: province);
			mad.addObject("city", city == null ? new GgCode() : city);
			mad.addObject("county", county == null ? new GgCode() : county);
			mad.addObject("bcList", list == null ? new ArrayList<GgCode>()
					: list);
			mad.addObject("notices", notices == null ? new ArrayList<Integer>()
					: notices);
			session.setAttribute("notices", notices);
			mad.addObject("chartMap", resMap);
			mad.setViewName("/common/mainPage");
		} else if (userInd.equals("2")) {
			mad.addObject("province", province == null ? new GgCode()
					: province);
			mad.addObject("city", city == null ? new GgCode() : city);
			mad.addObject("county", county == null ? new GgCode() : county);
			mad.addObject("bcList", list == null ? new ArrayList<GgCode>()
					: list);
			mad.addObject("notices", notices == null ? new ArrayList<Integer>()
					: notices);
			session.setAttribute("notices", notices);
			mad.addObject("chartMap", resMap);
			mad.setViewName("/enterprise/enterpriseMainPage");
		}
		return mad;

	}

//	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@RequestMapping("/query")
	public ModelAndView query(HttpServletRequest request) {
		ModelAndView mad = new ModelAndView();
		String province = request.getParameter("hidden_province1");
		String city = request.getParameter("hidden_city1");
		String county = request.getParameter("hidden_county1");
		String classCode = request.getParameter("businessClass");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("province", province);
		conditionMap.put("city", city);
		conditionMap.put("county", county);
		conditionMap.put("classCode", classCode);
		conditionMap.put("beginDate", beginDate.equals("请输入开始日期") ? ""
				: beginDate);
		conditionMap.put("endDate", endDate.equals("请输入截止日期") ? "" : endDate);
		Map totalMap = corpService.getUserCorpCount(conditionMap);
//		Map<String, Object> lossMap = claimService.getLossSum(conditionMap);
		Map resMap = GuPolicyMainService.getChartCount(conditionMap);//里面有一个总保费
		Map preventFee = GuPolicyMainService.getPreventFee(conditionMap);//总事故预防费
		double sumUsePreventFee = commonwealService.getSumUsePreventFee(conditionMap);//总使用的事故预防费用
		
		BigDecimal prevent = (BigDecimal) preventFee.get("PREVENTFEE");
//		BigDecimal practical_preventFee = prevent.subtract(sumUsePrevent);
		
		resMap.put("PREVENTFEE",prevent);
//		resMap.put("TOTALCOUNT", totalMap.get("TOTALCOUNT"));
		String areaCode = "";
		if(!"".equals(county)){
			areaCode=county;
			GgCompanySum sum = insurePolicyService.selectByPrimaryKeyC(areaCode);
			resMap.put("TOTALCOUNT", sum == null ? 1:sum.getCompanySum());
		}else if(!"".equals(city)){
			areaCode=city;
			GgCompanySum sum = insurePolicyService.selectByPrimaryKeyC(areaCode);
			resMap.put("TOTALCOUNT", sum == null ? 1:sum.getCompanySum());
		}else{
			areaCode=province;
			Map<String, Object> map2 = new HashMap<String, Object>();
			ConditionAdapter adapter = new ConditionAdapter();
			adapter.setQueryCondition(map2);
			map2.put("level", "2");
			List<Map<String, Object>> list2 = insurePolicyService.selectCompanySum(adapter);
			int sum = 0;
			for(int i=0;i<list2.size();i++){
				sum = sum + Integer.valueOf((String) list2.get(i).get("COMPANY_SUM"));
			}
			resMap.put("TOTALCOUNT", sum);
		}
//		resMap.put("LOSSAMOUNT", lossMap.get("LOSSAMOUNT"));
		resMap.put("LOSSAMOUNT", sumUsePreventFee);
		mad.setViewName("/jianguan/publisher/publishResult");
		session.setAttribute("chartMap", resMap);	
		mad.addObject("chartMap", resMap);
		return mad;
	}
	
	@RequestMapping("/initDiagram")
	public ModelAndView initDiagram() {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		String comLevel = ggUser.getComLevel();
		String userInd = ggUser.getUserInd();
		String flag = ggUser.getFlag();
		GgCode province = null;
		GgCode city = null;
		GgCode county = null;
		// 统计条件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("province", null);
		map.put("city", null);
		map.put("county", null);
		map.put("classCode", null);
		map.put("beginDate", null);
		map.put("endDate", null);
		String areaCode = "";
		if ("1".equals(comLevel)) {
			// 省级用户
			province = ggCodeService.getGgCode(ggUser.getProvince());
			map.put("province", province.getCodeCode());
			areaCode = province.getCodeCode();
		} else if ("2".equals(comLevel)) {
			// 市
			province = ggCodeService.getGgCode(ggUser.getProvince());
			city = ggCodeService.getGgCode(ggUser.getCity());
			map.put("province", province.getCodeCode());
			map.put("city", city.getCodeCode());
			areaCode = city.getCodeCode();
		} else if ("3".equals(comLevel)) {
			province = ggCodeService.getGgCode(ggUser.getProvince());
			city = ggCodeService.getGgCode(ggUser.getCity());
			county = ggCodeService.getGgCode(ggUser.getCounty());
			map.put("province", province.getCodeCode());
			map.put("city", city.getCodeCode());
			map.put("county", county.getCodeCode());
			areaCode = county.getCodeCode();
		}
		GgNotice notice = new GgNotice();
		notice.setMarkRead("0");
		notice.setRecipient(ggUser.getUserCode());
		Integer notices = ggNoticeService.getCountByNotice(notice);
		//获取行业大类
		GgCode code = new GgCode();
		code.setCodeType("IndustryCategories");
		List<GgCode> list = ggCodeService.getGgCodeByObj(code);
		//获取企业总数
//		Map totalMap = corpService.getUserCorpCount(map);
//		Map<String, Object> lossMap = claimService.getLossSum(map);
		
		//premium(总保费),preventFee(事故预防费),appliCount(企业总数)
		Map resMap = GuPolicyMainService.getChartCount(map);
		Map preventFee = GuPolicyMainService.getPreventFee(map);//总事故预防费
		double sumUsePreventFee = commonwealService.getSumUsePreventFee(map);//总使用的事故预防费用
		
		if(null == preventFee) {
			preventFee = new HashMap<>();
		}
		BigDecimal prevent = (BigDecimal) preventFee.get("PREVENTFEE");
		
		
		resMap.put("PREVENTFEE",String.valueOf(prevent));
//		resMap.put("TOTALCOUNT", totalMap.get("TOTALCOUNT"));
		if("1".equals(comLevel)){
			Map<String, Object> map2 = new HashMap<String, Object>();
			ConditionAdapter adapter = new ConditionAdapter();
			adapter.setQueryCondition(map2);
			map2.put("level", "2");
			List<Map<String, Object>> list2 = insurePolicyService.selectCompanySum(adapter);
			int sum = 0;
			for(int i=0;i<list2.size();i++){
				sum = sum + Integer.valueOf((String) list2.get(i).get("COMPANY_SUM"));
			}
			resMap.put("TOTALCOUNT", sum);
		}else{
			GgCompanySum sum = insurePolicyService.selectByPrimaryKeyC(areaCode);
			resMap.put("TOTALCOUNT", sum == null ? 1:sum.getCompanySum());
		}
//		resMap.put("LOSSAMOUNT", lossMap.get("LOSSAMOUNT"));
		resMap.put("LOSSAMOUNT", sumUsePreventFee);

		if (userInd.equals("1")) {
			mad.addObject("province", province == null ? new GgCode()
					: province);
			mad.addObject("city", city == null ? new GgCode() : city);
			mad.addObject("county", county == null ? new GgCode() : county);
			mad.addObject("bcList", list == null ? new ArrayList<GgCode>()
					: list);
			mad.addObject("notices", notices == null ? new ArrayList<Integer>()
					: notices);
			session.setAttribute("notices", notices);
			mad.addObject("chartMap", resMap);
			mad.setViewName("/jianguan/publisher/publishCondition");
		} 
		return mad;

	}
	
	
	
	
}
