package com.dsib.entity;

import java.io.Serializable;

public class GgKind extends GgKindKey  implements Serializable {
	private String riskcode;

	private String kindcname;

	private String kindename;

	private String areacode;

	private String description;

	private String insurancecode;

	private String validstatus;

	private String remark;

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode == null ? null : riskcode.trim();
	}

	public String getKindcname() {
		return kindcname;
	}

	public void setKindcname(String kindcname) {
		this.kindcname = kindcname == null ? null : kindcname.trim();
	}

	public String getKindename() {
		return kindename;
	}

	public void setKindename(String kindename) {
		this.kindename = kindename == null ? null : kindename.trim();
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode == null ? null : areacode.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getInsurancecode() {
		return insurancecode;
	}

	public void setInsurancecode(String insurancecode) {
		this.insurancecode = insurancecode == null ? null : insurancecode
				.trim();
	}

	public String getValidstatus() {
		return validstatus;
	}

	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus == null ? null : validstatus.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}
