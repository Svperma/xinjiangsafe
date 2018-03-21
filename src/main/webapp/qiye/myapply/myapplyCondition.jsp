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
<title>我的理赔</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<link rel="stylesheet" href="${basePath }/css/etpStyle.css">
<link href="${basePath }/etpcss/bootstrap-combined.min.css"
	rel="stylesheet">
<script type="text/javascript" src="js/select2css.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${basePath }/js/bootstrap-datetimepicker.js"></script>
</head>
<body>
	<div class="maincont">
		<div class="neicont_main_left_cont">
			<div class="neicont_main_left_cont_main">

				<form action="" target="resultFrame" method="post" name="myclaim"
					id="myclaim">
					<!-- <div class="select_list">
						<div id="uboxstyle">
							<select name="languagec" id="languagec">
								<option value="" selected="selected">批单状态</option>
								<option value="0">待审核</option>
								<option value="1">审核</option>
							</select>
							
						</div>
					</div>
					<div class="select_list">
						<div id="uboxstyle">
							<select name="languagec" id="languagec">
								<option value="" selected="selected">首付状态</option>
								<option value="0">已收款</option>
								<option value="1">未收款</option>
							</select>
						</div>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a href="javaScript:check()">查询</a>
					</div>-->
				</form>

				<iframe name="resultFrame" src="/myapply/myapplyInit"
					frameborder="0" style="width:100%;height:80%;"></iframe>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function check() {
			var page = document.forms["myclaim"];
			page.action = "${basePath }/myclaim/myclaimQuery";
			page.submit();
		}
	</script>
</body>
</html>
