package com.dsib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.GgInsureConfigMapper;
import com.dsib.entity.GgInsureConfig;
import com.dsib.service.GgInsureConfigService;

@Service("ggInsureConfigService")
public class GgInsureConfigServiceImpl implements GgInsureConfigService {

	@Autowired
	private GgInsureConfigMapper configMapper;

	public List<GgInsureConfig> getInsurance(GgInsureConfig config) {
		List<GgInsureConfig> list = null;
		try {
			list = configMapper.getInsurance(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
