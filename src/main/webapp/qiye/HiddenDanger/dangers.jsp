<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>首页</title>

<script type="text/javascript" src="/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/css/WdatePicker.css">

</head>
<body>
	<div class="maincont_mid_cont_right_main"
		style="padding: 0;padding-top: 10px;">
		<form action="${basePath }/evaluateDangers/CheckingContinue" id="fm"
			name="fm" method="GET">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="float: left;margin-top: 20px;text-align:center;">
				<tr class="table_head" style="text-align:center;">
					<td>序号</td>
					<td colspan="3">排查内容</td>
					<td>排查人</td>
					<td>排查时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="ggSub" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
						<tr class="table_mid">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
						<tr class="">
					</c:if>
					<td colspan="3">${listSize.index+1 }</td>
					<td><a href="${ggSub.DOCADDRESS }"
						style="color:red;text-decoration: underline;" target="_blank">${ggSub.CONTENT
							}</a></td>
					<td>${ggSub.EVALUATOR }</td>
					<td><fmt:formatDate value="${ggSub.EVALUATDATE }"
							pattern="yyyy-MM-dd" /></td>
					<td style="width:200px;"><a
						href="${basePath }/evaluateDangers/CheckingDetails?id=${ggSub.ID}"
						style="display:inline-block;width:60px;height:27px;padding:3px 8px; margin:0px;background:#00a6e3;"
						target="mainFrame">查看 </a></td>
					</tr>
				</c:forEach>
			</table>
			<jsp:include page="${basePath }/enterprise/etyPagination.jsp" />
		</form>
	</div>
	<script>
		function changeColor(o) {
			o.style.color = "red";
		}
		function changeNone(o) {
			o.style.color = "black";
		}
	</script>
</body>
</html>
