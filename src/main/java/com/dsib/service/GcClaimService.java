package com.dsib.service;

import java.util.Map;

import com.dsib.entity.GcClaim;

public interface GcClaimService {

	public Map<String, Object> getLossSum(Map<String, Object> map);
	
	Integer insertGcClaimSelective (GcClaim claim) ;
}
