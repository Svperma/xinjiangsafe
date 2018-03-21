<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ page import="com.bocom.api.b2b.order.*"%>
<%@ page import="com.bocom.api.core.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>直接商户--授权支付--订单生成</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String merchantNo = request.getParameter("merchantNo");
	//商户编号
	String merchantOrderNo = request.getParameter("merchantOrderNo");
	//商户检索号
	String purchaserBankNo = request.getParameter("purchaserBankNo");
	//买方网银客户号
	String payAccNo = request.getParameter("payAccNo");
	//付款账号
	String recAccNo = request.getParameter("recAccNo");
	//收款账号
	String recAccType = request.getParameter("recAccType");
	//收款帐户类型
	String validatePeriod = request.getParameter("validatePeriod");
	//订单有效天数
	String orderCurrency = request.getParameter("orderCurrency");
	//订单币种
	String orderAmount = request.getParameter("orderAmount");
	//订单金额
	String bargainorComment = request.getParameter("bargainorComment");
	//卖方备注
	String purchaserComment = request.getParameter("purchaserComment");
	//买方备注：</td>
	String orderName = request.getParameter("orderName");
	//订单名称 orderName
	String erpSerialNo = request.getParameter("erpSerialNo");
	//ERP编号
	String orderComment = request.getParameter("orderComment");
	//订单备注
	
	B2BDireMerOrder order = new B2BDireMerOrder();
	order.setMerchantNo(merchantNo);
	order.setMerchantOrderNo(merchantOrderNo);
	order.setPayAccNo(payAccNo);
	order.setRecAccNo(recAccNo);
	order.setRecAccType(recAccType);
	order.setValidatePeriod(validatePeriod);
	order.setOrderAmount(orderAmount);
	order.setOrderCurrency(orderCurrency);
	order.setBargainorComment(bargainorComment);
	order.setPurchaserComment(purchaserComment);
	order.setOrderName(orderName);
	order.setPurchaserBankNo(purchaserBankNo);
	order.setERPNo(erpSerialNo);
	order.setOrderComment(orderComment);
	

	BOCOMB2BMiddlemanClient B2BClient = new BOCOMB2BMiddlemanClient();
	boolean ret = B2BClient.initalize("G:\\ds_new\\modules\\webapps\\trafficsafety\\payment\\B2B\\bankcomm\\ini\\B2BMerchantForBankcomm.xml");

	if (!ret) {
		String errmsg = B2BClient.getLastErr();
		out.println("初始化失败:");
		out.println(errmsg);
	} else {

		BOCOMOPReply result = B2BClient.createOrder(order);

		if (result == null) {
			String errmsg = B2BClient.getLastErr();
			out.println("交易错误信息:");
			out.println(errmsg);
		} else {
			String code = result.getRetCode();
			String msg = result.getErrorMessage();
			out.println("交易返回码：" + code + "<BR />");
			out.println("交易错误信息：" + msg + "<BR />");
			out.println("----------------------------");
			out.println("<BR />");

			if ("0000".equals(code)) {
				String order_no = result.getValueByName("order_no");
				String order_status = result.getValueByName("order_status");
				String tr_acdt = result.getValueByName("tr_acdt");
				String tr_time = result.getValueByName("tr_time");
				String merchant_no = result.getValueByName("merchant_no");
				String merchant_order_no = result.getValueByName("merchant_order_no");
				String order_currency = result.getValueByName("order_currency");
				String order_amount = result.getValueByName("order_amount");
				
				//String serial_no = result.getValueByName("serial_no");
				//String pay_acc_no = result.getValueByName("pay_acc_no");
				//String rec_acc_no = result.getValueByName("rec_acc_no");
				//String tran_currency = result.getValueByName("tran_currency");
				//String tran_amount = result.getValueByName("tran_amount");
				//String fee_amount = result.getValueByName("fee_amount");
				//String pay_sum = result.getValueByName("pay_sum");
				//String tran_status = result.getValueByName("tran_status");
				//String faild_reason = result.getValueByName("faild_reason");

				out.println("订单号:");
				out.println(order_no);
				out.println("<BR />");

				out.println("订单状态:");
				out.println(order_status);
				out.println("<BR />");

				out.println("处理日期:");
				out.println(tr_acdt);
				out.println("<BR />");

				out.println("处理时间:");
				out.println(tr_time);
				out.println("<BR />");

				out.println("商户编号:");
				out.println(merchant_no);
				out.println("<BR />");

				out.println("商户检索号:");
				out.println(merchant_order_no);
				out.println("<BR />");

				out.println("订单币种:");
				out.println(order_currency);
				out.println("<BR />");

				out.println("订单金额:");
				out.println(order_amount);
				out.println("<BR />");
			}
		}
	}
%>

</body>
</html>
