<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
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

<title>My JSP 'mainInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="css/etpStyle.css">
<script type="text/javascript">
	var $j = jQuery.noConflict();
	function click1() {
		$j(document).ready(function() {
			$j(".select_list_inputa").css("color", "black");
			$j(".td-none").children().remove();
			$j(".td-none").append("<input type='file' name='corpImages'/>");
		})
		var a1 = document.getElementById("ax1s");
		a1.innerHTML = "提交";
		a1.onclick = function() {
			var companyName = document.getElementById("companyName").value;//公司名称
			var corpration = document.getElementById("corpration").value;//法人
// 			var businessLicenseNo = document.getElementById("businessLicenseNo").value;//营业执照号
// 			var safetyLicenseNo = document.getElementById("safetyLicenseNo").value;//安全生产许可证号
			
			var businessLicenseNo = document.getElementById("businessLicenseNo").value;//营业执照号
// 			var corpImages = document.getElementsByName("corpImages");//营业执照图片
			var bLicenseDate = document.getElementsByName("bLicenseDate").value;//营业执照有效期
			var safetyLicenseNo = document.getElementById("safetyLicenseNo").value;//安全生产许可证号
// 			var safetyLicenseImg = document.getElementsByName("safetyLicenseImg").value;//安全生产许可证图片
			var sLiceseDate = document.getElementsByName("sLiceseDate").value;//安全生产许可证有效期

			if ((companyName == null ) || (companyName == "")) {
				alert("公司名称为空，请输入");
				return;
			}if ((corpration == null )||(corpration == "")) {
				alert("法定代表人为空，请输入");
				return;
			}/* if ((businessLicenseNo == null) || (businessLicenseNo == "")) {
				alert("统一社会信用代码为空，请输入");
				return;
			} */
			if (flag == "1" && classCode == ("610000" || "620000" || "630000")) {
				if ((businessLicenseNo == null) || (businessLicenseNo == "")) {
					alert("统一社会信用代码为空，请输入");
					businessLicenseNo.focus();
					return;
				}
// 				if (((businessLicenImg == null) || (businessLicenImg == ""))
// 						|| (businessLicenImg == "未选择任何文件")) {
// 					alert("营业执照证书为空，请选择");
// 					return;
// 				}
				if ((bLicenseDate == null) || (bLicenseDate == "")) {
					alert("营业执照有效期，请输入");
					bLicenseDate.foucs();
					return;
				}
				if ((safetyLicenseNo == null) || (safetyLicenseNo == "")) {
					alert("安全生产许可证号为空，请输入");
					safetyLicenseNo.focus();
					return;
				}
// 				if (((safetyLicenseImg == null) || (safetyLicenseImg == ""))
// 						|| (businessLicenImg == "未选择任何文件")) {
// 					alert("安全生产许可证为空，请选择");
// 					return;
// 				}
				if ((sLiceseDate == null) || (sLiceseDate == "")) {
					alert("安全生产许可证截至日期，请输入");
					sLiceseDate.foucs();
					return;
				}
			}
// 			var flag = document.getElementById("flag").value;//企业类别
// 			if(flag=='1'){
// 				if ((safetyLicenseNo == null ) || (safetyLicenseNo == "")) {
// 					alert("安全生产许可证号为空，请输入");
// 					return;
// 				}
// 			}
			var form = document.forms["updateForm"];
			form.submit();
		};
		modifyArea(null, "province", "Province");
		var input1 = document.getElementsByClassName("select_list_inputa");
		for ( var i = 0; i < input1.length; i++) {
			input1[i].removeAttribute("readonly");
		}
	}
	function modifyArea(parentId, childId, codeType) {
		var parentVal = "";
		var condition = "?codeType=" + codeType;
		if (parentId != null) {
			parentVal = document.getElementById(parentId).value;
			condition += "&remark=" + parentVal;
		}
		$j.ajax({
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
					var op = document.createElement("option");
					op.value = item.codeCode;
					op.text = item.codeCName;
					select.appendChild(op);
				}
				if (parentId == "province") {
					modifyArea('city', 'county', 'County');
				}
				/* if (parentId == null) {
					modifyArea('province', 'city', 'City');
				} */
			},
			error : function() {
				alert("error")
			}
		});
	}
	function getArea(parentId, childId) {
		var parentVal = "";
		if (parentId != null)
			parentVal = document.getElementById(parentId).value;
		$j.ajax({
			type : "post",
			url : "${basePath}/codeControl/getArea",
			data : JSON.stringify({
				"remark" : parentVal
			}),
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				for ( var i = 0; i < data.length; i++) {
					var item = data[i];
					var option = document.createElement("option");
					option.value = item.codeCode;
					option.text = item.codeCName;
					obj.appendChild(option);
				}
			},
			error : function() {
				alert("error");
			}
		});
	}
	function getClassCode(parentId, childId) {
		var parentVal = "";
		if (parentId != null && parentId != '')
			parentVal = document.getElementById(parentId).value;
		else
			return;
		document.getElementById(childId).length = 0;
		$j.ajax({
			type : "post",
			url : "codeControl/getGgCodeByObj?codeType=IndustryType&remark="
					+ parentVal,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				var obj = document.getElementById(childId);
				for ( var i = 0; i < data.length; i++) {
					var item = data[i];
					var option = document.createElement("option");
					option.value = item.codeCode;
					option.text = item.codeCName;
					obj.appendChild(option);
				}
			},
			error : function() {
				alert("error");
			}
		});
	}
