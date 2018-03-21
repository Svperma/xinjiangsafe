package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgUser;
import com.dsib.service.GgCodeService;

@Controller
@RequestMapping("/codeControl")
public class GgCodeController extends BaseController {

	@Resource(name = "ggCodeService")
	private GgCodeService codeService;

	@RequestMapping(value = "/getArea")
	public void getArea(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String remark = obj.getString("remark");
		List<GgCode> list = codeService.getGgCodeList(remark);
		String areaList = "";
		areaList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(areaList);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getClassCode")
	public void getClassCode(@RequestBody JSONObject obj,
			HttpServletResponse response) {
		String remark = obj.getString("remark");
		List<GgCode> list = codeService.getIndustryCode(remark);
		String codeList = "";
		codeList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(codeList);
			write.flush();
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getGgCodeByObj")
	public void getGgCodeByObj(GgCode ggCode, HttpServletResponse response) {
		List<GgCode> list = codeService.getGgCodeByObj(ggCode);
		String codeList = "";
		codeList = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			PrintWriter write = response.getWriter();
			write.write(codeList);
			write.flush();
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/getProvince")
	public void getProvince() {
		
		GgUser user = (GgUser) session.getAttribute("ggUser");
		
		String codeType = request.getParameter("codeType");
		String remark = request.getParameter("remark");
		
		GgCode code = new GgCode();
		code.setCodeType(codeType);
		code.setRemark(remark);
//		if(!"0".equals(user.getComLevel())) {//如果不是全国级别用户  只能查出所在的省
//			code.setCodeCode(user.getProvince());
//		}
		List<GgCode> codes = codeService.getGgCodeByObj(code);
//		write.write(JSON.toJSONString(codes));
//		write.flush();
//		write.close();
		
//		GgUser user = (GgUser) session.getAttribute("ggUser");
//		
//		GgCode code = new GgCode();
//		List<GgCode> provinces = null;
//		
//		String comLevel = user.getComLevel();
//		if("0".equals(comLevel)) {
//			code.setCodeType("Province");
//			provinces = codeService.getGgCodeByObj(code);
//		}
//		if("1".equals(comLevel)) {
//			code.setCodeType("Province");
//			code.setCodeCode(user.getProvince());
//			provinces = codeService.getGgCodeByObj(code);
//		}
//		if("2".equals(comLevel)) {
//			code.setCodeType("Province");
//			code.setCodeCode(user.getProvince());
//			provinces = codeService.getGgCodeByObj(code);
//		}
//		if("3".equals(comLevel)) {
//			code.setCodeType("Province");
//			code.setCodeCode(user.getProvince());
//			provinces = codeService.getGgCodeByObj(code);
//		}
//		
//		write.write(JSON.toJSONString(provinces));
	}
	
	@RequestMapping(value = "/getCity")
	public void getCity() {
		
		GgUser user = (GgUser) session.getAttribute("ggUser");
		
		GgCode code = new GgCode();
		List<GgCode> citys = null;
		
		String comLevel = user.getComLevel();
		if("0".equals(comLevel)) {
			code.setCodeType("City");
			code.setRemark(user.getProvince());
			citys = codeService.getGgCodeByObj(code);
		}
		if("1".equals(comLevel)) {
			code.setCodeType("City");
			code.setCodeCode(user.getProvince());
			citys = codeService.getGgCodeByObj(code);
		}
		if("2".equals(comLevel)) {
			code.setCodeType("City");
			code.setCodeCode(user.getCity());
			code.setRemark(user.getProvince());
			citys = codeService.getGgCodeByObj(code);
		}
		if("3".equals(comLevel)) {
			code.setCodeType("City");
			code.setCodeCode(user.getCity());
			code.setRemark(user.getProvince());
			citys = codeService.getGgCodeByObj(code);
		}
		
//		write.write(JSON.toJSONString(citys));
//		write.flush();
//		write.close();
	}
	
	@RequestMapping(value = "/getCounty")
	public void getCounty() {
		
		GgUser user = (GgUser) session.getAttribute("ggUser");
		
		GgCode code = new GgCode();
		List<GgCode> countys = null;
		
		String comLevel = user.getComLevel();
		if("0".equals(comLevel)) {
			code.setCodeType("County");
			countys = codeService.getGgCodeByObj(code);
		}
		if("1".equals(comLevel)) {
		}
		if("2".equals(comLevel)) {
		}
		if("3".equals(comLevel)) {
		}
		
//		write.write(JSON.toJSONString(countys));
//		write.flush();
//		write.close();
	}
		
}
