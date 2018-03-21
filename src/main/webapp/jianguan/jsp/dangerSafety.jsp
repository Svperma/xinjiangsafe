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
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'testGgUserCorpDangers.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<style type="text/css">  

.tb{width:800px;font-size:12px;background:#6887D9}  

.tb thead th{height:25px;background:#217AC4;color:white}  

.tb tbody td{height:22px;background:white;padding-left:3px;}  

.autocut {  

    width:300px;  

    overflow:hidden;  

    white-space:nowrap;  

    text-overflow:ellipsis;  

    -o-text-overflow:ellipsis;  

    -icab-text-overflow: ellipsis;  

    -khtml-text-overflow: ellipsis;  

    -moz-text-overflow: ellipsis;  

    -webkit-text-overflow: ellipsis;  

}  

  

</style>  

<body>
	<form action="${basePath }/evaluateDangers/riskLevelContinue" id="fm"
		method="GET">
		<div class="neicont_imga">
			<img src="${basePath }/images/icotit2.jpg">企业安全评估
		</div>
		<div class="neicont_main_left_cont_main">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<thead>  
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;width:3%;">序号</td>
					<td style="width:12%;">企业名称</td>
					<td style="width:20%;">所属地</td>
					<td style="width:12%;">联系人</td>
					<td style="width:10%;">联系方式</td>
<!-- 					<td style="width:12%;">评估时间</td> -->
					<td style="width:12%;">综合评估</td>
<!-- 					<td style="width:5%;">风险状况</td> -->
<!-- 					<td style="border-top-right-radius: 5px;width:10%;">操作</td> -->
				</tr>
				</thead> 
				<tbody>   
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="ggusercorp" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
						<tr class="">
					</c:if>
					<!-- 序号 -->
					<td><c:out value="${listSize.count }"></c:out></td>
					<!-- 企业名称 -->
					<td style="text-align: left;"><div class="autocut" title="${ggusercorp.COMPANYNAME }">${ggusercorp.COMPANYNAME }</div></td>
					<!-- 所属地 -->
					<td style="text-align: left;">${ggusercorp.PROVINCE }-${ ggusercorp.CITY }-${ ggusercorp.COUNTY }</div></td>
					<!-- 联系人 -->
					<td><c:out value="${ggusercorp.LINKNAME }"></c:out></td>
					<!-- 电话 -->
					<td><c:out value="${ggusercorp.MOBILE }"></c:out></td>
					<!-- 评估时间 -->
					<%-- <td><fmt:formatDate value="${ggusercorp.EVALUATDATE }"
							pattern="yyyy-MM-dd" /></td> --%>
					<!-- 评估内容 -->
					<td style="cursor:pointer;" onMouseOver="setColor(this)"
						onMouseOut="retriveColor(this)"
						onClick="window.open('${basePath }/evaluateDangers/riskRating/details?userCode=${ggusercorp.USERCODE }&companyName=${ggusercorp.COMPANYNAME }','_parent')">
						<span style="display:inline-block;width:120px;overflow:hidden;
							text-overflow:ellipsis;white-space:nowrap;">
						<u>详情<%-- ${ggusercorp.CONTENT} --%></u>
						</span>
					</td>
				</c:forEach>
				</tbody>  
			</table>
<!-- 			<div
				style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
				<a href="javascript:history.go(-1);" class="table_buttonb"
					style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
			</div> -->
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</div>
	</form>
</body>
<script>
	function setColor(o) {
		o.style.color = "red";
	}
	function retriveColor(o) {
		o.style.color = "black";
	}
</script>
</html>
