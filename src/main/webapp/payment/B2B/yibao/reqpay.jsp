<%@page language="java" contentType="text/html;charset=gbk"%>
<%@page import="com.yeepay.*"%>
<%!String formatString(String text) {
		if (text == null) {
			return "";
		}
		return text;
	}%>
<%
	/* request.setCharacterEncoding("GBK");
	String keyValue = formatString(Configuration.getInstance().getValue("keyValue")); // 商家密钥
	String nodeAuthorizationURL = formatString(Configuration.getInstance().getValue("yeepayCommonReqURL")); // 交易请求地址
			System.out.print("请求易宝地址："+nodeAuthorizationURL);
	// 商家设置用户购买商品的支付信息
	String p0_Cmd = formatString("Buy"); // 在线支付请求，固定值 ”Buy”
	String p1_MerId = formatString(Configuration.getInstance().getValue("p1_MerId")); // 商户编号
	String p2_Order = formatString(request.getParameter("p2_Order")); // 商户订单号
	String p3_Amt = formatString(request.getParameter("p3_Amt")); // 支付金额
	String p4_Cur = formatString("CNY"); // 交易币种
	String p5_Pid = formatString(request.getParameter("p5_Pid")); // 商品名称
	String p6_Pcat = formatString(request.getParameter("p6_Pcat")); // 商品种类
	String p7_Pdesc = formatString(request.getParameter("p7_Pdesc")); // 商品描述
	String p8_Url = formatString(request.getParameter("p8_Url")); // 商户接收支付成功数据的地址
	String p9_SAF = formatString(request.getParameter("p9_SAF")); // 需要填写送货信息 0：不需要  1:需要
	String pa_MP = formatString(request.getParameter("pa_MP")); // 商户扩展信息
	String pd_FrpId = formatString(request.getParameter("pd_FrpId")); // 支付通道编码
	// 银行编号必须大写
	pd_FrpId = pd_FrpId.toUpperCase();
	String pr_NeedResponse = formatString("1"); // 默认为"1"，需要应答机制
	String hmac = formatString(""); // 交易签名串

	// 获得MD5-HMAC签名
	hmac = PaymentForOnlineService.getReqMd5HmacForOnlinePayment(
			p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid,
			p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId,
			pr_NeedResponse, keyValue); */
%>
<!-- saved from url=(0014)about:internet -->
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>跳转中...</title>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
</head>
<body style="height: 600px;">
	<form name="yeepay" action='${nodeAuthorizationURL}' method='POST' id="yeepay"
		target="_blank">
		<input type='hidden' name='p0_Cmd' value='${p0_Cmd}'> <input
			type='hidden' name='p1_MerId' value='${p1_MerId}'> <input
			type='hidden' name='p2_Order' value='${p2_Order}'> <input
			type='hidden' name='p3_Amt' value='${p3_Amt}'> <input
			type='hidden' name='p4_Cur' value='${p4_Cur}'> <input
			type='hidden' name='p5_Pid' value='${p5_Pid}'> <input
			type='hidden' name='p6_Pcat' value='${p6_Pcat}'> <input
			type='hidden' name='p7_Pdesc' value='${p7_Pdesc}'> <input
			type='hidden' name='p8_Url' value='${p8_Url}'> <input
			type='hidden' name='p9_SAF' value='${p9_SAF}'> <input
			type='hidden' name='pa_MP' value='${pa_MP}'> <input
			type='hidden' name='pd_FrpId' value='${pd_FrpId}'> <input
			type="hidden" name="pr_NeedResponse" value="${pr_NeedResponse}">
		<input type='hidden' name='hmac' value='${hmac}'>
		<!-- <table cellpadding="3" cellspacing="1" class="common" style="width:90%;font-size:14px;" align="center">
				<tr>
					<td sytle="text-align:center;">正在跳转至易宝支付界面...请稍后</td>
				</tr>
			</table> -->

	</form>
</body>
<script type="text/javascript">
	window.onload = function() {
		
// 		document.forms[0].target = "_blank";
// 		document.forms[0].submit();

		var form = document.forms[0];
		form.action = "${nodeAuthorizationURL}";
		form.target = "_self";
// 		form.target = "_blank";
		form.submit();
		
		showUpperView("${basePath}/payment/dialog.jsp", 400, 250);
	}
</script>
</html>
