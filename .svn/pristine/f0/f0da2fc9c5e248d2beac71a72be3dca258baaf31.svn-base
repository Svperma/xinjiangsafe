<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
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

<title>My JSP 'MyHonorList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<jsp:include page="${basePath }/enterprise/etyinclude.jsp" />
</head>

<body>
	<div class="maincont_mid_cont_right">
		<div class="maincont_mid_cont_right_main">
			<form action="${basePath }/honor/MyHonorPagination" id="fm" name="fm"
				method="GET">
				<table cellpadding="0" cellspacing="0" width="100%" border="0">
					<tr class="table_head">
						<td style="width: 10%;text-align: center;">荣誉名称</td>
						<td style="width: 15%;text-align: center;">获得日期</td>
						<td style="width: 15%;text-align: center;">颁发单位</td>
						<td style="width: 15%;text-align: center;">级别</td>
						<td style="width: 15%;text-align: center;">有效期</td>
						<td style="width: 15%;text-align: center;">证明</td>
						<td style="width: 15%;text-align: center;">操作</td>
					</tr>
					<c:forEach items="${sessionScope.pagination.resultList }"
						var="honor" varStatus="listSize">
						<c:if test="${listSize.index %2 ==0 }">
							<tr class="table_mid">
						</c:if>
						<c:if test="${listSize.index %2 != 0 }">
							<tr class="">
						</c:if>
						<td style="display: none;"><span id="idNo${listSize.index }">${honor.ID
								}</span></td>
						<td style="text-align: center;">${honor.HONOR }</td>
						<td style="text-align: center;"><fmt:formatDate
								value="${honor.GETDATE }" pattern="yyyy-MM-dd" /></td>
						<td style="text-align: center;">${honor.POSTUTIL }</td>
						<td style="text-align: center;"><tlds:name
								codeType="honorClassCode" codeCode="${honor.REWARDSCLASSCODE }" />
						</td>
						<td style="text-align: center;"><fmt:formatDate
								value="${honor.VALIDITYDATE }" pattern="yyyy-MM-dd"
								var="validitydate" /> <!-- &gt; 大于号 --> <c:set var="date"
								value="9999-12-31"></c:set> <c:if
								test="${validitydate eq date }">永久</c:if> <c:if
								test="${validitydate ne date}">
					${validitydate }
					</c:if></td>
						<td style="text-align: center;"><a class="table_buttonb"
							href="${basePath }${honor.CENTRALIZEDADDRESS}" target="_blank">
								查看 </a> <c:if test="${honor.VALIDITY eq '1'}">
						</td>
						<td style="text-align: center;">		
								<a href="javascript:deletePersons(${listSize.index });"
									class="table_buttona">删除</a>
							</c:if> <c:if test="${validitydate le SYSDATE}">
								<a onclick="javascript:deletePersons(${listSize.index });"
									class="table_buttona">已过期</pa>
							</c:if></td>
						</tr>
					</c:forEach>
				</table>
				<jsp:include page="${basePath }/enterprise/etyPagination.jsp" />
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
function deletePersons(obj){
	  var conf=window.confirm("确定删除？");
	  if(conf == true){
	  var id = document.getElementById("idNo"+obj).innerHTML;
	  	window.location.href = "${basePath }/honor/deleteById?id="+id;
	  };
  }
</script>
</html>
