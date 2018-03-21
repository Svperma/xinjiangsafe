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
</head>
<body onload="findArea('hidden_province1','city',2,'city1','county1');findArea('hidden_province1','city',2,'city1','county1');">
<jsp:include page="${basePath }/common/include.jsp" />
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<link href="/css/style.css" type="text/css" rel="stylesheet">
	<input type="hidden" id="province"
		value="${sessionScope.ggUser.province }">
	<input type="hidden" id="city" value="${sessionScope.ggUser.city }">
	<input type="hidden" id="county" value="${sessionScope.ggUser.county }">
	<input type="hidden" id="comLevel"
		value="${sessionScope.ggUser.comLevel }">
	<div class="neicont_main_left_cont">
		<div class="neicont_img">
			<img src="${basePath }/images/icotit2.jpg">公示栏
		</div>
		<div class="neicont_main_left_cont_main" style="padding-left:50px;">
			<form action="${basePath }/publish/query" name="fm" method="post"
				target="resultFrame">
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
									<option value="${sessionScope.province.codeCode }">${sessionScope.province.codeCName
										}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
									<option value="选择省份">选择省份</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="select_list" id="c_city1"
						onclick="findArea('hidden_province1','city',2,'city1','county1');findArea('hidden_city1','county',3,'county1',null);">
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
									<option value="${sessionScope.county.codeCode }">${sessionScope.county.codeCName
										}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 3 }">
									<option value="选择区县">选择区县</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="select_list"
						onclick="getBusinessClass('languageh','businessClass')">
						<div id="uboxstyle">
							<select name="languageh" id="languageh" class="hiddenProperty">
								<option value="" selected="selected">行业大类</option>
								<c:forEach items="${bcList }" var="code" varStatus="st">
									<option value="${code.codeCode }">${code.codeCName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="select_list">
						<div id="uboxstyle">
							<select name="businessClass" id="businessClass"
								class="hiddenProperty">
								<option value="" selected="selected">企业类型</option>
							</select>
						</div>
					</div>
				</div>
				<div class="select_list_all" style="margin-top:10px;">
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							value="请输入开始日期" name="beginDate" id="beginDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
<!-- 							onblur="if(!value){value=defaultValue;this.style.color='#999'}" -->
					</div>
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							value="请输入截止日期" name="endDate" id="endDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
<!-- 							onblur="if(!value){value=defaultValue;this.style.color='#999'}" -->
					</div>
					<div class="select_list" style="margin-left:40px;">
						<a href="javascript:submitFm()">查询</a>
					</div>
				</div>
			</form>
			<div></div>
		</div>
		<iframe name="resultFrame"
			style="background-color:#F1F1F1;margin-top:10px;"
			src="${basePath }/jianguan/publisher/publishResult.jsp" width="100%"
			frameborder="0" height="100%"> </iframe>
	</div>
</body>
<script type="text/javascript">
	var $j = jQuery.noConflict();
	function submitFm() {
		document.forms["fm"].submit();
	}
</script>
</html>
