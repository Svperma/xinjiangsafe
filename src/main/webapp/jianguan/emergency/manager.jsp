<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  <body>
  <jsp:include page="${basePath }/common/include.jsp"></jsp:include>
        <form action="${basePath }/Emergency/emergencylist"  method="GET">
      		 <div class="neicont_imga">
            	<img src="images/icotit2.jpg">
                <div class="neicont_img_font">应急管理</div>
             </div>
             <div class="neicont_main_left_cont_main">
                <table cellpadding="0" cellspacing="0"  width="100%" border="0" style="margin-top: 10px;">
			        <tr class="table_lista">
			          <td style="border-top-left-radius: 5px;">序号</td>
			          <td>预案名称</td>
			          <td>文件来源</td>
			          <td style="border-top-right-radius: 5px;">操作</td>
			        </tr>
			        <c:forEach items="${sessionScope.pagination.resultList }" var="ggemergency"
							varStatus="listSize">
			        <tr>
			          <td><c:out value="${listSize.count }"></c:out></td>
			          <td><c:out value="${ggemergency.TITLE }"></c:out></td>
					  <td>
					       <c:choose>
						       <c:when test="${ggemergency.DOCSOURCE eq '01'}">
								<font>事故预防办公室</font>
							   </c:when>
							   <c:when test="${ggemergency.DOCSOURCE eq '02'}">
								<font>保险公司</font>
							   </c:when>
							   <c:when test="${ggemergency.DOCSOURCE eq '03'}">
								<font>企业</font>
							   </c:when>
						    </c:choose>
					  </td>
			          <td><a class="table_buttonb" href="main15-1.html">查看</a></td>
			        </tr>
			        </c:forEach>  
               </table>
               <jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
             </div>
       </form>   
  </body>
</html>
