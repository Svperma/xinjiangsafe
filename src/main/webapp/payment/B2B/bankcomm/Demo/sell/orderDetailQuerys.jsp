<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="com.bocom.api.core.*"%>
<%@ page import="com.bocom.api.b2b.*"%>
<%@ include file="../conf/configration.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%			
			String queryMode = request.getParameter("queryMode"); //订单模式
			String orderNo = request.getParameter("orderNo"); //订单号
			String merchantNo = request.getParameter("merchantNo"); //商户编号
			String merOrderNo = request.getParameter("merOrderNo"); //商户检索号

			BOCOMB2BSellerClient B2BClient = new BOCOMB2BSellerClient();

			//boolean ret = B2BClient.initalize("/bocommjava/ini/sell/B2BMerchant.xml");
			boolean ret = B2BClient.initalize(SELL_CONF_BASE);

			if (!ret) {
				String errmsg = B2BClient.getLastErr();
				out.println("初始化失败：" + errmsg);
			} else {

				BOCOMOPReply result = null;
				if ("0".equals(queryMode)) {
					result = B2BClient.queryOrderDetail(orderNo);
				} else if ("1".equals(queryMode)) {
					result = B2BClient
							.queryOrderDetail(merchantNo, merOrderNo);
				}

				if (result == null) {
					String errmsg = B2BClient.getLastErr();
					out.println("交易错误信息:" + errmsg);
				} else {
					String code = result.getRetCode();
					String msg = result.getErrorMessage();
					out.println("----------------------------");
					out.println("<BR />");
					out.println("交易返回码：" + code + "<BR />");
					out.println("交易错误信息：" + msg + "<BR />");
					out.println("----------------------------");
					out.println("<BR />");
					if ("0000".equals(code)) {
						int num = result.getOpResultSize(); //得到返回记录个数
						out.println("返回纪录数：" + num + "<BR />");
						out.println("----------------------------");
						out.println("<BR />");

						for (int index = 0; index < num; index++) {
							String order_no = result.getValueByName(index,
									"order_no"); //订单号
							String ref_order_no = result.getValueByName(index,
									"ref_order_no"); //关联订单号
							String merchant_no = result.getValueByName(index,
									"merchant_no"); //商户编号
							String mer_order_no = result.getValueByName(index,
									"merchant_order_no");//商户检索号
							String order_amount = result.getValueByName(index,
									"order_amount"); //订单金额
							String pay_mode = result.getValueByName(index,
									"pay_mode"); //付款模式
							String agreement_no = result.getValueByName(index,
									"agreement_no"); //主协议号
							String sub_atreement_no = result.getValueByName(
									index, "sub_agreement_no"); //子协议号
							String order_mode = result.getValueByName(index,
									"order_mode_name"); //订单模式名称
							String order_status = result.getValueByName(index,
									"order_status"); //订单状态
							String ele_code = result.getValueByName(index,
									"electronic_code"); //电子回单效验码	
							String order_name = result.getValueByName(index,
									"order_name"); //订单名称
							String esatab_from = result.getValueByName(index,
									"establish_from"); //订单生成方式
							String esatab_date = result.getValueByName(index,
									"establish_date"); //订单生成日期
							String esatab_time = result.getValueByName(index,
									"establish_time"); //订单生成时间
							String validate_period = result.getValueByName(
									index, "validate_period"); //订单自动关闭有效期
							String close_date = result.getValueByName(index,
									"close_date"); //订单关闭日期
							String close_time = result.getValueByName(index,
									"close_time"); //订单关闭时间
							String close_reason = result.getValueByName(index,
									"close_reason"); //订单关闭原因
							String buyer_name = result.getValueByName(index,
									"purchaser_name"); //买家企业名称
							String buyer_cust_no = result.getValueByName(index,
									"purchaser_ebank_no");//买家网银客户号
							String buyer_bran_name = result.getValueByName(
									index, "purchaser_branch_name");//买家所属分行名称
							String buyer_address = result.getValueByName(index,
									"purchaser_address");//买家企业所在地址
							String buyer_comment = result.getValueByName(index,
									"purchaser_comment");//买家备注
							String pay_acc_no = result.getValueByName(index,
									"pay_acc_no"); //付款账号
							String pay_acc_cur = result.getValueByName(index,
									"pay_acc_currency"); //付款账号币种
							String pay_acc_name = result.getValueByName(index,
									"pay_acc_name"); //付款账号户名
							String seller_name = result.getValueByName(index,
									"bargainor_name"); //卖家企业名称
							String seller_ebank_no = result.getValueByName(
									index, "bargainor_ebank_no");//卖家网银客户号
							String seller_bran_name = result.getValueByName(
									index, "bargainor_branch_name");//卖家所属分行名称
							String seller_address = result.getValueByName(
									index, "bargainor_address"); //卖家企业所在地                                                                                                                  
							String seller_comment = result.getValueByName(
									index, "bargainor_comment");//卖家备注                                                                                                                          
							String rec_acc_no = result.getValueByName(index,
									"rec_acc_no"); //收款账号                                                                                                                     
							String rec_acc_cur = result.getValueByName(index,
									"rec_acc_currency"); //收款账号币种                                                                                                         
							String rec_acc_name = result.getValueByName(index,
									"rec_acc_name"); //收款账号户名                                                                                                         
							String rec_bank_type = result.getValueByName(index,
									"rec_bank_type"); //收款银行类型                                                                                                                         
							String rec_bank_name = result.getValueByName(index,
									"rec_bank_name"); //收款银行全称                                                                                                         
							String nike_name = result.getValueByName(index,
									"merchant_shortname");//商户简称                                                                                                                        
							String bail_acc_no = result.getValueByName(index,
									"bail_acc_no"); //商户保证金账号                                                                                                       
							String bail_acc_name = result.getValueByName(index,
									"bail_acc_name"); //商户保证金账号户名                                                                                                   
							String pay_sum = result.getValueByName(index,
									"pay_sum"); //已付款金额                                                                                                   
							String pay_reate = result.getValueByName(index,
									"pay_rate"); //已付款金额比率                                                                                               
							String fee_pay_sum = result.getValueByName(index,
									"fee_pay_sum"); //付款累计手续费                                                                                                       
							String bail_balance = result.getValueByName(index,
									"bail_balance"); //保证金余额                                                                                                                   
							String bail_pay_sum = result.getValueByName(index,
									"bail_pay_sum"); //保证金交割总额                                                                                                       
							String return_sum = result.getValueByName(
									index, "return_sum"); //退款总额                                                                                                               
							String return_rate = result.getValueByName(
									index, "return_rate"); //退款比率                                                                                                               
							String return_times = result.getValueByName(
									index, "return_times"); //退款次数                                                                                                               
							String fee_return_sum = result.getValueByName(index,
									"fee_return_sum"); //退款总手续费                                                                                                       
							String bankComment = result.getValueByName(index,
									"bank_comment"); //银行备注                                                                                                                     

							out.println("<BR />");
							
							out.println("订单号:");
							out.println(order_no);
							out.println("<BR />");

							out.println("关联订单号:");
							out.println(ref_order_no);
							out.println("<BR />");

							out.println("商户编号:");
							out.println(merchant_no);
							out.println("<BR />");

							out.println("商户检索号:");
							out.println(mer_order_no);
							out.println("<BR />");

							out.println("订单金额:");
							out.println(order_amount);
							out.println("<BR />");

							out.println("付款模式:");
							out.println(pay_mode);
							out.println("<BR />");

							out.println("主协议号:");
							out.println(agreement_no);
							out.println("<BR />");

							out.println("子协议号:");
							out.println(sub_atreement_no);
							out.println("<BR />");

							out.println("订单模式名称:");
							out.println(order_mode);
							out.println("<BR />");

							out.println("订单状态:");
							out.println(order_status);
							out.println("<BR />");

							out.println("电子回单效验码:");
							out.println(ele_code);
							out.println("<BR />");

							out.println("订单名称:");
							out.println(order_name);
							out.println("<BR />");

							out.println("订单生成方式:");
							out.println(esatab_from);
							out.println("<BR />");

							out.println("订单生成日期:");
							out.println(esatab_date);
							out.println("<BR />");

							out.println("订单生成时间:");
							out.println(esatab_time);
							out.println("<BR />");

							out.println("订单自动关闭有效期:");
							out.println(validate_period);
							out.println("<BR />");

							out.println("订单关闭日期:");
							out.println(close_date);
							out.println("<BR />");

							out.println("订单关闭时间:");
							out.println(close_time);
							out.println("<BR />");

							out.println("订单关闭原因:");
							out.println(close_reason);
							out.println("<BR />");

							out.println("买家企业名称:");
							out.println(buyer_name);
							out.println("<BR />");

							out.println("买家网银客户号:");
							out.println(buyer_cust_no);
							out.println("<BR />");

							out.println("买家所属分行名称:");
							out.println(buyer_bran_name);
							out.println("<BR />");

							out.println("买家企业所在地址:");
							out.println(buyer_address);
							out.println("<BR />");

							out.println("买家备注:");
							out.println(buyer_comment);
							out.println("<BR />");

							out.println("付款账号:");
							out.println(pay_acc_no);
							out.println("<BR />");

							out.println("付款账号币种:");
							out.println(pay_acc_cur);
							out.println("<BR />");

							out.println("付款账号户名:");
							out.println(pay_acc_name);
							out.println("<BR />");

							out.println("卖家企业名称:");
							out.println(seller_name);
							out.println("<BR />");

							out.println("卖家网银客户号:");
							out.println(seller_ebank_no);
							out.println("<BR />");

							out.println("卖家所属分行名称:");
							out.println(seller_bran_name);
							out.println("<BR />");

							out.println("卖家企业所在地:");
							out.println(seller_address);
							out.println("<BR />");

							out.println("卖家备注:");
							out.println(seller_comment);
							out.println("<BR />");

							out.println("收款账号:");
							out.println(rec_acc_no);
							out.println("<BR />");

							out.println("收款账号币种:");
							out.println(rec_acc_cur);
							out.println("<BR />");

							out.println("收款账号户名:");
							out.println(rec_acc_name);
							out.println("<BR />");

							out.println("收款银行类型:");
							out.println(rec_bank_type);
							out.println("<BR />");

							out.println("收款银行全称:");
							out.println(rec_bank_name);
							out.println("<BR />");

							out.println("商户简称:");
							out.println(nike_name);
							out.println("<BR />");

							out.println("商户保证金账号:");
							out.println(bail_acc_no);
							out.println("<BR />");

							out.println("商户保证金账号户名:");
							out.println(bail_acc_name);
							out.println("<BR />");

							out.println("已付款金额:");
							out.println(pay_sum);
							out.println("<BR />");

							out.println("已付款金额比率:");
							out.println(pay_reate);
							out.println("<BR />");

							out.println("付款累计手续费:");
							out.println(fee_pay_sum);
							out.println("<BR />");

							out.println("保证金余额:");
							out.println(bail_balance);
							out.println("<BR />");

							out.println("保证金交割总额:");
							out.println(bail_pay_sum);
							out.println("<BR />");

							out.println("退款总额:");
							out.println(return_sum);
							out.println("<BR />");

							out.println("退款比率:");
							out.println(return_rate);
							out.println("<BR />");

							out.println("退款次数:");
							out.println(return_times);
							out.println("<BR />");

							out.println("退款总手续:");
							out.println(fee_return_sum);
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
