package com.dsib.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评估
 * 
 * @author 珍珠亚实
 * 
 */
public class GgEvaluateDangers implements Serializable  {

	private String id;/* 序号 */
	private String userCode;/* 企业代码 */
	private String content;/* 评估内容 */
	private String evaluator;/* 评估人 */
	private Date evaluatDate;/* 评估时间 */
	private Date completeDate;/* 整改完成时间 */
	private String userInd;/* 评估人类型：1政府，2企业，3保险公司，4第三方 */
	private String status;/* 整改状态：0未整改，1整改完成 */
	private String docAddress;/* 评估资料地址 */
	private String evaluaTion;/* 评估状态：0往期评估1最新评估 */
	private String source;/* 危险源 */
	private String checkMan;/* 检查人 */
	private Date checkDate;/* 检查时间 */
	private String dangersCondition;/* 危险源状态：0往期评估1最新评估 */
	private String statusContent;// 整改内容
	private String remark;
	private String flag;
	private Date endEvaluatDate;// 评估截止日期

	private GgUserCorp ggUserCorp;
	private List<GgEvaluateDangers> list;

	public GgUserCorp getGgUserCorp() {
		return ggUserCorp;
	}

	public void setGgUserCorp(GgUserCorp ggUserCorp) {
		this.ggUserCorp = ggUserCorp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}

	public Date getEvaluatDate() {
		return evaluatDate;
	}

	public void setEvaluatDate(Date evaluatDate) {
		this.evaluatDate = evaluatDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public String getUserInd() {
		return userInd;
	}

	public void setUserInd(String userInd) {
		this.userInd = userInd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDocAddress() {
		return docAddress;
	}

	public void setDocAddress(String docAddress) {
		this.docAddress = docAddress;
	}

	public String getEvaluaTion() {
		return evaluaTion;
	}

	public void setEvaluaTion(String evaluaTion) {
		this.evaluaTion = evaluaTion;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getDangersCondition() {
		return dangersCondition;
	}

	public void setDangersCondition(String dangersCondition) {
		this.dangersCondition = dangersCondition;
	}

	public String getStatusContent() {
		return statusContent;
	}

	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getEndEvaluatDate() {
		return endEvaluatDate;
	}

	public void setEndEvaluatDate(Date endEvaluatDate) {
		this.endEvaluatDate = endEvaluatDate;
	}

	public List<GgEvaluateDangers> getList() {
		return list;
	}

	public void setList(List<GgEvaluateDangers> list) {
		this.list = list;
	}

}
