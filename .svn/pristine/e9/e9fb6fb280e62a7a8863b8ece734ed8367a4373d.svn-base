package com.dsib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.QyMyclaimMapper;
import com.dsib.entity.GcClaim;
import com.dsib.entity.GcClaimProve;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.QyMyclaimService;

@Service("QyMyclaimService")
public class QyMyclaimServiceImpl implements QyMyclaimService {

	@Autowired
	private QyMyclaimMapper myclaim;

	public List<Map<String, Object>> getClaimInit(Pagination pagination) {

		List<Map<String, Object>> resultList = null;

		try {
			resultList = myclaim.getClaimInit(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
	
	@Override
	public List<Map<String, Object>> getClaimInitlize(Pagination pagination) {
		
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		try{
			resultList = myclaim.getClaimInitlize(pagination);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}

	public Map<String, Object> getBusinessno(String userCode) {

		Map<String, Object> resultMap = null;

		try {
			resultMap = myclaim.getBusinessno(userCode);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}

	public void setClaimInsert(GcClaim gcClaim) {

		try {
			myclaim.getClaimInsert(gcClaim);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Pagination getClaimInitPagination(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = myclaim.getClaimInit(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	public List<Map<String, Object>> getClaimShow(String businessno) {
		List<Map<String, Object>> resultMap = new ArrayList<Map<String,Object>>();
		try {
			resultMap = myclaim.getClaimShow(businessno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}

	public void getClaimchuan(GcClaimProve GcClaimProve) {

		try {
			myclaim.getClaimchuan(GcClaimProve);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Map<String, Object> getClaimInsurance(String BAOANNO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = myclaim.getClaimInsurance(BAOANNO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}

	// 修改GGCODE表的 总评分
	public void mySerce() {
		try {
			myclaim.mySerce();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void myPolicy() {
		try {
			myclaim.myPolicy();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void myCheckTalk(GgEvaluate GggEvaluate) {
		try {
			myclaim.myCheckTalk(GggEvaluate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Map<String, Object>> getClaimExcel(ConditionAdapter conditionAdapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = myclaim.getClaimExcel(conditionAdapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> historytalk(Map map) {
		List<Map<String, Object>> mapResult = new ArrayList<Map<String, Object>>();
		try {
			mapResult = myclaim.historytalk(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapResult;
	}

	public Map<String, Object> chakan(String str) {
		Map<String, Object> mapresult = new HashMap<String, Object>();
		try {
			mapresult = myclaim.chakan(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapresult;
	}

	public void xiugai(GcClaimProve gcClaimProve) {
		try {
			myclaim.xiugai(gcClaimProve);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List talkcount(String id) {
		List<Map<String, Object>> count = new ArrayList<Map<String, Object>>();
		try {
			count = myclaim.talkcount(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}

	public List<GuPolicyMain> selectByGuPolicyMain(GuPolicyMain gu) {
		List<GuPolicyMain> list = null;
		try {
			list = myclaim.selectByGuPolicyMain(gu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String selectScrop(String str) {
		String result = "";
		try{
			result = myclaim.selectScrop(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return result;
	}

	@Override
	public void baoanNo(GcClaim gcClaim) {
		myclaim.baoanNo(gcClaim);
		
	}

	@Override
	public List<GcClaim> getClaimByLossDateAndPolicyNo(GcClaim claim) {
		return myclaim.getClaimByLossDateAndPolicyNo(claim);
	}


}
