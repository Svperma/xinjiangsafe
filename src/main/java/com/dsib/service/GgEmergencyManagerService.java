package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.service.base.BaseService;

public interface GgEmergencyManagerService extends BaseService {

	/**
	 * 应急管理查询
	 * 
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> getEmergency(Pagination pagination);

}
