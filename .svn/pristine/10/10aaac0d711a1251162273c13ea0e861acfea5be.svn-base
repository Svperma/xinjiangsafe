<%@page import="com.sinosoft.utility.date.DateUtils"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<%@ page import="com.sinosoft.application.trafficsafety.dto.domain.*"%>
<%@ page import="com.sinosoft.application.common.ServiceManager"%>
<!-- 建设银行 -->
<%
	String path = request.getContextPath();System.out.println(path);
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + path + "/";

	String orderNo = request.getParameter("orderNO").trim();
	
	String merchantNo = (String) request.getAttribute("merchantNo");//商号
	String userName = (String) request.getAttribute("userName");//收款人账户名

	String bussinessNos = request.getParameter("businessNos");
	String[] bussinessNo = bussinessNos.split("-");
	for (int i = 0; i < bussinessNo.length; i++) {
		GpMainOrderDto mainOrder = new GpMainOrderDto();
		mainOrder.setBusinessNo(bussinessNo[i]);
		mainOrder.setMerchantOrderNo(orderNo);
		mainOrder.setMerchantNo(merchantNo); //
		mainOrder.setUpdateTime(DateTime.current());
		ServiceManager.trafficsafety.getGpMainOrderService().insert(mainOrder);
	}
	//
	GpOrderDetailDto gpOrderDetailDto = (GpOrderDetailDto) request.getSession().getAttribute("gpOrderDetailDto");
	GpOrderDetailDto Order = new GpOrderDetailDto();//保单
	Order.setBusinessNo(orderNo);
	Order.setOrderNo(orderNo);
	Order.setDealDate(DateUtils.parse((new java.text.SimpleDateFormat( "yyyyMMdd").format(new Date())),
			DateUtils.YEAR_TO_DAY_NO_HYPHEN)); // 订单日期
			Order.setMerchantNo(merchantNo);
			Order.setOrderCurrency("CNY");
			Order.setOrderAmount(gpOrderDetailDto.getOrderAmount());
	ServiceManager.trafficsafety.getGpOrderDetailService().insert(Order);
//	String backUrl = basePath + "trafficsafety/payment/B2B/ccb/ccbPayBack.jsp";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>建行B2B支付</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/common/css/Standard.css" rel="stylesheet" type="text/css">
</head>
<!-- gpOrderDetailDto 订单bean -->
<body>
	<form action="https://ibsbjstar.ccb.com.cn/app/ccbMain" method="post" id="fm" name="fm">

		<!-- 商户代码(银行提供) -->
		<input name="MERCHANTID" type="hidden" value="<%=merchantNo %>" /> <!-- 105110063000186 -->

		<!-- 柜台代码(银行提供) -->
		<input name="POSID" type="hidden" value="896604144" /> <!-- 100000037 -->
		<!-- 分行代码(银行提供) -->
		<input name="BRANCHID" type="hidden" value="110000000" />
		<!-- 订单号(商户网站生成的不重复号码,最多30位) -->
		<input name="ORDERID" type="hidden" value='<bean:write name="gpOrderDetailDto" property="orderNo" />'/>
		<!-- 支付金额(商户网站提供) -->
		<input name="PAYMENT" type="hidden"
			value="<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>" />
		<!-- 币种代码(01:人民币) -->
		<input name="CURCOD" type="hidden" value="01" />
		<!-- 银行支付交易码(690401: 企业支付) -->
		<input name="TXCODE" type="hidden" value="690401" />
		<!-- 备注1(最多30位,只能输入英文和数字,不允许输入中文) -->
		<input name="REMARK1" type="hidden" value="" />

		<!-- 备注2(最多30位,只能输入英文和数字,不允许输入中文) -->
		<input name="REMARK2" type="hidden" value="" />
		<!-- 加密串(调用MD5加密函数生成) -->
		<input name="MAC" id="mac" type="hidden" value="" />

		<!-- 订单说明 orderNote -->
		<input name="MerchantRemarks" type="hidden" value="投保支付" />

		<table cellpadding="3" cellspacing="1" class="common"
			style="width:90%" align="center">
			<tr>
				<td>正在跳转建设银行支付页面...请稍后</td>
			</tr>
		</table>
		
	</form>
</body>
<script type="text/javascript" src="/trafficsafety/payment/B2B/ccb/md5.js"></script>
<script language="javascript">
	
	window.onload =function make(){
		var tmp;
		var subform= document.forms[0]; //获取表单对象
		var MERCHANTID= subform.MERCHANTID.value;
		var POSID= subform.POSID.value;
		var BRANCHID= subform.BRANCHID.value;
		var ORDERID= subform.ORDERID.value;
		var PAYMENT= subform.PAYMENT.value;
		var CURCODE="01"; //币种代码
		var TXCODE="690401"; //企业支付交易码
		var REMARK1=subform.REMARK1.value;
		var REMARK2=subform.REMARK2.value;
		var bankURL="https://ibsbjstar.ccb.com.cn/app/ccbMain";	//生成环境的银行请求地址
		
		tmp ="MERCHANTID="+MERCHANTID+"&POSID="+POSID+"&BRANCHID="+BRANCHID+"&ORDERID="+ORDERID+"&PAYMENT="+PAYMENT+"&CURCODE="+CURCODE+"&TXCODE="+TXCODE+"&REMARK1="+REMARK1+"&REMARK2="+REMARK2;    //加密原串
		//tmp='MERCHANTID=105290045112144&POSID=100000037&BRANCHID=310000000&ORDERID=200905014189364&PAYMENT=0.01&CURCODE=01&TXCODE=690401&REMARK1=&REMARK2=';
		strMD5=hex_md5(tmp); //调用加密函数生成MAC值对应的加密串
		subform.action=bankURL+ "?" +tmp+ "&MAC=" +strMD5;
		document.getElementById("mac").value=strMD5;
// 		subform.target="_target";
		subform.target="_self";
		subform.submit();
	}
</script>
</html>

