<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="gc"%>
<jsp:include page="${basePath }/common/include.jsp" />
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

<title>My JSP 'claimInfoResult.jsp' starting page</title>

<meta http-equiv="pragma" content="private">
<meta http-equiv="cache-control" content="private">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="neicont_main_left_cont">
		<div class="neicont_imga">
			<img src="images/icotit2.jpg">赔案清单
		</div>
		<form action="${basePath }/policyinfo/claimDetailContinue" name="fm"
			id="fm">
			<div class="neicont_main_left_cont_main">
				<table cellpadding="0" cellspacing="0" width="100%" border="0"
					style="margin-top: 10px;">
					<tr class="table_lista">
						<td style="border-top-left-radius: 5px;">序号</td>
						<td>企业名称</td>
						<td>报案时间</td>
						<td>结案时间</td>
						<td>承保公司</td>
						<td>事故原因</td>
						<td>损失情况（元）</td>
						<td>已决赔款（元）</td>
						<td>未决赔款（元）</td>
						<td>援助金（元）</td>
						<td>状态</td>
						<td style="border-top-right-radius: 5px;">操作</td>
					</tr>
					<c:forEach items="${sessionScope.pagination.resultList }"
						var="claim" varStatus="st">
						<c:if test="${st.index % 2 == 0 }">
							<tr class="table_listb">
						</c:if>
						<c:if test="${st.index % 2 != 0 }">
							<tr>
						</c:if>
						<td>${st.index+1 }</td>
						<td>${claim.COMPANYNAME }</td>
						<td><fm:formatDate value="${claim.BAOANDATE }"
								pattern="yyyy-MM-dd" /></td>
						<td><fm:formatDate value="${claim.CLOSEDATE }"
								pattern="yyyy-MM-dd" /></td>
						<td><gc:name codeCode="${claim.INSURERCODE }"
								codeType="CICompanycode" /></td>
						<td>${claim.LOSSCAUSE }</td>
						<td>${claim.LOSSAMOUNT }</td>
						<td>${claim.PAYAMOUNT }</td>
						<td>${claim.UNPAY }</td>
						<td>${claim.ASSISTANCE }</td>
						<td><c:if test="${claim.STATUS == 6 }">
	        		已结案
	        	</c:if> <c:if test="${claim.STATUS != 6 }">
	        		未结案
	        	</c:if></td>
						<td><a class="table_buttonb"
							href="${basePath }/policyinfo/viewDetail?businessNo=${claim.BUSINESSNO }">查看</a></td>
						</tr>
					</c:forEach>
				</table>
				<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
				<div
					style="clear:both;width:100%;padding-top:20px;margin-bottom:10px;">
					<a href="javascript:history.back();" class="table_buttonb"
						style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
