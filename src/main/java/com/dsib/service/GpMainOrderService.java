package com.dsib.service;

import java.util.List;

import com.dsib.entity.GpMainOrder;
import com.dsib.entity.GuPolicyEndorse;

public interface GpMainOrderService {

	public void insertMainOrder(GpMainOrder gpMainOrder);

	public void updateByMerchantOrderNo(GpMainOrder gm);

	public List<GpMainOrder> selectByBusinessNo(String businessNo);

	public void deleteByBusinessNo(String businessNo);
	
	public GuPolicyEndorse selectByEndorsement(String str);
}
