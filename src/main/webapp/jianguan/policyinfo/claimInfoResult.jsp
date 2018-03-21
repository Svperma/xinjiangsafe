<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="gc"%>
<jsp:include page="${basePath }/common/include.jsp" />
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

<title>My JSP 'claimInfoResult.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="private">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="neicont_main_left_cont">
		<div class="neicont_imga">
			<img src="images/icotit2.jpg">赔案状况
		</div>
		<div class="neicont_main_left_cont_main">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;">序号</td>
					<td>地区</td>
					<td>已决案件数</td>
					<td>已决赔款（万元）</td>
					<td>未决案件数</td>
					<td>未决赔款（万元）</td>
					<td style="border-top-right-radius: 5px;">援助金（万元）</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }" var="item"
					varStatus="vs">
					<c:if test="${vs.index % 2==0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${vs.index % 2!=0 }">
						<tr>
					</c:if>
					<td>${vs.index+1 }</td>
					<td><a
						href="${basePath }/policyinfo/claimDetail?province=${item.PROVINCE}&city=${item.CITY}&county=${item.COUNTY}"
						class="table_buttone"
						style="color:#000;text-decoration: underline;"> <gc:name
								codeCode="${item.PROVINCE }" codeType="Province"></gc:name> <c:if
								test="${item.CITY != null && item.CITY != '' }">
		  		-<gc:name codeCode="${item.CITY }" codeType="City" />
							</c:if> <c:if test="${item.COUNTY != null && item.COUNTY != '' }">
		  		-<gc:name codeCode="${item.COUNTY }" codeType="County"></gc:name>
							</c:if>
					</a></td>
					<td>${item.PAYCOUNT }</td>
					<td>${item.PAYAMOUNT }</td>
					<td>${item.UNPAYCOUNT }</td>
					<td>${item.UNPAYAMOUNT }</td>
					<td>${item.ASSISTANCE }</td>
				</c:forEach>
			</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
