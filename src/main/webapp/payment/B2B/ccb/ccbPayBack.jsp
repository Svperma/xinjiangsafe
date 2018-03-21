<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>建设银行返回页面</title>
</head>

<body>
</body>
<%
	//订单业务ID
	String orderNo = request.getParameter("ORDERID");

	// 判断交易结果状态，进行后续操作 （Y－成功；N－失败；E－客户放弃支付，此时ACC_TYPE字段为空）
	if ("Y".equals(request.getParameter("SUCCESS"))) {
		out.println("<br>交易成功!<br>商户订单号:" + orderNo +　"<br>交易金额:"　+　request.getParameter("PAYMENT");
	} else {
		out.println("<br>交易失败!<br>商户订单号:" + orderNo ;
	}
%>


</html>
