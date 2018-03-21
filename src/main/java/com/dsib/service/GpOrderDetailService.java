package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.entity.GpOrderDetail;

public interface GpOrderDetailService {

	public void insertOrederDetail(GpOrderDetail gpOrderDetail);

	public void updateByBusinessNo(GpOrderDetail go);

	public List<GpOrderDetail> selectByMainInMerchantOrderNo(String businessNo);

	public void deleteByBusinessNo(String businessNo);
	
	public void updatePayFlag(String str);
	
	public void updatePolicyMain(String str);
	
	public void updateproposal(Map<String,Object> condition);
	

}
