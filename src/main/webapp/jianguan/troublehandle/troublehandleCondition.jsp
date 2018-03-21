<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<jsp:include page="${basePath }/common/include.jsp" />
</head>
<script type="text/javascript">
	window.onload = "findArea('hidden_province1','city',2,'city1','county1')";
</script>
<body>
	<input type="hidden" id="province"
		value="${sessionScope.ggUser.province }">
	<input type="hidden" id="city" value="${sessionScope.ggUser.city }">
	<input type="hidden" id="county" value="${sessionScope.ggUser.county }">
	<input type="hidden" id="comLevel"
		value="${sessionScope.ggUser.comLevel }">

	<div class="neicont_main_left_cont">
		<div class="neicont_img">
			<img src="images/icotit1.jpg">地区选择
		</div>
		<div class="neicont_main_left_cont_main">
			<form action="${basePath }/troublehandle/troublequery" name="trouble"
				method="post" target="resultFrame">
				<div class="select_list_all">
					<div class="select_list" id="c_province1"
						onclick="findArea('province','province',1,'province1','city1')">
						<div id="uboxstyle">
							<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
								<input type="hidden" id="hidden_province1"
									name="hidden_province1"
									value="${sessionScope.province.codeCode }">
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 1 }">
								<input type="hidden" id="hidden_province1"
									name="hidden_province1" value="">
							</c:if>
							<select name="province1" id="province1">
								<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
									<option value="${sessionScope.province.codeCode }">
										${sessionScope.province.codeCName}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
									<option value="选择省份">选择省份</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="select_list" id="c_city1"
						onclick="findArea('hidden_province1','city',2,'city1','county1')">
						<div id="uboxstyle">
							<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
								<input type="hidden" id="hidden_city1" name="hidden_city1"
									value="${sessionScope.city.codeCode }">
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 2 }">
								<input type="hidden" id="hidden_city1" name="hidden_city1"
									value="">
							</c:if>
							<select name="city1" id="city1">
								<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
									<option value="${sessionScope.city.codeCode }">${sessionScope.city.codeCName
										}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 2 }">
									<option value="选择城市">选择城市</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="select_list" id="c_county1"
						onclick="findArea('hidden_city1','county',3,'county1',null)">
						<div id="uboxstyle">
							<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
								<input type="hidden" id="hidden_county1" name="hidden_county1"
									value="${sessionScope.county.codeCode }">
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 3 }">
								<input type="hidden" id="hidden_county1" name="hidden_county1"
									value="">
							</c:if>
							<select name="county1" id="county1">
								<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
									<option value="${sessionScope.county.codeCode }">${sessionScope.county.codeCName}
									</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 3 }">
									<option value="选择区县">选择区县</option>
								</c:if>
							</select>
						</div>
					</div>
				</div>
				<div class="select_list_all" style="margin-top:10px;">
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							value="请输入开始日期" name="beginDate" id="beginDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							value="请输入截止日期" name="endDate" id="endDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="width: 200px;">
						<input id="name" name="name" class="select_list_inputa"
							type="text" maxlength="20" value="请输入企业名称"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="margin-left:40px;">
						<a href="javascript:submitTrouble();">查询</a>
					</div>
					<div class="select_list" style="">
						<a href="#">综合报表下载</a>
					</div>
				</div>
			</form>

			<iframe name="resultFrame"
				style="background-color:#F1F1F1;margin-top:10px;"
				src="/troublehandle/troubleinit" width="100%" frameborder="0"
				height="100%"> </iframe>
</body>
<script type="text/javascript">
	function submitTrouble() {
		document.forms["trouble"].submit();
	}
</script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
</html>
