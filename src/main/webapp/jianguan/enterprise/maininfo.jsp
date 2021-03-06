
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
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<jsp:useBean id="now" class="java.util.Date" />
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'maininfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
<body>
	<form action="${basePath }/usercorp/UsercorpContinue" id="fm"
		method="GET">
<!-- 		<div style="float:right;padding-right:30px;"> -->
<!-- 			<img src="images/tanhao.gif" width="25px" height="25px" />重大危险源 -->
<!-- 		</div> -->
<!-- 		<div class="neicont_imga"> -->
<!-- 			<img src="images/icotit2.jpg"> -->
<!-- 			<div class="neicont_img_font">企业状况</div> -->
<!-- 			<span class="neicont_img_span">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;企业总数： -->
<!-- 				<span> -->
<!-- 				<c:forEach items="${sessionScope.intValue }" var="usercount"> -->
<!-- 					${usercount.USERCODE}家 -->
<!-- 				</c:forEach> -->
<!-- 				</span> -->
<!-- 			</span> -->
<!-- 		</div> -->
		<div class="neicont_main_left_cont_main">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;">序号</td>
					<td>企业名称</td>
					<td>安全生产许可证号</td>
					<td>许可证有效期至</td>
					<td>保险单状态</td>
					<td>企业类型</td>
					<td>安全标准化等级</td>
					<td>责任限额(万元/人)</td>
					<td>每次事故责任限额(万元)</td>
					<td>投保人数</td>
					<td style="border-top-right-radius: 5px;">操作</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="ggusercorp" varStatus="listSize">
					<c:if test="${listSize.index % 2 ==0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
						<tr class="">
					</c:if>
					<td><c:out value="${listSize.count }"></c:out></td>
					<td><c:out value="${ggusercorp.COMPANYNAME }"></c:out> <c:if
							test="${ggusercorp.SOURCE eq '1' }">
							<img src="${basePath }/images/tanhao.gif" width="25px"
								height="25px">
						</c:if></td>
					<td><c:out value="${ggusercorp.SAFETYLICENSENO }"></c:out></td>
					<td><fmt:formatDate value="${ggusercorp.SAFETYLICESEDATE}"
							pattern="yyyy-MM-dd" /></td>
					<td>
						<c:if test="${ggusercorp.ENDDATE == '未投保' }"><span style="color: red;">${ggusercorp.ENDDATE}</span></c:if>
						<c:if test="${ggusercorp.ENDDATE == '已过期' }"><span style="color: red;">${ggusercorp.ENDDATE}</span></c:if>
						<c:if test="${ggusercorp.ENDDATE == '已投保' }"><span>${ggusercorp.ENDDATE}</span></c:if>
						<%-- <fmt:formatDate value="${ggusercorp.ENDDATE}" pattern="yyyy-MM-dd" var="endDATE"/>
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="nowDate" />
						<c:if test="${endDATE >= nowDate }">已投保</c:if>
						<c:if test="${endDATE <= nowDate }">过期未续保</c:if>
						<c:if test="${endDATE == '' or empty endDATE}">未投保</c:if> --%>
					</td>
					<td>${ggusercorp.CLASSCODE }</td>
					<td>${ggusercorp.STANDARDLEVEL}</td>
					<td><fmt:formatNumber value="${ggusercorp.UNITAMOUNT}" pattern="##.##"/></td>
					<td><c:out value="${ggusercorp.SUMAMOUNT}"></c:out></td>
					<td>${ggusercorp.EMCOUNT}</td>
					<td><a class="table_buttonb"
<%-- 						href="${basePath }/usercorp/details?userCode=${ggusercorp.USERCODE }&businessNo=${ggusercorp.BUSINESSNO }" --%>
						href="${basePath }/usercorp/corpAndItem?userCode=${ggusercorp.USERCODE }&businessNo=${ggusercorp.BUSINESSNO }"
						target="mainFrame">查看详情</a></td>
					</tr>
				</c:forEach>
			</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</div>
	</form>
</body>
</html>
