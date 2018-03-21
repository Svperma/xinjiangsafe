package com.dsib.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dsib.common.Pagination;
import com.dsib.dao.GgUserMapper;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgNews;
import com.dsib.entity.GgUser;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgNewsService;
import com.dsib.service.GgUserService;
import com.dsib.util.FileUtil;
import com.dsib.util.Md5Util;
import com.dsib.util.StringUtil;

@Controller
@SessionAttributes({"imgList","noteList"})
@RequestMapping("/edit")
public class AdminController extends BaseController  {

	@Autowired
	GgUserMapper userMapper;
	@Resource(name = "ggNewsService")
	private GgNewsService ggNewsService;
	@Resource(name = "ggUserService")
	private GgUserService ggUserService;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	
	@RequestMapping("/getAlternateImg")
	public ModelAndView getAlternateImg(@RequestParam String docType) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("docType", docType);
		pagination.setQueryCondition(map);
		List<Map<String, Object>> list = ggNewsService.getAlternateImg(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		session.setAttribute("pagination", pagination);
		if (docType.equals("5")) {
			mad.setViewName("/admin/adv");
		}if (!"5".equals(docType)) {
			mad.setViewName("/admin/list");
		}
		return mad;
	}
	@RequestMapping("/newsContinue")
	public ModelAndView newsContinue(@RequestParam("pageNo") String pageNo) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		String docType = request.getParameter("docType");
		pagination.setQueryCondition(docType);
		pagination.setPageNo(Integer.valueOf(pageNo));
		List<Map<String, Object>> list = ggNewsService.getContinueByDocType(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		session.setAttribute("pagination", pagination);
		if (docType.equals("5")) {
			mad.setViewName("/admin/advDown");
		}if (!"5".equals(docType)) {
			mad.setViewName("/admin/listDown");
		}
//		mad.setViewName("/admin/advDown");
		return mad;
	}

