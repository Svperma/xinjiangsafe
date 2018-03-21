<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ page import="com.bocom.api.core.BOCOMSignServer"%>

<%
	request.setCharacterEncoding("utf-8");

	try{
		String merchant_no = request.getParameter("merchant_no");
		String merchant_order_no = request.getParameter("merchant_order_no");
		String order_mode = request.getParameter("order_mode");
		String pay_mode = request.getParameter("pay_mode");
		String order_name = request.getParameter("order_name");
		String order_currency = request.getParameter("order_currency");
		String order_amount = request.getParameter("order_amount");
		String bargainor_comment = request.getParameter("bargainor_comment");
		String purchaser_comment = request.getParameter("purchaser_comment");
		String pay_acc_no = request.getParameter("pay_acc_no");
		String rec_acc_no = request.getParameter("rec_acc_no");
		String rec_bank_type = request.getParameter("rec_bank_type");
		String validate_period = request.getParameter("validate_period");
		String order_comment = request.getParameter("order_comment");
		String erp_serial_no = request.getParameter("erp_serial_no");
		
		StringBuffer  sign = null;
		sign = new StringBuffer("<?xml version=\"1.0\" encoding=\"gb2312\"?><BOCOMB2B>");
		sign.append("<merchant_no>"+merchant_no+"</merchant_no>");
		sign.append("<merchant_order_no>"+merchant_order_no+"</merchant_order_no>");
		sign.append("<order_mode>"+order_mode+"</order_mode>");
		sign.append("<pay_mode>"+pay_mode+"</pay_mode>");
		sign.append("<validate_period>"+validate_period+"</validate_period>");
		sign.append("<order_name>"+order_name+"</order_name>");
		sign.append("<order_currency>"+order_currency+"</order_currency>");
		sign.append("<order_amount>"+order_amount+"</order_amount>");
		sign.append("<order_comment>"+order_comment+"</order_comment>");
		sign.append("<bargainor_comment>"+bargainor_comment+"</bargainor_comment>");
		sign.append("<purchaser_comment>"+purchaser_comment+"</purchaser_comment>");
		sign.append("<pay_acc_no>"+pay_acc_no+"</pay_acc_no>");
		sign.append("<rec_acc_no>"+rec_acc_no+"</rec_acc_no>");
		sign.append("<rec_bank_type>"+rec_bank_type+"</rec_bank_type>");
		sign.append("<erp_serial_no>"+erp_serial_no+"</erp_serial_no>");
		sign.append("</BOCOMB2B>");
		
		System.out.println(sign);
		
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		String reqData = encoder.encode(sign.toString().getBytes());
		reqData = reqData.replaceAll("\r","");
		reqData = reqData.replaceAll("\n","");
		
		BOCOMB2BMiddlemanClient B2BClient = new BOCOMB2BMiddlemanClient();
		boolean ret = B2BClient.initalize("/usr/bocommjava/ini/sell/B2BMerchant.xml");
	
		if (!ret) {
			String errmsg = B2BClient.getLastErr();
			out.println("³õÊ¼»¯Ê§°Ü:");
			out.println(errmsg);
			return;
		}
		
		BOCOMSignServer nss = B2BClient.getSignServer();
		nss.setPlainText(reqData.getBytes("GBK"));
		byte[] signMes = nss.attachedSign();
		String B2BSignData = null;
		B2BSignData = (new String(signMes,"GBK"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script language="javascript">
function subAuthForm(){
	document.payForm.submit();
}
</script>
</head>
<body onLoad = "subAuthForm();">
<form  name ="payForm" method="post" action="https://ebanktest.95559.com/corporbank/B2BOrder" >

<input type="hidden" name="B2BSignData" value="<%=B2BSignData%>"/>
</form>
</body>
</html>
<%
	}catch(Exception ee)
	{
		ee.printStackTrace();
	}
%>