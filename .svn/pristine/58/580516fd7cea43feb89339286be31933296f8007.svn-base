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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyConsultReport.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/css/etpStyle.css">
<script type="text/javascript" src="/js/select2css.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>

<style type="text/css">
.checkNew {
	position: absolute;
	left: 0px;
	top: 0px;
	width: 79%;
	height: 100%;
	z-index: 1000;
	background-color: #CCC;
	opacity: 0.8;
	padding: 100px 200px;
	color: black;
}

.checkNew td {
	padding: 5px 10px;
}
</style>
<style>
#div_back .a_back {
	display: block;
	margin: 10px auto;
	padding: 5px 10px;
	background: #00a6e3;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	color: #fff;
	width: 60px;
	height: 25px;
}
</style>
</head>

<body>
	<!-- onload="selectZixun(o);" -->
	<div class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_top">
			<div class="select_list" style="  line-height: 33px;">
				<input style="margin-right: 10px;margin-left: 5px;" name="zixun"
					type="radio" value="5" checked="checked"
					onclick="selectZixun(this);" />咨询 <input
					style="margin-right: 10px;margin-left: 5px;" name="zixun"
					type="radio" value="3" onclick="selectZixun(this);" />投诉
			</div>
			<div class="select_list" style="margin-left:10px;">
				<a style="width: 100px;" href="javascript:openDiv();">我要咨询/投诉</a>
			</div>
		</div>
		<iframe name="resultFrame"
			src="${basePath }/qiye/MyConsult/MyConsultContion.jsp" width="100%"
			frameborder="0" height="100%"></iframe>
	</div>

	<div id="checkNew" class="checkNew neicont_main_left_cont_main"
		style="display:none;">
		<form action="${basePath}/myConsult/sendConsult" name="fs" id="fs"
			method="POST" target="resultFrame">
			<div class="neicont_main_left_cont_main">
				<div style="text-align:left;font-size:18px;">
					<img src="images/icotit2.jpg">发送咨询/投诉
				</div>
				<table cellpadding="0" cellspacing="0" width="100%">
					<tr class="new-title table_lista">
						<td colspan="8"></td>
						<td></td>
					</tr>
					<tr>
						<td>接收对象：</td>
						<td>
							<div class="select_list"
								onclick="moveGrade('userInd','userCode');">
								<div id="uboxstyle">
									<select name="userInd" id="userInd">
										<option value="">
											请选择接收对像
											<c:forEach items="${userInd }" var="ggUser"
												varStatus="listSize">
												<c:if test="${ggUser.codeCode ==  '1'}"><option value="${ggUser.codeCode }">安监用户</option></c:if>
												<c:if test="${ggUser.codeCode ==  '3'}"><option value="${ggUser.codeCode }">保险公司用户</option></c:if>
												<c:if test="${ggUser.codeCode ==  '4'}"><option value="${ggUser.codeCode }">经纪公司用户</option></c:if>
											</c:forEach>
									</select>
								</div>
							</div>
						</td>
						<td>接收人：</td>
						<td>
							<div class="select_list">
								<input type="text" id="person" name="person" value="请选择接收人"
									style="outline: none;border:1px solid #ededed;">
								<div id="userCode"
									style="border:1px solid #ededed; width:150px;height:180px;
									border-radius:1px;text-align:left;display:none; overflow:auto;overflow-x: scroll">
									<a style="width:98px;height:23px;" href="javascript:void();"
										id="userCode-a">确定</a>
								</div>
								<input type="hidden" id="hfexample" name="hfexample" />
							</div>
						</td>
					</tr>
					<tr>
						<td>选择操作类型：</td>
						<td>
							<div class="select_list">
								<div id="uboxstyle">
									<select name="attr" id="attr">
										<option value="5">咨询</option>
										<option value="3">投诉</option>
									</select>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>内容：</td>
						<td colspan="2"><textarea rows="10" style="width:100%;"
								name="contentSource" id="contentSource"></textarea></td>
					</tr>
				</table>
				<div style="margin:10px auto;width:100%;">
					<div class="select_list" style="margin-left:0px;">
						<div id="div_back">
							<a href="javascript:hide();" class="a_back" style="width:60px;">取消</a>
						</div>
					</div>
					<div id="div_back" class="select_list" style="margin-left:0px;">
						<a class="a_back" href="javascript:submitFm();"
							style="width:60px;">发送</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function openDiv() {
			document.getElementById("checkNew").style.display = "";
		}
	</script>
	<script type="text/javascript">
		function submitFm() {
			var obj = document.getElementById("userInd").value;
			var use = document.getElementById("person").value;
			var con = document.getElementById("contentSource").value;
			if (obj == "") {
				alert("请选择用户类型");
				return;
			}
			if (use == "请选择用户") {
				alert("请选择用户");
				return;
			}
			if (con == "") {
				alert("请输入消息内容");
				return;
			}
			var attr = document.getElementsByName("attr");
			var zixun = document.getElementsByName("zixun");
			for ( var i = 0; i < zixun.length; i++) {
				if (zixun[i].value == 3) {
					zixun[i].checked = "checked";
				}
			}
			var url = "${basePath}/myConsult/sendConsult";
			var form = document.forms["fs"];
			form.action = url;
			form.submit();
			hide();
		}
		function hide() {
			document.getElementById("checkNew").style.display = "none";
			$(document).ready(function() {
				$("#select_info_userInd").text("请选择用户类型");
				$("#person").val("请选择用户");
				$("#contentSource").val("");
			})
		}
	</script>
	<script type="text/javascript">
		function selectZixun(o) {
			var val = o.value;
			window.open("${basePath}/myConsult/selectZixun?attr=" + val,
					"resultFrame");
		}

		function moveGrade(parentId, userCode) {
			var obj = document.getElementById(parentId).value;
			$
					.ajax({
						type : "post",
						url : "${basePath}/myConsult/getGare",
						data : JSON.stringify({
							"userInd" : obj
						}),
						dataType : "json",
						contentType : "application/json;charset=UTF-8",
						success : function(data) {
							$("#userCode p").remove();
							$("#hfexample").val("");
							$("#person").val("请选择用户");
							var ckb;
							var p;
							var span;
							var div = document.getElementById("userCode");

							for ( var i = 0; i < data.length; i++) {
								var item = data[i];
								ckb = document.createElement("input");
								ckb.type = "checkbox";
								p = document.createElement("p");
								span = document.createElement("span");
								span.id = item.USERCODE;
								ckb.value = item.USERCODE;
								ckb.onclick = function() {
									var val = this.value;
									var hiddenInp = document
											.getElementById("hfexample");
									var hiddenVal = hiddenInp.value.replace(
											"请选择用户", "");
									var spanText = document
											.getElementById(this.value).innerHTML;
									var person = document
											.getElementById("person");
									var personValue = person.value;
									if (this.checked) {
										if (hiddenVal.length == 0) {
											hiddenInp.value = this.value;
											person.value = spanText;
										} else {
											hiddenInp.value = hiddenVal + ";"
													+ this.value;
											person.value = personValue + ";"
													+ spanText;
										}
									} else {
										var strs = hiddenVal.split(";");
										var result = "";
										for ( var i = 0; i < strs.length; i++) {
											var str = strs[i];
											if (str != this.value) {
												result += str + ";";
											}
										}
										var persons = personValue.split(";");
										var result1 = "";
										for ( var i = 0; i < persons.length; i++) {
											var per = persons[i];
											if (per != spanText) {
												result1 += per + ";";
											}
										}
										hiddenInp.value = result.substring(0,
												result.length - 1);
										person.value = result1.substring(0,
												result1.length - 1);
									}
								}
								span.innerHTML = item.USERNAME;
								p.appendChild(ckb);
								p.appendChild(span);
								div.appendChild(p);
							}
						},
						error : function() {
							alert("系统异常请重试!");
						}
					});
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#person").click(function() {
				$("#userCode").css("display", "block")
			})
		})
		$(document).ready(function() {
			$("#userCode-a").click(function() {
				$("#userCode").css("display", "none")
			})
		})
	</script>
</body>
</html>
