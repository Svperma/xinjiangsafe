package com.dsib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgEvaluaMapper;
import com.dsib.entity.GgEvaluate;
import com.dsib.service.GgEvaluaService;

@Service("ggEvaluaService")
public class GgEvaluaServiceImpl implements GgEvaluaService {

	@Autowired
	private GgEvaluaMapper ggEvaluaMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination) {
		List<GgEvaluate> list = null;
		try {
			list = ggEvaluaMapper.getComplainAndFeedback(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void insertSendConsult(GgEvaluate ggEvaluate) {
		try {
			ggEvaluaMapper.insertSendConsult(ggEvaluate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<GgEvaluate> selectZixun(Pagination pagination) {
		List<GgEvaluate> list = null;
		try {
			list = ggEvaluaMapper.selectZixun(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Pagination getMyConsultContinuePaginations(Pagination pagination) {
		List<GgEvaluate> list = null;
		try {
			list = ggEvaluaMapper.selectZixun(pagination);
			// list = ggEvaluaMapper.getComplainAndFeedback(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

}
