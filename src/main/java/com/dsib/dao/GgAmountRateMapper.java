package com.dsib.dao;

import java.util.List;

import com.dsib.entity.GgAmountRate;

public interface GgAmountRateMapper {
	int deleteByPrimaryKey(String rateid);

	int insert(GgAmountRate record);

	int insertSelective(GgAmountRate record);

	GgAmountRate selectByPrimaryKey(String rateid);

	int updateByPrimaryKeySelective(GgAmountRate record);

	int updateByPrimaryKey(GgAmountRate record);

	/**
	 * 获取限额费率
	 * 
	 * @param key
	 * @return
	 */
	GgAmountRate selectByType(GgAmountRate ggAmountRate);

	/**
	 * 获取可以当前企业可投保的总限额
	 * 
	 * @param ggAmountRate
	 * @return
	 */
	List<GgAmountRate> getAmountList(GgAmountRate ggAmountRate);
}