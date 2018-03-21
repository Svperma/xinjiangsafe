package com.dsib.inter;

import java.util.List;

import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;

/**
 * 用于封装接口导入主表对象
 */
public class GuServiceInter {

	private GuPolicyAdjustRate policyAdjustRate;

	private boolean adjustRatestatu;

	private List<GuPolicyItemKind> policyItemKind;

	private GuPolicyMain policyMain;

	private boolean policyMainstatus;

	private List<GuPolicyInsured> insuredList;

	private List<GuPolicyLimit> policyLimit;

	public GuPolicyAdjustRate getPolicyAdjustRate() {
		return policyAdjustRate;
	}

	public void setPolicyAdjustRate(GuPolicyAdjustRate policyAdjustRate) {
		this.policyAdjustRate = policyAdjustRate;
	}

	public boolean isAdjustRatestatu() {
		return adjustRatestatu;
	}

	public void setAdjustRatestatu(boolean adjustRatestatu) {
		this.adjustRatestatu = adjustRatestatu;
	}

	public List<GuPolicyItemKind> getPolicyItemKind() {
		return policyItemKind;
	}

	public void setPolicyItemKind(List<GuPolicyItemKind> policyItemKind) {
		this.policyItemKind = policyItemKind;
	}

	public GuPolicyMain getPolicyMain() {
		return policyMain;
	}

	public void setPolicyMain(GuPolicyMain policyMain) {
		this.policyMain = policyMain;
	}

	public boolean isPolicyMainstatus() {
		return policyMainstatus;
	}

	public void setPolicyMainstatus(boolean policyMainstatus) {
		this.policyMainstatus = policyMainstatus;
	}

	public List<GuPolicyInsured> getInsuredList() {
		return insuredList;
	}

	public void setInsuredList(List<GuPolicyInsured> insuredList) {
		this.insuredList = insuredList;
	}

	public List<GuPolicyLimit> getPolicyLimit() {
		return policyLimit;
	}

	public void setPolicyLimit(List<GuPolicyLimit> policyLimit) {
		this.policyLimit = policyLimit;
	}

}
