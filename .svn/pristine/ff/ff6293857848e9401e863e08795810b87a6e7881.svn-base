package com.dsib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.QyMypolicyMapper;
import com.dsib.service.QyMypolicyService;

@Service("QyMyPolicy")
public class QyMypolicyServiceImpl implements QyMypolicyService {

	@Autowired
	QyMypolicyMapper qymypolicy;

	public List<Map<String, Object>> getqymypolicy(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.getQymyPolicy(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> getqymypolicyjj(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.getQymyPolicyJj(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> getqymypolicyPolicy(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.getQymyPolicyPolicy(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Pagination getqymypolicyPolicyPagination(Pagination pagination) {
		
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.getQymyPolicyPolicy(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}

	public Pagination getqymypolicyjjPagination(Pagination pagination) {

		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.getQymyPolicyJj(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}
	// public List<Map<String, Object>> getqymypolicyquery(Pagination
	// pagination) {
	// List<Map<String,Object>> resultList = null;
	// try{
	// resultList = qymypolicy.getqymypolicyquery(pagination);
	//
	// }catch(Exception ex){
	// ex.printStackTrace();
	// }
	// return resultList;
	// }

	public Map<String, Object> getmypolicyshow(String businessno) {
		Map<String, Object> resultMap = null;
		try {
			resultMap = qymypolicy.getMypolicyShow(businessno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}

	public List<Map<String, Object>> getmypolicyappend(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.getMypolicyAppend(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Pagination getqymypolicyPagination(Pagination pagination) {

		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.getQymyPolicy(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}

	public Map<String, Object> getMypolicyNOShow(String bussinessno) {
		Map<String, Object> reusltMap = null;
		try {
			reusltMap = qymypolicy.getMypolicyNOShow(bussinessno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return reusltMap;
	}

	public List<Map<String, Object>> myPolicyAdditional(String business) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = qymypolicy.myPolicyAdditional(business);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Map<String, Object> myPolicyyeared(String business) {
		Map<String, Object> resultList = null;
		try {
			resultList = qymypolicy.myPolicyyeared(business);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Map<String, Object> getMypolicyModfy(String buiness) {
		Map<String, Object> reusltMap = null;
		try {
			reusltMap = qymypolicy.getMypolicyModfy(buiness);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return reusltMap;
	}

	public Map<String, Object> showSpecial(String str) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try{
			resultMap = qymypolicy.showSpecial(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultMap;
	}

}
