package com.dsib.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dsib.common.Pagination;
import com.dsib.dao.GgAdministrMapper;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgUser;
import com.dsib.service.GgAdministrationService;

@Service("ggAdministration")
public class GgAdministrationServiceImpl implements GgAdministrationService {

	@Autowired
	private GgAdministrMapper ggAdmin;

	public List<Map<String, Object>> getAdminQuery(Pagination pagination) {

		List<Map<String, Object>> resultList = null;

		try {
			resultList = ggAdmin.getAdminQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public void getAdminsert(GgUser user) {
		try {
			ggAdmin.getAdminsert(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public List<Map<String, Object>> Criteria() {

		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggAdmin.Criteria();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public void setAdminStatus(String USERCODE) {

		try {
			ggAdmin.setAdminStatus(USERCODE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public GgUser getAdminEdit(String USERCODE) {
		GgUser gguser = null;
		try {
			gguser = ggAdmin.getAdminEdit(USERCODE);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return gguser;
	}

	public void getAdminUpdate(GgUser gguser) {

		try {
			ggAdmin.getAdminUpdate(gguser);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Pagination getAdminpage(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggAdmin.getAdminQuery(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}

	public List<Map<String, Object>> getAdminQueryPolicy(Pagination pagination) {
		List<Map<String, Object>> resultList = null;

		try {
			resultList = ggAdmin.getAdminQueryPolicy(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public GgUser getAdminEditNew(String userCode) {
		GgUser gguser = null;
		try {
			gguser = ggAdmin.getAdminEditNew(userCode);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return gguser;
	}

	public List<Map<String, Object>> getAdminQueryJj(Pagination pagination) {
		List<Map<String, Object>> resultList = null;

		try {
			resultList = ggAdmin.getAdminQueryJj(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
	public List<GgCode> selectByComLevel(String comLevel) {
		List<GgCode> resultList = null;

		try {
			resultList = ggAdmin.selectByComLevel(comLevel);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
}
