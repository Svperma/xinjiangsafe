package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgEmergencyManagerMapper;
import com.dsib.service.GgEmergencyManagerService;

@Service("GgEmergencyManagerService")
public class GgEmergencyManagerImpl implements GgEmergencyManagerService {

	@Autowired
	private GgEmergencyManagerMapper ggEmergencyManagerMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 应急管理查询
	 */
	public List<Map<String, Object>> getEmergency(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEmergencyManagerMapper.getEmergency(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
