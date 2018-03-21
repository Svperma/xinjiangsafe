package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
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

public interface InsurePolicyService {
	
	int insert(GuPolicyInsurePremium record);

    int insertSelective(GuPolicyInsurePremium record);

    GuPolicyInsurePremium selectByPrimaryKey(GuPolicyInsurePremiumKey key);

    int updateByPrimaryKeySelective(GuPolicyInsurePremium record);

    int updateByPrimaryKey(GuPolicyInsurePremium record);

	int deleteByPrimaryKey(GgKindKey key);

	int insert(GgKind record);

	int insertSelective(GgKind record);

	GgKind selectByPrimaryKey(GgKindKey key);

	int updateByPrimaryKeySelective(GgKind record);

	int updateByPrimaryKey(GgKind record);

	int deleteByPrimaryKey(GgKindRateKey key);

	int insert(GgKindRate record);

	int insertSelective(GgKindRate record);

	GgKindRate selectByPrimaryKey(GgKindRateKey key);

	int updateByPrimaryKeySelective(GgKindRate record);

	int updateByPrimaryKey(GgKindRate record);

	int deleteByPrimaryKey(GuPolicyCoinsKey key);

	int insert(GuPolicyCoins record);

	int insertSelective(GuPolicyCoins record);

	GuPolicyCoins selectByPrimaryKey(GuPolicyCoinsKey key);

	int updateByPrimaryKeySelective(GuPolicyCoins record);

	int updateByPrimaryKey(GuPolicyCoins record);

	int deleteByPrimaryKey(String businessno);

	int insert(GuPolicyFee record);

	int insertSelective(GuPolicyFee record);

	GuPolicyFee selectByPrimaryKey(String businessno);

	int updateByPrimaryKeySelective(GuPolicyFee record);

	int updateByPrimaryKey(GuPolicyFee record);

	int deleteByPrimaryKey(GuPolicyInsuredKey key);

	int insert(GuPolicyInsured record);

	int insertSelective(GuPolicyInsured record);

	GuPolicyInsured selectByPrimaryKey(GuPolicyInsuredKey key);

	int updateByPrimaryKeySelective(GuPolicyInsured record);

	int updateByPrimaryKey(GuPolicyInsured record);

	int deleteByPrimaryKey(GuPolicyItemKindKey key);

	int insert(GuPolicyItemKind record);

	int insertSelective(GuPolicyItemKind record);

	GuPolicyItemKind selectByPrimaryKey(GuPolicyItemKindKey key);

	int updateByPrimaryKeySelective(GuPolicyItemKind record);

	int updateByPrimaryKey(GuPolicyItemKind record);

	int deleteByPrimaryKey(GuPolicyLimitKey key);

	int insert(GuPolicyLimit record);

	int insertSelective(GuPolicyLimit record);

	GuPolicyLimit selectByPrimaryKey(GuPolicyLimitKey key);

	int updateByPrimaryKeySelective(GuPolicyLimit record);

	int updateByPrimaryKey(GuPolicyLimit record);

	int deleteByPrimaryKey(GgKindPriceKey key);

	int insert(GgKindPrice record);

	int insertSelective(GgKindPrice record);

	GgKindPrice selectByPrimaryKey(GgKindPriceKey key);

	int updateByPrimaryKeySelective(GgKindPrice record);

	int updateByPrimaryKey(GgKindPrice record);

	int insert(GuPolicyAdjustRate record);

	int insertSelective(GuPolicyAdjustRate record);

	GuPolicyAdjustRate selectByPrimaryKey2(String businessno);

	int updateByPrimaryKeySelective(GuPolicyAdjustRate record);

	int updateByPrimaryKey(GuPolicyAdjustRate record);

	/**
	 * 根据地区获取可投保险种
	 * 
	 * @param ggUser
	 * @return
	 */
	List<GgRisk> findKind4Aera(GgUser ggUser);

	/**
	 * 
	 * @param key
	 * @return
	 */
	GgRisk selectByPrimaryKey(GgRiskKey key);

	/**
	 * 根据主键获取保险公司详细信息
	 * 
	 * @param key
	 * @return
	 */
	GgInsuranceDetail selectByPrimaryKey(GgInsuranceDetailKey key);

	/**
	 * 查询当前保险公司所属险种的费率
	 * 
	 * @param ggKind
	 * @return
	 */
	List<GgKind> getGgKindList(GgKind ggKind);

	/**
	 * 获取限额费率
	 * 
	 * @param key
	 * @return
	 */
	GgAmountRate selectByType(GgAmountRate ggAmountRate);

	/**
	 * 获取企业折扣
	 * 
	 * @param ggUserRateKey
	 * @return
	 */
	GgUserRate selectByPrimaryKey(GgUserRateKey ggUserRateKey);

	/**
	 * 查询企业是否有已经生效的保单
	 * 
	 * @param main
	 * @return
	 */
	List<GuPolicyMain> selectRenewalFlag(GuPolicyMain main);
	
	List<GgEmployee> getGgEmployeeList(GgEmployee ggEmployee);
	
