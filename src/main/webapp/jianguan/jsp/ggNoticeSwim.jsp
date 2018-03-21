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
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'ggNotice.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<form action="${basePath }noticeList/sendNotice" method="POST"
		name="fml">
		<div id="checkNew" class="checkNew neicont_main_left_cont_main"
			style="display:;">
			<div class="neicont_main_left_cont_main">
				<div style="text-align:left;font-size:18px;">
					<img src="images/icotit2.jpg">发消息
					<c:forEach items="${sessionScope.notoce }" var="notice">
						<input type="hidden" value="${notice.USERCODE }" name="userCode">
					</c:forEach>
				</div>
				<table cellpadding="0" cellspacing="0" width="100%">
					<tr class="new-title table_lista">
						<td colspan="8"></td>
						<td></td>
					</tr>
					<c:forEach items="${sessionScope.notoce }" var="notice">
						<tr>
							<td>接受对象类型：</td>
							<td>
								<div class="select_list">
									<div id="uboxstyle">
										<select name="userIn" id="userInd">
											<option value="${notice.USERIND }">
												<c:choose>
													<c:when test="${notice.USERIND eq '1' }">企业用户</c:when>
													<c:when test="${notice.USERIND eq '2' }">保险公司</c:when>
													<c:when test="${notice.USERIND eq '3' }">第三方</c:when>
													<c:when test="${notice.USERIND eq '4' }">经纪公司</c:when>
													<c:otherwise>所有用户</c:otherwise>
												</c:choose>
											</option>
										</select>
									</div>
								</div>
							</td>
							<td>用户选择：</td>
							<td>
								<div class="select_list">
									<div id="uboxstyle">
										<select name="userCode" id="userCode">
											<option value="${notice.USERCODE }">${notice.COMPANYNAME
												}</option>
										</select>
									</div>
								</div>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>标题：</td>
							<td colspan="2"><input type="text"
								class="select_list_inputa"
								style="border-color : black ; width:100%;" name="title"
								id="title"></td>
						</tr>
						<tr>
							<td>内容：</td>
							<td colspan="2"><textarea rows="10" style="width:100%;"
									name="contentSource" id="contentSource"></textarea></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="margin:10px auto;width:100%;">
				<div class="select_list" style="margin-left:40px;">
					<div id="div_back">
						<a href="javascript:history.go(-1);" class="a_back">取消</a>
					</div>
				</div>
				<div class="select_list" style="margin-right:200px;">
					<a class="select_list_alink" href="javascript:submitFml();">发送</a>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function mymsg() {
		}
		function hide() {
			document.getElementById("checkNew").style.display = "none";
			$(document).ready(function() {
				$("#select_info_userIn").text("请选择用户类型");
				$("#userCode").val("请选择用户");
				$("#title").val("");
				$("#contentSource").val("");
			})
		}
	</script>
	<script type="text/javascript">
		function submitFml() {
			var obj = document.getElementById("userInd").value;
			var use = document.getElementById("userCode").value;
			var tit = document.getElementById("title").value;
			var con = document.getElementById("contentSource").value;
			if (obj == "") {
				alert("请选择用户类型");
				return false;
			} else if (use == "请选择用户") {
				alert("请选择用户");
				return false;
			} else if (tit == "") {
				alert("请输入内容标题");
				return false;
			} else if (con == "") {
				alert("请输入消息内容");
				return false;
			} else {
				var url = "${basePath}/noticeList/sendNotice";
				var form = document.forms["fml"];
				form.action = url;
				form.submit();
				hide();
			}
		}
	</script>
</body>
</html>