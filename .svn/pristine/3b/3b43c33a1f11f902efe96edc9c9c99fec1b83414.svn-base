<%@page import="org.apache.tools.ant.types.DataType"%>
<%@page import="com.dsib.entity.GpOrderDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%
	/* String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	String businessNo = (String) request.getSession().getAttribute(
			"businessNo");
	String payType = (String)request.getSession().getAttribute("payType");//支付类型 1:投保支付 2:批改支付
	
	String classCode = (String) request.getSession().getAttribute(
			"classCode");
	GpOrderDetail gpOrderDetailDto = (GpOrderDetail) request
			.getSession().getAttribute("gpOrderDetail");
	String orderNo = gpOrderDetailDto.getOrderNo();

	String backUrl = basePath + "/payment/callBack?businessnos="
			+ businessNo + "&orderno=" + orderNo + "&classcode="
			+ classCode + "&dataType=" + payType;

	System.out.println("backurl==>"+backUrl); */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- saved from url=(0014)about:internet -->
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>

<title>易宝支付</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/common/css/Standard.css" rel="stylesheet" type="text/css">
</head>
<!-- gpOrderDetailDto 订单bean -->
<body>
	<div id="input">
		<form method="post" action="${basePath }/payment/B2B/yibao/reqpay.jsp">
			<div>
				<input type="hidden" name="p2_Order" id="p2_Order"
					value="${sessionScope.gpOrderDetail.orderNo }" />
			</div>
			<div>
				<input name="p3_Amt" id="p3_Amt" type="hidden"
					value="${sessionScope.gpOrderDetail.orderAmount }" />
				<!-- <input name="p3_Amt" id="p3_Amt" type="hidden" value="0.01" /> -->

			</div>
			<div>
				<input type="hidden" name="p5_Pid" id="p5_Pid"
					value="anquanshengchanzerenxian" />
			</div>
			<div>
				<input type="hidden" name="p6_Pcat" id="p6_Pcat" value="" />
			</div>
			<div>
				<input type="hidden" name="p7_Pdesc" id="p7_Pdesc"
					value="anquanshengchanzerenxian" />
			</div>
			<div>
				<!-- <input type="hidden" name="p8_Url" id="p8_Url" value="http://www.jiaotongbx.cn/trafficsafety/payment/B2B/yibao/callback.jsp"/> -->
				<input type="hidden" name="p8_Url" id="p8_Url" value="${backUrl }" />
			</div>
			<div>
				<input type="hidden" name="p9_SAF" id="p9_SAF" value="0" />

			</div>
			<div>
				<input type="hidden" name="pa_MP" id="pa_MP"
					value="anquanshengchanzerenxian" />
			</div>
			<div>
				<input type="hidden" name="pd_FrpId" id="pd_FrpId" />
				<!--支付通道编码在易宝支付产品(HTML版)通用接口使用说明中-->
			</div>
		</form>
	</div>
</body>
<script language="javascript">
	window.onload = function() {
		//var url = "https://ebspay.boc.cn/PGWPortal/B2BRecvOrder.do";
		//window.open(url, "", "height=600,width=800,status=yes,toolbar=no,menubar=no,location=no,left=80");
		/* document.forms[0].target = "_self";
		document.forms[0].submit(); */
// 		var url = "${basePath }/payment/B2B/yibao/reqpay.jsp";
		var form = document.forms[0];
		form.action = "${basePath }/payment/B2B/yibao/reqpay.jsp";
		form.target = "_self";
		form.submit();
	}
</script>
</html>

