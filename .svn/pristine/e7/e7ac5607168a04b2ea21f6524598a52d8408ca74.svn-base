<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/enterprise/etyinclude.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'pagination.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<script type="text/javascript" src="${basePath }/js/pagination.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
</head>

<body>
	<div class="neicont_main_left_cont_main">
		<input type="hidden" id="pageNo" name="pageNo"
			value="${pagination.pageNo }"> <input type="hidden"
			id="pageSize" name="pageSize" value="${pagination.pageSize }">
		<input type="hidden" id="pageCount" name="pageCount"
			value="${pagination.pageCount }">
		<div class="pages">
			<ul>
				<li><a href="javascript:goFirst();">首页</a></li>
				<li><a href="javascript:goBack();">上一页</a></li>
				<c:if test="${pagination.pageCount <= 5 }">
					<c:forEach begin="1" end="${pagination.pageCount }" varStatus="vs">
						<li><a href="javascript:go(${vs.index })">${vs.index }</a></li>
					</c:forEach>
				</c:if>
				<c:if test="${pagination.pageCount >5 }">
					<c:if test="${pagination.pageNo<4 }">
						<li><a href="javascript:go(1)">1</a></li>
						<li><a href="javascript:go(2)">2</a></li>
						<li><a href="javascript:go(3)">3</a></li>
						<li><a href="javascript:go(4)">4</a></li>
						<li><a href="javascript:go(5)">5</a></li>
					</c:if>
					<c:if
						test="${pagination.pageNo-2>1 && pagination.pageNo+2<pagination.pageCount}">
						<li>...</li>
						<li><a href="javascript:go(${pagination.pageNo-2 })">${pagination.pageNo-2
								}</a></li>
						<li><a href="javascript:go(${pagination.pageNo-1 })">${pagination.pageNo-1
								}</a></li>
						<li><a href="javascript:go(${pagination.pageNo })">${pagination.pageNo
								}</a></li>
						<li><a href="javascript:go(${pagination.pageNo+1 })">${pagination.pageNo+1
								}</a></li>
						<li><a href="javascript:go(${pagination.pageNo+2 })">${pagination.pageNo+2
								}</a></li>
						<li>...</li>
					</c:if>
					<c:if test="${pagination.pageNo+2>=pagination.pageCount }">
						<li>...</li>
						<li><a href="javascript:go(${pagination.pageCount-4 })">${pagination.pageCount-4
								}</a></li>
						<li><a href="javascript:go(${pagination.pageCount-3 })">${pagination.pageCount-3
								}</a></li>
						<li><a href="javascript:go(${pagination.pageCount-2 })">${pagination.pageCount-2
								}</a></li>
						<li><a href="javascript:go(${pagination.pageCount-1 })">${pagination.pageCount-1
								}</a></li>
						<li><a href="javascript:go(${pagination.pageCount })">${pagination.pageCount
								}</a></li>
					</c:if>
				</c:if>
				<li><a href="javascript:goForword();">下一页</a></li>
				<li><a href="javascript:goEnd();">尾页</a></li>
				<li><input id="go" type="text" style="width: 60px; height: 24px"/></li>
				<li><a href="javascript:goBySelect();">GO</a></li>
				<li>第${pagination.pageNo }/${pagination.pageCount
					}页;共${pagination.totalCount }条 每页${pagination.pageSize }条</li>
			</ul>
		</div>
	</div>
</body>
</html>
