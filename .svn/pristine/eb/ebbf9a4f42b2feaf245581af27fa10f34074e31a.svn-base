<%@page import="com.allbank.payment.PolicyServiceUtil"%>
<%@page import="com.thoughtworks.xstream.io.xml.DomDriver"%>
<%@page import="com.allbank.paymentback.ECClient"%>
<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="com.lsy.baselib.crypto.processor.ECCryptoProcessor"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>中信银行返回支付结果页面</title>
</head>

<body>
</body>
<%
	String signedMessage = (String)request.getParameter("SIGNRSPMSG").trim();
	if(null==signedMessage || "".equals(signedMessage)){
		out.println("<br>中信银行返回信息有误！请及时联系客服处理!") ;
		return;
	}
	
	ECCryptoProcessor processor = new ECCryptoProcessor();
	// 声明信任证书，即为中信银行电子商务B2B支付网关的服务器证书，用于验证签名是否为中信银行签出。
	String trustedCrt = PolicyServiceUtil.readBanksFile("ecclient.txt");
	try {
		processor.addTrustedCertificate(trustedCrt.getBytes());
		processor.verify(signedMessage.getBytes());
		// 通过ECCryptoProcessor类定义的getOrderMessage方法读取订单明文数据
		String OrderMessage = new String( processor.getOrderMessage(signedMessage.getBytes()) );
		
		OrderMessage = OrderMessage.substring(OrderMessage.indexOf("<row>"), OrderMessage.indexOf("</row>")+"</row>".length());
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("row", ECClient.class);
		ECClient ecClient = (ECClient) xStream.fromXML(OrderMessage);
		
		String STT = ecClient.getSTT();  // 交易结果状态 01：交易成功；02：交易失败；03：状态未知；04：审核处理中
		String orderNo = ecClient.getORDERNO();
		if("01".equals(STT) ){
			out.println("<br>中信银行线上支付交易成功!<br>商户订单号:" + orderNo + "<br>支付金额:" + ecClient.getTRANAMT()) ;
		} else {
			out.println("<br>中信银行线上支付交易失败,请及时联系客服处理!<br>商户订单号:" + orderNo) ;
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}

%>


</html>
