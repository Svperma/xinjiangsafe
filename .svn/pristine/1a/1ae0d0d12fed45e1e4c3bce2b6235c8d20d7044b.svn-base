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
				<form action="${basePath }/dsmanager/mypolicyjjPagin" id="fm"
					method="post">
					<span style="font-size: 12px;color: red;float:right;">注：“线下出单”按钮为企业线下汇款确认到账后手动出单的功能，请务必在确认到账之后点击出单。</span>
					<table cellpadding="0" cellspacing="0" width="100%" border="0">
						<tr class="table_head">
							<td align="center">被保险人</td>
							<td align="center">起保日期</td>
							<td align="center">终保日期</td>
							<td align="center">投保人数</td>
							<td align="center">总保费（元）</td>
							<td align="center">保险公司</td>
							<td align="center">归属机构</td>
							<td align="center">业务员</td>
							<td align="center">状态</td>
							<td align="center" style="width:290px;">操作</td>
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
							
							<td align="center">${mypolicy.INSUREDNAME }</td>
							<td id="startDate${th.index }" align="center"><fmt:formatDate value="${mypolicy.STARTDATE }"
									pattern="yyyy-MM-dd" /></td>
							<td align="center"><fmt:formatDate value="${mypolicy.ENDDATE }"
									pattern="yyyy-MM-dd" /></td>
							<td align="center">${mypolicy.EMCOUNT }</td>
							<td align="center">${mypolicy.SPREADSHEETPREMIUM }</td>
							<td align="center">${mypolicy.INSURERCODE }</td>
							<td align="center">
								<c:if test="${mypolicy.GUISHU == null  }">
								无
								</c:if>
								<c:if test="${mypolicy.GUISHU != null  }">
								${mypolicy.GUISHU }
								</c:if>
							</td>
							<td align="center">
								<c:if test="${mypolicy.FLAG == null  }">
								企业自投
								</c:if>
								<c:if test="${mypolicy.FLAG != null  }">
								${mypolicy.ORDERNAME }
								</c:if>
							</td>
							<td align="center">
								<c:if test="${mypolicy.UNDERWRITEFLAG == '0'  }">暂存</c:if>
								<c:if test="${mypolicy.UNDERWRITEFLAG == '1'  }">待审核</c:if>
								<c:if test="${mypolicy.UNDERWRITEFLAG == '2'  }">不通过</c:if> 
								<c:if test="${mypolicy.UNDERWRITEFLAG == '5'  }">待报价</c:if> 
								<c:if test="${mypolicy.UNDERWRITEFLAG == '3'  }">
									<c:if test="${mypolicy.PAYFLAG == '0' }">通过审核</c:if>
									<c:if test="${mypolicy.PAYFLAG == '1' }">出单失败</c:if>
								</c:if>
							</td>
							<td align="center"> 
								<c:if test="${mypolicy.FLAG == null  }">
									<c:if test="${mypolicy.UNDERWRITEFLAG == 3 }">
										<c:if test="${mypolicy.PAYFLAG == 0}">
											<!-- 0 表示未缴费 - 1表示已缴费 -->
											<a class="table_buttonb"
												<%-- href="/dsmanager/underLine?businessNo=${mypolicy.BUSINESSNO }" --%>
												onclick="underLine('${mypolicy.BUSINESSNO}'	,'${th.index }')"
												target="mainFrame" style="background-color:#390; cursor:pointer;">线下出单</a>
										</c:if>
										<c:if test="${mypolicy.PAYFLAG == 1}">
											<a class="table_buttonb" 
											<%-- href="/dsmanager/callBack?businessno=${mypolicy.BUSINESSNO }" --%>
											onclick="callBack('${mypolicy.BUSINESSNO}'	,'${th.index }')"
											style="background-color:#F00; cursor:pointer;" target="mainFrame">重新出单</a>
										</c:if>
									</c:if> 
									<c:if test="${mypolicy.UNDERWRITEFLAG == 1}"> 
