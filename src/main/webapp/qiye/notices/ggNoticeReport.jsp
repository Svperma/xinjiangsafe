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
<jsp:include page="${basePath }/enterprise/etyinclude.jsp" />
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="${basePath }/js/jquery.js"></script>

<script type="text/javascript" src="${basePath }/js/common.js"></script>
<script type="text/javascript"
	src="${basePath }/jianguan/jsp/box/jquery-ui.min.js"></script>

</head>
<body>

	<div id="checkNew" class="checkNew neicont_main_left_cont_main"
		style="display:none;width:100%;position:absolute;height:100%;opacity:1;background:#ededed;">
		<form action="${basePath }/evaluateDangers/sendNoticeUser" name="fs"
			id="fs" method="POST" target="resultFrame">
			<div class="neicont_main_left_cont_main">
				<table cellpadding="0" cellspacing="0" width="100%">
					<tr class="table_lista">
						<td colspan="8"></td>
						<td></td>
					</tr>
					<tr>
						<td width="10%;">接受对象类型：</td>
						<td>
							<div class="select_list"
								onclick="moveGrade('userInd','userCode');">
								<div id="uboxstyle">
									<select name="userInd" id="userInd">
										<option value="">请选择用户类型</option>
											<c:forEach items="${sessionScope.list_userInd }"
												var="ggNoticeUser" varStatus="listSize">
												<c:if test="${ggNoticeUser.codeCode == '1'}"><option value="${ggNoticeUser.codeCode }">安监用户</option></c:if>
<!-- 												<c:if test="${ggNoticeUser.codeCode == '2'}"><option value="${ggNoticeUser.codeCode }">企业用户</option></c:if> -->
												<c:if test="${ggNoticeUser.codeCode == '3'}"><option value="${ggNoticeUser.codeCode }">经纪公司用户</option></c:if>
												<c:if test="${ggNoticeUser.codeCode == '4'}"><option value="${ggNoticeUser.codeCode }">保险公司用户</option></c:if>
											</c:forEach>
									</select>
								</div>
							</div>
						</td>
						<td width="100px;">用户选择：</td>
						<td>
							<div class="select_list">
								<input type="text" id="person" name="person" value="请选择用户"
									style="outline: none;border:1px solid #ededed; height: 30px;">
								<div id="userCode"
									style="border:1px solid #ededed; width:140px; height:180px; overflow:scroll;
									border-radius:2px;text-align:left;display:none;">
									<a style="width:80px;height:27px;" href="javascript:void()"
										id="userCode-a">确定</a>
								</div>
								<input type="hidden" id="hfexample" name="hfexample" />
							</div>
						</td>
					</tr>
					<tr>
						<td width="60px;">标题：</td>
						<td colspan="2"><input type="text" class="select_list_inputa"
							style="border-color : black ; width:100%;" name="title"
							id="title"></td>
					</tr>
					<tr>
						<td width="60px;">内容：</td>
						<td colspan="2"><textarea rows="10" style="width:100%;"
								name="contentSource" id="contentSource"></textarea></td>
					</tr>
				</table>
			</div>
			<div style="margin:10px auto;width:100%;">
				<div class="select_list" style="margin-left:40px;">
					<div id="div_back">
						<a href="javascript:close();" class="a_back">取消</a>
					</div>
				</div>
				<div class="select_list" style="margin-right:100px;">
					<a class="select_list_alink" href="javascript:submitFm();">发送</a>
				</div>
			</div>
		</form>
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/evaluateDangers/get_riskRatingInfo"
			name="fml" method="post" target="resultFrame">
			<div class="select_list_all">
				<div class="select_list" style="width: 200px;">
					<input class="select_list_inputa" type="text" maxlength="20"
						value="请输入开始日期" name="startNoticeDate" id="startNotice"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
						style="color: rgb(153, 153, 153);height:30px;">
				</div>
				<div class="select_list" style="width: 200px;">
					<input class="select_list_inputa" type="text" maxlength="20"
						value="请输入截止日期" name="endNoticeDate" id="endNotice"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
						style="color: rgb(153, 153, 153);height:30px;">
				</div>
				<div class="select_list" style="width: 200px;">
					<input class="select_list_inputa" type="text" maxlength="20"
						value="请输入接收人名称" name="recipient" id="recipient"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: rgb(153, 153, 153);height:30px;">
				</div>
				<div class="select_list">
					<div id="uboxstyle">
						<select name="Readtype" id="Readtype">
							<option value="" selected="selected">消息类型</option>
							<option value="0">未读消息</option>
							<option value="1">已读消息</option>
						</select>
					</div>
				</div>
				<div class="select_list" style="width:200px;">
					<input name="reci" type="radio" value="1" checked="checked">我接收的
					<input name="reci" type="radio" value="0">我发送的
				</div>
				<div class="select_list">
					<a href="javascript:submitCh()">查询</a>
				</div>
				<div class="select_list">
					<a href="javascript:hide();">发送新消息</a>
				</div>
			</div>
			<iframe name="resultFrame"
				src="${basePath }/qiye/notices/ggNotice.jsp" width="100%"
				frameborder="0" height="100%"></iframe>
		</form>
	</div>
</body>
<script type="text/javascript">
	function submitCh() {
		var fm = document.forms["fml"];
		fm.action = "${basePath}/noticeList/selectNotice";
		fm.submit();
	}
	function getData(data) {
		return data.companyName;
	}
</script>
<script type="text/javascript">
	function exportExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/evaluateDangers/exportToExcel";
		fm.submit();
	}
</script>
<script>
	function hide() {
		document.getElementById("checkNew").style.display = "";
	}

	function moveGrade(parentId, userCode) {
		var obj = document.getElementById(parentId).value;
		$
				.ajax({
					type : "post",
					url : "${basePath}/noticeList/getGare",
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
								var person = document.getElementById("person");
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
	function submitFm() {
		var obj = document.getElementById("userInd").value;
		var per = document.getElementById("person").value;
		var tit = document.getElementById("title").value;
		var con = document.getElementById("contentSource").value;
		if (obj == "") {
			alert("请选择用户类型");
			return false;
		} else if (per == "请选择用户") {
			alert("请选择用户");
			return false;
		} else if (tit == "") {
			alert("请输入内容标题");
			return false;
		} else if (con == "") {
			alert("请输入消息内容");
			return false;
		} else {
			var reci = document.getElementsByName("reci");
			for ( var i = 0; i < reci.length; i++) {
				if (reci[i].value == 0) {
					reci[i].checked = true;
				}
			}
			var url = "${basePath }/noticeList/sendNoticeUser";
			var form = document.forms["fs"];
			form.action = url;
			form.submit();
			close();
		}
	}
	function close() {
		document.getElementById("checkNew").style.display = "none";
		var check = document.getElementById("checkNew");
		check.location.href = location.href;
		$(document).ready(function() {
			$("#select_info_userInd").text("请选择用户类型");
			$("#person").val("请选择用户");
			$("#title").val("");
			$("#contentSource").val("");
		})
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
</html>