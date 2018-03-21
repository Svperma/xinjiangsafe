<%@ page contentType="text/html; charset=UTF-8"%>
<table>
	<tbody>
		<br />
		<tr heigth="100px">
			<logic:iterate id="ggPaymentConfigDto" name="ggPaymentConfigDto3List">
				<td width="16.5%"><input name="order_amount" type="hidden"
					value="<bean:write name="gpOrderDetailDto" property="orderAmount" format="##########.00"/>" />
					<input name="businessNos" type="hidden"
					value='<%=request.getAttribute("bussinessNos")%>'> <input
					name="ggPaymentConfigBussnissType" type="hidden"
					value='<bean:write name="ggPaymentConfigDto" property="businessType" />'>
					<input name="ggPaymentConfigPaymentCardType" type="hidden"
					value='<bean:write name="ggPaymentConfigDto" property="paymentCardType" />'>
					<input name="ggPaymentConfigPaymentCode" type="hidden"
					value='<bean:write name="ggPaymentConfigDto" property="paymentCode" />'>
					<input name="ggPaymentConfigConifgFile" type="hidden"
					value='<bean:write name="ggPaymentConfigDto" property="conifgFile" />'>
					<input name="ggPaymentConfigMerchantNo" type="hidden"
					value='<bean:write name="ggPaymentConfigDto" property="merchantNo" />'>
					<input name="ggPaymentConfigAcc_no" type="hidden"
					value='<bean:write name="ggPaymentConfigDto" property="acc_no" />'>
					<input name="ggPaymentConfigUserName" type="hidden"
					value='<bean:write name="ggPaymentConfigDto" property="userName" />'>
					<%-- <input name="pay_id" type="radio"  value='<bean:write name="ggPaymentConfigDto" property="paymentCode" />'> --%>
					<span><img
						src='<bean:write name="ggPaymentConfigDto" property="paymentLogo" />'
						alt='<bean:write name="ggPaymentConfigDto" property="paymentName" />'
						onclick="generatePay();"></span></td>
			</logic:iterate>
		</tr>
	</tbody>
</table>

<br>
<!-- <table>
  <tr hegth="100px">
    <input name="paySubmit" type="button" value="确认支付" class="button" onclick="generatePay()" id="paySubmit"/>
  </tr>
</table> -->
<script type="text/javascript">

	function generatePay() {
		fm.action = "/order/payment/B2B/yibao/yibaoPay.jsp";
		/* var gg = document.getElementById("paySubmit");
		gg.disabled = true; 
		fm.target="_blank"; */
		fm.submit();
		return true;
	}
</script>

