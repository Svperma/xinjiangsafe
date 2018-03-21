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
<base href="<%=basePath%>">

<title>My JSP 'MyConsultContion.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<div style="height:180%;" class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_main">
			<form action="${basePath }/myConsult/myConsultContinue" id="fm"
				name="fm" method="GET">
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="myConsult" varStatus="list">
					<c:if test="${myConsult.attributeId eq '5' }">
						<ul class="tousu">
							<li style="color: #999;"><span>咨询人：</span> <span
								style="color:blue;">${myConsult.beEvaluator }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span>咨询对象：</span> <span style="color:blue;">${myConsult.evaluator
									}</span> <span style="float:right;color:blue;"> <fmt:formatDate
										value="${myConsult.evaluateTime }" pattern="yyyy-MM-dd" />
							</span></li>
							<li style="color: #999;"><span>咨询内容：${myConsult.content
									}</span></li>
							<c:forEach items="${myConsult.list }" var="evalist">
								<c:choose>
									<c:when
										test="${evalist.evaluator == sessionScope.ggUser.userName }">
										<li><span style="color:#333333;">回复：${evalist.content
												}</span> <span style="color: #333333; float:right;"> <fmt:formatDate
													value="${evalist.evaluateTime }" pattern="yyyy-MM-dd" />
										</span></li>
									</c:when>
									<c:otherwise>
										<li><span style="color:#f26422;">回复：${evalist.content
												}</span> <span style="color: #f26422; float:right;"> <fmt:formatDate
													value="${evalist.evaluateTime }" pattern="yyyy-MM-dd" />
										</span></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${myConsult.attributeId eq '3' }">
						<ul class="tousu">
							<li style="color: #999;"><span>投诉人：</span> <span
								style="color:blue;">${myConsult.beEvaluator }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span>投诉对象：</span> <span style="color:blue;">${myConsult.evaluator
									}</span> <span style="float:right;color:blue;"> <fmt:formatDate
										value="${myConsult.evaluateTime }" pattern="yyyy-MM-dd" />
							</span></li>
							<li style="color: #999;"><span>投诉内容：${myConsult.content
									}</span></li>
							<c:forEach items="${myConsult.list }" var="evalist">
								<c:choose>
									<c:when
										test="${evalist.evaluator == sessionScope.ggUser.userName }">
										<li><span style="color:#333333;">回复：${evalist.content
												}</span> <span style="color: #333333; float:right;"> <fmt:formatDate
													value="${evalist.evaluateTime }" pattern="yyyy-MM-dd" />
										</span></li>
									</c:when>
									<c:otherwise>
										<li><span style="color:#f26422;">回复：${evalist.content
												}</span> <span style="color: #f26422; float:right;"> <fmt:formatDate
													value="${evalist.evaluateTime }" pattern="yyyy-MM-dd" />
										</span></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</c:if>
				</c:forEach>
				<jsp:include page="${basePath }/enterprise/etyPagination.jsp" />
			</form>
		</div>
	</div>
</body>
</html>
