package com.dsib.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dsib.dao.GuPolicyInsuredMapper;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.service.GuPolicyInsuredService;

@Service("guPolicyInsuredService")
public class GuPolicyInsuredServiceImpl implements GuPolicyInsuredService {
	
	@Resource
	private GuPolicyInsuredMapper guPolicyInsuredMapper;

	/**
	 * 查询关系人方法  
	 */
	@Override
	public GuPolicyInsured selectByPrimaryKey(GuPolicyInsuredKey guPolicyInsuredKey) {
		
		return guPolicyInsuredMapper.selectByPrimaryKey(guPolicyInsuredKey);
	}

}
