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
				if (parentId == null) {
					select.length = 1;
				} else {
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

<body
	onload="modifyArea('province','city','City');getClassCode('classCode','businessClass');">
	<div class="maincont">
		<form action="${basePath }usercorp/updateInfo" name="updateForm"
			method="post" enctype="multipart/form-data">
			<div class="neicont_main_left_cont_main">
				<div class="neicont_main_left_cont_main">
					<c:if test="${empty ggusercorp.userCode }">
						<input id="userCode" name="userCode" type="hidden"
							value="${ggUser.userCode }">
						<div id="checkNew">
							<div>
								<table cellpadding="0" cellspacing="0" width="100%">
									<tr class="new-title " style="color: red;">
										<td style="color: red;font-size: 17px;">新注册用户请先完善企业信息(先填写"社会统一信用代码"可能会自动补全信息)</td>
									</tr>
								</table>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty ggusercorp.userCode }">
						<input id="userCode" name="userCode" type="hidden"
							value="${ggusercorp.userCode }">
					</c:if>
					<table style="margin:0 auto;width:100%;">
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">企业名称：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.companyName }"
								onblur="checkUserName(this);" id="companyName"
								name="companyName" style="color: rgb(153, 153, 153);" /> <input
								class="select_list_inputa" value="${ggusercorp.companyName }"
								id="companyNameold" name="companyNameold" maxlength="150"
								style="color: rgb(153, 153, 153);" type="hidden" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">法定代表人：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.corpration }"
								id="corpration" name="corpration" maxlength="50"
								style="color: rgb(153, 153, 153);" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系人：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.linkName }"
								id="linkName" name="linkName" maxlength="40" style="color: rgb(153, 153, 153);" /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系地址：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.companyAddress }"
								id="companyAddress" name="companyAddress" maxlength="150"
								style="color: rgb(153, 153, 153);" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">座机电话：</td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.mobile }"
								maxlength="13" id="mobile" name="mobile"
								style="color: rgb(153, 153, 153);" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">手机号：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.telephone }"
								maxlength="11" id="telephone" name="telephone"
								style="color: rgb(153, 153, 153);" /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系邮箱：</td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.email }"
								id="email" name="email" maxlength="29" style="color: rgb(153, 153, 153);" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">传真：</td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.fax }" name="fax"
								maxlength="12" id="fax" style="color: rgb(153, 153, 153);" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">邮编：</td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.post }"
								maxlength="6" id="post" name="post"
								style="color: rgb(153, 153, 153);" /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">归属省：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="province" id="province"
								onchange="modifyArea('province','city','City')">
									<c:forEach items="${list_pro}" var="pro" varStatus="st">
										<option value="${pro.codeCode }" selected="selected">${pro.codeCName
											}</option>
									</c:forEach>
							</select></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">归属市：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select name="city"
								id="city" onchange="modifyArea('city','county','County')">
									<c:forEach items="${list_city}" var="ci" varStatus="st">
										<option value="${ci.codeCode}" selected="selected">${ci.codeCName
											}</option>
									</c:forEach>
							</select></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">归属县：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="county" id="county">
									<c:forEach items="${list_county}" var="co" varStatus="st">
										<option value="${co.codeCode}" selected="selected">${co.codeCName
											}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">行业大类：<span
								style="color: red;float: right;">*</span></td>
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
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">经营范围：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
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
										<option value="1">非新开办企业</ption>
										<option value="0">新开办企业</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">统一社会信用代码：<span
								style="color: red;float: right;" id="businessLicen1">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" maxlength="30"
								value="${ggusercorp.businessLicenseNo }" id="businessLicenseNo"
								name="businessLicenseNo" style="color: rgb(153, 153, 153);"
								onblur="checkBusinessNo(this)" /> <input
								class="select_list_inputa"
								value="${ggusercorp.businessLicenseNo }"
								id="businessLicenseNoold" name="businessLicenseNoold"
								style="color: rgb(153, 153, 153);" type="hidden" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">营业执照<span style="color:red;font-size: 15px;">
							(盖章扫描件)
						</span>：<span
								style="color: red;float: right;" id="businessLicen2">*</span></td>
							<c:if test="${empty ggusercorp.businessLicenseImage }">
								<td style="border-bottom:#9CF 1px solid;"><input
									type="file" class="select_list_inputa"
									value="${ggusercorp.businessLicenseImage }"
									name="businessLicenImg" id="businessLicenImg"
									style="color: rgb(153, 153, 153);" /></td>
							</c:if>
							<%-- <c:if test="${not empty ggusercorp.businessLicenseImage }">
								<td style="border-bottom:#9CF 1px solid;" class="td-none"><a
									href="${ggusercorp.businessLicenseImage }"
									class="table_buttonc" target="_blank">查看</a></td>
							</c:if> --%>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">营业执照截至日期：<span
								style="color: red;float: right;" id="businessLicen3">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><fmt:formatDate
									var="busDate" value="${ggusercorp.businessLicenseDate}"
									pattern="yyyy-MM-dd" /> <input class="select_list_inputa"
								value="${busDate}" name="bLicenseDate" id="bLicenseDate"
								style="color: rgb(153, 153, 153);"
								onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})" />
							</td>
						</tr>
						<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全生产许可证号：
							<span style="color: red;float: right;" id="safetyLicense1">*</span></td>
						<td style="border-bottom:#9CF 1px solid;"><input
							class="select_list_inputa" maxlength="30"
							value="${ggusercorp.safetyLicenseNo }" name="safetyLicenseNo"
							onblur="checkSafeNo(this)" id="safetyLicenseNo"
							style="color: rgb(153, 153, 153);" /> <input
							class="select_list_inputa" value="${ggusercorp.safetyLicenseNo }"
							name="safetyLicenseNoold" id="safetyLicenseNoold"
							style="color: rgb(153, 153, 153);" type="hidden" /></td>
						<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全生产许可证<span style="color:red;font-size: 15px;">
							(盖章扫描件)
						</span>：<span style="color: red;float: right;" id="safetyLicense2">*</span></td>
						<c:if test="${empty ggusercorp.safetyLicenseImage }">
							<td style="border-bottom:#9CF 1px solid;"><input type="file" 
								class="select_list_inputa" name="safetyLicenseImg"
								id="safetyLicenseImg" value="${ggusercorp.safetyLicenseImage }"
								style="color: rgb(153, 153, 153);" /></td>
						</c:if>
						<%-- <c:if test="${not empty ggusercorp.safetyLicenseImage }">
								<td style="border-bottom:#9CF 1px solid;" class="td-none"><a
									href="${ggusercorp.safetyLicenseImage }" class="table_buttonc"
									target="_blank">查看</a></td>
							</c:if> --%>
						<td class="table_listb" style="border-bottom:#9CF 1px solid;">许可证截至日期：
							<span style="color: red;float: right;" id="safetyLicense3">*</span></td>
						<td style="border-bottom:#9CF 1px solid;"><fmt:formatDate
								var="safeDate" value="${ggusercorp.safetyLiceseDate }"
								pattern="yyyy-MM-dd" /> <input class="select_list_inputa"
							value="${safeDate }" name="sLiceseDate" id="sLiceseDate"
							style="color: rgb(153, 153, 153);"
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
									type="file" class="select_list_inputa" name="standardLevelImg"
									id="standardLevelImg" value="${ggusercorp.standardLevelImage }"
									style="color: rgb(153, 153, 153);" /></td>
							</c:if>
							<%-- <c:if test="${not empty ggusercorp.standardLevelImage }">
								<td style="border-bottom:#9CF 1px solid;"  class="td-none"><a
									href="${ggusercorp.standardLevelImage }" class="table_buttonc"
									target="_blank">查看</a></td>
							</c:if> --%>
							 <%--<td class="table_listb" style="border-bottom:#9CF 1px solid;">风险状况：<span
								style="color: red;float: right;">*</span></td>
							<td style="border-bottom:#9CF 1px solid;"><select
								name="riskLevel" id="riskLevel">
									<c:forEach items="${list_riskLevel}" var="risk" varStatus="st">
										<c:if test="${risk.codeCode != ggusercorp.riskLevel}">
											<option value="${risk.codeCode}">${risk.codeCName }</option>
										</c:if>
										<c:if test="${risk.codeCode == ggusercorp.riskLevel}">
											<option value="${risk.codeCode}" selected>${risk.codeCName
												}</option>
										</c:if>
									</c:forEach>
							</select></td> 
							 --%>
						</tr>
						<%-- <tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">上年度营业额：</td>
							<td style="border-bottom:#9CF 1px solid;"><input
								class="select_list_inputa" value="${ggusercorp.turnover }"
								id="turnover" name="turnover" style="color: rgb(153, 153, 153);" /></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">上年度税务报表：</td>
							<c:if test="${empty ggusercorp.tax }">
								<td style="border-bottom:#9CF 1px solid;" colspan="3"><input
									type="file" class="select_list_inputa" name="turnoverExl"
									id="turnoverExl" value="${ggusercorp.tax }"
									style="color: rgb(153, 153, 153);" /></td>
							</c:if>
							<c:if test="${not empty ggusercorp.tax }">
								<td style="border-bottom:#9CF 1px solid;" colspan="3" class="td-none"><a
									href="${ggusercorp.tax }" class="table_buttonc" target="_blank">查看</a></td>
							</c:if>
						</tr> --%>

						<tr>
							<td></td>
							<td></td>
							<td colspa><a
								style="margin:20px auto;background-color:#008abd;width:80px;cursor:pointer;"
								id="ax1s" onclick="click1()">提交</a></td>
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
// 			document.getElementById("businessLicen1").style.display="";
// 			document.getElementById("businessLicen2").style.display="";
// 			document.getElementById("businessLicen3").style.display="";
		}else {
			document.getElementById("safetyLicense1").style.display="none";
			document.getElementById("safetyLicense2").style.display="none";
			document.getElementById("safetyLicense3").style.display="none";
// 			document.getElementById("businessLicen1").style.display="none";
// 			document.getElementById("businessLicen2").style.display="none";
// 			document.getElementById("businessLicen3").style.display="none";
		}
	}
