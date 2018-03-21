<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'experresourceShow.jsp' starting page</title>

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
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">机构详情
	</div>
	<div class="neicont_main_left_cont_main">
		<div style="width:49.5%;float:left;">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td
						style="border-top-left-radius: 5px;border-top-right-radius: 5px;padding-left:20px;"
						colspan="2">机构信息</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">机构名称：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.ORGNAME
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">机构等级：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.GRADE
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">负责人：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.ORGOWNER
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">联系方式：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.GOPHONE
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">地址：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.ADDRESS
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">省：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.PROVINCE
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">市：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.CITY
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">区县：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.COUNTY
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">组织机构代码：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;">${resulteList.ORGCODE
						}</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;" rowspan="5">组织机构影像文件：</td>
					<td style="border-bottom:#9CF 1px solid;text-align:left;"
						rowspan="5"><img src="${resulteList.PHOTO }"></td>
				</tr>
			</table>
		</div>
		<div style="width:49.5%;float:right;">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td colspan="4"
						style="border-top-left-radius: 5px;border-top-right-radius: 5px;">人员信息</td>
				</tr>
				<tr>
					<td style="border-bottom:#9CF 1px solid;">姓名</td>
					<td style="border-bottom:#9CF 1px solid;">性别</td>
					<td style="border-bottom:#9CF 1px solid;">联系方式</td>
					<td style="border-bottom:#9CF 1px solid;">证件号</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList}"
					var="expert" varStatus="th">
					<tr>
						<td style="border-bottom:#9CF 1px solid;">${expert.EXPERNAME
							}</td>
						<td style="border-bottom:#9CF 1px solid;"><c:if
								test="${expert.SEX == 0 }"> 未说明</c:if> <c:if
								test="${expert.SEX == 1 }">  男 	</c:if> <c:if
								test="${expert.SEX == 2 }">  女      </c:if></td>
						<td style="border-bottom:#9CF 1px solid;">${expert.GUPHONE }</td>
						<td style="border-bottom:#9CF 1px solid;">${expert.IDNUMBER }</td>
					</tr>
				</c:forEach>
			</table>
			<div class="pages">
				<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
			</div>
		</div>
		<div
			style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
			<a href="javascript:history.go(-1);" class="table_buttonb"
				style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		function addUser() {
			var div = $("#addUser");
			var divHeight = div.height();
			var divWidth = div.width();
			var divTop = ($(window).height() - divHeight) / 2;
			var divLeft = ($(window).width() - divWidth) / 2;
			div.css({
				"top" : divTop,
				"left" : divLeft,
				"display" : "block"
			});
		}
		function close() {
			$("#addUser").css({
				"display" : "none"
			});
		}
	</script>
</body>
</html>
