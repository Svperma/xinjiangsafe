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
	<form action="${basePath }/newsLookUpContinue" id="fm" name="fm" >
		<nav style="min-height:580px;background-color:white;width:1170px;margin:0 auto;">
		  <div class="nav_1">
	            <div style="font-size:20px; font-weight: 900;margin: 0 auto;text-align: center;">
	            <c:if test="${sessionScope.docType == '1' }">
	            	新闻动态
	            </c:if>
	            <c:if test="${sessionScope.docType == '2' }">
	            	 政策法规
	            </c:if>
	            <c:if test="${sessionScope.docType == '3' }">
	           		 专题报道
	            </c:if>
	            <c:if test="${sessionScope.docType == '4' }">
	            	案例分析
	            </c:if>
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
		  <div class="nav_1">
		 	<ul id="ul-1">
		 		<c:forEach items="${sessionScope.pagination.resultList }" var="item" varStatus="st">
			 			<div id="li-1" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;margin-left: 0px;text-align: left;">
			 				<a style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:85%;margin-top: 2px;margin-left: 0px;text-decoration: underline;"
								href="${basePath }/newsDetail?id=${item.DOCID}&docType=${item.DOCTYPE}&docDate=${item.PUBLISHDATE}">
			 					<span style="margin-right: 20px;float: left;">${st.index+1 }</span>${item.TITLE }</a>
				 			<span id="span-1" style="display:block;float:right;width: 10%;">
				 				<fmt:formatDate value="${item.PUBLISHDATE }" pattern="yyyy-MM-dd" />
				 			</span>
			 			</div>
		 		</c:forEach>
		 	</ul>
		  </div>
		 	<input id="docType" name="docType" value="${sessionScope.docType }" type="hidden">
		  
		</nav>
		<div style="width: 1170px;margin:0 auto;">
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
			<hr>
		</div>
	</form>
		 <jsp:include page="${basePath }/news/footer.jsp"></jsp:include>
  </body>
</html>