	int deleteByPrimaryKey2(String businessno);

	int insert(GuPolicyMain record);

	int insertSelective(GuPolicyMain record);

	GuPolicyMain selectByPrimaryKey3(String businessno);

	int updateByPrimaryKeySelective(GuPolicyMain record);

	int updateByPrimaryKey(GuPolicyMain record);

	/**
	 * 获取可以当前企业可投保的总限额
	 * 
	 * @param ggAmountRate
	 * @return
	 */
	List<GgAmountRate> getAmountList(GgAmountRate ggAmountRate);

	/**
	 * 插入投保单数据
	 * 
	 * @param guPolicyMain
	 * @param guPolicyFee
	 * @param guPolicyAdjustRate
	 * @param guPolicyItemKindList
	 * @param guPolicyLimitList
	 * @param guPolicyInsuredList
	 */
	void insertAll(GuPolicyMain guPolicyMain, GuPolicyFee guPolicyFee,
			GuPolicyAdjustRate guPolicyAdjustRate,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyLimit> guPolicyLimitList,
			List<GuPolicyInsured> guPolicyInsuredList);
	/**
	 * 获取跟单员工列表
	 * 
	 * @param ggAmountRate
	 * @return
	 */
	List<GuPolicyEmployee> findEmployeeList(GuPolicyEmployee guPolicyEmployee);
	/**
	 * 插入投保单数据
	 * @param guPolicyMain
	 * @param guPolicyFee
	 * @param guPolicyAdjustRate
	 * @param guPolicyItemKindList
	 * @param guPolicyLimitList
	 * @param guPolicyInsuredList
	 * @param guPolicyEmployeeList
	 */
	void insertAll(GuPolicyMain guPolicyMain, GuPolicyFee guPolicyFee,
			GuPolicyAdjustRate guPolicyAdjustRate,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyLimit> guPolicyLimitList,
			List<GuPolicyInsured> guPolicyInsuredList,
			List<GuPolicyEmployee> guPolicyEmployeeList);
	/**
	 * 根据业务号查询所有跟单险别数据
	 * @param guPolicyItemKind
	 * @return
	 */
	List<GuPolicyItemKind> selectListByBusinessNo(
			GuPolicyItemKind guPolicyItemKind);
	/**
	 * 插入报价单
	 * @param guPolicyMain
	 * @param guPolicyFee
	 * @param guPolicyAdjustRate
	 * @param guPolicyItemKindList
	 * @param guPolicyLimitList
	 * @param guPolicyInsuredList
	 * @param guPolicyEmployeeList
	 * @param guPolicyInsurePremiumList
	 */
	void insertAll(GuPolicyMain guPolicyMain, GuPolicyFee guPolicyFee,
			GuPolicyAdjustRate guPolicyAdjustRate,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyLimit> guPolicyLimitList,
			List<GuPolicyInsured> guPolicyInsuredList,
			List<GuPolicyEmployee> guPolicyEmployeeList,
			List<GuPolicyInsurePremium> guPolicyInsurePremiumList);
	/**
	 * 查询报价列表
	 * @param guPolicyInsurePremiumKey
	 * @return
	 */
	List<GuPolicyInsurePremium> findInsurePremiumList(GuPolicyInsurePremiumKey guPolicyInsurePremiumKey);
	/**
	 * 带有事务的报价单更新
	 * @param guPolicyMain
	 * @param guPolicyFee
	 * @param guPolicyItemKindlist
	 */
	void updateTempBean(GuPolicyMain guPolicyMain, GuPolicyFee guPolicyFee,
			List<GuPolicyItemKind> guPolicyItemKindlist);
	/**
	 * 校验是否可以投保
	 * @param userCode
	 * @return
	 */
	List<GuPolicyMain> checkPolicyHas(String userCode);
	/**
	 * 爱玩玩
	 * @param businessno
	 * @return
	 */
	List<GuPolicyMain> selectByiddd(String businessno);
	/**
	 * 呵呵
	 * @param guPolicyMain
	 * @return
	 */
	List<Map<String, Object>> exportJuck(GuPolicyMain guPolicyMain);
	/**
	 * 评价查询
	 * @param pagination
	 * @return
	 */
	List<Map<String, Object>> getPingJia(Pagination pagination);
	/**
	 * 评价查询
	 * @param pagination
	 * @return
	 */
	Pagination getPingJiaCC(Pagination pagination);
	/**
	 * 删除评价
	 * @param businessno
	 */
	void delPingjia(String businessno);
	
	int insertSelective(GgCompanySum record);

    int updateByPrimaryKeySelective(GgCompanySum record);
    
    GgCompanySum selectByPrimaryKeyC(String areaCode);

	List<Map<String, Object>> selectCompanySum(ConditionAdapter adapter);
	/**
	 * 批量导入保单
	 * @param list
	 * @param listInsured
	 * @param listItem
	 */
	void insertBatchPolicy(List<GuPolicyMain> list,
			List<GuPolicyInsured> listInsured, List<GuPolicyItemKind> listItem,List<GgUserCorp> userCorps);

}