</script>
</head>

<body onload="getArea(null,'province');">
	<div class="maincont">
		<form action="${basePath }usercorp/updateInfo" name="updateForm"
			method="post" enctype="multipart/form-data">
			<div class="neicont_main_left_cont_main">
				<div class="neicont_main_left_cont_main">
					<c:if test="${empty ggusercorp.userCode }">
						<input id="userCode" name="userCode" type="hidden" value="${ggUser.userCode }">
							<div id="checkNew">
								<div>
									<table cellpadding="0" cellspacing="0" width="100%">
										<tr class="new-title " style="color: red;">
											<td style="color: red;font-size: 17px;">新注册用户请先完善企业信息</td>
										</tr>
									</table>
								</div>
							</div>
					</c:if>
					<c:if test="${not empty ggusercorp.userCode }">
						<input id="userCode" name="userCode" type="hidden" value="${ggusercorp.userCode }">
					</c:if>
					<table style="margin:0 auto;width:100%;">
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">企业名称：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.companyName }" onblur="checkUserName(this);" id="companyName"
								name="companyName" style="color: rgb(153, 153, 153);" readonly />
							<input
								class="select_list_inputa" value="${ggusercorp.companyName }" onblur="checkUserName(this);" id="companyNameold"
								name="companyNameold" style="color: rgb(153, 153, 153);" type="hidden"/>
							</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">法定代表人：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.corpration }" id="corpration"
								name="corpration" style="color: rgb(153, 153, 153);" readonly /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系人：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.linkName }"
								name="linkName" style="color: rgb(153, 153, 153);" readonly /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系地址：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.companyAddress }"
								name="companyAddress" style="color: rgb(153, 153, 153);"
								readonly /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">电话：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.mobile }" maxlength="11"
								name="mobile" style="color: rgb(153, 153, 153);" readonly /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">手机：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.telephone }" maxlength="11"
								name="telephone" style="color: rgb(153, 153, 153);" readonly /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系邮箱：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.email }"
								name="email" style="color: rgb(153, 153, 153);" readonly /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">传真：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.fax }" name="fax" maxlength="12"
								style="color: rgb(153, 153, 153);" readonly /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">邮编：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.post }" maxlength="6"
								name="post" style="color: rgb(153, 153, 153);" readonly /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">归属省：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="province" id="province"
								onchange="modifyArea('province','city','City')">
									<c:forEach items="${list_pro}" var="pro" varStatus="st">
										<option value="${pro.codeCode }" selected="selected">${pro.codeCName
											}</option>
									</c:forEach>
							</select></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">归属市：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="city" id="city"
								onchange="modifyArea('city','county','County')">
									<c:forEach items="${list_city}" var="ci" varStatus="st">
										<option value="${ci.codeCode}" selected="selected">${ci.codeCName
											}</option>
									</c:forEach>
							</select></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">归属县：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="county" id="county">
									<c:forEach items="${list_county}" var="co" varStatus="st">
										<option value="${co.codeCode}" selected="selected">${co.codeCName
											}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">行业大类：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="classCode" id="classCode"
								onchange="getClassCode('classCode','businessClass')">
									<c:forEach items="${list_classCode}" var="cl" varStatus="st">
										<c:if test="${cl.codeCode== ggusercorp.classCode}">
											<option value="${cl.codeCode}" selected>${cl.codeCName
												}</option>
										</c:if>
										<c:if test="${cl.codeCode != ggusercorp.classCode}">
											<option value="${cl.codeCode}">${cl.codeCName }</option>
										</c:if>
									</c:forEach>
							</select></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">经营范围：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;" ><select
								name="businessClass" id="businessClass">
									<c:forEach items="${list_businessClass}" var="bc"
										varStatus="st">
										<c:if test="${bc.codeCode == ggusercorp.businessClass}">
											<option value="${bc.codeCode}" selected>${bc.codeCName
												}</option>
										</c:if>
										<c:if test="${list_businessClass != ggusercorp.businessClass}">
											<option value="${bc.codeCode}">${bc.codeCName }</option>
										</c:if>
									</c:forEach>
							</select></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">企业类型：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;" >
								<select name="flag" id="flag" onchange="getFlag()">
										<option selected="selected"<c:if test="${ggusercorp.flag =='1' }"></c:if> value="1">非新开办企业</ption>
										<option selected="selected"<c:if test="${ggusercorp.flag =='0' }"></c:if> value="0">新开办企业</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">统一社会信用代码：
							<span style="color: red;float: right;" id="businessLicen1">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" maxlength="30"
								value="${ggusercorp.businessLicenseNo }" id="businessLicenseNo"
								name="businessLicenseNo" style="color: rgb(153, 153, 153);" onblur="checkBusinessNo(this)"
								readonly />
								<input
								class="select_list_inputa"
								value="${ggusercorp.businessLicenseNo }" id="businessLicenseNoold"
								name="businessLicenseNoold" style="color: rgb(153, 153, 153);" type="hidden"/>
								</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">营业执照<span style="color:red;font-size: 15px;">
							(盖章扫描件)
						</span>：<span style="color: red;float: right;" id="businessLicen2">*</span></td>
							<c:if test="${empty ggusercorp.businessLicenseImage }">
								<td style="border-bottom:#9CF 1px solid;"><input
									type="file" class="select_list_inputa"
									value="${ggusercorp.businessLicenseImage }" name="corpImages"
									style="color: rgb(153, 153, 153);" readonly /></td>
							</c:if>
							<c:if test="${not empty ggusercorp.businessLicenseImage }">
								<td style="border-bottom:#9CF 1px solid;" class="td-none"><a
									href="${ggusercorp.businessLicenseImage }"
									class="table_buttonc" target="_blank">查看</a></td>
							</c:if>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">营业执照截至日期：
								<span style="color: red;float: right;" id="businessLicen3">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><fmt:formatDate
									var="busDate" value="${ggusercorp.businessLicenseDate}"
									pattern="yyyy-MM-dd" /> <input class="select_list_inputa"
								value="${busDate}" name="bLicenseDate"
								style="color: rgb(153, 153, 153);" readonly
								onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})" />
							</td>
						</tr>
						<tr><!-- onblur="checkSafeNo(this)" -->
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全生产许可证号：
								<span style="color: red;float: right;" id="safetyLicense1">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" maxlength="30"
								value="${ggusercorp.safetyLicenseNo }" name="safetyLicenseNo" onblur="checkSafeNo(this)" id="safetyLicenseNo"
								style="color: rgb(153, 153, 153);" readonly />
								<input
								class="select_list_inputa"
								value="${ggusercorp.safetyLicenseNo }" name="safetyLicenseNoold" id="safetyLicenseNoold"
								style="color: rgb(153, 153, 153);" type="hidden"/>
							</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全生产许可证<span style="color:red;font-size: 15px;">
							(盖章扫描件)
						</span>：<span style="color: red;float: right;" id="safetyLicense2">*</span></td>
							<c:if test="${empty ggusercorp.safetyLicenseImage }">
								<td style="border-bottom:#9CF 1px solid;"><input
									type="file" class="select_list_inputa" name="corpImages"
									value="${ggusercorp.safetyLicenseImage }"
									style="color: rgb(153, 153, 153);" readonly /></td>
							</c:if>
							<c:if test="${not empty ggusercorp.safetyLicenseImage }">
								<td style="border-bottom:#9CF 1px solid;" class="td-none"><a
									href="${ggusercorp.safetyLicenseImage }" class="table_buttonc"
									target="_blank">查看</a></td>
							</c:if>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">许可证截至日期：
								<span style="color: red;float: right;" id="safetyLicense3">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><fmt:formatDate
									var="safeDate" value="${ggusercorp.safetyLiceseDate }"
									pattern="yyyy-MM-dd" /> <input class="select_list_inputa"
								value="${safeDate }" name="sLiceseDate"
								style="color: rgb(153, 153, 153);" readonly
								onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})" /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全标准化等级：</td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="standardLevel" id="standardLevel">
									<c:forEach items="${list_safe}" var="sa" varStatus="st">
										<c:if test="${sa.codeCode== ggusercorp.standardLevel}">
											<option value="${sa.codeCode}" selected>${sa.codeCName
												}</option>
										</c:if>
										<c:if test="${sa.codeCode != ggusercorp.standardLevel}">
											<option value="${sa.codeCode}">${sa.codeCName }</option>
										</c:if>
									</c:forEach>
							</select></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全标准化等级证书<span style="color:red;font-size: 15px;">
							(盖章扫描件)
						</span>：</td>
							<c:if test="${empty ggusercorp.standardLevelImage }">
								<td style="border-bottom:#9CF 1px solid;"><input
									type="file" class="select_list_inputa" name="corpImages"
									value="${ggusercorp.standardLevelImage }"
									style="color: rgb(153, 153, 153);" readonly /></td>
							</c:if>
							<c:if test="${not empty ggusercorp.standardLevelImage }">
								<td style="border-bottom:#9CF 1px solid;"  class="td-none"><a
									href="${ggusercorp.standardLevelImage }" class="table_buttonc"
									target="_blank">查看</a></td>
							</c:if>
							<%-- <td class="table_listb" style="border-bottom:#9CF 1px solid;">风险状况：<span style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="riskLevel" id="riskLevel">
									<c:forEach items="${list_riskLevel}" var="risk" varStatus="st">
										<c:if test="${risk.codeCode == ggusercorp.riskLevel}">
											<option value="${risk.codeCode}" selected>${risk.codeCName
												}</option>
										</c:if>
										<c:if test="${risk.codeCode != ggusercorp.riskLevel}">
											<option value="${risk.codeCode}">${risk.codeCName }</option>
										</c:if>
									</c:forEach>
							</select></td> --%>
						</tr>
						
						<%-- <tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">上年度营业额：</td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.turnover }"
								name="turnover" style="color: rgb(153, 153, 153);" readonly /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">上年度税务报表：</td>
							<c:if test="${empty ggusercorp.tax }">
								<td style="border-bottom:#9CF 1px solid;" colspan="3"><input
									type="file" class="select_list_inputa" name="corpImages"
									value="${ggusercorp.tax }" style="color: rgb(153, 153, 153);"
									readonly /></td>
							</c:if>
							<c:if test="${not empty ggusercorp.tax }">
								<td style="border-bottom:#9CF 1px solid;" colspan="3" class="td-none"><a
									href="${ggusercorp.tax }" class="table_buttonc" target="_blank">查看</a></td>
							</c:if>
						</tr> --%>
						<tr>
							<td></td>
							<td></td>
							<td><a
								style="margin:20px auto;background-color:#008abd;width:80px;cursor:pointer;"
								id="ax1s" onclick="click1()">修改</a></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="clearboth"></div>
	</div>
	</form>
