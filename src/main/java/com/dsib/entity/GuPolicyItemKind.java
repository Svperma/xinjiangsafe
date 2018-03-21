package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GuPolicyItemKind extends GuPolicyItemKindKey  implements Serializable{
	private String policyno;

	private String riskcode;

	private Date startdate;

	private Date enddate;

	private String kindname;

	private BigDecimal spreadsheetpremium;

	private BigDecimal actualpremium;

	private BigDecimal amount;

	private BigDecimal rate;

	private BigDecimal discount;

	private BigDecimal unitamount;

	private BigDecimal unitpremium;

	private BigDecimal quantity;

	private String flag;

	private String remark;

	private boolean judge;
	
	public boolean isJudge() {
		return judge;
	}

	public void setJudge(boolean judge) {
		this.judge = judge;
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno == null ? null : policyno.trim();
	}

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode == null ? null : riskcode.trim();
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname == null ? null : kindname.trim();
	}

	public BigDecimal getSpreadsheetpremium() {
		return spreadsheetpremium;
	}

	public void setSpreadsheetpremium(BigDecimal spreadsheetpremium) {
		this.spreadsheetpremium = spreadsheetpremium;
	}

	public BigDecimal getActualpremium() {
		return actualpremium;
	}

	public void setActualpremium(BigDecimal actualpremium) {
		this.actualpremium = actualpremium;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getUnitamount() {
		return unitamount;
	}

	public void setUnitamount(BigDecimal unitamount) {
		this.unitamount = unitamount;
	}

	public BigDecimal getUnitpremium() {
		return unitpremium;
	}

	public void setUnitpremium(BigDecimal unitpremium) {
		this.unitpremium = unitpremium;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
	public GuPolicyItemKind() {
		super();
	}

	public GuPolicyItemKind(String riskcode,
			BigDecimal spreadsheetpremium, BigDecimal actualpremium,
			BigDecimal amount, BigDecimal unitamount) {
		super();
		this.riskcode = riskcode;
		this.spreadsheetpremium = spreadsheetpremium;
		this.actualpremium = actualpremium;
		this.amount = amount;
		this.unitamount = unitamount;
	}
	
}