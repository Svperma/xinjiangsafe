package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.GgPaymentConfigMapper;
import com.dsib.entity.GgPaymentConfig;
import com.dsib.service.GgPaymentConfigService;

@Service("ggPaymentConfigService")
public class GgPaymentConfigServiceImpl implements GgPaymentConfigService {

	@Autowired
	private GgPaymentConfigMapper ggPaymentConfigMapper;

	public List<GgPaymentConfig> getPayCom(Map<String, Object> map) {
		List<GgPaymentConfig> list = null;
		try {
			list = ggPaymentConfigMapper.getPayCom(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
