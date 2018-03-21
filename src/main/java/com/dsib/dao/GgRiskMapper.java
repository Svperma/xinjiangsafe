package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgRisk;
import com.dsib.entity.GgRiskKey;
import com.dsib.entity.GgUser;

public interface GgRiskMapper {
	int deleteByPrimaryKey(GgRiskKey key);

	int insert(GgRisk record);

	int insertSelective(GgRisk record);

	GgRisk selectByPrimaryKey(GgRiskKey key);

	int updateByPrimaryKeySelective(GgRisk record);

	int updateByPrimaryKey(GgRisk record);

	/**
	 * 获取可投保险种
	 * 
	 * @param ggUser
	 * @return
	 */
	List<GgRisk> findKind4Aera(GgUser ggUser);
	/**
	 * 评价查询
	 * @param pagination
	 * @return
	 */
	List<Map<String, Object>> getPingJia(Pagination pagination);

	void delPingjia(String businessno);
}