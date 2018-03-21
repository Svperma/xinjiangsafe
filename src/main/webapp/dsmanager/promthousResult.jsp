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

<body onload="queryPreventive();">
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">查询结果
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/dsmanager/promthousContinue" id="fm" method="GET">
			<table cellpadding="0" cellspacing="0" width="100%" border="1"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td>序号</td>
					<td>项目名称</td>
					<td>项目负责人</td>
					<td>使用单位</td>
					<td>使用金额</td>
					<td>收款银行</td>
					<td>收款帐号</td>
					<td>状态</td>
				</tr>
			<c:forEach items="${sessionScope.pagination.resultList }" var="managerList" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
				<tr class="table_listb">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
				<tr class="">
					</c:if>
					<td>${listSize.index+1 }</td>
					<td>${managerList.COSTNAME }</td>
					<td>${managerList.PRINCIPAL }</td>
					<td>${managerList.ACCEPTOR }</td>
					<td>${managerList.PAYAMOUNT }</td>
					<td>${managerList.DUEBANK }</td>
					<td>${managerList.SHROFFNUMBER }</td>
					<td><c:if test="${managerList.FLAG == '1' }">已确认</c:if>
					<c:if test="${managerList.FLAG != '1' }">
					<a class="table_buttonb" href="/dsmanager/addpromthous?businessno=${managerList.ID }" target="mainFrame">确认</a>
									</c:if></td>
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
