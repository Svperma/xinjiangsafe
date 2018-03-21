package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgNotice;

public interface GgNoticeMapper {

	/**
	 * @author hslt
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectList(Pagination pagination)
			throws Exception;

	/**
	 * @author hslt
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryList(Pagination pagination)
			throws Exception;

	/**
	 * @author hslt
	 * @param ggNotice
	 */
	public void insertList(GgNotice ggNotice);

	/**
	 * @author hslt
	 * @param ggNotice
	 */
	public void updateList(GgNotice ggNotice);

	/**
	 * 查询所有消息
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryListAll(Pagination pagination)
			throws Exception;

	/**
	 * 根据recipient查看通知详情
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String selectListAllByRecipient(String map) throws Exception;

	/**
	 * 查询未读信息条数
	 * 
	 * @author hslt
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public Integer getCountByNotice(GgNotice notice) throws Exception;

	/**
	 * 根据seriesNo查看通知信息
	 * 
	 * @author hslt
	 * @param seriesNo
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> querySeriesNo(Pagination map)
			throws Exception;

	/**
	 * 修改阅读状态为‘1’
	 * 
	 * @author hslt
	 * @param markRead
	 */
	public void updateMarkRead(GgNotice ggNotice);

	/**
	 * 查询通知列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> noticeList(Pagination map)
			throws Exception;

	/**
	 * 用来判断风险页面是否发送过信息
	 * 
	 * @author hslt
	 * @param ggNotice
	 * @return
	 */
	public List<GgNotice> forSeriesNo(GgNotice ggNotice);

	/**
	 * 信息“查询按钮”我接收的信息查询方法
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectNotice(Pagination map);

	/**
	 * 我发送的信息，查询
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryListSend(Pagination map);

}
