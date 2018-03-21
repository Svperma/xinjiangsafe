package com.dsib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.GpMainOrderMapper;
import com.dsib.entity.GpMainOrder;
import com.dsib.entity.GuPolicyEndorse;
import com.dsib.service.GpMainOrderService;

@Service("gpMainOrderService")
public class GpMainOrderServiceImpl implements GpMainOrderService {

	@Autowired
	private GpMainOrderMapper gpMainOrderMapper;

	public void insertMainOrder(GpMainOrder gpMainOrder) {
		try {
			gpMainOrderMapper.insertMainOrder(gpMainOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateByMerchantOrderNo(GpMainOrder gm) {
		try {
			gpMainOrderMapper.updateByMerchantOrderNo(gm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<GpMainOrder> selectByBusinessNo(String businessNo) {
		List<GpMainOrder> list = null;
		try {
			list = gpMainOrderMapper.selectByBusinessNo(businessNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteByBusinessNo(String businessNo) {
		try {
			gpMainOrderMapper.deleteByBusinessNo(businessNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public GuPolicyEndorse selectByEndorsement(String str) {
		GuPolicyEndorse guPolicyEndorse = new GuPolicyEndorse();
		try{
			guPolicyEndorse = gpMainOrderMapper.selectByEndorsement(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return guPolicyEndorse;
	}

}
