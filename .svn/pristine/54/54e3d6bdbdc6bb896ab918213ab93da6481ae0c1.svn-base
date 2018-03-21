<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/common/include.jsp" />
<html>
  <head>
    <base href="<%=basePath%>">
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/select2css.js"></script>
	<script type="text/javascript" src="js/readXml.js"></script>
	<script type="text/javascript" src="${basePath }/js/common.js"></script>
	<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
  </head>
  <body>
    <input type="hidden" id="province" value="${sessionScope.ggUser.province }">
	<input type="hidden" id="city" value="${sessionScope.ggUser.city }">
	<input type="hidden" id="county" value="${sessionScope.ggUser.county }">
	<input type="hidden" id="comLevel" value="${sessionScope.ggUser.comLevel }">
    	<div class="neicont_main_left_cont">
        	<div class="neicont_img"><img src="images/icotit1.jpg">地区选择</div>
            <div class="neicont_main_left_cont_main">
            <form action="${basePath }/policyUser/adminquery" name="Adminer" method="get" target="resultFrame">
		            	<div class="select_list_all">
            		<div class="select_list" id="c_province1" onclick="findArea('province','province',1,'province1','city1')">
            			<div id="uboxstyle">
            					<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
								<input type="hidden" id="hidden_province1" name="hidden_province1"
								value="${sessionScope.province.codeCode }">
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
								<input type="hidden" id="hidden_province1" name="hidden_province1"
								value="">
								</c:if>
								<select name="province1" id="province1">
								<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
								<option value="${sessionScope.province.codeCode }">
									${sessionScope.province.codeCName}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
								<option value="选择省份">选择省份</option>
								</c:if>
								</select>
            			</div>
            		</div>
            	<div class="select_list" id="c_city1" onclick="findArea('hidden_province1','city',2,'city1','county1')">
           			 <div id="uboxstyle">
							<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
											<input type="hidden" id="hidden_city1" name="hidden_city1"
												value="${sessionScope.city.codeCode }">
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 2 }">
										<input type="hidden" id="hidden_city1" name="hidden_city1"
											value="">
							</c:if>
							<select name="city1" id="city1">
								<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
									<option value="${sessionScope.city.codeCode }">${sessionScope.city.codeCName
										}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 2 }">
									<option value="选择城市">选择城市</option>
								</c:if>
							</select>
						</div>
				</div>
				<div class="select_list" id="c_county1"
					onclick="findArea('hidden_city1','county',3,'county1',null)" >
					<div id="uboxstyle">
						<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
							<input type="hidden" id="hidden_county1" name="hidden_county1"
								value="${sessionScope.county.codeCode }">
						</c:if>
						<c:if test="${sessionScope.ggUser.comLevel < 3 }">
							<input type="hidden" id="hidden_county1" name="hidden_county1"
								value="">
						</c:if>
						<select name="county1" id="county1">
							<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
								<option value="${sessionScope.county.codeCode }">${sessionScope.county.codeCName}
								</option>
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 3 }">
								<option value="选择区县">选择区县</option>
							</c:if>
						</select>
					</div>
				</div>
				<div class="select_list" id="userTypes">
					<div id="uboxstyle">
						<select name="userType" id="userType">
							<option value="" selected="selected">选择操作权限</option>
							<option value="0">分支机构</option>
							<option value="1">业务员</option>
						</select>
					</div>
				</div>
			</div>
		<div class="select_list_all">
			<div class="select_list" style="width: 200px;">
				<input class="select_list_inputa" type="text" maxlength="20" name="UserName" id="UserName" value="请输入需要查询的用户名" onfocus="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#999'}" style="color: rgb(153, 153, 153);">
			</div>
			<div class="select_list" style="margin-left:100px;">
				<a href="javascript:submitAdminer();">查询</a>
			</div>
			<div class="select_list">
				<c:if test="${sessionScope.ggUser.flag ==0 }"><a href="javascript:void(0);" onclick="addUser()">添加用户</a></c:if>
			</div>
		</div>
		</form>
	</div>
</div> 
	<iframe name="resultFrame" style="background-color:#F1F1F1;margin-top:10px;" src="/policyUser/adminquery" width="100%" frameborder="0" height="100%">
				
	</iframe>
	<style>
