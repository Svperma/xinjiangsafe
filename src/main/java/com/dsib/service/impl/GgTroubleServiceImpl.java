package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgTroubleMapper;
import com.dsib.service.GgTroubleService;

@Service("ggTroubleService")
public class GgTroubleServiceImpl implements GgTroubleService {

	@Autowired
	private GgTroubleMapper ggtroubleMapper;

	public List<Map<String, Object>> getTroublehandle(Pagination pagination) {
		List<Map<String, Object>> resList = null;
		try {
			resList = ggtroubleMapper.getGgTrouble(pagination);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resList;
	}

	public Map<String, Object> getShow(String id) {
		Map<String, Object> resList = null;
		try {
			resList = ggtroubleMapper.getShow(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resList;
	}

}
