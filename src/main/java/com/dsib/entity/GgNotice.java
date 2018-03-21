package com.dsib.entity;

import java.io.Serializable;
import java.util.Date;

public class GgNotice implements Serializable  {

	private String seriesNo;/* 序号 */
	private String title;/* 标题 */
	private String contentSource;/* 内容 */
	private String publisher;/* 发布人 */
	private Date publishTime;/* 发布时间 */
	private String recipient;/* 接受者 */
	private Date validDate;/* 有效期至 */
	private String status;/* 状态（1，有效，0无效） */
	private String markRead;/* 状态：（1已读，0未读） */
	private String flag;
	private String remark;

	public String getSeriesNo() {
		return seriesNo;
	}

	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentSource() {
		return contentSource;
	}

	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMarkRead() {
		return markRead;
	}

	public void setMarkRead(String markRead) {
		this.markRead = markRead;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
