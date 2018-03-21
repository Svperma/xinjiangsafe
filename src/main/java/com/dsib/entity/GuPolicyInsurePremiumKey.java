package com.dsib.entity;

import java.io.Serializable;

public class GuPolicyInsurePremiumKey  implements Serializable{
    private String businessNo;

    private String valNo;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getValNo() {
        return valNo;
    }

    public void setValNo(String valNo) {
        this.valNo = valNo == null ? null : valNo.trim();
    }
}