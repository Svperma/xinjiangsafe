<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<link href="${basePath }/css/styleCopy.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${basePath }/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath }/js/readXml.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<script type="text/javascript" src="/js/select2cssCopy.js"></script>
<html>
<head>
  <base href="<%=basePath%>">
</head>
 <body>
   <input type="hidden" id="province" value="${sessionScope.ggUser.province }">
<input type="hidden" id="city" value="${sessionScope.ggUser.city }">
<input type="hidden" id="county" value="${sessionScope.ggUser.county }">
<input type="hidden" id="comLevel" value="${sessionScope.ggUser.comLevel }">
   	<div class="neicont_main_left_cont">
       	<div class="neicont_img"><img src="images/icotit1.jpg">企业查询</div>
           <div class="neicont_main_left_cont_main">
           <form action="${basePath }/dsmanager/queryPreventive" name="fm" id="fm" method="post" target="resultFrame">
        	<div class="select_list_all">
				<div class="select_list">
						<div id="uboxstyle">
							<select name="languagec" id="languagec">
								<option value="0" selected="selected" style="background:#fff;">请选择评价等级</option>
								<option value="1" style="background:#fff;">好评</option>
								<option value="2" style="background:#fff;">中评</option>
								<option value="3" style="background:#fff;">差评</option>
							</select>
						</div>
				</div>
				<div class="select_list">
						<div id="uboxstyle">
							<select name="inserdCode" id="inserdCode">
								<option value="" selected="selected">保险公司</option>
								<c:forEach items="${list_CICompanycode}" var="gginsurerconfig" varStatus="st">
									<option value="${gginsurerconfig.insuranceCode }">${gginsurerconfig.insuranceName }</option>
								</c:forEach>
							</select>
						</div>
				</div>
				<div class="select_list" style="margin-left:30px;">
					<a href="javascript:queryPreventive();">查询</a>
				</div>
		</div>
		</form>
	</div>
</div> 
	<iframe name="resultFrame" style="background-color:#F1F1F1;margin-top:10px;" src="/dsmanager/queryPingjia.jsp" width="100%" frameborder="0" height="100%">
	</iframe>
<script type="text/javascript">
	/* 查询方法 */
	function queryPreventive(){
		var url = "${basePath }/dsmanager/getPing";
		var form = document.forms["fm"];
		form.action = url;
		form.submit();
	}
</script>
  </body>
</html>
