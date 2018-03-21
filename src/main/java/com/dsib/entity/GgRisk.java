package com.dsib.entity;

import java.io.Serializable;

public class GgRisk extends GgRiskKey  implements Serializable {
	private String flag;

	private String remark;

	private String riskname;

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

	public String getRiskname() {
		return riskname;
	}

	public void setRiskname(String riskname) {
		this.riskname = riskname == null ? null : riskname.trim();
	}
}
