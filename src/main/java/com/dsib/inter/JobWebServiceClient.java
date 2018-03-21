package com.dsib.inter; 


import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.sql.Statement;

import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;


import com.dsib.entity.GcClaim;
import com.dsib.entity.GuPolicyMain;
import com.dsib.inter.BizInfo;
import com.dsib.service.JobWebServiceClientService;
import com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm;
import com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.ApplicantEhm;
import com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.MainEhm;
import com.dsib.webService.AZX.insuranceSingleQuery.dto.xsd.InsuranceSingleQueryRequest;
import com.dsib.webService.AZX.insuranceSingleQuery.dto.xsd.InsuranceSingleQueryResponse;
import com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortType;
import com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortTypeProxy;



public class JobWebServiceClient{

	@Resource(name="JobWebService")
	private JobWebServiceClientService client ;
	
	
	 String dataBaseUser = BizInfo.proread("user"); //数据库用户名;
	String dataBasePass = BizInfo.proread("pass"); //数据库用户密码;
	 String dataBaseDriver = BizInfo.proread("driver"); //数据库驱动;
	 String dataBaseUrl = BizInfo.proread("url");//数据库地址;
	
	 String AZXBaseUser = BizInfo.proread("AZXuser"); //安责险用户名
	 String AZXBasePass = BizInfo.proread("AZXpass"); //安责险密码
	 String AZXBaseDriver = BizInfo.proread("AZXdriver"); //安责险驱动
	  String AZXBaseUrl = BizInfo.proread("AZXurl");//安责险地址
	
	public JobWebServiceClient() {
		//ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()); 
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		//client = (JobWebServiceClientService) context.getBean("JobWebService");
	}

