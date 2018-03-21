<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

</head>

<body>
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">查询结果
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/exper/experpage" id="fm" method="get">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;">机构名称</td>
					<td>组织机构代码</td>
					<td>负责人</td>
					<td>联系方式</td>
					<td>机构等级</td>
					<td>地址</td>
					<td>评估企业数</td>
					<td>被评价数</td>
					<td style="border-top-right-radius: 5px;">操作</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="GovOrgan" varStatus="th">
					<c:if test="${th.index %2 ==0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${th.index %2 !=0 }">
						<tr class="">
					</c:if>
					<td>${GovOrgan.ORGNAME }</td>
					<td>${GovOrgan.ORGCODE }</td>
					<td>${GovOrgan.ORGOWNER }</td>
					<td>${GovOrgan.PHONE }</td>
					<td>${GovOrgan.GRADE }</td>
					<td>${GovOrgan.ADDRESS }</td>
					<td><a
						href="${basepath }/exper/expercompany?ORGCODE=${GovOrgan.ORGCODE }"
						style="text-decoration:underline;color:black;">${GovOrgan.GECOM
							}</a></td>
					<td><a
						href="${basepath }/exper/expertalk?ORGCODE=${GovOrgan.ORGCODE }"
						style="text-decoration:underline;color:black;">${GovOrgan.GVCOM
							}</a></td>
					<td><a class="table_buttonb"
						href="${basePath }/exper/experShow?ORGCODE=${GovOrgan.ORGCODE }">查看</a>
					</td>
					</tr>
				</c:forEach>
			</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</form>
	</div>
</body>
</html>
