package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;

public interface GgEmployeeMapper {
	/**
	 * 查询员工列表
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getEmployeeDetails(Pagination map);

	/**
	 * 查询按钮
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getSubmit(Pagination map);

	/**
	 * 逻辑删除用户（有效状态设置为0即可）
	 * 
	 * @author hslt
	 * @param ggemployee
	 * @return
	 */
	public void deletePersons(GgEmployee ggemployee);

	/**
	 * 添加新员工
	 * 
	 * @author hslt
	 * @param ggemployee
	 */
	public void insertPersons(GgEmployee ggemployee);

	/**
	 * 修改员工信息
	 * 
	 * @author hslt
	 * @param ggemployee
	 */
	public void updatePersons(GgEmployee ggemployee);

	/**
	 * 查询员工人数
	 * 
	 * @param inte
	 * @return
	 * @throws Exception
	 */
	public Integer getNum(String userCode) throws Exception;

	/**
	 * 报表下载
	 * 
	 * @author hslt
	 * @param adapter
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEmployeeToExc(ConditionAdapter adapter)
			throws Exception;

	public GgEmployee getEmployeeDetail(String userCode);

	/***
	 * 导入人员信息时的反编译部门
	 * 
	 * @author hslt
	 * @param departmentCode
	 * @return
	 */
	public String insertToExcelPersons(String departmentCode);

	public List<GgCode> getGgCodeByObj(GgCode ggCode);
	
	public List<GgEmployee> getGgEmployeeList(GgEmployee ggEmployee);

	public GgEmployee selectByIdentityNo(String identityNo);

}
