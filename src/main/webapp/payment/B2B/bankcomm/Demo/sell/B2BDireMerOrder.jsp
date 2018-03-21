<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ page import="com.bocom.api.b2b.order.*"%>
<%@ page import="com.bocom.api.core.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>ֱ���̻�--��Ȩ֧��--��������</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String merchantNo = request.getParameter("merchantNo");
	//�̻����
	String merchantOrderNo = request.getParameter("merchantOrderNo");
	//�̻�������
	String purchaserBankNo = request.getParameter("purchaserBankNo");
	//�������ͻ���
	String payAccNo = request.getParameter("payAccNo");
	//�����˺�
	String recAccNo = request.getParameter("recAccNo");
	//�տ��˺�
	String recAccType = request.getParameter("recAccType");
	//�տ��ʻ�����
	String validatePeriod = request.getParameter("validatePeriod");
	//������Ч����
	String orderCurrency = request.getParameter("orderCurrency");
	//��������
	String orderAmount = request.getParameter("orderAmount");
	//�������
	String bargainorComment = request.getParameter("bargainorComment");
	//������ע
	String purchaserComment = request.getParameter("purchaserComment");
	//�򷽱�ע��</td>
	String orderName = request.getParameter("orderName");
	//�������� orderName
	String erpSerialNo = request.getParameter("erpSerialNo");
	//ERP���
	String orderComment = request.getParameter("orderComment");
	//������ע
	
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
			}
		}
	}
%>

</body>
</html>
