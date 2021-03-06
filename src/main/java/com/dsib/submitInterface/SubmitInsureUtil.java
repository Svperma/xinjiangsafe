package com.dsib.submitInterface;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.dsib.dao.GuPolicyEmployeeMapper;
import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyEmployee;
import com.dsib.entity.GuPolicyInsured;
import com.dsib.entity.GuPolicyInsuredKey;
import com.dsib.entity.GuPolicyItemKind;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.GgUserService;
import com.dsib.service.GuInterfaceService;
import com.dsib.service.GuPolicyInsuredService;
import com.dsib.service.GuPolicyItemKindService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.webService.AZX.bean.common.xsd.ApplicantEhm;
import com.dsib.webService.AZX.bean.common.xsd.InsuredEhm;
import com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm;
import com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm;
import com.dsib.webService.AZX.bean.common.xsd.MainEhm;
import com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleRequest;
import com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleResponse;
import com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortType;
import com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortTypeProxy;
import com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteRequest;
import com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteResponse;
import com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServicePortType;
import com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServicePortTypeProxy;

/**
 * 提交核保工具
 * 
 * @author Administrator
 * 
 */
@Component
public class SubmitInsureUtil {

	@Resource(name = "GuInterface")
	private GuInterfaceService guinter;

	@Resource(name = "guPolicyInsuredService")
	private GuPolicyInsuredService policyInsuredService;// 关系人信息

	@Resource(name = "ggUserService")
	private GgUserService userService;// 用户查询

	@Resource(name = "guPolicyItemKindService")
	private GuPolicyItemKindService guPolicyItemKindService;

	@Resource
	private GuPolicyEmployeeMapper employeeMapper;

	@Resource
	private GuPolicyMainMapper guPolicyMainMapper;

	/**
	 * 根据保单号提交人工核保接口
	 * 
	 * @param businessNo
	 * @return
	 * @throws RemoteException
	 */
	public ManualUnderwriteResponse manualUnderwriting(String businessNo)
			throws RemoteException {

		// 保单主信息
		GuPolicyMain guPolicyMain = guPolicyMainMapper
				.selectByPrimaryKey(businessNo);

		// 险别信息
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(businessNo);
		List<GuPolicyItemKind> guPolicyItemKindList = guPolicyItemKindService
				.selectListByBusinessNo(guPolicyItemKind);

		// 保单员工信息
		GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
		guPolicyEmployee.setBusinessNo(businessNo);
		List<GuPolicyEmployee> guPolicyEmployeeList = employeeMapper
				.findEmployeeList(guPolicyEmployee);

		ManualUnderwriteResponse manualUnderwriting = manualUnderwriting(
				guPolicyMain, guPolicyItemKindList, guPolicyEmployeeList);

		return manualUnderwriting;
	}

