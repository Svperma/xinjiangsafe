package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GgAmountRateMapper;
import com.dsib.dao.GgCompanySumMapper;
import com.dsib.dao.GgEmployeeMapper;
import com.dsib.dao.GgInsuranceDetailMapper;
import com.dsib.dao.GgKindMapper;
import com.dsib.dao.GgKindPriceMapper;
import com.dsib.dao.GgKindRateMapper;
import com.dsib.dao.GgRiskMapper;
import com.dsib.dao.GgUserCorpMapper;
import com.dsib.dao.GgUserRateMapper;
import com.dsib.dao.GuPolicyAdjustRateMapper;
import com.dsib.dao.GuPolicyCoinsMapper;
import com.dsib.dao.GuPolicyEmployeeMapper;
import com.dsib.dao.GuPolicyFeeMapper;
import com.dsib.dao.GuPolicyInsurePremiumMapper;
import com.dsib.dao.GuPolicyInsuredMapper;
import com.dsib.dao.GuPolicyItemKindMapper;
import com.dsib.dao.GuPolicyLimitMapper;
import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GgAmountRate;
import com.dsib.entity.GgCompanySum;
import com.dsib.entity.GgEmployee;
import com.dsib.entity.GgInsuranceDetail;
import com.dsib.entity.GgInsuranceDetailKey;
import com.dsib.entity.GgKind;
import com.dsib.entity.GgKindKey;
import com.dsib.entity.GgKindPrice;
import com.dsib.entity.GgKindPriceKey;
import com.dsib.entity.GgKindRate;
import com.dsib.entity.GgKindRateKey;
import com.dsib.entity.GgRisk;
import com.dsib.entity.GgRiskKey;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GgUserRate;
import com.dsib.entity.GgUserRateKey;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyCoins;
import com.dsib.entity.GuPolicyCoinsKey;
import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyFee;
import com.dsib.entity.GuPolicyInsurePremium;
import com.dsib.entity.GuPolicyInsurePremiumKey;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyItemKindKey;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyLimitKey;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.InsurePolicyService;

@Service("insurePolicyService")
public class InsurePolicyServiceImpl implements InsurePolicyService {

	@Autowired
	private GgKindMapper ggKindMapper;
	@Autowired
	private GgKindRateMapper ggKindRateMapper;
	@Autowired
	private GuPolicyFeeMapper guPolicyFeeMapper;
	@Autowired
	private GuPolicyInsuredMapper guPolicyInsuredMapper;
	@Autowired
	private GuPolicyItemKindMapper guPolicyItemKindMapper;
	@Autowired
	private GuPolicyLimitMapper guPolicyLimitMapper;
	@Autowired
	private GuPolicyCoinsMapper guPolicyCoinsMapper;
	@Autowired
	private GgKindPriceMapper ggKindPriceMapper;
	@Autowired
	private GgRiskMapper ggRiskMapper;
	@Autowired
	private GgInsuranceDetailMapper ggInsuranceDetailMapper;
	@Autowired
	private GgAmountRateMapper ggAmountRateMapper;
	@Autowired
	private GgUserRateMapper ggUserRateMapper;
	@Autowired
	private GuPolicyAdjustRateMapper guPolicyAdjustRateMapper;
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;
	@Autowired
	private GgEmployeeMapper ggEmployeeMapper;
	@Autowired
	private GuPolicyEmployeeMapper guPolicyEmployeeMapper;
	@Autowired
	private GuPolicyInsurePremiumMapper guPolicyInsurePremiumMapper;
	@Autowired
	private GgCompanySumMapper ggCompanySumMapper;
	
	@Autowired
	private GgUserCorpMapper userCorpMapper;
	
	
	public int deleteByPrimaryKey(GgKindKey key) {
		return ggKindMapper.deleteByPrimaryKey(key);
	}

	public int insert(GgKind record) {
		return ggKindMapper.insert(record);
	}

	public int insertSelective(GgKind record) {
		return ggKindMapper.insertSelective(record);
	}

