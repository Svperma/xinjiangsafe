<%@page import="com.allbank.payment.PolicyServiceUtil"%>
<%@page import="com.sinosoft.application.common.WriteFileToFile"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.bocnet.common.security.PKCS7Tool"%>
<!-- 中行返回结果页面 -->
<%
	//交易流水 网关生成的交易流水
	String tranSeq = request.getParameter("tranSeq");
	//交易类型(01:支付/04:联机退货)
	String tranCode = request.getParameter("tranCode");
	//订单流水(网关保存的订单唯一流水号)
	String orderSeq = request.getParameter("orderSeq");
	//商户号
	String bocNo = request.getParameter("bocNo");
	//商户订单号
	String orderNo = request.getParameter("orderNo");
	//币种 001
	String curCode = request.getParameter("curCode");
	//订单金额(订单总金额)
//	String orderAmount = request.getParameter("orderAmount");
	//交易费用
	String feeAmount = request.getParameter("feeAmount");
	//交易时间(YYYYMMDDHHMISS)
	String tranTime = request.getParameter("tranTime");
	//交易币种 
//	String tranCur = request.getParameter("tranCur");
	//交易金额(交易类型为支付时表示支付金额)
	String tranAmount = request.getParameter("tranAmount");
	//交易状态(成功/失败)
	String tranStatus = request.getParameter("tranStatus");
	//失败原因
	String errMsg = request.getParameter("errMsg");
	// 付款账户账号
//	String actnumF = request.getParameter("actnumF");
	//银行数字签名
	String signData = request.getParameter("signData");
	//交易流水|交易类型|交易状态|交易时间|交易金额|交易费用|商户号|商户订单号|币种
	//tranSeq| tranCode| tranStatus| tranTime| tranAmount| feeAmount| bocNo| orderNo| curCode

	String msg = "交易流水(tranSeq):" + tranSeq + "\r\n交易类型(tranCode):" + tranCode 
				+"\r\n交易状态(tranStatus):" + tranStatus + "\r\n交易时间(tranTime):"+ tranTime 
				+"\r\n交易金额(tranAmount):"+ tranAmount +"\r\n交易费用(feeAmount):"+ feeAmount 
				+"\r\n商户号(bocNo):"+ bocNo +"\r\n商户订单号(orderNo):" + orderNo;
	WriteFileToFile.writeToBankFile(msg, "bocPayback");  // 将银行返回信息存入文件
	if("1"。equals(tranStatus)){
		String cerPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/classes/com/allbank/payment/cer/boc.cer";
		PKCS7Tool tool = PKCS7Tool.getVerifier( cerPath);
		//签名前字符串
		String signStr = tranSeq + "|" + tranCode + "|" + tranStatus + "|"
				+ tranTime + "|" + tranAmount + "|" + feeAmount + "|"
				+ bocNo + "|" + orderNo + "|" + curCode;
		byte[] bSignData = signStr.getBytes();
		try {
			//验签名
			tool.verify(signData, bSignData, null);
			PolicyServiceUtil.dataWriteBack(orderNo, tranAmount, orderSeq, bocNo, "中行B2B");
		} catch (Exception e) {
			out.println("<br>中行返回交易失败!<br>商户订单号:" + orderNo );
		} 
	} else if("2"。equals(tranStatus)){
		out.println("<br>中国银行支付失败!<br>商户订单号:" + orderNo + "<br />失败原因：" + errMsg);
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>中国银行回调接口</title>
</head>

<body>
</body>
</html>
