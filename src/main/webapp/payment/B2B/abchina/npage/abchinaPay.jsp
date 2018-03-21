<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<%@ page
	import="com.sinosoft.application.trafficsafety.dto.custom.GuPolicyDto"%>
<%@ page
	import="com.sinosoft.application.trafficsafety.dto.domain.GpOrderDetailDto"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String configFile = (String) request.getAttribute("configFile");//配置文件路径
//	String businessNo = (String) request.getAttribute("businessNo");//未知----当做订单号
	String orderNO = request.getParameter("orderNO").trim();
	
	String accountNo = (String) request.getAttribute("accountNo");//银行账号
	String merchantNo = (String) request.getAttribute("merchantNo");//商号
	String userName = (String) request.getAttribute("userName");//收款人账户名
	Date date = new Date();
	String orde_date = new java.text.SimpleDateFormat("yyyy/MM/dd")
			.format(date);//
	String orde_time = new java.text.SimpleDateFormat("HH:mm:ss")
			.format(date);
	GpOrderDetailDto gpOrderDetailDto = (GpOrderDetailDto) request
			.getSession().getAttribute("gpOrderDetailDto");

	//保单列表
	List guPolicyDtoList = (List) request.getSession().getAttribute(
			"guPolicyDtoList");

	//拼接表单信息，用于银行调用返回url，更新保单状态为已缴费
	String businessno = "";
	for (int i = 0; i < guPolicyDtoList.size(); i++) {
		if (i == guPolicyDtoList.size() - 1) {
			businessno += ((GuPolicyDto) guPolicyDtoList.get(i))
					.getGuPolicyMainDto().getBusinessNo();
		} else {
			businessno += ((GuPolicyDto) guPolicyDtoList.get(i))
					.getGuPolicyMainDto().getBusinessNo() + "-";
		}
		//			GuPolicyDto guPolicyDto = (GuPolicyDto)guPolicyDtoList.get(i);
		//			guPolicyDto.getGuPolicyMainDto().setUnderWriteFlag("4");
		//			ServiceManager.trafficsafety.getGuPolicyService().update(guPolicyDto);
	}
	/* String backUrl = "http://www.jiaotongbx.cn/trafficsafety/payment/B2B/abchina/npage/noticeback.jsp?businessnos="
			+ businessno + "&orderno=" + orderNO; */
	String backUrl = basePath + "trafficsafety/payment/B2B/abchina/npage/noticeback.jsp?businessnos="
			+ businessno + "&orderno=" + orderNO;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>农行B2B支付</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/common/css/Standard.css" rel="stylesheet" type="text/css">
</head>
<!-- gpOrderDetailDto 订单bean -->
<body>
	<form
		action="/trafficsafety/payment/B2B/abchina/demo/MerchantFundTransfer.jsp">

		<!-- 订单号 -->
		<input name="MerchantTrnxNo" type="hidden"
			value="<bean:write name="gpOrderDetailDto" property="orderNo" />" />

		<!-- 交易日期 TrnxDate -->
		<input name="TrnxDate" type="hidden" value="<%=orde_date%>" />
		<!-- 交易时间 -->
		<input name="TrnxTime" type="hidden" value="<%=orde_time%>" />
		<!-- 交易金额 -->
		<input name="TrnxAmount" type="hidden"
			value="<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>" />
		<!-- 收款方账号 -->
		<input name="AccountDBNo" type="hidden" value="<%=accountNo%>" />
		<!-- 收款方名称AccountDBName -->
		<input name="AccountDBName" type="hidden" value="<%=userName%>" />
		<!-- 收款方账户开户行联行号 -->
		<input name="AccountDBBank" type="hidden" value="000000" />

		<!-- 后台通知 -->
		<input name="NotifyType" type="hidden" value="1" />
		<!-- 结果通知URL -->
		<input name="ResultNotifyURL" type="hidden" value="<%=backUrl%>" />

		<!-- 订单说明 orderNote -->
		<input name="MerchantRemarks" type="hidden" value="投保支付" />

		<table cellpadding="3" cellspacing="1" class="common"
			style="width:90%" align="center">
			<tr>
				<td>正在跳转...请稍后</td>
			</tr>
		</table>
		<!--		
			
			<tr>
				<td class="title2">订单号：</td>
				<td class="input2"><bean:write name="gpOrderDetailDto" property="orderNo" /> </td>
				
			</tr>
			
			
				<tr>
				<td class="title2">银行分配的商户编号：</td>
				<td class="input2"><%=merchantNo%></td>
				
			</tr>
			<tr>
				<td class="title2">保单业务号：</td>
				<td class="input2"><%=businessno%></td>
				
			</tr> 
			
			<tr>
				<td class="title2">银行账号：</td>
				<td class="input2"><%=accountNo%></td>
				
			</tr>
			
 			<tr>
				<td class="title2">订单金额：</td>
				<td class="input2"><input name="order_amount" maxlength="15"
					class="w60"
					value="<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>" />
					&nbsp; <font color="red" size="4">*</font></td>
			</tr>
			
			<tr>
				<td class="title2">订单币别：</td>
				<td class="input2"><bean:write name="gpOrderDetailDto" property="orderCurrency" /> </td>
				
			</tr>
			<tr>
				<td class="title2">订单状态：</td>
				<td class="input2"><br> <br></td>
				
			</tr>
	
			
	</table>
		<p align=center>
			<input name="subAuthFormButton" type="button" value=" 提 交 "
				class="button" onclick="subAuthForm()" />
		</p>-->

	</form>
</body>
<script language="javascript">
	window.onload = function() {
		document.forms[0].target = "_self"
		document.forms[0].submit();
	}
	//function subAuthForm() {
	//document.forms[0].submit();
	//fm.subAuthFormButton.disabled = 'true';
	//var url = "https://ebspay.boc.cn/PGWPortal/B2BRecvOrder.do";
	//window.open(url, "", "height=600,width=800,status=yes,toolbar=no,menubar=no,location=no,left=80");
	//fm.submit();
	//}
</script>
</html>

