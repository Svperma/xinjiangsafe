package com.dsib.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GuPolicyInsurePremium extends GuPolicyInsurePremiumKey  implements Serializable{
    private BigDecimal sumPremium;

    private BigDecimal premium;

    private BigDecimal itemkindOne;

    private BigDecimal itemkindTwo;

    private BigDecimal itemkindThree;

    private BigDecimal itemkindFour;

    private String insureCode;

    private String flag;

    private String remark;

    public BigDecimal getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(BigDecimal sumPremium) {
        this.sumPremium = sumPremium;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getItemkindOne() {
        return itemkindOne;
    }

    public void setItemkindOne(BigDecimal itemkindOne) {
        this.itemkindOne = itemkindOne;
    }

    public BigDecimal getItemkindTwo() {
        return itemkindTwo;
    }

    public void setItemkindTwo(BigDecimal itemkindTwo) {
        this.itemkindTwo = itemkindTwo;
    }

    public BigDecimal getItemkindThree() {
        return itemkindThree;
    }

    public void setItemkindThree(BigDecimal itemkindThree) {
        this.itemkindThree = itemkindThree;
    }

    public BigDecimal getItemkindFour() {
        return itemkindFour;
    }

    public void setItemkindFour(BigDecimal itemkindFour) {
        this.itemkindFour = itemkindFour;
    }

    public String getInsureCode() {
        return insureCode;
    }

    public void setInsureCode(String insureCode) {
        this.insureCode = insureCode == null ? null : insureCode.trim();
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