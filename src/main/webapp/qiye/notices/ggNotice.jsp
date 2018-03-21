<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ggNotice.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<jsp:include page="${basePath }/enterprise/etyinclude.jsp" />

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
#div_back .a_back {
	margin: 0 auto;
	background: #00a6e3;
	color: #fff;
	background-color: #00A6E3;
	width: 60px;
	padding: 5px 20px;
	margin-top: 5px;
}

#tab_notice td {
	font-size: 14px;
}

#tab_notice a {
	font-size: 14px;
	line-height: 30px;
	color: #fff;
	display: block;
	width: 80px;
	height: 27px;
	border-bottom: 1px solid #fff;
	background: #00a6e3;
	margin-left: 30%;
}
</style>

</head>
<body>
	<div class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_main">
			<form action="${basePath }noticeList/noticeContinue" method="GET"
				id="fm" name="fmn">
				<table style="table-layout: fixed;word-wrap:break-word;margin-bottom:100px;"
					width="100%" id="tab_notice">
					<tr class="table_head">
						<td>发布时间</td>
						<td>消息标题</td>
						<td>接收人</td>
						<td>消息内容</td>
						<td>查看</td>
					</tr>
					<c:forEach items="${sessionScope.pagination.resultList }"
						var="ggNotice" varStatus="listSize">
						<c:if test="${listSize.index %2 ==0 }">
							<tr class="table_listb" style="width:100%;">
						</c:if>
						<c:if test="${listSize.index %2 != 0 }">
							<tr class="">
						</c:if>
						<td style="width:15%;"><fmt:formatDate
								value="${ggNotice.PUBLISHTIME }" pattern="yyyy-MM-dd HH:mm" /></td>
						<td style="width:20%;">${ggNotice.TITLE }</td>
						<c:if test="${ggNotice.RECIPIENT eq ggNotice.USERCODE }">
							<td style="width:20%;">${ggNotice.USERNAME }</td>
						</c:if>
						<c:if test="${ggNotice.PUBLISHER eq ggNotice.USERCODE }">
							<td style="width:20%;">${ggNotice.USERNAME }</td>
						</c:if>
						<td
							style="width:35%;text-overflow:ellipsis;overflow:hidden;white-space:nowrap;width:35%;">
							${ggNotice.CONTENTSOURCE }</td>
						<td><a style="cursor:pointer;color:white;width:30%;"
							href="${basePath }/noticeList/noticeDetails?
										seriesNo=${ggNotice.SERIESNO }&
										markRead=${ggNotice.MARKREAD }&
										recipient=${ggNotice.RECIPIENT}">
								查看</a></td>
						</tr>
					</c:forEach>
				</table>
				<div id="div_back">
					<a href="javascript:history.go(-1);" class="a_back">返回</a>
					<jsp:include page="${basePath }/enterprise/etyPagination.jsp"></jsp:include>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
