package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgUser;
import com.dsib.service.base.BaseService;

public interface GgUserService extends BaseService {
	
	public GgUser getUser(String userCode);

	/**
	 * 个人信息查看
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryPersonsAll(Pagination pagination)
			throws Exception;

	/**
	 * qiye更新用户信息
	 * 
	 * @param ggUser
	 */
	public void updateUser(GgUser ggUser);

	/**
	 * 企业个人中心信息查看
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> queryPersonsAllEnterprise(
			Pagination pagination);

	public void insertGgUser(GgUser ggUser);

	/**
	 * 获取监管用户对象
	 * 
	 * @param userCode
	 * @return
	 */
	public GgUser getObject(String userCode);

	public void updateNewUser(GgUser gguser);

	public void insertGgUserByRegister(GgUser ggUser);
}
