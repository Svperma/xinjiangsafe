package com.dsib.entity;

import java.io.Serializable;

public class GgEmployee implements Serializable  {

	private String emId;// 员工代码
	private String emName;// 员工名称
	private String identityNo;// 身份证号
	private String sex;// 性别
	private Integer age;// 年龄
	private String address;// 地址
	private String userCode;// 公司代码
	private String departmentCode;// 部门
	private String telePhone;// 电话
	private String validStatus;// 状态

	public GgEmployee(String emName, String identityNo/*, String sex, String age,
			String telePhone, String departmentCode, String address*/) {
		super();
//		if (!"".equals(emName)) {
			this.emName = emName;
//		}if (!"".equals(identityNo)) {
			this.identityNo = identityNo;
//		}if (!"".equals(sex)) {
//			this.sex = sex;
//		}if (!"".equals(age)) {
//			this.age = Integer.valueOf(age);
//		}if (!"".equals(address)) {
//			this.address = address;
//		}if (!"".equals(departmentCode)) {
//			this.departmentCode = departmentCode;
//		}if (!"".equals(telePhone)) {
//			this.telePhone = telePhone;
//		}
		
		
		
		
		
	}

	public GgEmployee() {
		super();
	}

	public String getEmId() {
		return emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

}
