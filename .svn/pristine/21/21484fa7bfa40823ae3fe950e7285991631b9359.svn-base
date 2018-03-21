<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="${basePath }/etpcss/style.css">
<link href="${basePath }/etpcss/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap-datetimepicker.js"></script>   
<html>
  <body>
  <form action="${basePath }/insurePolicy/getPingCo" enctype="multipart/form-data" name="fm" method="post">
  <div class="maincont_mid_cont_right" style="height:600px;">
  	<table id="sonTab" cellpadding="0" cellspacing="0"  width="100%" border="0" style="margin-top: 10px;">
        <tr class="table_lista">
          	<td align=center>评价人</td>
         	<td align=center>评价内容</td>
         	<td align=center>评价分数</td>
        </tr>
        <c:forEach items="${sessionScope.pagination.resultList }" var="mycheck" varStatus="th">
	 	<tr>
			<td align=center>${mycheck.PINGJIAREN }****</td>
			<td align=center>${mycheck.CONTENT }</td>
	        <td align=center>${mycheck.SCORE }</td>
        </tr>
        </c:forEach>
      </table>
      <jsp:include page="${basePath }/enterprise/etyPagination.jsp"></jsp:include>
      <div class="maincont_mid_cont_right_bot" style="width:90%;text-align:center;padding:5px;float:left;">
      	<div style="width:300px;margin:0 auto;">
		  <a style="cursor:pointer;width: 80px;height: 22px;padding: 5px 0px;" onclick="cancelSelect()">关闭</a>
		</div>
	  </div>
  </div>
  </form>
    <script type="text/javascript">
 function cancelSelect() {
  	window.parent.close();
 }
  </script>
  </body>
</html>
