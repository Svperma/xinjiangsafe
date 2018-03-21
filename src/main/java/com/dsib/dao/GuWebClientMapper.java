package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.entity.GcClaim;
import com.dsib.entity.GuPolicyAdjustRate;

public interface GuWebClientMapper {

	public  List<Map<String,Object>> quotePolicyMain();//查看
	
	public void updatePolicyKind(Map<String,Object> map);//修改附加险信息
	
	public void updatePolicyMain(Map<String,Object> map);//修改main表
	
	public void updatePremium(Map<String,Object> map);
	
	public void updaterbPolicy(Map<String,Object> map);
	
	public void insertClaim(GcClaim gcClaim);
	
	GuPolicyAdjustRate adjustrate(String str);
	
	public void CensorContent(Map<String,Object> censor);
	
	public void updateCensor(Map<String,Object> map);
}
