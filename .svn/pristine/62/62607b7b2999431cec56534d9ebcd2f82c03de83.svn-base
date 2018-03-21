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
  <form action="${basePath}/insurePolicy/getPlaceValue" enctype="multipart/form-data" method="post" name="fm">
  <div class="maincont_mid_cont_right" style="height:600px;">
  	<table id="sonTab" cellpadding="0" cellspacing="0"  width="100%" border="0" style="margin-top: 10px;">
        <tr class="table_lista">
          	<td align=center>序号</td>
         	<td align=center>员工姓名</td>
		  	<td align=center>身份证号</td>
        </tr>
        <c:forEach items="${ggEmployeeList }" var="fList" varStatus="rowIndex">
      	  <tr <c:if test="${rowIndex.count%2==0 }">class="table_listb"</c:if>>
      	  <td align=center>${rowIndex.index+1 }</td>
          <td align=center>${fList.emName }</td>
          <td align=center>${fList.identityNo }</td>	
          </tr>
        </c:forEach>
      </table>
  </div>
  </form>
  </body>
</html>
