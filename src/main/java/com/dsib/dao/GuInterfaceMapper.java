package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;

public interface GuInterfaceMapper {

	public GgUserCorp getUserCorp(String str);

	public void upDataUserCorp(GgUserCorp userCorp);

	public Map<String, Object> showadjustRate(String str);

	public void insertadjustRate(GuPolicyAdjustRate adjustRate);

	public void updateadjustRate(GuPolicyAdjustRate adjustRate);

	public Map<String, Object> showitemKind(Map<String, Object> map);

	public void insertitemkind(GuPolicyItemKind policyItemKind);

	public void updateitemkind(GuPolicyItemKind policyItemKind);

	public Map<String, Object> showpolicyMain(String str);

	public void insertpolicyMain(GuPolicyMain policyMain);

	public void updatepolicyMain(GuPolicyMain policyMain);

	public Map<String, Object> showPolicyInsured(Map<String, Object> map);

	public void insertpolicyinsured(GuPolicyInsured policyInsured);

	public void updatepolicyinsured(GuPolicyInsured policyInsured);

	public List<Map<String, Object>> showpolicyLimit(Map<String, Object> map);

	public void insertpolicyLimit(GuPolicyLimit policyLimit);

	public void updatepolicyLimit(GuPolicyLimit policyLimit);

	public Map<String, Object> LookadjustRate(String str);

	public List<Map<String, Object>> LookitemKind(String str);

	public List<Map<String, Object>> Lookpolicyinsured(String str);

	public List<Map<String, Object>> LookpolicyLimit(String str);

	public Map<String, Object> LookpolicyMain(String str);

}
