<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" href="${basePath }/css/etpStyle.css">
<link rel="stylesheet" href="${basePath }/css/WdatePicker.css">
<script type="text/javascript" src="${basePath }/js/select2css.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<script type="text/javascript" src="${basePath }/js/cardByIdentityNo.js"></script>
</head>
<body>
	<div class="maincont">
		<div class="maincont_mid_cont_right">
			<div class="maincont_mid_cont_right_main">

				<form action="${basePath }/employee/updateForms" method="POST"
					name="fm" id="fm">
					<table cellpadding="0" cellspacing="0" width="100%" border="0">
						<c:forEach items="${list_summit }" var="queryPersons">
							<tr>
								<td style="color:#57a6e3;width:15%;">员工姓名：</td>
								<td><input type="hidden" name="emId" id="emId"
									value="${queryPersons.EMID }"> <input
									class="select_list_inputa" type="text" style="width:350px;"
									maxlength="20" value="${queryPersons.EMNAME }" name="emName"
									id="emName"
									onfocus="if(value==defaultValue){value='${queryPersons.EMNAME }';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);"></td>
							</tr>
							<tr>
								<td style="color:#57a6e3;width:15%;">身份证号：</td>
								<td><input class="select_list_inputa" type="text"
									style="width:350px;" maxlength="18"
									value="${queryPersons.IDENTITYNO }" name="identityNo"
									id="identityNo"
									onfocus="if(value==defaultValue){value='${queryPersons.IDENTITYNO }';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);"></td>
							</tr>
							<%-- <tr>
								<td style="color:#57a6e3;width:10%;">性别：</td>
								<td>
									<div class="select_list">
										<div id="uboxstyle">
											<select name="sex" id="sex" style="width:80px;">
												<c:if test="${queryPersons.SEX  eq '1'}">
													<option value="${queryPersons.SEX }" selected="selected">男</option>
													<option value="2">女</option>
												</c:if>
												<c:if test="${queryPersons.SEX  eq '2'}">
													<option value="${queryPersons.SEX }" selected="selected">女</option>
													<option value="1">男</option>
												</c:if>
											</select>
										</div>
									</div>
								</td>
								<td style="color:#57a6e3;width:10%;">年龄：</td>
								<td><input class="select_list_inputa" type="text"
									style="width:100%;" maxlength="20" value="${queryPersons.AGE }"
									name="age" id="age"
									onfocus="if(value==defaultValue){value='${queryPersons.AGE }';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);"></td>
							</tr>
							<tr>
								<td style="color:#57a6e3;width:10%;">联系方式：</td>
								<td><input class="select_list_inputa" type="text"
									style="width:100%;" maxlength="20"
									value="${queryPersons.TELEPHONE }" name="telephone"
									id="telephone"
									onfocus="if(value==defaultValue){value='${queryPersons.TELEPHONE }';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);"></td>
								<td style="color:#57a6e3;width:15%;">家庭住址：</td>
								<td><input class="select_list_inputa" type="text"
									style="width:100%;" maxlength="20"
									value="${queryPersons.ADDRESS }" name="address" id="address"
									onfocus="if(value==defaultValue){value='${queryPersons.ADDRESS }';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);"></td>
							</tr>
							<tr>
								<td style="color:#57a6e3;width:15%;">隶属部门：</td>
								<td>
									<div class="select_list">
										<div id="uboxstyle">
											<select name="departmentCode" id="departmentCode"
												style="width:80px;">
												<c:forEach items="${list_depart }" var="dar">
													<c:if test="${queryPersons.DEPARTMENTCODE eq dar.codeCode }">
														<option value="${dar.codeCode }" selected="selected">${dar.codeCName
															}</option>
													</c:if>
													<c:if
														test="${queryPersons.DEPARTMENTCODE != dar.codeCode }">
														<option value="${dar.codeCode }">${dar.codeCName
															}</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
								</td>
							</tr> --%>
						</c:forEach>
					</table>
				</form>
				<div class="maincont_mid_cont_right_bot">
					<a href="javascript:submitFm();">确认</a> <a
						href="javascript:history.go(-1);">返回</a>
				</div>
			</div>
		</div>
		<div class="clearboth"></div>
	</div>
</body>
<script type="text/javascript">
	var $j = jQuery.noConflict();
	function submitFm() {
		var emName = document.getElementById("emName").value;
		var identityNo = document.getElementById("identityNo");
// 		var age = document.getElementById("age").value;
// 		var telephone = document.getElementById("telephone").value;
// 		var address = document.getElementById("address").value;
		if (emName == "" || emName == "请输入员工姓名") {
			alert("员工姓名为空，请输入！");
			return;
		}
		if (identityNo.value == "" || identityNo.value == "请输入员工证件号") {
			alert("证件号为空，请输入身份证号！");
			return;
		}
		if (identityNo.value != "") {
// 			var IDCard = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
			var IDa = $j("#identityNo").val();
			if (checkCardByIdno(IDa)) {
// 				if (age == "" || age == "请输入人员年龄") {
// 					alert("员工年龄为空，请重新输入！");
// 					return;
// 				}
// 				if (telephone == "" || telephone == "请输入联系方式") {
// 					alert("联系方式为空，请输入手机号或座机号！");
// 					return;
// 				}
// 				if (telephone != "") {
// 					var tele = /^1[0-9]{10}$/;
// 					var flag = tele.test(telephone); //true
// 					if (flag == false) {
// 						alert("手机号验证不通过，重新输入！");
// 						return;
// 					}
// 				}
// 				if (address == "" || address == "请输入居住地址") {
// 					alert("居住地址为空，请重新填写！");
// 					return;
// 				}
				var url = "${basePath}/employee/updateForms";
				var form = document.forms["fm"];
				form.action = url;
				form.submit();
			} else {
// 				alert("证件号不符合要求，请重新输入！");
				return;
			}
		}
// 		if (age == "" || age == "请输入人员年龄") {
// 			alert("员工年龄为空，请重新输入！");
// 			return;
// 		}
// 		if (telephone == "" || telephone == "请输入联系方式") {
// 			alert("联系方式为空，请输入手机号或座机号！");
// 			return;
// 		}
// 		if (telephone != "") {
// 			var tele = /^1[0-9]{10}$/;
// 			var flag = tele.test(telephone); //true
// 			if (flag == false) {
// 				alert("手机号验证不通过，重新输入！");
// 			}
// 		}
// 		if (address == "" || address == "请输入居住地址") {
// 			alert("居住地址为空，请重新填写！");
// 			return;
// 		}
		var url = "${basePath}/employee/updateForms";
		var form = document.forms["fm"];
		form.action = url;
		form.submit();
	}
</script>
</html>