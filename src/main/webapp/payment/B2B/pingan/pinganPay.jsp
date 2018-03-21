<%@page import="com.sinosoft.utility.date.DateUtils"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<%@ page import="com.sinosoft.application.trafficsafety.dto.domain.*"%>
<%@ page import="com.sinosoft.application.common.ServiceManager"%>
<!-- 平安银行 -->
<%
	String path = request.getContextPath();System.out.println(path);
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + path + "/";

	String orderNo = request.getParameter("orderNO").trim();
	
	String merchantNo = (String) request.getAttribute("merchantNo");//商号
	String userName = (String) request.getAttribute("userName");//收款人账户名
	Date date = new Date();
/* 	String orde_date = new java.text.SimpleDateFormat("yyyy/MM/dd").format(date);//
	String orde_time = new java.text.SimpleDateFormat("HH:mm:ss").format(date); */

	String bussinessNos = request.getParameter("businessNos");
	String[] bussinessNo = bussinessNos.split("-");
	for (int i = 0; i < bussinessNo.length; i++) {
		GpMainOrderDto mainOrder = new GpMainOrderDto();
		mainOrder.setBusinessNo(bussinessNo[i]);
		mainOrder.setMerchantOrderNo(orderNo);
		mainOrder.setMerchantNo( merchantNo); //
		mainOrder.setUpdateTime(DateTime.current());
		ServiceManager.trafficsafety.getGpMainOrderService().insert(mainOrder);
	}
	//
	GpOrderDetailDto gpOrderDetailDto = (GpOrderDetailDto) request.getSession().getAttribute("gpOrderDetailDto");
	GpOrderDetailDto Order = new GpOrderDetailDto();//保单
	Order.setBusinessNo(orderNo);
	Order.setOrderNo(orderNo);
	Order.setDealDate(DateUtils.parse((new java.text.SimpleDateFormat( "yyyyMMdd").format(new Date())),
			DateUtils.YEAR_TO_DAY_NO_HYPHEN)); // 订单日期
			Order.setMerchantNo( merchantNo);
			Order.setOrderCurrency("CNY");
			Order.setOrderAmount(gpOrderDetailDto.getOrderAmount());
	ServiceManager.trafficsafety.getGpOrderDetailService().insert(Order);
	String backUrl = basePath + "trafficsafety/payment/B2B/pingan/pinganPayBack.jsp";
	String backUrlTo = basePath + "pinganPayback";
	String timestamp = new java.text.SimpleDateFormat( "yyyyMMddHHmmssSSS").format(new Date() );
	
/* 	String orig = "masterid=" + "2000000833" +"|orderid=" + orderNo	+ "|currency=RMB|amount=" + String.valueOf(gpOrderDetailDto.getOrderAmount())
			+ "|timestamp=" + timestamp + "|validtime=0|remark="; */
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>平安银行B2B支付</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/common/css/Standard.css" rel="stylesheet" type="text/css">
</head>

<body>
	<form action="/trafficsafety/payment/B2B/pingan/prepareToPingan.jsp"  method=post id="fm" name="fm">
		<!-- 商户订单数据组成的原始数据字符串 -->
		<input type=hidden id="orig" name="orig" value="0">
		<input type=hidden name="masterid" value="<%=merchantNo %>">
		<input type=hidden name="orderid" value='<bean:write name="gpOrderDetailDto" property="orderNo" />'>
		<input type=hidden name="currency" value="RMB">
		<input type=hidden name="amount" value='<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>'>
		<input type=hidden name="timestamp" value="<%=timestamp%>">
		<input type=hidden name="validtime" value="0">
		<input type=hidden name="remark" value="">
		
		<!-- 原始数据字符串的签名	调用银行提供的api对orig签名后得到的字符串 -->
		<input type=hidden id="sign" name= "sign" value="1">
		<!-- 商户接收订单支付结果的URL	(该url所指程序必须存在) -->
		<input type=hidden name= "returnurl" value="<%=backUrl%>">
		<!-- 商户接收订单支付结果服务器通知的url (该url所指程序必须可以接受重复成功结果)-->
		<input type=hidden name= "NOTIFYURL" value="<%=backUrlTo%>">
	</form>


		<table cellpadding="3" cellspacing="1" class="common"
			style="width:90%" align="center">
			<tr>
				<td>正在跳转平安银行支付页面...请稍后</td>
			</tr>
		</table>
		

	</form>
</body>

<script language="javascript">
	
	window.onload =function make(){
		var masterid = document.fm.masterid.value;
		var orderid = document.fm.orderid.value;
//		var currency = document.fm.currency.value;
		var amount = document.fm.amount.value;
		var timestamp = document.fm.timestamp.value;
//		var validtime = document.fm.validtime.value;
//		var remark = document.fm.remark;
		
		var orig = "masterid=" + masterid
					+"|orderid=" + orderid
					+"|currency=RMB|amount=" + amount
					+"|timestamp=" + timestamp
					+"|validtime=0|remark=";
		document.fm.orig.value = orig;
		var subform= document.forms[0]; //获取表单对象
// 		subform.target="_blank";
		subform.target="_self";
		subform.submit();
	}
</script>
</html>

