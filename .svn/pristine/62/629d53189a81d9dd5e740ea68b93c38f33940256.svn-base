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
<jsp:include page="${basePath }/enterprise/etyinclude.jsp" />
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="${basePath }/js/calendar/WdatePicker.js"></script>
<style type="text/css">
.maincont_mid_cont_right_top a {
	color: #fff;
	width: 150px;
	height: 31px;
	display: block;
	background-color: #008abd;
	float: left;
	margin-right: 10px;
	line-height: 31px;
}
</style>
</head>
<body>
	<div class="maincont_mid_cont_right" style="height: 80%;">
		<form action="${basePath}/evaluateDangers/selectChecking" name="fml"
			id="fml" target="resultFrame">
			<div class="maincont_mid_cont_right_top">
				<input class="select_list_inputa"
					style="  width: 130px;height:30px;" type="text" maxlength="20"
					value="排查开始日期" name="startDate" id="startDate"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
					onblur="if(!value){value=defaultValue;this.style.color='#999'}"
					onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
					style="color: rgb(153, 153, 153);"> <input
					class="select_list_inputa" style="  width: 150px;height:30px;"
					type="text" maxlength="20" value="排查截止日期" name="endDate"
					id="endDate"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
					onblur="if(!value){value=defaultValue;this.style.color='#999'}"
					onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
					style="color: rgb(153, 153, 153);">
				<div class="select_list">
					<div id="uboxstyle">
						<select name="status" id="status" style="width:100px;">
							<option value="0" selected="selected">待处理</option>
							<option value="1">处理完成</option>
						</select>
					</div>
				</div>
				<div class="select_list" style="margin-left:10px;">
					<a style="width: 80px;" href="javascript:submitCh()">查询</a>
				</div>
				<div class="select_list" style="margin-left:10px;">
					<a style="width: 80px;" href="/qiye/HiddenDanger/addChecking.jsp">添加</a>
				</div>
			</div>
			<iframe name="resultFrame"
				src="${basePath }/qiye/HiddenDanger/dangers.jsp" width="100%"
				frameborder="0" height="100%"></iframe>
		</form>
	</div>
</body>
<script type="text/javascript">
	function submitCh() {
		var fm = document.forms["fml"];
		fm.action = "${basePath}/evaluateDangers/selectChecking";
		fm.submit();
	}
</script>
</html>