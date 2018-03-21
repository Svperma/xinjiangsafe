package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GGovexpert;
import com.dsib.entity.GgEvaluate;

public interface GgovExpertService {

	public List<Map<String, Object>> getGgEXperQuery(Pagination pagination);

	public List<Map<String, Object>> getExpertShow(Pagination pagination);

	public void getGgExperDel(String str);

	public List<Map<String, Object>> getGgExpercommpany(Pagination pagination);

	public List<GgEvaluate> getGgExperTalk(Pagination pagination);

	public Pagination getGgExperPage(Pagination pagination);

	public Pagination getGgScopPage(Pagination pagination);

	public List<GGovexpert> selectGovExperts(GGovexpert govExpert);

	public List<Map<String, Object>> addInveStigateByExpert(
			Pagination pagination);

	public List<GGovexpert> selectGovorganByCode(GGovexpert govExpert);

}
