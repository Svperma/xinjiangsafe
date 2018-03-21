package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GuPolicyCoins extends GuPolicyCoinsKey  implements Serializable{
	private String policyno;

	private String coinscode;

	private String coinsname;

	private BigDecimal coinsrate;

	private String coinsflag;

	private String flag;

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno == null ? null : policyno.trim();
	}

	public String getCoinscode() {
		return coinscode;
	}

	public void setCoinscode(String coinscode) {
		this.coinscode = coinscode == null ? null : coinscode.trim();
	}

	public String getCoinsname() {
		return coinsname;
	}

	public void setCoinsname(String coinsname) {
		this.coinsname = coinsname == null ? null : coinsname.trim();
	}

	public BigDecimal getCoinsrate() {
		return coinsrate;
	}

	public void setCoinsrate(BigDecimal coinsrate) {
		this.coinsrate = coinsrate;
	}

	public String getCoinsflag() {
		return coinsflag;
	}

	public void setCoinsflag(String coinsflag) {
		this.coinsflag = coinsflag == null ? null : coinsflag.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}
}