package com.dsib.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.dsib.entity.GgInsureConfig;
import com.dsib.service.GgInsureConfigService;

@Controller
@RequestMapping("/insurance")
public class GginsureConfigController extends BaseController {

	private GgInsureConfigService serviceImpl;

	@RequestMapping("/getInsurance")
	public void getInsurance(HttpServletResponse response, GgInsureConfig config) {
		try {
			System.out.println(config.getInsuranceName());
			List<GgInsureConfig> list = serviceImpl.getInsurance(config);
			String result = JSON.toJSONString(list);
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(result);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