</body>
<script type="text/javascript">
	function getFlag() {
		var flag = document.getElementById("flag").value;
		if (flag=="1") {
			document.getElementById("safetyLicense1").style.display="";
			document.getElementById("safetyLicense2").style.display="";
			document.getElementById("safetyLicense3").style.display="";
			document.getElementById("businessLicen1").style.display="";
			document.getElementById("businessLicen2").style.display="";
			document.getElementById("businessLicen3").style.display="";
		}else {
			document.getElementById("safetyLicense1").style.display="none";
			document.getElementById("safetyLicense2").style.display="none";
			document.getElementById("safetyLicense3").style.display="none";
			document.getElementById("businessLicen1").style.display="none";
			document.getElementById("businessLicen2").style.display="none";
			document.getElementById("businessLicen3").style.display="none";
		}
	}
</script>								
<script type="text/javascript">
	function checkBusinessNo(o) {
		var val = o.value;
		var businessLicenseNoold = document.getElementById("businessLicenseNoold").value;
		$j.ajax({
			type : "get",
			url : "/usercorp/checkBusinessNo?businessNo=" + val + "&businessLicenseNoold=" + businessLicenseNoold,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("统一社会信用代码已存在，请重新输入");
// 					o.value = "";
					o.focus();
					return;
				} if (data == "isNoHave") {
					alert("统一社会信用代码不可为空，请重新输入");
// 					o.value = "";
					o.focus();
					return;
				}

			},
			error : function() {
				alert("business失败，请稍后再试");
			}
		});
	}
	function checkSafeNo(s) {
		var flag = document.getElementById("flag").value;//企业类别
		if(flag=='0'){
			return;
		}
		var sa = s.value;
		var safetyLicenseNoold = document.getElementById("safetyLicenseNoold").value;
		$j.ajax({
			type : "get",
			url : "/usercorp/checkSafeNo?safeNo=" + sa+"&safetyLicenseNoold="+safetyLicenseNoold,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("安全生产执照号已存在，请重新输入");
// 					s.value = "";
					s.focus();
					return;
				} if (data == "isNoHave") {
					alert("安全生产执照号不可为空，请重新输入");
// 					s.value = "";
					s.focus();
					return;
				} 

			},
			error : function() {
				alert("safe失败，请稍后再试");
			}
		});
	}
	function checkUserName(n) {
		var uName = n.value;
		var companyNameold = document.getElementById("companyNameold").value;
			$j.ajax({
				type : "get",
				url : "/usercorp/checkUserName?userName=" + uName+"&companyNameold="+companyNameold,
				data : {},
				dataType : "json",
				contentType : "application/json;charset=utf-8",
				success : function(data) {
					if (data == "yes") {
						alert("该公司名称已存在，请重新输入");
	// 					n.value = "";
						n.focus();
						return;
					} if (data == "isNoHave") {
						alert("公司名称不可为空，请输入");
	// 					n.value = "";
						n.focus();
						return;
					}
	
				},
				error : function() {
					alert("失败，请稍后再试");
				}
			});
	}
</script>
</html>
