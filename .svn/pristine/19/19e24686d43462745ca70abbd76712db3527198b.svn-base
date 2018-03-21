<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="${basePath }/etpcss/style.css">
<link href="${basePath }/etpcss/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${basePath }/css/tab-tou.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<html>
  <body style="height:100%;background:#fff;">
  <form action="" enctype="multipart/form-data" method="post" name="fom">
  <div class="maincont_mid_cont_right">
	 <div class="tab-top-div">
		<table class="nav-tab">
			<tr>
				<td colspan="9" class="bg-tab-ddd">地区企业数量维护</td>
			</tr>
			<tr>
				<td colspan="9" >新疆维吾尔族自治区企业总数：${xinjiang }</td>
			</tr>
			<tr>
				<td colspan="4" class="bg-tab-ddd">市</td>
				<td colspan="3" class="bg-tab-ddd">企业总数</td>
				<td colspan="2" class="bg-tab-ddd">维护操作</td>
			</tr>
			<c:forEach items="${chengshi }" var="managerList" varStatus="listSize">
				<tr>
					<td colspan="4">${managerList.PROVINCE }</td>
					<td colspan="3">${managerList.COMPANY_SUM }</td>
					<td colspan="2">
					<div class="maincont_mid_cont_right_bot" >
						<a style="cursor:pointer; margin: auto;width: 108px;height: 22px;float: none;" onclick="goZus('${managerList.AREA_CODE }')">维护</a>
					</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		</br>
		</br>
	 </div>
	</div>
  </form>
    <script type="text/javascript">
    function goZus(o){
		fom.action = "${basePath}/dsmanager/conmpanyQQQ?codes="+o;
		fom.target = "mainFrame";
		fom.submit();
  	}

  </script>
  </body>
</html>
