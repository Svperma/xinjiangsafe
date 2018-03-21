<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>policyInfoCondition</title>

</head>
<body onload="findArea('hidden_province1','city',2,'city1','county1');findArea('hidden_province1','city',2,'city1','county1');">
	<jsp:include page="${basePath }/common/include.jsp" />
	<script type="text/javascript" src="${basePath }/js/common.js"></script>
	<input type="hidden" id="province"
		value="${sessionScope.ggUser.province }">
	<input type="hidden" id="city" value="${sessionScope.ggUser.city }">
	<input type="hidden" id="county" value="${sessionScope.ggUser.county }">
	<input type="hidden" id="comLevel"
		value="${sessionScope.ggUser.comLevel }">
	<div class="neicont_main_left_cont">
		<div class="neicont_img">
			<img src="/images/icotit2.jpg">保险信息
		</div>
		<div class="neicont_main_left_cont_main" style="padding-left:50px;">
			<form action="${basePath }/policyinfo/queryPolicy" name="fm" method="get"
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
						onclick="findArea('hidden_province1','city',2,'city1','county1');findArea('hidden_city1','county',3,'county1',null)">
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
					<div class="select_list">
						<div id="uboxstyle">
							<select name="classCode" id="classCode" class="hiddenProperty">
								<option  value="" selected="selected">行业大类</option>
								<c:forEach items="${bcList }" var="code" varStatus="st">
									<option value="${code.codeCode }">${code.codeCName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
<!-- 					<div class="select_list"> -->
<!-- 						<div id="uboxstyle"> -->
<!-- 							<select name="businessClass" id="businessClass" -->
<!-- 								class="hiddenProperty"> -->
<!-- 								<option value="" selected="selected">企业类型</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="select_list" style="width:200px;"> -->
<!-- 						<input name="type" type="radio" value="1" checked>承保状况 <input -->
<!-- 							name="type" type="radio" value="2">赔案状况 -->
<!-- 					</div> -->
					<%-- <div class="select_list">
						<div id="uboxstyle">
							<select name="insurance" id="insurance" class="hiddenProperty">
								<option value="" selected="selected">选择保险公司</option>
								<c:forEach items="${sessionScope.insurerList }" var="insurer">
									<option value="${insurer.insuranceCode }">${fn:substring(insurer.insuranceName,'0','8')
										}...</option>
								</c:forEach>
							</select>
						</div>
					</div> --%>
				</div>
				<div class="select_list_all" style="margin-top:10px;">
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							placeholder="请输入开始日期" name="beginDate" id="beginDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
<!-- 							onblur="if(!value){value=defaultValue;this.style.color='#999'}" -->
					</div>
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							placeholder="请输入截止日期" name="endDate" id="endDate"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
							style="color: rgb(153, 153, 153);">
<!-- 							onblur="if(!value){value=defaultValue;this.style.color='#999'}" -->
					</div>
					<div class="select_list" style="margin-left:40px;">
						<a href="javascript:submitFm()">查询</a>
					</div>
<!-- 					<div class="select_list" style=""> -->
<!-- 						<a class="select_list_alink" href="javascript:exportExcel();">报表下载</a> -->
<!-- 					</div> -->
				</div>
			</form>
			<div></div>
		</div>
		<iframe name="resultFrame" id="resultFrame"
			style="background-color:#F1F1F1;margin-top:10px;"
			src="${basePath }/jianguan/policyinfo/policyInfoResult.jsp"
			width="100%" frameborder="0" height="100%"> </iframe>
	</div>
</body>
<script type="text/javascript">
	function submitFm() {
		
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
			var type = document.getElementsByName("type");
			var tValue = "";
			for ( var i = 0; i < type.length; i++) {
				if (type[i].checked) {
					tValue = type[i].value;
				}
			}
			if (tValue == "1") {
				fm.action = "${basePath}/policyinfo/queryPolicy";
				document.getElementById("resultFrame").src = "/jianguan/policyinfo/policyInfoResult.jsp";
			} else if (tValue == "2") {
				fm.action = "${basePath}/policyinfo/queryClaim";
				document.getElementById("resultFrame").src = "/jianguan/policyinfo/claimInfoResult.jsp";
			}
			fm.submit();
		}
		if (province != null && city != null ) {
			var fm = document.forms["fm"];
			var type = document.getElementsByName("type");
			var tValue = "";
			for ( var i = 0; i < type.length; i++) {
				if (type[i].checked) {
					tValue = type[i].value;
				}
			}
			if (tValue == "1") {
				fm.action = "${basePath}/policyinfo/queryPolicy";
				document.getElementById("resultFrame").src = "/jianguan/policyinfo/policyInfoResult.jsp";
			} else if (tValue == "2") {
				fm.action = "${basePath}/policyinfo/queryClaim";
				document.getElementById("resultFrame").src = "/jianguan/policyinfo/claimInfoResult.jsp";
			}
			fm.submit();
		}
		if (county != null && city != null && province != null) {
			var fm = document.forms["fm"];
			var type = document.getElementsByName("type");
			var tValue = "";
			for ( var i = 0; i < type.length; i++) {
				if (type[i].checked) {
					tValue = type[i].value;
				}
			}
			if (tValue == "1") {
				fm.action = "${basePath}/policyinfo/queryPolicy";
				document.getElementById("resultFrame").src = "/jianguan/policyinfo/policyInfoResult.jsp";
			} else if (tValue == "2") {
				fm.action = "${basePath}/policyinfo/queryClaim";
				document.getElementById("resultFrame").src = "/jianguan/policyinfo/claimInfoResult.jsp";
			}
			fm.submit();
		}
		
		
	}

	function exportExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/policyinfo/exportExcel";
		fm.submit();
	}
</script>
</html>
