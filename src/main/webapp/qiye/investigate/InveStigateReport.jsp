<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'InveStigateReport.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="/css/etpStyle.css">
<script type="text/javascript" src="/js/select2css.js"></script>
</head>

<body>
	<div class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_top">
			<form action="${basePath}/subScribe/selectEvaChecking" name="fml"
				id="fml" target="resultFrame">
				<div class="select_list" style="margin-left:0px;"
					style="width:150px;">
					<div id="uboxstyle">
						<select name="userInd" id="userInd">
							<option selected="selected">请选择评估类型</option>
							<c:forEach items="${sessionScope.list_userInd }" var="list">
								<option value="${list.codeCode }">${list.codeCName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="select_list" style="margin-left:10px;width:100px;">
					<a style="  width: 80px;" href="javascript:submitCh()">查询</a>
				</div>
				<div class="select_list" style="margin-left:10px;width:100px;">
					<a style="  width: 80px;"
						href="${basePath }/subScribe/addInveStigate">预约评估</a>
				</div>
				<div class="select_list" style="margin-left:10px;width:100px;">
					<a style="  width: 80px;"
						href="${basePath }evaluateDangers/insertInveStigate?userCode=${sessionScope.ggUser.userCode }">评估录入</a>
				</div>
			</form>
		</div>
		<iframe name="resultFrame"
			src="${basePath }/qiye/investigate/InveStigateContion.jsp"
			width="100%" frameborder="0" height="100%"></iframe>
	</div>
	<br>
</body>
<script type="text/javascript">
	function submitCh() {
		var userInd = document.getElementById("userInd").value;
		if (userInd != "" && userInd != "请选择评估类型") {
			var fm = document.forms["fml"];
			fm.action = "${basePath}/subScribe/selectEvaChecking";
			fm.submit();
		} else {
			alert("请选择查询的评估类型！");
		}

	}
</script>
</html>
