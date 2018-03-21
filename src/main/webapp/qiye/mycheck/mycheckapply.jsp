<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="gc"%>

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
<title>My JSP 'mycheckResult.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath }/css/etpStyle.css">
<link rel="stylesheet" href="${basePath }/css/WdatePicker.css">
<script type="text/javascript" src="${basePath }/js/select2css.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="${basePath }/js/calendar/WdatePicker.js"></script>
</head>

<body>
	<div class="maincont">
		<div class="maincont_mid_cont_right">
			<div id="evaluateId" style="border-radius:5px; position:absolute;top:10px;z-index:9999;width:100%;background-color:white;">
				<div style="text-align:left;width:100%; opacity:1.0;">
				<div style="clear:both;"></div>
				</div>

				<!-- --------------------------------------------------------------------------------------------- -->
				<!-- --------------------------------------------------------------------------------------------- -->
				<!-- --------------------------------------------------------------------------------------------- -->
				<!-- --------------------------------------------------------------------------------------------- -->
			<div class="content" id="other">
					<div style="width:100%;height:360px;">
						<form action="" name="apply">
							<div style="margin-left:-1200px;font-size:30px;" >批单申请
							<% String k =request.getParameter("businessno"); %>
								<input type="hidden" value="<%=k%>" id="businessno" name="businessno">
							</div>
							<div style=" height: 40px; width: 400px; margin-left: 120px; font-size: 18px;" >
								<span style="float: left; margin-left: 30px">批单生效日期:</span><span></span><input class="select_list_inputa"
					style=" margin-left:20px; width: 130px;height:30px;" type="text" maxlength="20"
					value="批单开始日期" name="startDate" id="startDate"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
					onblur="if(!value){value=defaultValue;this.style.color='#999'}"
					onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
					style="color: rgb(153, 153, 153);">
							</div>
							<div><textarea rows="15px" cols="200px;" id="content" name="content" style="text-align: left;"></textarea></div>
						</form>
					</div>
				<div style="backgroun-color:white;padding:15px 0px; "
					class="border-left border-right border-bottom">
					<a href="javascript:sumPingjia();"
						style="padding:5px 15px;background-color:#00A6E3;border-radius:5px;color:#FFFFFF">提交批单</a>
					<a href="javascript:history.go(-1);"
						style="padding:5px 15px;background-color:#00A6E3;border-radius:5px;color:#FFFFFF;">返回</a>
				</div>
			
			</div>
		<div class="clearboth"></div>
	</div>
</div>
</body>
<script type="text/javascript">
	function sumPingjia(){
		var content = document.getElementById("content").value;
		var startDate = document.getElementById("startDate").value;
		if (content == null || content == "") {
			alert("请输入批单内容");
			return;
		}
		if (startDate == null || startDate == ""){
			alert("请选择批单生效日期");
			return;
		}
		var businessno = document.getElementById("businessno").value;
		$.ajax({
			type : "post",
			contentType:"application/json;charset=UTF-8",
			data:JSON.stringify({
					"content":content,
					"businessno":businessno,
					"startDate":startDate
			}),
			url : "${basepath }/mycheck/mycheckApply",
			success : function(data) {
				if (data == "success") {
					alert("提交成功！");
// 					window.location.href = "${basePath}/qiye/mycheck/mycheckCondition.jsp";
					window.location.href = "/mycheck/mycheckinit";
					return;
				}
			},
			error : function(){
				alert("提交出错，请稍后重试！");
				return;
			}
		});
	}
</script>
</html>
