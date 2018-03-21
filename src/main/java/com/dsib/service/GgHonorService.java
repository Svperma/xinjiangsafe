package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgHonor;
import com.dsib.service.base.BaseService;

public interface GgHonorService extends BaseService {
	/**
	 * 查询本企业所有的荣誉
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> selectAll(Pagination pagination);

	/**
	 * 根据荣誉等级查询
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> selectQueryByHonorCode(
			Pagination pagination);

	/**
	 * 根据ID逻辑删除
	 * 
	 * @author hslt
	 * @param honor
	 * @return
	 */
	public void deleteById(GgHonor honor);

	/**
	 * 添加荣誉
	 * 
	 * @author hslt
	 * @param ggHonor
	 */
	public void addHonor(GgHonor ggHonor);

	/**
	 * 荣誉列表翻页
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public Pagination getMyHonorPagination(Pagination pagination);

}
