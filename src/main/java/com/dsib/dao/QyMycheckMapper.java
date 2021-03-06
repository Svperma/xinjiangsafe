package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GuPolicyEndorse;

public interface QyMycheckMapper {

	public List<Map<String, Object>> getMyPolicyInit(Pagination pagination);
	
	public List<Map<String, Object>> getMyPolicyInitJj(Pagination pagination);

	public void myCheckTalk(GgEvaluate ggEvaluate);

	public void mySerce(); // 服务态度标记自增1

	public void myPolicy(); // 保单寄送标记自增1

	public List<Map<String, Object>> myCheckAdditional(String business); // 附加险查询

	public Map<String, Object> myCheckyeared(String business);

	public List<Map<String, Object>> getmyCheckExcel(ConditionAdapter conditionAdapter);

	public List<Map<String, Object>> historytalk(Map map);

	public List<Map<String, Object>> talkcount(String id);

	public List<Map<String, Object>> getMyPolicyInitPolicy(Pagination pagination);

	public List<GgEvaluate> selectInsuredCode(GgEvaluate ggevaluate);

	public void myCheckTalkInsert(GgEvaluate ggEvaluate);

	public List<Map<String, Object>> exportPolicy(ConditionAdapter adapter);

	public List<Map<String, Object>> correctQuery(Pagination pagination);

	public List<Map<String, Object>> exportCorrect(ConditionAdapter adapter);
	
	public void sperialPro(Map<String,Object> map); 
	
	public void endorse(GuPolicyEndorse guPolicyEndorse);
	
	public List<Map<String,Object>> getApplyInit(Pagination  pagination);//批单查询
	
	public List<Map<String,Object>> getApply(Map<String,Object> map);
	
	public void auditing(Map<String,Object> map);//审核成功
	
	public void audited(Map<String,Object> map);//审核不成功
		
	public void aditnumber(Map<String,Object> map);//添加批单号
	
	public void defary(Map<String,Object> map);//经纪公司确认支付

	//监管用户条件查询保单分页 
	public List<Map<String, Object>> getMyPolicyInitJg(Pagination pagination);
	
	//监管用户条件查询保单不分页 
	List<Map<String, String>> getMyPolicyInitJgNotPage(Map<String , Object> conditionMap);

}
