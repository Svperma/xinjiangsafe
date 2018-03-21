package com.dsib.entity;

import java.io.Serializable;
import java.util.Date;

public class GuPolicyEndorse  implements Serializable{

	private String buseiness;
	private Date updatedate;
	private String specialprovisions;
	private String insuredcode;
	private Date endorsedate;
	private String payflag;
	private String remark;
	private String operator;
	private double calculation;
	private String flag;
	private String endorsement;
	
	public String getEndorsement() {
		return endorsement;
	}
	public void setEndorsement(String endorsement) {
		this.endorsement = endorsement;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public double getCalculation() {
		return calculation;
	}
	public void setCalculation(double calculation) {
		this.calculation = calculation;
	}
	public String getBuseiness() {
		return buseiness;
	}
	public void setBuseiness(String buseiness) {
		this.buseiness = buseiness;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getSpecialprovisions() {
		return specialprovisions;
	}
	public void setSpecialprovisions(String specialprovisions) {
		this.specialprovisions = specialprovisions;
	}
	public String getInsuredcode() {
		return insuredcode;
	}
	public void setInsuredcode(String insuredcode) {
		this.insuredcode = insuredcode;
	}
	public Date getEndorsedate() {
		return endorsedate;
	}
	public void setEndorsedate(Date endorsedate) {
		this.endorsedate = endorsedate;
	}
	public String getPayflag() {
		return payflag;
	}
	public void setPayflag(String payflag) {
		this.payflag = payflag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
	
}
