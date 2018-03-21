package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GGovexpert;
import com.dsib.entity.GgEvaluateDangers;
import com.dsib.entity.GgUserCorp;
import com.dsib.service.base.BaseService;

public interface GgEvaluateDangersService extends BaseService {
	/**
	 * husiletu 分页查询企业评估列表
	 */
	public List<Map<String, Object>> getUserCorpInfo(Pagination map);

	/**
	 * husiletu 评估内容查看
	 */
	public List<Map<String, Object>> getCorpBy_userCode(Pagination map);

	/**
	 * husiletu 分页查询未评估企业列表
	 */
	public List<Map<String, Object>> selectdangerSourceNotDetails(Pagination map);

	/**
	 * husiletu 未评估企业列表确认
	 */
	public List<Map<String, Object>> getDangerSourceDetails(Pagination map);

	/**
	 * 保存企业信息
	 * 
	 * @author hslt
	 * @param ggusercorp
	 */
	public void updateUserCorp(GgUserCorp ggusercorp);

	/**
	 * 给为评估的企业进行评估和危险源的插入
	 * 
	 * @author hslt
	 * @param ggEvaluateDangers
	 */
	public void insertEvaDanger(GgEvaluateDangers ggEvaluateDangers);

	/**
	 * 更新评估危险源信息
	 * 
	 * @author hslt
	 * @param id
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
	public List<Map<String, Object>> getUserCorpToExc(ConditionAdapter adapter);

	/**
	 * 安全风险 翻页
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public Pagination getRiskLevel(Pagination pagination);

	/**
	 * 未评估企业信息 翻页
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public Pagination getUsercorpContinue(Pagination pagination);

	/**
	 * 查询未评估的机构
	 * 
	 * @author hslt
	 * @param userCode
	 * @return
	 */
	public List<Map<String, Object>> selectGovOrganDetails(String userCode);

	/**
	 * 查询未评估的专家
	 * 
	 * @author hslt
	 * @param govExpert
	 * @return
	 */
	public List<Map<String, Object>> selectGovOrganPersons(GGovexpert govExpert);

	/**
	 * 查询企业是否已有评估
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> whetherList(Pagination pagination);

	/**
	 * 查询企业排查记录（即危险源）
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> selectCheckWrite(Pagination pagination);

	/**
	 * 根据id查询出排查记录的详细信息
	 * 
	 * @author hslt
	 * @param eva
	 * @return
	 */
	public List<GgEvaluateDangers> selectCheckDetails(GgEvaluateDangers eva);

	/**
	 * 查询按钮
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> selectChecking(Pagination pagination);

	/**
	 * 企业自添加排查
	 * 
	 * @author hslt
	 * @param ggEvaluateDangers
	 */
	public void insertEvaDangerChecking(GgEvaluateDangers ggEvaluateDangers);

	/**
	 * 企业登录查看评估记录
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	/* public List<Map<String, Object>> selectEva(Pagination pagination); */
	public List<GgEvaluateDangers> selectEva(Pagination pagination);

	/**
	 * 根据id更新原数据的整改状态
	 * 
	 * @author hslt
	 * @param ggEvaluateDangers
	 */
	public void updateEvaStatus(GgEvaluateDangers ggEvaluateDangers);

	/**
	 * 保存整改提交的信息
	 * 
	 * @author hslt
	 * @param ggEvaluateDangers
	 */
	public void insertEvaStatus(GgEvaluateDangers ggEvaluateDangers);

	/**
	 * 排查记录列表分页
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public Pagination CheckingContinue(Pagination pagination);

	/**
	 * 查询按钮，按userInd和userCode
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> selectEvaChecking(Pagination pagination);
	
	void insertGgEvaluateDangersBySelective(GgEvaluateDangers evaluateDangers) ;
	
	List<GgEvaluateDangers> selectiveEvaluateDangers(GgEvaluateDangers evaluateDanagers) ;
	
	void updateEvaDangerSelective(GgEvaluateDangers evaluateDanagers);
}
