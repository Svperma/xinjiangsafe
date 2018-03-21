package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgNotice;
import com.dsib.entity.GgUser;
import com.dsib.service.base.BaseService;

public interface GgNoticeService extends BaseService {
	/**
	 * 根据userCode传值
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> selectList(Pagination pagination);

	/**
	 * 条件查询通知信息
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> queryList(Pagination pagination);

	/**
	 * 插入通知信息
	 * 
	 * @author hslt
	 * @param ggNotice
	 */
	public void insertList(GgNotice ggNotice);

	/**
	 * 更新通知信息
	 * 
	 * @author hslt
	 * @param ggNotice
	 */
	public void updateList(GgNotice ggNotice);

	/**
	 * 查询所有消息
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> queryListAll(Pagination pagination);

	/**
	 * 根据recipient查看通知信息详情
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public String selectListAllByRecipient(String pagination);

	/**
	 * 查询未读信息条数
	 * 
	 * @author hslt
	 * @param notice
	 * @return
	 */
	public Integer getCountByNotice(GgNotice notice);

	/**
	 * 根据seriesNo查看通知信息
	 * 
	 * @author hslt
	 * @param seriesNo
	 * @return
	 */
	public List<Map<String, Object>> querySeriesNo(Pagination pagination);

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
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> noticeList(Pagination pagination);

	/**
	 * 消息中心 翻页
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public Pagination getNoticeContinue(Pagination pagination);

	/**
	 * 企业用户登录首页 翻页
	 * 
	 * @param pagination
	 * @return
	 */
	public Pagination getNoticePage(Pagination pagination);

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
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> selectNotice(Pagination pagination);

	/**
	 * 发送消息查询方法
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> getNoticeUser(Pagination pagination);

	/**
	 * @author hslt
	 */
	public List<GgUser> selectNotice4User(GgUser user);

	/**
	 * 反编译接收人
	 * 
	 * @author hslt
	 * @param string
	 * @return
	 */
	public List<GgNotice> selectRecipientDesc(String recipient);

	/**
	 * @author hslt
	 * @param user
	 * @return
	 */
	public List<GgUser> selectUserName(GgUser user);

	/**
	 * 我发送的消息，查询
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> queryListSend(Pagination pagination);

}
