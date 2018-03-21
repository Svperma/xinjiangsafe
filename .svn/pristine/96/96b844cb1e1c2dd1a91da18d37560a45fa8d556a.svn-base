<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'InveStigateContion.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/css/etpStyle.css">
</head>

<body>
	<div class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_main">
			<table cellpadding="0" cellspacing="0" width="100%" border="0">
				<tr class="table_head">
					<td>评估机构</td>
					<td>评估内容</td>
					<td>评估时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="evaUserInd" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
						<tr class="table_mid" style="height:35px;">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
						<tr class="" style="height:35px;">
					</c:if>
					<td
						style="border-bottom:1px solid #CCC; font-weight:bold; width:15%; ">
						<tlds:name codeType="userInd" codeCode="${evaUserInd.userInd }" />
					</td>
					<td onMouseOver="setColor()" onMouseOut="retriveColor()"
						style="cursor:pointer; width:55%;border-bottom:1px solid #CCC;border-left:1px solid #CCC;font-weight:bold;">
						<a href="${evaUserInd.docAddress }"
						style="display:inline-block;width:90%;overflow:hidden;white-space:nowrap;text-overflow:ellipsis; 
						color:black; text-decoration:underline;"
						target="_blank">${evaUserInd.content } </a>
					</td>
					<td
						style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;font-weight:bold; 
					width:15%;">
						<fmt:formatDate value="${evaUserInd.evaluatDate }"
							pattern="yyyy-MM-dd" />
					</td>
					<td
						style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;width:15%;">
						<c:if test="${evaUserInd.status eq '0' }">
							<a
								style="width: 120px;background-color:#00A6E3;padding:5px 20px;
							margin-top:50px;"
								href="${basePath }/subScribe/StatusEndding?id=${evaUserInd.id }"
								target="mainFrame"> 提交整改结果</a>
						</c:if> <c:if test="${evaUserInd.status eq '2' }">
							<c:forEach items="${evaUserInd.list }" var="evalist">
								<a
									style="width: 120px;background-color:#00A6E3;padding:5px 20px; margin-top:50px;"
									href="${evalist.docAddress }" target="_back"> 查看整改资料</a>
							</c:forEach>
						</c:if>
					</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" style="height:150px;"></td>
				</tr>
				<tr>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
