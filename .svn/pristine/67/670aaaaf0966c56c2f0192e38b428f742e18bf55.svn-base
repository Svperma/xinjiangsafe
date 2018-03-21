package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;
import com.dsib.inter.GuServiceInter;
import com.dsib.inter.MessgeMail;

public interface GuInterfaceService {

	public GgUserCorp getUserCorp(String str);// 获取企业信息

	public MessgeMail upDataUserCorp(List<GgUserCorp> userCorp);// 多条修改企业信息

	public MessgeMail upDateUserCorpsign(GgUserCorp userCorp);// 单条修改企业信息

	public Map<String, Object> showadjustRate(String str);// 查询adjustRate是否存在该数据

	public void insertadjustRate(GuPolicyAdjustRate adjustRate);// 增加adjustRate----true

	public void updateadjustRate(GuPolicyAdjustRate adjustRate);// 修改adjustRate----false

	public Map<String, Object> showitemKind(Map<String, Object> map);// 查询itemKind是否存在该数据

	public void insertitemkind(GuPolicyItemKind policyItemKind);// 增加itemKind------true

	public void updateitemkind(GuPolicyItemKind policyItemKind);// 修改itemKind------false

	public Map<String, Object> showpolicyMain(String str);// 查询policyMain是否存在该数据

	public void insertpolicyMain(GuPolicyMain policyMain);// 增加policyMain--------true

	public void updatepolicyMain(GuPolicyMain policyMain);// 修改policyMain--------false

	public Map<String, Object> showpolicyinsured(Map<String, Object> map); // 查询policyinsured是否存在该数据

	public void insertpolicyinsured(GuPolicyInsured policyInsured); // 增加policyinsured-------true

	public void updatepolicyinsured(GuPolicyInsured policyInsured);// 修改policyinsured-------false

	public List<Map<String, Object>> showpolicyLimit(Map<String, Object> map); // 查询policyLimit是否存在该数据

	public void insertpolicyLimit(GuPolicyLimit policyLimit);// 增加policyLimit----true

	public void updatepolicyLimit(GuPolicyLimit policyLimit);// 修改policyLimit------flase

	public MessgeMail insertBigMain(List<GuServiceInter> lists);// 事务执行以上SQL

	public Map<String, Object> LookadjustRate(String str);// 支付传递adjustRate表中的数据

	public List<Map<String, Object>> LookitemKind(String str);// 支付传递limitKind表中的数据

	public List<Map<String, Object>> Lookpolicyinsured(String str);// 支付传递policyinsured表中的数据

	public List<Map<String, Object>> LookpolicyLimit(String str);// 支付传递policyLimit表中的数据

	public Map<String, Object> LookpolicyMain(String str);// 支付传递policymain表中的数据

}
