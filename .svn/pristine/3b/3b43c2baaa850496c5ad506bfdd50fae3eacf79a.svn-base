<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


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

<title>My JSP 'mypolicyResult.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${basePath }/js/select2css.js"></script>

<link rel="stylesheet" href="${basePath }/css/etpStyle.css" />
<link rel="stylesheet" href="/js/calendar/skin/WdatePicker.css">

</head>
<body>
	<div class="maincont">
		<div class="maincont_mid_cont_right">
			<div class="maincont_mid_cont_right_main">
				<form action="${basePath }/mypolicy/mypolicyPagin" id="fm"
					method="post">
					<table cellpadding="0" cellspacing="0" width="100%" border="0">
						<tr class="table_head">
							<td>被保险人</td>
							<td>起保日期</td>
							<td>终保日期</td>
							<td>投保人数</td>
							<td>总保费（元）</td>
							<td>保险公司</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${sessionScope.pagination.resultList }"
							var="mypolicy" varStatus="th">
							<c:if test="${th.index % 2 != 1 }">
								<c:if test="${mypolicy.UNDERWRITEFLAG == 2 }">
									<!-- 判断审核状态 0暂缓 1待审核 2不通过 3通过 -->
									<tr class="table_mid" style="color:red;">
								</c:if>
								<c:if test="${mypolicy.UNDERWRITEFLAG != 2 }">
									<tr class="table_mid">
								</c:if>
							</c:if>
							<c:if test="${th.index % 2 == 1 }">
								<c:if test="${mypolicy.UNDERWRITEFLAG == 2 }">
									<tr style="color:red;">
								</c:if>
								<c:if test="${mypolicy.UNDERWRITEFLAG != 2 }">
									<tr>
								</c:if>
							</c:if>
							<td>${mypolicy.INSUREDNAME }</td>
							<td><fmt:formatDate value="${mypolicy.STARTDATE }"
									pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${mypolicy.ENDDATE }"
									pattern="yyyy-MM-dd" /></td>
							<td>${mypolicy.EMCOUNT }</td>
							<td>${mypolicy.SPREADSHEETPREMIUM }</td>
							<td>${mypolicy.INSURERCODE }</td>
							<td><c:if test="${mypolicy.UNDERWRITEFLAG == '0'  }">暂存</c:if>
								<c:if test="${mypolicy.UNDERWRITEFLAG == '1'  }">待审核</c:if> 
								<c:if test="${mypolicy.UNDERWRITEFLAG == '2'  }">不通过</c:if> 
								<c:if test="${mypolicy.UNDERWRITEFLAG == '5'  }">待报价</c:if> 
								<c:if test="${mypolicy.UNDERWRITEFLAG == '3'  }">
									<c:if test="${mypolicy.PAYFLAG == '0' }">
				 					通过审核
			 						</c:if>
									<c:if test="${mypolicy.PAYFLAG == '1' }">
				 					支付成功
				 					</c:if>
								</c:if>
							</td>
							<td>
								<c:if test="${mypolicy.UNDERWRITEFLAG == 1 }">
									<a class="table_buttonb"
										href="/mypolicy/mypolicyshow?businessno=${mypolicy.BUSINESSNO }"
										target="mainFrame">查看</a> 
								</c:if>
								<c:if test="${mypolicy.UNDERWRITEFLAG == 3 }">
									<a class="table_buttonb"
										href="/mypolicy/mypolicyshow?businessno=${mypolicy.BUSINESSNO }"
										target="mainFrame">查看</a> 
									<c:if test="${mypolicy.PAYFLAG == 0}">
										<!-- 0 表示未缴费 - 1表示已缴费 type=1是保单缴费2是批单缴费-->
										<a class="table_buttonb"
											onclick="preparePay('${mypolicy.BUSINESSNO }')"
											target="mainFrame" style="background-color:#390;">缴费</a>
										<a class="table_buttonb"
										href="/dsmanager/delPolicy?businessno=${mypolicy.BUSINESSNO }"
										style="background-color:#F00;" target="mainFrame">注销</a>
									</c:if>
								</c:if> 
								<c:if test="${mypolicy.UNDERWRITEFLAG == 2 }">
									<a class="table_buttonb"
										href="/mypolicy/mypolicyrenwal?businessno=${mypolicy.BUSINESSNO }"
										style="background-color:#F00;" target="mainFrame">重新提交</a>
									<a class="table_buttonb"
									href="/dsmanager/delPolicy?businessno=${mypolicy.BUSINESSNO }"
									style="background-color:#F00;" target="mainFrame">注销</a>
								</c:if>
								<c:if test="${mypolicy.UNDERWRITEFLAG == '5'  }">
									<a class="table_buttonb"
									href="/insurePolicy/getThisPreumin?businessno=${mypolicy.BUSINESSNO }"
									target="mainFrame">查看报价</a>
								</c:if>
							</td>
							</tr>
						</c:forEach>
					</table>
					<jsp:include page="${basePath }/enterprise/etyPagination.jsp"></jsp:include>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function preparePay(obj){
		var url = document.referrer;
		window.open("${basePath }/payment/preparePay?businessNo="+obj+"&type=1&his="+url);
	}
</script>
</html>
