package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GgKindPrice extends GgKindPriceKey  implements Serializable {
	private BigDecimal price;

	private String flag;

	private String remark;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
