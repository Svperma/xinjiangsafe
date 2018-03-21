package com.dsib.service;

import java.util.List;
import java.util.Map;

public interface ToJudgeService {

	public List<Map<String, Object>> showJudge(String str);

	public void deletePolicy(String str);

	public String selectPolicy(String str);

	public void updatePolicy(Map map);

}