	public GgKind selectByPrimaryKey(GgKindKey key) {
		return ggKindMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GgKind record) {
		return ggKindMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GgKind record) {
		return ggKindMapper.updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(GgKindRateKey key) {
		return ggKindRateMapper.deleteByPrimaryKey(key);
	}

	public int insert(GgKindRate record) {
		return ggKindRateMapper.insert(record);
	}

	public int insertSelective(GgKindRate record) {
		return ggKindRateMapper.insertSelective(record);
	}

	public GgKindRate selectByPrimaryKey(GgKindRateKey key) {
		return ggKindRateMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GgKindRate record) {
		return ggKindRateMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GgKindRate record) {
		return ggKindRateMapper.updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(GuPolicyCoinsKey key) {
		return guPolicyCoinsMapper.deleteByPrimaryKey(key);
	}

	public int insert(GuPolicyCoins record) {
		return guPolicyCoinsMapper.insert(record);
	}

	public int insertSelective(GuPolicyCoins record) {
		return guPolicyCoinsMapper.insertSelective(record);
	}

	public GuPolicyCoins selectByPrimaryKey(GuPolicyCoinsKey key) {
		return guPolicyCoinsMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GuPolicyCoins record) {
		return guPolicyCoinsMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyCoins record) {
		return guPolicyCoinsMapper.updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(String businessno) {
		return guPolicyFeeMapper.deleteByPrimaryKey(businessno);
	}

	public int insert(GuPolicyFee record) {
		return guPolicyFeeMapper.insert(record);
	}

	public int insertSelective(GuPolicyFee record) {
		return guPolicyFeeMapper.insertSelective(record);
	}

	public GuPolicyFee selectByPrimaryKey(String businessno) {
		return guPolicyFeeMapper.selectByPrimaryKey(businessno);
	}

	public int updateByPrimaryKeySelective(GuPolicyFee record) {
		return guPolicyFeeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyFee record) {
		return guPolicyFeeMapper.updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(GuPolicyInsuredKey key) {
		return guPolicyInsuredMapper.deleteByPrimaryKey(key);
	}

	public int insert(GuPolicyInsured record) {
		return guPolicyInsuredMapper.insert(record);
	}

	public int insertSelective(GuPolicyInsured record) {
		return guPolicyInsuredMapper.insertSelective(record);
	}

	public GuPolicyInsured selectByPrimaryKey(GuPolicyInsuredKey key) {
		return guPolicyInsuredMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GuPolicyInsured record) {
		return guPolicyInsuredMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyInsured record) {
		return guPolicyInsuredMapper.updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(GuPolicyItemKindKey key) {
		return guPolicyItemKindMapper.deleteByPrimaryKey(key);
	}

	public int insert(GuPolicyItemKind record) {
		return guPolicyItemKindMapper.insert(record);
	}

	public int insertSelective(GuPolicyItemKind record) {
		return guPolicyItemKindMapper.insertSelective(record);
	}

	public GuPolicyItemKind selectByPrimaryKey(GuPolicyItemKindKey key) {
		return guPolicyItemKindMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GuPolicyItemKind record) {
		return guPolicyItemKindMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyItemKind record) {
		return guPolicyItemKindMapper.updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(GuPolicyLimitKey key) {
		return guPolicyLimitMapper.deleteByPrimaryKey(key);
	}

	public int insert(GuPolicyLimit record) {
		return guPolicyLimitMapper.insert(record);
	}

	public int insertSelective(GuPolicyLimit record) {
		return guPolicyLimitMapper.insertSelective(record);
	}

	public GuPolicyLimit selectByPrimaryKey(GuPolicyLimitKey key) {
		return guPolicyLimitMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GuPolicyLimit record) {
		return guPolicyLimitMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyLimit record) {
		return guPolicyLimitMapper.updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(GgKindPriceKey key) {
		return ggKindPriceMapper.deleteByPrimaryKey(key);
	}

	public int insert(GgKindPrice record) {
		return ggKindPriceMapper.insert(record);
	}

	public int insertSelective(GgKindPrice record) {
		return ggKindPriceMapper.insertSelective(record);
	}

	public GgKindPrice selectByPrimaryKey(GgKindPriceKey key) {
		return ggKindPriceMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GgKindPrice record) {
		return ggKindPriceMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GgKindPrice record) {
		return ggKindPriceMapper.updateByPrimaryKey(record);
	}

	public List<GgRisk> findKind4Aera(GgUser ggUser) {
		return ggRiskMapper.findKind4Aera(ggUser);
	}

	public GgRisk selectByPrimaryKey(GgRiskKey key) {
		return ggRiskMapper.selectByPrimaryKey(key);
	}

	public GgInsuranceDetail selectByPrimaryKey(GgInsuranceDetailKey key) {
		return ggInsuranceDetailMapper.selectByPrimaryKey(key);
	}

	public List<GgKind> getGgKindList(GgKind ggKind) {
		return ggKindMapper.getGgKindList(ggKind);
	}

	public GgAmountRate selectByType(GgAmountRate ggAmountRate) {
		return ggAmountRateMapper.selectByType(ggAmountRate);
	}

	public GgUserRate selectByPrimaryKey(GgUserRateKey ggUserRateKey) {
		return ggUserRateMapper.selectByPrimaryKey(ggUserRateKey);
	}

	public int insert(GuPolicyAdjustRate record) {
		return guPolicyAdjustRateMapper.insert(record);
	}

	public int insertSelective(GuPolicyAdjustRate record) {
		return guPolicyAdjustRateMapper.insertSelective(record);
	}

	public int updateByPrimaryKeySelective(GuPolicyAdjustRate record) {
		return guPolicyAdjustRateMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyAdjustRate record) {
		return guPolicyAdjustRateMapper.updateByPrimaryKey(record);
	}

	public GuPolicyAdjustRate selectByPrimaryKey2(String businessno) {
		return guPolicyAdjustRateMapper.selectByPrimaryKey(businessno);
	}

	public List<GuPolicyMain> selectRenewalFlag(GuPolicyMain main) {
		return guPolicyMainMapper.selectRenewalFlag(main);
	}

	public int deleteByPrimaryKey2(String businessno) {
		return guPolicyMainMapper.deleteByPrimaryKey(businessno);
	}

	public int insert(GuPolicyMain record) {
		return guPolicyMainMapper.insert(record);
	}

	public int insertSelective(GuPolicyMain record) {
		return guPolicyMainMapper.insertSelective(record);
	}

	public GuPolicyMain selectByPrimaryKey3(String businessno) {
		return guPolicyMainMapper.selectByPrimaryKey(businessno);
	}

	public int updateByPrimaryKeySelective(GuPolicyMain record) {
		return guPolicyMainMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyMain record) {
		return guPolicyMainMapper.updateByPrimaryKey(record);
	}

	public List<GgAmountRate> getAmountList(GgAmountRate ggAmountRate) {
		return ggAmountRateMapper.getAmountList(ggAmountRate);
	}

	@Transactional
	public void insertAll(GuPolicyMain guPolicyMain, GuPolicyFee guPolicyFee,
			GuPolicyAdjustRate guPolicyAdjustRate,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyLimit> guPolicyLimitList,
			List<GuPolicyInsured> guPolicyInsuredList) {
		guPolicyMainMapper.insertSelective(guPolicyMain);
		guPolicyFeeMapper.insertSelective(guPolicyFee);
		guPolicyAdjustRateMapper.insertSelective(guPolicyAdjustRate);
		for (int i = 0; i < guPolicyItemKindList.size(); i++) {
			guPolicyItemKindMapper.insertSelective(guPolicyItemKindList.get(i));
		}
		for (int i = 0; i < guPolicyLimitList.size(); i++) {
			guPolicyLimitMapper.insertSelective(guPolicyLimitList.get(i));
		}
		for (int i = 0; i < guPolicyInsuredList.size(); i++) {
			guPolicyInsuredMapper.insertSelective(guPolicyInsuredList.get(i));
		}
	}

	public List<GgEmployee> getGgEmployeeList(GgEmployee ggEmployee) {
		return ggEmployeeMapper.getGgEmployeeList(ggEmployee);
	}


	public List<GuPolicyEmployee> findEmployeeList(GuPolicyEmployee guPolicyEmployee) {
		return guPolicyEmployeeMapper.findEmployeeList(guPolicyEmployee);
	}


	@Transactional
	public void insertAll(GuPolicyMain guPolicyMain, GuPolicyFee guPolicyFee,
			GuPolicyAdjustRate guPolicyAdjustRate,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyLimit> guPolicyLimitList,
			List<GuPolicyInsured> guPolicyInsuredList,
			List<GuPolicyEmployee> guPolicyEmployeeList) {
		guPolicyMainMapper.insertSelective(guPolicyMain);
		guPolicyFeeMapper.insertSelective(guPolicyFee);
		guPolicyAdjustRateMapper.insertSelective(guPolicyAdjustRate);
		for (int i = 0; i < guPolicyItemKindList.size(); i++) {
			guPolicyItemKindMapper.insertSelective(guPolicyItemKindList.get(i));
		}
		for (int i = 0; i < guPolicyLimitList.size(); i++) {
			guPolicyLimitMapper.insertSelective(guPolicyLimitList.get(i));
		}
		for (int i = 0; i < guPolicyInsuredList.size(); i++) {
			guPolicyInsuredMapper.insertSelective(guPolicyInsuredList.get(i));
		}
		for (int i = 0; i < guPolicyEmployeeList.size(); i++) {
			guPolicyEmployeeMapper.insertSelective(guPolicyEmployeeList.get(i));
		}
	}

	public List<GuPolicyItemKind> selectListByBusinessNo(
			GuPolicyItemKind guPolicyItemKind) {
		return guPolicyItemKindMapper.selectListByBusinessNo(guPolicyItemKind);
	}

	public int insert(GuPolicyInsurePremium record) {
		return guPolicyInsurePremiumMapper.insert(record);
	}

	public int insertSelective(GuPolicyInsurePremium record) {
		return guPolicyInsurePremiumMapper.insertSelective(record);
	}

	public GuPolicyInsurePremium selectByPrimaryKey(GuPolicyInsurePremiumKey key) {
		return guPolicyInsurePremiumMapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(GuPolicyInsurePremium record) {
		return guPolicyInsurePremiumMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GuPolicyInsurePremium record) {
		return guPolicyInsurePremiumMapper.updateByPrimaryKey(record);
	}

	@Transactional
	public void insertAll(GuPolicyMain guPolicyMain, GuPolicyFee guPolicyFee,
			GuPolicyAdjustRate guPolicyAdjustRate,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyLimit> guPolicyLimitList,
			List<GuPolicyInsured> guPolicyInsuredList,
			List<GuPolicyEmployee> guPolicyEmployeeList,
			List<GuPolicyInsurePremium> guPolicyInsurePremiumList) {
		
		if(null != guPolicyMain) {
			guPolicyMainMapper.insertSelective(guPolicyMain);
		}
		if(null != guPolicyFee) {
			guPolicyFeeMapper.insertSelective(guPolicyFee);
		}
		if(null != guPolicyAdjustRate) {
			guPolicyAdjustRateMapper.insertSelective(guPolicyAdjustRate);
		}
		if(null != guPolicyItemKindList) {
			for (int i = 0; i < guPolicyItemKindList.size(); i++) {
				guPolicyItemKindMapper.insertSelective(guPolicyItemKindList.get(i));
			}
		}
		if(null != guPolicyLimitList) {
			for (int i = 0; i < guPolicyLimitList.size(); i++) {
				guPolicyLimitMapper.insertSelective(guPolicyLimitList.get(i));
			}
		}
		if(null != guPolicyInsuredList) {
			for (int i = 0; i < guPolicyInsuredList.size(); i++) {
				guPolicyInsuredMapper.insertSelective(guPolicyInsuredList.get(i));
			}
		}
		if(null != guPolicyEmployeeList) {
			for (int i = 0; i < guPolicyEmployeeList.size(); i++) {
				guPolicyEmployeeMapper.insertSelective(guPolicyEmployeeList.get(i));
			}
		}
		if(null != guPolicyInsurePremiumList) {
			for (int i = 0; i < guPolicyInsurePremiumList.size(); i++) {
				guPolicyInsurePremiumMapper.insertSelective(guPolicyInsurePremiumList.get(i));
			}
		}
		
		
		
		
		
		
		
		
	}


	public List<GuPolicyInsurePremium> findInsurePremiumList(GuPolicyInsurePremiumKey guPolicyInsurePremiumKey) {
		return guPolicyInsurePremiumMapper.findInsurePremiumList(guPolicyInsurePremiumKey);
	}

	@Transactional
	public void updateTempBean(GuPolicyMain guPolicyMain,
			GuPolicyFee guPolicyFee, List<GuPolicyItemKind> guPolicyItemKindlist) {
		guPolicyMainMapper.updateByPrimaryKeySelective(guPolicyMain);
		guPolicyFeeMapper.updateByPrimaryKeySelective(guPolicyFee);
		for (int i = 0; i < guPolicyItemKindlist.size(); i++) {
			guPolicyItemKindMapper.updateByPrimaryKeySelective(guPolicyItemKindlist.get(i));
		}
	}

	@Override
	public List<GuPolicyMain> checkPolicyHas(String userCode) {
		return guPolicyMainMapper.checkPolicyHas(userCode);
	}

	@Override
	public List<GuPolicyMain> selectByiddd(String businessno) {
		return guPolicyMainMapper.selectByiddd(businessno);
	}

	@Override
	public List<Map<String, Object>> exportJuck(GuPolicyMain guPolicyMain) {
		return guPolicyMainMapper.exportJuck(guPolicyMain);
	}

	@Override
	public List<Map<String, Object>> getPingJia(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggRiskMapper.getPingJia(pagination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Pagination getPingJiaCC(Pagination pagination) {
		List<Map<String, Object>> resultList = null;
		try {
			resultList = ggRiskMapper.getPingJia(pagination);
			pagination.setResultList(resultList);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return pagination;
	}

	@Override
	public void delPingjia(String businessno) {
		ggRiskMapper.delPingjia(businessno);
	}

	@Override
	public int insertSelective(GgCompanySum record) {
		return ggCompanySumMapper.insert(record);
	}

	@Override
	public int updateByPrimaryKeySelective(GgCompanySum record) {
		return ggCompanySumMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public GgCompanySum selectByPrimaryKeyC(String areaCode) {
		return ggCompanySumMapper.selectByPrimaryKey(areaCode);
	}

	@Override
	public List<Map<String, Object>> selectCompanySum(ConditionAdapter adapter) {
		return ggCompanySumMapper.selectCompanySum(adapter);
	}

	@Transactional
	public void insertBatchPolicy(List<GuPolicyMain> list,
			List<GuPolicyInsured> listInsured, List<GuPolicyItemKind> listItem,List<GgUserCorp> userCorps) {
		for(int i=0;i<list.size();i++){
			guPolicyMainMapper.insertSelective(list.get(i));
		}
		for(int j=0;j<listInsured.size();j++){
			guPolicyInsuredMapper.insertSelective(listInsured.get(j));
		}
		for(int g=0;g<listItem.size();g++){
			guPolicyItemKindMapper.insertSelective(listItem.get(g));
		}
		
		//添加公司信息
    	for (GgUserCorp userCorp_policy : userCorps) {
			GgUserCorp userCorp_busLicenseNo =
					userCorpMapper.selectByBusinessLicenseNo(userCorp_policy.getBusinessLicenseNo());
			
			if(null == userCorp_busLicenseNo) {
				userCorpMapper.insertUserCorp(userCorp_policy);
			}
		}
		
	}


}
