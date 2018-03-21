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
<jsp:include page="${basePath }/common/include.jsp" />
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<html>
<head>
<base href="<%=basePath%>">
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
		<img src="images/icotit2.jpg">查询结果
	</div>
	<div class="neicont_main_left_cont_main">
		<div style="width:20%;float:left;">
			<form id="fm" method="get" action="${basePath }/weal/wealpage">
				<table cellpadding="0" cellspacing="0" width="100%" border="0"
					style="margin-top: 10px;">
					<tr class="table_lista">
						<td colspan="2"
							style="border-top-left-radius: 5px;border-top-right-radius: 5px;">事故预防费</td>
					</tr>
					<tr class="table_listb">
						<td>保费总数：</td>
						<td>${result.PREMMIUM }万元</td>
					</tr>
					<tr>
						<td>应收总额：</td>
						<td>${result.COUNTE }万元</td>
					</tr>
					<tr class="table_listb">
						<td>已收总额</td>
						<td>${result.HAVEINGR }万元</td>
					</tr>
					<tr>
						<td>已使用金额</td>
						<td>${result.USEE }万元</td>
					</tr>
					<tr class="table_listb">
						<td>未使用金额</td>
						<td>${result.HAVEINGR - result.USEE }万元</td>
					</tr>
				</table>
			</form>
		</div>

		<div style="width:78%;float:right;">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;">使用单位</td>
					<td>使用日期</td>
					<td>使用金额(元)</td>
					<td>使用项目名称</td>
					<td style="border-top-right-radius: 5px;">&nbsp;</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="common" varStatus="th">
					<c:if test="${th.index % 2 == 0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${th.index % 2 != 0 }">
						<tr>
					</c:if>

					<td>${common.ACCEPTOR }</td>
					<td><fmt:formatDate value="${common.PAYDATE }"
							pattern="yyyy-MM-dd" /></td>
					<td>${common.PAYAMOUNT }</td>
					<td>${common.COSTNAME }</td>
					<td><a class="table_buttonb"
						href="${basePath }/weal/wealshow?id=${common.ID }">查看</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="pages">
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</div>
		<div style="clear:both;"></div>
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
