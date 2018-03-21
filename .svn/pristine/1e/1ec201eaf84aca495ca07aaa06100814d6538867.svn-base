<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<form action="${basePath }/dsmanager/correctQueryContinue" id="fm" method="GET">
			<table cellpadding="0" cellspacing="0" width="100%" border="1"
				style="margin-top: 10px;">
				<tr class="table_lista">
							<td>批单号</td>
							<td>被保险人</td>
							<!--<td>起保日期</td>
							<td>终保日期</td>-->
							<td>保单号</td>
							<td>总保费（元）</td>
							<td>批改金额（元）</td>
							<td>保险公司</td>
							<td>归属机构</td>
							<td>业务员</td>
							<td>保单状态</td>
							<td>审核状态</td>
							<td>详情</td>
						</tr>
						<c:forEach items="${sessionScope.pagination.resultList }"
							var="mycheck" varStatus="th">
							<c:if test="${th.index % 2 != 1 }">
								<c:if test="${mycheck.STATUS != 1 }">
									<tr class="table_mid" style="color:#F00;">
								</c:if>
								<c:if test="${mycheck.STATUS == 1 }">
									<tr class="table_mid">
								</c:if>
							</c:if>
							<c:if test="${th.index % 2 == 1 }">
								<c:if test="${mycheck.STATUS != 1 }">
									<tr style="color:#F00;">
								</c:if>
								<c:if test="${mycheck.STATUS == 1 }">
									<tr>
								</c:if>
							</c:if>
							<td>${mycheck.ENDORSEMENT }</td>
							<td>${mycheck.INSUREDNAME }</td>
							<!-- <td><fmt:formatDate value="${mycheck.STARTDATE }"
									pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${mycheck.ENDDATE }"
									pattern="yyyy-MM-dd" /></td>-->
							<td>${mycheck.POLICYNO }</td>
							<td>${mycheck.SPREADSHEETPREMIUM }</td>
							<td>${mycheck.CALCULATION }</td>
							<td>${mycheck.INSURERCODE }</td>
							<td>
								<c:if test="${mycheck.GUISHU == null  }">
								无
								</c:if>
								<c:if test="${mycheck.GUISHU != null  }">
								${mycheck.GUISHU }
								</c:if>
							</td>
							<td>
								<c:if test="${mycheck.FLAG == null  }">
								企业自投
								</c:if>
								<c:if test="${mycheck.FLAG != null  }">
								${mycheck.ORDERNAME }
								</c:if>
							</td>
							<td><c:if test="${mycheck.STATUS == 1 }">有效</c:if> <c:if
									test="${mycheck.STATUS != 1 }">无效</c:if>
							</td>
							<td>
								<c:if test="${mycheck.FLAG == '1' }">完成</c:if>
								<c:if test="${mycheck.FLAG == '0' }">待审核</c:if>
								<c:if test="${mycheck.FLAG == '2' }">审核不通过</c:if>
							</td>
							<td>
								<c:if test="${mycheck.FLAG == '1' }">
									<a class="table_buttonb"
									href="/dsmanager/mypolicyshowP?businessno=${mycheck.BUSINESSNO }" target="mainFrame">查看</a>
								</td>
								</c:if>
								<c:if test="${mycheck.FLAG == '0' }">
									<a class="table_buttonb"
									href="/dsmanager/mypolicyshowP?businessno=${mycheck.BUSINESSNO }" target="mainFrame">查看</a>
								</td>
								</c:if>
								<c:if test="${mycheck.FLAG == null }">
									<a class="table_buttonb"
									href="/dsmanager/mypolicyshowP?businessno=${mycheck.BUSINESSNO }&evaluator=${mycheck.ENDORSEMENT }" target="mainFrame">查看</a>
									</td>
								</c:if>
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
