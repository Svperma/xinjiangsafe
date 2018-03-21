package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GGovexpert;
import com.dsib.entity.GgEvaluateDangers;
import com.dsib.entity.GgUserCorp;

public interface GgEvaluateDangersMapper {
	/**
	 * 保存评估危险源信息
	 * 
	 * @author hslt
	 * @param ggEvaluateDangers
	 * @throws Exception
	 */
	public void insertEvaDanger(GgEvaluateDangers ggEvaluateDangers)
			throws Exception;

	/**
	 * 通过userCode外键关联，查询企业评估内容信息
	 * 
	 * @author husiletu
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getCorpBy_userCode(Pagination pagination)
			throws Exception;

	/**
	 * 风险评估--分页
	 * 
	 * @author husiletu
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserCorpInfo(Pagination pagination)
			throws Exception;

	/**
	 * 查询未评估企业列表
	 * 
	 * @author husiletu
	 * @param parameter
	 * @return
	 */
	public List<Map<String, Object>> selectdangerSourceNotDetails(
			Pagination pagination) throws Exception;

	/**
	 * 未评估企业列表确认
	 * 
	 * @author husiletu
	 * @param parameter
	 * @return
	 */
	public List<Map<String, Object>> getDangerSourceDetails(
			Pagination pagination) throws Exception;

	/**
	 * 保存企业信息
	 * 
	 * @author husiletu
	 * @param ggusercorp
	 * @return
	 * @throws Exception
	 */
	public void updateUserCorp(GgUserCorp ggusercorp) throws Exception;

	/**
	 * 更新评估危险源信息
	 * 
	 * @author hslt
	 * @param ggEvaluateDangers
	 */
	public void updateEvaDanger(GgEvaluateDangers ggEvaluateDangers);

	/**
	 * 查询机构等级
	 * 
	 * @author hslt
	 * @param stringGrage
	 * @return
	 */
	public String getGrage(String stringGrage);

	/**
	 * 下载报表
	 * 
	 * @author hslt
	 * @param adapter
	 * @return
	 */
	public List<Map<String, Object>> getUserCorpToExc(ConditionAdapter adapter)
			throws Exception;

	/**
	 * 查询未评估机构
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectGovOrganDetails(String classCode)
			throws Exception;

	/**
	 * 查询未评估的专家
	 * 
	 * @author hslt
	 * @param govExpert
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectGovOrganPersons(GGovexpert govExpert)
			throws Exception;

	/**
	 * 查询企业是否已有评估
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> whetherList(Pagination map)
			throws Exception;
	
	void insertGgEvaluateDangersBySelective(GgEvaluateDangers evaluateDanagers) ;
	
	List<GgEvaluateDangers> selectiveEvaluateDangers(GgEvaluateDangers evaluateDanagers) ;
	
	void updateEvaDangerSelective(GgEvaluateDangers evaluateDanagers);

}
