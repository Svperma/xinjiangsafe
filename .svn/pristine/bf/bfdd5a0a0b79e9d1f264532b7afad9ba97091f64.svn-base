<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


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

<title>My JSP 'experresourcecompany.jsp' starting page</title>

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
	<div class="neicont_main_left_cont">
		<div class="neicont_imga">
			<img src="images/icotit2.jpg">查询结果
		</div>
		<div class="neicont_main_left_cont_main">

			<form id="cd" action="${basePath }/exper/scoppage" method="get">
				<table cellpadding="0" cellspacing="0" width="100%" border="0"
					style="margin-top: 10px;">
					<tr class="table_lista">
						<td style="border-top-left-radius: 5px;">序号</td>
						<td>企业名称</td>
						<td>地区</td>
						<td>评估时间</td>
						<td>风险状况</td>
						<td style="border-top-right-radius: 5px;">评估报告</td>
					</tr>
					<c:forEach items="${sessionScope.pagination.resultList }"
						var="Company" varStatus="th">
						<c:if test="${th.index %2 ==0 }">
							<tr class="table_listb">
						</c:if>
						<c:if test="${th.index %2 !=0 }">
							<tr class="">
						</c:if>
						<td>${th.index+1 }</td>
						<td>${Company.COMPANYNAME }</td>
						<td>${Company.PROVINCE }-${Company.CITY }-${Company.COUNTY }</td>
						<td><fmt:formatDate value="${Company.EVALUATDATE }"
								pattern="yyyy-MM-dd" /></td>
						<td><c:if test="${Company.RISKLEVEL == 1}">合格</c:if> <c:if
								test="${Company.RISKLEVEL != 1}">不合格</c:if></td>
						<td><a href="${Company.DOCADDRESS }" target="_blank"
							style="padding:3px 10px;background-color:#00A6E3;color:white;">查看</a>
						</td>
						</tr>
					</c:forEach>
				</table>
				<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
			</form>
			<div
				style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
				<a href="javascript:history.go(-1);" class="table_buttonb"
					style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
			</div>
		</div>
	</div>
</body>
</html>
