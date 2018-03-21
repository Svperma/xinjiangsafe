package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgUser;

public interface GgAdministrationService {

	public List<Map<String, Object>> getAdminQuery(Pagination pagination);

	public void getAdminsert(GgUser user);

	public List<Map<String, Object>> Criteria();

	public void setAdminStatus(String USERCODE);

	public GgUser getAdminEdit(String USERCODE);

	public void getAdminUpdate(GgUser gguser);

	public Pagination getAdminpage(Pagination pagination);

	public List<Map<String, Object>> getAdminQueryPolicy(Pagination pagination);

	public GgUser getAdminEditNew(String userCode);
	public List<GgCode> selectByComLevel(String comLevel);

	public List<Map<String, Object>> getAdminQueryJj(Pagination pagination);


}
