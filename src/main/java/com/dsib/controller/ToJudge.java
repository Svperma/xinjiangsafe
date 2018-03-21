package com.dsib.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.dsib.entity.GgUser;
import com.dsib.service.ToJudgeService;

@Controller
@RequestMapping("/tojudge")
public class ToJudge extends BaseController {

	@Resource(name = "tojudge")
	private ToJudgeService tojudge;

	@RequestMapping("/process")
	public void process(PrintWriter print) {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		List<Map<String, Object>> listResult = tojudge.showJudge(ggUser
				.getUserCode());
		String result = "";
		if (listResult != null && listResult.size() > 0) {
			for (int i = 0; i < listResult.size(); i++) {
				if (String.valueOf(listResult.get(i).get("POLICYNO")) == null
						|| String.valueOf(listResult.get(i).get("POLICYNO"))
								.equals("")) {
					result = "renewal";
				} else {

					result = "myPolicy";
					break;
				}
			}
		} else {
			result = "${basePath}/insurePolicy/getPoilcying";
		}
		print.write(JSON.toJSONString(result));
	}
}
