<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'myclaimShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath }/css/etpStyle.css" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>
	<div class="maincont">
	<div class="neicont_main_left_cont">
	<div class="neicont_imga">
		<img src="images/icotit2.jpg">理赔详情
	</div>
	<div class="neicont_main_left_cont_main">
		<div id="ziliao"  style="border:1px red solid; width:800px; position: absolute; background-color:white; border:1px solid #CCC;border-radius:5px;padding:10px 20px;display:none;">
					<form name="claimchuan" id="claimchuan"
						enctype="multipart/form-data" method="post">
						<table width="90%">
							<tr>
								<td>事故调查报告：</td>
								<td colspan="3">
									<div class="select_list">
										<a class="table_buttonb" style="color:black;" id="ACCIDENTPORT" href="#">事故资料</a>
									</div>
								</td>
							</tr>
							<tr>
								<td>死亡证明：</td>
								<td colspan="3">
									<div class="select_list">
										<a class="table_buttonb" style="color:black;" id="DEATHPORT" href="#">死亡证明</a>
									</div>
								</td>
							</tr>
							<tr>
								<td>伤残证明：</td>
								<td colspan="3">
									<div class="select_list">
										<a class="table_buttonb" style="color:black;" id="DISABLITY" href="javascript:void(0);">伤残证明</a>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="4"></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align:center;"> <a
									href="javascript:hide();"
									style="width:100px;background:#00a6e3;">取消</a></td>
							</tr>
						</table>
					</form>
				</div>
		<table cellpadding="0" cellspacing="0" width="100%" border="0"
			style="margin-top: 50px;font-size:20px; ">

			<tr class="table_head">
				<td style="border-bottom:#9CF 1px solid;">被保险人名称</td>
				<td style="border-bottom:#9CF 1px solid;">保单号</td>
				<td style="border-bottom:#9CF 1px solid;">赔案号</td>
				<td style="border-bottom:#9CF 1px solid;">赔款金额</td>
				<td style="border-bottom:#9CF 1px solid;">出险时间</td>
				<td style="border-bottom:#9CF 1px solid;">出险原因</td>
				<td style="border-bottom:#9CF 1px solid;">保险公司</td>
				<td style="border-bottom:#9CF 1px solid;">赔付金额</td>
				<td style="border-bottom:#9CF 1px solid;">阶段查看</td>
				<td style="border-bottom:#9CF 1px solid;">资料查看</td>
			</tr>
			<c:forEach items="${resultMap }" var="st">
			<tr class="table_mid">
			<td style="border-bottom:#9CF 1px solid;text-align:left;">${st.INSUREDNAME}</td>
			<td style="border-bottom:#9CF 1px solid;text-align:left;">${st.POLICYNO}</td>
			<td style="border-bottom:#9CF 1px solid;text-align:left;">${st.PEIANNO}</td>
			<td style="border-bottom:#9CF 1px solid;text-align:left;">${st.PAYAMOUNT}元</td>
			<td style="border-bottom:#9CF 1px solid;text-align:left;"><fmt:formatDate
						value="${st.LOSSDATE }" pattern="yyyy-MM-dd" /></td>
			<td style="border-bottom:#9CF 1px solid;text-align:left;">${st.LOSSCAUSE}</td>
			<td style="border-bottom:#9CF 1px solid;text-align:left;">${st.INSURERCODE}</td>
			<td style="border-bottom:#9CF 1px solid;text-align:left;">${st.PAYAMOUNT}元</td>
			<td style="border-bottom:#9CF 1px solid; text-align: left;">
					<c:if test="${st.STATUS == '1' }">报案阶段</c:if>
					<c:if test="${st.STATUS == '2' }">勘察阶段</c:if>
					<c:if test="${st.STATUS == '3' }">定损核损</c:if>
					<c:if test="${st.STATUS == '4' }">赔付阶段</c:if>
					<c:if test="${st.STATUS == '5' }">完成理赔</c:if>
				</td>
			<td>
			<a style="border-bottom:#9CF 1px solid; padding:3px 8px; background: #00a6e3; text-align: left;"  href="javascript:showDiv('${st.ACCIDENTPORT}','${st.DEATHPORT }','${st.DISABLITY }');">资料</a></td>	
			</tr>
			</c:forEach>
		</table>
		<div class="select_list" style="margin-left: 40%">
		<a class="select_list" style="margin-top:20px;margin-left: 45%;" href="javascript:history.go(-1);">返回</a>
		</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
	function showDiv(A,B,C) {
		if(A != null || A != ''){
		var ACCIDENTPORT = document.getElementById("ACCIDENTPORT");
		ACCIDENTPORT.href=A;
		}
		if(A == null || A == ''){
			ACCIDENTPORT.href='javascript:void(0)';
		}
		if(B != null || B != ''){
		var DEATHPORT = document.getElementById("DEATHPORT");
		DEATHPORT.href=B;
		}
		if(B == null || B == ''){
			DEATHPORT.href='javascript:void(0)';
		}
		if(C != null || C != ''){
		var DISABLITY = document.getElementById("DISABLITY");
			DISABLITY.href = C;
		}
		if(C == null || C == ''){
			DISABLITY.href='javascript:void(0)';
		}
		alert(1111);
		document.getElementById("ziliao").style.display = 'block';
		document.getElementById("ziliao").style.top = "30px";
//			alert("完成操作");

	}
	function hide() {
		
		document.getElementById("ziliao").style.display = "none";
	}
	</script>
</body>
</html>
