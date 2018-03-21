package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GuPolicyFee  implements Serializable{
	private String businessno;

	private String riskcode;

	private String policyno;

	private String currency;

	private BigDecimal amount;

	private BigDecimal spreadsheetpremium;

	private BigDecimal actualpremium;

	private String flag;

	private String column9;

	private String column10;

	public String getBusinessno() {
		return businessno;
	}

	public void setBusinessno(String businessno) {
		this.businessno = businessno == null ? null : businessno.trim();
	}

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode == null ? null : riskcode.trim();
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno == null ? null : policyno.trim();
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency == null ? null : currency.trim();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public String getColumn9() {
		return column9;
	}

	public void setColumn9(String column9) {
		this.column9 = column9 == null ? null : column9.trim();
	}

	public String getColumn10() {
		return column10;
	}

	public void setColumn10(String column10) {
		this.column10 = column10 == null ? null : column10.trim();
	}
}