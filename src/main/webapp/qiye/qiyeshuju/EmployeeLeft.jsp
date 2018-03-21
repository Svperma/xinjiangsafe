<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<jsp:include page="${basePath }/enterprise/etyinclude.jsp"></jsp:include>
</head>
<body>
	<div class="neicont_main_left_cont">
		<div class="neicont_main_left_cont_main">
			<form action="${basePath }/employee/formMit" name="fm" id="fm"
				method="POST" target="resultFrame">
				<div class="select_list_all">
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							style="height:30px;" value="请输入您要查询的员工姓名" name="emName"
							id="emName"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="width: 200px;">
						<input class="select_list_inputa" type="text" maxlength="20"
							style="height:30px;" value="请输入查询的身份证号" name="identityNo"
							id="identityNo"
							onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
							onblur="if(!value){value=defaultValue;this.style.color='#999'}"
							style="color: rgb(153, 153, 153);">
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a href="javascript:submitCh()">查询</a>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a href="javascript:exportExcel();">报表下载</a>
					</div>
					<div class="select_list" style="margin-left:10px;">
						<a style="width:80px;" href="javascript:showDiv('daoru')">批量导入</a>
					</div>
				</div>
			</form>
			<div id="daoru"
				style="position: relative;background-color:white;border:1px solid #CCC;border-radius:5px;padding:10px 20px;display:none;">
				<form name="fml" id="fml"
					action="${basePath}/employee/exportToInputValue" method="post"
					enctype="multipart/form-data">
					<table width="90%">
						<tr>
							<td style="color:red;">选择excel文件：</td>
							<td><input class="select_list_inputa" type="file" name="inp"
								id="inp"></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align:center;"><a
								href="javascript:exportToInputValue();javascript:hide('daoru');"
								style="width:100px;color:#00a6e3;">导入 </a> <a
								href="javascript:hide('daoru');"
								style="width:100px;color:#00a6e3;">取消 </a> <a
								style="color:#57a6e3;" href="${basePath }/fileSource/员工信息导入模板.xls"
								target="_blank">下载模板 </a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<iframe name="resultFrame"
		src="${basePath }/qiye/qiyeshuju/EmployeeInformation.jsp" width="100%"
		frameborder="0" height="100%"></iframe>
</body>
<script type="text/javascript">
	function submitCh() {
		var fm = document.forms["fm"];
		fm.action = "${basePath }/employee/formMit";
		fm.submit();
	}
	function getData(data) {
		return data.companyName;
	}
</script>
<script type="text/javascript">
	function exportExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/employee/exportToExcel";
		fm.submit();
	}
</script>
<script type="text/javascript">
	function demoExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/employee/demoToExcel";
		fm.submit();
	}
</script>
<script type="text/javascript">
	function showDiv(obj) {
		document.getElementById(obj).style.display = '';
		document.getElementById(obj).style.top = "30px";
	}
	function hide(obj) {
		document.getElementById(obj).style.display = "none";
	}
</script>
<script type="text/javascript">
	function exportToInputValue() {
		var str = document.getElementById("inp").value;
		if (str.length == 0) {
			alert("请选择上传文件");
			return false;
		}
		 var formData = new FormData($("#fml")[0]);
     $.ajax({
          url: "${basePath}/employee/exportToInputValue" ,
          type: 'POST',
          data: formData,
          async: false,
          cache: false,
          contentType: false,
          processData: false,
          success: function (returndata) {
          	var returnnum = returndata.substring(returndata.indexOf("+")+1);
          	if (returndata == "typeNofind") {
              alert("文件不是excel类型");
              return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("IsHaveIdentityNoError"+"+"+returnnum)) {
				alert("第"+returnnum+"个身份证号已存在");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("nameIsNotNull"+"+"+returnnum)) {
				alert("第"+returnnum+"个名称不能为空");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("IdIsNotNull"+"+"+returnnum)) {
				alert("第"+returnnum+"个身份证号不可为空");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("IdCardError"+"+"+returnnum)) {
				alert("第"+returnnum+"个身份证号无效");
				return window.location.href = "${basePath}/employee/userDetails";
			}
			/* else if (returndata == ("sexError"+"+"+returnnum)) {
				alert("第"+returnnum+"个性别只能选择'男'或'女'");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("sexIsNotNull"+"+"+returnnum)) {
				alert("第"+returnnum+"个性别不可为空");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("ageIsNotNull"+"+"+returnnum)) {
				alert("第"+returnnum+"个年龄不可为空");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("telphoneIsNotNull"+"+"+returnnum)) {
				alert("第"+returnnum+"个手机号不可为空");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("telphoneError"+"+"+returnnum)) {
				alert("第"+returnnum+"个手机号码无效");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("departmentCodeIsNotNull"+"+"+returnnum)) {
				alert("第"+returnnum+"个工种不可为空");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("departmentCodeError"+"+"+returnnum)) {
				alert("第"+returnnum+"个工种无效");
				return window.location.href = "${basePath}/employee/userDetails";
			}else if (returndata == ("addressIsNotNull"+"+"+returnnum)) {
				alert("第"+returnnum+"个地址不可为空");
				return window.location.href = "${basePath}/employee/userDetails";
			} */
			else if (returndata == ("success"+"+"+returnnum)) {
				alert("共"+returnnum+"个批量导入员工成功！");
				return window.location.href = "${basePath}/employee/userDetails";
			}
          },
          error: function (XMLHttp,status,errorText) {
          		alert(status);
          		alert(errorText);
              alert("导入失败，请稍后重试！");
          }
     });
// 		var sub = document.forms["fml"];
// 		sub.action = "${basePath}/employee/exportToInputValue";
// 		sub.submit();
	}
</script>
</html>
