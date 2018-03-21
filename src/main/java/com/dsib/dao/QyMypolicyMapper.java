package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;

public interface QyMypolicyMapper {

	public List<Map<String, Object>> getQymyPolicy(Pagination pagination);

	public List<Map<String, Object>> getQymyPolicyJj(Pagination pagination);

	// public List<Map<String,Object>> getqymypolicyquery(Pagination
	// pagination);

	public Map<String, Object> getMypolicyShow(String businessno);

	public List<Map<String, Object>> getMypolicyAppend(Pagination pagination);

	public Map<String, Object> getMypolicyNOShow(String bussinessno);

	public List<Map<String, Object>> myPolicyAdditional(String business); // 附加险查询

	public Map<String, Object> myPolicyyeared(String business);

	public List<Map<String, Object>> getQymyPolicyPolicy(Pagination pagination);

	public Map<String, Object> getMypolicyModfy(String buiness);
	
	public Map<String,Object> showSpecial(String business);
}