	//保单查询	
	public void quote(){   
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		resultList = client.quotePolicyMain();
		if(resultList.size() != '0'){
		Iterator it = resultList.iterator();
		InsuranceSingleQueryRequest singleQuery = new InsuranceSingleQueryRequest();
		MainEhm mainEhm = new MainEhm();
		ApplicantEhm applicantEhm = new ApplicantEhm();
		while (it.hasNext()) {
			singleQuery.setRequestType("12");
			Map<String,Object> condition = (Map<String, Object>) it.next();
			singleQuery.setPrimaryKey(String.valueOf(condition.get("BUSINESSNO")));
			mainEhm.setSystemCode("AZBX");
			mainEhm.setProposalNo(String.valueOf(condition.get("PROPOSALNO")));
			//mainEhm.setProposalNo("05176501010004B7000139");
			mainEhm.setProposalNoType("01");
			mainEhm.setOperateDate(String.valueOf(condition.get("OPERATEDATE")));
			applicantEhm.setAppliName(String.valueOf(condition.get("APPLINAME")));
			applicantEhm.setIdentifyNumber(String.valueOf(condition.get("BUSINESSLICENSENO")));
			singleQuery.setApplicantEhm(applicantEhm);
			singleQuery.setMainEhm(mainEhm);
			AZXInsuranceSingleQueryServicePortType sp = new AZXInsuranceSingleQueryServicePortTypeProxy();
			InsuranceSingleQueryResponse service = null;
			try {
				service = sp.service(singleQuery);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(service!=null){
			String ResponseCode = service.getResponseCode();//应答标识
			String SendDateTime = service.getSendDateTime();//应答时间
			String RequestType = service.getRequestType();//请求类型
			String ErrorNo = service.getErrorNo();//异常编码
			String ProposalNo = service.getProposalNo();//单号码
			String ProposalState = service.getProposalState();//单号状态
			String CensorContent = service.getCensorContent();//审核未通过原因
			String PrimaryKey = service.getPrimaryKey();//业务号码主键唯一标识
			String SumAmout =service.getSpreadsheetPremium();//总保额
     		String ActualPremium = service.getActualPremium();//总保费
     		if("null".equals(ActualPremium) || StringUtils.isEmpty(ActualPremium)) {
     			ActualPremium = condition.get("SPREADSHEETPREMIUM").toString();
     		}
     		
     		//请求成功
     		if("0".equals(ResponseCode)){
//     		if(!"".equals(CensorContent)||CensorContent!="null"){
     		//审核通过的
			if("1".equals(ProposalState)){
				ItemKindEhm[] itemKindEhm = service.getItemKindEhmarry();
				List<Map<String,Object>> updateKindList = new ArrayList<Map<String,Object>>();
				if(null != itemKindEhm && itemKindEhm.length > 0) {
					for(int y=0 ; y < itemKindEhm.length ;y++){
						ItemKindEhm itemkind =  itemKindEhm[y];
						String kindCode = itemkind.getKindCode();//险种代码
						String KindName = itemkind.getKindName();//险种名称
						String Amount = itemkind.getAmount();//保额
						String Premium = itemkind.getPremium();//保费
						Map<String,Object> updateKind = new HashMap<String, Object>();//传送修改数据附加险种表
						if("0901001".equals(kindCode)){
							updateKind.put("premium", Double.parseDouble(Premium));
						}
						if("0901002".equals(kindCode)){
							updateKind.put("itemKind_one", itemkind.getPremium());
						}
						if("0901003".equals(kindCode)){
							updateKind.put("ittmKind_two", itemkind.getPremium());
						}
						if("0901004".equals(kindCode)){
							updateKind.put("ittmKind_three", itemkind.getPremium());
						}
						if("0901005".equals(kindCode)){
							updateKind.put("ittmKind_four", itemkind.getPremium());
						} 
						updateKind.put("business",PrimaryKey);
						updateKindList.add(updateKind);
					}
				}
				Map<String,Object> updateKind = new HashMap<String,Object>();
//				updateKind.put("business", PrimaryKey);
//				updateKind.put("Premium", Double.parseDouble(ActualPremium));
				
				Map<String,Object> updateMain = new HashMap<String,Object>();
			    updateMain.put("ProposalNo", ProposalNo);
				updateMain.put("ProposalState", "3");
				updateMain.put("CensorContent", CensorContent);
				updateMain.put("SumAmout", SumAmout);
				updateMain.put("ActualPremium", Double.parseDouble(ActualPremium));
				updateMain.put("business", PrimaryKey);
				client.updatePolicyAll(updateMain,updateKind,updateKindList);
			}
			//不通过的
			if("2".equals(ProposalState)) {
				Map<String,Object> censor = new HashMap<String, Object>();
     			censor.put("underdirections", CensorContent);//审核不通过原因
     			censor.put("business", PrimaryKey);
     			censor.put("underwriteflag", "2");
     			client.updateCensor(censor);
			}
			//其他错误原因
     		if("3".equals(ProposalState)) {
//     			Map<String,Object> censor = new HashMap<String, Object>();
//     			censor.put("underdirections", CensorContent);//其他错误原因
//     			censor.put("business", singleQuery.getPrimaryKey());//可能会有没有投保不成功的保单所以响应里没有"primaryKey",就需要用请求里的primaryKey
//     			censor.put("underwriteflag", "6");
//     			client.updateCensor(censor);
     			
     		}
			//调用接口返回错误信息的
     		}else{
//     			System.out.println("请求错误或失败===>" + service.getResponseName());
//     			Map<String,Object> censor = new HashMap<String, Object>();
//     			censor.put("underdirections", service.getResponseName());//接口返回的错误信息
//     			censor.put("business", PrimaryKey);
//     			censor.put("underwriteflag", "0");
//     			client.updateCensor(censor);
     		}
     		//调用接口返回异常信息的
			}else{
//     			Map<String,Object> censor = new HashMap<String, Object>();
//     			censor.put("underdirections", "调用接口失败!");//调用接口异常的信息
//     			censor.put("business", condition.get("BUSINESSNO"));
//     			censor.put("underwriteflag", "0");
//     			client.updateCensor(censor);
			}
		}
		}
	}
	
	public void claim(){
		
		String upmaxdatetime = "";
		
		try {
			Class.forName(dataBaseDriver); // 加载驱动
			Class.forName(AZXBaseDriver);// 加载安责险数据库驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		Connection AZXcon = null;
		PreparedStatement pstmt;
		PreparedStatement pstmtUpdate;
		PreparedStatement pstmtSelect;
		PreparedStatement pstmtInsert;
		
		try {
			//安责险平台数据库链接
			AZXcon = DriverManager.getConnection(AZXBaseUrl, AZXBaseUser, AZXBasePass);
			//向表 GCCLAIM_HISTORY 插入数据
			String insetsql = "INSERT INTO GCCLAIM_HISTORY(BAOANNO,PEIANNO,POLICYNO,LOSSAMOUNT,LOSSCAUSE,LOSSDATE,RISKCODE,"+
						 	  "BUSINESSNO,LOSSLOCAITON,CREATERCODE,CREATEDATE,UPDATORCODE,UPDATEDATE,"+
						      "STATUS,REMARK,FLAG,PROVINCE,CITY,COUNTY,PAYAMOUNT,INSURERCODE,CLOSEDATE,"+
						      "USERCODE,BAOANDATE,LOSSDETAIL,LINKNAME,LINKPHONE)"+
						      "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			int i = 0 ;//用于执行增添语句返回值
			//接口平台连接数据库并对数据进行查询
 			con = DriverManager.getConnection(dataBaseUrl, dataBaseUser, dataBasePass);
			Statement st = con.createStatement();
			String update = BizInfo.proread("upmaxdatetime");
			String sql = "SELECT ID , POLICYNO , REPORTNO , CLAIMNO , STATUS , CENSORCONTENT , ACCEPTANCETIME , " +
						 "UPDATENAME , UPDATETIME , PAYMENTAMOUNT , LOSSAMOUNT , LOSSCAUSE , CLOSEDATE , PREPAYMENTFLAG , " +
						 "PREPAYMENTAMOUNT , FLAG FROM claim WHERE UPDATETIME > '" + update+"' ORDER BY UPDATETIME ";
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				String id = result.getString(1);//id
				String proposalNo = result.getString(2);//保单号 
				String reportNo = result.getString(3);//报案号
				String claimNo = result.getString(4);//赔案号
				String status = result.getString(5);//状态
				String censorContent = result.getString(6);//受理人名称
				String acceptanceTime = result.getString(7);//受理时间
				String updateName = result.getString(8);//更新人名称
				String updateTime = result.getString(9);//更新时间
				String paymentAmount = result.getString(10);//赔付金额
				String lossAmount = result.getString(11);//损失金额
				String lossCause = result.getString(12);//损失原因
				String closeDate = result.getString(13);//结案日期
				String prepaymennFlag = result.getString(14);//是否预赔
				String prepayMentAmount = result.getString(15);//
				String flag = result.getString(16);//预赔金额
				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				GcClaim claim = new GcClaim();
				claim.setBaoAnNo(reportNo);//报案号 怎么 关联业务号
				claim.setPeiAnNo(claimNo);//赔案号
				claim.setPolicyNo(proposalNo);//保单号
				if(!"".equals(lossAmount)){
					claim.setLossAmount(Double.parseDouble(lossAmount));
				}else{
					claim.setLossAmount(Double.parseDouble("0.00"));
				}
				claim.setLossCause(lossCause);
				claim.setRiskCode("0901");
				claim.setBusinessNo(id);
				claim.setLossLocaiton("");
				claim.setCreaterCode(censorContent);//受理人姓名
				claim.setUpDatorCode(updateName);//修改人姓名
				claim.setPayAmount(Double.parseDouble(paymentAmount));
				claim.setStatus(status);//状态查看
				try {
					claim.setLossDate(sim.parse(acceptanceTime.toString()));//损失时间
					claim.setCreateDate(sim.parse(acceptanceTime.toString()));//受理时间
					if(updateTime!=null||!"".equals(updateTime)){
					claim.setUpDateDate(sim.parse(updateTime.toString()));//修改时间
					upmaxdatetime = sim.format(sim.parse(updateTime.toString()));
					}
					if(!"".equals(closeDate)){
					claim.setCloseDate(sim.parse(closeDate.toString()));//结案日期
					}
					if(!"".equals(acceptanceTime)||acceptanceTime != null){
					claim.setBaoanDate(sim.parse(acceptanceTime.toString()));
					}
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pstmt = AZXcon.prepareStatement(insetsql);
				pstmt.setString(1,claim.getBaoAnNo());
				pstmt.setString(2,claim.getPeiAnNo());
				pstmt.setString(3,claim.getPolicyNo());
				pstmt.setDouble(4,claim.getLossAmount());
				pstmt.setString(5,claim.getLossCause());
				pstmt.setDate(6,new java.sql.Date(claim.getLossDate().getTime()));
				pstmt.setString(7,claim.getRiskCode());
				pstmt.setString(8,claim.getBusinessNo());
				pstmt.setString(9,claim.getLossLocaiton());
				pstmt.setString(10,claim.getCreaterCode());
				pstmt.setDate(11,new java.sql.Date(claim.getCreateDate().getTime()));
				pstmt.setString(12,claim.getUpDatorCode());
				if(claim.getUpDateDate()!= null){
					pstmt.setDate(13, new java.sql.Date(claim.getUpDateDate().getTime()));
				}else{
					pstmt.setDate(13, null);
				}
				pstmt.setString(14,claim.getStatus());
				pstmt.setString(15,claim.getRemark());
				pstmt.setString(16,claim.getFlag());
				pstmt.setString(17,claim.getProvince());
				pstmt.setString(18,claim.getCity());
				pstmt.setString(19,claim.getCounty());
				pstmt.setDouble(20, claim.getPayAmount());
				pstmt.setString(21,claim.getInsurerCode());
				if(claim.getCloseDate()!=null){
					pstmt.setDate(22,  new java.sql.Date(claim.getCloseDate().getTime()));
				}else{
					pstmt.setDate(22, null);
				}
				pstmt.setString(23, claim.getUserCode());
				if(claim.getBaoanDate()!=null){
					pstmt.setDate(24,  new java.sql.Date(claim.getBaoanDate().getTime()));
				}else{
					pstmt.setDate(24, null);
				}
				pstmt.setString(25,claim.getLossDetail());
				pstmt.setString(26, claim.getLinkName());
				pstmt.setString(27, claim.getLinkPhone());
				i = pstmt.executeUpdate();
				                                          
				String gcclaimSelect = "SELECT * FROM GCCLAIM WHERE POLICYNO = '" + claim.getPolicyNo() +"'";
				System.out.println("...."+claim.getPolicyNo());
				pstmtSelect = (PreparedStatement)AZXcon.prepareStatement(gcclaimSelect);
				ResultSet rs = pstmtSelect.executeQuery();
				if(rs.next()){
					
					String gcclaimUpdate = " UPDATE GCCLAIM SET BAOANNO = '" + claim.getBaoAnNo() + "' , PEIANNO = '" + claim.getPeiAnNo() + 
											"' , POLICYNO = '" + claim.getPolicyNo() + "' , LOSSAMOUNT = '" + claim.getLossAmount() + "' , LOSSCAUSE = '" + claim.getLossCause() +
											"' ,   RISKCODE = '" + claim.getRiskCode() + "' , BUSINESSNO = '" + claim.getBusinessNo() + 
											"' , LOSSLOCAITON = '" + claim.getLossLocaiton() + "' , CREATERCODE = '" + claim.getCreaterCode() +  
											"' , STATUS = '" + claim.getStatus() + "' , REMARK = '" + claim.getRemark() + "' , FLAG = '" + claim.getFlag() + "' ,  PROVINCE = '" + claim.getProvince() +
											"' , CITY = '" + claim.getCity() + "' ,  COUNTY = '" + claim.getCounty() + "' , PAYAMOUNT = '" + claim.getPayAmount() + "' , INSURERCODE = '" + claim.getInsurerCode() +
											"' , USERCODE = '" + claim.getUserCode() + "' , LOSSDETAIL = '" + claim.getLossDetail() +
											"' , LINKNAME = '" + claim.getLinkName() + "' , LINKPHONE = '" + claim.getLinkPhone() + "'   WHERE POLICYNO= '" + claim.getPolicyNo() + "'";
				
					System.out.println("aa........"+gcclaimUpdate);
					pstmtUpdate = (PreparedStatement) AZXcon.prepareStatement(gcclaimUpdate);
					i = pstmtUpdate.executeUpdate();
				}else{
					String insertGcclaim = "INSERT INTO GCCLAIM(BAOANNO,PEIANNO,POLICYNO,LOSSAMOUNT,LOSSCAUSE,LOSSDATE,RISKCODE,"+
						 	  "BUSINESSNO,LOSSLOCAITON,CREATERCODE,CREATEDATE,UPDATORCODE,UPDATEDATE,"+
						      "STATUS,REMARK,FLAG,PROVINCE,CITY,COUNTY,PAYAMOUNT,INSURERCODE,CLOSEDATE,"+
						      "USERCODE,BAOANDATE,LOSSDETAIL,LINKNAME,LINKPHONE)"+
						      "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmtInsert = AZXcon.prepareStatement(insertGcclaim);
					pstmtInsert.setString(1,claim.getBaoAnNo());
					pstmtInsert.setString(2,claim.getPeiAnNo());
					pstmtInsert.setString(3,claim.getPolicyNo());
					pstmtInsert.setDouble(4,claim.getLossAmount());
					pstmtInsert.setString(5,claim.getLossCause());
					pstmtInsert.setDate(6,new java.sql.Date(claim.getLossDate().getTime()));
					pstmtInsert.setString(7,claim.getRiskCode());
					pstmtInsert.setString(8,claim.getBusinessNo());
					pstmtInsert.setString(9,claim.getLossLocaiton());
					pstmtInsert.setString(10,claim.getCreaterCode());
					pstmtInsert.setDate(11,new java.sql.Date(claim.getCreateDate().getTime()));
					pstmtInsert.setString(12,claim.getUpDatorCode());
					if(claim.getUpDateDate()!= null){
						pstmtInsert.setDate(13, new java.sql.Date(claim.getUpDateDate().getTime()));
					}else{
						pstmtInsert.setDate(13, null);
					}
					pstmtInsert.setString(14,claim.getStatus());
					pstmtInsert.setString(15,claim.getRemark());
					pstmtInsert.setString(16,claim.getFlag());
					pstmtInsert.setString(17,claim.getProvince());
					pstmtInsert.setString(18,claim.getCity());
					pstmtInsert.setString(19,claim.getCounty());
					pstmtInsert.setDouble(20, claim.getPayAmount());
					pstmtInsert.setString(21,claim.getInsurerCode());
					if(claim.getCloseDate()!=null){
						pstmtInsert.setDate(22,  new java.sql.Date(claim.getCloseDate().getTime()));
					}else{
						pstmtInsert.setDate(22, null);
					}
					pstmtInsert.setString(23, claim.getUserCode());
					if(claim.getBaoanDate()!=null){
						pstmtInsert.setDate(24,  new java.sql.Date(claim.getBaoanDate().getTime()));
					}else{
						pstmtInsert.setDate(24, null);
					}
					pstmtInsert.setString(25,claim.getLossDetail());
					pstmtInsert.setString(26, claim.getLinkName());
					pstmtInsert.setString(27, claim.getLinkPhone());
					i = pstmtInsert.executeUpdate();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					Date date = new Date();
					SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					BizInfo.prowrit("upmaxdatetime",sim.format(date));
					
					if(con != null) {
						con.close();
					}
					if(AZXcon != null ) {
						AZXcon.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
	}
	

	
}