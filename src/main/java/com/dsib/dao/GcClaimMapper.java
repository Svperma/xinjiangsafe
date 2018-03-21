package com.dsib.dao;

import java.util.Map;

import com.dsib.entity.GcClaim;

public interface GcClaimMapper {

	public Map<String, Object> getLossSum(Map<String, Object> map)
			throws Exception;
	
	Integer insertGcClaimSelective (GcClaim claim) ;
	
}
