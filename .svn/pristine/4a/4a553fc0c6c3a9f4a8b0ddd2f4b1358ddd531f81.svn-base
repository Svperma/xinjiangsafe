<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${basePath }/payment/css/bootstrap.css" rel="stylesheet">
<link href="${basePath }/payment/css/font-awesome.css" rel="stylesheet">
<link href="${basePath }/payment/css/style.css" rel="stylesheet">
<link href="${basePath }/payment/css/style1.css" rel="stylesheet">


</head>
<body>
<!-- 	<div style="width:100%; height:auto; float:left;"> -->
		<div style="width:1320px; margin-left:30px; margin-top:20px;">
			<div class="panel panel-default">
				<div class="panel-heading">缴费</div>

				<div class="panel-body"
					style="margin:10px auto; text-align:center; line-height:70px;">
					<%-- <form action="" method="post" name="fm1">
                        <a style="float:left; color:#000; font-size:20px; font-weight:bold; margin-left:20px;">网银支付</a><br />
                        <c:forEach var="b2b" items="${sessionScope.B2BList }" varStatus="st">
                        	<a href="#" class="bank_icon"><img width="148" height="48" src="..${b2b.paymentLogo }" /></a>
                        	<input name="businessNos" type="hidden"  value='<%=request.getAttribute("bussinessNos")%>'>
							<input name="orderNO" type="hidden"  value='${sessionScope.orderNo }'>
							<input name="ggPaymentConfigBussnissType" type="hidden"  value='${b2b.businessType }'>
							<input name="ggPaymentConfigPaymentCardType" type="hidden"  value='${b2b.paymentCardType }'>
							<input name="ggPaymentConfigPaymentCode" type="hidden"  value='${b2b.paymentCode }'>
							<input name="ggPaymentConfigConifgFile" type="hidden"  value='${b2b.conifgFile }'>
							<input name="ggPaymentConfigMerchantNo" type="hidden"  value='${b2b.merchantNo }'>
							<input name="ggPaymentConfigAcc_no" type="hidden"  value='${b2b.acc_no }'>
							<input name="ggPaymentConfigUserName" type="hidden"  value='${b2b.userName }'>
                        </c:forEach>
                    </div>
                    </form> --%>
					<form action="" method="post" name="fm2">
						<div class="panel-body"
							style="margin:10px auto; text-align:center; line-height:70px;">
							<a 
								style="float:left; color:#000; font-size:20px; font-weight:bold; margin-left:20px;">在线支付</a><br />
							<input type="hidden" name="classCode"
								value="${sessionScope.classCode }">
							<c:forEach var="third" items="${sessionScope.resultList }"
								varStatus="st">
								<%-- <a href="javascript:generatePay(${st.index });"
									class="bank_icon"><img width="148" height="48"
									src="..${third.paymentLogo }" /></a> --%>
									<a href="javascript:void(0);" onclick="javascript:generatePay(${st.index });"
									class="bank_icon"><img width="148" height="48"
									src="..${third.paymentLogo }" /></a>
									
								<input name="order_amount" type="hidden"
									value='<fmt:formatNumber>${sessionScope.gpOrderDetail.orderAmount }</fmt:formatNumber> ' />
								<input name="thirdBusinessNos" type="hidden"
									value='${sessionScope.businessNo }'>
								<input name="thirdBussnissType" type="hidden"
									value='${third.businessType }'>
								<input name="thirdPaymentCardType" type="hidden"
									value='${third.paymentCardType }'>
								<input name="thirdPaymentCode" type="hidden"
									value='${third.paymentCode }'>
								<input name="thirdConifgFile" type="hidden"
									value='${third.configFile }'>
								<input name="thirdMerchantNo" type="hidden"
									value='${third.merchantNo }'>
								<input name="thirdAcc_no" type="hidden" value='${third.acc_no }'>
								<input name="thirdUserName" type="hidden"
									value='${third.userName }'>
							</c:forEach>
						</div>
						<div style="text-align:left; line-height:0px;margin-left: 3%;margin-top: -1%;color: red;">
						提示：在线支付如果不显示缴费页面，请把浏览器的拦截关闭或允许。
						</div>
					</form>
					<div class="panel-body" style="margin:10px auto; text-align:center; line-height:70px;">
                    	<a style="float:left; color:#000; font-size:20px; font-weight:bold; margin-left:20px;">银行汇款</a><br />
                        <a style="float:left; color:#000; font-size:18px; margin-left:20px;">如您没有网银或其他支付账号，您可以通过以下银行帐号进行转帐。</a><br />
                        <table style="margin-left:20px; text-align:left;">
                        	<tr>
                        		<td>银行</td>
                            	<td>银行帐号</td>
                                <td>开户行全称</td>
                                <td>行号</td>
                                <td>账户名</td>
                            </tr>
                            <tr>
                            	<td style="font-weight: bold;">中国农业银行</td>
                            	<td>30004401040009751</td>
                                <td>中国农业银行乌鲁木齐友好路支行</td>
                                <td>103881000445</td>
                                <td>德圣保险经纪有限公司新疆分公司</td>
                            </tr>
                            <tr>
                            	<td style="font-weight: bold;">中国工商银行</td>
                            	<td>3002023119024509986</td>
                                <td>中国工商银行乌鲁木齐市克拉玛依东路支行</td>
                                <td>102881002311</td>
                                <td>德圣保险经纪有限公司新疆分公司</td>
                            </tr>
                            <tr>
                            <c:forEach items="${sessionScope.resultList }" var = "downPay">
                            	<td style="border-bottom: none;background-color: white;" colspan="5">
	                            	<h5 style="font-weight: bold;color: red;">重要提示：</h5>
	                            	<span style="color: red;">请务必将您的公司名称</span>
	                            	<font style="color: #00a6e3;font-weight: bold;">${sessionScope.ggUser.userName }</font>
	                            	<span style="color: red;">填写到汇款单的附言栏，我们将依此对汇款进行核对。</span>
                            	</td>
                            </c:forEach>
                            </tr>
                            
                            <%-- <tr>
                            	<td colspan="3">
                            		<a href="javascript:help();"  style="width:100px; margin:30px auto; font-size:14px;">汇款帮助</a> 
                            		<!-- <input type="button" onclick="help()" class="button" value="汇款帮助" /> -->
                            	</td>
                            </tr> --%>
                        </table>
                        	
                    </div>
<!-- 					<a href="javascript:history.go(-1);" -->
<!-- 						class="btn btn-block btn-lg btn-Info" -->
<!-- 						style="width:100px; margin:30px auto; font-size:14px;">返 回</a> -->
				</div>

			</div>
		</div>
<!-- 	</div> -->
</body>
<script type="text/javascript">
	function generatePay(index) {
		/* document.fm2.action = "${basePath}/payment/YBPay";
		document.fm2.submit(); */
		var tempwindow=window.open();
		tempwindow.location="${basePath}/payment/YBPay";
		tempwindow.submit();
		window.location.href = "${basePath}/qiye/mypolicy/mypolicyCondition.jsp";

	}
	function help() {
		window.open(
			"/order/payhelp.html","",
			"height=500px, width=450px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
	}
</script>
</html>