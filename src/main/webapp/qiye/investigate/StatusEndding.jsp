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

<title>My JSP 'StatusEndding.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="/css/etpStyle.css">
<script type="text/javascript" src="/js/select2css.js"></script>
<style>
#div_back .a_back {
	margin: 0 auto;
	background: #00a6e3;
	color: #fff;
	background-color: #00A6E3;
	width: 120px;
	padding: 5px 20px;
	margin-top: 50px;
}
</style>
</head>

<body>
	<form action="${basePath }/evaluateDangers/addChecking" name="fma"
		method="POST" style="position:relative;" id="fma"
		enctype="multipart/form-data">
		<div class="maincont_mid_cont">
			<div class="maincont_mid_cont_right">

				<div class="maincont_mid_cont_right_main">
					<table cellpadding="0" cellspacing="0" width="100%" border="0">
						<tr class="table_head">
							<td colspan="2">整改提交</td>
						</tr>
						<tr>
							<td style="border-bottom:1px solid #CCC; font-weight:bold;">整改内容：</td>
							<td
								style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
								<textarea cols="100" rows="10" style="width:90%;"
									name="statusContent" id="statusContent"></textarea>
							</td>
						</tr>
						<tr>
							<td style="border-bottom:1px solid #CCC; font-weight:bold;">资料上传：</td>
							<td
								style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
								<input type="file" name="docAddress" id="docAddress"> <input
								type="hidden" style="width:200px;" value="${StatusEndding.id}"
								name="endId" id="endId">
							</td>
						<tr>
							<td colspan="2" style="height:150px;">
								<div id="div_back">
									<a href="javascript:history.go(-1);" class="a_back">返回</a> <a
										class="a_back" href="javascript:statusSubmit();">提交 </a>
								</div>
							</td>
						</tr>
					</table>

				</div>
			</div>
			<div class="clearboth"></div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function statusSubmit() {
		var statusContent = document.getElementById("statusContent").value;
		var docAddress = document.getElementById("docAddress").value;
		if (statusContent == "") {
			alert("请输入整改内容！");
			return;
		}
		if (docAddress == "" || docAddress == null || docAddress == "未选择任何文件") {
			alert("请上传整改资料！");
			return;
		}
		var sub = document.forms["fma"];
		sub.action = "${basePath }/subScribe/statusSubmit";
		sub.submit();
	}
</script>
</html>
