package com.dsib.entity;

import java.io.Serializable;
import java.util.Date;

public class GcClaim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String baoAnNo;
	private String peiAnNo;
	private String policyNo;
	private double lossAmount;
	private String lossCause;
	private Date lossDate;
	private String riskCode;
	private String businessNo;
	private String lossLocaiton;
	private String createrCode;
	private Date createDate;
	private String upDatorCode;
	private Date upDateDate;
	private String status;
	private String remark;
	private String flag;
	private String province;
	private String city;
	private String county;
	private double payAmount;
	private String insurerCode;
	private Date closeDate;
	private String userCode;
	private Date baoanDate;
	private String lossDetail;
	private String linkName;
	private String linkPhone;

	public String getBaoAnNo() {
		return baoAnNo;
	}

	public void setBaoAnNo(String baoAnNo) {
		this.baoAnNo = baoAnNo;
	}

	public String getPeiAnNo() {
		return peiAnNo;
	}

	public void setPeiAnNo(String peiAnNo) {
		this.peiAnNo = peiAnNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public double getLossAmount() {
		return lossAmount;
	}

	public void setLossAmount(double lossAmount) {
		this.lossAmount = lossAmount;
	}

	public String getLossCause() {
		return lossCause;
	}

	public void setLossCause(String lossCause) {
		this.lossCause = lossCause;
	}

	public Date getLossDate() {
		return lossDate;
	}

	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getLossLocaiton() {
		return lossLocaiton;
	}

	public void setLossLocaiton(String lossLocaiton) {
		this.lossLocaiton = lossLocaiton;
	}

	public String getCreaterCode() {
		return createrCode;
	}

	public void setCreaterCode(String createrCode) {
		this.createrCode = createrCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpDatorCode() {
		return upDatorCode;
	}

	public void setUpDatorCode(String upDatorCode) {
		this.upDatorCode = upDatorCode;
	}

	public Date getUpDateDate() {
		return upDateDate;
	}

	public void setUpDateDate(Date upDateDate) {
		this.upDateDate = upDateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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


	public String getInsurerCode() {
		return insurerCode;
	}

	public void setInsurerCode(String insurerCode) {
		this.insurerCode = insurerCode;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}



	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public Date getBaoanDate() {
		return baoanDate;
	}

	public void setBaoanDate(Date baoanDate) {
		this.baoanDate = baoanDate;
	}

	public String getLossDetail() {
		return lossDetail;
	}

	public void setLossDetail(String lossDetail) {
		this.lossDetail = lossDetail;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

}
