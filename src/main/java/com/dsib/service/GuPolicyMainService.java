package com.dsib.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.base.BaseService;

public interface GuPolicyMainService extends BaseService {
	public Map getChartCount(Map map);
	
	public Map getPreventFee(Map map);

	public List<Map<String, Object>> getPolicyInfo(Pagination pagination);

	/**
	 * 获取企业明细
	 * 
	 * @param pagination
	 * @return
	 */
	public Pagination getEnterprises(Pagination pagination);

	/**
	 * 获取援助金明细
	 */
	public Pagination getAssistaces(Pagination pagination);

	/**
	 * 投诉与反馈
	 */
	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination);

	/**
	 * 报表
	 * 
	 * @param adapter
	 * @return
	 */
	public List<Map<String, Object>> policyToExcel(ConditionAdapter adapter);

	/**
	 * 企业明细报表
	 * 
	 * @param adapter
	 * @return
	 */
	public List<Map<String, Object>> enterprisesExcel(ConditionAdapter adapter);

	/**
	 * 企业明细报表
	 * 
	 * @param adapter
	 * @return
	 */
	public List<Map<String, Object>> assistancesExcel(ConditionAdapter adapter);

	/**
	 * 赔案状况
	 * 
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> getClaimMain(Pagination pagination);

	/**
	 * 保险截止日期
	 * 
	 * @param date
	 * @return
	 */
	public Date getDate(String userCode);

	/**
	 * 赔案明细
	 */
	public List<Map<String, Object>> claimDetail(Pagination pagination);

	/**
	 * 赔案详情
	 * 
	 * @param businessNo
	 * @return
	 */
	public Map<String, Object> viewDetail(String businessNo);

	public void updateByBusinessNo(GuPolicyMain guPolicyMain);
	
	/**
	 * 修改个别policymain的个别信息
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(GuPolicyMain record);
	
	/**
	 * 根据统一信用代码查询是否有有效保单
	 * @param identityNumber
	 * @return
	 */
	public List<String> isHavePolicyByIdentityNumber(String identityNumber) ;
	
	
	GuPolicyMain selectByPrimaryKey(String businessno);
}
