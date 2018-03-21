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
		<form action="${basePath }/dsmanager/companyContinue" id="fm" method="GET">
			<table cellpadding="0" cellspacing="0" width="100%" border="1"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td>序号</td>
					<td>企业名称</td>
					<td>信用代码</td>
					<td>省份</td>
					<td>城市</td>
					<td>区县</td>
					<td>保险公司</td>
<!-- 					<td>行业大类</td> -->
<!-- 					<td>行业小类</td> -->
					<td>联系人</td>
					<td>联系人电话</td>
					<td>企业人数</td>
					<td>是否投保</td>
				</tr>
			<c:forEach items="${sessionScope.pagination.resultList }" var="managerList" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
						<c:if test="${managerList.APPLICODE == null }">
							<tr class="table_listb" style="color:#F00;">
						</c:if>
						<c:if test="${managerList.APPLICODE != null }">
							<tr class="table_listb">
						</c:if>
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
						<c:if test="${managerList.APPLICODE == null }">
							<tr class="" style="color:#F00;">
						</c:if>
						<c:if test="${managerList.APPLICODE != null }">
							<tr class="">
						</c:if>
					</c:if>
					<td>${listSize.index+1 }</td>
					<td>${managerList.COMPANYNAME }</td>
					<td>${managerList.BUSINESSLICENSENO }</td>
					<td>
						<tlds:name codeType="Province" codeCode="${managerList.PROVINCE }" />
					</td>
					<td>
						<tlds:name codeType="City" codeCode="${managerList.CITY }" />
					</td>
					<td>
						<tlds:name codeType="County" codeCode="${managerList.COUNTY }" />
					</td>
					<td>
						<c:if test="${managerList.INSURERCODE != null }">
						 ${managerList.INSURERCODE }
						</c:if>
						<c:if test="${managerList.INSURERCODE == null}">
						 无
						</c:if>
					</td>
<!-- 					<td>${managerList.CLASSCODE }</td> -->
<!-- 					<td>${managerList.BUSINESSCLASS }</td> -->
					<td>${managerList.LINKNAME }</td>
					<td>${managerList.TELEPHONE }</td>
					<td>${managerList.EMCOUNT }</td>
					<td>
						<c:if test="${managerList.APPLICODE != null }">
						 已投保
						</c:if>
						<c:if test="${managerList.APPLICODE == null}">
						 未投保
						</c:if>
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
