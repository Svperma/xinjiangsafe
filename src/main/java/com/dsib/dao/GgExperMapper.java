package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GGovexpert;
import com.dsib.entity.GgEvaluate;

public interface GgExperMapper {

	public List<Map<String, Object>> getGgExpert(Pagination pagination);

	public List<Map<String, Object>> getGgEXperQuery(Pagination pagination);

	public List<Map<String, Object>> getGgExperShow(Pagination pagination);

	public void getGgExperDel(String str);

	public List<Map<String, Object>> getGgExpercimpany(Pagination pagination);

	public List<GgEvaluate> getGgExperTalk(Pagination pagination);

	public List<GGovexpert> selectGovExperts(GGovexpert govExpert);

	public List<Map<String, Object>> addInveStigateByExpert(
			Pagination pagination);

	public List<GGovexpert> selectGovorganByCode(GGovexpert govExpert);

}
