<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
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

<title>My JSP 'addInveStigateList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
#div_back .a_back {
	margin: 50 auto;
	padding: 5px 20px;
	background: #00a6e3;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	color: #fff;
}
</style>
</head>

<body>
	<div class="maincont_mid_cont_right_main"
		style="padding: 0;padding-top: 10px;">
		<form action="${basePath }/organ/yuyueListContinue" id="fm" name="fm"
			method="GET">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="float: left;margin-top: 20px;text-align:center;">
				<tr class="table_head" style="text-align:center;">
					<td>序号</td>
					<td>机构名称</td>
					<td>地址</td>
					<td>评估范围</td>
					<td>联系人</td>
					<td>联系方式</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="govOrgan" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
						<tr class="table_mid">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
						<tr class="">
					</c:if>
					<!-- 序号 -->
					<td>${listSize.index+1 }</td>
					<!-- 名称 -->
					<td>${govOrgan.ORGNAME }</td>
					<!-- 地址 -->
					<td><tlds:name codeCode='${govOrgan.PROVINCE }'
							codeType='Province'></tlds:name>- <tlds:name
							codeCode='${govOrgan.CITY }' codeType='City'></tlds:name>- <tlds:name
							codeCode='${govOrgan.COUNTY }' codeType='County'></tlds:name>-
						${govOrgan.ADDRESS }</td>
					<!-- 评估范围 -->
					<td><tlds:name codeType='IndustryCategories'
							codeCode='${govOrgan.LANGUAGE }'></tlds:name>- <tlds:name
							codeType='IndustryType' codeCode='${govOrgan.BUSINESSTYPE }'></tlds:name>
					</td>
					<!-- 联系人 -->
					<td>${govOrgan.ORGOWNER }</td>
					<!-- 联系方式 -->
					<td>${govOrgan.PHONE }</td>
					<!-- 操作 -->
					<td style="width:200px;">
						<!-- 此处判断：如果预约表中有当前的这个机构的信息，则显示“已预约” --> <c:if
							test="${govOrgan.ORGCODE == govOrgan.SUBORGCODE }">
							<div class="select_list" style="margin-left:32px;">
								<a
									href="${basePath }/subScribe/sendGovOrganByOrgCode?orgCode=${govOrgan.ORGCODE }"
									style="display:inline-block;width:80px;height:27px;-moz-border-radius: 0px;
								-webkit-border-radius: 0px;border-radius:0px;"
									target="mainFrame">已预约</a>
							</div>
						</c:if> <c:if test="${govOrgan.ORGCODE != govOrgan.SUBORGCODE }">
							<div class="select_list" style="margin-left:32px;">
								<a
									href="${basePath }/subScribe/sendGovOrganByOrgCode?orgCode=${govOrgan.ORGCODE }"
									style="display:inline-block;width:80px;height:27px;-moz-border-radius: 0px;
							-webkit-border-radius: 0px;border-radius:0px;"
									target="mainFrame">预约</a>
							</div>
						</c:if>
					</td>
					</tr>
				</c:forEach>
			</table>
			<div id="div_back">
				<a href="javascript:history.go(-1);" class="a_back">返回</a>
			</div>
			<jsp:include page="${basePath }/enterprise/etyPagination.jsp" />
		</form>
	</div>
</body>
</html>
