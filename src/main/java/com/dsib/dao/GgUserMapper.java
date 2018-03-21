package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgNotice;
import com.dsib.entity.GgUser;

public interface GgUserMapper {
	
	
	public GgUser getUser(String userCode);

	/**
	 * 查看个人中心
	 * 
	 * @hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryPersonsAll(Pagination map);

	/**
	 * qiye更新用户信息
	 * 
	 * @param ggUser
	 */
	public void updateUser(GgUser ggUser);

	/**
	 * 发送消息查询方法
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getNoticeUser(Pagination map);

	/**
	 * @author hslt
	 * @param user
	 * @return
	 */
	public List<GgUser> selectNotice4User(GgUser user);

	/**
	 * 反编译接收人
	 * 
	 * @author hslt
	 * @param recipient
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
	 * 企业个人中心信息查看
	 * 
	 * @author hslt
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryPersonsAllEnterprise(Pagination map);

	/**
	 * 插入gguser
	 * 
	 * @param ggUser
	 */
	public void insertGgUser(GgUser ggUser);

	/**
	 * @author hslt
	 * @param userCode
	 * @return
	 */
	public GgUser getObject(String userCode);

	public void updateNewUser(GgUser ggUser);

	public GgUser getUserName(String companyName);

	public void insertGgUserByRegister(GgUser ggUser);
}
