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

<%
	//保单ID
	String businessnos = request.getParameter("businessnos");
	//订单业务ID
	String detailBusinessNo = request.getParameter("orderno");

	//
	//交易流水
	String tranSeq = (String) request.getParameter("tranSeq");
	//交易类型
	String tranCode = (String) request.getParameter("tranCode");
	//订单流水
	String orderSeq = (String) request.getParameter("orderSeq");
	//商户号
	String bocNo = (String) request.getParameter("bocNo");
	//商户订单流水
	String orderNo = (String) request.getParameter("orderNo");
	//币种
	String curCode = (String) request.getParameter("curCode");
	//订单金额
	String orderAmount = (String) request.getParameter("orderAmount");
	//交易费用
	String feeAmount = (String) request.getParameter("feeAmount");
	//交易时间
	String tranTime = (String) request.getParameter("tranTime");
	//交易币种 
	String tranCur = (String) request.getParameter("tranCur");
	//交易金额
	String tranAmount = (String) request.getParameter("tranAmount");
	//交易状态
	String tranStatus = (String) request.getParameter("tranStatus");
	//失败原因
	String errMsg = (String) request.getParameter("errMsg");
	//签名串
	String signData = (String) request.getParameter("signData");

	//交易流水|交易类型|交易状态|交易时间|交易金额|交易费用|商户号|商户订单号|币种
	//tranSeq| tranCode| tranStatus| tranTime| tranAmount| feeAmount| bocNo| orderNo| curCode

	//com.bocnet.common.security.PKCS7Tool tool = com.bocnet.common.security.PKCS7Tool
	//		.getVerifier("E:\\保险项目\\dsib\\中国银行B2B直付商户支付网关接口规范\\中国银行B2B直付商户支付网关接口规范\\pkcs7demo\\BOCCA.cer");
	com.bocnet.common.security.PKCS7Tool tool = com.bocnet.common.security.PKCS7Tool.getVerifier("C:\\\cert02\\bocnetca.cer");
	
	//签名前字符串
	String signStr = tranSeq + "|" + tranCode + "|" + tranStatus + "|"
			+ tranTime + "|" + tranAmount + "|" + feeAmount + "|"
			+ bocNo + "|" + orderNo + "|" + curCode;
	byte[] bSignData = signStr.getBytes();
	int i = 0;
	try {
		//验签名
		tool.verify(signData, bSignData, null);
	} catch (Exception e) {
		i = 1;
		e.printStackTrace();
	} finally {
		if (i == 0 || i == 1) {//验证签名成功,解析返回结果，确定是否缴费成功、更新状态 //有问题 signData为空
			if ("1".equals(tranStatus))//交易成功
			{
				//更新订单信息
				GpOrderDetailDto gpOrderDetailDto = new GpOrderDetailDto();//回写订单表信息
				gpOrderDetailDto.setBusinessNo(detailBusinessNo);
				gpOrderDetailDto.setOrderNo(orderNo);//返回信息中的orderNumber
				gpOrderDetailDto.setOrderStatus("100");
				try {
					gpOrderDetailDto.setDealDate(DateUtils.parse(
							(tranTime.substring(0, 8)),
							DateUtils.YEAR_TO_DAY_NO_HYPHEN));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gpOrderDetailDto.setMerchantNo(bocNo);
				gpOrderDetailDto.setOrderCurrency("CNY");
				gpOrderDetailDto.setOrderAmount(Double.valueOf(Double
						.parseDouble(orderAmount)));//订单金额
				gpOrderDetailDto.setPaymentSeriNo("100");
				gpOrderDetailDto.setSettleCurrency("CNY");
				gpOrderDetailDto.setSettledAmount(Double.valueOf(Double
						.parseDouble(tranAmount)));
				gpOrderDetailDto.setPaymentName("中行B2B");
				System.out.println("start insert。。。。");
				ServiceManager.trafficsafety.getGpOrderDetailService()
						.insert(gpOrderDetailDto);

				// 缴费成功，回写保单信息
				GpMainOrderDto gpMainOrderDto = new GpMainOrderDto(); //流水号与订单号对应表
				gpMainOrderDto.setMerchantNo(bocNo);
				gpMainOrderDto.setMerchantOrderNo(detailBusinessNo);

				String[] businessno = businessnos.split("-");
				for (i = 0; i < businessno.length; i++) {

					gpMainOrderDto.setBusinessNo(businessno[i]);
					gpMainOrderDto.setUpdateTime(DateTime.current());
					ServiceManager.trafficsafety
							.getGpMainOrderService().insert(
									gpMainOrderDto);

					GuPolicyMainDto guPolicyMainDto = new GuPolicyMainDto();//保单主表
					guPolicyMainDto.setBusinessNo(businessno[i]);
					List resultList = ServiceManager.trafficsafety
							.getGuPolicyMainService().find(
									guPolicyMainDto, null);
					GuPolicyMainDto guPolicyMainDtoTemp = (GuPolicyMainDto) resultList
							.get(0);
					guPolicyMainDtoTemp.setPayFlag("1");
					guPolicyMainDtoTemp.setPayBillNo(gpOrderDetailDto
							.getOrderNo());
					guPolicyMainDtoTemp.setSignDate(new Date());
					guPolicyMainDtoTemp
							.setActualPremium(guPolicyMainDtoTemp
									.getSpreadsheetPremium());
					ServiceManager.trafficsafety
							.getGuPolicyMainService().update(
									guPolicyMainDtoTemp);

					GuPolicyFeeDto guPolicyFeeDto = new GuPolicyFeeDto();//费用表
					guPolicyFeeDto.setBusinessNo(businessno[i]);
					List feeList = ServiceManager.trafficsafety
							.getGuPolicyFeeService().find(
									guPolicyFeeDto, null);
					GuPolicyFeeDto guPolicyFeeDtoTemp = (GuPolicyFeeDto) feeList
							.get(0);
					guPolicyFeeDtoTemp
							.setActualPremium(guPolicyFeeDtoTemp
									.getSpreadsheetPremium());
					ServiceManager.trafficsafety
							.getGuPolicyFeeService().update(
									guPolicyFeeDtoTemp);

					GuPolicyItemKindDto guPolicyItemKindDto = new GuPolicyItemKindDto();//标的表
					guPolicyItemKindDto.setBusinessNo(businessno[i]);
					try {
						List itemKindList = ServiceManager.trafficsafety.getGuPolicyItemKindService().find(guPolicyItemKindDto, null);
						for (int j = 0; j < itemKindList.size(); j++) {
							GuPolicyItemKindDto guPolicyItemKindDtoTemp = (GuPolicyItemKindDto) itemKindList.get(j);
							guPolicyItemKindDtoTemp.setActualPremium(guPolicyItemKindDtoTemp.getSpreadsheetPremium());
							ServiceManager.trafficsafety.getGuPolicyItemKindService().update(guPolicyItemKindDtoTemp);
						}
					} catch (Exception e) {
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
					ggInfoConfigDto = (GgInfoConfigDto) ServiceManager.platform
							.getGgInfoConfigService().find(ggInfoConfigDto).get(0);
					GgUserDto ggUserDto = (GgUserDto) ServiceManager.platform.getGgUserService()
							.findByPrimaryKeyForCode( guPolicyMainDtoTemp.getOperatorCode());
					sendMail.sendHTMLMail(
							ggInfoConfigDto.getFromAddress(),
							ggInfoConfigDto.getConName(),
							ggUserDto.getEmail(),
							ggUserDto.getUserCName(),
							ggTempletsDto.getTempTitle(),
							ggTempletsDto.getTempContext(), null);
				}

				//调用 供应前台责任险的接口生成保单
				try {
					for (i = 0; i < businessno.length; i++) {
						String policy_BusinessNo = (businessno[i]);
						boolean status = ServiceManager.trafficsafety
								.getDutyRiskService()
								.insureLiabilityRequest(
										policy_BusinessNo,
										"insureLiability", "");
					}
				} catch (Exception e) {
					e.printStackTrace();
					//throw new Exception(e.getMessage());
				}

			} else {//交易失败
			}
		}
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>银行回调接口</title>
</head>

<body>OK!
</body>
</html>
