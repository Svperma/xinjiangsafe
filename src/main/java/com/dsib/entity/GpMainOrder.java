package com.dsib.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单主表
 * 
 * @author xinjg
 * 
 */
public class GpMainOrder  implements Serializable{

	private String businessNo;
	private String merchantNo;
	private String merchantOrderNo;
	private Date updateTime;

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantOrderNo() {
		return merchantOrderNo;
	}

	public void setMerchantOrderNo(String merchantOrderNo) {
		this.merchantOrderNo = merchantOrderNo;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
