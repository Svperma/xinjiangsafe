<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>安全生产责任保险服务信息平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <script type="text/javascript" language="JavaScript"></script>
  <script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
  <script type="text/javascript" src="${basePath }/js/index.js"></script>
  <link rel="stylesheet" href="${basePath }/css/xm1.css">
  <link rel="stylesheet" type="text/css" href="${basePath }/etpcss/style.css">
  <link rel="stylesheet" type="text/css" href="${basePath }/css/tab-tou.css">
  </head>
  
  <body>
   <header>
		<div class="img_1">
            <jsp:include page="${basePath }/news/biaoti.jsp"></jsp:include>
		</div>
	</header>
	<nav style="min-height:580px;">
	  <div class="nav_1" >
            <div style="display:block;word-break:normal;overflow-wrap: break-word;width:90%;font-size:20px; font-weight: 900;margin: 0 auto;text-align: center;">${sessionScope.newsDetail.TITLE }</div>
            <HR>
	  </div>
	  
	  
	  <c:if test="${guPolicyMain.businessNo != null }">
		 <div class="nav_1" style="text-align:left;display:block; font-size:18px;word-break:normal;overflow-wrap: break-word;width:75%;">
		  	<span style="overflow-wrap: break-word;margin-left: 3%;">
				<table class="nav-tab">
				<tr>
				<td class="bg-tab-ddd">企业名称</td>
				<td class="bg-tab-ddd">保险期间</td>
				<td class="bg-tab-ddd">赔偿限额</td>
				<td class="bg-tab-ddd">保单状态</td>
				</tr>
				<tr>
				<td>${guPolicyMain.appliName}</td>
				<td><fmt:formatDate value='${guPolicyMain.startDate}' pattern='yyyy年MM月dd'/>日至<fmt:formatDate value='${guPolicyMain.endDate}' pattern='yyyy年MM月dd'/>日</td>
				<td>${guPolicyMain.sumAmount/10000}万元</td>
				<td>${guPolicyMain.remark}</td>
				</tr>
				</table>
		  	</span>
		  </div>
	  </c:if>
	  <c:if test="${guPolicyMain.businessNo == null }">
	  <div class="nav_1" style="color: red;font-size:18px;width:75%;">
	  	<span style="text-align:center; margin: auto;">
				提示信息:${guPolicyMain.appliName}
	  	</span>
	  </div>
	  </c:if>
				</br>
				</br>
				</br>
	  <div class="maincont_mid_cont_right_bot" style="width: 100%;">
			<a style="cursor:pointer; display: block;margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;" onclick="javascript:history.go(-1);">返回首页</a>
		</div>
	</nav>
	<div class="nav_1" style="text-align: center;">
	</div>
	<jsp:include page="${basePath }/news/footer.jsp"></jsp:include>
  </body>
</html>
