<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fns"%>
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
<title>policyInfoResult</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${basePath }/js/common.js"></script>
</head>

<body>
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">保险信息
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/policyinfo/policyInfoContinue" id="fm" target="resultFrame">
			<table id="t1" cellpadding="0" cellspacing="0" width="100%"
				border="0" style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;">序号</td>
					<td>保险公司名称</td>
<!-- 					<td>地区</td> -->
					<td>承保企业数</td>
					<td>保费（元）</td>
					<td>事故预防费用（元）</td>
					<td>赔款总额（元）</td>
<!-- 					<td>援助金（元）</td> -->
<!-- 					<td style="border-top-right-radius: 5px;">投诉及反馈</td> -->
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="policyInfo" varStatus="vt">
					<tr class="table_lista">
					<c:if test="${vt.index % 2 ==0 }">
						<tr class="table_listb">
					</c:if>
					<c:if test="${vt.index % 2 != 0 }">
						<tr class="">
					</c:if>
					<td>${vt.index+1 }</td>
					<td>${policyInfo.INSURER }</td>
<!-- 					<td>${policyInfo.AREA }</td> -->
					<td><a
						href="${basePath }/policyinfo/enterpriseDetail?insurerCode=${policyInfo.INSURERCODE}"
						target="resultFrame"
						style="color: black;text-decoration: underline;">${policyInfo.ENTERPRISE
							}</a></td>
					<td>${policyInfo.PREMIUM }</td>
					<td>${policyInfo.PREVENTFEE }</td>
					<td>${policyInfo.PAYAMOUNT }</td>
		<%-- 			<td><a
						href="${basePath }/policyinfo/assistanceDetail?insurerCode=${policyInfo.INSURERCODE}"
						style="color: black;text-decoration: underline;">${policyInfo.ASSISTANCE
							}</a></td>
					<td><a
						href="${basePath }/policyinfo/getConplainAndFeedback?insurerCode=${policyInfo.INSURERCODE}"
						style="color: black;text-decoration: underline;"
						target="mainFrame">${policyInfo.SUGGESTION }</a></td>--%>
					</tr>
				</c:forEach>
<!-- 				<tr class="table_listc" style="background-color: #57ade6;"> -->
<!-- 					<td style="border-bottom-left-radius: 5px;">合计</td> -->
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 					<td>${sessionScope.countMap.enterprise }</td> -->
<!-- 					<td>${sessionScope.countMap.premium }</td> -->
<!-- 					<td>${sessionScope.countMap.preventFee }</td> -->
<!-- 					<td>${sessionScope.countMap.payAmount }</td> -->
<!-- 					<td>${sessionScope.countMap.assistance }</td> -->
<!-- 					<td style="border-bottom-right-radius: 5px;">${sessionScope.countMap.suggestion}</td> -->
<!-- 				</tr> -->
			</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</form>
	</div>
</body>
</html>
