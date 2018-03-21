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

<title>我的保单</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="qiyecss/stylesheet.css">
<script type="text/javascript" src="js/select2css.js"></script>
</head>
<body>
	<div class="maincont">
		<div class="neicont_main_left_cont">
			<div class="neicont_main_left_cont_main">
				<form action="" method="post" id="mycheck" name="mycheck"
					target="resultFrame">
					<input id="POLICYNO" name="POLICYNO" class="select_list_inputa"
						style="height: 28px;  width: 150px;" type="text" maxlength="20" value="请输入保单号"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: rgb(153, 153, 153);">
					<div class="select_list">
						<div id="uboxstyle">
							<select name="languagec" id="languagec" style="background:#fff;">
								<option value="" selected="selected" style="background:#fff;">请选择保单状态</option>
								<option value="1" style="background:#fff;">有效</option>
								<option value="0" style="background:#fff;">过期</option>
							</select>
						</div>
					</div>
					<div class="select_list">
						<div id="uboxstyle">
							<select name="languageb" id="languageb" style="background:#fff;">
								<option value="" selected="selected" style="background:#fff;">请选择业务归属</option>
								<option value="1" style="background:#fff;">保险公司业务</option>
								<option value="0" style="background:#fff;">其他业务</option>
							</select>
						</div>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a style=" width: 60px;" href="javaScript:mycheck();">查询</a>
					</div>
					<div class="select_list">
						<a class="select_list_alink" style="cursor: pointer;" onclick="goBBBBB()">批量导入保单</a>
					</div>
<!-- 					<div class="select_list"> -->
<!-- 						<a href="javaScript:mycheckExcel();">报表下载</a> -->
<!-- 					</div> -->
				</form>
				<iframe name="resultFrame" src="/policyUser/mycheckqueryPolicy"
					frameborder="0" style="width:100%;height:80%;"></iframe>
			</div>
		</div>
	</div>
</body>
<script>
	function mycheck() {
		var mycheck = document.forms["mycheck"];
		mycheck.action = "${basePath }/policyUser/mycheckqueryPolicy";
		mycheck.submit();
	}
// 	function mycheckExcel() {
// 		var mycheckl = document.forms["mycheck"];
// 		mycheckl.action = "${basePath }/mycheck/mycheckToExcel";
// 		mycheckl.submit();
// 	}
	function goBBBBB(){
		var url = "${basePath }/policyUser/goBBBBB";
		var form = document.forms["mycheck"];
		form.action = url;
		form.target = "mainFrame";
		form.submit();
	}
</script>
</html>
