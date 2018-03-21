package com.dsib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsib.dao.GuInterfaceMapper;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyAdjustRate;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyLimit;
import com.dsib.entity.GuPolicyMain;
import com.dsib.inter.GuServiceInter;
import com.dsib.inter.MessgeMail;
import com.dsib.service.GuInterfaceService;

@Service("GuInterface")
public class GuInterfaceServiceImpl implements GuInterfaceService {

	@Autowired
	private GuInterfaceMapper inter;

	public GgUserCorp getUserCorp(String str) {

		GgUserCorp usercorp = new GgUserCorp();
		try {
			usercorp = inter.getUserCorp(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return usercorp;
	}

	@Transactional
	public MessgeMail upDataUserCorp(List<GgUserCorp> userCorp) {// 多条修改企业信息

		MessgeMail message = new MessgeMail();
		message.setItems(true);
		String news = "";
		try {
			for (int i = 0; i < userCorp.size(); i++) {
				inter.upDataUserCorp(userCorp.get(i));
				news = "企业名称" + userCorp.get(i).getCompanyName() + "企业代码"
						+ userCorp.get(i).getUserCode();
			}
		} catch (Exception ex) {
			message.setItems(false);
			message.setMessge(news + ex.getMessage());
			ex.printStackTrace();
		}
		return message;
	}

	@Transactional
	public MessgeMail upDateUserCorpsign(GgUserCorp userCorp) {// 单条修改企业信息
		MessgeMail message = new MessgeMail();
		message.setItems(true);
		String news = "";
		try {
			inter.upDataUserCorp(userCorp);
			news = "企业名称" + userCorp.getCompanyName() + "企业代码"
					+ userCorp.getUserCode();
		} catch (Exception ex) {
			message.setItems(false);
			message.setMessge(news + ex.getMessage());
			ex.printStackTrace();
		}
		return message;
	}

	public Map<String, Object> showadjustRate(String str) {// 查询adjustRate是否存在该数据
		Map<String, Object> mapResult = new HashMap<String, Object>();
		try {
			mapResult = inter.showadjustRate(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapResult;
	}

	public void insertadjustRate(GuPolicyAdjustRate adjustRate) {// 增加adjustRate----1

		try {
			inter.insertadjustRate(adjustRate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateadjustRate(GuPolicyAdjustRate adjustRate) {// 修改adjustRate----2
		try {
			inter.updateadjustRate(adjustRate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Map<String, Object> showitemKind(Map<String, Object> map) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		try {
			mapResult = inter.showitemKind(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapResult;
	}

	public Map<String, Object> showpolicyMain(String str) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		try {
			mapResult = inter.showpolicyMain(str);
		} catch (Exception ex) {
			System.out.println("报错" + ex.getMessage());
			ex.printStackTrace();

		}
		return mapResult;
	}

	public void insertitemkind(GuPolicyItemKind policyItemKind) {
		try {
			inter.insertitemkind(policyItemKind);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateitemkind(GuPolicyItemKind policyItemKind) {
		try {
			inter.updateitemkind(policyItemKind);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void insertpolicyMain(GuPolicyMain policyMain) {
		try {
			inter.insertpolicyMain(policyMain);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void updatepolicyMain(GuPolicyMain policyMain) {
		try {
			inter.updatepolicyMain(policyMain);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Map<String, Object> showpolicyinsured(Map<String, Object> map) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		try {
			mapResult = inter.showPolicyInsured(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapResult;
	}

	public void insertpolicyinsured(GuPolicyInsured policyInsured) {
		try {
			inter.insertpolicyinsured(policyInsured);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void updatepolicyinsured(GuPolicyInsured policyInsured) {
		try {
			inter.updatepolicyinsured(policyInsured);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public List<Map<String, Object>> showpolicyLimit(Map<String, Object> map) {
		List<Map<String, Object>> mapResult = new ArrayList<Map<String, Object>>();
		try {
			mapResult = inter.showpolicyLimit(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapResult;
	}

	public void insertpolicyLimit(GuPolicyLimit policyLimit) {
		try {
			inter.insertpolicyLimit(policyLimit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void updatepolicyLimit(GuPolicyLimit policyLimit) {
		try {
			inter.updatepolicyLimit(policyLimit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Transactional
	public MessgeMail insertBigMain(List<GuServiceInter> lists) {

		MessgeMail message = new MessgeMail();
		message.setItems(true);
		String news = "";
		try {
			for (int i = 0; i < lists.size(); i++) {
				GuServiceInter serviceInter = lists.get(i);
				if (serviceInter.isAdjustRatestatu()) {
					insertadjustRate(serviceInter.getPolicyAdjustRate());
				} else {
					updateadjustRate(serviceInter.getPolicyAdjustRate());
				}
				List<GuPolicyItemKind> policyItemKind = serviceInter
						.getPolicyItemKind();
				GuPolicyItemKind policyItemKindsign = new GuPolicyItemKind();
				for (int j = 0; j < policyItemKind.size(); j++) {
					policyItemKindsign = policyItemKind.get(j);
					if (policyItemKindsign.isJudge()) {
						insertitemkind(policyItemKindsign);
					} else {
						updateitemkind(policyItemKindsign);
					}
				}
				if (serviceInter.isPolicyMainstatus()) {
					insertpolicyMain(serviceInter.getPolicyMain());
				} else {
					updatepolicyMain(serviceInter.getPolicyMain());
				}
				List<GuPolicyInsured> policyInsured = serviceInter
						.getInsuredList();
				GuPolicyInsured policyInsuredsign = new GuPolicyInsured();
				for (int j = 0; j < policyInsured.size(); j++) {
					policyInsuredsign = policyInsured.get(j);
					if (policyInsuredsign.isJudge()) {
						insertpolicyinsured(policyInsuredsign);
					} else {
						updatepolicyinsured(policyInsuredsign);
					}
				}
				List<GuPolicyLimit> policyLimit = serviceInter.getPolicyLimit();
				GuPolicyLimit policyLimitsign = new GuPolicyLimit();
				for (int j = 0; j < policyLimit.size(); j++) {
					policyLimitsign = policyLimit.get(j);
					if (policyLimitsign.isJudje()) {
						insertpolicyLimit(policyLimitsign);
					} else {
						updatepolicyLimit(policyLimitsign);
					}
				}
			}
		} catch (Exception ex) {
			message.setItems(false);
			message.setMessge(news + ex.getMessage());
			ex.printStackTrace();
		}
		return message;
	}

	public Map<String, Object> LookadjustRate(String str) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		try {
			mapResult = inter.LookadjustRate(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mapResult;
	}

	public List<Map<String, Object>> LookitemKind(String str) {
		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		try {
			listResult = inter.LookitemKind(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listResult;
	}

	public List<Map<String, Object>> Lookpolicyinsured(String str) {
		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		try {
			listResult = inter.Lookpolicyinsured(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listResult;
	}

	public List<Map<String, Object>> LookpolicyLimit(String str) {
		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		try {
			listResult = inter.LookpolicyLimit(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listResult;
	}

	public Map<String, Object> LookpolicyMain(String str) {
		Map<String, Object> mapRessult = new HashMap<String, Object>();
		try {
			mapRessult = inter.LookpolicyMain(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mapRessult;
	}
}
