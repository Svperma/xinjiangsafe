package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GgKindKey implements Serializable  {
	private BigDecimal id;

	private String kindcode;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getKindcode() {
		return kindcode;
	}

	public void setKindcode(String kindcode) {
		this.kindcode = kindcode == null ? null : kindcode.trim();
	}
}
