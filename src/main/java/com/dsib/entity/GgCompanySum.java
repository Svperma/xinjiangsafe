package com.dsib.entity;

import java.io.Serializable;

public class GgCompanySum implements Serializable  {
    private String areaCode;

    private String companySum;

    private String levels;
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getCompanySum() {
        return companySum;
    }

    public void setCompanySum(String companySum) {
        this.companySum = companySum == null ? null : companySum.trim();
    }

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels == null ? null : levels.trim();
	}
    
}
