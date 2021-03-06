package com.dsib.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgEmployee;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;

public interface GuPolicyMainMapper {

	// public List<GgMain> getGgMain(Pagination pagination);

	public Map getChartCount(Map map) throws Exception;
	/**
	 * 获取事故预防费
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map getPreventFee(Map map);

	public List<Map<String, Object>> getPolicyInfo(Pagination pagination)
			throws Exception;

	// 企业明细
	public List<Map<String, Object>> getEnterprises(Pagination pagination)
			throws Exception;

	// 援助金明细
	public List<Map<String, Object>> getAssistances(Pagination pagination)
			throws Exception;

	// 投诉与反馈
	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination)
			throws Exception;

	// 导报表
	public List<Map<String, Object>> policyToExcel(ConditionAdapter adapter)
			throws Exception;

	// 企业报表
	public List<Map<String, Object>> enterprisesExcel(ConditionAdapter adapter)
			throws Exception;

	// 援助金报表
	public List<Map<String, Object>> assistancesExcel(ConditionAdapter adapter)
			throws Exception;

	// 保险截止日期
	public Date getDate(String userCode) throws Exception;

	//
	public List<Map<String, Object>> getClaimMain(Pagination pagination)
			throws Exception;

	// 赔案明细
	public List<Map<String, Object>> claimDetail(Pagination pagination)
			throws Exception;

	// 赔案详情
	public Map<String, Object> viewDetail(String businessNo) throws Exception;
	/**
	 * 爱玩玩
	 * @param businessno
	 * @return
	 */
	List<GuPolicyMain> selectByiddd(String businessno);

	/**
	 * 查询企业是否有已经生效的保单
	 * 
	 * @param main
	 * @return
	 */
	List<GuPolicyMain> selectRenewalFlag(GuPolicyMain main);

	int deleteByPrimaryKey(String businessno);

	int insert(GuPolicyMain record);

	int insertSelective(GuPolicyMain record);

	
	GuPolicyMain selectByPrimaryKey(String businessno);

	int updateByPrimaryKeySelective(GuPolicyMain record);

	int updateByPrimaryKey(GuPolicyMain record);

	public void updateByBusinessNo(GuPolicyMain guPolicyMain);

	public List<GuPolicyEmployee> selectGuPolicyEmployee(String businessnos);

	public GgUserCorp selectGgUserCorp(String businessnos);

	public List<GgEmployee> selectGgEmployee(String pepIdentityNo);

	public GuPolicyAdjustRate selectGuPolicyAdjustRate(String businessnos);

	public List<GuPolicyItemKind> selectGuPolicyItemKind(String businessnos);

	public List<GuPolicyLimit> selectGuPolicyLimit(String businessnos);

	public Integer selectGuPolicyEmployeeCount(String businessnos);

	public GuPolicyMain selectByPolicyNo(String policyNo);

	public List<GuPolicyMain> checkPolicyHas(String userCode);
	
	public List<Map<String, Object>> exportJuck(GuPolicyMain guPolicyMain);

	public GuPolicyMain selectMainByPolicyNo(String string);
	
	public List<String> isHavePolicyByIdentityNumber(String identityNumber) ;

}