#addUser{width:500px;height:400px;background:#ebebeb;font-size:14px;border:1px solid #ccc;position:absolute;z-index:9;display:none;}
#form{width:500px;height:350px;margin:20px;z-index:10;}
#form input{margin:7px 10px;text-align:left;padding-left:10px;}
#form #dep{width:70px;margin:7px 10px;height:22px;border-radius:3px}
#uboxstyle ul.tag_options li{}
</style>
<div id="addUser">
	<div id="form">
		登录账号：<input id="userCode" name="userCode" type="text" class="select_list_inputa" style="color: rgb(153, 153, 153);" placeholder="请输入登录账号" /><br />
		登录密码：<input id="password" name="password" type="password" class="select_list_inputa" style="color: rgb(153, 153, 153);" placeholder="请输入登录密码"/><br />
		用户名称：<input id="userName" name="userName" type="text" class="select_list_inputa" style="color: rgb(153, 153, 153);" placeholder="请输入用户名称" /><br />
		联系人：<input id="linkName" name="linkName" type="text" class="select_list_inputa" style="color: rgb(153, 153, 153);" placeholder="请输入联系人" /><br />
		联系电话：<input id="telePhone" name="telePhone" type="text" class="select_list_inputa" style="color: rgb(153, 153, 153);" placeholder="请输入联系电话" /><br />
		<div class="select_list" style="margin:20px 0 0 20px; float: left;">
			<div id="uboxstyle">
				<select name="division" id="division" style="display: none;">
					<option value="100002">保险公司</option>
				</select>
			</div>
		</div>
		<div class="select_list" style="margin:20px 0 20px;">
			<div id="uboxstyle">
				<select name="flag" id="flag" style="display: none;">
					<option value="选择操作权限" selected="selected">选择操作权限</option>
					<option value="0">分支机构</option>
					<option value="1">业务员</option>
				</select>
			</div>
		</div>
		<div class="select_list" style="margin:20px 0  20px; ">
			<div id="uboxstyle" >
				<select name="discopy" id="discopy" style="display: inline-block;">
					<option value="选择用户等级" selected="selected">选择用户等级</option>
					<option value="2">市级用户</option>
					<option value="3">县级用户</option>
				</select>
			</div>
		</div>
		<br />
		<div style="clear:both;"></div>
		<div class="select_list_all">
			<div class="select_list" style="margin-top:20px;" id="c_province2" onclick="findArea('province2','province2',1,'province2','city2')">
				<div id="uboxstyle">
					  	<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
								<input type="hidden" id="hidden_province2" name="hidden_province2"
								value="${sessionScope.province.codeCode }">
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
								<input type="hidden" id="hidden_province2" name="hidden_province2"
								value="">
								</c:if>
								<select name="province2" id="province2">
								<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
								<option value="${sessionScope.province.codeCode }">
									${sessionScope.province.codeCName}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
								<option value="选择省份">选择省份</option>
								</c:if>
								</select>
								
				</div>
			</div>
			<div class="select_list" style="margin-top:20px" id="c_city2" onclick="findArea('hidden_province2','city',2,'city2','county2')">
				<div id="uboxstyle">
				  	<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
											<input type="hidden" id="hidden_city2" name="hidden_city2"
												value="${sessionScope.city.codeCode }">
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 2 }">
										<input type="hidden" id="hidden_city2" name="hidden_city2"
											value="">
							</c:if>
							<select name="city2" id="city2">
								<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
									<option value="${sessionScope.city.codeCode }">${sessionScope.city.codeCName
										}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 2 }">
									<option value="选择城市">选择城市</option>
								</c:if>
							</select>
						
				</div>
			</div>
			<div class="select_list" style="margin-top:20px" id="c_county2" onclick="findArea('hidden_city2','county',3,'county2',null)" >
				<div id="uboxstyle">
					  	<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
							<input type="hidden" id="hidden_county2" name="hidden_county2"
								value="${sessionScope.county.codeCode }">
						</c:if>
						<c:if test="${sessionScope.ggUser.comLevel < 3 }">
							<input type="hidden" id="hidden_county2" name="hidden_county2"
								value="">
						</c:if>
						<select name="county2" id="county2" >
							<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
								<option value="${sessionScope.county.codeCode }">${sessionScope.county.codeCName}
								</option>
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 3 }">
								<option value="选择区县">选择区县</option>
							</c:if>
						</select>
					
				</div>
			</div>
		</div>
		<div style="clear:both;"></div>
		<div class="select_list" style="margin-left:100px;margin-top:30px;">
			<a href="javascript:getInsert()" onclick="close()">确定添加</a>
		</div>
		<div class="select_list" style="margin-left:10px;margin-top:30px;">
			<a href="javascript:close()" onclick="close()">取消</a>
		</div>
	</div>
