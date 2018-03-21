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
				$("#etymenu a:eq(0)").click(
						function() {
							$("#etymenu span:eq(0)").css("background",
									"#00a6e3").css("display", "block").css(
									"width:", "100%").css("height", "30px")
									.css("line-height", "31px").css("color",
											"#fff").css("margin", "auto");
							$("#etymenu span:not(span:eq(0))").css(
									"background", "#b8b8b8");
						})
				$("#etymenu a:lt(4):gt(0)").click(
						function() {
							$("#etymenu span:eq(1)").css("background",
									"#00a6e3");
							$("#etymenu span:not(span:eq(1))").css(
									"background", "#b8b8b8");
						})
				$("#etymenu a:lt(8):gt(3)").click(
						function() {
							$("#etymenu span:eq(2)").css("background",
									"#00a6e3");
							$("#etymenu span:not(span:eq(2))").css(
									"background", "#b8b8b8");
						})
				$("#etymenu a:lt(10):gt(7)").click(
						function() {
							$("#etymenu span:eq(3)").css("background",
									"#00a6e3");
							$("#etymenu span:not(span:eq(3))").css(
									"background", "#b8b8b8");
						})
				$("#etymenu a:lt(11):gt(9)").click(
						function() {
							$("#etymenu span:eq(4)").css("background",
									"#00a6e3");
							$("#etymenu span:not(span:eq(4))").css(
									"background", "#b8b8b8");
						})
				$("#etymenu a:lt(12):gt(10)").click(
						function() {
							$("#etymenu span:eq(5)").css("background",
									"#00a6e3");
							$("#etymenu span:not(span:eq(5))").css(
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
					<li><a data-url="policyUser/insertPolicy">投保单录入</a></li>
				</c:if>
				<li><a data-url="policyUser/mypolicyCondition.jsp">投保单查询</a></li>
				<li><a data-url="policyUser/mycheckCondition.jsp">保单查询</a></li>
				<c:if test="${ggUser.flag=='0' }">
					<li><a class="neicont_main_left_alinkf" data-url="policyUser/adminSelect">用户管理</a></li>
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
