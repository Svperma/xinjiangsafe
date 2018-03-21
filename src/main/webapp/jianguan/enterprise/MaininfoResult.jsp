<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<!-- <script type="text/javascript" src="${basePath }/js/common.js"></script> -->
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
	function findArea(upperId, localId, currentLevel, o, lowerId) {
		var upper = $("#" + upperId).val();
		if (upper == null || "" == upper) {
			alert("请选择上级地区！");
			return;
		}
		var areaLevle = document.getElementById("comLevel").value;
		var areaCode = "";
		var upperCode = "";
		if (currentLevel <= areaLevle) {
			return;
		} else {
			upperCode = document.getElementById(upperId).value;
		}
		var ul = document.getElementById("options_" + o);
		var childNodes = ul.childNodes;
		if (childNodes != null && childNodes.length > 1) {
			for ( var i = 1; i < childNodes.length; i) {
				ul.removeChild(childNodes[i]);
			}
		}
		if (lowerId != null) {
			var ulul = document.getElementById("options_" + lowerId);
			if (ulul.childNodes != null && ulul.childNodes.length > 1) {
				for ( var i = 1; i < ulul.childNodes.length; i) {
					ulul.removeChild(ulul.childNodes[i]);
				}
			}
		}
		var actionUrl = "/codeControl/getArea";
		$.ajax({
			type : "post",
			url : actionUrl,
			contentType: "application/json;chartset=utf-8",
			data : JSON.stringify({
				"remark" : upperCode
			}),
			dataType : "json",
			success : function(data) {
				var select = document.getElementById(o);
				var div = document.getElementById("select_" + o);
				var op;
				var li;
				for ( var i = 0; i < data.length; i++) {
					op = document.createElement("option");
					op.value = data[i].codeCode;
					op.text = data[i].codeCName;
					select.appendChild(op);
					
					li = document.createElement("li");
					li.innerHTML = data[i].codeCName;
					li.className = "open";
					li.style.cursor = "pointer";
					li.onmouseover = function() {
						this.style.color = "#fff";
						this.style.backgroundColor = "#1ec2ff";
					};
					li.onmouseout = function() {
						this.style.color = "#79A2BD";
						this.style.backgroundColor = "";
					};
					li.onclick = function() {
						document.getElementById("select_info_" + o).innerHTML = this.innerHTML;
						var indexs = $(this).index();
						$("#" + o).get(0).selectedIndex = indexs; //设置Select索引值为1的项选中 
						$("#hidden_" + o).val($("#" + o).val());
					};
					ul.appendChild(li);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("查询有误...");
			}
		});
	}
// 	window.onload = function onloadbody(){
// 		var comLevel = document.getElementById("comLevel").value;
// 		var province1 = document.getElementById("province1").value;
// 		var city1 = document.getElementById("city1").value;
// 		var county1 = document.getElementById("county1").value;
// 		var hidden_province1 = document.getElementById("hidden_province1").value;
// 		var hidden_city1 = document.getElementById("hidden_city1").value;
// 		var hidden_county1 = document.getElementById("hidden_county1").value;
// 		findArea('province','province',1,'province1','city1');
// 		findArea('hidden_province1','city',2,'city1','county1');
// 		findArea('hidden_city1','county',3,'county1',null);
// 		if (comLevel == "1") {
// 			findArea('hidden_province1','city',2,'city1','county1');
// 		}else if (comLevel == "2") {
// 			alert("+++++++");
// 			document.getElementById("county1").onload = findArea('hidden_province1','city',2,'city1','county1');
// 		}
// 	}
	
</script>
<body onload="" id="bodyid">
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
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
			<form action="${basePath }/usercorp/maindetails" name="fm"
				method="get" target="resultFrame">
				<div class="select_list_all">
					<div class="select_list" id="c_province1"
						onclick="findArea('province','province',1,'province1','city1');">
<!-- 						onchange="modifyArea(null, 'province', 'Province');"> -->
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
					<div class="select_list" id="c_city1" onmouseover=""
						onclick="findArea('hidden_province1','city',2,'city1','county1');">
<!-- 						onchange="modifyArea('city','county','County')"> -->
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
						onclick="findArea('hidden_city1','county',3,'county1',null);">
<!-- 						onchage="modifyArea('city','null','County')"> -->
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
							<select name="classCode" id="classCode">
								<option value="" selected="selected">选择行业类型</option>
								<c:forEach items="${bcList}" var="code" varStatus="st">
									<option value="${code.codeCode }">${code.codeCName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="select_list_all" style="margin-top:10px;">
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							placeholder="请输入需要查询的企业名" name="companyName" id="companyName"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							onclick=""
							onpropertychange="downList(this,'${basePath}/usercorp/getCompanyName?companyName=',false,null,getData)"
							oninput="downList(this,'${basePath}/usercorp/getCompanyName?companyName=',false,null,getData)"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							placeholder="请输入组织机构代码" name="businessLicenseNo" id="businessLicenseNo"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							onclick="" style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="margin-left:40px;">
						<a href="javascript:submitCh()">查询</a>
					</div>
					<div class="select_list">
						<a class="select_list_alink" href="javascript:exportExcel();">报表下载</a>
					</div>
				</div>
		</div>
		</form>
	</div>
	<iframe name="resultFrame" scrolling="auto"
		src="${basePath }/jianguan/enterprise/maininfo.jsp" width="100%"
		frameborder="0" height="100%"></iframe>
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
			fm.action = "${basePath }/usercorp/maindetails";
			fm.submit();
		}
		if (province != null && city != null ) {
			var fm = document.forms["fm"];
			fm.action = "${basePath }/usercorp/maindetails";
			fm.submit();
		}
		if (county != null && city != null && province != null) {
			var fm = document.forms["fm"];
			fm.action = "${basePath }/usercorp/maindetails";
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
		fm.action = "${basePath}/usercorp/exportToExcel";
		fm.submit();
	}
</script>
<script type="text/javascript">
	function modifyArea(parentId, childId, codeType) {
		var parentVal = "";
		var condition = "?codeType=" + codeType;
		if (parentId != null) {
			parentVal = document.getElementById(parentId).value;
			condition += "&remark=" + parentVal;
		}
		$.ajax({
			type : "get",
			url : "${basePath}/codeControl/getGgCodeByObj" + condition,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				var select = document.getElementById(childId);
				if(parentId == null){
					select.length = 1;
				}else{
					select.length = 0;
				}
				
				for ( var i = 0; i < data.length; i++) {
					var item = data[i];
					var op = document.createElement("li");
					op.value = item.codeCode;
					op.text = item.codeCName;
					if(item.codeCode=="650000"){
						op.setAttribute("selected","selected");
					}
					select.appendChild(op);
				}
				if (parentId == "province") {
					modifyArea('city', 'county', 'County');
				}
				if (parentId == null) {
					modifyArea('province', 'city', 'City');
				} 
			},
			error : function() {
				alert("error");
			}
		});
	}
	/** ******************************************************************************************** **/
	
	
</script>
</html>
