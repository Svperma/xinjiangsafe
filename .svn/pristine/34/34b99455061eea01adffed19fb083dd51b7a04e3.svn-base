package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;

public interface QyMypolicyService {

	public List<Map<String, Object>> getqymypolicy(Pagination pagination);

	// public List<Map<String,Object>> getqymypolicyquery(Pagination
	// pagination);

	public Map<String, Object> getmypolicyshow(String businessno);

	public List<Map<String, Object>> getmypolicyappend(Pagination pagination);

	public Pagination getqymypolicyPagination(Pagination pagination);

	/**
	 * 审核不通过的保单
	 * @param bussinessno
	 * @return
	 */
	public Map<String, Object> getMypolicyNOShow(String bussinessno);

	public List<Map<String, Object>> myPolicyAdditional(String business); // 附加险查询

	public Map<String, Object> myPolicyyeared(String business);

	public List<Map<String, Object>> getqymypolicyjj(Pagination pagination);

	public Pagination getqymypolicyjjPagination(Pagination pagination);

	public List<Map<String, Object>> getqymypolicyPolicy(Pagination pagination);

	public Pagination getqymypolicyPolicyPagination(Pagination pagination);

	public Map<String, Object> getMypolicyModfy(String buiness);
	
	public Map<String,Object> showSpecial(String str);
}
