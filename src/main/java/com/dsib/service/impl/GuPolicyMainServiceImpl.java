package com.dsib.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GuPolicyMain;
import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.service.GuPolicyMainService;

@Service("GuPolicyMainService")
public class GuPolicyMainServiceImpl implements GuPolicyMainService {
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getChartCount(Map map) {
		Map resMap = null;
		try {
			resMap = guPolicyMainMapper.getChartCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}

	public List<Map<String, Object>> getPolicyInfo(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.getPolicyInfo(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Pagination getEnterprises(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.getEnterprises(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	public Pagination getAssistaces(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.getAssistances(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagination;
	}

	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination) {
		List<GgEvaluate> list = null;
		try {
			list = guPolicyMainMapper.getComplainAndFeedback(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 保险截止日期
	 */
	public Date getDate(String date) {
		Date enddate = null;
		try {
			enddate = guPolicyMainMapper.getDate(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enddate;
	}

	public List<Map<String, Object>> policyToExcel(ConditionAdapter adapter) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.policyToExcel(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> enterprisesExcel(ConditionAdapter adapter) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.enterprisesExcel(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> assistancesExcel(ConditionAdapter adapter) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.assistancesExcel(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> getClaimMain(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.getClaimMain(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> claimDetail(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = guPolicyMainMapper.claimDetail(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Map<String, Object> viewDetail(String businessNo) {
		Map<String, Object> map = null;
		try {
			map = guPolicyMainMapper.viewDetail(businessNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	public void updateByBusinessNo(GuPolicyMain guPolicyMain) {
		try {
			guPolicyMainMapper.updateByBusinessNo(guPolicyMain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int updateByPrimaryKeySelective(GuPolicyMain record) {
		return guPolicyMainMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<String> isHavePolicyByIdentityNumber(String identityNumber) {
		return guPolicyMainMapper.isHavePolicyByIdentityNumber(identityNumber);
	}

	@Override
	public Map getPreventFee(Map map) {
		return guPolicyMainMapper.getPreventFee(map);
	}

	@Override
	public GuPolicyMain selectByPrimaryKey(String businessno) {
		return guPolicyMainMapper.selectByPrimaryKey(businessno);
	}

}
