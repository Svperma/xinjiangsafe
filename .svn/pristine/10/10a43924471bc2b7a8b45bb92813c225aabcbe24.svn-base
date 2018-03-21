package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgSubscribe;
import com.dsib.entity.GovOrgan;
import com.dsib.service.base.BaseService;

public interface GovOrganService extends BaseService {
	/**
	 * 通过OrgCode外键关联，查询机构信息
	 * 
	 * @param
	 * @return
	 */
	public List<GovOrgan> getGovOrganBy_OrgCode(Pagination pagination);

	/**
	 * 插入机构表中评估信息
	 * 
	 * @author hslt
	 * @param govOrgan
	 */
	public void insertGov(GovOrgan govOrgan);

	public List<GovOrgan> selectGovorgan4Code(GovOrgan govOrgan);

	public List<GovOrgan> selectGovorganEvaPersons(GovOrgan govOrgan);

	/**
	 * 预约评估时，查询登录用户经营范围相等的评估机构
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> addInveStigateByOrgan(Pagination pagination);

	public List<GovOrgan> selectGovorganByCode(GovOrgan govOrgan);

	public List<GgSubscribe> selectSubscribe(GgSubscribe sub);
	
	List<GovOrgan> selectiveGovOrgan(GovOrgan govOrgan) ;
	
	void insertGovOrganSelective(GovOrgan govOrgan);
	
	void updateGovOrganSelective(GovOrgan govOrgan);
}
