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
					<input name="POLICYNO" id="POLICYNO" class="select_list_inputa"
						style="height:27px;   width: 150px;" type="text" maxlength="20"
						value="请输入保单号"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: rgb(153, 153, 153);">
					<div class="select_list">
						<div id="uboxstyle">
							<select name="languagec" id="languagec">
								<option value="2" selected="selected">是否结案</option>
								<option value="1">已结案</option>
								<option value="0">未结案</option>
							</select>
						</div>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a href="javaScript:check()">查询</a>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a style="background-color:#390;" href="javascript:queryBaoan();">报案</a>
						<!-- <a style="background-color:#390;" href="/myclaim/myclaimOfInsert">报案</a> -->
					</div>
					<div class="select_list">
						<a href="javaScript:excel()">报表下载</a>
					</div>
				</form>

				<iframe name="resultFrame" src="/myclaim/myclaimInit"
					frameborder="0" style="width:100%;height:80%;"></iframe>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function queryBaoan(){
			var url = "${basePath}/myclaim/myclaimOfQuery";
			$.ajax({
					type : "post",
					url : url,
					data : {},
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						if (data == "isHave") {
// 							alert("申请报案成功！");
							window.location.href = "${basePath}/myclaim/myclaimOfInsert";
						}
						if (data == "meiyouyouxiaobaodanbunengbaoan") {
							alert("没有生效的保险单,不能报案！");
							return;
						}
					},
					error : function() {
						alert("系统出错,请稍后重试！");
					}
				});
		}
	</script>
	<script type="text/javascript">
		function check() {
			var page = document.forms["myclaim"];
			page.action = "${basePath }/myclaim/myclaimQuery";
			page.submit();
		}
		function excel() {
			var exce = document.forms["myclaim"];
			exce.action = "${basePath }/myclaim/myclaimexcel";
			exce.submit();
		}
	</script>
</body>
</html>
