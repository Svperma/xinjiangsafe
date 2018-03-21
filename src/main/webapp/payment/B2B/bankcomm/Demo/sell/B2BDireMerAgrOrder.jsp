<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GB18030"%>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ page import="com.bocom.api.core.*"%>
<%@ page import="com.bocom.api.b2b.order.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%
			String merchant_no 		=  request.getParameter("merchant_no");  //商户编号
			
			String merchant_order_no 	= request.getParameter("merchant_order_no"); //商户检索号
			
			String order_mode 		= request.getParameter("order_mode"); //订单模式
			
			String sub_agreement_no = request.getParameter("sub_agreement_no"); //子协议号
			
			String purchaser_ebank_no			= request.getParameter("purchaser_ebank_no"); //买方网银客户号
			
			String pay_acc_no 		= request.getParameter("pay_acc_no"); //付款账号
			
			String bargainor_ebank_no			= request.getParameter("bargainor_ebank_no"); //卖方网银客户号
			
			String rec_acc_no 		= request.getParameter("rec_acc_no"); //收款账号
			
			String rec_bank_type = request.getParameter("recAccType"); //收款账户类型
			
			String validate_period			= request.getParameter("validate_period"); //订单有效天数
			
			String order_currency 		= request.getParameter("order_currency");//订单币种
			
			String order_amount 		= request.getParameter("order_amount");//订单金额
		
			String order_comment 		= request.getParameter("order_comment");//订单备注
			
			String bargainor_comment 		= request.getParameter("bargainor_comment");//卖方备注
			
			String purchaser_comment 		= request.getParameter("purchaser_comment");//买方备注
			
			String order_name 		= request.getParameter("order_name"); //订单名称
								
		  	String erp_serial_no 		= request.getParameter("erp_serial_no"); //ERP编号
		  	String configFile = request.getParameter("configFile");
		  	String configFileRealPath = request.getRealPath(configFile);
						

			B2BDireMerAgrOrder order = new B2BDireMerAgrOrder();

			order.setElement("merchant_no", merchant_no);
			order.setElement("merchant_order_no", merchant_order_no);
			order.setElement("order_mode", order_mode);
			order.setElement("sub_agreement_no",sub_agreement_no);
			order.setElement("purchaser_ebank_no", purchaser_ebank_no);
			order.setElement("bargainor_ebank_no", bargainor_ebank_no);
			order.setElement("validate_period", validate_period);
			order.setElement("order_name", order_name);
			order.setElement("order_currency", order_currency);
			order.setElement("order_amount", order_amount);
			order.setElement("order_comment", order_comment);			
			order.setElement("bargainor_comment", bargainor_comment);			
			order.setElement("purchaser_comment", purchaser_comment);			
			order.setElement("pay_acc_no", pay_acc_no);			
			order.setElement("rec_acc_no", rec_acc_no);
			order.setElement("rec_bank_type", rec_bank_type);
			order.setElement("erp_serial_no", erp_serial_no);
			
			BOCOMB2BSellerClient B2BClient = new BOCOMB2BSellerClient();
			boolean ret = B2BClient.initalize(configFileRealPath);

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
						String order_status = result
								.getValueByName("order_status");
						String tr_acdt = result.getValueByName("tr_acdt");
						String tr_time = result.getValueByName("tr_time");

						merchant_no = result
								.getValueByName("merchant_no");
						merchant_order_no = result
								.getValueByName("merchant_order_no");
						order_currency = result
								.getValueByName("order_currency");
						order_amount = result
								.getValueByName("order_amount");
						String serial_no = result.getValueByName("serial_no");
						pay_acc_no = result.getValueByName("pay_acc_no");
						rec_acc_no = result.getValueByName("rec_acc_no");
						String tran_currency = result
								.getValueByName("tran_currency");

						String tran_amount = result
								.getValueByName("tran_amount");
						String fee_amount = result.getValueByName("pay_acc_no");
						String pay_sum = result.getValueByName("pay_sum");
						String tran_status = result
								.getValueByName("tran_status");

						String faild_reason = result
								.getValueByName("faild_reason");

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

						out.println("付款流水号:");
						out.println(serial_no);
						out.println("<BR />");

						out.println("付款帐号:");
						out.println(pay_acc_no);
						out.println("<BR />");

						out.println("收款帐号:");
						out.println(rec_acc_no);
						out.println("<BR />");

						out.println("划款币种:");
						out.println(tran_currency);
						out.println("<BR />");

						out.println("划款金额:");
						out.println(tran_amount);
						out.println("<BR />");

						out.println("手续费金额:");
						out.println(fee_amount);
						out.println("<BR />");

						out.println("已划款总金额:");
						out.println(pay_sum);
						out.println("<BR />");

						out.println("付款流水状态:");
						out.println(tran_status);
						out.println("<BR />");

						out.println("失败原因:");
						out.println(faild_reason);
						out.println("<BR />");

					}
				}
			}
		%>
</body>
</html>




