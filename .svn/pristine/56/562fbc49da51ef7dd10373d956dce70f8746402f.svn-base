package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.entity.GgCompanySum;

public interface GgCompanySumMapper {
    int deleteByPrimaryKey(String areaCode);

    int insert(GgCompanySum record);

    int insertSelective(GgCompanySum record);

    GgCompanySum selectByPrimaryKey(String areaCode);

    int updateByPrimaryKeySelective(GgCompanySum record);

    int updateByPrimaryKey(GgCompanySum record);

	List<Map<String, Object>> selectCompanySum(ConditionAdapter adapter);
}