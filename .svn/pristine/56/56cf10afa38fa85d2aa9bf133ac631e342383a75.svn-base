<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<jsp:include page="include.jsp"></jsp:include>
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
</head>

<body>
	<div class="neicont_head">
		<ul style="width: 360px;">
			<!-- <li style="width:90px;"><a style="width:90px;" class="menua"
				href="http://baodan.jiaotongbx.cn:8080/agriculture/web_index/index.html">首页</a></li> -->
			<li style="width:90px;"><a style="width:90px;"
				style="width:75px;" class="menub"
				href="${basePath }noticeList/querySendNotice" target="mainFrame">
					<span id="notices" style="color:red;"> ${notices } </span>消息中心
			</a></li>
			<li style="width:90px;"><a style="width:90px;" class="menuc"
				href="${basePath }user/personalCenter" target="mainFrame">个人信息</a></li>
			<li style="width:90px;"><a style="width:90px;" class="menud"
				href="javascript:outLogin();">安全退出</a></li>
		</ul>
		<ul style="width: 280px;">
			<li style="width: 100%;"><a style="color: blue;width: 100%;text-decoration: underline;" 
			href="${basePath }user/personalCenter" target="mainFrame">欢迎您：${sessionScope.ggUser.userName }</a></li>
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
