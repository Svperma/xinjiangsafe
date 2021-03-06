package com.dsib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.QyMycheckMapper;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GuPolicyEndorse;
import com.dsib.service.QyMycheckService;

@Service("qymychecked")
public class QyMycheckServiceImpl implements QyMycheckService {

	@Autowired
	private QyMycheckMapper qymycheck;

	public List<Map<String, Object>> getmypolicyInit(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInit(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> getmypolicyInitjj(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInitJj(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Pagination getmypolicyInitjjPagination(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInitJj(pagination);
			pagination.setResultList(resultList);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return pagination;
	}
	
	public Pagination getmypolicyInitPagination(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInit(pagination);
			pagination.setResultList(resultList);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return pagination;
	}

	public void mychecktalk(GgEvaluate ggEvaluate) {

		try {
			qymycheck.myCheckTalk(ggEvaluate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void myserce() {
		try {
			qymycheck.mySerce();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void policy() {
		try {
			qymycheck.myPolicy();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public List<Map<String, Object>> mycheckadditional(String business) {
		List<Map<String, Object>> resultMap = null;
		try {
			resultMap = qymycheck.myCheckAdditional(business);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}

	public Map<String, Object> mycheckyeared(String business) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			resultMap = qymycheck.myCheckyeared(business);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}

	public List<Map<String, Object>> getmycheckExcel(ConditionAdapter conditionAdapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getmyCheckExcel(conditionAdapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> historytalk(Map map) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		try {
			resultList = qymycheck.historytalk(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> talkcount(String id) {
		List<Map<String, Object>> talkcount = null;
		try {
			talkcount = qymycheck.talkcount(id);

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return talkcount;
	}

	public List<Map<String, Object>> getmypolicyInitPolicy(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInitPolicy(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
	
	public Pagination getmypolicyInitPolicyPagination(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInitPolicy(pagination);
			pagination.setResultList(resultList);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return pagination;
	}

	public List<GgEvaluate> selectInsuredCode(GgEvaluate ggevaluate) {
		List<GgEvaluate> list = null;
		try {
			list = qymycheck.selectInsuredCode(ggevaluate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void myCheckTalkInsert(GgEvaluate ggEvaluate) {
		
		try {
			qymycheck.myCheckTalkInsert(ggEvaluate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}


	public List<Map<String, Object>> exportPolicy(ConditionAdapter adapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.exportPolicy(adapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}


	public List<Map<String, Object>> correctQuery(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.correctQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}


	public Pagination correctQueryContinue(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.correctQuery(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}


	public List<Map<String, Object>> exportCorrect(ConditionAdapter adapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.exportCorrect(adapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
	
	
	
	@Transactional
	public void sperialPro(Map<String, Object> map , GuPolicyEndorse guPolicyEndorse) {
		// TODO Auto-generated method stub
		try{
			qymycheck.endorse(guPolicyEndorse);
			qymycheck.sperialPro(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> getApplyInit(Pagination pagination) {
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		try{
			resultList = qymycheck.getApplyInit(pagination);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Map<String, Object>> getApply(Map<String,Object> map) {
		List<Map<String,Object>> resultMap = new ArrayList<Map<String,Object>>();
		try{
			resultMap = qymycheck.getApply(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public void auditing(Map<String, Object> map) {
		try{
			qymycheck.auditing(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void audited(Map<String, Object> map) {
		try{
			qymycheck.audited(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void aditnumber(Map<String, Object> map) {
		try{
			qymycheck.aditnumber(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void defary(Map<String, Object> map) {
		try{
			qymycheck.defary(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> getmypolicyInitjg(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInitJg(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Pagination getmypolicyInitjgPagination(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymycheck.getMyPolicyInitJg(pagination);
			pagination.setResultList(resultList);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return pagination;
	}

	/**
	 * 监管用户条件查询保单总和
	 */
	@Override
	public List<Map<String, String>> getMyPolicyInitJgNotPage(
			Map<String, Object> conditionMap) {
		return qymycheck.getMyPolicyInitJgNotPage(conditionMap);
	}

	
}
