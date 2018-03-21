package com.dsib.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dsib.util.DateEditor;

public class BaseController {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
//	protected PrintWriter write;

	/**
	 * 说明：ModelAttribute的作用
	 * 
	 * 1)放置在方法的形参上：表示引用Model中的数据
	 * 
	 * 2)放置在方法上面：表示请求该类的每个Action前都会首先执行它，也可以将一些准备数据的操作放置在该方法里面。
	 */
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
//			this.write = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.sql.Date.class, new DateEditor());
	}
}
