package com.dsib.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.ToJudgeMapper;
import com.dsib.service.ToJudgeService;

@Service("tojudge")
public class ToJudgeImpl implements ToJudgeService {

	@Autowired
	private ToJudgeMapper tojudge;

	public List<Map<String, Object>> showJudge(String str) {
		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		try {
			listResult = tojudge.showJudge(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listResult;
	}

	public void deletePolicy(String str) {

		try {
			tojudge.deletePolicy(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public String selectPolicy(String str) {
		String result = "";
		try {
			result = tojudge.selectPolicy(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public void updatePolicy(Map map) {
		try {
			tojudge.updatePolicy(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
