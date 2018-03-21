package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;
import com.dsib.service.base.BaseService;

public interface GgEmployeeService extends BaseService {

	public List<Map<String, Object>> getEmployeeDetails(Pagination map);

	public GgEmployee getEmployeeDetail(String userCode);

	/**
	 * 查询员工人数
	 * 
	 * @param inte
	 * @return
	 */
	public Integer getNum(String userCode);

	public List<Map<String, Object>> getSubmit(Pagination map);

	public void deletePersons(GgEmployee ggemployee);

	public void insertPersons(GgEmployee ggemployee);

	public void updatePersons(GgEmployee ggemployee);

	/**
	 * 报表下载
	 * 
	 * @author hslt
	 * @param adapter
	 * @return
	 */
	public List<Map<String, Object>> getEmployeeToExc(ConditionAdapter adapter);

	/**
	 * 翻页
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public Pagination getPersonsPaginations(Pagination pagination);

	/**
	 * 导入人员信息时的反编译部门
	 * 
	 * @author hslt
	 * @param departmentCode
	 * @return
	 */
	public String insertToExcelPersons(String departmentCode);

	public List<GgCode> getGgCodeByObj(GgCode ggCode);

	public GgEmployee selectByIdentityNo(String identityNo);

}
