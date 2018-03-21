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
<html>
<head>
<title>企业安全评估</title>
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
</head>
<body>
	<form action="${basePath }evaluateDangers/danger" method="GET">
		<div class="neicont_main_left_cont">
			<div class="neicont_imga">
				<img src="${basePath }/images/icotit2.jpg">企业安全评估
			</div>
			<div class="neicont_main_left_cont_main">
				<table cellpadding="0" cellspacing="0" width="80%" border="0"
					style="margin:10px auto;" id="tab_ax">
					<tr class="table_lista">
						<td
							style="border:1px solid #00a6e3;background-color:white;color:#F00;"
							rowspan="${fn:length(sessionScope.pagination.resultList) +1 }">
							${evaSource.COMPANYNAME }</td>
						<td style="border:1px solid #00a6e3;cursor:pointer;">评估机构</td>
						<td style="border:1px solid #00a6e3;cursor:pointer;">风险状况</td>
						<td style="border:1px solid #00a6e3;cursor:pointer;">评估资料</td>
					</tr>
					<c:forEach items="${sessionScope.pagination.resultList }"
						var="evaluateReport" varStatus="listSize">
						<c:if test="${listSize.index %2 ==0 }">
							<tr class="table_listb">
						</c:if>
						<c:if test="${listSize.index %2 != 0 }">
							<tr class="">
						</c:if>
						<!-- 评估机构：政府评估，企业，第三方，保险公司	 -->
						<td style="border:1px solid #00a6e3;"><tlds:name
								codeType="userInd" codeCode="${evaluateReport.USERIND }" /></td>
						<!--     风险状况		 -->
						<td style="border:1px solid #00a6e3;"><c:choose>
								<c:when test="${evaluateReport.RISKLEVEL eq '1' }">合格</c:when>
								<c:when test="${evaluateReport.RISKLEVEL eq '0' }">不合格</c:when>
								<c:otherwise>未知风险</c:otherwise>
							</c:choose></td>
						<td style="border:1px solid #00a6e3;"><a
							style="color:#57a6e3;" href="${evaluateReport.DOCADDRESS}"
							target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
					</tr>
				</table>
				<div style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
					<a href="javascript:history.go(-1);" class="table_buttonb" style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>