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
<!DOCTYPE HTML>
<jsp:include page="${basePath }/enterprise/etyinclude.jsp" />
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ggNoticeDetails.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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

#div_back {
	text-align: center;
	line-height: 20px;
}
</style>
<script type="text/javascript">
	function sendMsg() {
		var publisher = document.getElementById("pub").value;
		var recipient = document.getElementById("rec").value;
		var usercode = document.getElementById("code").value;
		var status = document.getElementById("mrinp").value;
		if (publisher != usercode) {
			if (status == 0) {
				var span = window.top.frames["topFrom"].document
						.getElementById("topNotices");
				span.innerHTML = span.innerHTML - 1;
			}
		}
	}
</script>
</head>

<body onload="sendMsg()">
	<form action="${basePath }noticeList/noticeDetails" method="GET"
		target="fmn">
		<div class="neicont_main_left_cont_main">
			<div class="neicont_imga">
				<img src="${basePath }/images/icotit2.jpg">通知消息详情
			</div>
			<div class="neicont_main_left_cont_main">
				<c:forEach items="${sessionScope.oneNotice }" var="oneNotice">
					<input style="display:none;" id="mrinp"
						value="${oneNotice.MARKREAD }" />
					<input style="display:none;" id="pub"
						value="${oneNotice.PUBLISHER }" />
					<input style="display:none;" id="rec"
						value="${oneNotice.RECIPIENT }" />
					<input style="display:none;" id="code"
						value="${sessionScope.ggUser.userCode }" />
					<div></div>
					<div></div>

					<div class="table_listb"
						style="text-align:left;display:block;font-size:18px;width:100%;">
						<span style="color:black;font-weight: bold;">发布时间：</span> <span
							style="color:black;margin-left: 30px;"> <fmt:formatDate
								value="${oneNotice.PUBLISHTIME }" pattern="yyyy-MM-dd HH:mm:ss" />
						</span>
					</div>
					<div
						style="text-align:left;display:block;font-size:18px;width:100%;">
						<span style="color:black;font-weight: bold;">发布人：</span> <span
							style="color:black;margin-left: 50px;">${oneNotice.USERNAME
							} </span>
					</div>
					<div class="table_listb"
						style="text-align:left;display:block;font-size:18px;color:black;width:100%;">
						<span style="color:black;font-weight: bold;">消息标题：</span> <span
							style="color:black;margin-left: 30px;">${oneNotice.TITLE }</span>
					</div>
					<div
						style="text-align:left;display:block;font-size:18px;color:black;width:100%;">
						<span style="color:black;font-weight: bold;">消息内容：</span>
					</div>
					<div class="table_listb"
						style="text-align:left;display:block; font-size:18px;word-break:normal;overflow-wrap: break-word;width:1330px;">
						<span
							style="color:black;display:block; font-size:18px;word-break:normal;overflow-wrap: break-word;margin-left: 125px;">${oneNotice.CONTENTSOURCE
							}</span>
					</div>
				</c:forEach>
				<div id="div_back">
					<%-- <a href="${basePath }/noticeList/selectNotice
						?reci=1&startNoticeDate=请输入开始日期&endNoticeDate=请输入截止日期&Readtype=0" class="a_back" target="">返回</a> --%>
					<a href="javascript:history.go(-1);" class="a_back">返回</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