	/**
	 * 提交人工核保接口
	 * 
	 * @param guPolicyMain
	 * @param guPolicyItemKindList
	 * @param guPolicyEmployeeList
	 * @return
	 * @throws RemoteException
	 */
	public ManualUnderwriteResponse manualUnderwriting(
			GuPolicyMain guPolicyMain,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyEmployee> guPolicyEmployeeList) throws RemoteException {

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		ManualUnderwriteRequest inseuranceSingle = new ManualUnderwriteRequest();
		inseuranceSingle.setRequestType("11");
		inseuranceSingle.setPrimaryKey(guPolicyMain.getBusinessNo());
		MainEhm mainEhm = new MainEhm();// 投保单主信息模块
		ApplicantEhm applicantEhm = new ApplicantEhm();// 投保人模块 对象
		InsuredEhm insuredEhm = new InsuredEhm();// 被保险人模块 对象
		ItemKindEhm itemKindEhm = new ItemKindEhm();// 险别信息模块
		ItemKindEhm[] itemKindEhmArray = null;
		InsuredSubjectEhm insuredSubject = new InsuredSubjectEhm();// 标的信息模块
		InsuredSubjectEhm[] insuredSubjectArray = null;
		mainEhm.setSystemCode("AZBX");// 系统来源
		mainEhm.setPrimaryKey(guPolicyMain.getBusinessNo());
		mainEhm.setPreviousPolicyNo(guPolicyMain.getPreviousPolicyNo());// 续保单时去年保单号码
		// mainEhm.setStartDate("2016-05-05 00:00:00");//起保时间
		mainEhm.setStartDate(sim.format(guPolicyMain.getStartDate()));// 起保时间
		mainEhm.setEndDate(sim.format(guPolicyMain.getEndDate()));// 终保日期
		mainEhm.setArgueSolution(guPolicyMain.getArgueSolution());// 争议结局方式
		mainEhm.setArbitBoardName(guPolicyMain.getArbitBoardName());// 仲裁委员会名称
		mainEhm.setOperatorCode(guPolicyMain.getOperatorCode());// 平台操作页面

		GgUser user = userService.getUser(guPolicyMain.getOperatorCode());// 根据保单的操作人找到用户用户
		mainEhm.setOperatorCompany(user.getUserName());// 平台操作员机构

		Date date = new Date();
		mainEhm.setOperateDate(sim.format(date));// 平台操作时间
		// if(guPolicyMain.getSignDate()!=null){
		mainEhm.setSignDate(sim.format(guPolicyMain.getSignDate() == null ? new Date()
				: guPolicyMain.getSignDate()));// 签单日期
		// }
		mainEhm.setRenewalFlag(StringUtils.isEmpty(guPolicyMain
				.getRenewalFlag()) == true ? "0" : guPolicyMain
				.getRenewalFlag());// 是否续保
		if (!"AICS".equals(guPolicyMain.getInsurerCode())) {
			mainEhm.setSumAmount(String.valueOf(guPolicyMain.getSumAmount()));// 总限额
		}
		mainEhm.setDisCount(String.valueOf(guPolicyMain.getDisCount()));// 总折扣率
		mainEhm.setSpreadsheetPremium(String.valueOf(guPolicyMain
				.getSpreadsheetPremium()));// 试算保费
		mainEhm.setActualPremium(String.valueOf(guPolicyMain.getActualPremium()));// 实际保费
		mainEhm.setSpecialProvisions(guPolicyMain.getSpecialprovisions());// 特殊约定
		mainEhm.setInsuredNumber(String.valueOf(guPolicyEmployeeList.size()));// 标的人数
		mainEhm.setInsurerCode(guPolicyMain.getInsurerCode());// 保险公司代码
		// mainEhm.setInsurerCode("ZHLHCX");
		mainEhm.setProvince(guPolicyMain.getProvince()); // 省
		mainEhm.setCity(guPolicyMain.getCity()); // 市
		mainEhm.setCounty(guPolicyMain.getCounty()); // 区县
		// 投保人信息
		GgUserCorp userCorp = guinter.getUserCorp(guPolicyMain.getAppliCode()) == null ? new GgUserCorp()
				: guinter.getUserCorp(guPolicyMain.getAppliCode());// 查询投保人公司信息

		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(guPolicyMain.getBusinessNo());
		guPolicyInsuredKey.setSeriesno(1L);
		GuPolicyInsured usere = policyInsuredService
				.selectByPrimaryKey(guPolicyInsuredKey);// 投保人跟单信息

		applicantEhm.setAppliName(usere.getInsuredname());
		applicantEhm
				.setIdentifyNumber(StringUtils.isEmpty(usere
						.getIdentitynumber()) == true ? "0" : usere
						.getIdentitynumber());
		applicantEhm.setCertificateno(StringUtils.isEmpty(usere
				.getInsuredtype()) == true ? "0" : usere.getInsuredtype());
		applicantEhm
				.setSafetyLevel(StringUtils.isEmpty(usere.getPolicyno()) == true ? "0"
						: usere.getPolicyno());
		applicantEhm.setAddressName(usere.getInsuredaddress());
		applicantEhm.setLinkerName(usere.getLinkname());
		applicantEhm.setPostCode(userCorp.getPost());
		applicantEhm
				.setPhone(StringUtils.isEmpty(userCorp.getMobile()) == true ? usere
						.getPhonenumber() : userCorp.getMobile());
		applicantEhm.setMobile(usere.getPhonenumber());
		applicantEhm.setEmail(usere.getEmail());
		applicantEhm
				.setClassCode(StringUtils.isEmpty(usere.getRemark()) == true ? "0"
						: usere.getRemark());
		applicantEhm
				.setBusinessClass(StringUtils.isEmpty(usere.getFlag()) == true ? "0"
						: usere.getFlag());
		applicantEhm.setProvince(guPolicyMain.getProvince());
		applicantEhm.setCity(guPolicyMain.getCity());
		applicantEhm.setCounty(guPolicyMain.getCounty());
		applicantEhm.setScale(userCorp.getClassSize());

		// 被保险人信息
		GgUserCorp userCorp2 = guinter.getUserCorp(guPolicyMain
				.getInsuredCode()) == null ? new GgUserCorp() : guinter
				.getUserCorp(guPolicyMain.getInsuredCode());// 查询被保人公司信息

		GuPolicyInsuredKey guPolicyInsuredKey2 = new GuPolicyInsuredKey();
		guPolicyInsuredKey2.setBusinessno(guPolicyMain.getBusinessNo());
		guPolicyInsuredKey2.setSeriesno(2L);
		GuPolicyInsured usere2 = policyInsuredService
				.selectByPrimaryKey(guPolicyInsuredKey2);// 被保人跟单信息

		insuredEhm.setInsuredName(usere2.getInsuredname());
		insuredEhm.setIdentifyNumber(usere2.getIdentitynumber());
		insuredEhm.setCertificateno(usere2.getInsuredtype());
		insuredEhm.setSafetyLevel(usere2.getPolicyno());
		insuredEhm.setAddressName(usere2.getInsuredaddress());
		insuredEhm.setLinkerName(usere2.getLinkname());
		insuredEhm.setPostCode(userCorp2.getPost());
		insuredEhm
				.setPhone(StringUtils.isEmpty(userCorp.getMobile()) == true ? usere
						.getPhonenumber() : userCorp.getMobile());
		insuredEhm.setMobile(usere2.getPhonenumber());
		insuredEhm.setEmail(usere2.getEmail());
		insuredEhm.setClassCode(usere2.getRemark());
		insuredEhm.setBusinessClass(usere2.getFlag());
		insuredEhm.setProvince(guPolicyMain.getProvince());
		insuredEhm.setCity(guPolicyMain.getCity());
		insuredEhm.setCounty(guPolicyMain.getCounty());
		insuredEhm.setScale(userCorp2.getClassSize());

		// 险别信息
		itemKindEhmArray = new ItemKindEhm[guPolicyItemKindList.size()];
		/**
		 * unitAmount的作用:组织接口请求的时候需要传输"第三者责任险"的eachtimelimit(每人赔偿限额),而数据库里没有存,
		 * 但是这个字段和主险的"每人赔偿限额"是一样的所以需要先取出来,然后在组织"第三者责任险"的时候把主险的"每人赔偿限额"放进去
		 */
		String unitAmount = "";
		for (int i = 0; i < guPolicyItemKindList.size(); i++) {
			itemKindEhm = new ItemKindEhm();
			if ("0901001".equals(guPolicyItemKindList.get(i).getKindcode())) {
				unitAmount = guPolicyItemKindList.get(i).getUnitamount()
						.toString();
			}
		}
		for (int i = 0; i < guPolicyItemKindList.size(); i++) {
			itemKindEhm = new ItemKindEhm();

			GuPolicyItemKind itemKind = guPolicyItemKindList.get(i);

			itemKindEhm.setKindCode(itemKind.getKindcode());
			itemKindEhm.setKindName(itemKind.getKindname());
			itemKindEhm.setAmount(String.valueOf(itemKind.getAmount()));
			itemKindEhm.setPremium(String.valueOf(itemKind.getActualpremium()));
			itemKindEhm.setRate(String.valueOf(itemKind.getRate()));
			itemKindEhm.setDeductible(String.valueOf(itemKind.getRemark()));
			itemKindEhm.setEachtimelimit(String.valueOf(itemKind.getAmount()));
			if ("0901002".equals(itemKind.getKindcode())) {
				itemKindEhm.setEchLimitAmount(unitAmount);
			} else {
				itemKindEhm.setEchLimitAmount(String.valueOf(itemKind
						.getUnitamount()));
			}
			itemKindEhm.setSumAmountlimit(String.valueOf(itemKind.getAmount()));
			itemKindEhmArray[i] = itemKindEhm;

		}
		// 标的人模块
		insuredSubjectArray = new InsuredSubjectEhm[guPolicyEmployeeList.size()];
		for (int i = 0; i < guPolicyEmployeeList.size(); i++) {
			insuredSubject = new InsuredSubjectEhm();
			insuredSubject.setInsuredObjectPerNo(String.valueOf(i));
			insuredSubject.setInsuredObjectPerName(guPolicyEmployeeList.get(i)
					.getPepName());
			insuredSubject.setInsuredObjectPerIdentifyType("1");
			insuredSubject
					.setInsuredObjectPerIdentifyNumber(guPolicyEmployeeList
							.get(i).getPepIdentityNo());
			insuredSubjectArray[i] = insuredSubject;
		}
		inseuranceSingle.setApplicantEhm(applicantEhm);
		inseuranceSingle.setInsuredEhm(insuredEhm);
		inseuranceSingle.setInsuredSubjectEhmArray(insuredSubjectArray);
		inseuranceSingle.setMainEhm(mainEhm);
		inseuranceSingle.setItemKindEhmArray(itemKindEhmArray);

		AZXManualUnderwriteServicePortType sp = new AZXManualUnderwriteServicePortTypeProxy();
		ManualUnderwriteResponse service = new ManualUnderwriteResponse();
		service = sp.service(inseuranceSingle);
		return service;
	}

