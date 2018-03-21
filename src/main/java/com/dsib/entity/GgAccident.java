package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 事故 对象
 * 
 * @author xinjg
 * 
 */
public class GgAccident implements Serializable {

	private String id;
	private String userCode;
	private String province;
	// 地点
	private String city;
	private String county;
	// 处理人
	private String dealer;
	// 事故发生时间
	private Date happenDate;
	// 事故原因
	private String cause;
	// 损失情况
	private String loss;
	// 援助金
	private BigDecimal assistance;
	// 保险公司
	private String insurerCode;
	private String status;
	private String remark;
	private String flag;
	private String advice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public Date getHappenDate() {
		return happenDate;
	}

	public void setHappenDate(Date happenDate) {
		this.happenDate = happenDate;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getLoss() {
		return loss;
	}

	public void setLoss(String loss) {
		this.loss = loss;
	}

	public BigDecimal getAssistance() {
		return assistance;
	}

	public void setAssistance(BigDecimal assistance) {
		this.assistance = assistance;
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

	public String getInsurerCode() {
		return insurerCode;
	}

	public void setInsurerCode(String insurerCode) {
		this.insurerCode = insurerCode;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

}
