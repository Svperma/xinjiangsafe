<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/enterprise/etyinclude.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'top.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="${basePath }/css/etpStyle.css">
</head>

<body>
	<div class="neicont_head">
		
		<ul style="width: 500px;">
			<!-- <li style="width:90px;"><a style="width:90px;" class="menua"
				href="http://baodan.jiaotongbx.cn:8080/agriculture/web_index/index.html">首页</a></li> -->
			<li style="width:180px;margin-top: 25px;"></li>
			<li style="width:90px;"><a style="width:90px;" class="menud"
				href="javascript:outLogin();">退出</a></li>
		</ul>
		<ul style="width: 280px;">
			<li style="width: 100%;"><a style="color: blue;width: 100%;text-decoration: underline;" 
			 target="mainFrame">欢迎您：${sessionScope.ggUser.userName }</a></li>
		</ul>
	</div>
</body>
<script type="text/javascript">
function outLogin() {
		var conf = window.confirm("确定退出？");
		if (conf == true) {
			self.parent.location.href = "${basePath}/user/outServlet";
		}
	}
</script>
</html>