	/**
	 * 提交内容的添加信息后，保存
	 * @author HSLT
	 * @param photo
	 * @return
	 */
	@RequestMapping("/addNewsandTrends")
	public ModelAndView addNewsandTrends(MultipartFile photo) {
//		ModelAndView mad = new ModelAndView();
		GgNews news = new GgNews();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		
//		String ishome = request.getParameter("s_ishome");//是否首页
//		String isvouch = request.getParameter("s_isvouch");//是否推荐
//		String istop = request.getParameter("s_istop");//是否置顶
//		String expectNo = request.getParameter("expectNo");//期数
//		String displayNo = request.getParameter("DISPLAYNO");//显示位置
		String docType = request.getParameter("cid");//产品分类代码
		String title = request.getParameter("title");// 标题
//		String decription = request.getParameter("DECRIPTION");// 描述
		String content = request.getParameter("content");// 内容
//		String docType = request.getParameter("docType");// 
		// 保存图片数据
		String phth = FileUtil.uploadFile(photo, request);
		/** 生成一个32位的随机数ID */
		String uuid = StringUtil.getUUID();
		/**查询当前最新一期的期数*/
//		news.setCreator(gguser.getUserCode());
//		news.setDocType(docType);
//		String expeNo = ggNewsService.selectExpeNo(news);
		//把查询出来的最新期数string类型转换为数字类型，便于计算
//		Integer nub = Integer.parseInt(expeNo);
//		Integer num = Integer.parseInt(expectNo);
//		Integer ger = nub+num;
//		String newExpeNo = ger.toString();
		
		
		if (phth == null) {
			news.setImagepath("");
		}else {
			news.setImagepath(phth);
		}
		news.setDocid(uuid);//ID
		news.setCreatedate(new Date());//添加时间
		news.setCreator(gguser.getUserCode());//添加人
//		news.setDecription(decription);
//		news.setExpectNo(newExpeNo);
//		news.setDisplayNo(displayNo);
		news.setDoccontent(content);
		news.setIsindex("1");
		news.setIsrecommend("1");
		news.setIstop("1");
		news.setPublishdate(new Date());
		news.setTitle(title);//标题
		news.setDoctype(docType);
		news.setVarstatus("1");
		ggNewsService.getAddNewsAndTrends(news);
		return this.getAlternateImg(docType);
	}
	/**
	 * @author HSLT
	 * @param photo
	 * @param photo1
	 * @return
	 */
	@RequestMapping("/addUpdateNewsandTrends")
	public ModelAndView addUpdateNewsandTrends(MultipartFile photo,MultipartFile photo1) {
		
		ModelAndView mad = new ModelAndView();
		GgNews news = new GgNews();
		Pagination pagination = new Pagination();
		Map<String, Object> map = new HashMap<String, Object>();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		
		String docId = request.getParameter("docId");//ID
		String ishome = request.getParameter("s_ishome");//是否首页
		String isvouch = request.getParameter("s_isvouch");//是否推荐
		String istop = request.getParameter("s_istop");//是否置顶
//		String expectNo = request.getParameter("expectNo");//期数
//		String displayNo = request.getParameter("DISPLAYNO");//显示位置
//		String cid = request.getParameter("cid");//产品分类标题
		String title = request.getParameter("title");// 标题
//		String decription = request.getParameter("DECRIPTION");// 描述
		String content = request.getParameter("content");// 内容
		String docType = request.getParameter("cctvcid");// 

		// 保存图片数据
		if (photo == null) {
			String phth = FileUtil.uploadFile(photo1, request);
			news.setImagepath(phth);
		}else {
			String phth = FileUtil.uploadFile(photo, request);
				news.setImagepath(phth);
		}
		news.setDocid(docId);//ID
		news.setCreatedate(new Date());//添加时间
		news.setCreator(gguser.getUserCode());//添加人
//		news.setDecription(decription);
//		news.setDisplayNo(displayNo);
		news.setDoccontent(content);
		news.setIsindex(ishome);
		news.setIsrecommend(isvouch);
		news.setIstop(istop);
		news.setPublishdate(new Date());
		news.setTitle(title);//标题
//		news.setDocType(cid);
		news.setVarstatus("1");
		ggNewsService.getUpdateNewsAndTrends(news);
		if (docType.equals("5")) {
			map.put("docType", docType);
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list = ggNewsService.getAlternateImg(pagination);
			pagination.setResultList(list);
			mad.addObject("pagination", pagination);
			session.setAttribute("pagination", pagination);
			mad.setViewName("/admin/advDown");
		}else{
			map.put("docType", "");
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list = ggNewsService.getAlternateImg(pagination);
			pagination.setResultList(list);
			mad.addObject("pagination", pagination);
			session.setAttribute("pagination", pagination);
			mad.setViewName("/admin/listDown");
		}
		return mad;
	}
	/**
	 * 更具id删除轮播信息
	 * @author hslt
	 * @param session
	 * @param ggNews
	 * @return
	 */
	@RequestMapping(value = "/deleteExpect")
	public ModelAndView deleteExpect(HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		String docId = request.getParameter("docId");
		String docType = request.getParameter("docType");
		GgNews ggNews = new GgNews();
		ggNews.setDocid(docId);
		ggNewsService.deleteExpect(ggNews);
		Map<String, Object> map = new HashMap<String, Object>();
		ggNews = new GgNews();
		if (docType.equals("5")) {
			map.put("docType", docType);
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list = ggNewsService.getAlternateImg(pagination);
			pagination.setResultList(list);
			mad.addObject("pagination", pagination);
			session.setAttribute("pagination", pagination);
			mad.setViewName("/admin/advDown");
		}
		if (!docType.equals("5")) {
			map.put("docType", "");
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list = ggNewsService.getAlternateImg(pagination);
			pagination.setResultList(list);
			mad.addObject("pagination", pagination);
			session.setAttribute("pagination", pagination);
//			List<Map<String, Object>> list1 = ggNewsService.getAlternateAll(pagination);
			mad.setViewName("/admin/listDown");
		}
		return mad;
	}
	/**
	 * 根据ID修改一条轮播信息
	 * @author HSLT
	 * @param session
	 * @param ggNews
	 * @return
	 */
	@RequestMapping(value = "/updateExpect")
	public ModelAndView updateExpect() {
		String docId = request.getParameter("docId");
		String docType = request.getParameter("docType");
		ModelAndView mad = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		try {
			map.put("docId", docId);
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list = ggNewsService.getAlternateImg(pagination);
			pagination.setResultList(list);
			mad.addObject("pagination", pagination);
			session.setAttribute("pagination", pagination);
//			mad.setViewName("/admin/listDown");
//			ggNewsService.updateExpect(ggNews);		根据ID更新一条轮播信息
//			List<Map<String, Object>> list = ggNewsService.getAlternateImg(pagination);
			
			//查询所有docType
			GgCode code = new GgCode();
			code.setCodeType("docType");
			code.setCodeCode("");
			List<GgCode> list_addExpect = ggCodeService.getGgCodeByObj(code);
			
			if (docType.equals("5")) {
//				mad.addObject("imgList", list);
				mad.addObject("list_addExpect", list_addExpect);
				mad.setViewName("/admin/advUpdate");
			}else {
//				mad.addObject("expeList", list);
				mad.addObject("list_addExpect", list_addExpect);
				mad.setViewName("/admin/addUpdate");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}
	/**
	 * 内容信息栏，点击添加内容按钮，返回分类到添加页面中
	 * @author HSLT
	 * @param session
	 * @param ggNews
	 * @return
	 */
	@RequestMapping(value = "/addExpect")
	public ModelAndView addExpect(HttpSession session, GgNews ggNews) {
		String docType = request.getParameter("docType");
		ModelAndView mad = new ModelAndView();
		try {
			GgCode code = new GgCode();
			code.setCodeType("docType");
			if (docType.equals("0")) {
				code.setCodeCode("");
			}
			List<GgCode> list_addExpect = ggCodeService.getGgCodeByObj(code);
			mad.addObject("typeList", list_addExpect);
			mad.setViewName("/admin/add");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}
	/**
	 * 根据查询栏的查询条件实现查询功能
	 * @author HSLT
	 * @param session
	 * @param ggNews
	 * @return
	 */
	@RequestMapping(value = "/queryExpect")
	public ModelAndView queryExpect(HttpSession session, GgNews ggNews) {
		String docType = request.getParameter("docType");
		String s_ishome = request.getParameter("s_ishome");
		String s_isvouch = request.getParameter("s_isvouch");
		String s_istop = request.getParameter("s_istop");
		String keywords = request.getParameter("keywords");//检索关键字
//		String expeNo = request.getParameter("expeNo");//期数
		ModelAndView mad = new ModelAndView();
		try {
			/*GgCode code = new GgCode();
			code.setCodeType("docType");
			if (docType.equals("0")) {
				code.setCodeCode("");
			}*/
//			List<GgCode> list_addExpect = ggCodeService.getGgCodeByObj(code);
			Map<String, Object> map = new HashMap<String, Object>();
			Pagination pagination = new Pagination();
				if (docType.equals("0")) {
					map.put("docType", "");
				}else {
					map.put("docType", docType);
				}
				map.put("isIndex", s_ishome);
				map.put("isRecommend", s_isvouch);
				map.put("isTop", s_istop);
				map.put("keywords", keywords);
//				map.put("expectNo", expeNo);
				
				pagination.setQueryCondition(map);
				List<Map<String, Object>> list = ggNewsService.getAlternateAll(pagination);
				pagination.setResultList(list);
				mad.addObject("pagination", pagination);
				session.setAttribute("pagination", pagination);
//			if (docType.equals("5")) {
//				ggNews.setDocType(docType);
//			}else {
//				ggNews.setDocType(docType);
//			}
//			ggNews.setDocType(docType);
//			ggNews.setIsIndex(s_ishome);
//			ggNews.setIsRecommend(s_isvouch);
//			ggNews.setIsTop(s_istop);
//			if (keywords != null && keywords != "") {
//				ggNews.setDocContent(keywords);
//				ggNews.setTitle(keywords);
//				ggNews.setDecription(keywords);
//			}
//			ggNews.setExpectNo(expeNo);
			
//			List<GgNews> list = ggNewsService.getAlternateAll(ggNews);
			if (!"5".equals(docType)) {
				mad.addObject("noteList", list);
				mad.setViewName("/admin/list");
			}if (docType.equals("5")) {
				mad.addObject("imgList", list);
				mad.setViewName("/admin/adv");
			}
//			mad.addObject("queryList", list);
//			mad.setViewName("/admin/add");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}
	/**
	 * 新闻用户修改密码
	 * @author HSLT
	 * @param writer
	 * @param js
	 */
	@RequestMapping(value = "/updatePassWord")
	public void updatePassWord(PrintWriter writer,@RequestBody JSONObject js) {
		String mpass = js.getString("mypwd"); // 原始密码
		String newpass = js.getString("newmypwd");//新密码
		String renewpass = js.getString("renewmypwd");//确认密码
		
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
		/*登录用户的密码*/
		String password = gguser.getPassword();
		String userCode = gguser.getUserCode();
		
		/**给输入的原始密码校验*/
		String pwd = Md5Util.md5(mpass);
		String newpwd = Md5Util.md5(newpass);
		String renewpwd = Md5Util.md5(renewpass);
		String result = "";
		if (!pwd.equals(password)) {
			//原始密码与输入密码不一样
			result = "pwdError";
		} else if(!newpwd.equals(renewpwd)){
			//两次密码不同的错
			result = "twoPWDdifferent";
		}else {
			//如果政府用户修改密码
			if (gguser.getUserInd().equals("1")) {
				gguser = new GgUser();
				gguser.setUserCode(userCode);
				gguser.setPassword(newpwd);
				ggUserService.updateNewUser(gguser);
				//修改密码成功
				result = "userInd1Succes";
			}else
			//如果企业用户修改密码
			if (gguser.getUserInd().equals("2")) {
				gguser = new GgUser();
				gguser.setUserCode(userCode);
				gguser.setPassword(newpwd);
				ggUserService.updateNewUser(gguser);
				//修改密码成功
				result = "userInd2Succes";
			}else{
				gguser = new GgUser();
				gguser.setUserCode(userCode);
				gguser.setPassword(newpwd);
				ggUserService.updateNewUser(gguser);
				//修改密码成功
				result = "adminSucces";
			}
		}
		writer.write(JSON.toJSONString(result));
	}
	@RequestMapping(value = "/queryContentNum")
	public void queryContentNum(@RequestParam String contentNum, PrintWriter writer) {
		/*GgUser ggUser = userMapper.getUser(userCode);*/
		
		String checkStatus = "yes";
		int num = 4000;
		if (contentNum.length() < num) {
			checkStatus = "no";
		}
		writer.write(JSON.toJSONString(checkStatus));
		writer.flush();
		writer.close();
	}
	@RequestMapping(value = "/queryDECRNum")
	public void queryDECRNum(@RequestParam String DECRNum, PrintWriter writer) {
		/*GgUser ggUser = userMapper.getUser(userCode);*/
		
		String checkStatus = "yes";
		int num = 400;
		if (DECRNum.length() < num) {
			checkStatus = "no";
		}
		writer.write(JSON.toJSONString(checkStatus));
		writer.flush();
		writer.close();
	}
}
