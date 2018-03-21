package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GgEmployeeMapper;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;
import com.dsib.service.GgEmployeeService;

@Service("ggemployeeService")
public class GgEmployeeServiceImpl implements GgEmployeeService {

	@Autowired
	private GgEmployeeMapper empMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> getEmployeeDetails(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = empMapper.getEmployeeDetails(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> getSubmit(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = empMapper.getSubmit(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void deletePersons(GgEmployee ggemployee) {
		try {
			empMapper.deletePersons(ggemployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public void insertPersons(GgEmployee ggemployee) {
		try {
			empMapper.insertPersons(ggemployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public void updatePersons(GgEmployee ggemployee) {
		try {
			empMapper.updatePersons(ggemployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 查询员工人数
	 */

	public Integer getNum(String inte) {
		Integer Num = null;
		try {
			Num = empMapper.getNum(inte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Num;
	}

	/**
	 * 下载报表
	 * 
	 * @author hslt
	 */
	public List<Map<String, Object>> getEmployeeToExc(ConditionAdapter adapter) {
		List<Map<String, Object>> list = null;
		try {
			list = empMapper.getEmployeeToExc(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 翻页
	 * 
	 * @author hslt
	 */
	public Pagination getPersonsPaginations(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = empMapper.getSubmit(pagination);
			/* list = empMapper.getEmployeeDetails(pagination); */
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	public GgEmployee getEmployeeDetail(String userCode) {
		GgEmployee list = null;
		try {
			list = empMapper.getEmployeeDetail(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 导入人员信息时的反编译部门
	 * 
	 * @author hslt
	 */
	public String insertToExcelPersons(String departmentCode) {
		String dep = null;
		try {
			dep = empMapper.insertToExcelPersons(departmentCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dep;
	}

	public List<GgCode> getGgCodeByObj(GgCode ggCode) {
		List<GgCode> list = null;
		try {
			list = empMapper.getGgCodeByObj(ggCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public GgEmployee selectByIdentityNo(String identityNo) {
		GgEmployee list = null;
		try {
			list = empMapper.selectByIdentityNo(identityNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
