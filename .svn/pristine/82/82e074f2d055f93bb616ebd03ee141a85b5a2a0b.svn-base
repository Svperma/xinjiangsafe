<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>My JSP 'commonwealShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/select2css.js"></script>
<script type="text/javascript" src="js/readXml.js"></script>
</head>

<body>
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">事故预防费使用
	</div>
	<div class="neicont_main_left_cont_main">
		<table cellpadding="0" cellspacing="0" width="70%" border="0"
			style="margin: 10px auto;">
			<tr class="table_lista">
				<td style="border-top-left-radius: 5px;" colspan="2">&nbsp;</td>
				<td style="border-top-right-radius: 5px;" colspan="2">&nbsp;</td>
			</tr>
			<tr class="table_listb">
				<td>项目名称：</td>
				<td>
					<div class="select_list">
						<div id="uboxstyle">${sessionScope.resMap.COSTNAME }</div>
					</div>
				</td>
				<td>使用金额：</td>
				<td>
					<div class="select_list" style="width: 200px;">
						${sessionScope.resMap.PAYAMOUNT }元</div>
				</td>
			</tr>
			<tr>
				<td>使用时间：</td>
				<td><fmt:formatDate value="${sessionScope.resMap.PAYDATE }"
						pattern="yyyy-MM-dd" /></td>
				<td>项目负责人：</td>
				<td>
					<div class="select_list" style="width: 200px;">
						${sessionScope.resMap.PRINCIPAL }</div>
				</td>
			</tr>
			<tr>
				<td>收款银行：</td>
				<td>
					<div class="select_list" style="width: 200px;">
						${sessionScope.resMap.DUEBANK }</div>
				</td>
				<td>收款账号：</td>
				<td>
					<div class="select_list" style="width: 200px;">
						${sessionScope.resMap.SHROFFNUMBER }</div>
				</td>
			</tr>
			<tr>
				<td>使用证明：</td>
				<td>
					<div class="select_list" style="width: 200px;">
						<c:if test="${not empty sessionScope.resMap.USERPROVE }">
							<a href="${sessionScope.resMap.USERPROVE }"
								style="width:80px; border-radius:5px;padding:2px 25px;color:white;"
								class="table_buttonb" target="_blank">证明查看</a>
						</c:if>
						<c:if test="${empty sessionScope.resMap.USERPROVE }">
              		暂无证明
              		</c:if>
					</div>
				</td>
				<td>使用单位</td>
				<td>
					<div class="select_list" style="width: 200px;">
						${sessionScope.resMap.ACCEPTOR }
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div
						style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
						<a href="javascript:history.go(-1);" class="table_buttonb"
							style="width:120px; border-radius:5px;padding:4px 30px;color:white;">返回</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
