package com.dsib.entity;

import java.io.Serializable;

public class GgRiskKey implements Serializable  {
	private String areacode;

	private String riskcode;

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode == null ? null : areacode.trim();
	}

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode == null ? null : riskcode.trim();
	}
}
