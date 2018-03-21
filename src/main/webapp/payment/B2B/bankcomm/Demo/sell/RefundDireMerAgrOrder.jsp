<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ page import="com.bocom.api.core.*"%>
<%@ include file="../conf/configration.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>直接商户---协议支付退款</title>
</head>

<body>
<%

	String merchant_no = request.getParameter("merchant_no");  //商户编号
	String order_no = request.getParameter("order_no"); //原订单号
	String order_mode = request.getParameter("order_mode"); //原订单模式
	String pay_acc_no = request.getParameter("pay_acc_no"); //退款付款账号
	String rec_acc_no = request.getParameter("rec_acc_no"); //退款收款账号
	String tran_currency = request.getParameter("tran_currency"); //退款币种
	String tran_amt = request.getParameter("tran_amt"); //退款金额
	String remark = request.getParameter("remark"); //退款备注 
	String erp_serial_no = request.getParameter("erp_serial_no"); //ERP编号 


	BOCOMB2BSellerClient B2BClient = new BOCOMB2BSellerClient();

	//boolean ret = B2BClient.initalize("/bocommjava/ini/sell/B2BMerchant.xml");
	boolean ret = B2BClient.initalize(SELL_CONF_BASE);

	if	(!ret)	{ 
	String errmsg = B2BClient.getLastErr();
	out.println("初始化失败:");
	out.println(errmsg);
	}else{

		BOCOMOPReply result  =B2BClient.inputRefundFlw(merchant_no,order_no,order_mode,pay_acc_no,rec_acc_no,tran_currency,tran_amt,remark, erp_serial_no );
	if (result ==null ){
		String  errmsg = B2BClient.getLastErr();
		out.println("交易错误信息:");
		out.println(errmsg);
	}else{
		String code = result.getRetCode();
		String msg  = result.getErrorMessage();
		out.println("----------------------------");
		out.println("<BR />");
		out.println("交易返回码:"+code);
		out.println("<BR />");
		out.println("交易错误信息:"+msg);
		out.println("<BR />");
		out.println("----------------------------");
		out.println("<BR />");
		if ("0000".equals(code)){ 
			int num = result.getOpResultSize();
			String total_num  = result.getResponseHead("total_num");
			out.println("总纪录数:" + total_num+"<BR />");
			out.println("返回纪录数：" + num);
			out.println("<BR />");
			out.println("----------------------------");
			out.println("<BR />");
			
			for (int index = 0 ; index<num ; index++){
			
			String serial_no  =	 result.getValueByName(index,"serial_no");
			 order_no	  =	 result.getValueByName(index,"order_no");
			String tran_datetime  =	 result.getValueByName(index,"tran_datetime");
			String tran_type  =	 result.getValueByName(index,"tran_type");	
			pay_acc_no  =	 result.getValueByName(index,"pay_acc_no");	
			 rec_acc_no  =	 result.getValueByName(index,"rec_acc_no");	
			String tran_amount    =	 result.getValueByName(index,"tran_amount");	
			String tran_status  =	 result.getValueByName(index,"tran_status");	
			String comment   =	 result.getValueByName(index,"comment");
			String erpno	  =	 result.getValueByName(index,"ERP_serial_no");
			String faild	  =  result.getValueByName(index,"faild_reason");
			
			out.println("<BR />");
			
			out.println("交易流水号");
			out.println(serial_no);
			out.println("<BR />");
			
			out.println("订单号");
			out.println(order_no);
			out.println("<BR />");
			
			out.println("交易时间");
			out.println(tran_datetime);
			out.println("<BR />");
			
			out.println("交易类型");
			out.println(tran_type);
			out.println("<BR />");
			
			out.println("付款账号");
			out.println(pay_acc_no);
			out.println("<BR />");
			
			out.println("收款账号");
			out.println(rec_acc_no);
			out.println("<BR />");
			
			out.println("交易金额");
			out.println(tran_amount);
			out.println("<BR />");
			
			out.println("交易状态");
			out.println(tran_status );
			out.println("<BR />");
			
			out.println("摘要");
			out.println(comment);
			out.println("<BR />");
			
			out.println("ERP编号");
			out.println(erpno);
			out.println("<BR />");
			
			out.println("失败原因");
			out.println(faild);
			out.println("<BR />");
			
			out.println("<BR />");
			out.println("----------------------------");
			out.println("<BR />");
			}
		}
	}
}
%>
</body>
</html>
