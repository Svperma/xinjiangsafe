package com.dsib.entity;

import java.io.Serializable;

public class GgUserRateKey  implements Serializable{
	private String usercode;

	private String ratetype;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public String getRatetype() {
		return ratetype;
	}

	public void setRatetype(String ratetype) {
		this.ratetype = ratetype == null ? null : ratetype.trim();
	}
}