	/**
	 * 根据保单号提交自动核保接口
	 * 
	 * @param businessNo
	 * @return
	 * @throws RemoteException
	 */
	public InsuranceSingleResponse autoUnderwriting(String businessNo)
			throws RemoteException {

		// 保单主信息
		GuPolicyMain guPolicyMain = guPolicyMainMapper
				.selectByPrimaryKey(businessNo);

		// 险别信息
		GuPolicyItemKind guPolicyItemKind = new GuPolicyItemKind();
		guPolicyItemKind.setBusinessno(businessNo);
		List<GuPolicyItemKind> guPolicyItemKindList = guPolicyItemKindService
				.selectListByBusinessNo(guPolicyItemKind);

		// 保单员工信息
		GuPolicyEmployee guPolicyEmployee = new GuPolicyEmployee();
		guPolicyEmployee.setBusinessNo(businessNo);
		List<GuPolicyEmployee> guPolicyEmployeeList = employeeMapper
				.findEmployeeList(guPolicyEmployee);

		InsuranceSingleResponse autoUnderwriting = autoUnderwriting(
				guPolicyMain, guPolicyItemKindList, guPolicyEmployeeList);

		return autoUnderwriting;
	}

	/**
	 * 提交自动核保接口
	 * 
	 * @param guPolicyMain
	 * @param guPolicyItemKindList
	 * @param guPolicyEmployeeList
	 * @return
	 * @throws RemoteException
	 */
	public InsuranceSingleResponse autoUnderwriting(GuPolicyMain guPolicyMain,
			List<GuPolicyItemKind> guPolicyItemKindList,
			List<GuPolicyEmployee> guPolicyEmployeeList) throws RemoteException {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		InsuranceSingleRequest inseuranceSingle = new InsuranceSingleRequest();
		inseuranceSingle.setRequestType("10");
		inseuranceSingle.setPrimaryKey(guPolicyMain.getBusinessNo());

		MainEhm mainEhm = new MainEhm();// 投保单主信息模块
		ApplicantEhm applicantEhm = new ApplicantEhm();// 投保人模块 对象
		InsuredEhm insuredEhm = new InsuredEhm();// 被保险人模块 对象
		ItemKindEhm itemKindEhm = new ItemKindEhm();// 险别信息模块
		ItemKindEhm[] itemKindEhmArray = null;
		InsuredSubjectEhm insuredSubject = new InsuredSubjectEhm();// 标的信息模块
		InsuredSubjectEhm[] insuredSubjectArray = null;
		mainEhm.setSystemCode("AZBX");// 系统来源
		mainEhm.setPrimaryKey(guPolicyMain.getBusinessNo());
		mainEhm.setPreviousPolicyNo(guPolicyMain.getPreviousPolicyNo());// 续保单时去年保单号码
		mainEhm.setStartDate(sim.format(guPolicyMain.getStartDate()));// 起保时间
		mainEhm.setEndDate(sim.format(guPolicyMain.getEndDate()));// 终保日期
		mainEhm.setArgueSolution(guPolicyMain.getArgueSolution());// 争议结局方式
		mainEhm.setArbitBoardName(guPolicyMain.getArbitBoardName());// 仲裁委员会名称
		mainEhm.setOperatorCode(guPolicyMain.getOperatorCode());// 平台操作页面

		GgUser user = userService.getUser(guPolicyMain.getOperatorCode());// 根据保单的操作人找到用户用户
		mainEhm.setOperatorCompany(user.getUserName());// 平台操作员机构
		mainEhm.setSalemanName(user.getLinkName());// 业务员姓名(用户的联系人)
		mainEhm.setSalemanPhone(user.getTelePhone());// 业务员电话(用户的电话)
		Date date = new Date();
		mainEhm.setOperateDate(sim.format(date));// 平台操作时间
		if (guPolicyMain.getSignDate() != null) {
			mainEhm.setSignDate(sim.format(guPolicyMain.getSignDate()));// 签单日期
		}
		mainEhm.setRenewalFlag(StringUtils.isEmpty(guPolicyMain
				.getRenewalFlag()) == true ? "0" : guPolicyMain
				.getRenewalFlag());// 是否续保
		if (!"AICS".equals(guPolicyMain.getInsurerCode())) {
			mainEhm.setSumAmount(String.valueOf(guPolicyMain.getSumAmount()));// 总限额
		}
		mainEhm.setDisCount(String.valueOf(guPolicyMain.getDisCount()));// 总折扣率
		mainEhm.setSpreadsheetPremium(String.valueOf(guPolicyMain
				.getSpreadsheetPremium()));// 试算保费
		mainEhm.setActualPremium(String.valueOf(guPolicyMain.getActualPremium()));// 实际保费
		mainEhm.setSpecialProvisions(guPolicyMain.getSpecialprovisions());// 特殊约定
		mainEhm.setInsuredNumber(String.valueOf(guPolicyEmployeeList.size()));// 标的人数
		mainEhm.setInsurerCode(guPolicyMain.getInsurerCode());// 保险公司代码
		// mainEhm.setInsurerCode("ZHLHCX");
		mainEhm.setProvince(guPolicyMain.getProvince()); // 省
		mainEhm.setCity(guPolicyMain.getCity()); // 市
		mainEhm.setCounty(guPolicyMain.getCounty()); // 区县
		// 投保人信息
		GgUserCorp userCorp = guinter.getUserCorp(guPolicyMain.getAppliCode());
		userCorp = userCorp == null ? new GgUserCorp() : userCorp;// 查询投保人公司信息

		GuPolicyInsuredKey guPolicyInsuredKey = new GuPolicyInsuredKey();
		guPolicyInsuredKey.setBusinessno(guPolicyMain.getBusinessNo());
		guPolicyInsuredKey.setSeriesno(1L);
		GuPolicyInsured usere = policyInsuredService
				.selectByPrimaryKey(guPolicyInsuredKey);// 投保人跟单信息

		applicantEhm.setAppliName(usere.getInsuredname());
		applicantEhm
				.setIdentifyNumber(StringUtils.isEmpty(usere
						.getIdentitynumber()) == true ? "0" : usere
						.getIdentitynumber());
		applicantEhm.setCertificateno(usere.getInsuredtype());
		applicantEhm.setSafetyLevel(usere.getPolicyno());
		applicantEhm.setAddressName(usere.getInsuredaddress());
		applicantEhm.setLinkerName(usere.getLinkname());
		applicantEhm.setPostCode(userCorp.getPost());
		applicantEhm.setPhone(userCorp.getMobile());
		applicantEhm.setMobile(usere.getPhonenumber());
		applicantEhm.setEmail(usere.getEmail());
		applicantEhm.setClassCode(usere.getRemark());
		applicantEhm.setBusinessClass(usere.getFlag());
		applicantEhm.setProvince(guPolicyMain.getProvince());
		applicantEhm.setCity(guPolicyMain.getCity());
		applicantEhm.setCounty(guPolicyMain.getCounty());
		applicantEhm.setScale(userCorp.getClassSize());

		// 被保险人信息
		GgUserCorp userCorp2 = guinter.getUserCorp(guPolicyMain
				.getInsuredCode());
		userCorp2 = userCorp2 == null ? new GgUserCorp() : guinter
				.getUserCorp(guPolicyMain.getInsuredCode());// 查询被保人公司信息

		GuPolicyInsuredKey guPolicyInsuredKey2 = new GuPolicyInsuredKey();
		guPolicyInsuredKey2.setBusinessno(guPolicyMain.getBusinessNo());
		guPolicyInsuredKey2.setSeriesno(2L);
		GuPolicyInsured usere2 = policyInsuredService
				.selectByPrimaryKey(guPolicyInsuredKey2);// 被保人跟单信息

		insuredEhm.setInsuredName(usere2.getInsuredname());
		insuredEhm.setIdentifyNumber(usere2.getIdentitynumber());
		insuredEhm.setCertificateno(usere2.getInsuredtype());
		insuredEhm.setSafetyLevel(usere2.getPolicyno());
		insuredEhm.setAddressName(usere2.getInsuredaddress());
		insuredEhm.setLinkerName(usere2.getLinkname());
		insuredEhm.setPostCode(userCorp2.getPost());
		insuredEhm.setPhone(userCorp2.getMobile());
		insuredEhm.setMobile(usere2.getPhonenumber());
		insuredEhm.setEmail(usere2.getEmail());
		insuredEhm.setClassCode(usere2.getRemark());
		insuredEhm.setBusinessClass(usere2.getFlag());
		insuredEhm.setProvince(guPolicyMain.getProvince());
		insuredEhm.setCity(guPolicyMain.getCity());
		insuredEhm.setCounty(guPolicyMain.getCounty());
		insuredEhm.setScale(userCorp2.getClassSize());
		// 险别信息
		itemKindEhmArray = new ItemKindEhm[guPolicyItemKindList.size()];
		String unitAmount = "";

		for (int i = 0; i < guPolicyItemKindList.size(); i++) {
			itemKindEhm = new ItemKindEhm();
			if ("0901001".equals(guPolicyItemKindList.get(i).getKindcode())) {
				unitAmount = guPolicyItemKindList.get(i).getUnitamount()
						.toString();
			}
		}
		for (int i = 0; i < guPolicyItemKindList.size(); i++) {
			itemKindEhm = new ItemKindEhm();
			GuPolicyItemKind itemKind = guPolicyItemKindList.get(i);
			itemKindEhm.setKindCode(itemKind.getKindcode());
			itemKindEhm.setKindName(itemKind.getKindname());
			itemKindEhm.setAmount(String.valueOf(itemKind.getAmount()));
			itemKindEhm.setPremium(String.valueOf(itemKind.getActualpremium()));
			itemKindEhm.setRate(String.valueOf(itemKind.getRate()));
			itemKindEhm.setDeductible(String.valueOf(itemKind.getRemark()));
			itemKindEhm.setEachtimelimit(String.valueOf(itemKind.getAmount()));
			if ("0901002".equals(itemKind.getKindcode())) {
				itemKindEhm.setEchLimitAmount(unitAmount);
			} else {
				itemKindEhm.setEchLimitAmount(String.valueOf(itemKind
						.getUnitamount()));
			}
			itemKindEhm.setSumAmountlimit(String.valueOf(itemKind.getAmount()));
			itemKindEhmArray[i] = itemKindEhm;

		}
		// 标的人模块
		insuredSubjectArray = new InsuredSubjectEhm[guPolicyEmployeeList.size()];
		for (int i = 0; i < guPolicyEmployeeList.size(); i++) {
			insuredSubject = new InsuredSubjectEhm();
			insuredSubject.setInsuredObjectPerNo(String.valueOf(i));
			insuredSubject.setInsuredObjectPerName(guPolicyEmployeeList.get(i)
					.getPepName());
			insuredSubject.setInsuredObjectPerIdentifyType("1");
			insuredSubject
					.setInsuredObjectPerIdentifyNumber(guPolicyEmployeeList
							.get(i).getPepIdentityNo());
			insuredSubjectArray[i] = insuredSubject;
		}
		inseuranceSingle.setApplicantEhm(applicantEhm);
		inseuranceSingle.setInsuredEhm(insuredEhm);
		inseuranceSingle.setInsuredSubjectArray(insuredSubjectArray);
		inseuranceSingle.setMainEhm(mainEhm);
		inseuranceSingle.setItemKindEhmArray(itemKindEhmArray);

		AZXInsuranceSingleServicePortType sp = new AZXInsuranceSingleServicePortTypeProxy();
		InsuranceSingleResponse service = new InsuranceSingleResponse();
		service = sp.service(inseuranceSingle);
		return service;
	}

}
