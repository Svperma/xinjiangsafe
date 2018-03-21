<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>

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
	<form action="${basePath }/policyinfo/enterpriseDetailContinue"
		name="fm" id="fm" method="get">
		<div class="neicont_imga">
			<img src="images/icotit2.jpg">企业明细
		</div>
		<div class="neicont_main_left_cont_main">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;">序号</td>
					<td>企业名称</td>
					<td>地区</td>
					<td>保险公司名称</td>
					<td>保险期间</td>
					<td>保费（元）</td>
					<td>每人赔偿限额（万元）</td>
					<td style="border-top-right-radius: 5px;">每次事故及累计赔偿限额（万元）</td>
				</tr>
				<c:forEach var="enterprise"
					items="${sessionScope.pagination.resultList }" varStatus="vs">
					<c:if test="${vs.index % 2==0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${vs.index % 2!=0 }">
						<tr>
					</c:if>
					<td>${vs.index+1 }</td>
					<td>${enterprise.COMNAME }</td>
					<td>${enterprise.PROVINCE }-${enterprise.CITY
						}-${enterprise.COUNTY }</td>
					<td>${enterprise.INSURER }</td>
					<td>${enterprise.BETWEENDATE }</td>
					<td>${enterprise.PREMIUM }</td>
					<td>${enterprise.UNITAMOUNT }</td>
					<td>${enterprise.AMOUNT }</td>
					</tr>
				</c:forEach>
			</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
			<div
				style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
				<a href="javascript:history.go(-1);" class="table_buttonb"
					style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
			</div>
		</div>
	</form>
</body>
</html>
