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
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" href="/css/etpStyle.css">
<script type="text/javascript" src="/js/select2css.js"></script>
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
<style>
#div_back .a_back {
	display: block;
	margin: 10px auto;
	padding: 5px 20px;
	background: #00a6e3;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	color: #fff;
	width: 60px;
	height: 27px;
}
</style>
</head>
<body>
	<div class="maincont_mid_cont_right" style="height: 580px;">
		<div class="maincont_mid_cont_right_top">
			<div class="select_list" style="width: 100%;height: auto;">

				<div id="br_Cnt0" style="width: 100%;">
					<div class="maincont_mid_cont_right_main"
						style="padding: 0;padding-top: 10px;">
						<table>
							<tr class="table_head" align="left">
								<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;查看排查记录</td>
							</tr>
							<c:forEach items="${checkWrite }" var="chenk">
								<tr style="width:100%;">
									<td style="width:15%;">排查内容：</td>
									<td><textarea readonly="readonly" cols="120" rows="8"
											style="margin: 0px 0px 15px; width: 100%; ">
								${chenk.content }
								</textarea></td>
								</tr>
								<tr style="width:100%;">
									<td>解决方案：</td>
									<td><textarea readonly="readonly" cols="120" rows="8"
											style="margin: 0px 0px 15px; width: 100%; ">
								${chenk.statusContent }
								</textarea></td>
								</tr>
								<tr style="width:100%;">
									<td>整改完成日期：</td>
									<td><input class="select_list_inputa"
										style="  width: 130px;" type="text" maxlength="20"
										disabled="disabled"
										value="<fmt:formatDate value="${chenk.completeDate }" pattern="yyyy-MM-dd"/>"
										onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
										onblur="if(!value){value=defaultValue;this.style.color='#999'}"
										onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
										style="color: rgb(153, 153, 153);"></td>
								</tr>
							</c:forEach>
						</table>
						<div
							style="clear:both;width:100%;padding-top:5px;;margin-bottom:10px;">
							<a href="javascript:history.go(-1);" class="table_buttonb"
								style="width:60px; border-radius:0px;padding:4px 30px;color:white;">返回</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<div class="clearboth"></div>
	<script>
		function changeColor(o) {
			o.style.color = "red";
		}
		function changeNone(o) {
			o.style.color = "black";
		}
	</script>
</body>
</html>
