<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>

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
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/select2css.js"></script>
<script type="text/javascript" src="js/readXml.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
</head>

<body>
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">查询结果
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/dsmanager/claimQueryContinue" id="fm" method="GET">
			<table cellpadding="0" cellspacing="0" width="100%" border="1"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td>序号</td>
					<td>企业名称</td>
					<td>保单号</td>
					<td>赔案号</td>
					<td>出险时间</td>
					<td>出险原因</td>
<!-- 					<td>省份</td> -->
<!-- 					<td>城市</td> -->
<!-- 					<td>区县</td> -->
					<td>保险公司</td>
					<td>赔款金额</td>
					<td>结案时间</td>
					<td>结案状态</td>
					<td>操作</td>
				</tr>
			<c:forEach items="${sessionScope.pagination.resultList }" var="managerList" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
				<tr class="table_listb">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
				<tr class="">
					</c:if>
					<td>${listSize.index+1 }</td>
					<td>${managerList.INSUREDNAME }</td>
					<td>${managerList.POLICYNO }</td>
					<td>${managerList.PEIANNO }</td>
					<td>${managerList.LOSSDATE }</td>
					<td>${managerList.LOSSCAUSE }</td>
<!-- 					<td>${managerList.PROVINCE }</td> -->
<!-- 					<td>${managerList.CITY }</td> -->
<!-- 					<td>${managerList.COUNTY }</td> -->
					<td>${managerList.INSURERCODE }</td>
					<td>${managerList.PAYAMOUNT }</td>
					<td>${managerList.CLOSEDATE }</td>
					<td>
						<c:if test="${managerList.STATUS == '5' }">
						 已结案
						</c:if>
						<c:if test="${managerList.STATUS == '4'}">
						 勘察
						</c:if>
						<c:if test="${managerList.STATUS == '3'}">
						 定损核损
						</c:if>
						<c:if test="${managerList.STATUS == '2'}">
						 赔付
						</c:if>
						<c:if test="${managerList.STATUS == '1'}">
						 已报案
						</c:if>
					</td>
					<td align="center">
						<a class="table_buttonb"
						href="/dsmanager/claimShow?businessno=${mycheck.POLICYNO }" target="mainFrame">查看</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		<div class="pages">  
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		</div>
			</form>
		<div style="clear:both;"></div>
	</div>
</body>
</html>
