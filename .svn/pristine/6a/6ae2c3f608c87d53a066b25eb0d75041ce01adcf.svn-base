package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgUser;

public interface GgAdministrMapper {

	public List<Map<String, Object>> getAdminQuery(Pagination pagination); // 初始化查询

	public void getAdminsert(GgUser user);

	public List<Map<String, Object>> Criteria(); // 增加条件查询SQL

	public void setAdminStatus(String USERCODE);

	public GgUser getAdminEdit(String USERCODE); // 点击修改查询数据

	public void getAdminUpdate(GgUser gguser);

	public List<Map<String, Object>> getAdminQueryPolicy(Pagination pagination);

	public GgUser getAdminEditNew(String userCode);
	public List<GgCode> selectByComLevel(String comLevel);

	public List<Map<String, Object>> getAdminQueryJj(Pagination pagination);

}
