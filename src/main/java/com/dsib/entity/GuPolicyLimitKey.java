package com.dsib.entity;

import java.io.Serializable;

public class GuPolicyLimitKey  implements Serializable{
	private String businessno;

	private String riskcode;

	private Long limitno;

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

	public Long getLimitno() {
		return limitno;
	}

	public void setLimitno(Long limitno) {
		this.limitno = limitno;
	}
}