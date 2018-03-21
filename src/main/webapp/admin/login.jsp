<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <title>登录</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="${basePath }user/login" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="name" id="name" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" id="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="code" id="ckCode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img src="${basePath }/getImageCode.servlet" id="img" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="getImage()">  
                                                   
                        </div>
                    </div>
                </div>
                <div style="padding:30px;"><input type="button" id="login" onclick="commit()" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
	function getImage(){
		 document.getElementById("img").src="${basePath }/getImageCode.servlet?time="+new Date();
	}
	
	function commit(){
		var name = document.getElementById("name").value.replace(" ","");
		if(name == null || name == ""){
			alert("用户名不能为空");
			return;
		}
		var password = document.getElementById("password").value.replace(" ","");
		if(password == null || password == ""){
			alert("密码不能为空");
			return;
		}
		var  ckCode = document.getElementById("ckCode").value.replace(" ","");
		if(ckCode == null || ckCode == ""){
			alert("验证码不能为空");
			return;
		}
		document.getElementById("login").value = "正在登录...";
		$.ajax({
			type:"post",
			url:"${basePath }/user/login",
			data : JSON.stringify({
				"userCode":name,
				"password":password,
				"ckCode":ckCode
			}),
			dataType:"json",
			contentType:"application/json;charset=UTF-8", 
			success:function(data){
				if(data == "userError"){
					alert("用户名错误，请重新输入");
					reset();
					return;
				}else
				if(data == "codeError"){
					alert("验证码错误，请重新输入");
					reset();
					return;
				}else
				if(data == "pwdError"){
					alert("密码错误，请重新输入");
					reset();
					return;
				}else if(data == "admin"){
					window.location.href="${basePath}/admin/index.jsp";
				}
			},
			error:function(){
				alert("error");
				document.getElementById("login").innerHTML = "登录";
			}
		});
	}
</script>
</html>