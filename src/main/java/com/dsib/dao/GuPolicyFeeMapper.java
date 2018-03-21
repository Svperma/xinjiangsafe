package com.dsib.dao;

import com.dsib.entity.GuPolicyFee;

public interface GuPolicyFeeMapper {
	int deleteByPrimaryKey(String businessno);

	int insert(GuPolicyFee record);

	int insertSelective(GuPolicyFee record);

	GuPolicyFee selectByPrimaryKey(String businessno);

	int updateByPrimaryKeySelective(GuPolicyFee record);

	int updateByPrimaryKey(GuPolicyFee record);
}