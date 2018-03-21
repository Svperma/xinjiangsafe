package com.dsib.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import oracle.sql.CLOB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgUser;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.GgNewsService;
import com.dsib.service.InsurePolicyService;
import com.dsib.util.SQLUtil;

@Controller
@SessionAttributes({ "newsList", "newsDetail", "nMap", "pMap", "pagination",
		"docType" , "newPhotoList"})
public class GgNewsController extends BaseController{

	@Resource(name = "ggNewsService")
	private GgNewsService ggNewsService;
	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;

	@RequestMapping("/")
	public ModelAndView initIndex() {
		ModelAndView mad = new ModelAndView();
		List<Map<String, Object>> list = ggNewsService.initIndex();
		List<Map<String, Object>> list1 = ggNewsService.getUpdatePhoto();
		Pagination pagination = new Pagination();
		List<GgEvaluate> evaList = ggNewsService
				.getComplainAndFeedback(pagination);
		pagination.setResultList(evaList);
		mad.setViewName("/index");
		mad.addObject("newsList", list);
		mad.addObject("newPhotoList", list1);
		mad.addObject("pagination", pagination);
		return mad;
	}

	@RequestMapping("/newsDetail")
	public ModelAndView newsDetail(@RequestParam("id") String id,
			@RequestParam("docType") String docType,
			@RequestParam("docDate") String docDate) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> map = ggNewsService.newsDetail(id);
		ClobProxyImpl clobProxyImpl = (ClobProxyImpl) map.get("DOCCONTENT");
		Clob clob = clobProxyImpl.getRawClob();
		String str= new SQLUtil().clobToString(clob);
		map.put("DOCCONTENT", str);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("docType", docType);
		conditionMap.put("docDate",
				docDate.subSequence(0, docDate.indexOf(".")));
		Map<String, Object> nMap = ggNewsService.getNextNews(conditionMap);
		Map<String, Object> pMap = ggNewsService.getPreviousNews(conditionMap);
		mad.addObject("newsDetail", map);
		mad.addObject("nMap", nMap == null ? "" : nMap);
		mad.addObject("pMap", pMap == null ? "" : pMap);
		mad.setViewName("/news/newsDetail");
		return mad;
	}
	
	@RequestMapping("/newsLookUp")
	public ModelAndView newsLookUp(@RequestParam String docType) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		pagination.setQueryCondition(docType);
		List<Map<String, Object>> list = ggNewsService.newsLookUp(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		mad.addObject("docType", docType);
		mad.setViewName("/news/newsLookUp");
		return mad;
	}
	/**
	 * 新闻动态、政策法规、专题报道、案例分析的分页
	 * @author HSLT
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/newsLookUpContinue")
	public ModelAndView newsLookUpContinue(
			@RequestParam("pageNo") String pageNo) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		
		String docType = request.getParameter("docType");
		
		pagination.setQueryCondition(docType);
		pagination.setPageNo(Integer.valueOf(pageNo));
		
		List<Map<String, Object>> list = ggNewsService.getContinueByDocType(pagination);
		
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		mad.setViewName("/news/newsLookUp");
		return mad;
	}
	
	//公共信息查询
	@RequestMapping("/wtmtmtba")
	public String wtmtmtba(HttpServletRequest request, Model model){
		String widedaima = request.getParameter("widedaima");
		List<GuPolicyMain> guPolicyMains = insurePolicyService.selectByiddd(widedaima);
		GuPolicyMain guPolicyMain = new GuPolicyMain();
		if(guPolicyMains.size()>0){
			guPolicyMain = guPolicyMains.get(0);
			if(guPolicyMain.getEndDate().before(new Date())){
				guPolicyMain.setRemark("已过期");
			}else{
				guPolicyMain.setRemark("有效");
			}
		}else{
			guPolicyMain.setAppliName("没有查询到与你相关的信息!");
		}
		request.setAttribute("guPolicyMain", guPolicyMain);
		return "/news/HOHODetail";
	}
		
	@RequestMapping("/getPolicy")
	public void getPolicy(@RequestParam String name,
			HttpServletResponse response) {
		try {
			List<Map<String, Object>> list = ggNewsService.getPolicy(name);
			String str = JSONArray.toJSONString(list);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/publicLookUp")
	public ModelAndView publicLookUp() {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		List<GgEvaluate> list = ggNewsService
				.getComplainAndFeedback(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		mad.setViewName("/news/publicLookUp");
		return mad;
	}

	@RequestMapping("/publicLookUpContinue")
	public ModelAndView publicLookUpContinue(
			@RequestParam("pageNo") String pageNo) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		pagination.setPageNo(Integer.valueOf(pageNo));
		List<GgEvaluate> list = ggNewsService
				.getComplainAndFeedback(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		mad.setViewName("/news/publicLookUp");
		return mad;
	}
	/**
	 * @author hslt
	 * @category 退出登录的Servlet,注销
	 */
	/*@RequestMapping(value = "/outServlet")
	public void outServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			session.invalidate();
//			response.sendRedirect("/");
//			request.getHeader("admin/login.jsp");
//			request.getRequestDispatcher("/publish/initPage").forward(request, response);
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
//			response.sendRedirect("http://192.168.0.250:8082/admin/login.jsp");
	}*/
	@RequestMapping(value = "/outServlet")
	public void updatePassWord(PrintWriter writer,@RequestBody JSONObject js) {
		String userInd = js.getString("userInd"); // 
		
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		/*登录用户的密码*/
		String usercode = gguser.getUserCode();
		
		String result = "";
		if (userInd.equals(usercode)) {
			session.invalidate();
			result = "sucessOut";
		}else {
				result = "ErrorOut";
		}
		writer.write(JSON.toJSONString(result));
	}
}