</div>
<script type="text/javascript">
function addUser(){
	var div = $j("#addUser");
	var divHeight = div.height();
	var divWidth = div.width();
	document.getElementById("userCode").value = "";
	document.getElementById("password").value = "";
	var divTop = ($j(window).height()-divHeight)/2;
	var divLeft = ($j(window).width()-divWidth)/2;
	div.css({"top":divTop,"left":divLeft,"display":"block"});
}

function close(){
	$j("#addUser").css({"display":"none"});
}
	 
function getInsert(){
 		var  userCode = document.getElementById("userCode").value.replace(" ","");
 		if(userCode == null || userCode == "" || userCode =="请输入登录账号"){
			alert("用户名不能为空");
			return;
		}
 		var  telePhone = document.getElementById("telePhone").value.replace(" ","");
 		if(telePhone == null || telePhone == "" || telePhone =="请输入联系电话"){
			alert("联系电话不能为空");
			return;
		}
 		var  linkName = document.getElementById("linkName").value.replace(" ","");
 		if(linkName == null || linkName == "" || linkName =="请输入联系人"){
			alert("联系人不能为空");
			return;
		}
 		
		var password = document.getElementById("password").value;
		
		var userName = document.getElementById("userName").value;
		if(userName == null || userName == "" || userName == "请输入用户名称"){
			alert("用户名称不能为空");
			return;
		}
		
		var division = document.getElementById("division").value;
		if(division == null || division == "" || division == "选择部门"){
			alert("用户部门不能为空");
			return;
		}
		
		var flag = document.getElementById("flag").value;
		if(flag == null || flag == "" || flag == "选择操作权限"){
			alert("用户权限不能为空");
			return;
		}
		
		
		var province2 = document.getElementById("province2").value;
		var city2 = document.getElementById("city2").value;
		if(city2 == null || city2 == "" || city2 == "选择城市"){
			city2="";
		}
		var county2 = document.getElementById("county2").value;
		if(county2 == null || county2 == "" || county2 == "选择区县"){
			county2="";
		}
		
		var discopy = document.getElementById("discopy").value;
		if(discopy==null || discopy =="" || discopy =="选择用户等级" ){
			alert("用户等级不允许为空");
			return;
		}
		
		$j.ajax({
			type:"post",
			url:"${basePath}/policyUser/admininsert",
			data: JSON.stringify({
				"userCode":userCode,
				"password":password,
				"userName":userName,
			    "division":division,
				"flag":flag,
				"province":province2,
				"city":city2,
				"county":county2,
				"comLevel":discopy,
				"telePhone":telePhone,
				"linkName":linkName,
			}),
			dataType:"json",
			contentType:"application/json;charset=UTF-8",
			success: function(data){
				if(data == "success" ){
						alert("用户添加成功");
						close();
						window.location.href="/policyUser/administrationCondition.jsp";
						return;
				
				}else
				if(data == "falsess"){
						alert("用户已存在");
						close();
						return;
				}
			
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert(XMLHttpRequest.responseText);
				alert(textStatus);
				alert("出现错误");
			}
			
			
		});
 }
 	function submitAdminer(){
 		var province = document.getElementById("province1").value;
		var city = document.getElementById("city1").value;
		var county = document.getElementById("county1").value;
		var UserName = document.getElementById("UserName").value;
		if(UserName == "请输入需要查询的用户名"){
			document.getElementById("UserName").value="";
		}
		if (province == "选择省份") {
			province = null;
		}
		if (province == null ) {
			alert("请选择省份！");
			return;
		}
		if (city == "选择城市" ) {
			document.getElementById("hidden_city1").value = "";
			document.getElementById("hidden_county1").value = "";
			document.getElementById("select_info_county1").innerHTML ="选择区县"
		}
		if (county == "选择区县") {
			document.getElementById("hidden_county1").value = "";
		}
		
		if (county != null && city == null && province != null ) {
			document.getElementById("hidden_county1").value = "";
			alert("请选择城市");
			return;
		}
		if (county != null && city == null && province == null ) {
			alert("请选择省份");
			return;
		}
		if (county != null && city != null && province == null) {
			alert("请选择省份");
			return;
		}
		if (province != null || province != "选择省份") {
			document.forms["Adminer"].submit();
		}
		if (province != null && city != null ) {
			document.forms["Adminer"].submit();
		}
		if (county != null && city != null && province != null) {
			document.forms["Adminer"].submit();
		}
		
	}	
	

</script>
  </body>
</html>
