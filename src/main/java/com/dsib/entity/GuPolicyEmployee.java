package com.dsib.entity;

import java.io.Serializable;

public class GuPolicyEmployee extends GuPolicyEmployeeKey  implements Serializable{
    private String pepName;

    private String pepIdentityNo;

    private String age;

    private String address;

    private String moble;

    private String businessNo;
    
    public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getPepName() {
        return pepName;
    }

    public void setPepName(String pepName) {
        this.pepName = pepName == null ? null : pepName.trim();
    }

    public String getPepIdentityNo() {
        return pepIdentityNo;
    }

    public void setPepIdentityNo(String pepIdentityNo) {
        this.pepIdentityNo = pepIdentityNo == null ? null : pepIdentityNo.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble == null ? null : moble.trim();
    }
}