<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<%@ page import="java.text.DecimalFormat"%>
<%@ page import="com.sinosoft.utility.date.DateUtils"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@ page import="com.bocnet.common.security.PKCS7Tool"%>
<%@ page import="com.sinosoft.application.common.ServiceManager"%>
<%@ page import="com.sinosoft.application.trafficsafety.dto.domain.*"%>
<!-- 中行B2B -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + path + "/";
	
//	String configFile = (String) request.getAttribute("configFile");//配置文件路径
	String orderNo = request.getParameter("orderNO").trim(); // 当做订单号
//	String accountNo = (String) request.getAttribute("accountNo");//银行账号
	String merchantNo = (String) request.getAttribute("merchantNo");//商号
	String orde_date = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//
	GpOrderDetailDto gpOrderDetailDto = (GpOrderDetailDto) request.getSession().getAttribute("gpOrderDetailDto");
	
    //拼接表单信息，用于银行调用返回url，更新保单状态为已缴费
	String bussinessNos = request.getParameter("businessNos");
	//回调url
	String backUrl = basePath + "trafficsafety/payment/B2B/boc/bocPayBack.jsp?businessnos="+bussinessNos+"&orderno="+orderNo;
	//数字签名 SignData bocNo|orderNo|curCode|orderAmount|orderTime
	DecimalFormat decimalFormat = new DecimalFormat("#.00");
	String SignData = merchantNo+"|"+orderNo+"|"+"001"+"|"+ decimalFormat.format(gpOrderDetailDto.getOrderAmount()) +"|"+orde_date;
	//密钥
	String password = "51908196"; // 111111
	//证书名称
	String certName = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/classes/com/allbank/payment/cer/boc.pfx";
//	String certName = "C:\\cert02\\boc.pfx";
	//keypassword默认与keystorepassword相同
	String verifyString = "";
	try{
		PKCS7Tool tool = PKCS7Tool.getSigner(certName, password, password);
		//签名
		verifyString = tool.sign(SignData.getBytes());
	}catch(Exception e){e.printStackTrace();}
		
	//
	String[] bussinessNo = bussinessNos.split("-");
	for (int i = 0; i < bussinessNo.length; i++) {
		GpMainOrderDto mainOrder = new GpMainOrderDto();
		mainOrder.setBusinessNo(bussinessNo[i]);
		mainOrder.setMerchantOrderNo(orderNo);
		mainOrder.setMerchantNo( merchantNo); //
		mainOrder.setUpdateTime(DateTime.current());
		ServiceManager.trafficsafety.getGpMainOrderService().insert(mainOrder);
	}
	GpOrderDetailDto Order = new GpOrderDetailDto();//保单
	Order.setBusinessNo(orderNo);
	Order.setOrderNo(orderNo);
	Order.setDealDate(DateUtils.parse((new java.text.SimpleDateFormat( "yyyyMMdd").format(new Date())),	DateUtils.YEAR_TO_DAY_NO_HYPHEN)); // 订单日期
	Order.setMerchantNo( merchantNo);
	Order.setOrderCurrency("CNY");
	Order.setOrderAmount( gpOrderDetailDto.getOrderAmount());
	ServiceManager.trafficsafety.getGpOrderDetailService().insert(Order);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>中行B2B支付</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="/common/css/Standard.css" rel="stylesheet" type="text/css">
  </head>
  <body>
 <!-- 正式地址-->
  <form action="https://ebspay.boc.cn/PGWPortal/B2BRecvOrder.do">
   
   <!-- 测试地址 -->
  <!-- <form action="http://180.168.146.75:81/PGWPortal/B2BRecvOrder.do" method="post"> -->
  <!-- 提交银行信息 -->
  <input name="bocNo" type="hidden" value="<%=merchantNo%>" />
  <input name="orderNo" type="hidden" value="<bean:write name="gpOrderDetailDto" property="orderNo" />" />
  <input name="curCode" type="hidden" value="001" />
  <input name="orderAmount" type="hidden" value='<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>' />
  <!-- 订单时间 orderTime -->
  <input name="orderTime" type="hidden" value="<%=orde_date %>" />
  <!-- 订单说明 orderNote -->
   <input name="orderNote" type="hidden" value="投保支付" />
  <!-- 通知商户url orderUrl-->
  <input name="orderUrl" type="hidden" value="<%=backUrl %>" />
  <!-- 超时时间 orderTimeoutDate -->
  <!-- <input name="orderTimeoutDate" type="hidden" value="" /> -->
  <!-- 数字签名 SignData bocNo|orderNo|curCode|orderAmount|orderTime-->
  <input name="signData" type="hidden" value="<%=verifyString %>" />

 	<table cellpadding="3" cellspacing="1" class="common" style="width:90%" align="center">
		<tr>
			<td>正在跳转中国银行支付页面...请稍后</td>
		</tr>
	</table>
		
</form>
  </body>
  <script language="javascript">
 window.onload=function(){
  	document.forms[0].target="_self" 
  	document.forms[0].submit();
 }
</script>
</html>

