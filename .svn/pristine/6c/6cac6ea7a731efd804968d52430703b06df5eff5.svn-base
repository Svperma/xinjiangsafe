package com.dsib.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.dsib.dao.GgUserMapper;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GgUserService;
import com.dsib.util.Md5Util;

@Controller
public class RegisterController {

	@Autowired
	GgUserMapper userMapper;
	@Resource(name = "ggUserService")
	private GgUserService ggUserService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggUserCorpService;

	@RequestMapping(value = "/register")
	public void doRegister(@RequestBody GgUser ggUser, PrintWriter out , HttpSession session) {
		
		String userCode = ggUser.getUserCode();
		String randomStr = (String) session.getAttribute("randomStr");
//		String linkName = ggUser.getLinkName();
//		String telephone = ggUser.getTelePhone();
//		String companyName = ggUser.getUserName();
		String password = ggUser.getPassword();
		String ckCode = ggUser.getCkCode();//验证码
		
		String result = "";
		if (ckCode.equals(randomStr)) {
//		GgUser gguser = userMapper.getUser(userCode);
//		if (gguser == null ) {
			ggUser.setUserCode(userCode);
			ggUser.setPassword(Md5Util.md5(password));
			ggUser.setUserInd("2");
			ggUser.setValidStatus("1");
			ggUserService.insertGgUserByRegister(ggUser);
			
			result = "success";
//		}else {
//			result = "NameIsHave";
//		}
		}else {
			result = "codeError";
		}

		out.write(JSON.toJSONString(result));
		out.flush();
		out.close();
	}
}
