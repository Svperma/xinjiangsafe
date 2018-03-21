package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgExperMapper;
import com.dsib.entity.GGovexpert;
import com.dsib.entity.GgEvaluate;
import com.dsib.service.GgovExpertService;

@Service("ggovExpertService")
public class GgExpertServiceImpl implements GgovExpertService {

	@Autowired
	private GgExperMapper ggExpermapper;

	public List<Map<String, Object>> getGgEXperQuery(Pagination pagination) {
		List<Map<String, Object>> resList = null;
		try {
			resList = ggExpermapper.getGgEXperQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resList;
	}

	public List<Map<String, Object>> getExpertShow(Pagination pagination) {
		List<Map<String, Object>> restList = null;
		try {
			restList = ggExpermapper.getGgExperShow(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return restList;
	}

	public void getGgExperDel(String str) {
		try {
			ggExpermapper.getGgExperDel(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public List<Map<String, Object>> getGgExpercommpany(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggExpermapper.getGgExpercimpany(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<GgEvaluate> getGgExperTalk(Pagination pagination) {

		List<GgEvaluate> resultList = null;
		try {
			resultList = ggExpermapper.getGgExperTalk(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return resultList;
	}

	public Pagination getGgExperPage(Pagination pagination) {

		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggExpermapper.getGgEXperQuery(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return pagination;
	}

	public Pagination getGgScopPage(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggExpermapper.getGgExpercimpany(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;

	}

	public List<GGovexpert> selectGovExperts(GGovexpert govExpert) {
		List<GGovexpert> list = null;
		try {
			list = ggExpermapper.selectGovExperts(govExpert);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<Map<String, Object>> addInveStigateByExpert(
			Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggExpermapper.addInveStigateByExpert(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List<GGovexpert> selectGovorganByCode(GGovexpert govExpert) {
		List<GGovexpert> list = null;
		try {
			list = ggExpermapper.selectGovorganByCode(govExpert);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
