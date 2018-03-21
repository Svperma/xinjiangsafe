<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>My JSP 'ManagerResult.jsp' starting page</title>

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
	<div class="neicont_img">
		<img src="images/icotit1.jpg">条件选择
	</div>
	<div class="neicont_main_left_cont_main">

		<form action="${basePath }/Emergency/emergencylist" name="fm"
			method="get" target="resultFrame">
			<div class="select_list_all">
				<div class="select_list">
					<div id="uboxstyle">
						<select name="emType" id="emType">
							<option value="" selected="selected">选择行业类型</option>
							<c:forEach items="${sessionScope.businessList}" var="code"
								varStatus="st">
								<option value="${code.codeCode }">${code.codeCName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="select_list">
					<div id="uboxstyle">
						<select name="docSource" id="docSource">
							<option value="" selected="selected">文件来源</option>
							<c:forEach items="${sessionScope.sourceList}" var="code2"
								varStatus="st">
								<option value="${code2.codeCode }">${code2.codeCName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="select_list" style="margin-left:40px;">
					<a href="javascript:submitCh()">查询</a>
				</div>
			</div>
		</form>
	</div>
	<iframe name="resultFrame"
		src="${basePath }jianguan/emergency/manager.jsp" width="100%"
		frameborder="0" height="100%"></iframe>
</body>
<script type="text/javascript">
	function submitCh() {
		document.forms["fm"].submit();
	}
</script>
</html>
