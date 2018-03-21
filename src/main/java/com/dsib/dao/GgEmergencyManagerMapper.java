package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;

public interface GgEmergencyManagerMapper {
	/**
	 * 应急管理查询
	 * 
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEmergency(Pagination pagination)
			throws Exception;

}
