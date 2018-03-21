package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GgKindRate extends GgKindRateKey  implements Serializable {
	private String kindcode;

	private String areacode;

	private BigDecimal rate;

	private String validstatus;

	private String flag;

	private String remark;

	public String getKindcode() {
		return kindcode;
	}

	public void setKindcode(String kindcode) {
		this.kindcode = kindcode == null ? null : kindcode.trim();
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode == null ? null : areacode.trim();
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus == null ? null : validstatus.trim();
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
}
