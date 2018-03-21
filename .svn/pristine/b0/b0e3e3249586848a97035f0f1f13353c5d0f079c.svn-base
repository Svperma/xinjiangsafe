package com.dsib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsib.dao.GuWebClientMapper;
import com.dsib.entity.GcClaim;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.service.JobWebServiceClientService;

@Service("JobWebService")
public class JobWebServiceImpl implements JobWebServiceClientService{

	@Autowired
	private GuWebClientMapper client ;
	
	@Override
	public List<Map<String, Object>> quotePolicyMain() {
		List<Map<String,Object>> resultMap = new ArrayList<Map<String,Object>>();
		try{
			resultMap = client.quotePolicyMain();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public void updatePolicyKind(Map<String, Object> map) {
		try{
			client.updatePolicyKind(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void updatePolicyMain(Map<String, Object> map) {
		try{
			client.updatePolicyMain(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void updaterbPolicy(Map<String, Object> map) {
		try{
			client.updaterbPolicy(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void insertClaim(GcClaim gcClaim) {
		try{
			client.insertClaim(gcClaim);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public GuPolicyAdjustRate adjustrate(String str) {
		GuPolicyAdjustRate rate = new GuPolicyAdjustRate();
		rate = client.adjustrate(str);
		return rate;
	}

	public GuWebClientMapper getClient() {
		return client;
	}

	public void setClient(GuWebClientMapper client) {
		this.client = client;
	}

	
	
	@Transactional
	public void updatePolicyAll(Map<String, Object> mainPolicy,Map<String, Object> policyKind, List<Map<String, Object>> Premium) {
//			client.updatePolicyKind(policyKind);
			client.updatePolicyMain(mainPolicy);
			Iterator it = Premium.iterator();
			while(it.hasNext()){
				Map<String,Object> premium = (Map<String, Object>) it.next();
				client.updatePremium(premium);
			}
		
	}

	@Override
	public void CensorContent(Map<String, Object> censor) {
		client.CensorContent(censor);
		
	}

	@Override
	public void updateCensor(Map<String, Object> map) {
		client.updateCensor(map);
		
	}
}
