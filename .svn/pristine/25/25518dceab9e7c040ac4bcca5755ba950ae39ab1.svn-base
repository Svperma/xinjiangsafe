<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String configFile = (String) request.getAttribute("configFile");
	String businessNo = (String) request.getAttribute("businessNo");
	String accountNo = (String) request.getAttribute("accountNo");
	String merchantNo = (String) request.getAttribute("merchantNo");
	
	
%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/common/css/Standard.css" rel="stylesheet" type="text/css">
<title>直接商户-协议支付</title>
<script language="javascript">
	function subAuthForm() {
//		createOrderInfo();
	//	var url = "/trafficsafety/payment/B2B/bankcomm/Demo/sell/WEBDirectMerOrder.jsp";
		//window.open(url, "", "height=600,width=800,status=yes,toolbar=no,menubar=no,location=no,left=80");
		fm.submit();
	}
	function createOrderInfo() {
		var tmpDate = new Date();
		var day = tmpDate.getDate();
		var month = tmpDate.getMonth() + 1;
		var year = tmpDate.getYear();
		var hours = tmpDate.getHours()
		var minutes = tmpDate.getMinutes()
		var seconds = tmpDate.getSeconds()

		month = ((month < 10) ? "0" : "") + month;
		day = ((day < 10) ? "0" : "") + day;
		hours = ((hours < 10) ? "0" : "") + hours;
		minutes = ((minutes < 10) ? "0" : "") + minutes;
		seconds = ((seconds < 10) ? "0" : "") + seconds;

		document.all.merchant_order_no.value = year + month + day + hours
				+ minutes + seconds;

	}
</script>
</head>

<body onload="subAuthForm();">

	<html:form action="/trafficsafety/payment.do?actionType=payment">
			<input name="businessNo" type="hidden" value="<%=businessNo%>" />
			<%-- 保单业务号码--%>
			<input name="merchant_no" type="hidden" maxlength="15"
				value="<%=merchantNo%>" />
			<%-- 商户编号--%>
			<input name="configFile" type="hidden" value="<%=configFile%>" />
			<%-- 配置文件--%>
			<input name="rec_acc_no" type="hidden" maxlength="21"
				value="<%=accountNo%>" />
			<%-- 收款账号--%>
			<input name="order_mode" type="hidden" maxlength="2" value="10" />
			<%-- 订单模式号--%>
			<input name="order_currency" type="hidden" maxlength="10" value="CNY" />
			<%-- 订单币别--%>
			<input name="rec_bank_type" type="hidden" maxlength="2" value="01"/>
			<%-- 收款帐户类型--%>
			<input name="pay_mode" type="hidden" maxlength="2" value="02"/>
			<%-- 付款模式  02：授权付款--%>

			<!-- 商户检索号 -->

			<input name="merchant_order_no" type="hidden" maxlength="30" value="<bean:write name="gpOrderDetailDto" property="orderNo" />"/>
			<input type="hidden" name="order_amount" maxlength="15" class="w60" value="<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>"  />
	</html:form>
</body>
</html>

