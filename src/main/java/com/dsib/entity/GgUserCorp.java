package com.dsib.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 企业
 */
public class GgUserCorp  implements Serializable{
	private Date businessLicenseDate;/* 经营许可证有效期至 */
	private String userCode;/* 用户代码 */
	private String companyName;/* 企业名称 */
	private String companyAddress;/* 企业地址 */
	private Date safetyLiceseDate;/*	*/
	private String linkName;/* 联系人名称 */
	private String classCode;/* 行业大类 */
	private String businessClass;/* 经营范围 */
	private String province;/* 省份 */
	private String city;/* 城市 */
	private String county;/* 区县 */
	private String corpration;/* 法人 */
	private Integer emCount;/* 员工总数 */
	private String telephone;/* 电话 */
	private String mobile;/* 手机 */
	private String email;/* 邮箱 */
	private String fax;/* 传真 */
	private String post;/* 邮编 */
	private String businessLicenseNo;/* 营业执照号 */
	private String businessLicenseImage;/* 营业执照图片 */
	private String safetyLicenseNo;/* 安全生产许可证号 */
	private String safetyLicenseImage;/* 安全生产许可证图片 */
	private Integer turnover;/* 上年度营业额 */
	private String tax;/* 税务报表 */
	private String remark;/*	*/
	private String standardLevelImage;/* 标准化等级图片 */
	private String riskLevel;/* 危险等级 */
	private String flag;/*	*/
	private String faithLevel;/* 诚信等级 */
	private String standardLevel;/* 标准化等级 */

	private String sumstandardLevel;/* 综合等级 */
	private String classSize;/* 企业规模 */
	private String validStatus;/* 有效：0无效，1有效，2未审核 */

	private List<GgEvaluateDangers> list_ggEvaluateDangers; // 多项评估（用于封装：一对多）
	private List<GuPolicyMain> list_GgMain; // 多项保单信息（用于封装：一对多）
	private GovOrgan govOrgan;// 一个机构部门信息（用于封装：多对一）

	public GovOrgan getGovOrgan() {
		return govOrgan;
	}

	public void setGovOrgan(GovOrgan govOrgan) {
		this.govOrgan = govOrgan;
	}

	public Date getBusinessLicenseDate() {
		return businessLicenseDate;
	}

	public void setBusinessLicenseDate(Date businessLicenseDate) {
		this.businessLicenseDate = businessLicenseDate;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Date getSafetyLiceseDate() {
		return safetyLiceseDate;
	}

	public void setSafetyLiceseDate(Date safetyLiceseDate) {
		this.safetyLiceseDate = safetyLiceseDate;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(String businessClass) {
		this.businessClass = businessClass;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCorpration() {
		return corpration;
	}

	public void setCorpration(String corpration) {
		this.corpration = corpration;
	}

	public Integer getEmCount() {
		return emCount;
	}

	public void setEmCount(Integer emCount) {
		this.emCount = emCount;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}

	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}

	public String getBusinessLicenseImage() {
		return businessLicenseImage;
	}

	public void setBusinessLicenseImage(String businessLicenseImage) {
		this.businessLicenseImage = businessLicenseImage;
	}

	public String getSafetyLicenseNo() {
		return safetyLicenseNo;
	}

	public void setSafetyLicenseNo(String safetyLicenseNo) {
		this.safetyLicenseNo = safetyLicenseNo;
	}

	public String getSafetyLicenseImage() {
		return safetyLicenseImage;
	}

	public void setSafetyLicenseImage(String safetyLicenseImage) {
		this.safetyLicenseImage = safetyLicenseImage;
	}

	public Integer getTurnover() {
		return turnover;
	}

	public void setTurnover(Integer turnover) {
		this.turnover = turnover;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStandardLevelImage() {
		return standardLevelImage;
	}

	public void setStandardLevelImage(String standardLevelImage) {
		this.standardLevelImage = standardLevelImage;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFaithLevel() {
		return faithLevel;
	}

	public void setFaithLevel(String faithLevel) {
		this.faithLevel = faithLevel;
	}

	public String getStandardLevel() {
		return standardLevel;
	}

	public void setStandardLevel(String standardLevel) {
		this.standardLevel = standardLevel;
	}

	public String getSumstandardLevel() {
		return sumstandardLevel;
	}

	public void setSumstandardLevel(String sumstandardLevel) {
		this.sumstandardLevel = sumstandardLevel;
	}

	public String getClassSize() {
		return classSize;
	}

	public void setClassSize(String classSize) {
		this.classSize = classSize;
	}

	public List<GgEvaluateDangers> getList_ggEvaluateDangers() {
		return list_ggEvaluateDangers;
	}

	public void setList_EvaluateReport(
			List<GgEvaluateDangers> list_ggEvaluateDangers) {
		this.list_ggEvaluateDangers = list_ggEvaluateDangers;
	}

	public List<GuPolicyMain> getList_GgMain() {
		return list_GgMain;
	}

	public void setList_GgMain(List<GuPolicyMain> list_GgMain) {
		this.list_GgMain = list_GgMain;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public void setList_ggEvaluateDangers(
			List<GgEvaluateDangers> list_ggEvaluateDangers) {
		this.list_ggEvaluateDangers = list_ggEvaluateDangers;
	}
	
	public boolean isSameComPany(GgUserCorp userCorp) {
		String companyName = this.companyName;
		String businessLicenseNo = this.businessLicenseNo;
		if(null == companyName) {
			companyName = "";
		}
		if(null == businessLicenseNo) {
			businessLicenseNo = "";
		}
		
		if(companyName.equals(userCorp.getCompanyName())
				&& businessLicenseNo.equals(userCorp.getBusinessLicenseNo())) {
			return true;
		}
		return false;
	}
	
}
