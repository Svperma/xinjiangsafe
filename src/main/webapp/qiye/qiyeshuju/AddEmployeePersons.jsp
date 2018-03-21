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
<!DOCTYPE html>
<html lang="zh-CN">
<link rel="stylesheet" type="text/css" href="${basePath }/etpcss/style.css">
<script type="text/javascript" src="${basePath }/js/card.js"/>
<head>
<script type="text/javascript" src="${basePath }/js/jquery.min.js"/>
<link rel="stylesheet" type="text/css" media="screen" href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="${basePath }/css/etpStyle.css">
<link rel="stylesheet" href="${basePath }/css/WdatePicker.css">
<script type="text/javascript" src="${basePath }/js/select2css.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<script type="text/javascript" src="${basePath }/js/cardByIdentityNo.js"></script>
<meta charset="utf-8">
<title>首页</title>
</head>
<body>

	<div class="maincont">
		<div class="maincont_mid_cont_right">
			<div class="maincont_mid_cont_right_main">
				<form action="${basePath }/employee/addPersons" method="POST"
					name="fm">
					<table cellpadding="0" cellspacing="0" width="100%" border="0">
						<tr>
							<td style="color:#57a6e3;width:15%;">员工姓名：</td>
							<td><input class="select_list_inputa" type="text"
								maxlength="20" value="请输入员工姓名" name="emName" id="emName"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);">
								<span style="color: red;">*</span>
							</td>
						<tr>
						</tr>
							<td style="color:#57a6e3;width:15%;">员工证件号：</td>
							<td><input class="select_list_inputa" type="text"
								maxlength="18" value="请输入身份证号" name="identityNo"
								id="identityNo"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);">
								<span style="color: red;">*</span>
							</td>
						</tr>
						<!-- <tr>
							<td style="color:#57a6e3;width:10%;">性别：</td>
							<td>
								<div class="select_list">
									<div id="uboxstyle">
										<select name="sex" id="sex">
											<option value="">未说明</option>
											<option value="1">男</option>
											<option value="2">女</option>
										</select>
									</div>
								</div>
							</td>
							<td style="color:#57a6e3;width:10%;">年龄：</td>
							<td><input class="select_list_inputa" type="text"
								maxlength="20" value="请输入人员年龄" name="age" id="age"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);"></td>
						</tr> -->
						<!-- <tr>
							<td style="color:#57a6e3;width:10%;">联系方式：</td>
							<td><input class="select_list_inputa" type="text"
								maxlength="20" value="请输入联系方式" name="telephone" id="telephone"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);"></td>
							<td style="color:#57a6e3;width:15%;">家庭住址：</td>
							<td><input class="select_list_inputa" type="text"
								maxlength="20" value="请输入居住地址" name="address" id="address"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);"></td>
						</tr> -->
						<%-- <tr>
							<td style="color:#57a6e3;width:15%;">工种：</td>
							<td>
								<div class="select_list">
									<div id="uboxstyle">
										<select name="departmentCode" id="departmentCode">
											<c:forEach items="${sessionScope.list_depart }" var="depart">
												<option value="${depart.codeCode }">${depart.codeCName
													}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
						</tr> --%>
					</table>
				</form>
				<div class="maincont_mid_cont_right_bot">
					<a href="#" onclick="submitFm();">确认</a> <a
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
		var IDa = $j("#identityNo").val();
		if (emName == "" || emName == "请输入员工姓名") {
			alert("员工姓名为空，请输入！");
			return false;
		} if (identityNo.value == "" || identityNo.value == "请输入身份证号") {
			alert("身份证号为空，请输入身份证号！");
			return false;
		} if (identityNo.value != null && identityNo.value != "" && identityNo.value != "请输入身份证号") {
			if (checkCardByIdno(IDa)) {
				var url = "${basePath}/employee/addPersons";
				var form = document.forms["fm"];
				form.action = url;
				form.submit();
			} else {//身份证校验
// 			      alert("身份证校验不通过，请重新输入");
			      return false;
		    }
		}
	    var url = "${basePath}/employee/addPersons";
		var form = document.forms["fm"];
		form.action = url;
		form.submit();
	    }
// 			var IDCard = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
// 			var IDa = $j("#identityNo").val();
// 			if (IDCard.test(IDa)) {
// 				if (age == "" || age == "请输入人员年龄") {
// 					alert("员工年龄为空，请重新输入！");
// 					return false;
// 				}
// 				if (telephone == "" || telephone == "请输入联系方式") {
// 					alert("联系方式为空，请输入手机号或座机号！");
// 					return false;
// 				}
// 				if (telephone != "") {
// 					var tele = /^1[0-9]{10}$/;
// 					var flag = tele.test(telephone); //true
// 					if (flag == false) {
// 						alert("手机号验证不通过，重新输入！");
// 						return false;
// 					}
// 				}
// 				if (address == "" || address == "请输入居住地址") {
// 					alert("居住地址为空，请重新填写！");
// 					return false;
// 				}
// 				var url = "${basePath}/employee/addPersons";
// 				var form = document.forms["fm"];
// 				form.action = url;
// 				form.submit();

// 			} else {
// 				alert("证件号不符合要求，请重新输入！");
// 				return false;
// 			}
// 		}
// 		if (age == "" || age == "请输入人员年龄") {
// 			alert("员工年龄为空，请重新输入！");
// 			return false;
// 		}
// 		if (telephone == "" || telephone == "请输入联系方式") {
// 			alert("联系方式为空，请输入手机号或座机号！");
// 			return false;
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
// 			return false;
// 		}
</script>
</html>