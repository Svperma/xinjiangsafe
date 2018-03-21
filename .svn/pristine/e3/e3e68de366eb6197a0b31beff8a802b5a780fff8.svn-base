package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GuPolicyEndorse;

public interface QyMycheckService {

	public List<Map<String, Object>> getmypolicyInit(Pagination pagination);

	public Pagination getmypolicyInitPagination(Pagination pagination);

	public void mychecktalk(GgEvaluate ggEvaluate);

	public void myserce();

	public void policy();

	public List<Map<String, Object>> mycheckadditional(String business);

	public Map<String, Object> mycheckyeared(String business);

	public List<Map<String, Object>> getmycheckExcel(ConditionAdapter conditionAdapter);

	public List<Map<String, Object>> historytalk(Map map);

	public List<Map<String, Object>> talkcount(String id);

	public List<Map<String, Object>> getmypolicyInitjj(Pagination pagination);

	public Pagination getmypolicyInitjjPagination(Pagination pagination);

	public List<Map<String, Object>> getmypolicyInitPolicy(Pagination pagination);

	public Pagination getmypolicyInitPolicyPagination(Pagination pagination);

	public List<GgEvaluate> selectInsuredCode(GgEvaluate ggevaluate);

	public void myCheckTalkInsert(GgEvaluate ggEvaluate);

	public List<Map<String, Object>> exportPolicy(ConditionAdapter adapter);

	public List<Map<String, Object>> correctQuery(Pagination pagination);

	public Pagination correctQueryContinue(Pagination pagination);

	public List<Map<String, Object>> exportCorrect(ConditionAdapter adapter);
	
	public void sperialPro(Map<String,Object> map,GuPolicyEndorse guPolicyEndorse); 
	
	public List<Map<String,Object>> getApplyInit(Pagination pagination);//批单查询
	
	public List<Map<String,Object>> getApply(Map<String,Object> map);
	
	public void auditing(Map<String,Object> map);//审核通过批单
	
	public void audited(Map<String,Object> map);//审核不通过
	
	public void aditnumber(Map<String,Object> map);//添加批单号
	
	public void defary(Map<String,Object> map);//经纪公司批单确认支付

	public List<Map<String, Object>> getmypolicyInitjg(Pagination pagination);

	public Pagination getmypolicyInitjgPagination(Pagination pagination);
	
	/**
	 * 监管用户条件查询保单总和
	 * @param conditionMap
	 * @return
	 */
	List<Map<String, String>> getMyPolicyInitJgNotPage(Map<String , Object> conditionMap);

	
}
