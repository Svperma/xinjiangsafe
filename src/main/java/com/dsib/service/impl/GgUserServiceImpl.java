package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgUserMapper;
import com.dsib.entity.GgUser;
import com.dsib.service.GgUserService;

@Service("ggUserService")
public class GgUserServiceImpl implements GgUserService {
	@Autowired
	private GgUserMapper ggUserMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> queryPersonsAll(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserMapper.queryPersonsAll(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * qiye更新用户信息
	 */
	public void updateUser(GgUser ggUser) {
		try {
			ggUserMapper.updateUser(ggUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public List<Map<String, Object>> queryPersonsAllEnterprise(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserMapper.queryPersonsAllEnterprise(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void insertGgUser(GgUser ggUser) {
		ggUserMapper.insertGgUser(ggUser);
	}
	public void insertGgUserByRegister(GgUser ggUser) {
		ggUserMapper.insertGgUserByRegister(ggUser);
	}

	public GgUser getObject(String userCode) {
		GgUser list = null;
		try {
			list = ggUserMapper.getObject(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void updateNewUser(GgUser ggUser) {
		try {
			ggUserMapper.updateNewUser(ggUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@Override
	public GgUser getUser(String userCode) {
		return ggUserMapper.getUser(userCode);
	}

}
