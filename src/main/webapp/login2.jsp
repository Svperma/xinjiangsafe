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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<title>登录</title>
<link rel="stylesheet" href="${basePath }/css/style.css">
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>

<script type="text/javascript">
	/* 解决iframe下系统超时无法跳出iframe框架的问题 */
	if (window != top)
		top.location.href = location.href;
</script>
</head>

<body style="  min-height: 534px;" onkeydown="enter()">
	<div class="login_main_all">
		<div class="login_main" style="background:url('images/jianguan.jpg') no-repeat;background-size:100%;">
			<div class="login_main_mid">
			<div class="login_main_mid_con" style="float:left;">
				<div style="width:80%;height:80%;margin:4em auto;">
					<h2 style="padding-top:10px;text-align:right;padding-bottom:20px;">产品介绍</h2>
					<a><img src="images/tiaokuan.png" style="width:650px;margin-left:5em;"/></a>
					<p><a style="padding:10px 20px;" href="/fileSource/baoxiantiaokuan.docx">◆保险条款</a>
					<a href="/common/showbeian.jsp" target="_black" style="padding:10px 20px;">◆备案信息</a></p>
				</div>
			</div>
				<form action="login" id="fm" method="post">
					<div class="login_main_mid_con">
						<ul style="background-color:#fff;padding:20px 20px;opacity:0.8;margin-top:8em;">
							<li><h2>平台登录</h2></li>
							<li><input id="userCode" name="userCode" class="inputa" 
								type="text" maxlength="20" value="请输入您的用户名"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);"></li>
							<li><input id="password" name="password" class="inputb" 
								type="password" maxlength="20" value="请输入您的密码"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);"></li>
							<li><input id="ckCode" name="ckCode" class="inputc"
								type="text" maxlength="4" value="请输入验证码" 
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);width:50%;"><a
								class="yanzheng" href="javascript:getImage();"><img id="img"
									src="${basePath }/getImageCode.servlet"></a></li>
							<li><a id="login" class="submit" href="javascript:commit();">登录</a></li>
							<input type="hidden" id="userInd" value="1">
 <li id='regist'><a style='text-decoration:underline;' href='${basePath}/forget.jsp'>忘记密码</a>
<a style='float:right;margin-right:10px;text-decoration:underline;'  href='${basePath }/register.jsp'>企业注册</a></li>
						
						</ul>
					</div>
				</form>
			</div>

		</div>
		<p>©copyright 2016 德圣保险经纪有限公司</p>
	</div>
</body>
<script>
	function getImage() {
		document.getElementById("img").src = "${basePath }/getImageCode.servlet?time="
				+ new Date();
	}

	function commit() {
		var userCode = document.getElementById("userCode").value.replace(" ",
				"");
		if (userCode == null || userCode == "" || userCode == "请输入您的用户名") {
			alert("用户名不能为空");
			return;
		}
		var password = document.getElementById("password").value.replace(" ",
				"");
		if (password == null || password == "" || password == "请输入您的密码") {
			alert("密码不能为空");
			return;
		}
		var ckCode = document.getElementById("ckCode").value.replace(" ", "");
		if (ckCode == null || ckCode == "" || ckCode == "请输入验证码") {
			alert("验证码不能为空");
			return;
		}
		var userInd = document.getElementById("userInd").value;
		document.getElementById("login").innerHTML = "正在登录...";
		$.ajax({
			type : "post",
			url : "${basePath }/user/login",
			data : JSON.stringify({
				"userCode" : userCode,
				"password" : password,
				"userInd":userInd,
				"ckCode" : ckCode
			}),
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if(data == "userTypeError"){
					alert("没有此用户，请重新输入");
					reset();
					return;
				}else
				if (data == "userError") {
					alert("用户名错误，请重新输入");
					reset();
					return;
				} else if (data == "codeError") {
					alert("验证码错误，请重新输入");
					reset();
					return;
				} else if (data == "pwdError") {
					alert("密码错误，请重新输入");
					reset();
					return;
				} else if (data == "jianguan") {
					window.location.href = "${basePath}/publish/initPage";
				} else if (data == "qiye") {
					window.location.href = "${basePath}/noticeList/initData";
				} else if (data == "dsmanager") {
					window.location.href = "${basePath}/dsmanager/initManager";
				} else if (data == "policy") {
					window.location.href = "${basePath}/policyUser/initPolicy";
				} else if (data == "other") {
					window.location.href = "${basePath}/publish/initPage";
				}
			},
			error : function() {
				alert("error");
				document.getElementById("login").innerHTML = "登录";
			}
		});
	}

	function reset() {
		document.getElementById("login").innerHTML = "登录";
		document.getElementById("ckCode").value = "";
	}

	function enter() {
		if (event.keyCode == 13 || event.keyCode == 108) {
			event.keyCode = 9;
			event.returnValue = false;
			document.getElementById("login").click();
		}
	}
</script>
<script type="text/javascript">
	/* var str = location.href;
	var num = str.indexOf("?");
	var subStr = str.substring(num + 1);
	var strs = subStr.split("=");
	if (strs[0] == "type" && strs[1] == "1") {
		document.getElementById("userInd").value = "2";
		var ul = document.getElementsByTagName("ul")[0];
		ul.innerHTML = ul.innerHTML
				+ ("<li id='regist'><a style='float:right;margin-right:20px;text-decoration:underline;'  href='register.jsp'>用户注册</a></li>");
	} */
</script>
</html>