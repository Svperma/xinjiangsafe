package com.dsib.submitInterface;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GcClaim;
import com.dsib.entity.GuPolicyMain;
import com.dsib.webService.AZX.ClaimGet.dto.common.xsd.MainEhm;
import com.dsib.webService.AZX.ClaimGet.dto.xsd.ClaimGetRequest;
import com.dsib.webService.AZX.ClaimGet.dto.xsd.ClaimGetResponse;
import com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType;
import com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortTypeProxy;

@Component
public class SubmitClaimUtil {
	
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;
	
	
	/**
	 * 调用在线报案接口
	 * @param claim
	 * @return
	 * @throws RemoteException
	 */
	public ClaimGetResponse claimGet(GcClaim claim)
			throws RemoteException {
		/**
		 * 组织在线理赔入参
		 */
		GuPolicyMain gupolicymain = guPolicyMainMapper.selectByPolicyNo(claim.getPolicyNo());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		MainEhm mainEhm = new MainEhm();
		mainEhm.setPolicyNo(claim.getPolicyNo());//保单号
		mainEhm.setSystemCode("AZBX");//系统代码
		mainEhm.setLosscause(sim.format(claim.getLossDate()));//出险时间
		mainEhm.setLossLocation(claim.getLossLocaiton());//出险地点
		mainEhm.setDanger(claim.getLinkName());//出险人
		mainEhm.setInsurerCode(claim.getInsurerCode());//要求理赔的保险公司代码
		mainEhm.setInformant(gupolicymain.getAppliName());//报案人为企业名称
		mainEhm.setReportDate(sim.format(claim.getBaoanDate()));//报案时间
		mainEhm.setLinkPhone(claim.getLinkPhone());//联系人电话
		mainEhm.setLinkName(claim.getLinkName());//联系人名称
		mainEhm.setDescribe(claim.getLossCause());//出险原因
		
		ClaimGetResponse service = new ClaimGetResponse();
		AZXClaimGetServicePortType sp = new AZXClaimGetServicePortTypeProxy();
		ClaimGetRequest claimGetRequest = new ClaimGetRequest();
		claimGetRequest.setMainEhm(mainEhm);
		claimGetRequest.setRequestType("60");
		
		service = sp.service(claimGetRequest);
		return service;
	}
	
	
	

}
