<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%> --%>
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

<title>My JSP 'addInveStigate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/css/etpStyle.css">
<link href="/css/bootstrap-combined.min.css" rel="stylesheet">
<script type="text/javascript"
	src="${basePath }/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
</head>
<body>
	<div class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_top">
			<div class="select_list_all">
				<form action="${basePath }/organ/govOrganOrGovExpert" name="fm"
					id="fm" method="GET" target="resultFrame">
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							style="height:30px;" value="请输入要查询的机构或专家" name="orgName"
							id="orgName"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="width:130;">
						<div id="uboxstyle">
							<select name="orgClass" id="orgClass"
								style="float:left;margin-right: 10px;width:130;">
								<option>请选择等级</option>
								<option value="1">国家级</option>
								<option value="2">省级</option>
								<option value="3">市级</option>
								<option value="4">区县级</option>
							</select>
						</div>
					</div>
					<div class="select_list" style="width:130;">
						<div id="uboxstyle">
							<select name="orgOrganOrExpert" id="orgOrganOrExpert"
								style="float:left;margin-right: 10px;width:130;">
								<!-- 							<option value="">请选择类型</option> -->
								<option value="1">机构</option>
								<option value="0">专家</option>
							</select>
						</div>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a href="javascript:submitCh()">查询</a>
					</div>
				</form>
			</div>
		</div>
		<iframe name="resultFrame"
			src="${basePath }/qiye/investigate/addInveStigateList.jsp"
			width="100%" frameborder="0" height="100%"></iframe>
	</div>

	<script type="text/javascript">
		function submitCh() {
			var fm = document.forms["fm"];
			fm.action = "${basePath }/organ/govOrganOrGovExpert";
			fm.submit();

		}
	</script>
</body>
</html>
