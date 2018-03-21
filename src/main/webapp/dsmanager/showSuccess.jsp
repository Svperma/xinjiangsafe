<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body>
	<div
		style="width:100%;height:100%;background:#fff;padding:50px 0px;text-align:center;">
		<div style="width:20%;height:20%;margin:0 auto;">
			<img src="${basePath }/images/duihao.png" style="width:75%;" />
		</div>
		<div style="width:100%;height:20%;text-align:center;padding:50px 0px">
			<h4>操作成功</h4>
		</div>
	</div>
</body>
</html>
