<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="${basePath }/css/styleCopy.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/select2cssCopy.js"></script>
</head>
<body onload="mycheck()">
	<div class="maincont">
		<div class="neicont_main_left_cont">
			<div class="neicont_main_left_cont_main">
				<form action="" method="post" id="mycheck" name="mycheck" target="resultFrame">
					<div class="select_list">
						<div id="uboxstyle">
							<select name="languagec" id="languagec" style="background:#fff;">
								<option value="0" selected="selected" style="background:#fff;">请选择评价等级</option>
								<option value="1" style="background:#fff;">好评</option>
								<option value="2" style="background:#fff;">中评</option>
								<option value="3" style="background:#fff;">差评</option>
							</select>
							<input type="hidden" id="riskCode" name="riskCode" value="${riskCode }"/>
							<input type="hidden" id="insurancecode" name="insurancecode" value="${insurancecode }"/>
						</div>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a style=" width: 60px;" href="javaScript:mycheck();">查询</a>
					</div>
				</form>
				<iframe name="resultFrame" src=""
					frameborder="0" style="width:100%;height:80%;"></iframe>
			</div>
		</div>
	</div>
</body>
<script>
	function mycheck() {
		var mycheck = document.forms["mycheck"];
		mycheck.action = "${basePath }/insurePolicy/getPing";
		mycheck.submit();
	}
</script>
</html>