<!-- 										<a class="table_buttonb" href="/dsmanager/mypolicyshow?businessno=${mypolicy.BUSINESSNO }" -->
<!-- 										target="mainFrame">审核</a> -->
										<a class="table_buttonb"
										href="/dsmanager/modfyPolicy?businessno=${mypolicy.BUSINESSNO }"
										target="mainFrame">修改</a>
									</c:if>
									<a class="table_buttonb"
									href="/dsmanager/delPolicy?businessno=${mypolicy.BUSINESSNO }"
									style="background-color:#F00;" target="mainFrame">注销</a>
								</c:if>
								<c:if test="${mypolicy.FLAG == '1'  }">
									<a class="table_buttonb"
									href="/dsmanager/mypolicyshowP?businessno=${mypolicy.BUSINESSNO }" target="mainFrame">查看</a>
									</td>
								</c:if>
								<c:if test="${mypolicy.FLAG == '0'  }">
									<c:if test="${mypolicy.UNDERWRITEFLAG == '5'  }">
										<a class="table_buttonb"
										href="/dsmanager/getThisPreumin?businessno=${mypolicy.BUSINESSNO }"
										target="mainFrame">查看报价</a>
									</c:if> 
									<c:if test="${mypolicy.UNDERWRITEFLAG == '3'  }">
										<c:if test="${mypolicy.PAYFLAG == 0}">
										<a class="table_buttonb" 
										<%-- href="/payment/preparePay?businessNo=${mypolicy.BUSINESSNO }" --%>
										onclick="preparePay('${mypolicy.BUSINESSNO}'	,'${th.index }')"
										target="mainFrame" style="background-color:#390; cursor:pointer;">缴费</a>
										<a class="table_buttonb"
										<%-- href="/dsmanager/underLine?businessNo=${mypolicy.BUSINESSNO }" --%>
										onclick="underLine('${mypolicy.BUSINESSNO}'	,'${th.index }')"
										target="mainFrame" style="background-color:#390; cursor:pointer;">线下出单</a>
										</c:if>
										<c:if test="${mypolicy.PAYFLAG == 1 }">
											<a class="table_buttonb" style="cursor:pointer;"
											onclick="dsResubmit('${mypolicy.BUSINESSNO}','${th.index }')"
											style="background-color:#F00;" target="mainFrame">重新出单</a>
										</c:if>
									</c:if>
									<c:if test="${mypolicy.UNDERWRITEFLAG == '2' }">
										<a class="table_buttonb" 
										<%-- 	href="/dsmanager/dsResubmit?businessno=${mypolicy.BUSINESSNO }" --%>
											onclick="dsResubmit('${mypolicy.BUSINESSNO}','${th.index }')"
											style="background-color:#F00; cursor:pointer;" target="mainFrame">重新出单</a>
									</c:if>
									<a class="table_buttonb"
									href="/dsmanager/delPolicy?businessno=${mypolicy.BUSINESSNO }"
									style="background-color:#F00;" target="mainFrame">注销</a>
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
	
	<script type="text/javascript">
		function dsResubmit(businessNo,index) {
			var startDate = document.getElementById("startDate"+index).innerHTML;
			var startDate2 = new Date(startDate);
			var today = new Date();
			if(startDate2 <= today) {
			  	alert("起保日期不能小于或等于当前日期!");
			  	return false;
			}
			var fom = document.getElementById("fm");
			fom.action = "${basePath}/dsmanager/dsResubmit?businessno=" + businessNo;
			fom.target = "mainFrame";
			fom.submit();
		}
		
		function underLine(businessNo,index) {
			var startDate = document.getElementById("startDate"+index).innerHTML;
			var startDate2 = new Date(startDate);
			var today = new Date();
			if(startDate2 <= today) {
			  	alert("起保日期不能小于或等于当前日期!");
			  	return false;
			}
			var fom = document.getElementById("fm");
			fom.action = "${basePath}/dsmanager/underLine?businessno=" + businessNo;
			fom.target = "mainFrame";
			fom.submit();
		}
		
		function preparePay(businessNo,index) {
			var startDate = document.getElementById("startDate"+index).innerHTML;
			var startDate2 = new Date(startDate);
			var today = new Date();
			if(startDate2 <= today) {
			  	alert("起保日期不能小于或等于当前日期!");
			  	return false;
			}
			var fom = document.getElementById("fm");
			
			var url = document.referrer;
			window.open("/payment/preparePay?businessNo="+businessNo+"&type=1&his="+url);
		
// 			fom.action = "${basePath}/dsmanager/preparePay?businessno=" + businessNo;
// 			fom.target = "mainFrame";
// 			fom.submit();
		}
		
		function callBack(businessNo,index) {
			var startDate = document.getElementById("startDate"+index).innerHTML;
			var startDate2 = new Date(startDate);
			var today = new Date();
			if(startDate2 <= today) {
			  	alert("起保日期不能小于或等于当前日期!");
			  	return false;
			}
			var fom = document.getElementById("fm");
			fom.action = "${basePath}/dsmanager/callBack?businessno=" + businessNo;
			fom.target = "mainFrame";
			fom.submit();
		}
		
		
	</script>
	
</body>
</html>
