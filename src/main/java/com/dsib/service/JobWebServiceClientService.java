package com.dsib.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dsib.entity.GcClaim;
import com.dsib.entity.GuPolicyAdjustRate;


public interface JobWebServiceClientService {

	public List<Map<String,Object>> quotePolicyMain(); //人工核保单号查询接口入参查询
	
	public void updatePolicyKind(Map<String,Object> map); //人工核保单号查询接口返回参数更新数据库附加险种表
	
	public void updatePolicyMain(Map<String,Object> map); //单号查询接口返回参数更新数据库Main表
	
	public void updaterbPolicy(Map<String,Object> map);//人工核保存储保单号
	
	public void insertClaim(GcClaim gcClaim);//接口添加理赔信息
	
	GuPolicyAdjustRate adjustrate(String str);//查看费率问题 
	
	public void updatePolicyAll(Map<String,Object> mainPolicy , Map<String,Object> policyKind , List<Map<String,Object>> Premium);

	public void CensorContent(Map<String,Object> censor);
	
	public void updateCensor(Map<String,Object> map);
	
}
