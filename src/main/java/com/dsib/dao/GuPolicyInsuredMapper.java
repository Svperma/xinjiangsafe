package com.dsib.dao;

import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;

public interface GuPolicyInsuredMapper {
	int deleteByPrimaryKey(GuPolicyInsuredKey key);

	int insert(GuPolicyInsured record);

	int insertSelective(GuPolicyInsured record);

	GuPolicyInsured selectByPrimaryKey(GuPolicyInsuredKey key);

	int updateByPrimaryKeySelective(GuPolicyInsured record);

	int updateByPrimaryKey(GuPolicyInsured record);
}