<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${basePath }/edit/updatePassWord" name="fm" id="fm">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
          		${sessionScope.ggUser.userName }
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="mypwd" id="mypwd" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newmypwd" id="newmypwd" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="renewmypwd" id="renewmypwd" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newmypwd:两次输入的密码不一致" />          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <a id="updatepwd" class="button bg-main icon-check-square-o" href = "javascript:submit();">提交</a>   
          <a class="button bg-main icon-check-square-o" href = "javascript:history.go(-1);">返回</a>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body>
<script type="text/javascript">
function submit(){
	var mypwd = document.getElementById("mypwd").value.replace(" ", "");
	var newmypwd = document.getElementById("newmypwd").value.replace(" ", "");
	var renewmypwd = document.getElementById("renewmypwd").value.replace(" ", "");
	if (mypwd == null || mypwd == "") {
		alert("请输入原始密码");
		return;
	}if (newmypwd == null || newmypwd == "") {
		alert("请输入新密码");
		return;
	}if (renewmypwd == null || renewmypwd == "") {
		alert("请确认新密码");
		return;
	}
	$.ajax({
			type : "post",
			url : "${basePath }/edit/updatePassWord",
			data : JSON.stringify({
				"mypwd" : mypwd,
				"newmypwd" : newmypwd,
				"renewmypwd":renewmypwd
			}),
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if(data == "pwdError"){
					alert("原始密码错误,请重新输入");
					reset();
					return;
				}else if (data == "twoPWDdifferent") {
					alert("输入的密码不一致，请重新输入");
					reset();
					return;
				} else  if (data == "userInd1Succes") {
					alert("修改密码成功，请重新登录");
					window.open("/login.jsp","_parent");
				}else  if (data == "userInd2Succes") {
					alert("修改密码成功，请重新登录");
					window.open("/login.jsp?type=1","_parent");
				} else  if (data == "adminSucces") {
					alert("修改密码成功，请重新登录");
					window.open("/admin/login.jsp","_parent");
				} 
			},
			error : function() {
				alert("error");
				reset();
				document.getElementById("updatepwd").innerHTML = "提交";
			}
		});
}
function reset() {
		document.getElementById("updatepwd").innerHTML = "提交";
		document.getElementById("mypwd").value = "";
		document.getElementById("newmypwd").value = "";
		document.getElementById("renewmypwd").value = "";
	}
</script>
</html>