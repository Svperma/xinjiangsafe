package com.dsib.service;

import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;



public interface GuPolicyInsuredService {
	
	
	public GuPolicyInsured selectByPrimaryKey(GuPolicyInsuredKey guPolicyInsuredKey);
}
