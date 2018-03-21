package com.dsib.entity;

import java.io.Serializable;

public class GuPolicyInsured extends GuPolicyInsuredKey  implements Serializable{
	private String policyno;

	private String riskcode;

	private String insuredtype;

	private String insuredcode;

	private String insuredname;

	private String insuredaddress;

	private String insuredflag;

	private String identitytype;

	private String identitynumber;

	private String linkname;

	private String phonenumber;

	private String email;

	private String flag;

	private String remark;

	private boolean judge;

	public boolean isJudge() {
		return judge;
	}

	public void setJudge(boolean judge) {
		this.judge = judge;
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno == null ? null : policyno.trim();
	}

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode == null ? null : riskcode.trim();
	}

	public String getInsuredtype() {
		return insuredtype;
	}

	public void setInsuredtype(String insuredtype) {
		this.insuredtype = insuredtype == null ? null : insuredtype.trim();
	}

	public String getInsuredcode() {
		return insuredcode;
	}

	public void setInsuredcode(String insuredcode) {
		this.insuredcode = insuredcode == null ? null : insuredcode.trim();
	}

	public String getInsuredname() {
		return insuredname;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname == null ? null : insuredname.trim();
	}

	public String getInsuredaddress() {
		return insuredaddress;
	}

	public void setInsuredaddress(String insuredaddress) {
		this.insuredaddress = insuredaddress == null ? null : insuredaddress
				.trim();
	}

	public String getInsuredflag() {
		return insuredflag;
	}

	public void setInsuredflag(String insuredflag) {
		this.insuredflag = insuredflag == null ? null : insuredflag.trim();
	}

	public String getIdentitytype() {
		return identitytype;
	}

	public void setIdentitytype(String identitytype) {
		this.identitytype = identitytype == null ? null : identitytype.trim();
	}

	public String getIdentitynumber() {
		return identitynumber;
	}

	public void setIdentitynumber(String identitynumber) {
		this.identitynumber = identitynumber == null ? null : identitynumber
				.trim();
	}

	public String getLinkname() {
		return linkname;
	}

	public void setLinkname(String linkname) {
		this.linkname = linkname == null ? null : linkname.trim();
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber == null ? null : phonenumber.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
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

	public GuPolicyInsured() {
		super();
	}

	public GuPolicyInsured(String policyno, String riskcode,
			String insuredtype, String insuredname, String insuredaddress,
			String identitynumber, String linkname, String phonenumber,
			String email, String flag, String remark) {
		super();
		this.policyno = policyno;
		this.riskcode = riskcode;
		this.insuredtype = insuredtype;
		this.insuredname = insuredname;
		this.insuredaddress = insuredaddress;
		this.identitynumber = identitynumber;
		this.linkname = linkname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.flag = flag;
		this.remark = remark;
	}
	
	
}