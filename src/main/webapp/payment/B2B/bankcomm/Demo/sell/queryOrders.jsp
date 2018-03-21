<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="com.bocom.api.core.*"%>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ include file="../conf/configration.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>����������ѯ</title>
</head>
<body>
<%
			String startDate;
			String endDate;
			String orderStatus;
			String payAcc;
			String recAcc;
			String orderMode;
			String merchantNo;
			String payRate;
			String refOrder;
			String pageNo;

			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			orderStatus = request.getParameter("orderStatus");
			payAcc = request.getParameter("payAcc");
			recAcc = request.getParameter("recAcc");
			orderMode = request.getParameter("orderMode");
			merchantNo = request.getParameter("merchantNo");
			payRate = request.getParameter("payRate");
			refOrder = request.getParameter("refOrder");
			pageNo	 = request.getParameter("pageNo");
			BOCOMB2BSellerClient B2BClient = new BOCOMB2BSellerClient();
			//boolean ret = B2BClient.initalize("/bocommjava/ini/sell/B2BMerchant.xml");
			boolean ret = B2BClient.initalize(SELL_CONF_BASE);

			if (!ret) {
				String errmsg = B2BClient.getLastErr();
				out.println("��ʼ��ʧ��:");
				out.println(errmsg);

			} else {
				BOCOMOPReply result = B2BClient.queryOrders(startDate, endDate,
						orderStatus, payAcc, recAcc, orderMode, merchantNo, payRate,
						refOrder,pageNo);

				if (result == null) {
					String errmsg = B2BClient.getLastErr();
					out.println("���״�����Ϣ:");
					out.println(errmsg);
				} else {
					String code = result.getRetCode();
					String msg = result.getErrorMessage();
					out.println("----------------------------");
					out.println("<BR />");
					out.println("���׷����룺" + code + "<BR />");
					out.println("���״�����Ϣ��" + msg + "<BR />");
					out.println("----------------------------");
					out.println("<BR />");
					if ("0000".equals(code)) {
						int num = result.getOpResultSize(); //�õ����ؼ�¼����
						String total_num  = result.getResponseHead("total_num");
						out.println("�ܼ�¼��:" + total_num+"<BR />");
						out.println("���ؼ�¼����" + num + "<BR />");
						out.println("----------------------------");
						out.println("<BR />");

						for (int index = 0; index < num ; index++) {
							String order_no = result.getValueByName(index,
									"order_no"); //������
							String ref_order_no = result.getValueByName(
									index, "ref_order_no"); //����������
							String merchant_no = result.getValueByName(
									index, "merchant_no"); //�̻����
							String mer_order_no = result.getValueByName(
									index, "merchant_order_no");//�̻�������
							String order_amount = result.getValueByName(
									index, "order_amount"); //�������
							String pay_mode = result.getValueByName(index,
									"pay_mode"); //����ģʽ
							String agreement_no = result.getValueByName(
									index, "agreement_no"); //��Э���
							String sub_atreement_no = result.getValueByName(
									index, "sub_agreement_no"); //��Э���
							String order_mode = result.getValueByName(index,
									"order_mode_name"); //����ģʽ����
							String order_status = result.getValueByName(
									index, "order_status"); //����״̬
							String ele_code = result.getValueByName(index,
									"electronic_code"); //���ӻص�Ч����	
							String contrace_no = result.getValueByName(
									index, "contract_no"); //��ͬ���
							String contrace_name = result.getValueByName(
									index, "contract_name"); //��ͬ����
							String invoice_no = result.getValueByName(index,
									"invoice_no"); //��Ʊ���
							String trade_content = result.getValueByName(
									index, "trade_content"); //��������
							String cont_content = result.getValueByName(
									index, "contract_content"); //��ͬ����
							String trade_rule = result.getValueByName(index,
									"trade_rule"); //���׹���
							String shipment_date = result.getValueByName(
									index, "shipment_date"); //��������
							String check_criterion = result.getValueByName(
									index, "check_criterion"); //�����׼
							String esatab_from = result.getValueByName(
									index, "establish_from"); //�������ɷ�ʽ
							String esatab_date = result.getValueByName(
									index, "establish_date"); //������������
							String esatab_time = result.getValueByName(
									index, "establish_time"); //��������ʱ��
							String validate_period = result.getValueByName(
									index, "validate_period"); //�����Զ��ر���Ч��
							String close_date = result.getValueByName(index,
									"close_date"); //�����ر�����
							String close_time = result.getValueByName(index,
									"close_time"); //�����ر�ʱ��
							String close_reason = result.getValueByName(
									index, "close_reason"); //�����ر�ԭ��
							String buyer_name = result.getValueByName(index,
									"purchaser_name"); //�����ҵ����
							String buyer_cust_no = result.getValueByName(
									index, "purchaser_ebank_no");//��������ͻ���
							String buyer_bran_name = result.getValueByName(
									index, "purchaser_branch_name");//���������������
							String buyer_no = result.getValueByName(index,
									"purchaser_no"); //��һ�Ա��
							String buyer_address = result.getValueByName(
									index, "purchaser_address");//�����ҵ���ڵ�ַ
							String buyer_comment = result.getValueByName(
									index, "purchaser_comment");//��ұ�ע
							String pay_acc_no = result.getValueByName(index,
									"pay_acc_no"); //�����˺�
							String pay_acc_cur = result.getValueByName(
									index, "pay_acc_currency"); //�����˺ű���
							String pay_acc_name = result.getValueByName(
									index, "pay_acc_name"); //�����˺Ż���
							String seller_name = result.getValueByName(
									index, "bargainor_name"); //������ҵ����
							String seller_ebank_no = result.getValueByName(
									index, "bargainor_ebank_no");//���������ͻ���
							String seller_bran_name = result.getValueByName(
									index, "bargainor_branch_name");//����������������
							String seller_address = result.getValueByName(
									index, "bargainor_address"); //������ҵ���ڵ�                                                                                                                  
							String seller_comment = result.getValueByName(
									index, "bargainor_comment");//���ұ�ע                                                                                                                          
							String rec_acc_no = result.getValueByName(index,
									"rec_acc_no"); //�տ��˺�                                                                                                                     
							String rec_acc_cur = result.getValueByName(index,
									"rec_acc_currency"); //�տ��˺ű���                                                                                                         
							String rec_acc_name = result.getValueByName(index,
									"rec_acc_name"); //�տ��˺Ż���                                                                                                         
							String rec_bank_type = result.getValueByName(
									index, "rec_bank_type"); //�տ���������                                                                                                                         
							String rec_bank_name = result.getValueByName(
									index, "rec_bank_name"); //�տ�����ȫ��                                                                                                         
							String nike_name = result.getValueByName(index,
									"merchant_shortname");//�̻����                                                                                                                        
							String pay_sum = result.getValueByName(index,
									"pay_sum"); //�Ѹ�����                                                                                                   
							String pay_reate = result.getValueByName(index,
									"pay_rate"); //�Ѹ��������                                                                                               
							String fee_pay_sum = result.getValueByName(index,
									"fee_pay_sum"); //�����ۼ�������                                                                                                       
							String bail_balance = result.getValueByName(
									index, "bail_balance"); //��֤�����                                                                                                                   
							String bail_pay_sum = result.getValueByName(index,
									"bail_pay_sum"); //��֤�𽻸��ܶ�                                                                                                       
							String bail_pay_reate = result.getValueByName(
									index, "bail_pay_rate"); //��֤�𽻸����                                                                                                       
							String bail_return_sum = result.getValueByName(
									index, "bail_return_sum"); //��֤���˿��ܶ�                                                                                                               
							String bail_return_rate = result.getValueByName(
									index, "bail_return_rate"); //��֤���˿����                                                                                                               
							String bail_pay_times = result.getValueByName(
									index, "bail_pay_times"); //��֤�𽻸����                                                                                                               
							String bail_fee = result.getValueByName(index,
									"bail_fee_pay_sum"); //��֤�𽻸���������                                                                                                       
							String bankComment = result.getValueByName(
									index, "bank_comment"); //���б�ע                                                                                                                     
							
							out.println("<BR />");
							
							out.println("������:");
							out.println(order_no);
							out.println("<BR />");

							out.println("����������:");
							out.println(ref_order_no);
							out.println("<BR />");

							out.println("�̻����:");
							out.println(merchant_no);
							out.println("<BR />");

							out.println("�̻�������:");
							out.println(mer_order_no);
							out.println("<BR />");

							out.println("�������:");
							out.println(order_amount);
							out.println("<BR />");

							out.println("����ģʽ:");
							out.println(pay_mode);
							out.println("<BR />");

							out.println("��Э���:");
							out.println(agreement_no);
							out.println("<BR />");

							out.println("��Э���:");
							out.println(sub_atreement_no);
							out.println("<BR />");

							out.println("����ģʽ����:");
							out.println(order_mode);
							out.println("<BR />");

							out.println("����״̬:");
							out.println(order_status);
							out.println("<BR />");

							out.println("���ӻص�Ч����:");
							out.println(ele_code);
							out.println("<BR />");

							out.println("��ͬ���:");
							out.println(contrace_no);
							out.println("<BR />");

							out.println("��ͬ����:");
							out.println(contrace_name);
							out.println("<BR />");

							out.println("��Ʊ���:");
							out.println(invoice_no);
							out.println("<BR />");

							out.println("��������:");
							out.println(trade_content);
							out.println("<BR />");

							out.println("��ͬ����:");
							out.println(cont_content);
							out.println("<BR />");

							out.println("���׹���:");
							out.println(trade_rule);
							out.println("<BR />");

							out.println("��������:");
							out.println(shipment_date);
							out.println("<BR />");

							out.println("�����׼:");
							out.println(check_criterion);
							out.println("<BR />");

							out.println("�������ɷ�ʽ:");
							out.println(esatab_from);
							out.println("<BR />");

							out.println("������������:");
							out.println(esatab_date);
							out.println("<BR />");

							out.println("��������ʱ��:");
							out.println(esatab_time);
							out.println("<BR />");

							out.println("�����Զ��ر���Ч��:");
							out.println(validate_period);
							out.println("<BR />");

							out.println("�����ر�����:");
							out.println(close_date);
							out.println("<BR />");

							out.println("�����ر�ʱ��:");
							out.println(close_time);
							out.println("<BR />");

							out.println("�����ر�ԭ��:");
							out.println(close_reason);
							out.println("<BR />");

							out.println("�����ҵ����:");
							out.println(buyer_name);
							out.println("<BR />");

							out.println("��������ͻ���:");
							out.println(buyer_cust_no);
							out.println("<BR />");

							out.println("���������������:");
							out.println(buyer_bran_name);
							out.println("<BR />");

							out.println("��һ�Ա��:");
							out.println(buyer_no);
							out.println("<BR />");

							out.println("�����ҵ���ڵ�ַ:");
							out.println(buyer_address);
							out.println("<BR />");

							out.println("��ұ�ע:");
							out.println(buyer_comment);
							out.println("<BR />");

							out.println("�����˺�:");
							out.println(pay_acc_no);
							out.println("<BR />");

							out.println("�����˺ű���:");
							out.println(pay_acc_cur);
							out.println("<BR />");

							out.println("�����˺Ż���:");
							out.println(pay_acc_name);
							out.println("<BR />");

							out.println("������ҵ����:");
							out.println(seller_name);
							out.println("<BR />");

							out.println("���������ͻ���:");
							out.println(seller_ebank_no);
							out.println("<BR />");

							out.println("����������������:");
							out.println(seller_bran_name);
							out.println("<BR />");

							out.println("������ҵ���ڵ�:");
							out.println(seller_address);
							out.println("<BR />");

							out.println("���ұ�ע:");
							out.println(seller_comment);
							out.println("<BR />");

							out.println("�տ��˺�:");
							out.println(rec_acc_no);
							out.println("<BR />");

							out.println("�տ��˺ű���:");
							out.println(rec_acc_cur);
							out.println("<BR />");

							out.println("�տ��˺Ż���:");
							out.println(rec_acc_name);
							out.println("<BR />");

							out.println("�տ���������:");
							out.println(rec_bank_type);
							out.println("<BR />");

							out.println("�տ�����ȫ��:");
							out.println(rec_bank_name);
							out.println("<BR />");

							out.println("�̻����:");
							out.println(nike_name);
							out.println("<BR />");


							out.println("�Ѹ�����:");
							out.println(pay_sum);
							out.println("<BR />");

							out.println("�Ѹ��������:");
							out.println(pay_reate);
							out.println("<BR />");

							out.println("�����ۼ�������:");
							out.println(fee_pay_sum);
							out.println("<BR />");

							out.println("��֤�����:");
							out.println(bail_balance);
							out.println("<BR />");

							out.println("��֤�𽻸��ܶ�:");
							out.println(bail_pay_sum);
							out.println("<BR />");

							out.println("��֤�𽻸����:");
							out.println(bail_pay_reate);
							out.println("<BR />");

							out.println("��֤���˿��ܶ�:");
							out.println(bail_return_sum);
							out.println("<BR />");

							out.println("��֤���˿����:");
							out.println(bail_return_rate);
							out.println("<BR />");

							out.println("��֤�𽻸����:");
							out.println(bail_pay_times);
							out.println("<BR />");

							out.println("��֤�𽻸�������:");
							out.println(bail_fee);
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
