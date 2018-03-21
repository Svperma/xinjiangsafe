<%@page import="com.sun.xml.internal.rngom.ast.builder.Include"%>
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
	<nav style="min-height:580px;background-color:white;width:1170px;margin:0 auto;">
	  <div class="nav_1">
            <div style="font-size:20px; font-weight: 900;margin: 0 auto;text-align: center;">
	            公众参与
            </div>
            <HR>
      </div>
      <style>
		#ul-1,#li-1{
			width:100%;
			height:20px;
			list-style: disc;
			padding:0 10px 0 15px;
		}
		#li-1{
			padding:10px 0px;
			
		}
		#li-1 a{
			display:block;
			float:left;
			color:black;
		}
		#li-1 a:hover,#li-1:hover{
			color:#e4393c;
		}
		#span-1{
			display:block;
			float:right;
			margin-right: 20px;
		}
      </style>
	  <div  style="text-align: left;">
	 	<c:forEach items="${sessionScope.pagination.resultList }" var="ggEvalute">
            	<span><a href="${basePath }/publicDetail?id=${ggEvalute.seriesNo}"><span class="letter">&nbsp;问：</span>${ggEvalute.content }</a></span><br>
            	<c:forEach items="${ggEvalute.list }" var="del">
            		<span><a href="${basePath }/publicDetail?id=${ggEvalute.seriesNo}"><span class="letter1">&nbsp;答：</span>${del.content }</a></span><br>
            	</c:forEach>
            	<hr style="border:1px dotted;">
            </c:forEach>
	  </div>
	  
	</nav>
	<form action="${basePath }/publicLookUpContinue" id="fm" name="fm" method="get" >
	<div style="width: 1170px;margin:0 auto;">
		<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
		<hr>
	</div>
	</form>
	<jsp:include page="${basePath }/footer.jsp"></jsp:include>
  </body>
</html>
