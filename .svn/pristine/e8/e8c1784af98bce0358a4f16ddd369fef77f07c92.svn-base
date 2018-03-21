
<%@page import="org.springframework.web.context.ContextLoader"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.alibaba.druid.sql.visitor.functions.If"%>
<%@page import="javax.annotation.Resource"%>
<%@page import="com.dsib.entity.GpOrderDetail"%>
<%@page import="com.dsib.entity.GuPolicyMain"%>
<%@page import="com.dsib.service.GpOrderDetailService"%>
<%@page import="com.dsib.service.GuPolicyMainService"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page language="java" contentType="text/html;charset=utf-8"%>
<%@page
	import="com.yeepay.PaymentForOnlineService,com.yeepay.Configuration"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%!String formatString(String text) throws Exception {
		return (text == null) ? "" : new String(
				java.net.URLDecoder.decode(text.trim(), "gb2312").toString()
						.getBytes("iso8859_1"), "gbk");
	}%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//保单ID
	String businessNos = request.getParameter("businessnos");
	//业务ID
	String detailBusinessNo = request.getParameter("orderno");

	String orde_date = new java.text.SimpleDateFormat("yyyyMMdd")
			.format(new Date());//

	String keyValue = formatString(Configuration.getInstance()
			.getValue("keyValue")); // 商家密钥
	String r0_Cmd = formatString(request.getParameter("r0_Cmd")); // 业务类型
	String p1_MerId = formatString(Configuration.getInstance()
			.getValue("p1_MerId")); // 商户编号
	String r1_Code = formatString(request.getParameter("r1_Code"));// 支付结果
	String r2_TrxId = formatString(request.getParameter("r2_TrxId"));// 易宝支付交易流水号
	String r3_Amt = formatString(request.getParameter("r3_Amt"));// 支付金额
	String r4_Cur = formatString(request.getParameter("r4_Cur"));// 交易币种
	String r5_Pid = new String(formatString(
			request.getParameter("r5_Pid")).getBytes("iso-8859-1"),
			"gbk");// 商品名称
	String r6_Order = formatString(request.getParameter("r6_Order"));// 商户订单号
	String r7_Uid = formatString(request.getParameter("r7_Uid"));// 易宝支付会员ID
	String r8_MP = new String(formatString(
			request.getParameter("r8_MP")).getBytes("iso-8859-1"),
			"gbk");// 商户扩展信息
	String r9_BType = formatString(request.getParameter("r9_BType"));// 交易结果返回类型
	String hmac = formatString(request.getParameter("hmac"));// 签名数据
	
	String dataType = request.getParameter("dataType");
	System.out.println("hmac:" + hmac);
	//保存数据
	StringBuffer buffer = new StringBuffer();
	buffer.append("商家密钥: ").append(keyValue);
	buffer.append("\r\n业务类型: ").append(r0_Cmd);
	buffer.append("\r\n商户编号: ").append(p1_MerId);
	buffer.append("\r\n支付结果: ").append(r1_Code);
	buffer.append("\r\n易宝支付交易流水号: ").append(r2_TrxId);
	buffer.append("\r\n支付金额: ").append(r3_Amt);
	buffer.append("\r\n商品名称: ").append(r5_Pid);
	buffer.append("\r\n商户订单号: ").append(r6_Order);
	buffer.append("\r\n易宝支付会员ID: ").append(r7_Uid);
	buffer.append("\r\n商户扩展信息: ").append(r8_MP);
	buffer.append("\r\n交易结果返回类型: ").append(r9_BType);
	buffer.append("\r\n签名数据: ").append(hmac);
// 		new WriteFileToFile().writeForYeePay(buffer.toString(), "d:\\YeepayOnline\\", "易宝返回信息");  //保存报文

	// 校验返回数据包
	boolean flag = false;
	flag = PaymentForOnlineService.verifyCallback(hmac, p1_MerId,
			r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid,
			r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
	System.out.println(flag);
	System.out.println(r1_Code);
	// 	@Resource(name="gpOrderDetailService")
	// 	@Autowired
	ApplicationContext context = ContextLoader
			.getCurrentWebApplicationContext();
	GpOrderDetailService gpOrderDetailService = (GpOrderDetailService) context
			.getBean("gpOrderDetailService");
	// 	@Resource(name="GuPolicyMainService")
	GuPolicyMainService guPolicyMainService = (GuPolicyMainService) context
			.getBean("GuPolicyMainService");
	if (flag == true) {
		// 	if(1==1){
		if("1".equals(dataType)){
		/*转换结算金额的格式*/
			double settleAmount = Double.parseDouble(r3_Amt);
	
			GuPolicyMain guPolicyMain = new GuPolicyMain();
			guPolicyMain.setPayFlag("1");//支付标志为已支付--1
			guPolicyMain.setActualPremium(settleAmount);//实际保费--结算金额
			guPolicyMain.setBusinessNo(businessNos);
			guPolicyMainService.updateByBusinessNo(guPolicyMain);
			//			GpMainOrder gm = new GpMainOrder();
			//			gm.setUpdateTime(new Date());
			//			gm.setMerchantOrderNo(businessnos);
			//			gpMainOrderService.updateByMerchantOrderNo(gm);
			GpOrderDetail go = new GpOrderDetail();
			go.setMerchantNo(p1_MerId);//商户号
			go.setSettleCurrency("CNY");//结算币别（人民币）
			go.setSettleAmount(settleAmount);//结算金额
			go.setEndDate(new Date());//支付成功的时间
			go.setOrderStatus("100");//100是支付成功的状态
			go.setBusinessNo(detailBusinessNo);
			gpOrderDetailService.updateByBusinessNo(go);
		}else if("2".equals(dataType)){
				gpOrderDetailService.updatePayFlag(businessNos);
			}
		}
		//在接收到支付结果通知后，判断是否进行过业务逻辑处理，不要重复进行业务逻辑处理
		if (r1_Code.equals("1")) {
			// 产品通用接口支付成功返回-浏览器重定向
			System.out.println("~~~~~~~~" + r9_BType);
			//校验签名没有错误，且，支付结果为“成功”（1）执行以下的更新数据库方法
			
			
			if (r9_BType.equals("1")) {
				out.println("订单支付成功！");
				// 产品通用接口支付成功返回-服务器点对点通讯
			} else if (r9_BType.equals("2")) {
				// 如果在发起交易请求时	设置使用应答机制时，必须应答以"success"开头的字符串，大小写不敏感
				out.println("SUCCESS");
				// 产品通用接口支付成功返回-电话支付返回	
				//
			}
			// 下面页面输出是测试时观察结果使用
			out.println("<br>交易成功!<br>商家订单号:" + r6_Order + "<br>支付金额:"
					+ r3_Amt + "<br>易宝支付交易流水号:" + r2_TrxId);
		}
	} else {
		out.println("交易签名被篡改!");
	}
%>
<html>
<body>
	<%-- <form action="${basePath}/payment/callBack" method="post" >
		
		<table>
			<tr>
				<td><%=request.getAttribute("title") %></td>
			</tr>
			<tr>
				<td><%=request.getAttribute("content") %></td>
			</tr>
		</table>
		</form> --%>
</body>
<!-- <script type="text/javascript">
		window.onload=function(){
			var f= document.getElementById("flag").value;
			
				document.forms[0].submit();
			
		}
	</script> -->
</html>