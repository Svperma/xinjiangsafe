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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyHonorReport.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<jsp:include page="${basePath }/enterprise/etyinclude.jsp" />
<script src="/js/calendar/WdatePicker.js" type="text/javascript"></script>
</head>

<body>
	<div class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_top">
			<form action="${basePath }/honor/selectClass" name="fm" id="fm"
				target="resultFrame">
				<div class="select_list_all">
					<div class="select_list" style="margin-left:30px;">
						<div id="uboxstyle">
							<select name="honorCode" id="honorCode">
								<option selected="selected">请选择荣誉级别</option>
								<option value="1">国家级</option>
								<option value="2">省级</option>
								<option value="3">市级</option>
								<option value="4">区县级</option>
							</select>
						</div>
					</div>
					<div class="select_list" style="margin-left:30px;">
						<a style="  width: 80px;height:27px;"
							href="javascript:selectClass();">查询</a>
					</div>
					<div class="select_list" style="margin-left:-20px;">
						<a style="  width: 80px;height:27px;" href="javascript:showDiv();">添加</a>
					</div>
				</div>
			</form>
			<script type="text/javascript">
				function selectClass() {
					var honorCode = document.getElementById("honorCode").value;
					if (honorCode == "" || honorCode == "请选择荣誉级别") {
						alert("查询条件为空，请选择查询的荣誉等级！");
					} else {
						var fm = document.forms["fm"];
						fm.action = "${basePath}/honor/selectClass";
						fm.submit();
					}
				}
			</script>

			<div id="baoan"
				style="position: relative;background-color:white;border:1px solid #CCC;border-radius:5px;padding:10px 20px;display:none;">
				<form action="${basePath }/honor/addHonor" name="addHonor"
					id="addHonor" method="POST" target="resultFrame"
					style="position:relative;" enctype="multipart/form-data">
					<table width="90%">
						<tr>
							<td>荣誉名称：</td>
							<td><input class="select_list_inputa" type="text"
								name="honor" id="honor"></td>
							<td>获得日期：</td>
							<td>
								<input class="select_list_inputa" style="  width: 130px;"
								type="text" maxlength="20" value="请输入日期" name="getDate"
								id="getDate"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
								style="color: rgb(153, 153, 153);">
							</td>
						</tr>
						<tr>
							<td>颁发单位：</td>
							<td><input class="select_list_inputa" type="text"
								name="postUtil" id="postUtil"></td>
							<td>证书：</td>
							<td><input class="select_list_inputa" type="file"
								name="docAddress" id="docAddress"></td>
						</tr>
						<tr>
							<td>级别：</td>
							<td>
								<div class="select_list">
									<div id="uboxstyle">
										<select id="classCode" name="classCode">
											<option value="1">国家级</option>
											<option value="2">省级</option>
											<option value="3">市级</option>
											<option value="4">区县级</option>
										</select>
									</div>
								</div>
							</td>
							<td>荣誉有效期：</td>
							<td>
								<div class="select_list" onclick="javascript:dis();">
									<div id="uboxstyle">
										<select id="endDate" name="endDate">
											<option value="0">永久</option>
											<option value="1">其它</option>
										</select>
									</div>
								</div> <input class="select_list_inputa"
								style="  width: 130px;display:none;height:30px;" type="text"
								maxlength="20" value="请输入日期" name="postDate" id="postDate"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
								style="color: rgb(153, 153, 153);">
							</td>
						</tr>
						<tr>
							<td colspan="4"></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align:center;">
								<div class="select_list" style="margin-left:10px;">
									<a href="javascript:addHonorFm();"
										style="width:100px;border-radius:0px;margin-top:15px;">添加</a>
								</div>
								<div class="select_list" style="margin-left:10px;">
									<a href="javascript:hide();"
										style="width:100px;border-radius:0px;margin-top:15px;">取消</a>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<script type="text/javascript">
				function showDiv() {
					document.getElementById('baoan').style.display = '';
					document.getElementById('baoan').style.top = "30px";
				}
				function hide() {
					document.getElementById('baoan').style.display = "none";
					/* location.reload(true); */
					/* var honor = document.getElementById("honor");
					var getDate = document.getElementById("getDate");
					var postUtil = document.getElementById("postUtil");
					var docAddress = document.getElementById("docAddress");
					var classCode = document.getElementById("select_info_classCode");
					var endDate = document.getElementById("select_info_endDate"); */
					$(document)
							.ready(
									function() {
										$("#honor").val("");
										$("#getDate").val("请输入日期");
										$("#postUtil").val("");
										$("#docAddress").val("");
										$("#docAddress").html("未选择任何文件");

										$("#options_classCode li").removeClass(
												"open_selected");
										$("#options_classCode li").addClass(
												"open");
										$("#options_classCode li").removeAttr(
												"id");
										$("#select_info_classCode").html("国家级");
										var postDate = document
												.getElementById("endDate").value;
										if (postDate == "1") {
											$("#options_endDate li")
													.removeClass(
															"open_selected");
											$("#options_endDate li").addClass(
													"open");
											$("#options_endDate li")
													.removeAttr("id");
											$("#select_info_endDate")
													.html("永久");
											document.getElementById("postDate").style.display = "none";
										}
									});
				}
				function dis() {
					var postDate = document.getElementById("endDate").value;
					if (postDate == "1") {
						document.getElementById('postDate').style.display = "";
					} else {
						document.getElementById('postDate').style.display = "none";
					}
				}
			</script>
		</div>
		<iframe name="resultFrame"
			src="${basePath }/qiye/honor/MyHonorList.jsp" width="100%"
			frameborder="0" height="100%"></iframe>
	</div>
</body>
<script type="text/javascript">
	function addHonorFm() {
		var honor = document.getElementById("honor").value;
		var getDate = document.getElementById("getDate").value;
		var postUtil = document.getElementById("postUtil").value;
		var docAddress = document.getElementById("docAddress").value;
		var endDate = document.getElementById("endDate").value;
		var postDate = document.getElementById("postDate").value;
		if (honor == "" || honor == null) {
			alert("请输入荣誉名称");
			return;
		}
		if (getDate == "" || getDate == "请输入日期") {
			alert("获得荣誉日期为空，请输入！");
			return;
		}
		if (postUtil == "" || postUtil == null) {
			alert("颁发荣誉单位为空，请输入！");
			return;
		}
		if (docAddress == "" || docAddress == "未选择任何文件") {
			alert("请上传荣誉证书");
			return;
		}
		if (endDate == "1") {
			if (postDate == "" || postDate == "请输入日期") {
				alert("请选择荣誉有效期");
				return;
			}
		}
		var fm = document.forms["addHonor"];
		fm.action = "${basePath }/honor/addHonor";
		fm.submit();
		hide();
	}
</script>
</html>
