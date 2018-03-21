package com.dsib.dao;

import java.util.List;

import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyItemKindKey;

public interface GuPolicyItemKindMapper {
	int deleteByPrimaryKey(GuPolicyItemKindKey key);

	int insert(GuPolicyItemKind record);

	int insertSelective(GuPolicyItemKind record);

	GuPolicyItemKind selectByPrimaryKey(GuPolicyItemKindKey key);

	int updateByPrimaryKeySelective(GuPolicyItemKind record);

	int updateByPrimaryKey(GuPolicyItemKind record);
	/**
	 * 根据业务号查询所有跟单险别数据
	 * @param guPolicyItemKind
	 * @return
	 */
	List<GuPolicyItemKind> selectListByBusinessNo(
			GuPolicyItemKind guPolicyItemKind);
}