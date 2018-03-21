package com.dsib.dao;

import java.util.List;

import com.dsib.entity.GgKind;
import com.dsib.entity.GgKindKey;

public interface GgKindMapper {
	int deleteByPrimaryKey(GgKindKey key);

	int insert(GgKind record);

	int insertSelective(GgKind record);

	GgKind selectByPrimaryKey(GgKindKey key);

	int updateByPrimaryKeySelective(GgKind record);

	int updateByPrimaryKey(GgKind record);

	/**
	 * 查询当前保险公司所属险种的费率
	 * 
	 * @param ggKind
	 * @return
	 */
	List<GgKind> getGgKindList(GgKind ggKind);
}