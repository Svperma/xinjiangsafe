<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sinosoft.application.trafficsafety.dto.domain.GpOrderDetailDto"%>
<%@ page import="com.sinosoft.utility.date.DateUtils"%>
<%@ page import="com.sinosoft.application.common.ServiceManager"%>
<%@ page import="com.sinosoft.application.trafficsafety.dto.custom.GuPolicyDto"%>
<%@ page import="com.sinosoft.application.trafficsafety.dto.domain.*"%>

<%@ page import="com.sinosoft.application.common.mail.SendMail"%>
<%@ page import="com.sinosoft.application.platform.dto.domain.GgInfoConfigDto"%>
<%@ page import="com.sinosoft.application.platform.dto.domain.GgTempletsDto"%>
<%@ page import="com.sinosoft.application.platform.dto.domain.GgUserDto"%>

<%@ page import="com.hitrust.b2b.trustpay.client.b2b.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>银行回调接口</title>
</head>

<body>
	<!-- 跳转成功，给客户的URL -->
	<URL>http://jiaotongbx.cn</URL>
</body>
<%
	//保单ID
	String businessnos = request.getParameter("businessnos");
	//订单业务ID
	String orderNO = request.getParameter("orderno");

	//1、取得MSG参数，并利用此参数值生成交易结果对象
	TrnxResult tResult = new TrnxResult(request.getParameter("MSG"));

	//2、判断交易结果状态，进行后续操作
	if (tResult.isSuccess()) {
		//商户代码
		String MerchantID = tResult.getValue("MerchantID");
		//企业客户代码
		String CorporationCustomerNo = tResult.getValue("CorporationCustomerNo");
		//商户交易编号
		String MerchantTrnxNo = tResult.getValue("MerchantTrnxNo");
		//交易流水号
		String TrnxSN = tResult.getValue("TrnxSN");
		//交易类型
		String TrnxType = tResult.getValue("TrnxType");
		//交易金额	
		String TrnxAMT = tResult.getValue("TrnxAMT");
		//冻结序号	
		String FreezeNo = tResult.getValue("FreezeNo");
		//原冻结序号	
		String OrginalFreezeNo = tResult.getValue("OrginalFreezeNo");
		//付款方帐号	
		String AccountNo = tResult.getValue("AccountNo");
		//付款方帐户名
		String AccountName = tResult.getValue("AccountName");
		//付款方开户行联行号
		String AccountBank = tResult.getValue("AccountBank");
		//收款方帐号
		String AccountDBNo = tResult.getValue("AccountDBNo");
		//收款方帐户名
		String AccountDBName = tResult.getValue("AccountDBName");
		//收款方开户行联行号
		String AccountDBBank = tResult.getValue("AccountDBBank");
		//交易时间	
		String TrnxTime = tResult.getValue("TrnxTime");
		//交易状态
		String TrnxStatus = tResult.getValue("TrnxStatus");

		System.out.println("AccountDBName" + AccountDBName);

		if ("2".equals(TrnxStatus)) {//交易成功
			//更新订单信息
			GpOrderDetailDto gpOrderDetailDto = new GpOrderDetailDto();//回写订单表信息
			gpOrderDetailDto.setBusinessNo(orderNO);
			gpOrderDetailDto.setOrderNo(TrnxSN);//返回信息中的orderNumber--MerchantTrnxNo
			gpOrderDetailDto.setOrderStatus("100");
			try {
				Date date = new Date();
				String orde_date2 = new java.text.SimpleDateFormat( "yyyyMMdd").format(date);//
				gpOrderDetailDto.setDealDate(DateUtils.parse(
						(orde_date2), DateUtils.YEAR_TO_DAY_NO_HYPHEN));

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			gpOrderDetailDto.setMerchantNo(MerchantID);
			gpOrderDetailDto.setOrderCurrency("CNY");
			gpOrderDetailDto.setOrderAmount(Double.valueOf(Double.parseDouble(TrnxAMT)));//订单金额
			gpOrderDetailDto.setPaymentSeriNo("100");
			gpOrderDetailDto.setPaymentAccountNo(AccountNo);  //付款方帐号
			gpOrderDetailDto.setSettleCurrency("CNY");
			gpOrderDetailDto.setSettledAmount(Double.valueOf(Double.parseDouble(TrnxAMT)));
			gpOrderDetailDto.setPaymentName("农行B2B");
			System.out.println("start insert。。。。");
			ServiceManager.trafficsafety.getGpOrderDetailService().insert(gpOrderDetailDto);
			
			GpMainOrderDto gpMainOrderDto = new GpMainOrderDto(); //流水号与保单号对应表
			gpMainOrderDto.setMerchantOrderNo(orderNO); //订单号
			gpMainOrderDto.setMerchantNo("0");  //商户号

			// 缴费成功，回写保单信息

			String[] businessno = businessnos.split("-");
			for (int i = 0; i < businessno.length; i++) {
				
				gpMainOrderDto.setBusinessNo(businessno[i]);  //流水号
				gpMainOrderDto.setUpdateTime(DateTime.current());
				ServiceManager.trafficsafety.getGpMainOrderService().insert(gpMainOrderDto);

				GuPolicyMainDto guPolicyMainDto = new GuPolicyMainDto();//保单主表
				guPolicyMainDto.setBusinessNo(businessno[i]);
				List resultList = ServiceManager.trafficsafety
						.getGuPolicyMainService().find(guPolicyMainDto, null);
				GuPolicyMainDto guPolicyMainDtoTemp = (GuPolicyMainDto) resultList.get(0);
				guPolicyMainDtoTemp.setPayFlag("1");
				guPolicyMainDtoTemp.setPayBillNo(gpOrderDetailDto.getOrderNo());
				guPolicyMainDtoTemp.setSignDate(new Date());  // 出单日期
				guPolicyMainDtoTemp.setActualPremium(guPolicyMainDtoTemp.getSpreadsheetPremium());
				ServiceManager.trafficsafety.getGuPolicyMainService().update(guPolicyMainDtoTemp);

				GuPolicyFeeDto guPolicyFeeDto = new GuPolicyFeeDto();//费用表
				guPolicyFeeDto.setBusinessNo(businessno[i]);
				List feeList = ServiceManager.trafficsafety
						.getGuPolicyFeeService().find(guPolicyFeeDto, null);
				GuPolicyFeeDto guPolicyFeeDtoTemp = (GuPolicyFeeDto) feeList.get(0);
				guPolicyFeeDtoTemp.setActualPremium(guPolicyFeeDtoTemp.getSpreadsheetPremium());
				ServiceManager.trafficsafety.getGuPolicyFeeService().update(guPolicyFeeDtoTemp);

				GuPolicyItemKindDto guPolicyItemKindDto = new GuPolicyItemKindDto();//标的表
				guPolicyItemKindDto.setBusinessNo(businessno[i]);
				try {
					List itemKindList = ServiceManager.trafficsafety
							.getGuPolicyItemKindService().find(guPolicyItemKindDto, null);
					for (int j = 0; j < itemKindList.size(); j++) {
						GuPolicyItemKindDto guPolicyItemKindDtoTemp = (GuPolicyItemKindDto) itemKindList.get(j);
						guPolicyItemKindDtoTemp.setActualPremium(guPolicyItemKindDtoTemp.getSpreadsheetPremium());
						ServiceManager.trafficsafety.getGuPolicyItemKindService().update( guPolicyItemKindDtoTemp);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				//发送邮件
				SendMail sendMail = new SendMail();
				//获取邮箱服务器地址
				GgInfoConfigDto ggInfoConfigDto = new GgInfoConfigDto();
				GgTempletsDto ggTempletsDto = new GgTempletsDto();
				ggTempletsDto.setTempCode("1371191377");// 缴费成功模版，暂时写死
				ggTempletsDto = (GgTempletsDto) ServiceManager.platform.getGgTempletsService().find(ggTempletsDto, null).get(0);
				ggInfoConfigDto.setConId("1369818078");// 德圣邮件服务器
				ggInfoConfigDto = (GgInfoConfigDto) ServiceManager.platform.getGgInfoConfigService().find(ggInfoConfigDto).get(0);
				GgUserDto ggUserDto = (GgUserDto) ServiceManager.platform
						.getGgUserService().findByPrimaryKeyForCode( guPolicyMainDtoTemp.getOperatorCode());
				sendMail.sendHTMLMail(ggInfoConfigDto.getFromAddress(),
						ggInfoConfigDto.getConName(),
						ggUserDto.getEmail(), ggUserDto.getUserCName(),
						ggTempletsDto.getTempTitle(),
						ggTempletsDto.getTempContext(), null);

			}

			//调用 供应前台责任险的接口生成保单
			try {
				for (int i = 0; i < businessno.length; i++) {
					String policy_BusinessNo = (businessno[i]);
					boolean status = ServiceManager.trafficsafety
							.getDutyRiskService()
							.insureLiabilityRequest(policy_BusinessNo,
									"insureLiability", "");
				}
			} catch (Exception e) {
				e.printStackTrace();
				//throw new Exception(e.getMessage());
			}
		}

	}
%>


</html>
