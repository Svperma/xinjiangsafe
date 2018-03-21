package com.dsib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GgCommonwealMapper;
import com.dsib.entity.Gupreventfeedetail;
import com.dsib.service.GgCommonwealService;

@Service("GgCommonweal")
public class GgCommonwealServiceImpl implements GgCommonwealService {

	@Autowired
	private GgCommonwealMapper ggCommonweal;

	public List<Map<String, Object>> getCommonwealQuery(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.getCommonwealQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Map<String, Object> getCommonsumQuery(Pagination pagination) {
		Map<String, Object> resultList = null;
		try {
			resultList = ggCommonweal.getCommonsumQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public void getCommonInsert(Gupreventfeedetail gu) {
		try {
			ggCommonweal.getCommonInsert(gu);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Map<String, Object> getCommonShow(String id) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = ggCommonweal.getCommonShow(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}

	public List<Map<String, Object>> getCommonwealExel(ConditionAdapter adapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.getCommonwealExel(adapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
	public List<Map<String, Object>> getDsManagerPreventiveToExc(ConditionAdapter adapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.getDsManagerPreventiveToExc(adapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Pagination getCommonwealPage(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.getCommonwealQuery(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}

	public List<Map<String, Object>> getqian() {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.getqian();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> selectDsManager_commonweal(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.selectDsManager_commonweal(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
	public Pagination getPreventiveContinue(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.selectDsManager_commonweal(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}


	public List<Map<String, Object>> companyQuery(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.companyQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}


	public Pagination companyQueryContinue(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.companyQuery(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}


	public List<Map<String, Object>> exportCompany(ConditionAdapter adapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.exportCompany(adapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public List<Map<String, Object>> claimQuery(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.claimQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	public Pagination claimQueryContinue(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.claimQuery(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}


	public List<Map<String, Object>> exportClaim(ConditionAdapter adapter) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.exportClaim(adapter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Map<String, Object>> findpromthous(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.findpromthous(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Pagination findpromthousContinue(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.findpromthous(pagination);
			pagination.setResultList(resultList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pagination;
	}

	@Override
	public void quePromthous(String businessno) {
		ggCommonweal.quePromthous(businessno);
	}

	@Override
	public List<Map<String, Object>> claimListQuery(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggCommonweal.claimListQuery(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Double getSumUsePreventFee(Map<String, Object> map) {
		return ggCommonweal.getSumUsePreventFee(map);
	}
}