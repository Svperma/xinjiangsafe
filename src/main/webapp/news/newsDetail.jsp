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
            <span style="float:right;color:#aaa;">发布时间：<fmt:formatDate value="${sessionScope.newsDetail.PUBLISHDATE }" pattern="yyyy-MM-dd"/></span>
	  </div>
	  
	  <!-- <div class="nav_1" style="font-weight: bold;">
	  	简介：
	  </div> -->
	  
	  <%-- <div class="nav_1" style="text-align:left;display:block; font-size:18px;word-break:normal;overflow-wrap: break-word;width:75%;">
	  	<span style="overflow-wrap: break-word;margin-left: 3%;">
	  	${sessionScope.newsDetail.DECRIPTION }
	  	</span>
	  </div> --%>
	  
	  <c:if test="${sessionScope.newsDetail.IMAGEPATH != null }">
	  <div class="nav_1" style="text-align: center;">
	  	<img alt="" src="${sessionScope.newsDetail.IMAGEPATH }" style="width: 585px;height: 380px;">
	  </div>
	  </c:if>
	  
	  <!-- <div class="nav_1" style="font-weight: bold;">
	  	内容：
	  </div> -->
	  
	  <div class="nav_1" style="text-align:left;display:block; font-size:18px;word-break:normal;overflow-wrap: break-word;width:66%;overflow: hidden;">
	  	<span style="overflow-wrap: break-word;margin-left: 3%;">
	  	${sessionScope.newsDetail.DOCCONTENT }
	  	</span>
	  </div>
	</nav>
	<div class="nav_1" style="text-align: center;">
		<c:if test="${sessionScope.pMap != ''}">
		<a href="${basePath }/newsDetail?id=${sessionScope.pMap.DOCID}&docType=${sessionScope.pMap.DOCTYPE}&docDate=${sessionScope.pMap.PUBLISHDATE}" style="margin-right:50px;cursor:poitor;">上一篇</a>
		</c:if>
		<c:if test="${sessionScope.nMap != ''}">
		<a href="${basePath }/newsDetail?id=${sessionScope.nMap.DOCID}&docType=${sessionScope.nMap.DOCTYPE}&docDate=${sessionScope.nMap.PUBLISHDATE}">下一篇</a>
		</c:if>
		<hr>
	</div>
	<jsp:include page="${basePath }/news/footer.jsp"></jsp:include>
  </body>
</html>
