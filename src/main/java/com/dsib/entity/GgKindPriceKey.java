package com.dsib.entity;

import java.io.Serializable;

public class GgKindPriceKey implements Serializable  {
	private String areacode;

	private String insurecode;

	private String riskcode;

	private String industrycode;

	private String scalecode;

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode == null ? null : areacode.trim();
	}

	public String getInsurecode() {
		return insurecode;
	}

	public void setInsurecode(String insurecode) {
		this.insurecode = insurecode == null ? null : insurecode.trim();
	}

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode == null ? null : riskcode.trim();
	}

	public String getIndustrycode() {
		return industrycode;
	}

	public void setIndustrycode(String industrycode) {
		this.industrycode = industrycode == null ? null : industrycode.trim();
	}

	public String getScalecode() {
		return scalecode;
	}

	public void setScalecode(String scalecode) {
		this.scalecode = scalecode == null ? null : scalecode.trim();
	}
}
