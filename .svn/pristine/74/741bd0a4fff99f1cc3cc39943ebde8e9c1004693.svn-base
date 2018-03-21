package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GcClaim;
import com.dsib.entity.GcClaimProve;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GuPolicyMain;

public interface QyMyclaimMapper {

	public List<Map<String, Object>> getClaimInit(Pagination pagination);

	public List<Map<String,Object>> getClaimInitlize(Pagination pagination);
	
	public Map<String, Object> getBusinessno(String userCode);

	public void getClaimInsert(GcClaim gcClaim);

	public List<Map<String, Object>> getClaimShow(String businessno);

	public void getClaimchuan(GcClaimProve GcClaimProve); // 证明上传

	public Map<String, Object> getClaimInsurance(String BAOANNO);

	public void mySerce();

	public void myPolicy();

	public void myCheckTalk(GgEvaluate GggEvaluate);

	public List<Map<String, Object>> getClaimExcel(ConditionAdapter conditionAdapter);

	public List<Map<String, Object>> historytalk(Map map);

	public Map<String, Object> chakan(String str);

	public void xiugai(GcClaimProve gcClaimProve);

	public List<Map<String, Object>> talkcount(String id);

	public List<GuPolicyMain> selectByGuPolicyMain(GuPolicyMain gu);
	
	public String selectScrop(String str);
	
	public void baoanNo(GcClaim gcClaim);
	
	/**
	 * 根据时间和保单号查是否有同一时间重复提交的报案
	 * @param claim
	 * @return
	 */
	public List<GcClaim> getClaimByLossDateAndPolicyNo(GcClaim claim) ;
}
