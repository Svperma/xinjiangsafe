package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgHonor;

public interface GgHonorMapper {

	/**
	 * 查询本企业所有的荣誉
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectAll(Pagination map);

	/**
	 * 根据荣誉等级查询
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectQueryByHonorCode(Pagination map);

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

}
