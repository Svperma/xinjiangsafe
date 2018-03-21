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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'ggNotice.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<form action="${basePath }noticeList/sendNotice" method="GET"
		name="fmn" target="mainFrame">
		<div class="neicont_main_left_cont_main">
			<div class="neicont_img">
				<img src="images/icotit3.jpg">个人中心
			</div>
			<div class="neicont_main_left_cont_main">
				<table style="table-layout: fixed;word-wrap:break-word;"
					width="100%">
					<c:forEach items="${sessionScope.personalCenter }"
						var="personalcenter" varStatus="list">
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">名称：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.USERNAME
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系人：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.LINKNAME
								}</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">座机电话：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.MOBILE
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系人电话：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.TELEPHONE
								}</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">用户类型：</td>
							<c:forEach items="${list_userInd }" var="userInd" varStatus="st">
								<td style="border-bottom:#9CF 1px solid;">${userInd.codeCName
									}</td>
							</c:forEach>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">所属部门：</td>
							<c:forEach items="${Department }" var="code" varStatus="st">
								<td style="border-bottom:#9CF 1px solid;">${code.codeCName
									}</td>
							</c:forEach>
						</tr>

						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">权限：</td>
							<td style="border-bottom:#9CF 1px solid;"><c:choose>
									<c:when test="${personalcenter.COMLEVEL == '0' }">全国</c:when>
									<c:when test="${personalcenter.COMLEVEL == '1' }">省级</c:when>
									<c:when test="${personalcenter.COMLEVEL == '2' }">市级</c:when>
									<c:when test="${personalcenter.COMLEVEL == '3' }">区县级</c:when>
									<c:otherwise>其它</c:otherwise>
								</c:choose></td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">权限等级：</td>
							<td style="border-bottom:#9CF 1px solid;"><tlds:name
									codeType="Perssion" codeCode="${personalcenter.FLAG }" /></td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系地址</td>
							<td style="border-bottom:#9CF 1px solid;" colspan="3"><c:forEach
									items="${list_province }" var="province"> ${province.codeCName }</c:forEach>
								<c:forEach items="${list_city }" var="city">
									<c:if test="${not empty city.codeCName }">
							-${city.codeCName }
							</c:if>
								</c:forEach> <c:forEach items="${list_county }" var="county">
									<c:if test="${not empty county.codeCName }">
							-${county.codeCName }
							</c:if>
								</c:forEach> -${personalcenter.ADDRESS }</td>
						</tr>
					</c:forEach>
				</table>
				<div
					style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
					<a href="${basePath }/admin/pass.jsp" class="table_buttonb"
						style="width:120px; border-radius:5px;padding:5px 30px;color:white;">修改密码</a>
					<a href="javascript:history.go(-1);" class="table_buttonb"
						style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
				</div>
			</div>
	</form>
</body>
</html>