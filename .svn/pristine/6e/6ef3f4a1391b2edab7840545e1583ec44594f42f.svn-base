package com.dsib.dao;

import java.util.List;

import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyEmployeeKey;

public interface GuPolicyEmployeeMapper {
    int deleteByPrimaryKey(GuPolicyEmployeeKey key);

    int insert(GuPolicyEmployee record);

    int insertSelective(GuPolicyEmployee record);

    GuPolicyEmployee selectByPrimaryKey(GuPolicyEmployeeKey key);

    int updateByPrimaryKeySelective(GuPolicyEmployee record);

    int updateByPrimaryKey(GuPolicyEmployee record);
    /**
	 * 获取跟单员工列表
	 * 
	 * @param ggAmountRate
	 * @return
	 */
	List<GuPolicyEmployee> findEmployeeList(GuPolicyEmployee guPolicyEmployee);
}