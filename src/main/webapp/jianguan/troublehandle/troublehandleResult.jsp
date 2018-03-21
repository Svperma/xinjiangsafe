<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

</head>

<body>
	<form action="" id="fm" target="resultFrame">
		<div id="shigu" class="neicont_main_left_cont">
			<div class="neicont_imga">
				<img src="images/icotit2.jpg">事故查询
			</div>
			<div class="neicont_main_left_cont_main">
				<table cellpadding="0" cellspacing="0" width="100%" border="0"
					style="margin-top: 10px;">
					<tr class="table_lista">
						<td style="border-top-left-radius: 5px;">序号</td>
						<td>企业名称</td>
						<td>地区</td>
						<td>案件负责人</td>
						<td>案件发生日期</td>
						<td>事故原因</td>
						<td>损失情况</td>
						<td>援助金</td>
						<td>处理进度</td>
						<td style="border-top-right-radius: 5px;">处理结果</td>
					</tr>
					<c:forEach items="${sessionScope.pagination.resultList}"
						var="GgAccident" varStatus="th">
						<c:if test="${th.index %2 ==0 }">
							<tr class="table_listb">
						</c:if>
						<c:if test="${th.index %2 !=0 }">
							<tr class="">
						</c:if>
						<td>${th.index+1 }</td>
						<td>${GgAccident.USERCODE }</td>
						<td>${GgAccident.PROVINCE }-${GgAccident.CITY
							}-${GgAccident.COUNTY }</td>
						<td>${GgAccident.DEALER }</td>
						<td><fmt:formatDate value="${GgAccident.HAPPENDATE }"
								pattern="yyyy-MM-dd" /></td>
						<td>${GgAccident.CAUSE }</td>
						<td>${GgAccident.LOSS }</td>
						<td>${GgAccident.ASSISTANCE }</td>
						<td><c:if test="${GgAccident.STATUS =='0'}">正在处理</c:if> <c:if
								test="${GgAccident.STATUS !='0'}">处理完成</c:if></td>
						<td><a class="table_buttonb"
							href="${basePath }/troublehandle/troubleshow?id=${GgAccident.ID }">查看</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="pages">
					<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</form>
</body>
<script>
	function change(o) {
		var val = document.getElementById("select_info_languagee").innerHTML;
		var shigu = document.getElementById("shigu");
		var zhuanjia = document.getElementById("zhuanjia");
		var name = document.getElementById("name");
		if (val == "案件查看") {
			shigu.style.display = "";
			zhuanjia.style.display = "none";
			name.value = "请输入企业名称"
		} else {
			shigu.style.display = "none";
			zhuanjia.style.display = "";
			name.value = "请输入专家姓名"
		}
	}
</script>
</html>
