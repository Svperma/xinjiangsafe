<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/common/include.jsp" />
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'administrationResult.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/select2css.js"></script>
<script type="text/javascript" src="js/readXml.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
</head>

<body>
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">用户查询结果
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/admin/adminpage" id="fm" method="post">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;">序号</td>
					<td>省份</td>
					<td>市级</td>
					<td>区县</td>
					<td>登录ID</td>
					<td>用户名称</td>
					<td>所属部门</td>
					<td>权限</td>
					<td>上级管理人</td>
					<td>操作</td>
					<td style="border-top-right-radius: 5px;">&nbsp;</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList}" var="Admin"
					varStatus="th">
					<c:if test="${th.index %2 ==0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${th.index %2 !=0 }">
						<tr class="">
					</c:if>
					<td>${th.index+1 }</td>
					<td>${Admin.PROVINCE }</td>
					<td>${Admin.CITY }</td>
					<td>${Admin.COUNTY }</td>
					<td>${Admin.USERCODE }</td>
					<td>${Admin.USERNAME }</td>
					<td>${Admin.DIVISION }</td>
					<td><c:if test="${Admin.FLAG ==0 }">管理员</c:if> <c:if
							test="${Admin.FLAG !=0 }">操作员</c:if></td>
					<td>${Admin.REMARK }</td>
					<td><c:if test="${sessionScope.power == 0 }">
							<a class="table_buttonb"
								href="${basePath }/admin/adminedit?UserCode=${Admin.USERCODE }">编辑</a>
							<a class="table_buttona"
								href="javascript:del('${Admin.USERCODE }');">删除</a>
							<%-- <a class="table_buttona"
								href="${basePath }/admin/admindel?UserCode=${Admin.USERCODE }">删除</a> --%>
						</c:if></td>
					</tr>
				</c:forEach>
			</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</form>
	</div>
</body>
<script type="text/javascript">
	function del(s){
// 		var conf = window.confirm("确定删除？");
// 			if (conf == true) {
				/* window.location.href = "${basePath }/admin/admindel?UserCode=" + s; */
				$j.ajax({
					type : "get",
					url : "${basePath }/admin/admindel?userCode=" + s,
					data : {},
					dataType : "json",
					contentType : "application/json;charset=utf-8",
					success : function(data) {
						if (data == "bunengshanchuziji") {
							alert("不能删除本人用户，请联系上级管理员操作！");
							return;
						}else if (data == "success") {
							alert("删除用户成功");
							var url = "${basePath }/admin/admindelfan";
							window.location.href = url;
// 							url.target = "mainFrame";
// 							return;
						}
					},
					error : function() {
						alert("操作失败，请稍后再试");
					}
				});
// 			}
	}
</script>
</html>
