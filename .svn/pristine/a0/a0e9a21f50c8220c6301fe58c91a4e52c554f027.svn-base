<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
* {
	font-family: "微软雅黑";
}
#div_back .a_back {
	display: inline-block;
	margin: 20px auto;
	padding: 7px 20px;
	background: #00a6e3;
	-moz-border-radius: 8px;
	-webkit-border-radius: 8px;
	border-radius: 8px;
	color: #fff;
	width: 60px;
	font-size: 14px;
}
</style>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
</head>
<body style="background-color:#ededed;">
	<div
		style="width:700px;height:650px;margin: 0 auto;background-color:#ededed;padding: 30px;">
		<div style="border: 1px solid white;border-radius:10px;">
			<div
				style="background-color:#00a6e3;padding-top: 20px;border-top-left-radius:10px;border-top-right-radius:10px;">
				<span
					style="background-color:white;margin-left: 30px;padding: 5px 10px;border-radius:5px;">用户注册</span>
			</div>
			<div style="padding:10px;background-color:white;">
				<!-- <div
					style="border-radius:5px;height:100px;background-color:#ededed;padding:5px;">
					<p>注册须知：</p>
				</div> -->
				<div
					style="background: url('/images/register_bg_new.jpg');background-repeat: no-repeat;padding: 30px;height: 400px;background-size:678px 432px;
				border-bottom-left-radius:10px;border-bottom-right-radius:10px;">
					<span
						style="float:left;margin-top:-20px;margin-left:50px;background-color: white;color:#FDAF3F;font-weight: bold;">用户注册（带*的为必填项）</span>
					<div style="clear:both;"></div>
					<form action="">
						<table cellpadding="10px">
							<tr>
								<td>用户名:</td>
								<td><input type="text" name="userCode" id="userCode"
									onblur="checkUserCode(this)" maxlength="15"><span
									style="color:#FD9705;">*</span></td>
							</tr>
							<tr>
								<td>登录密码:</td>
								<td><input type="password" name="password" id="password" maxlength="15"><span
									style="color:#FD9705;">*</span></td>
							</tr>
							<tr>
								<td>确认密码:</td>
								<td><input type="password" name="confirmPwd"
									id="comfirmPwd" maxlength="15"><span style="color:#FD9705;">*</span></td>
							</tr>
							<tr>
								<td>验证码:</td>
								<td><input type="text" name="ckCode" id="ckCode" maxlength="4"></td>
							</tr>
							<tr>
								<td></td>
								<td>
								<a class="yanzheng" href="javascript:getImage();">
										<img id="img" src="${basePath }/getImageCode.servlet">
								</a>
								</td>
							</tr>
						</table>
						
						<div style="margin-top:30px;margin-left:5px;padding-top:4%;">
							<div id="">
								<a href="javascript:submitFm();" id = "imgSum" 
								style="display: inline-block; margin: 20px auto; text-decoration:none;
								padding: 7px 20px; background: #00a6e3;
								-moz-border-radius: 6px; -webkit-border-radius: 6px; border-radius: 6px;
								color: #fff; width: 60px; font-size: 14px;" readonly >
								确定注册
								</a>
								<a href="javascript:reset();" 
								style="display: inline-block; margin: 20px auto; text-decoration:none;
								padding: 7px 20px; background: #00a6e3;
								-moz-border-radius: 6px; -webkit-border-radius: 6px; border-radius: 6px;
								color: #fff; width: 60px; font-size: 14px;"
								>重新输入</a>
							</div>
						</div>
					</form>
					<script type="text/javascript">
						function getImage() {
							document.getElementById("img").src = "${basePath }/getImageCode.servlet?time="
									+ new Date();
						}
						function checkQuery() {
							var t = document.getElementById("tiaokuan");
							if (t.value == "1") {
								t.value = "0";
								document.getElementById("imgSum").style.background ="#ededed";
								document.getElementById("imgSum").href = "#";
							}else if (t.value == "0") {
								t.value = "1";
								document.getElementById("imgSum").style.background ="#00a6e3";
								document.getElementById("imgSum").href = "javascript:submitFm();";
							}
						}
						function tiaokuan(){
							window.open("${basePath}/Provision.html");
						}
					</script>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function reset() {
		document.getElementById("userCode").value="";
		document.getElementById("password").value = "";
		document.getElementById("comfirmPwd").value = "";
// 		document.getElementById("userName").value = "";
// 		document.getElementById("linkName").value = "";
// 		document.getElementById("telePhone").value = "";
		document.getElementById("ckCode").value = "";
	}
	function submitFm() {
		var userCode = $("#userCode").val();
		var password = $("#password").val();
		var comfirmPwd = $("#comfirmPwd").val();
		var ckCode = $("#ckCode").val().replace(" ", "");
// 		var linkName = $("#linkName").val();
// 		var telePhone = $("#telePhone").val();

		if (userCode == null || userCode == "") {
			alert("登陆账号不能为空");
			return;
		} if (password == null || password == "") {
			alert("密码不能为空");
			return;
		} if (password != comfirmPwd) {
			alert("两次输入的密码不同");
			return;
		} /* var ckCode = document.getElementById("ckCode").value.replace(" ", ""); */
		if (ckCode == null || ckCode == "" ) {
			alert("验证码不能为空");
			return;
		}
// 		if (linkName == null || linkName == "") {
// 			alert("联系人不能为空");
// 			return;
// 		} if (telePhone == null || telePhone == "") {
// 			alert("联系方式不能为空");
// 			return;
// 		}
		$.ajax({
			type : "post",
			url : "/register",
			data : JSON.stringify({
				"userCode" : userCode,
				"password" : password,
				"ckCode" : ckCode
// 				"userName" : $("#userName").val(),
// 				"linkName" : linkName,
// 				"telePhone" : telePhone
			}),
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "success") {
					var con = window.confirm("恭喜您，注册成功，是否直接登录？");
					if (con == true) {
						window.open("login.jsp", "_parent");
					} else {
						window.open("index.jsp", "_parent");
					}
				}if (data == "codeError") {
					alert("验证码输入错误，请重新输入");
					return;
				}
				;
			},
			error : function() {
				alert("注册失败，请稍后再试");
			}
		});
	}

	function checkUserCode(o) {
		var val = o.value;
		$.ajax({
			type : "get",
			url : "/user/checkUser?userCode=" + val,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("账号已存在！");
					o.value = "";
					o.focus();
				}

			},
			error : function() {
				alert("注册失败，请稍后再试");
			}
		});
	}
</script>
</html>