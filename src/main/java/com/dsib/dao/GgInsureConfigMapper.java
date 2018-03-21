package com.dsib.dao;

import java.util.List;

import com.dsib.entity.GgInsureConfig;

public interface GgInsureConfigMapper {

	public List<GgInsureConfig> getInsurance(GgInsureConfig config)
			throws Exception;
	
	
}
