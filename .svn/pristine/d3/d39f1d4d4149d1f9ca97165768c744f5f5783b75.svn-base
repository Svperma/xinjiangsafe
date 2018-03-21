package com.dsib.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsib.entity.GgKind;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.PolicyManager;
import com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm;
@Component
public class TidyPolicy {
	
	@Autowired
	private JiSuanPremiumUtil jisuan;

	/**
	 * 组织数据库的itemKind
	 * @param ggKindList
	 * @param policyManager
	 * @param businessNo
	 * @return
	 * @throws Exception
	 */
	public List<GuPolicyItemKind> tideItemKind(List<GgKind> ggKindList
			,PolicyManager policyManager
			,String businessNo) throws Exception {
		
		List<GuPolicyItemKind> guPolicyItemKindList = new ArrayList<GuPolicyItemKind>();
		
		//安全等级费率
		double adjust = jisuan.getAdjust(policyManager.getStandardLevel());

		BigDecimal sumMainPremium = jisuan.getSumMainPremium2(policyManager);
		
		for (int i = 0; i < ggKindList.size(); i++) {
			GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
			guPolicyItemKind.setBusinessno(businessNo);
			guPolicyItemKind.setKindcode(ggKindList.get(i).getKindcode());
			guPolicyItemKind.setKindname(ggKindList.get(i).getKindcname());
			Date startDate = DateUtils.formatStartDate(policyManager.getStartDate());
			guPolicyItemKind.setStartdate(startDate);
			Date endDate = DateUtils.formatEndDate(policyManager.getEndDate());
			guPolicyItemKind.setEnddate(endDate);
			guPolicyItemKind.setRiskcode(policyManager.getRiskCode());
			guPolicyItemKind.setAmount(new BigDecimal(policyManager
					.getSumAmount()));
			guPolicyItemKind.setUnitamount(new BigDecimal(policyManager
					.getAmount()));
			if (i == 0) {// 主险

				guPolicyItemKind.setActualpremium(sumMainPremium);
				guPolicyItemKind.setSpreadsheetpremium(sumMainPremium);
				double mainSumRate = jisuan.getMainSumRate(policyManager);
				guPolicyItemKind.setRate(BigDecimal.valueOf(mainSumRate));
				guPolicyItemKindList.add(guPolicyItemKind);
				continue;
			}
			if ("on".equals(policyManager.getItemOne()) && i == 1) {
				Double sanamount = Double.valueOf(policyManager.getSanamount());
				BigDecimal sanZhePremium = jisuan.getSanZhePremium2(sanamount,
						adjust, ggKindList.get(i));
				guPolicyItemKind.setActualpremium(sanZhePremium);
				guPolicyItemKind.setSpreadsheetpremium(sanZhePremium);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(sanamount));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				double sanZheRate = jisuan.getSanZheRate(adjust,
						ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(sanZheRate));
				guPolicyItemKind.setRemark("500");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
			
				policyManager.setItemOne(sanZhePremium.toString());
			}
			if ("on".equals(policyManager.getItemTwo()) && i == 2) {
				BigDecimal yiLiaoPremium = jisuan
						.getYiLiaoPremium2(policyManager.getSumAmount(),
								adjust, ggKindList.get(i));
				guPolicyItemKind.setActualpremium(yiLiaoPremium);
				guPolicyItemKind.setSpreadsheetpremium(yiLiaoPremium);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getSumAmount()) * 0.3));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				double yiLiaoRate = jisuan.getYiLiaoRate(adjust,
						ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(yiLiaoRate));
				guPolicyItemKind.setRemark("500");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
				
				policyManager.setItemTwo(yiLiaoPremium.toString());
			}
			if ("on".equals(policyManager.getItemThree()) && i == 3) {
				double jiuYuanPremium = jisuan
						.getJiuYuanPremium(policyManager.getSumAmount(),
								adjust, ggKindList.get(i));
				BigDecimal jiuYuanPremium2 = BigDecimal.valueOf(jiuYuanPremium);
				guPolicyItemKind.setActualpremium(jiuYuanPremium2);
				guPolicyItemKind.setSpreadsheetpremium(jiuYuanPremium2);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getSumAmount()) * 0.3));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.3));
				double jiuYuanRate = jisuan.getJiuYuanRate(adjust,
						ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(jiuYuanRate));
				guPolicyItemKind.setRemark("2000");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
			
				policyManager.setItemThree(jiuYuanPremium2.toString());
			}
			if ("on".equals(policyManager.getItemFour()) && i == 4) {
				BigDecimal faLvPremium = jisuan
						.getFaLvPremium2(policyManager.getSumAmount(), adjust,
								ggKindList.get(i));
				guPolicyItemKind.setActualpremium(faLvPremium);
				guPolicyItemKind.setSpreadsheetpremium(faLvPremium);
				guPolicyItemKind.setAmount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getSumAmount()) * 0.05));
				guPolicyItemKind.setUnitamount(BigDecimal.valueOf(Double
						.valueOf(policyManager.getAmount()) * 0.05));
				double faLvRate = jisuan.getFaLvRate(adjust, ggKindList.get(i)) * 1000.0;
				guPolicyItemKind.setRate(BigDecimal.valueOf(faLvRate));
				guPolicyItemKind.setRemark("500");//免赔额
				guPolicyItemKindList.add(guPolicyItemKind);
			
				policyManager.setItemFour(faLvPremium.toString());
			}
		}
		
		
		return guPolicyItemKindList;
	}
}
