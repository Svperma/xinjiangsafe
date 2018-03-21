<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>My JSP 'ggNotice.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
#div_back .a_back {
	display: inline-block;
	margin: 20px auto;
	padding: 7px 20px;
	background: #00a6e3;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	color: #fff;
	width: 60px;
	font-size: 14px;
}

#div_back {
	text-align: center;
	line-height: 20px;
}

#tab_personal td {
	font-size: 14px;
}
</style>

<jsp:include page="${basePath }/common/include.jsp"></jsp:include>

</head>
<body>
	<form action="${basePath }noticeList/sendNotice" method="GET"
		name="fmn" target="mainFrame">
		<div class="neicont_img">
			<img src="images/icotit3.jpg">个人中心
		</div>
		<div class="neicont_main_left_cont_main">
			<div></div>
			<div class="neicont_main_left_cont_main">
				<table style="table-layout: fixed;word-wrap:break-word;"
					width="100%" id="tab_personal">
					<c:forEach items="${personalCenter }" var="personalcenter"
						varStatus="list">
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">名称：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.COMPANYNAME
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系人：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.LINKNAME
								}</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">电话：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.MOBILE
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系人电话：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.TELEPHONE
								}</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">联系地址</td>
							<td style="border-bottom:#9CF 1px solid;"><c:forEach
									items="${list_province }" var="province"> ${province.codeCName } </c:forEach>
								<c:forEach items="${list_city }" var="city"> -${city.codeCName } </c:forEach>
								<c:forEach items="${list_county }" var="county"> -${county.codeCName } </c:forEach>
								-${personalcenter.COMPANYADDRESS }</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">用户类型：</td>
							<c:forEach items="${list_userInd }" var="userInd" varStatus="st">
								<td style="border-bottom:#9CF 1px solid;">${userInd.codeCName
									}</td>
							</c:forEach>
							<%-- <td class="table_listb" style="border-bottom:#9CF 1px solid;">所属部门：</td>
							<c:forEach items="${Department }" var="code" varStatus="st">
								<td style="border-bottom:#9CF 1px solid;">${code.codeCName
									}</td>
							</c:forEach> --%>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">行业大类：</td>
							<c:forEach items="${list_classCode }" var="userCorp">
								<td style="border-bottom:#9CF 1px solid;"><c:out
										value="${userCorp.codeCName }"></c:out></td>
							</c:forEach>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">经营范围：</td>
							<c:forEach items="${list_businessClass }" var="corp_class">
								<td style="border-bottom:#9CF 1px solid;">${corp_class.codeCName
									}</td>
							</c:forEach>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">员工数量：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.EMCOUNT
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">法定代表人：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.CORPRATION
								}</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">传真：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.FAX
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">邮编：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.POST
								}</td>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">统一社会信用代码：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.BUSINESSLICENSENO
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">营业执照：</td>
							<c:if test="${empty personalcenter.BUSINESSLICENSEIMAGE }">
								<td style="border-bottom:#9CF 1px solid;"><input
									type="file" class="select_list_inputa"
									value="${personalcenter.BUSINESSLICENSEIMAGE }"
									name="corpImages" style="color: rgb(153, 153, 153);" readonly /></td>
							</c:if>
							<c:if test="${not empty personalcenter.BUSINESSLICENSEIMAGE }">
								<td><a href="${personalcenter.BUSINESSLICENSEIMAGE }"
									style="color:#00a6e3;" target="_blank">查看</a></td>
							</c:if>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全生产许可证号：</td>
							<td style="border-bottom:#9CF 1px solid;">${personalcenter.SAFETYLICENSENO
								}</td>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">安全生产许可证：</td>
							<c:if test="${empty personalcenter.SAFETYLICENSEIMAGE }">
								<td style="border-bottom:#9CF 1px solid;"><input
									type="file" class="select_list_inputa" name="corpImages"
									value="${personalcenter.SAFETYLICENSEIMAGE }"
									style="color: rgb(153, 153, 153);" readonly /></td>
							</c:if>
							<c:if test="${not empty personalcenter.SAFETYLICENSEIMAGE }">
								<td style="border-bottom:#9CF 1px solid;"><a
									href="${personalcenter.SAFETYLICENSEIMAGE }"
									style="color:#00a6e3;" target="_blank">查看</a></td>
							</c:if>
						</tr>
						<tr>
							<td class="table_listb" style="border-bottom:#9CF 1px solid;">许可证截至日期：</td>
							<td style="border-bottom:#9CF 1px solid;"><fmt:formatDate
									var="safeDate" value="${personalcenter.SAFETYLICESEDATE }"
									pattern="yyyy-MM-dd" /> <input style="font-size: 14px;"
								class="select_list_inputa" value="${safeDate }"
								name="sLiceseDate" disabled="disabled"
								onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})" />
							</td>

							<td class="table_listb" style="border-bottom:#9CF 1px solid;">营业执照截至日期：</td>
							<td style="border-bottom:#9CF 1px solid;"><fmt:formatDate
									var="busDate" value="${personalcenter.BUSINESSLICENSEDATE}"
									pattern="yyyy-MM-dd" /> <input style="font-size: 14px;"
								class="select_list_inputa" value="${busDate}"
								name="bLicenseDate" disabled="disabled"
								onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})" />
							</td>
						</tr>
					</c:forEach>
				</table>
				<div id="div_back">
					<a href="${basePath }/admin/pass.jsp" class="a_back">修改密码</a>
					
					<a href="javascript:history.go(-1);" class="a_back">返回</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>