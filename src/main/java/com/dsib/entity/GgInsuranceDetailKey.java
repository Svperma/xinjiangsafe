package com.dsib.entity;

import java.io.Serializable;

public class GgInsuranceDetailKey implements Serializable  {
	private String riskcode;

	private String insurancecode;

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode == null ? null : riskcode.trim();
	}

	public String getInsurancecode() {
		return insurancecode;
	}

	public void setInsurancecode(String insurancecode) {
		this.insurancecode = insurancecode == null ? null : insurancecode
				.trim();
	}
}
