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
			String merchant_no 		=  request.getParameter("merchant_no");  //�̻����
			
			String merchant_order_no 	= request.getParameter("merchant_order_no"); //�̻�������
			
			String order_mode 		= request.getParameter("order_mode"); //����ģʽ
			
			String sub_agreement_no = request.getParameter("sub_agreement_no"); //��Э���
			
			String purchaser_ebank_no			= request.getParameter("purchaser_ebank_no"); //�������ͻ���
			
			String pay_acc_no 		= request.getParameter("pay_acc_no"); //�����˺�
			
			String bargainor_ebank_no			= request.getParameter("bargainor_ebank_no"); //���������ͻ���
			
			String rec_acc_no 		= request.getParameter("rec_acc_no"); //�տ��˺�
			
			String rec_bank_type = request.getParameter("recAccType"); //�տ��˻�����
			
			String validate_period			= request.getParameter("validate_period"); //������Ч����
			
			String order_currency 		= request.getParameter("order_currency");//��������
			
			String order_amount 		= request.getParameter("order_amount");//�������
		
			String order_comment 		= request.getParameter("order_comment");//������ע
			
			String bargainor_comment 		= request.getParameter("bargainor_comment");//������ע
			
			String purchaser_comment 		= request.getParameter("purchaser_comment");//�򷽱�ע
			
			String order_name 		= request.getParameter("order_name"); //��������
								
		  	String erp_serial_no 		= request.getParameter("erp_serial_no"); //ERP���
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
				out.println("��ʼ��ʧ��:");
				out.println(errmsg);
			} else {

				BOCOMOPReply result = B2BClient.createOrder(order);

				if (result == null) {
					String errmsg = B2BClient.getLastErr();
					out.println("���״�����Ϣ:");
					out.println(errmsg);
				} else {
					String code = result.getRetCode();
					String msg = result.getErrorMessage();
					out.println("���׷����룺" + code + "<BR />");
					out.println("���״�����Ϣ��" + msg + "<BR />");
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

						out.println("������:");
						out.println(order_no);
						out.println("<BR />");

						out.println("����״̬:");
						out.println(order_status);
						out.println("<BR />");

						out.println("��������:");
						out.println(tr_acdt);
						out.println("<BR />");

						out.println("����ʱ��:");
						out.println(tr_time);
						out.println("<BR />");

						out.println("�̻����:");
						out.println(merchant_no);
						out.println("<BR />");

						out.println("�̻�������:");
						out.println(merchant_order_no);
						out.println("<BR />");

						out.println("��������:");
						out.println(order_currency);
						out.println("<BR />");

						out.println("�������:");
						out.println(order_amount);
						out.println("<BR />");

						out.println("������ˮ��:");
						out.println(serial_no);
						out.println("<BR />");

						out.println("�����ʺ�:");
						out.println(pay_acc_no);
						out.println("<BR />");

						out.println("�տ��ʺ�:");
						out.println(rec_acc_no);
						out.println("<BR />");

						out.println("�������:");
						out.println(tran_currency);
						out.println("<BR />");

						out.println("������:");
						out.println(tran_amount);
						out.println("<BR />");

						out.println("�����ѽ��:");
						out.println(fee_amount);
						out.println("<BR />");

						out.println("�ѻ����ܽ��:");
						out.println(pay_sum);
						out.println("<BR />");

						out.println("������ˮ״̬:");
						out.println(tran_status);
						out.println("<BR />");

						out.println("ʧ��ԭ��:");
						out.println(faild_reason);
						out.println("<BR />");

					}
				}
			}
		%>
</body>
</html>




