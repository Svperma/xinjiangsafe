package com.dsib.service;

import java.util.List;

import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluate;
import com.dsib.service.base.BaseService;

public interface GgEvaluaService extends BaseService {

	/**
	 * 查询企业登录的投诉/咨询
	 * 
	 * @author hslt
	 * @param pagination
	 * @return
	 */
	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination);

	/**
	 * 企业发送咨询
	 * 
	 * @author hslt
	 * @param ggEvaluate
	 */
	public void insertSendConsult(GgEvaluate ggEvaluate);

	public List<GgEvaluate> selectZixun(Pagination pagination);

	public Pagination getMyConsultContinuePaginations(Pagination pagination);

}
