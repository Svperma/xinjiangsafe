package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import javax.mail.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GgEvaluateDangersMapper;
import com.dsib.dao.GgUserCorpMapper;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEvaluateDangers;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.service.GgUserCorpService;

@Service("ggUserCorpService")
public class GgUserCorpServiceImpl implements GgUserCorpService {
	@Autowired
	private GgUserCorpMapper ggUserCorpMapper;
	
	@Autowired
	private GgEvaluateDangersMapper evaluateDangersMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getUserCorpCount(Map map) {
		Map<String, Object> resMap = null;
		try {
			resMap = ggUserCorpMapper.getUserCorpCount(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}

	/**
	 * @author jjx
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getCorpBy_userCode1(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserCorpMapper.getCorpBy_userCode1(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @author jjx
	 */
	public List<Map<String, Object>> get_Main_itemBy_userCode(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserCorpMapper.get_Main_itemBy_userCode(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询企业总数
	 * 
	 * @author jjx
	 */
	public List<Map<String, Object>> getCorpBy_userCodeCount(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserCorpMapper.getCorpBy_userCodeCount(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询评估内容
	 * 
	 * @author jjx
	 */
	public List<Map<String, Object>> getContent(String EvaluateDangers) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserCorpMapper.getContent(EvaluateDangers);
		} catch (Exception e) {
			// TODO Auto-generated catch block;
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询危险源
	 */
	public List<Map<String, Object>> get_Source(String userCode){
		List<Map<String, Object>> list = null;
		try {
			list = ggUserCorpMapper.get_Source(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 请输入要查询的企业名
	 */
	public List<GgUserCorp> getCompanyName(String UserCorp) {
		List<GgUserCorp> list = null;
		try {
			list = ggUserCorpMapper.getCompanyName(UserCorp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据businessNo查询主险和附加险
	 * 
	 * @param list
	 * @return
	 */
	public List<GuPolicyItemKind> getBusinessNo(String businessNo) {
		List<GuPolicyItemKind> list = null;
		try {
			list = ggUserCorpMapper.getBusinessNo(businessNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * qiye 企业信息
	 */
	public GgUserCorp getData(String userCode) {
		GgUserCorp list = null;
		try {
			list = ggUserCorpMapper.getData(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * qiye获取行业大类
	 */
	public String getclassCode(String userCode) {
		String classCode = null;
		try {
			classCode = ggUserCorpMapper.getclassCode(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classCode;
	}

	/**
	 * qiye更新企业信息
	 */
	public void updateUserCorp(GgUserCorp ggusercorp) {
		try {
			ggUserCorpMapper.updateUserCorp(ggusercorp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pagination getUsercorpContinue(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserCorpMapper.getCorpBy_userCode1(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	/**
	 * 下载报表
	 * 
	 * @author hslt
	 */
	public List<Map<String, Object>> getUserCorpToExc(ConditionAdapter adapter) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserCorpMapper.getUserCorpToExc(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public GgUserCorp selectByPrimaryKey(String userCode) {
		return ggUserCorpMapper.selectByPrimaryKey(userCode);
	}

	/**
	 * 用户注册时usercorp表插入数据
	 */
	public void insertUserCorp(GgUserCorp ggUserCorp) {
		ggUserCorpMapper.insertUserCorp(ggUserCorp);

	}

	@Override
	public List<GgUserCorp> getUserLikeName(String remark) {
		return ggUserCorpMapper.getUserLikeName(remark);
	}

	@Override
	public GgUserCorp checkTelePhone(String telePhone) {
		// TODO Auto-generated method stub
		return ggUserCorpMapper.checkTelePhone(telePhone);
	}

	@Override
	public GgUserCorp selectByBusinessLicenseNo(String businessLicenseNo) {
		return ggUserCorpMapper.selectByBusinessLicenseNo(businessLicenseNo);
	}

	@Override
	public GgUserCorp selectByCompanyName(String companyName) {
		return ggUserCorpMapper.selectByCompanyName(companyName);
	}

	@Override
	public List<GgUserCorp> selectiveGgUserCorp(GgUserCorp userCorp){
		return ggUserCorpMapper.selectiveGgUserCorp(userCorp);
	}

	@Override
	public void updateUserCorpByBusinessLicenseNo(GgUserCorp ggusercorp) {
		ggUserCorpMapper.updateUserCorpByBusinessLicenseNo(ggusercorp);
	}

	@Transactional
	public void updateUserCode_userCorpAndEvaluateDangers(String userCode,GgUserCorp userCorp,
			List<GgEvaluateDangers> evaluateDangers) {
		
		userCorp.setUserCode(userCode);
		ggUserCorpMapper.updateUserCorpByBusinessLicenseNo(userCorp);
		
		for (int i = 0; i < evaluateDangers.size(); i++) {
			GgEvaluateDangers tempEvaluateDangers = evaluateDangers.get(i);
			tempEvaluateDangers.setUserCode(userCode);
			evaluateDangersMapper.updateEvaDangerSelective(tempEvaluateDangers);
		}
	}




}
