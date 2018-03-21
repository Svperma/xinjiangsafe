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

<title>My JSP 'shouye.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<jsp:include page="${basePath }/enterprise/etyinclude.jsp"></jsp:include>
</head>

<body onload="validUser()">
	<form action="${basePath }noticeList/noticePage" id="fm" method="GET">
		<input type="hidden" id="corpStatus"
			value="${sessionScope.corpStatus }">
		<div class="maincont_mid_cont_right" style="height: 580px;">
			<div class="maincont_mid_cont_right_top">
				<a href="${basePath }employee/userDetails">员工总数：${Num}人,查看员工信息</a>
				<c:if test="${not empty enddate}">
					<a href="qiye/mycheck/mycheckCondition.jsp" style="width:300px;">安全责任保险截止日期到<fmt:formatDate
							value="${enddate}" type="date" dateStyle="long" />,查看保单信息
					</a>
				</c:if>
				<c:if test="${empty enddate}">
					<a href="${basePath }/insurePolicy/getAreaPlan"
						style="width:300px;">未投保,点击投保</a>
				</c:if>
			</div>
	
			<div id="br_Cnt0" style="width: 100%;">
				<div class="maincont_mid_cont_right_main"
					style="padding: 0;padding-top: 10px;">
					<table cellpadding="0" cellspacing="0" width="100%" border="0"
						style="margin-top: 20px;text-align:left;">
						<tr class="table_head" style="text-align: center;">
							<td style="width: 8%;">序号</td>
							<td style="width: 50%;">标题</td>
							<td style="width: 22%;">发送人</td>
							<td style="width: 20%;">发送时间</td>
						</tr>
						<c:if test="${ not empty sessionScope.pagination.resultList or sessionScope.pagination.resultList != ''}">
						<c:forEach items="${sessionScope.pagination.resultList }"
							var="ggnotice" varStatus="listSize">
								<c:if test="${ggnotice.SERIESNO != ''}">
								<c:if test="${listSize.index %2 ==0 }">
									<tr class="table_listb" style="text-align: center;height:35px;">
								</c:if>
								<c:if test="${listSize.index %2 != 0 }">
									<tr class="" style="text-align: center;height:35px;">
								</c:if>
								<td><c:out value="${listSize.index+1 }"></c:out></td>
								<td><c:if test="${listSize.index %2 ==0 }">
										<a
											href="${basePath }/noticeList/noticeDetails?seriesNo=${ggnotice.SERIESNO }&markRead=0&recipient=${ggnotice.RECIPIENT}"
											style="text-align:center;width:97%;margin:0px;background:#f5f5f5;color:black;padding:0;display:block;float:none;"
											class="table_listb">${ggnotice.TITLE } </a>
									</c:if> <c:if test="${listSize.index %2 != 0 }">
										<a
											href="${basePath }/noticeList/noticeDetails?seriesNo=${ggnotice.SERIESNO }&markRead=0&recipient=${ggnotice.RECIPIENT}"
											style="text-align:center;width:97%;margin:0px;background:#fff;color:black;padding:0;display:block;float:none;"
											class="table_listb">${ggnotice.TITLE } </a>
									</c:if></td>
								<td>${ggnotice.PUBLISHER }</td>
								<td>${ggnotice.PUBLISHTIME }</td>
								</tr>
								</c:if>
						</c:forEach>
						</c:if>
								<c:if test="${sessionScope.pagination.resultList =='' or empty sessionScope.pagination.resultList }">
									<tr style="">
									
									<td style="color: red;text-align: center;padding-top: 50px;font-size: 20px;" colspan="4" >无新未读信息</td>
									</tr>
								</c:if>
					</table>
					<div class="pages">
						<jsp:include page="${basePath }/enterprise/etyPagination.jsp"></jsp:include>
					</div>
				</div>
			</div>
	</form>
</body>
<script type="text/javascript">
	function validUser() {
		var status = document.getElementById("corpStatus").value;
		if (status == "0") {
			window.open("${basePath}/usercorp/initData", "mainFrame");
		}
	}
</script>
</html>
