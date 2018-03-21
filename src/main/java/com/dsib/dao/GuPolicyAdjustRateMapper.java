package com.dsib.dao;

import com.dsib.entity.GuPolicyAdjustRate;

public interface GuPolicyAdjustRateMapper {
	int deleteByPrimaryKey(String businessno);

	int insert(GuPolicyAdjustRate record);

	int insertSelective(GuPolicyAdjustRate record);

	GuPolicyAdjustRate selectByPrimaryKey(String businessno);

	int updateByPrimaryKeySelective(GuPolicyAdjustRate record);

	int updateByPrimaryKey(GuPolicyAdjustRate record);
}