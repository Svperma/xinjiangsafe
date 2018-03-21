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

<title>My JSP 'addChecking.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="/css/etpStyle.css">
<script src="/js/calendar/WdatePicker.js" type="text/javascript"></script>
<script>
	function changeDiv(x) {
		var m = x.value;
		document.getElementById('br_Cnt' + m).style.display = "";
		if (m == 0) {
			m = 1;
		} else {
			m = 0;
		}
		document.getElementById('br_Cnt' + m).style.display = "none";
	}
</script>
</head>
<body>
	<form action="${basePath }/evaluateDangers/addChecking" name="fma"
		method="POST" style="position:relative;" id="fma"
		enctype="multipart/form-data">
		<div class="maincont_mid_cont_right" style="height: 580px;">
			<div class="maincont_mid_cont_right_top">
				<div class="select_list" style="width: 100%;height: auto;">
					<div id="br_Cnt0" style="width: 100%;">
						<div class="maincont_mid_cont_right_main"
							style="padding: 0;padding-top: 10px;">
							<table>
								<tr class="table_head" align="left">
									<td colspan="3">增加排查记录</td>
								</tr>
								<tr>
									<td>排查内容：</td>
									<td><textarea cols="100" rows="8" name="content"
											id="content"></textarea></td>
								</tr>
								<tr>
									<td>解决方案：</td>
									<td><textarea cols="100" rows="8" name="statusContent"
											id="statusContent"></textarea></td>
								</tr>
								<tr>
									<td>资料上传：</td>
									<td><input class="select_list_inputa"
										style="  width: 200px;" type="file" maxlength="20"
										name="docAddress" id="docAddress"></td>
								</tr>
								<tr>
									<td>整改结束日期：</td>
									<td><input class="select_list_inputa"
										style="  width: 130px;" type="text" maxlength="20"
										value="请输入日期" name="completeDate" id="completeDate"
										onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
										onblur="if(!value){value=defaultValue;this.style.color='#999'}"
										onclick="WdatePicker({minDate:new Date,isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
										style="color: rgb(153, 153, 153);"></td>
								</tr>
								<tr>
									<td colspan="2" style="padding-left:45%;"><a
										style="display:inline-block;width:80px;height:27px;border-radius:0px;"
										href="javascript:addChecking();">提交</a> <a
										style="display:inline-block;width:80px;height:27px;border-radius:0px;"
										href="javascript:history.go(-1);">返回</a></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearboth"></div>
	</form>
	<script>
		function changeColor(o) {
			o.style.color = "red";
		}
		function changeNone(o) {
			o.style.color = "black";
		}
		function addChecking() {
			var content = document.getElementById("content").value;
			var statusContent = document.getElementById("statusContent").value;
			var docAddress = document.getElementById("docAddress").value;
			var completeDate = document.getElementById("completeDate").value;
			if (content == "") {
				alert("排查内容为空，请填写！");
				return;
			} else if (statusContent == "") {
				alert("解决方案为空，请填写！");
				return;
			} else if (docAddress == "") {
				alert("排查资料为空，请上传！");
				return;
			}
			if (completeDate == "请输入日期") {
				alert("整改结束日期为空，请选择！");
				return;
			}
			var sub = document.forms["fma"];
			sub.action = "${basePath }/evaluateDangers/addChecking";
			sub.submit();
		}
	</script>
</body>
</html>