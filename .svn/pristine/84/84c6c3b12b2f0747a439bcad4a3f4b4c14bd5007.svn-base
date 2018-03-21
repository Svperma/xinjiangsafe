package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GovOrgan;

public interface GovOrganMapper {

	/**
	 * 
	 * @param pagination
	 * @return
	 */
	public List<GovOrgan> getGovOrgan(Pagination pagination);

	/**
	 * 插入机构表中评估信息
	 * 
	 * @author hslt
	 * @param govOrgan
	 * @throws Exception
	 */
	public void insertGov(GovOrgan govOrgan) throws Exception;

	/**
	 * 
	 * @author hslt
	 * @param govOrgan
	 * @throws Exception
	 */
	public List<GovOrgan> selectGovorgan4Code(GovOrgan govOrgan);

	public List<GovOrgan> selectGovorganEvaPersons(GovOrgan govOrgan);

	/**
	 * 预约评估时，查询登录用户经营范围相等的评估机构
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> addInveStigateByOrgan(Pagination map);

	public List<GovOrgan> selectGovorganByCode(GovOrgan govOrgan);
	
	List<GovOrgan> selectiveGovOrgan(GovOrgan govOrgan) ;
	
	void insertGovOrganSelective(GovOrgan govOrgan);
	
	void updateGovOrganSelective(GovOrgan govOrgan);
}
