package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyItemKind;

public interface GgUserCorpMapper {
	/**
	 * 查询企业状况列表信息
	 * 
	 * @author jjx
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getCorpBy_userCode1(Pagination pagination)
			throws Exception;

	/**
	 * 查询企业状况详情
	 * 
	 * @author jjx
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> get_Main_itemBy_userCode(Pagination map)
			throws Exception;

	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map getUserCorpCount(Map map) throws Exception;

	/**
	 * 查询企业总数
	 * 
	 * @author jjx
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getCorpBy_userCodeCount(Pagination map) throws Exception;

	/**
	 * 查询评估内容
	 * 
	 * @author jjx
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getContent(String EvaluateDangers)
			throws Exception;

	/**
	 * 查询危险源
	 * 
	 * @author jjx
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> get_Source(String userCode);

	/**
	 * 请输入要查询的企业名
	 * 
	 * @param userCorp
	 * @return
	 */
	public List<GgUserCorp> getCompanyName(String userCorp) throws Exception;

	/**
	 * 根据businessNo查询主险和附加险
	 * 
	 * @param list
	 * @return
	 */
	public List<GuPolicyItemKind> getBusinessNo(String businessNo)
			throws Exception;

	/**
	 * qiye企业信息
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public GgUserCorp getData(String userCode) throws Exception;

	/**
	 * qiye获取行业大类
	 * 
	 * @param userCode
	 * @return
	 */
	public String getclassCode(String userCode) throws Exception;

	/**
	 * qiye更新企业信息
	 * 
	 * @param ggusercorp
	 * @throws Exception
	 */
	public void updateUserCorp(GgUserCorp ggusercorp) throws Exception;
	/**
	 * 根据社会统一信用代码 qiye更新企业信息
	 * 
	 * @param ggusercorp
	 * @throws Exception
	 */
	public void updateUserCorpByBusinessLicenseNo(GgUserCorp ggusercorp);

	/**
	 * 报表下载
	 * 
	 * @param adapter
	 * @return
	 */
	public List<Map<String, Object>> getUserCorpToExc(ConditionAdapter adapter)
			throws Exception;

	/**
	 * 根据主键查询企业详细信息
	 * 
	 * @param userCode
	 * @return
	 */
	public GgUserCorp selectByPrimaryKey(String userCode);

	/**
	 * 用户注册时usercorp表插入数据
	 * 
	 * @param ggUserCorp
	 */
	public void insertUserCorp(GgUserCorp ggUserCorp);

	public GgUserCorp getBusinessLicenseNo(String businessLicenseNo);

	public GgUserCorp getsafetyLicenseNo(String safetyLicenseNo);

	public GgUserCorp getUserName(String userName);

	public List<GgUserCorp> getUserLikeName(String remark);
	public GgUserCorp checkTelePhone(String telePhone);
	
	GgUserCorp selectByBusinessLicenseNo(String businessLicenseNo);
	GgUserCorp selectByCompanyName(String companyName);
	
	List<GgUserCorp> selectiveGgUserCorp(GgUserCorp userCorp);
	
	
	

}
