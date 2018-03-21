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
<script type="text/javascript" src="${basePath }/js/card.js"></script>   
<html>
  <body>
  <form action="" enctype="multipart/form-data" method="post" name="fm">
  <div class="maincont_mid_cont_right" style="height:600px;">
  	<h3>理赔记录</h3>
  	<table id="sonTab" cellpadding="0" cellspacing="0"  width="80%" border="0" style="margin-top: 30px;margin:0 auto;">
        <tr class="table_lista">
          	<td align=center>序号</td>
          	<td align=center>企业名称</td>
			<td align=center>保单号</td>
         	<td align=center>赔案号</td>
         	<td align=center>出险时间</td>
         	<td align=center>保险公司</td>
			<td align=center>赔款金额</td>
			<td align=center>结案时间</td>
			<td align=center>结案状态</td>
        </tr>
        <c:forEach items="${sessionScope.pagination.resultList }" var="fList" varStatus="rowIndex">
      	  <tr <c:if test="${rowIndex.count%2==0 }">class="table_listb"</c:if>>
      	  <td align=center>${rowIndex.index+1 }</td>
          <td align=center>${fList.INSUREDNAME }</td>
          <td align=center>${fList.POLICYNO }</td>
          <td align=center>${fList.PEIANNO }</td>
          <td align=center>${fList.LOSSDATE }</td>
          <td align=center>${fList.INSURERCODE }</td>
          <td align=center>${fList.PAYAMOUNT }</td>
          <td align=center>${fList.CLOSEDATE }</td>
          <td align=center>
       				<c:if test="${fList.STATUS == '5' }">
					 已结案
					</c:if>
					<c:if test="${fList.STATUS == '4'}">
					 勘察
					</c:if>
					<c:if test="${fList.STATUS == '3'}">
					 定损核损
					</c:if>
					<c:if test="${fList.STATUS == '2'}">
					 赔付
					</c:if>
					<c:if test="${fList.STATUS == '1'}">
					 已报案
					</c:if>
			</td>
          </tr>
        </c:forEach>
      </table>
      <div class="maincont_mid_cont_right_bot" style="width:90%;padding:5px;margin:0 auto;">
      	<div style="width:300px;margin:0 auto;text-align:center;">
		  <a style="cursor:pointer;width: 80px;height: 22px;padding: 5px 0px;display:block;margin:0 auto;float:none;" onclick="history.go(-1)">返回</a>
		</div>
	  </div>
  </div>
  </form>
  </body>
</html>
