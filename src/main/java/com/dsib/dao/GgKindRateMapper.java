package com.dsib.dao;

import com.dsib.entity.GgKindRate;
import com.dsib.entity.GgKindRateKey;

public interface GgKindRateMapper {
	int deleteByPrimaryKey(GgKindRateKey key);

	int insert(GgKindRate record);

	int insertSelective(GgKindRate record);

	GgKindRate selectByPrimaryKey(GgKindRateKey key);

	int updateByPrimaryKeySelective(GgKindRate record);

	int updateByPrimaryKey(GgKindRate record);
}