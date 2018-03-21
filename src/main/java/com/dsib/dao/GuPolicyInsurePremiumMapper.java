package com.dsib.dao;

import java.util.List;

import com.dsib.entity.GuPolicyInsurePremium;
import com.dsib.entity.GuPolicyInsurePremiumKey;

public interface GuPolicyInsurePremiumMapper {
    int deleteByPrimaryKey(GuPolicyInsurePremiumKey key);

    int insert(GuPolicyInsurePremium record);

    int insertSelective(GuPolicyInsurePremium record);

    GuPolicyInsurePremium selectByPrimaryKey(GuPolicyInsurePremiumKey key);

    int updateByPrimaryKeySelective(GuPolicyInsurePremium record);

    int updateByPrimaryKey(GuPolicyInsurePremium record);

	List<GuPolicyInsurePremium> findInsurePremiumList(GuPolicyInsurePremiumKey guPolicyInsurePremiumKey);
}