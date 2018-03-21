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

<title>My JSP 'dangerSourceNotDetail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<form
		action="${basePath }evaluateDangers/evaluateReportUsercorpContinue"
		id="fm" method="POST">
		<div class="neicont_main_left_cont">
			<div class="neicont_imga">
				<img src="${basePath }/images/icotit2.jpg">企业安全评估
			</div>
			<div class="neicont_main_left_cont_main">
				<table cellpadding="0" cellspacing="0" width="100%" border="0"
					style="margin-top: 10px;">
					<tr class="table_lista">
						<td style="border-top-left-radius: 5px;width:3%;">序号</td>
						<td style="width:10%;">企业名称</td>
						<td style="width:10%;">联系人</td>
						<td style="width:10%;">联系方式</td>
						<td style="width:20%;">统一社会信用代码</td>
						<td style="width:10%;">安全生产许可证号</td>
						<td style="width:10%;">法人</td>
						<td style="width:5%;">员工总数</td>
						<td style="border-top-right-radius: 5px;width:10%;">操作</td>
					</tr>
					<c:forEach items="${sessionScope.pagination.resultList }"
						var="usercorpNotDetail" varStatus="listSize">
						<c:if test="${listSize.index %2 ==0 }">
							<tr class="table_listb">
						</c:if>
						<c:if test="${listSize.index %2 != 0 }">
							<tr class="">
						</c:if>
						<!-- 序号 -->
						<td><c:out value="${listSize.count }"></c:out></td>
						<!-- 企业名称 -->
						<td><c:out value="${usercorpNotDetail.COMPANYNAME }"></c:out></td>
						<!-- 联系人 -->
						<td><c:out value="${usercorpNotDetail.LINKNAME }"></c:out></td>
						<!-- 电话 -->
						<td><c:out value="${usercorpNotDetail.MOBILE }"></c:out></td>
						<!-- 营业执照号 -->
						<td><c:out value="${usercorpNotDetail.BUSINESSLICENSENO }"></c:out></td>
						<!-- 安全生产许可证号 -->
						<td><c:out value="${usercorpNotDetail.SAFETYLICENSENO }"></c:out></td>
						<!-- 企业类型 -->
						<td><c:out value="${usercorpNotDetail.CORPRATION }"></c:out></td>
						<!-- 员工总数 -->
						<td><c:out value="${usercorpNotDetail.EMCOUNT }"></c:out></td>
						<!-- 操作 -->
						<!-- 此处跳转到企业状况的详细页面，且只查看企业信息（或企业和保单信息） -->
						<td><a class="table_buttonb"
							href="${basePath }evaluateDangers/dangerSourceCountersign
								?userCode=${usercorpNotDetail.USERCODE }
								&companyName=${usercorpNotDetail.COMPANYNAME }
								&classCode=${usercorpNotDetail.CLASSCODE }">确认评估</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
					</tr>
				</table>
				<div style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
					<a href="javascript:history.go(-1);" class="table_buttonb" style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
				</div>
				<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
			</div>
		</div>
	</form>
</body>
</html>
