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

<link href="/css/style.css" type="text/css" rel="stylesheet">


</head>


<body onload="findArea('hidden_province1','city',2,'city1','county1');findArea('hidden_province1','city',2,'city1','county1');">
	<jsp:include page="${basePath }/common/include.jsp" />
	<script type="text/javascript" src="${basePath }/js/common.js"></script>
<!-- 	<script type="text/javascript" src="${basePath }/webapp/js/jquery-1.8.3.min.js"></script> -->
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
			<form action="${basePath }evaluateDangers/get_riskRatingInfo"
				name="fm" method="get" target="resultFrame">
				<div class="select_list_all">
					<div class="select_list" id="c_province1"
						 onclick="findArea('province','province',1,'city1','city1')" 
						<%--onclick="getProvince('province1','city1','City')"--%>
						> 
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
							<select name="province1" id="province1"  >
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
					onclick="findArea('hidden_province1','city',2,'city1','county1');findArea('hidden_city1','county',3,'county1',null);" 
						<%-- onclick="getProvince('city1','county1','County')" --%>
						>
						<div id="uboxstyle">
							<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
								<input type="hidden" id="hidden_city1" name="hidden_city1"
									value="${sessionScope.city.codeCode }">
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 2 }">
								<input type="hidden" id="hidden_city1" name="hidden_city1"
									value="">
							</c:if>
							<select name="city1" id="city1" >
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
				<!-- 	<div class="select_list">
						<div id="uboxstyle">
							<select name="riskLevel" id="riskLevel">
								<option value="" selected="selected">风险状况</option>
								<option value="1">合格</option>
								<option value="0">不合格</option>
							</select>
						</div>
					</div> -->
					<div class="select_list">
						<div id="uboxstyle">
							<select name="status" id="status">
								<option value="" selected="selected">整改进度</option>
								<option value="0" >未整改</option>
								<option value="1">整改中</option>
								<option value="2">整改完成</option>
							</select>
						</div>
					</div>
				</div>
				<div class="select_list_all">
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							placeholder="请输入需要查询的企业名" name="companyName" id="companyName"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							onclick=""
							oninput="downList(this,'${basePath}/usercorp/getCompanyName?companyName=',false,null,getData)"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							placeholder="请输入开始评估范围" name="startEvaluatDate" id="evaluatDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
							<!-- onblur="if(!value){value=defaultValue;this.style.color='#999'}" -->
					</div>
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							placeholder="请输入结束评估范围" name="endEvaluatDate" id="evaluatDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
							<!-- onblur="if(!value){value=defaultValue;this.style.color='#999'}" -->
					</div>
					<div class="select_list" style="margin-left:40px;">
						<a href="javascript:submitCh()">查询</a>
					</div>
					<div class="select_list">
						<a href="${basePath }evaluateDangers/dangerSourceNotDetails">企业评估</a>
					</div>
					<div class="select_list">
						<a  class="select_list_alink" href="javascript:exportExcel();">报表下载</a>
					</div>
				</div>
			</form>
		</div>
		<br/>
		<iframe name="resultFrame"
			src="${basePath }jianguan/jsp/dangerSafety.jsp" width="100%"
			frameborder="0" height="100%"></iframe>
	</div>
</body>
<script type="text/javascript">
	function submitCh() {
		var province = document.getElementById("province1").value;
		var city = document.getElementById("city1").value;
		var county = document.getElementById("county1").value;
		if (province == "选择省份") {
			province = null;
		}
		if (province == null ) {
			alert("请选择省份！");
			return;
		}
		if (city == "选择城市" ) {
			document.getElementById("hidden_city1").value = "";
			document.getElementById("hidden_county1").value = "";
			document.getElementById("select_info_county1").innerHTML ="选择区县"
		}
		if (county == "选择区县") {
			document.getElementById("hidden_county1").value = "";
		}
		
		if (county != null && city == null && province != null ) {
			document.getElementById("hidden_county1").value = "";
			alert("请选择城市");
			return;
		}
		if (county != null && city == null && province == null ) {
			alert("请选择省份");
			return;
		}
		if (county != null && city != null && province == null) {
			alert("请选择省份");
			return;
		}
		if (province != null || province != "选择省份") {
			var fm = document.forms["fm"];
			fm.action = "${basePath }evaluateDangers/get_riskRatingInfo";
			fm.submit();
		}
		if (province != null && city != null ) {
			var fm = document.forms["fm"];
			fm.action = "${basePath }evaluateDangers/get_riskRatingInfo";
			fm.submit();
		}
		if (county != null && city != null && province != null) {
			var fm = document.forms["fm"];
			fm.action = "${basePath }evaluateDangers/get_riskRatingInfo";
			fm.submit();
		}
	}
	function getData(data) {
		return data.companyName;
	}
</script>
<script type="text/javascript">
	function exportExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/evaluateDangers/exportToExcel";
		fm.submit();
	}
	
</script>
<script type="text/javascript">

</script>




</html>