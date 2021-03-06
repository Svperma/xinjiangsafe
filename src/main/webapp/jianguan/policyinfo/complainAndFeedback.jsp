<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
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

<title>My JSP 'complainAndFeedback.jsp' starting page</title>

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
	<div class="neicont_main_left_cont">
		<div class="neicont_img">
			<img src="images/icotit1.jpg">投诉及建议选择
		</div>
		<div class="neicont_main_left_cont_main"></div>
		<div class="neicont_main_left_cont">
			<div class="neicont_imga">
				<img src="images/icotit3.jpg">列表
			</div>
			<div class="neicont_main_left_cont_main">
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="evaluate">
					<div class="message_list">
						<div id="control">
							<div class="control_mid">
								<img src="images/tou_01.png" width=40 height=40
									style="float:left;" /> <span class="control_spana"
									style="line-height:40px;">${evaluate.evaluator }：</span> <a>
									<span class="control_spanb">${evaluate.content }</span> <span
									class="control_spana" style="float:right;"><fm:formatDate
											value="${evaluate.evaluateTime }"
											pattern="yyyy年MM月dd日  HH:mm:ss" /></span> <span
									class="control_spanc">+</span>
								</a>
							</div>
						</div>
						<c:forEach items="${evaluate.list }" var="item">
							<div class="message_list">
								<div id="control" style="margin:13px 0 0 20px;">
									<div class="control_mid">
										<img src="images/tou_02.png" width=30 height=30
											style="float:left;" /> <span class="control_spana"
											style="line-height:35px;">${item.evaluator }：</span> <span
											class="control_spanb" style="line-height:35px;">${item.content
											}</span>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
				<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
				<div
					style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
					<a href="javascript:history.go(-1);" class="table_buttonb"
						style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
				</div>
</body>
</html>
