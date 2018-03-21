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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<base href="<%=basePath%>">
<title>My JSP 'etpMenu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="/css/etpStyle.css">
<script type="text/javascript" src="/js/select2css.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#etymenu a").click(
						function() {
							$("#etymenu span:").css("background",
									"#00a6e3").css("display", "block").css(
									"width:", "100%").css("height", "30px")
									.css("line-height", "31px").css("color",
											"#fff").css("margin", "auto");
							$("#etymenu span:not(span)").css(
									"background", "#b8b8b8");
						})
			})
</script>
<style type="text/css">
#a_back a {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="maincont_mid_cont">
		<div class="maincont_mid_cont_left" id="etymenu">
			<ul id="a_back">
				<li class="tit"><span>业务管理</span></li>
				<c:if test="${ggUser.flag=='1' }">
					<li><a data-url="dsmanager/insertPolicy">投保单录入</a></li>
				</c:if>
				<li><a data-url="dsmanager/getPeoplist">投保单查询</a></li>
				<li><a data-url="dsmanager/getPolicyList">保单查询</a></li>
				<li><a data-url="dsmanager/companyQuery">企业查询</a></li>
				<c:if test="${ggUser.flag=='0' }">
					<c:if test="${ggUser.comLevel=='1' }">
						<li><a data-url="dsmanager/preventive">预防费用查询</a></li>
						<li><a data-url="dsmanager/garbageReportForm">综合报表</a></li>
						<li><a data-url="dsmanager/pingjiaguanli">评价管理</a></li>
						<li><a data-url="dsmanager/prometheus">事故预防费管理</a></li>
						<li><a data-url="dsmanager/conmpanyEdit">企业数量维护</a></li>
					</c:if>
				</c:if>
				<li><a data-url="dsmanager/correctQuery">批单查询</a></li>
				<li><a data-url="dsmanager/claimQuery">理赔查询</a></li>
<!-- 				<li><a data-url="jianguan/experresource/experresourceCondition.jsp">评估机构</a></li> -->
				<c:if test="${ggUser.flag=='0' }">
					<li><a class="neicont_main_left_alinkf" data-url="dsmanager/adminSelect">用户管理</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
<script type="text/javascript">
	var $j = jQuery.noConflict();
	$j(function() {
		$j("#etymenu").find("a").on("click", function() {
			var targetUrl = "${basePath}/" + $j(this).data("url");
			$j(this).attr("href", targetUrl).attr("target", "mainFrame");
			$j(this).parent().siblings().removeClass("hovertit");
			$j(this).parent().attr("class", "hovertit");
		});
	});
</script>
</html>
