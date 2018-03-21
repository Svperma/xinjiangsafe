<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>报案</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
#div_back .a_back {
	display: inline-block;
	margin: 20px auto;
	padding: 7px 20px;
	background: #00a6e3;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	color: #fff;
	width: 60px;
	font-size: 14px;
}

#div_back {
	text-align: center;
	line-height: 20px;
}

#tab_personal td {
	font-size: 18px;
}
</style>

<jsp:include page="${basePath }/common/include.jsp"></jsp:include>

</head>
<body>
	<form action="#" method="GET" name="fmn" target="mainFrame">
		<div class="neicont_img" style="font-size: 18px;">
			<img src="images/icotit3.jpg">报案信息
		</div>
		<div class="neicont_main_left_cont_main">
			<div></div>
			<div class="neicont_main_left_cont_main">
				<table
					style="table-layout: fixed;word-wrap:break-word;text-align: center;"
					width="100%" id="tab_personal">
					<c:forEach items="${gupolicymainList }" var="list" varStatus="vr">
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">保单号码：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input class="select_list_inputa"
								style="color: rgb(153, 153, 153);" value="${list.policyNo }"
								id="policyNo" name="policyNo" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">被保险人：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input class="select_list_inputa"
								style="color: rgb(153, 153, 153);" value="${list.insuredCode }"
								id="insuredCode" name="insuredCode" type="hidden"> <input
								class="select_list_inputa" style="color: rgb(153, 153, 153);"
								value="${list.insuredName }" id="insuredName" name="insuredName"
								readonly="readonly">
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">投保人数：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input class="select_list_inputa"
								style="color: rgb(153, 153, 153);" value="${list.remark }"
								id="sumPerson" name="sumPerson" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">保险期限：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input
								value="<fmt:formatDate value='${list.startDate }' pattern='yyyy-MM-dd HH:mm:ss'/>"
								style="color: rgb(153, 153, 153);" readonly="readonly"
								id="startDate" name="startDate">至 <input
								value="<fmt:formatDate value='${list.endDate }' pattern='yyyy-MM-dd HH:mm:ss'/>"
								style="color: rgb(153, 153, 153);" readonly="readonly"
								id="endDate" name="endDate">
							</td>
						</tr>

						<!-- 下列数据不可为空 -->
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">报案人姓名：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input class="select_list_inputa"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);" value="请输入报案人姓名"
								id="userName" name="userName">
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">报案人联系电话：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input class="select_list_inputa"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);" value="请输入报案人联系电话" id="phone"
								name="phone">
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">出险时间：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input class="select_list_inputa" value="请输入出险时间"
								name="openDate" id="openDate" style="color: rgb(153, 153, 153);"
								onclick="WdatePicker({maxDate:'%y-%M-%d',isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">估损金额(元)：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input value="请输入估损金额" class="select_list_inputa"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);" id="amount" name="amount">
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">出险地点：</td>
							<td
								style="border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<input value="请输入出险地点" class="select_list_inputa"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: rgb(153, 153, 153);" id="address" name="address">
							</td>
						</tr>
						<tr>
							<td class="table_listb"
								style="border-bottom:#9CF 1px solid;border-top: #9CF 1px solid;border-left: #9CF 1px solid;border-right: #9CF 1px solid;">出险说明：</td>
							<td
								style="border-bottom:#9CF 1px solid;border-top: #9CF 2px solid;border-right: #9CF 1px solid;">
								<textarea cols="90" rows="6" id="yuanyin" name="yuanyin"></textarea>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div id="div_back">
					<td colspan="2" style="text-align:center;"><a class="a_back"
						href="javascript:reported();" style="background:#00a6e3;">报案</a> <a
						href="javascript:history.go(-1);" class="a_back" id="backgo">返回</a>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function reported() {
		var userName = document.getElementById("userName").value; //报案人姓名
		var phone = document.getElementById("phone").value;
		var openDate = document.getElementById("openDate").value;//出险时间
		var amount = document.getElementById("amount").value;//估损金额
		var address = document.getElementById("address").value;//出险地点
		var yuanyin = document.getElementById("yuanyin").value;//出险说明
		var userCode = document.getElementById("insuredCode").value;//被保险人
		var policyNo = document.getElementById("policyNo").value;//保单号
		var sumPerson = document.getElementById("sumPerson").value;//总人数
		var startDate = document.getElementById("startDate").value;
		var endDate = document.getElementById("endDate").value;
		if (userName == null || userName == "" || userName == "请输入报案人姓名") {
			alert("请输入报案人姓名！");
			return;
		}
		if (phone == null || phone == "" || phone == "请输入报案人联系电话" || !/^1[34578]\d{9}$/.test(phone) ) {
			alert("报案人联系电话不正确！");
			return;
		}
		if (openDate == null || openDate == "" || openDate == "请输入出险时间") {
			alert("请输入出险时间！");
			return;
		}
		if (amount == null || amount == "" || amount == "请输入估损金额" || !/^[0-9]+.?[0-9]*$/.test(amount)) {
			alert("估损金额不正确！");
			return;
		}
		if (address == null || address == "" || address == "请输入出险地点") {
			alert("请输入出险地点！");
			return;
		}
		if (yuanyin == null || yuanyin == "") {
			alert("请输入出险说明！");
			return;
		}
		$
				.ajax({
					type : "post",
					url : "/myclaim/myclaimreported",
					data : JSON.stringify({
						"userCode" : userCode,
						"userName" : userName,
						"policyNo" : policyNo,
						"sumPerson" : sumPerson,
						"startDate" : startDate,
						"endDate" : endDate,
						"phone" : phone,
						"openDate" : openDate,
						"amount" : amount,
						"address" : address,
						"yuanyin" : yuanyin
					}),
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						if (data == "succee") {
							alert("申请报案成功！");
							window.location.href = "${basePath}/qiye/myclaim/myclaimCondition.jsp";
							return;
						}
						if (data == "chaochufanwei") {
							alert("出险日期不在赔付范围内！");
							return;
						}
						if(data == "failed") {
							alert("系统繁忙,请稍后重试!");
							return;
						}
						var errorMessage = data;
						
						alert(errorMessage);
					},
					error : function() {
						alert("请稍后重试！");
					}
				});
	}
</script>
</html>