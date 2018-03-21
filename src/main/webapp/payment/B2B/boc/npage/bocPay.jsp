<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<%@ page import="com.sinosoft.application.trafficsafety.dto.custom.GuPolicyDto"%>
<%@ page import="com.sinosoft.application.trafficsafety.dto.domain.GpOrderDetailDto"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String configFile = (String) request.getAttribute("configFile");//配置文件路径
	String businessNo = (String) request.getAttribute("businessNo");//未知----当做订单号
	String accountNo = (String) request.getAttribute("accountNo");//银行账号
	String merchantNo = (String) request.getAttribute("merchantNo");//商号
	String orde_date=new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//
	
	GpOrderDetailDto gpOrderDetailDto = (GpOrderDetailDto)request.getSession().getAttribute("gpOrderDetailDto");
  
    //保单列表
    List guPolicyDtoList = (List)request.getSession().getAttribute("guPolicyDtoList");
    
    //拼接表单信息，用于银行调用返回url，更新保单状态为已缴费
	String businessno = "";
		for(int i = 0;i<guPolicyDtoList.size();i++){
			if(i == guPolicyDtoList.size()-1){
			    businessno += ((GuPolicyDto) guPolicyDtoList.get(i)).getGuPolicyMainDto().getBusinessNo();
			}else{
			    businessno += ((GuPolicyDto) guPolicyDtoList.get(i)).getGuPolicyMainDto().getBusinessNo() + "-";
			}
			//			GuPolicyDto guPolicyDto = (GuPolicyDto)guPolicyDtoList.get(i);
			//			guPolicyDto.getGuPolicyMainDto().setUnderWriteFlag("4");
			//			ServiceManager.trafficsafety.getGuPolicyService().update(guPolicyDto);
		}
		java.text.DecimalFormat  df = new java.text.DecimalFormat("0.00");
		Double d= gpOrderDetailDto.getOrderAmount() ;
		String db = df.format(d);
	
	
	//回调url
	String backUrl = "http://www.jiaotongbx.cn/trafficsafety/payment/B2B/boc/npage/noticeback.jsp?businessnos="+businessno+"&orderno="+businessNo;
	//数字签名 SignData bocNo|orderNo|curCode|orderAmount|orderTime
	String oldStr = merchantNo+"|"+gpOrderDetailDto.getOrderNo()+"|"+"001"+"|"+gpOrderDetailDto.getOrderAmount()+"|"+orde_date;
	
	//密钥
	String password = "111111";
	//证书名称
	String certName = "C:\\cert02\\boc.pfx";
	//keypassword默认与keystorepassword相同
	com.bocnet.common.security.PKCS7Tool tool = com.bocnet.common.security.PKCS7Tool.getSigner(certName, password,password);
	//签名
	String verifyString = tool.sign(oldStr.getBytes());
	System.out.println(oldStr);
	System.out.println(verifyString);
		
	
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
  <!-- gpOrderDetailDto 订单bean -->
  <body>
 <!-- 正式地址-->
  <form action="https://ebspay.boc.cn/PGWPortal/B2BRecvOrder.do">
   
   <!-- 测试地址<form action="http://180.168.146.75:81/PGWPortal/B2BRecvOrder.do">-->
  <!-- 提交银行信息 -->
  <input name="bocNo" type="hidden" value="<%=merchantNo%>" />
  <input name="orderNo" type="hidden" value="<bean:write name="gpOrderDetailDto" property="orderNo" />" />
  <input name="curCode" type="hidden" value="001" />
  <input name="orderAmount" type="hidden" value="<%=db %>" />
  <!-- 订单时间 orderTime -->
  <input name="orderTime" type="hidden" value="<%=orde_date %>" />
  <!-- 订单说明 orderNote -->
   <input name="orderNote" type="hidden" value="投保支付" />
  <!-- 通知商户url orderUrl-->
  <input name="orderUrl" type="hidden" value="<%=backUrl %>" />
  <!-- 超时时间 orderTimeoutDate -->
  <!-- 数字签名 SignData bocNo|orderNo|curCode|orderAmount|orderTime-->
  <input name="signData" type="hidden" value="<%=verifyString %>" />

  <table cellpadding="3" cellspacing="1" class="common"
			style="width:90%" align="center">
			<tr><td>正在跳转...请稍后</td></tr>
			</table>
	  <!--			<tr>
				<td class="title2">数字签名前信息：</td>
				<td class="input2"><%=oldStr%></td>
				
			</tr>
			
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
 window.onload=function(){
 	//var url = "https://ebspay.boc.cn/PGWPortal/B2BRecvOrder.do";
 	//window.open(url, "", "height=600,width=800,status=yes,toolbar=no,menubar=no,location=no,left=80");
  	document.forms[0].target="_blank" 
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

