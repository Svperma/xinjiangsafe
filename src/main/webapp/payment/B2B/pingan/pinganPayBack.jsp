<%@page import="com.sdb.payment.core.MerchantSignVerify"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>平安银行返回结果页面</title>
</head>

<body>
</body>
<%
	String orig = request.getParameter("orig");
	String sign = request.getParameter("sign");
	if(orig==null || "".equals(orig) || sign==null || "".equals(sign)){
		out.println("<br/>平安银行返回信息失败！");
	}
	boolean flag = MerchantSignVerify.merchantVerifyPayGate_ABA(sign, orig);
	if(!orig.endsWith("|") ){
		orig = orig + "|";
	}
	String status_ = orig.substring(orig.indexOf("status=")+"status=".length(), orig.indexOf("|", orig.indexOf("status")));
	String orderid_ = orig.substring(orig.indexOf("orderid=")+"orderid=".length(), orig.indexOf("|", orig.indexOf("orderid")));
	// 判断交易结果状态，进行后续操作
	if ("0".equals(status_) && flag) {
		String amount_ = orig.substring(orig.indexOf("=", orig.indexOf("amount"))+1, orig.indexOf("|", orig.indexOf("amount")));
		out.println("<br>交易成功!<br>商户订单号:" + orderid_ + "<br>金额:" + amount_);
			
	} else if("1".equals(status_)){
		out.println("<br>交易失败!<br>商户订单号:" + orderid_ );
	}
%>


</html>
