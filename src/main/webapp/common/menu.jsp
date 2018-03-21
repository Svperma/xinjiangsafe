<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="include.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="neicont_main">
		<div class="neicont_main_left" id="menu">
			<ul>
				<li class="tit"><span>功能区</span></li>
				<li class="hovertit"><a
					data-url="publish/initDiagram"
					class="neicont_main_left_alinka">公示栏</a></li>
				<li><a class="neicont_main_left_alinkb"
					data-url="usercorp/initPage">企业状况</a></li>
				<li><a class="neicont_main_left_alinke"
					data-url="evaluateDangers/select_riskRatingInfo">安全风险</a></li>
				<li><a class="neicont_main_left_alinkc"
					data-url="policyinfo/policyInfo">保险信息</a></li>
<!-- 				<li><a class="neicont_main_left_alinkh" -->
<!-- 					data-url="jianguan/experresource/experresourceCondition.jsp">评估机构</a></li> -->
				<li><a class="neicont_main_left_alinkh" 
						data-url="policyinfo/getPolicyList">保单查询</a></li>
				<li><a class="neicont_main_left_alinkf"
					data-url="jianguan/commonweal/commonwealCondition.jsp">事故预防</a></li>
					<c:if test="${sessionScope.ggUser.flag == '0' }">
						<li style="border:none;"><a class="neicont_main_left_alinkf"
							data-url="admin/admininit">用户管理</a></li>
					</c:if>
			</ul>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#menu").find("a").on("click", function() {
			$this = $(this);
			var targetUrl = "${basePath}/" + $this.data("url");
			$this.attr("href", targetUrl).attr("target", "mainFrame");
			$this.parent().siblings().removeClass("hovertit");
			$this.parent().attr("class", "hovertit");
		});
	});
</script>
</html>
