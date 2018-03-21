package com.dsib.inter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyFee;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.GuInterfaceService;

@Component
public class TrimerMypolicy {

	@Resource(name = "GuInterface")
	private GuInterfaceService interService;

	public void domypolicy() {
		String url = BizInfo.pronumber("getmypolicy");
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		String upmaxmypolicytime = BizInfo.proread("upmaxmypolicytime");
		String threeCode = BizInfo.proread("usercorp");
		pairs.add(new BasicNameValuePair("tertiaryCode", threeCode));// 第三方机构
		pairs.add(new BasicNameValuePair("changeDate", upmaxmypolicytime));
		String json = HttpRequestUtils.httpPost(url, pairs); // 获取的json对象
		System.out.println("JSONOBJECR" + json);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String time = BizInfo.proread("upmaxmypolicytime");// 保存更新时间
		if (json.substring(0, 1).equals("[")) {
			JSONArray arrayresult = (JSONArray) JSONArray.parse(json);// 将字符串转换成JSONArray
			GuPolicyAdjustRate adjustRate = new GuPolicyAdjustRate();// 费率
			List<GuServiceInter> guServiceInterList = new ArrayList<GuServiceInter>();
			GuPolicyFee fee = new GuPolicyFee();// 费率
			GuServiceInter guServiceInter = new GuServiceInter();
			for (int i = 0; i < arrayresult.size(); i++) {
				JSONObject objectResult = (JSONObject) arrayresult.get(i);
				String businessNo = objectResult.getString("businessNo");// 业务号
				String specialProvisions = objectResult
						.getString("specialProvisions");

				// 在guPolicyItemKind表中添加
				String additionalEmployerActualPremium = objectResult
						.getString("additionalEmployerActualPremium");// 补充雇主责任保险实际保费
				String additionalEmployerAmount = objectResult
						.getString("additionalEmployerAmount");// 补充雇主责任保险保额getUnitamount()
				String additionalEmployerSpreadsheetPremium = objectResult
						.getString("additionalEmployerSpreadsheetPremium");// 补充雇主责任保险试算保费
				String additionalEmployerSumAmount = objectResult
						.getString("additionalEmployerSumAmount");// 补充雇主责任保险保额amount()
				String additionalMedicalExpensesActualPremium = objectResult
						.getString("additionalMedicalExpensesActualPremium");// 附加医疗费用保险实际保费
				String additionalMedicalExpensesSpreadsheetPremium = objectResult
						.getString("additionalMedicalExpensesSpreadsheetPremium");// 附加医疗费用保险试算保费
				String additionalMedicalExpensesSumAmount = objectResult
						.getString("additionalMedicalExpensesSumAmount");// 附加医疗费用保险amount()
				String safetyProductionActualPremium = objectResult
						.getString("safetyProductionActualPremium");// 安全生产责任险试算保费
				String safetyProductionAmount = objectResult
						.getString("safetyProductionAmount");// 安全生产责任险保额getUnitamount()
				String safetyProductionSpreadsheetPremium = objectResult
						.getString("safetyProductionSpreadsheetPremium");// 安全生产责任险实际保费
				String safetyProductionSumAmount = objectResult
						.getString("safetyProductionSumAmount");// 安全生产保险保额amount()
				String thirdPartyPropertyLossActualPremium = objectResult
						.getString("thirdPartyPropertyLossActualPremium");// 补充第三者责任限额实际保费
				String thirdPartyPropertyLossAmount = objectResult
						.getString("thirdPartyPropertyLossAmount");// 补充第三者责任保额amount()
				String thirdPartyPropertyLossSpreadsheetPremium = objectResult
						.getString("thirdPartyPropertyLossSpreadsheetPremium");// 补充第三者责任试算保费
				String thirdPartyPropertyLossSumAmount = objectResult
						.getString("thirdPartyPropertyLossSumAmount");// 补充第三者责任保额amount()
				// 在GuPolicyAdjustRate表中添加
				String amountAdjust = objectResult.getString("amountAdjust");// 每人费率
				String lossRatioAdjust = objectResult
						.getString("lossRatioAdjust");// 企业事故率折扣
				String renewalAdjust = objectResult.getString("renewalAdjust");// 续保折扣
				String renewalFlag = objectResult.getString("renewalFlag"); // 状态
				String shortRate = objectResult.getString("shortRate");// 短期费率
				String standardLevelRate = objectResult
						.getString("standardLevelRate");// 安全标准化费率
				String sumAmountAdjust = objectResult
						.getString("sumAmountAdjust");// 累积费率
				// 在PolicyMain 中添加
				String appliAddress = objectResult.getString("appliAddress");// 投保人地址
				String appliCode = objectResult.getString("appliCode");// 投保人CODE
				String appliName = objectResult.getString("appliName");// 投保人名字
				String arbitBoardName = objectResult
						.getString("arbitBoardName");// 仲裁委员会名称
				String argueSolution = objectResult.getString("argueSolution");// 争议解决方案方式
				String accidentPreventFee = objectResult
						.getString("accidentPreventFee");// 事故预防费
				String actualPremium = objectResult.getString("actualPremium"); // 实际保费
				String city = objectResult.getString("city");// 市
				String classCode = objectResult.getString("classCode");// 险类代码
				String county = objectResult.getString("county");// 区县
				String disCount = objectResult.getString("disCount");// 总折扣NUMBER类型
				String endDate = objectResult.getString("endDate");// DATE类型
				String insuredAddress = objectResult
						.getString("insuredAddress");// 被保险地址
				String insuredName = objectResult.getString("insuredName");// 被保险人姓名
				String insuredcode = objectResult.getString("insuredcode");// 被保险人CODE
				String insurerCode = objectResult.getString("insurerCode");// 保险人CODE
				String operateDate = objectResult.getString("operateDate");// 操作时间

				if (operateDate.compareTo(time) > 0) {
					time = operateDate;
				}
				String operatorCode = objectResult.getString("operatorCode");// 操作员CODE
				String payBillNo = objectResult.getString("payBillNo");// 支付账号
				String payFlag = objectResult.getString("payFlag");// 缴费标志
				String planCode = objectResult.getString("planCode");// 方案
				String policyNo = objectResult.getString("policyNo");// 保单号
				String previousPolicyNo = objectResult
						.getString("previousPolicyNo");// 上一年的保单号
				String proposalNo = objectResult.getString("proposalNo");// 投保单号
				String province = objectResult.getString("province");// 省
				String riskCode = objectResult.getString("riskCode");// 险种代码
				String spreadsheetPremium = objectResult
						.getString("spreadsheetPremium");// guPolicyItemKind表
				String startDate = objectResult.getString("startDate");
				String sumAmout = objectResult.getString("sumAmout");
				// 在 GUPOLICYINSURED 表中添加
				String appliIdentifyNumber = objectResult
						.getString("appliIdentifyNumber");// 投保人证件号码
				String appliIdentifyType = objectResult
						.getString("appliIdentifyType"); // 投保人证件类型
				String appliMoble = objectResult.getString("appliMoble");// 投保人电话？？
				String appliEmail = objectResult.getString("appliEmail");// 投保人Email
				String insuredIdentifyNumber = objectResult
						.getString("insuredIdentifyNumber");// 被保险人证件号码
				String insuredIdentifyType = objectResult
						.getString("insuredIdentifyType");// 被保险人证件类型
				String insuredMoble = objectResult.getString("insuredMoble");// 被保险人电话？？
				String insuredEmail = objectResult.getString("insuredEmail");// 被保险EMAIL
				// 在GUPolicyLimit表中添加
				String employeeLiabilityLimits = objectResult
						.getString("employeeLiabilityLimits");// 从业人员责任限额
				String legalLiabilityLimit = objectResult
						.getString("legalLiabilityLimit");// 法律费用责任限额
				String rescueExpenseLiabilityLimit = objectResult
						.getString("rescueExpenseLiabilityLimit");// 救援责任限额
				String thirdPartyLiabilityLimits = objectResult
						.getString("thirdPartyLiabilityLimits");// 第三者责任限额

				// 插入adjustRate中
				adjustRate.setBusinessno(businessNo);
				adjustRate.setAmountadjust(amountAdjust);
				adjustRate.setLossrate(lossRatioAdjust);
				adjustRate.setRenewalrate(renewalAdjust);
				adjustRate.setFlag(renewalFlag);
				adjustRate.setShortrate(shortRate);
				adjustRate.setStandardlevelrate(standardLevelRate);
				adjustRate.setSumamountadjust(sumAmountAdjust);
				boolean adjustRatestatu;// 状态：true.进行插入;false.进行修改
				Map<String, Object> mapadjustResult = interService
						.showadjustRate(adjustRate.getBusinessno());
				if (mapadjustResult != null && mapadjustResult.size() > 0) {
					adjustRatestatu = false;
				} else {
					adjustRatestatu = true;
				}
				guServiceInter.setPolicyAdjustRate(adjustRate);
				guServiceInter.setAdjustRatestatu(adjustRatestatu);
				// 插入itemKind中
				List<GuPolicyItemKind> kindList = new ArrayList<GuPolicyItemKind>();
				if (additionalEmployerActualPremium == ""
						|| additionalEmployerSpreadsheetPremium == "") {
					GuPolicyItemKind itemKind = new GuPolicyItemKind(); // 附加险
					itemKind.setBusinessno(businessNo);
					itemKind.setKindcode("0901003");
					itemKind.setKindname("附加补充雇主责任保险");
					itemKind.setRiskcode(riskCode);
					itemKind.setSpreadsheetpremium(BigDecimal.valueOf(Double
							.parseDouble(additionalEmployerSpreadsheetPremium)));
					itemKind.setActualpremium(BigDecimal.valueOf(Double
							.parseDouble(additionalEmployerActualPremium)));
					itemKind.setAmount(BigDecimal.valueOf(Double
							.parseDouble(additionalEmployerSumAmount)));
					itemKind.setUnitamount(BigDecimal.valueOf(Double
							.parseDouble(additionalEmployerAmount)));
					itemKind.setPolicyno(policyNo);
					try {
						itemKind.setStartdate(sim.parse(startDate));
						itemKind.setEnddate(sim.parse(endDate));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Map<String, Object> check = new HashMap<String, Object>();
					check.put("businessNo", itemKind.getKindcode());
					check.put("kindCode", itemKind.getKindname());
					Map<String, Object> mapkindResult = interService
							.showitemKind(check);
					if (mapkindResult != null && mapkindResult.size() > 0) {
						itemKind.setJudge(false);
					} else {
						itemKind.setJudge(true);
					}
					kindList.add(itemKind);
				}
				if (additionalMedicalExpensesActualPremium == ""
						|| additionalMedicalExpensesSpreadsheetPremium == "") {
					GuPolicyItemKind itemKind = new GuPolicyItemKind(); // 附加险
					itemKind.setBusinessno(businessNo);
					itemKind.setKindcode("0901002");
					itemKind.setKindname("附加医疗费用保险");
					itemKind.setRiskcode(riskCode);
					itemKind.setSpreadsheetpremium(BigDecimal.valueOf(Double
							.parseDouble(additionalMedicalExpensesSpreadsheetPremium)));
					itemKind.setActualpremium(BigDecimal.valueOf(Double
							.parseDouble(additionalMedicalExpensesSumAmount)));
					itemKind.setAmount(BigDecimal.valueOf(Double
							.parseDouble(additionalMedicalExpensesSumAmount)));
					itemKind.setPolicyno(policyNo);
					try {
						Date start = sim.parse(startDate);
						Date end = sim.parse(endDate);
						itemKind.setStartdate(start);
						itemKind.setEnddate(end);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Map<String, Object> check = new HashMap<String, Object>();
					Map<String, Object> mapkindResult = interService
							.showitemKind(check);
					if (mapadjustResult != null && mapkindResult.size() > 0) {
						itemKind.setJudge(false);
					} else {
						itemKind.setJudge(true);
					}
					kindList.add(itemKind);
				}

				if (thirdPartyPropertyLossSpreadsheetPremium == ""
						|| thirdPartyPropertyLossActualPremium == "") {
					GuPolicyItemKind itemKind = new GuPolicyItemKind(); // 附加险
					itemKind.setBusinessno(businessNo);
					itemKind.setKindcode("0901004");
					itemKind.setRiskcode(riskCode);
					itemKind.setSpreadsheetpremium(BigDecimal.valueOf(Double
							.parseDouble(thirdPartyPropertyLossSpreadsheetPremium)));
					itemKind.setActualpremium(BigDecimal.valueOf(Double
							.parseDouble(thirdPartyPropertyLossActualPremium)));
					itemKind.setAmount(BigDecimal.valueOf(Double
							.parseDouble(thirdPartyPropertyLossSumAmount)));
					itemKind.setUnitamount(BigDecimal.valueOf(Double
							.parseDouble(thirdPartyPropertyLossAmount)));
					itemKind.setPolicyno(policyNo);
					try {
						Date start = sim.parse(startDate);
						Date end = sim.parse(endDate);
						itemKind.setStartdate(start);
						itemKind.setEnddate(end);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Map<String, Object> check = new HashMap<String, Object>();
					Map<String, Object> mapkindResult = interService
							.showitemKind(check);
					if (mapkindResult != null && mapkindResult.size() > 0) {
						itemKind.setJudge(false);
					} else {
						itemKind.setJudge(true);
					}
					kindList.add(itemKind);
				}
				if (safetyProductionSpreadsheetPremium == ""
						|| safetyProductionActualPremium == "") {
					GuPolicyItemKind itemKind = new GuPolicyItemKind();
					itemKind.setBusinessno(businessNo);
					itemKind.setKindcode("0901001");
					itemKind.setRiskcode(riskCode);
					itemKind.setSpreadsheetpremium(BigDecimal.valueOf(Double
							.parseDouble(safetyProductionSpreadsheetPremium)));
					itemKind.setActualpremium(BigDecimal.valueOf(Double
							.parseDouble(safetyProductionActualPremium)));
					itemKind.setAmount(BigDecimal.valueOf(Double
							.parseDouble(safetyProductionSumAmount)));
					itemKind.setUnitamount(BigDecimal.valueOf(Double
							.parseDouble(safetyProductionAmount)));
					try {
						Date start = sim.parse(startDate);
						Date end = sim.parse(endDate);
						itemKind.setStartdate(start);
						itemKind.setEnddate(end);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Map<String, Object> check = new HashMap<String, Object>();
					Map<String, Object> mapkindResult = interService
							.showitemKind(check);
					if (mapkindResult != null && mapkindResult.size() > 0) {
						itemKind.setJudge(false);
					} else {
						itemKind.setJudge(true);
					}
					kindList.add(itemKind);
				}
				guServiceInter.setPolicyItemKind(kindList);
				// 插入PolicyMain表中
				GuPolicyMain policyMain = new GuPolicyMain();
				policyMain.setBusinessNo(businessNo);
				policyMain.setAppliAddress(appliAddress);
				policyMain.setAppliCode(appliCode);
				policyMain.setAppliName(appliName);
				policyMain.setArbitBoardName(arbitBoardName);
				policyMain.setArgueSolution(argueSolution);
				policyMain.setAccidentPreventFee(BigDecimal.valueOf(Double
						.parseDouble(accidentPreventFee)));
				policyMain.setActualPremium(Double.parseDouble(actualPremium));
				policyMain.setCity(city);
				policyMain.setClassCode(classCode);
				policyMain.setCounty(county);
				policyMain.setDisCount(Double.valueOf(disCount));
				policyMain.setInsuredAddress(insuredAddress);
				policyMain.setInsuredCode(insuredcode);
				policyMain.setInsuredName(insuredName);
				policyMain.setInsurerCode(insurerCode);
				policyMain.setOperatorCode(operatorCode);
				policyMain.setPayBillNo(payBillNo);
				policyMain.setPayFlag(payFlag);
				policyMain.setPlanCode(planCode);
				policyMain.setPolicyNo(policyNo);
				policyMain.setPreviousPolicyNo(previousPolicyNo);
				policyMain.setProposalNo(proposalNo);
				policyMain.setProvince(province);
				policyMain.setSpreadsheetPremium(Double
						.parseDouble(spreadsheetPremium));
				policyMain.setSumAmount(Double.parseDouble(sumAmout));
				policyMain.setRenewalFlag(renewalFlag);
				try {
					Date end = sim.parse(endDate);
					Date star = sim.parse(startDate);
					Date operate = sim.parse(operateDate);
					policyMain.setEndDate(end);
					policyMain.setStartDate(star);
					policyMain.setOperateDate(operate);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String number = policyMain.getBusinessNo();
				Map<String, Object> policyMainResult = interService
						.showpolicyMain(number);
				boolean policyMainstatus;
				if (policyMainResult != null && policyMainResult.size() > 0) {
					policyMainstatus = false;
				} else {
					policyMainstatus = true;
				}
				guServiceInter.setPolicyMain(policyMain);
				guServiceInter.setPolicyMainstatus(policyMainstatus);
				// 插入GuPolicyInsured跟单表
				List<GuPolicyInsured> insuredList = new ArrayList<GuPolicyInsured>();
				GuPolicyInsured insured = new GuPolicyInsured();// 跟单表(投保人)
				GuPolicyInsured insure = new GuPolicyInsured();
				Long k1 = 1L;
				Long k2 = 2L;
				insured.setBusinessno(businessNo);
				insured.setPolicyno(policyNo);
				insured.setInsuredflag("1");
				insured.setRiskcode(riskCode);
				insured.setSeriesno(k1);
				insured.setInsuredcode(insuredcode);
				insured.setInsuredname(insuredName);
				insured.setIdentitytype(appliIdentifyType);
				insured.setIdentitynumber(appliIdentifyNumber);
				insured.setPhonenumber(appliMoble);
				insured.setEmail(appliEmail);
				insured.setLinkname(appliName);
				Map<String, Object> checkLink = new HashMap<String, Object>();
				String numberinsured = insured.getBusinessno();
				checkLink.put("businessNo", numberinsured);
				checkLink.put("seriesno", k1);
				Map<String, Object> insuredResult = interService
						.showpolicyinsured(checkLink);
				if (insuredResult != null && insuredResult.size() > 0) {
					insured.setJudge(false);
				} else {
					insured.setJudge(true);
				}
				insuredList.add(insured);
				insure.setBusinessno(businessNo);
				insure.setPolicyno(policyNo);
				insure.setInsuredflag("2");
				insure.setRiskcode(riskCode);
				insure.setSeriesno(k2);
				insure.setInsuredcode(insuredcode);
				insure.setInsuredname(insuredName);
				insure.setInsuredaddress(insuredAddress);
				insure.setIdentitytype(insuredIdentifyType);
				insure.setIdentitynumber(insuredIdentifyNumber);
				insure.setPhonenumber(insuredMoble);
				insure.setEmail(insuredEmail);
				insure.setLinkname(insuredName);
				insuredList.add(insure);
				checkLink.put("businessNo", businessNo);
				checkLink.put("seriesno", k2);
				insuredResult = interService.showpolicyinsured(checkLink);
				if (insuredResult != null && insuredResult.size() > 0) {
					insure.setJudge(false);
				} else {
					insure.setJudge(true);
				}
				guServiceInter.setInsuredList(insuredList);
				// 插入GuPolicyLimit险种限额表
				List<GuPolicyLimit> policyLimit = new ArrayList<GuPolicyLimit>();
				Map<String, Object> checkLimit = new HashMap<String, Object>();
				GuPolicyLimit guPolicyLimit = new GuPolicyLimit();// 限额代码限额描述
				guPolicyLimit.setBusinessno(businessNo);
				guPolicyLimit.setRiskcode(riskCode);
				guPolicyLimit.setLimitno(1L);
				guPolicyLimit.setLimitfee(new BigDecimal(
						employeeLiabilityLimits));
				guPolicyLimit.setLimitcode("001");// 用该字段存限额
				guPolicyLimit.setLimitdescription("从业人员责任限额");
				checkLimit.put("businessno", guPolicyLimit.getBusinessno());
				checkLimit.put("riskcode", guPolicyLimit.getRiskcode());
				checkLimit.put("limitNo", guPolicyLimit.getLimitno());
				List<Map<String, Object>> limitResult = new ArrayList<Map<String, Object>>();
				limitResult = interService.showpolicyLimit(checkLimit);
				if (limitResult != null && limitResult.size() > 0) {
					guPolicyLimit.setJudje(false);
				} else {
					guPolicyLimit.setJudje(true);
				}
				policyLimit.add(guPolicyLimit);

				GuPolicyLimit guPolicyLimit1 = new GuPolicyLimit();
				guPolicyLimit1.setBusinessno(businessNo);
				guPolicyLimit1.setPolicyno(policyNo);
				guPolicyLimit1.setRiskcode(riskCode);
				guPolicyLimit1.setLimitno(2L);
				guPolicyLimit1.setLimitfee(new BigDecimal(
						thirdPartyLiabilityLimits));
				guPolicyLimit1.setLimitcode("002");
				guPolicyLimit1.setLimitdescription("第三者责任限额");
				checkLimit.put("businessno", guPolicyLimit.getBusinessno());
				checkLimit.put("riskcode", guPolicyLimit.getRiskcode());
				checkLimit.put("limitNo", guPolicyLimit.getLimitno());
				limitResult = interService.showpolicyLimit(checkLimit);
				if (limitResult != null && limitResult.size() > 0) {
					guPolicyLimit1.setJudje(false);
				} else {
					guPolicyLimit1.setJudje(true);
				}
				policyLimit.add(guPolicyLimit1);
				GuPolicyLimit guPolicyLimit2 = new GuPolicyLimit();
				guPolicyLimit2.setBusinessno(businessNo);
				guPolicyLimit2.setPolicyno(policyNo);
				guPolicyLimit2.setRiskcode(riskCode);
				guPolicyLimit2.setLimitno(3L);
				guPolicyLimit2.setLimitfee(new BigDecimal(Double
						.valueOf(rescueExpenseLiabilityLimit)));
				guPolicyLimit2.setLimitcode("003");
				guPolicyLimit2.setLimitdescription("救援费用责任限额");
				checkLimit.put("businessno", guPolicyLimit.getBusinessno());
				checkLimit.put("riskcode", guPolicyLimit.getRiskcode());
				checkLimit.put("limitNo", guPolicyLimit.getLimitno());
				limitResult = interService.showpolicyLimit(checkLimit);
				if (limitResult != null && limitResult.size() > 0) {
					guPolicyLimit2.setJudje(false);
				} else {
					guPolicyLimit2.setJudje(true);
				}
				policyLimit.add(guPolicyLimit2);
				GuPolicyLimit guPolicyLimit3 = new GuPolicyLimit();
				guPolicyLimit3.setBusinessno(businessNo);
				guPolicyLimit3.setPolicyno(policyNo);
				guPolicyLimit3.setRiskcode(riskCode);
				guPolicyLimit3.setLimitno(4L);
				guPolicyLimit3.setLimitfee(new BigDecimal(Double
						.valueOf(legalLiabilityLimit)));
				guPolicyLimit3.setLimitcode("004");
				guPolicyLimit3.setLimitdescription("法律费用责任限额");
				checkLimit.put("businessno", guPolicyLimit.getBusinessno());
				checkLimit.put("riskcode", guPolicyLimit.getRiskcode());
				checkLimit.put("limitNo", guPolicyLimit.getLimitno());
				limitResult = interService.showpolicyLimit(checkLimit);
				if (limitResult != null && limitResult.size() > 0) {
					guPolicyLimit3.setJudje(false);
				} else {
					guPolicyLimit3.setJudje(true);
				}
				policyLimit.add(guPolicyLimit3);
				guServiceInter.setPolicyLimit(policyLimit);
				guServiceInterList.add(guServiceInter);
			}
			MessgeMail mail = interService.insertBigMain(guServiceInterList);
			if (mail.isItems()) {
				BizInfo.prowrit("upmaxmypolicytime", time);
			} else {
//				SendMail.send(mail.getMessge());
			}

		}

	}
}
