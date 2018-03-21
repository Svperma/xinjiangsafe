<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ page import="com.bocom.api.core.BOCOMSignServer"%>

<%
String B2BSignData = (String)request.getAttribute("B2BSignData");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script language="javascript">
function subAuthForm(){
	document.payForm.submit();
}
</script>
</head>
<body onLoad = "subAuthForm();">
<form  name ="payForm" method="post" action="https://ebank.95559.com.cn/corporbank/B2BOrder" >
<!-- <form  name ="payForm" method="post" action="https://61.172.242.229/corporbank/B2BOrder" >-->
<input type="hidden" name="B2BSignData" value="<%=B2BSignData%>"/>
</form>
</body>
</html>
