<%@page import="com.sinosoft.utility.date.DateUtils"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<%@ page import="com.sinosoft.application.trafficsafety.dto.domain.*"%>
<%@ page import="com.sinosoft.application.common.ServiceManager"%>
<!-- 中信银行 -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String orderNo = request.getParameter("orderNO").trim();
	
	String merchantNo = (String) request.getAttribute("merchantNo");//商号
	String userName = (String) request.getAttribute("userName");//收款人账户名
	Date date = new Date();

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
	
	String backUrl = basePath + "trafficsafety/payment/B2B/ecitic/eciticPayBack.jsp";
	String backUrlTo = basePath + "ECClientPayback";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>中信银行B2B支付</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/common/css/Standard.css" rel="stylesheet" type="text/css">
</head>
<!-- gpOrderDetailDto 订单bean -->
<body>
	<form action="/trafficsafety/payment.do?actionType=eciticPayment" method="post" id="fm" name="fm">

		<!-- 商户编号(银行提供) 10000363-->
		<input name="MCTNO" type="hidden" value="<%=merchantNo %>" />
		<!-- 页面通知地址 -->
		<input name="PCBURL" type="hidden" value="<%=backUrl %>"/>
		<!-- 后台通知地址 -->
		<input name="SCBURL" type="hidden" value="<%=backUrlTo %>"/>

		<!-- 订单号(商户网站生成的不重复号码,最多30位) -->
		<input name="ORDERNO" type="hidden" value='<bean:write name="gpOrderDetailDto" property="orderNo" />'/>
		<!-- 支付金额(商户网站提供)<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/> -->
		<input name="ORDERAMT" type="hidden" value='<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>' />

		<table cellpadding="3" cellspacing="1" class="common"
			style="width:90%" align="center">
			<tr>
				<td>正在跳转到中信银行支付页面...请稍后</td>
			</tr>
		</table>
		

	</form>
</body>

<script language="javascript">
	window.onload =function make(){
		var subform= document.forms[0]; //获取表单对象
		subform.target="_self";
		subform.submit();
	}
</script>
</html>

