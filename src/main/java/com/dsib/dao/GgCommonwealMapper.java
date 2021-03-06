package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.Gupreventfeedetail;

public interface GgCommonwealMapper {

	public List<Map<String, Object>> getCommonwealQuery(Pagination pagination);

	public Map<String, Object> getCommonsumQuery(Pagination pagination);

	public void getCommonInsert(Gupreventfeedetail gu);

	public Map<String, Object> getCommonShow(String id);

	public List<Map<String, Object>> getCommonwealExel(ConditionAdapter adapter);

	public List<Map<String, Object>> getqian();

	public List<Map<String, Object>> selectDsManager_commonweal(Pagination pagination);

	public List<Map<String, Object>> getDsManagerPreventiveToExc(ConditionAdapter adapter);

	public List<Map<String, Object>> companyQuery(Pagination pagination);

	public List<Map<String, Object>> exportCompany(ConditionAdapter adapter);

	public List<Map<String, Object>> claimQuery(Pagination pagination);

	public List<Map<String, Object>> exportClaim(ConditionAdapter adapter);

	public List<Map<String, Object>> findpromthous(Pagination pagination);

	public void quePromthous(String businessno);

	public List<Map<String, Object>> claimListQuery(Pagination pagination);
	
	Double getSumUsePreventFee(Map< String, Object> map);

}
