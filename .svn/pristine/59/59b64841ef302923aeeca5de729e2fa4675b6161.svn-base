<%@ page language="java" contentType="text/html; charset=gbk" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<% 
	String signreqmsg = (String)request.getAttribute("signreqmsg");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>中信银行支付页面</title>
</head>
<body onload="submitForm();">
	<form name="form" method="post" action="https://b2b.bank.ecitic.com/cec/gateway.do">
		<!-- 测试  https://ec.test.bank.ecitic.com/cec/gateway.do-->
		<!-- b2b.bank.ecitic.com -->
		<input type="hidden" name="SIGNREQMSG" value="<%=signreqmsg %>" />
	</form>
	
	<script type="text/javascript">
		function submitForm(){
			document.form.submit();
		}
	</script>
</body>
</html>
