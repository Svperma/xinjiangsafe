<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<form method="post" action="${basePath }/edit/queryExpect" id="fma"
			name="fma">
			<div class="panel-head">
				<strong class="icon-reorder"> 内容列表</strong> 
				<a href="" style="float:right; display:none;">添加字段</a>
			</div>

			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li>
						<a class="button border-main icon-plus-square-o"
						href="${basePath }/edit/addExpect?docType=0"> 添加内容
						</a>
					</li>
					<li>搜索：</li>
					<li>
						<input type="text" placeholder="请输入搜索关键字" name="keywords" id="keywords" class="input"
							style="width:250px; line-height:17px;display:inline-block" /> 
						<input type="text" name="docType" id="docType" value="5" class="input"
							style="width:250px; line-height:17px;display:none;" />
						<a href="javascript:query();" class="button border-main icon-search">搜索</a>
					</li>
					<!-- <li>
						<input type="text" placeholder="请输入搜索期数" name="expeNo" id="expeNo" class="input"
							style="width:250px; line-height:17px;display:inline-block" /> 
						
					</li> -->
				</ul>
			</div>
		</form>
	</div>
	<div class="panel admin-panel" style="height:500px;">
		<iframe scrolling="auto" rameborder="0"
			src="${basePath }/admin/advDown.jsp" name="table" width="100%"
			height="100%" id="advFrame">
		</iframe>
	</div>
	<script type="text/javascript">
		function query() {
			var url = "${basePath }/edit/queryExpect";
			var form = document.forms["fma"];
			form.action = url;
			form.submit();
		}
	</script>
</body>
</html>