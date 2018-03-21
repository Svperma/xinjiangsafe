package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.GpOrderDetailMapper;
import com.dsib.entity.GpOrderDetail;
import com.dsib.service.GpOrderDetailService;

@Service("gpOrderDetailService")
public class GpOrderDetailServiceImpl implements GpOrderDetailService {

	@Autowired
	private GpOrderDetailMapper gpOrderDetailMapper;

	public void insertOrederDetail(GpOrderDetail gpOrderDetail) {
		try {
			gpOrderDetailMapper.insertOrderDetail(gpOrderDetail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateByBusinessNo(GpOrderDetail go) {
		try {
			gpOrderDetailMapper.updateByBusinessNo(go);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<GpOrderDetail> selectByMainInMerchantOrderNo(String businessNo) {
		List<GpOrderDetail> list = null;
		try {
			list = gpOrderDetailMapper
					.selectByMainInMerchantOrderNo(businessNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteByBusinessNo(String businessNo) {
		try {
			gpOrderDetailMapper.deleteByBusinessNo(businessNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatePayFlag(String str) {
		
		try{
			gpOrderDetailMapper.updatePayFlag(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void updatePolicyMain(String str) {
		try{
			gpOrderDetailMapper.updatePolicyMain(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateproposal(Map<String, Object> condition) {
		try{
			gpOrderDetailMapper.updateproposal(condition);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
