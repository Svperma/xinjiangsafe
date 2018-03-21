<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/common/include.jsp" />
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/select2css.js"></script>
<script type="text/javascript" src="js/readXml.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
</head>

<body>
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">查询结果
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/dsmanager/pingjiaContinue" id="fm" method="GET">
			<table cellpadding="0" cellspacing="0" width="100%" border="1"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td>序号</td>
					<td>保险公司</td>
					<td>评价人</td>
					<td>评价内容</td>
					<td>评价分数</td>
					<td>评价时间</td>
					<td>操作</td>
				</tr>
			<c:forEach items="${sessionScope.pagination.resultList }" var="managerList" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
				<tr class="table_listb">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
				<tr class="">
					</c:if>
					<td>${listSize.index+1 }</td>
					<td>${managerList.INSURENAME }</td>
					<td><a style="color: black;" href="/usercorp/details?userCode=${managerList.EVALUATOR }&busi=1&businessNo=">${managerList.PINGJIARENZ }</a></td>
					<td>${managerList.CONTENT }</td>
					<td>${managerList.SCORE }</td>
					<td>${managerList.EVALUATETIME }</td>
					<td><a class="table_buttonb" href="/dsmanager/delPingJia?businessno=${managerList.SERIESNO }"
									style="background-color:#F00;" target="mainFrame">删除</a></td>
				</tr>
				</c:forEach>
			</table>
		<div class="pages">
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</div>
			</form>
		<div style="clear:both;"></div>
	</div>
</body>
</html>
