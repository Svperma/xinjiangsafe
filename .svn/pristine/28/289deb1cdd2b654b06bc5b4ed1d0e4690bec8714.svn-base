<%@page import="com.sdb.payment.core.MerchantSignVerify,java.util.*"%>
<%@page language="java" contentType="text/html;charset=gbk"%>
<%
	request.setCharacterEncoding("GBK");
	// 商家设置用户购买商品的支付信息
	String orig = request.getParameter("orig");
	String sign = MerchantSignVerify.merchantSignData_ABA(orig);
	String returnurl = request.getParameter("returnurl");
	String NOTIFYURL = request.getParameter("NOTIFYURL");
%>
<html>
	<head>
		<title>正在跳转平安银行支付页面...请稍后
		</title>
	</head>
	<body>
		<form id="fm" name="fm" action='https://ebank.sdb.com.cn/corporbank/merpayb2b.do' method='POST' target="_self">
			<!-- testebank.sdb.com.cn:461 -->
			<!-- ebank.sdb.com.cn -->
			<input type=hidden name="orig" value="<%=orig %>">
			<input type=hidden name= "sign" value="<%=sign %>">
			<input type=hidden name= "returnurl" value="<%=returnurl%>">
			<input type=hidden name= "NOTIFYURL" value="<%=NOTIFYURL%>">
			
		</form>
	</body>
	<script type="text/javascript">
	window.onload=function(){
 		document.forms[0].target="_self"
	  	document.forms[0].submit();
	}
	</script>
</html>