</script>
<script type="text/javascript">
	function click1() {
		var companyName = document.getElementById("companyName").value;//公司名称
		var corpration = document.getElementById("corpration").value;//法人
		var linkName = document.getElementById("linkName").value;//联系人
		var companyAddress = document.getElementById("companyAddress").value;//联系地址
		// 			var mobile = document.getElementById("mobile").value;//联系座机电话
		var telephone = document.getElementById("telephone").value;//联系电话
		var businessLicenseNo = document.getElementById("businessLicenseNo").value;//营业执照号
		var businessLicenImg = document.getElementById("businessLicenImg").value;//营业执照图片
		var bLicenseDate = document.getElementById("bLicenseDate").value;//营业执照有效期
		var safetyLicenseNo = document.getElementById("safetyLicenseNo").value;//安全生产许可证号
		var safetyLicenseImg = document.getElementById("safetyLicenseImg").value;//安全生产许可证图片
		var sLiceseDate = document.getElementById("sLiceseDate").value;//安全生产许可证有效期
		var standardLevelImg = document.getElementById("standardLevelImg").value; //安全标准化等级图片
		//var riskLevel = document.getElementById("riskLevel").value;
		
		//校验：如果非新开办的企业并且属于“非煤”、“危化”、“烟花爆竹”大类的，营业执照、安全许可证都是必填项
		var flag = document.getElementById("flag").value;//是否新开办企业
		var classCode = document.getElementById("classCode").value;//行业大类
// 		alert("flag:"+flag);
// 		alert("classCode:"+classCode);
		if ((companyName == null) || (companyName == "")) {
			alert("公司名称为空，请输入");
			corpration.focus();
			return;
		}
		if ((corpration == null) || (corpration == "")) {
			alert("法定代表人为空，请输入");
			corpration.focus();
			return;
		}
		if ((linkName == null) || (linkName == "")) {
			alert("请输入联系人");
			linkName.foucs();
			return;
		}
		if ((companyAddress == null) || (companyAddress == "")) {
			alert("请输入联系地址");
			companyAddress.foucs();
			return;
		} /* if ((mobile == null ) || (mobile == "")) {
						alert("请输入座机电话");
						mobile.foucs();
						return;
					} */
		if (telephone.length == 0) {
			alert("请输入手机号码！");
			telephone.focus();
			return false;
		}
		if (telephone.length != 11) {
			alert("请输入有效的手机号码！");
			telephone.focus();
			return false;
		}
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (!myreg.test(telephone)) {
			alert("请输入有效的手机号码！");
			telephone.focus();
			return false;
		}
		if ((businessLicenseNo == null) || (businessLicenseNo == "")) {
			alert("统一社会信用代码为空，请输入");
			businessLicenseNo.focus();
			return false;
		}
		if (((businessLicenImg == null) || (businessLicenImg == ""))
				|| (businessLicenImg == "未选择任何文件")) {
			alert("营业执照证书为空，请选择");
			return false;
		}
		if ((bLicenseDate == null) || (bLicenseDate == "")) {
			alert("营业执照有效期，请输入");
			bLicenseDate.foucs();
			return false;
		}
		if (flag == "1" && classCode == ("610000" || "620000" || "630000")) {
			if ((safetyLicenseNo == null) || (safetyLicenseNo == "")) {
				alert("安全生产许可证号为空，请输入");
				safetyLicenseNo.focus();
				return;
			}
			if (((safetyLicenseImg == null) || (safetyLicenseImg == ""))
					|| (businessLicenImg == "未选择任何文件")) {
				alert("安全生产许可证为空，请选择");
				return;
			}
			if ((sLiceseDate == null) || (sLiceseDate == "")) {
				alert("安全生产许可证截至日期，请输入");
				sLiceseDate.foucs();
				return;
			}
		}
		var form = document.forms["updateForm"];
		form.action = "${basePath }usercorp/updateRegisterInfo";
		form.submit();
		
	}
	//查询营业执照号是否存在
	function checkBusinessNo(o) {
		var val = o.value;
		var businessLicenseNoold = document
				.getElementById("businessLicenseNoold").value;
		$j.ajax({
			type : "get",
			url : "/usercorp/checkBusinessNo?businessNo=" + val
					+ "&businessLicenseNoold=" + businessLicenseNoold,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("统一社会信用代码已存在，请重新输入");
					o.value = "";
					o.focus();
					return false;
				}else if (data == "isNoHave") {
					alert("统一社会信用代码不可为空，请重新输入");
					// 					o.value = "";
					o.focus();
					return ;
				}else if(data == "no") {
					//什么也不做,
				}else {
					//将后台传回来的公司信息放到页面
					//暂时先不做,因为用户填写到这里的时候基本已经把信息填写完了,万一库里的信息与客户填写的信息不符,以填写的为准
					if(confirm("已有一份公司的信息是否需要自动填写?")) {
						$j("#companyName").val(data.companyName);
						$j("#corpration").val(data.corpration);
						$j("#linkName").val(data.linkName);
						$j("#companyAddress").val(data.companyAddress);
						$j("#mobile").val(data.mobile);
						$j("#telephone").val(data.telephone);
						$j("#email").val(data.email);
						$j("#fax").val(data.fax);
						$j("#post").val(data.post);
						$j("#province").val(data.province);
						$j("#city").val(data.city);
						modifyArea('city','county','County');
						$j("#county").val(data.county);
						$j("#classCode").val(data.classCode);
						getClassCode('classCode','businessClass');
						$j("#businessClass").val(data.businessClass);
						
						var businessLicenseDate = new Date(data.businessLicenseDate);
						$j("#bLicenseDate").val(formatDate(businessLicenseDate));
						
						$j("#safetyLicenseNo").val(data.safetyLicenseNo);
						
						var safetyLiceseDate = new Date(data.safetyLiceseDate);
						$j("#sLiceseDate").val(formatDate(safetyLiceseDate));
						
						$j("#standardLevel").val(data.standardLevel);
					}
				}
			},
			error : function() {
				alert("business失败，请稍后再试");
			}
		});
	}
	
	/**格式化时间戳**/
	function formatDate(now)   {       
       var   year = now.getFullYear();       
       var   month=now.getMonth()+1;       
       var   date=now.getDate();       
       var   hour=now.getHours();       
       var   minute=now.getMinutes();       
       var   second=now.getSeconds();       
       return   year+"-"+month+"-"+date/* +"   "+hour+":"+minute+":"+second */;       
    }       
           
	
	
	//查询安全生产许可证是否存在
	function checkSafeNo(s) {
		var flag = document.getElementById("flag").value;//企业类别
		if(flag=='0'){
			return;
		}
		var sa = s.value;
		var safetyLicenseNoold = document.getElementById("safetyLicenseNoold").value;
		$j.ajax({
			type : "get",
			url : "/usercorp/checkSafeNo?safeNo=" + sa + "&safetyLicenseNoold="
					+ safetyLicenseNoold,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("安全生产执照号已存在，请重新输入");
					// 					s.value = "";
					s.focus();
					return;
				}
				if (data == "isNoHave") {
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
	//查询企业名称是否存在
	function checkUserName(n) {
		var uName = n.value;
		var companyNameold = document.getElementById("companyNameold").value;
		$j.ajax({
			type : "get",
			url : "/usercorp/checkUserName?userName=" + uName
					+ "&companyNameold=" + companyNameold,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("该公司名称已存在，请重新输入");
					// 					n.value = "";
					n.focus();
					return;
				}
				if (data == "isNoHave") {
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
	
		/** 校验社会统一信用代码**/
	function checkBusinessLienseNo(label) {
		var regex = /[^_IOZSVa-z\W]{2}\d{6}[^_IOZSVa-z\W]{10}/;
		var businessLienseNo = label.value;
		
		if(!regex.test(businessLienseNo)) {
			alert("无效的社会统一信用代码");
			label.value = "";
			label.onfocus;
			return false;
		}
	}
</script>
</html>
