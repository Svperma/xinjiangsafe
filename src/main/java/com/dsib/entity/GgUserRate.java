package com.dsib.entity;

import java.io.Serializable;

public class GgUserRate extends GgUserRateKey  implements Serializable{
	private String rate;

	private String flag;

	private String remark;

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate == null ? null : rate.trim();
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