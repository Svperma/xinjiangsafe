<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<title>My JSP 'addInveStigateContion.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="/css/etpStyle.css">
<link href="/css/bootstrap-combined.min.css" rel="stylesheet">
<script type="text/javascript"
	src="${basePath }/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<style>
#div_back .a_back {
	margin: 50 auto;
	padding: 5px 20px;
	background: #00a6e3;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	color: #fff;
}
</style>
</head>

<body>
	<div class="maincont_mid_cont_right_main">
		<input type="hidden"
			value="${sessionScope.govOrganByOrgCode.orgCode }" name="orgCode"
			id="orgCode">
		<table cellpadding="0" cellspacing="0" width="100%" border="0">
			<tr class="table_head">
				<td colspan="4">机构明细</td>
			</tr>
			<tr>
				<td style="border-bottom:1px solid #CCC; font-weight:bold;">机构名称：</td>
				<td style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
					${sessionScope.govOrganByOrgCode.orgName }</td>
				<td
					style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;font-weight:bold;">地址：</td>
				<td style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
					<span style="font-size: 16px;" name="address" id="address">
						<tlds:name codeCode='${sessionScope.govOrganByOrgCode.province }'
							codeType='Province'></tlds:name> <tlds:name
							codeCode='${sessionScope.govOrganByOrgCode.city }'
							codeType='City'></tlds:name> <tlds:name
							codeCode='${sessionScope.govOrganByOrgCode.county }'
							codeType='County'></tlds:name>
						${sessionScope.govOrganByOrgCode.address }
				</span>
				</td>
			</tr>
			<tr>
				<td style="border-bottom:1px solid #CCC;font-weight:bold;">评估范围：</td>
				<td colspan="3"
					style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
					<span style="font-size: 16px;" name="businessType"
					id="businessType"> <tlds:name
							codeCode='${sessionScope.govOrganByOrgCode.langUage }'
							codeType='IndustryCategories'></tlds:name> <tlds:name
							codeCode='${sessionScope.govOrganByOrgCode.businessType }'
							codeType='IndustryType'></tlds:name>
				</span>
				</td>
			</tr>
			<tr>
				<td style="border-bottom:1px solid #CCC;font-weight:bold;">联系人：</td>
				<td style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
					<span style="font-size: 16px;" name="person" id="person">
						${sessionScope.govOrganByOrgCode.orgOwner } </span>
				</td>
				<td
					style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;font-weight:bold;">联系方式：</td>
				<td style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
					<span style="font-size: 16px;" name="telephone" id="telephone">
						${sessionScope.govOrganByOrgCode.phone } </span>
				</td>
			</tr>
			<tr>
				<td style="border-bottom:1px solid #CCC;font-weight:bold;">请选择评估日期：</td>
				<td colspan="3"
					style="border-bottom:1px solid #CCC;border-left:1px solid #CCC;">
					<input class="select_list_organ_inputa" type="text" maxlength="20"
					value="请选择评估日期" name="evaDate" id="evaDate"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
					onblur="if(!value){value=defaultValue;this.style.color='#999'}"
					onclick="WdatePicker({minDate:new Date(),isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
					style="color: rgb(153, 153, 153);">
				</td>
			</tr>
			<tr>
				<td colspan="4"><a
					style="width: 120px;background-color:#00A6E3;border-radius:0px;padding:5px 20px;margin-top:50px;"
					href="javascript:inveStigate();">预约 </a> <a
					style="width: 120px;background-color:#00A6E3;border-radius:0px;padding:5px 20px;margin-top:50px;"
					href="javascript:history.go(-1);" class="a_back">取消</a></td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
	function inveStigate() {
		var organ = document.getElementById("orgCode").value;
		var inveDate = document.getElementById("evaDate").value;
		if (inveDate == "" || inveDate == "请选择评估日期") {
			alert("评估日期为空，请选择约定评估日期！")
		} else {
			$.ajax({
				type : "post",
				url : "${basePath}/subScribe/inveStigateSubmit",
				data : JSON.stringify({
					"orgCode" : organ,
					"evaDate" : inveDate
				}),
				dataType : "json",
				contentType : "application/json;charset=UTF-8",

				success : function(data) {
					alert("预约成功");
					window.location.href = "${basePath}/subScribe/Record";
				},
				error : function() {
					alert("系统异常请重试!");
				}
			});
		}

	}
</script>
</html>
