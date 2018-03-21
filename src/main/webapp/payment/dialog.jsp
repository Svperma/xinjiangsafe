<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	p{
		font-size:12px;
		padding-top: 20px;
		text-align: center;
	}
	.title{
		height:30px;
		background-color:#337AB7;
		color:#FFF;
		font-size:16px;
		font-weight:bold;
		padding-top:12px;
		padding-left:5px;
	}
	a{
		padding:5px 20px;
		border:#999 solid 1px;
		font-size:12px;
		background-color:#F1F2F7;
		cursor:pointer;
		text-decoration: none;
	}
	a:hover{
		background-color:#FFF;
	}
	.borderStyle{
		width:380px;
		height:230px;
		border:10px solid #B1B1B1;
	}
	body{
		margin:0px 0px;
	}
	.redirect{
		text-align: center;
		margin-top: 50px;
	}
</style>
</head>
<body>
<div class="borderStyle">
	<div class="title" >登录平台支付 <img onclick="closeDiv()" style="float:right;margin-right:5px;" src="${basePath }/images/close.png"></div>
    <div>
    	<p>请您在新打开的支付平台页面进行支付，支付完成前请不要关闭该窗口</p>
        <div id="btnDiv" class="redirect"> 
        	<a onclick="complete()">已完成支付</a>
            <a onclick="falsed()">支付遇到问题</a>
        </div>
        <div id="payFalse" style="display:none;" class="redirect"> 
        	请尽快拨打客服电话：<font color="RED">400-004-9696</font><br/>
        	工作人员会为您提供帮助。<br/>您的满意是我们不懈的追求。
        </div>
    </div>
</div>
<script type="text/javascript">
	function closeDiv(){
		window.open("${basePath }/qiye/mypolicy/mypolicyCondition.jsp","mainFrame");
		removeDiv();
	}
	function complete(){
		window.open("${basePath }/qiye/mypolicy/mypolicyCondition.jsp","mainFrame");
		removeDiv();
		
	}
	function falsed(){
		var btnDiv = document.getElementById("btnDiv");
		btnDiv.style.display = "none";
		var fal = document.getElementById("payFalse");
		fal.style.display = "";
	}
</script>
</body>
</html>