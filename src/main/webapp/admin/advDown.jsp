<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
</head>
<body>
<form action="${basePath }/edit/newsContinue" id="fm" name="fm">
	<div class="panel admin-panel" style="height:1000px;">

		<table class="table table-hover text-center">
			<tr>
				<th width="80px;">序号</th>
				<!-- <th width="100px;">期数</th> -->
				<!--  -->
				<!-- <th width="80px;">显示位置</th> -->
				<th width="200px;">图片</th>
				<th width="450px;">标题</th>
<!-- 				<th width="180px;">属性</th> -->
				<!-- <th width="8%">分类名称</th> -->
				<th width="120px;">更新时间</th>
				<th width="240px;">操作</th>
			</tr>
			<c:forEach items="${sessionScope.pagination.resultList }" var="img" varStatus="vs">
				<tr>
					<td style="text-align:left; padding-left:10px;width: 80px;"><input
						type="checkbox" name="id[]" value="${vs.index+1 }" />
						${vs.index+1 }</td>
					<%-- <td style="text-align: center;width: 100px;" id="expectNo">第${img.EXPECTNO }期</td> --%>
					<%-- <td style="text-align: center;width: 80px;" id="displayNo">${img.DISPLAYNO }</td> --%>
					<td width="200px;" style="text-align: center;" id="imagePath"><img
						src="${img.IMAGEPATH }" alt="" width="70" height="50" /></td>
					<%-- <td style="text-align: center;width: 350px;">${img.TITLE }</td> --%>
					<td id="title" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;width: 420px;">
						<div style="display:inline-block;word-break:normal;overflow-wrap: break-word;width:400px;
							font-size:20px; margin: 0 auto;text-align: center;">${img.TITLE }
						</div>
					</td>
					<td style="text-align: center;width: 180px;display: none;">
					<input id="docType" name="docType" value="${img.DOCTYPE }" type="hidden">
					</td>
<!-- 					<td style="text-align: center;width: 180px;" id="indexOrTopOrRecommend"> -->
<!-- 						<font color="#00CC99"> -->
							<!-- 判断：如果‘首页’为1，则显示（其他项相同） --> 
<!-- 							<c:if test="${img.ISINDEX == '1' }">首页</c:if>  -->
<!-- 							<c:if test="${img.ISRECOMMEND == '1' }">推荐</c:if>  -->
<!-- 							<c:if test="${img.ISTOP == '1' }">置顶</c:if>  -->
<!-- 							<c:if test="${img.ISTOP == '' && img.ISINDEX == '' && img.ISRECOMMEND == '' }"></c:if> -->
<!-- 						</font> -->
<!-- 					</td> -->
					<td style="text-align: center;width: 120px;" id="publishDate">
						<fmt:formatDate value="${img.PUBLISHDATE }" pattern="yyyy-MM-dd" />
					</td>
					<td style="width: 240px;">
						<div class="button-group">
<!-- 							<a class="button border-main" target="admin" -->
<!-- 								href="javascript:update('${img.DOCID }','${img.DOCTYPE }')"> -->
<!-- 								<span class="icon-edit"></span> 修改 -->
<!-- 							</a>  -->
							<a class="button border-red"
								href="javascript:del('${img.DOCID }','${img.DOCTYPE }')"> 
								<span class="icon-trash-o"></span> 删除
							</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
	</div>
	</form>
	<script type="text/javascript">
		function update(mid, docpe) {
			var conf = window.confirm("确定修改？");
			if (conf == true) {
				window.location.href = "${basePath }/edit/updateExpect?docId=" + mid + "&docType=" + docpe;
			}
		}
		function del(mid, docpe) {
			var conf = window.confirm("确定删除？");
			if (conf == true) {
				window.location.href = "${basePath }/edit/deleteExpect?docId=" + mid + "&docType=" + docpe;
			}
		}
	</script>
</body>
</html>