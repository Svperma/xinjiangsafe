package com.dsib.entity;

import java.io.Serializable;

public class GcClaimProve implements Serializable{

	private String baoanNo;
	private String accidentPort;
	private String deathPort;
	private String disabLity;

	public String getBaoanNo() {
		return baoanNo;
	}

	public void setBaoanNo(String baoanNo) {
		this.baoanNo = baoanNo;
	}

	public String getAccidentPort() {
		return accidentPort;
	}

	public void setAccidentPort(String accidentPort) {
		this.accidentPort = accidentPort;
	}

	public String getDeathPort() {
		return deathPort;
	}

	public void setDeathPort(String deathPort) {
		this.deathPort = deathPort;
	}

	public String getDisabLity() {
		return disabLity;
	}

	public void setDisabLity(String disabLity) {
		this.disabLity = disabLity;
	}

}
