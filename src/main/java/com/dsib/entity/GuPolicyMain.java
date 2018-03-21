package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GuPolicyMain implements Serializable {

	private String businessNo;
	private String proposalNo;
	private String policyNo;
	private String previousPolicyNo;
	private String payBillNo;
	private String classCode;
	private String riskCode;
	private String planCode;
	private String appliCode;
	private String appliName;
	private String appliAddress;
	private String insuredCode;
	private String insuredName;
	private String insuredAddress;
	private Date startDate;
	private Date endDate;
	private String currency;
	private Double sumAmount;
	private Double disCount;
	private Double sumDiscount;
	private Double spreadsheetPremium;
	private Double actualPremium;
	private Double sumPremium;
	private Double sumSubPrem;
	private String argueSolution;
	private String arbitBoardName;
	private Integer endorseTimes;
	private Integer insureTimes;
	private String operatorCode;
	private Date operateDate;
	private Date signDate;
	private String updatorCode;
	private Date updateDate;
	private String underWriteCode;
	private String underWriteName;
	private Date underWriteEndDate;
	private String underDirections;
	private String underWriteFlag;
	private String payFlag;
	private String renewalFlag;
	private String insurerCode;
	private String province;
	private String city;
	private String county;
	private Integer correctPremium;
	private String correctNo;
	private Date correctDate;
	private BigDecimal accidentPreventFee;
	private String specialprovisions;
	private String flag;
	private String remark;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSpecialprovisions() {
		return specialprovisions;
	}

	public void setSpecialprovisions(String specialprovisions) {
		this.specialprovisions = specialprovisions;
	}

	private List<GuPolicyItemKind> list_GuPolicyItemKind;
	private GgUserCorp ggusercorp;

	public List<GuPolicyItemKind> getList_GuPolicyItemKind() {
		return list_GuPolicyItemKind;
	}

	public void setList_GuPolicyItemKind(
			List<GuPolicyItemKind> list_GuPolicyItemKind) {
		this.list_GuPolicyItemKind = list_GuPolicyItemKind;
	}

	public GgUserCorp getGgusercorp() {
		return ggusercorp;
	}

	public void setGgusercorp(GgUserCorp ggusercorp) {
		this.ggusercorp = ggusercorp;
	}

	public BigDecimal getAccidentPreventFee() {
		return accidentPreventFee;
	}

	public void setAccidentPreventFee(BigDecimal accidentPreventFee) {
		this.accidentPreventFee = accidentPreventFee;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPreviousPolicyNo() {
		return previousPolicyNo;
	}

	public void setPreviousPolicyNo(String previousPolicyNo) {
		this.previousPolicyNo = previousPolicyNo;
	}

	public String getPayBillNo() {
		return payBillNo;
	}

	public void setPayBillNo(String payBillNo) {
		this.payBillNo = payBillNo;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getAppliCode() {
		return appliCode;
	}

	public void setAppliCode(String appliCode) {
		this.appliCode = appliCode;
	}

	public String getAppliName() {
		return appliName;
	}

	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}

	public String getAppliAddress() {
		return appliAddress;
	}

	public void setAppliAddress(String appliAddress) {
		this.appliAddress = appliAddress;
	}

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getInsuredAddress() {
		return insuredAddress;
	}

	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(Double sumAmount) {
		this.sumAmount = sumAmount;
	}

	public Double getDisCount() {
		return disCount;
	}

	public void setDisCount(Double disCount) {
		this.disCount = disCount;
	}

	public Double getSumDiscount() {
		return sumDiscount;
	}

	public void setSumDiscount(Double sumDiscount) {
		this.sumDiscount = sumDiscount;
	}

	public Double getSpreadsheetPremium() {
		return spreadsheetPremium;
	}

	public void setSpreadsheetPremium(Double spreadsheetPremium) {
		this.spreadsheetPremium = spreadsheetPremium;
	}

	public Double getActualPremium() {
		return actualPremium;
	}

	public void setActualPremium(Double actualPremium) {
		this.actualPremium = actualPremium;
	}

	public Double getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(Double sumPremium) {
		this.sumPremium = sumPremium;
	}

	public Double getSumSubPrem() {
		return sumSubPrem;
	}

	public void setSumSubPrem(Double sumSubPrem) {
		this.sumSubPrem = sumSubPrem;
	}

	public String getArgueSolution() {
		return argueSolution;
	}

	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}

	public String getArbitBoardName() {
		return arbitBoardName;
	}

	public void setArbitBoardName(String arbitBoardName) {
		this.arbitBoardName = arbitBoardName;
	}

	public Integer getEndorseTimes() {
		return endorseTimes;
	}

	public void setEndorseTimes(Integer endorseTimes) {
		this.endorseTimes = endorseTimes;
	}

	public Integer getInsureTimes() {
		return insureTimes;
	}

	public void setInsureTimes(Integer insureTimes) {
		this.insureTimes = insureTimes;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getUpdatorCode() {
		return updatorCode;
	}

	public void setUpdatorCode(String updatorCode) {
		this.updatorCode = updatorCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUnderWriteCode() {
		return underWriteCode;
	}

	public void setUnderWriteCode(String underWriteCode) {
		this.underWriteCode = underWriteCode;
	}

	public String getUnderWriteName() {
		return underWriteName;
	}

	public void setUnderWriteName(String underWriteName) {
		this.underWriteName = underWriteName;
	}

	public Date getUnderWriteEndDate() {
		return underWriteEndDate;
	}

	public void setUnderWriteEndDate(Date underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}

	public String getUnderDirections() {
		return underDirections;
	}

	public void setUnderDirections(String underDirections) {
		this.underDirections = underDirections;
	}

	public String getUnderWriteFlag() {
		return underWriteFlag;
	}

	public void setUnderWriteFlag(String underWriteFlag) {
		this.underWriteFlag = underWriteFlag;
	}

	public String getPayFlag() {
		return payFlag;
	}

	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}

	public String getRenewalFlag() {
		return renewalFlag;
	}

	public void setRenewalFlag(String renewalFlag) {
		this.renewalFlag = renewalFlag;
	}

	public String getInsurerCode() {
		return insurerCode;
	}

	public void setInsurerCode(String insurerCode) {
		this.insurerCode = insurerCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Integer getCorrectPremium() {
		return correctPremium;
	}

	public void setCorrectPremium(Integer correctPremium) {
		this.correctPremium = correctPremium;
	}

	public String getCorrectNo() {
		return correctNo;
	}

	public void setCorrectNo(String correctNo) {
		this.correctNo = correctNo;
	}

	public Date getCorrectDate() {
		return correctDate;
	}

	public void setCorrectDate(Date correctDate) {
		this.correctDate = correctDate;
	}
	
	public GuPolicyMain() {
		super();
	}

	public GuPolicyMain(String businessNo, String policyNo, String riskCode,
			String planCode, String appliName, String appliAddress,
			String insuredName, String insuredAddress, Date startDate,
			Date endDate, String currency, Double sumAmount, Double disCount,
			Double spreadsheetPremium, Date signDate, String underWriteFlag,
			String payFlag, String insurerCode, String province, String city,
			String county, String flag) {
		super();
		this.businessNo = businessNo;
		this.policyNo = policyNo;
		this.riskCode = riskCode;
		this.planCode = planCode;
		this.appliName = appliName;
		this.appliAddress = appliAddress;
		this.insuredName = insuredName;
		this.insuredAddress = insuredAddress;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currency = currency;
		this.sumAmount = sumAmount;
		this.disCount = disCount;
		this.spreadsheetPremium = spreadsheetPremium;
		this.signDate = signDate;
		this.underWriteFlag = underWriteFlag;
		this.payFlag = payFlag;
		this.insurerCode = insurerCode;
		this.province = province;
		this.city = city;
		this.county = county;
		this.flag = flag;
	}
	
}
