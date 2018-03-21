package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.entity.GgPaymentConfig;

public interface GgPaymentConfigMapper {

	public List<GgPaymentConfig> getPayCom(Map<String, Object> map)
			throws Exception;
}
