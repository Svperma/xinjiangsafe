package com.dsib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.GgSubscribeMapper;
import com.dsib.entity.GgSubscribe;
import com.dsib.service.GgSubscribeService;

@Service("ggSubscribeService")
public class GgSubscribeServiceImpl implements GgSubscribeService {

	@Autowired
	GgSubscribeMapper mapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertInveStigate(GgSubscribe scribe) {
		boolean list = false;
		try {
			list = mapper.insertInveStigate(scribe);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
