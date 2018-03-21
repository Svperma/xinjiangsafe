package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluateDangers;
import com.dsib.entity.GgSubscribe;

public interface GgSubscribeMapper {
	/**
	 * 查询企业排查记录（即危险源）
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectCheckWrite(Pagination map)
			throws Exception;

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
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectChecking(Pagination map);

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
	 * @param map
	 * @return
	 */
	/* public List<Map<String, Object>> selectEva(Pagination map); */
	public List<GgEvaluateDangers> selectEva(Pagination map);

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
	 * 查询按钮，按userInd和userCode
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectEvaChecking(Pagination map);

	/**
	 * 预约评估成功，插入预约表中
	 * 
	 * @author hslt
	 * @param scribe
	 * @return
	 */
	public boolean insertInveStigate(GgSubscribe scribe);

	/**
	 * @author hslt
	 * @param sub
	 * @return
	 */
	public List<GgSubscribe> selectSubscribe(GgSubscribe sub);

}
