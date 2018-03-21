package com.dsib.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GgInsureConfig;
import com.dsib.entity.GgPaymentConfig;
import com.dsib.entity.GgUser;
import com.dsib.entity.GpMainOrder;
import com.dsib.entity.GpOrderDetail;
import com.dsib.entity.GuPolicyMain;
import com.dsib.inter.Apply;
import com.dsib.service.GgInsureConfigService;
import com.dsib.service.GgPaymentConfigService;
import com.dsib.service.GpMainOrderService;
import com.dsib.service.GpOrderDetailService;
import com.dsib.service.GuPolicyMainService;
import com.dsib.service.InsurePolicyService;
import com.dsib.service.JobWebServiceClientService;
import com.dsib.submitInterface.SubmitInsureAfterUtil;




import com.yeepay.Configuration;
import com.yeepay.PaymentForOnlineService;

@Controller
@SessionAttributes({ "resultList", "businessNo", "gpOrderDetail"})
@RequestMapping("/payment")
public class GgPaymentController extends BaseController {

	@Autowired
	GuPolicyMainMapper mainMapper;
	@Resource(name = "ggPaymentConfigService")
	private GgPaymentConfigService ggPaymentConfigService;
	@Resource(name = "insurePolicyService")
	private InsurePolicyService mainService;
	@Resource(name = "gpMainOrderService")
	private GpMainOrderService gpMainOrderService;
	@Resource(name = "gpOrderDetailService")
	private GpOrderDetailService detailService;
	@Resource(name = "GuPolicyMainService")
	private GuPolicyMainService guPolicyMainService;
	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	@Resource(name="JobWebService")
	JobWebServiceClientService client;
	
	@Resource(name = "ggInsureConfigService")
	private GgInsureConfigService ggInsureConfigService;
	
	@Autowired
	private SubmitInsureAfterUtil insureAfterUtil;
	
	/**
	 * 点击缴费调转至此
	 * @param businessNo
	 * @return
	 */
	@RequestMapping("/preparePay")
	public ModelAndView preparePay(@RequestParam String businessNo) {
		ModelAndView mad = new ModelAndView();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String url = request.getParameter("his");
		conditionMap.put("paymentCardType", "03");
		List<GgPaymentConfig> list = ggPaymentConfigService
				.getPayCom(conditionMap);

		GuPolicyMain guPolicyMain = mainService.selectByPrimaryKey3(businessNo);
		//获取 支付类型  1 保单支付 2 批单支付
		String type = request.getParameter("type");
		session.setAttribute("payType", type);
		
		List<GpMainOrder> mainList = gpMainOrderService
				.selectByBusinessNo(businessNo);
		List<GpOrderDetail> orderDetail = detailService
				.selectByMainInMerchantOrderNo(businessNo);

		if (orderDetail.size() > 0) {
			detailService.deleteByBusinessNo(businessNo);
		}
		if (mainList.size() > 0) {
			gpMainOrderService.deleteByBusinessNo(businessNo);
		}
		
		String merchantNo = Apply.proread("p1_MerId");
		
		// 插入订单主表
		GpMainOrder gpMainOrder = new GpMainOrder();
		gpMainOrder.setBusinessNo(businessNo);
		gpMainOrder.setMerchantNo(merchantNo);
		gpMainOrder.setMerchantOrderNo(String.valueOf(new Date().getTime()));
		gpMainOrder.setUpdateTime(new Date());
		gpMainOrderService.insertMainOrder(gpMainOrder);
		// 插入订单明细表
		GpOrderDetail detail = new GpOrderDetail();
		detail.setBusinessNo(gpMainOrder.getMerchantOrderNo());
		detail.setOrderNo(gpMainOrder.getMerchantOrderNo());
		detail.setDealDate(new Date());
		detail.setOrderCurrency("CNY");
//		if("1".equals(type)){
			detail.setOrderAmount(guPolicyMain.getSpreadsheetPremium());
//		}else if("2".equals(type)){
//			GuPolicyEndorse guPolicyEndorse =  gpMainOrderService.selectByEndorsement(businessNo);
//			detail.setOrderAmount(guPolicyEndorse.getCalculation());
//		}
		detailService.insertOrederDetail(detail);
		mad.addObject("resultList", list);
		mad.addObject("gpOrderDetail", detail);
		mad.addObject("businessNo", businessNo);
		session.setAttribute("his", url);
		mad.setViewName("/payment/preparePay");
		return mad;
	}

	/**
	 * 点击"易宝支付"图片跳转至此
	 * @param session
	 * @return
	 */
	@RequestMapping("/YBPay")
	public ModelAndView YBPay(HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Map<String , Object> map = new HashMap<String,Object>();
		//拼接回调地址
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		String businessNo = (String) request.getSession().getAttribute("businessNo");
		String payType = (String)request.getSession().getAttribute("payType");//支付类型 1:投保支付 2:批改支付
		String classCode = (String) request.getSession().getAttribute("classCode");
		GpOrderDetail gpOrderDetailDto = (GpOrderDetail) request.getSession().getAttribute("gpOrderDetail");
		String orderNo = gpOrderDetailDto.getOrderNo();
		String backUrl = basePath + "/payment/callBack?businessnos="
				+ businessNo + "&orderno=" + orderNo + "&classcode="
				+ classCode + "&dataType=" + payType;
		
		String nodeAuthorizationURL = formatString(Configuration.getInstance().getValue("yeepayCommonReqURL")); // 交易请求地址
		String keyValue = formatString(Configuration.getInstance().getValue("keyValue")); // 商家密钥
		// 商家设置用户购买商品的支付信息
		String p0_Cmd  		   = formatString("Buy"); // 在线支付请求，固定值 ”Buy”
		String p1_MerId 	   = formatString(Configuration.getInstance().getValue("p1_MerId")); // 商户编号
		String p2_Order  	   = formatString(gpOrderDetailDto.getOrderNo()); // 商户订单号
		String p3_Amt  		   = formatString(String.valueOf(gpOrderDetailDto.getOrderAmount())); // 支付金额
		String p4_Cur  		   = formatString("CNY"); // 交易币种
		String p5_Pid  		   = formatString("anquanshengchanzerenxian"); // 商品名称
		String p6_Pcat		   = formatString(""); // 商品种类
		String p7_Pdesc		   = formatString("anquanshengchanzerenxian"); // 商品描述
		String p8_Url 		   = formatString(backUrl); // 商户接收支付成功数据的地址
		String p9_SAF		   = formatString("0"); // 需要填写送货信息 0：不需要  1:需要
		String pa_MP 		   = formatString("anquanshengchanzerenxian"); // 商户扩展信息
		String pd_FrpId		   = formatString("").toUpperCase(); // 支付通道编码// 银行编号必须大写
		String pr_NeedResponse = formatString("1"); // 默认为"1"，需要应答机制
		// 获得MD5-HMAC签名
		String hmac = PaymentForOnlineService.getReqMd5HmacForOnlinePayment(
				p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid,
				p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId,
				pr_NeedResponse, keyValue);
		hmac = formatString(hmac); // 交易签名串
		
		map.put("backUrl", backUrl);
		map.put("nodeAuthorizationURL", nodeAuthorizationURL);// 交易请求地址
		map.put("keyValue", keyValue); // 商家密钥
		map.put("p0_Cmd",p0_Cmd); // 在线支付请求，固定值 ”Buy”
		map.put("p1_MerId",p1_MerId); // 商户编号
		map.put("p2_Order",p2_Order ); // 商户订单号
		map.put("p3_Amt", p3_Amt); // 支付金额
		map.put("p4_Cur",p4_Cur); // 交易币种
		map.put("p5_Pid",p5_Pid); // 商品名称
		map.put("p6_Pcat",p6_Pcat); // 商品种类
		map.put("p7_Pdesc",p7_Pdesc ); // 商品描述
		map.put("p8_Url", p8_Url); // 商户接收支付成功数据的地址
		map.put("p9_SAF",p9_SAF ); // 需要填写送货信息 0：不需要  1:需要
		map.put("pa_MP",pa_MP); // 商户扩展信息
		map.put("pd_FrpId",pd_FrpId); // 支付通道编码// 银行编号必须大写
		map.put("pr_NeedResponse",pr_NeedResponse); // 默认为"1"，需要应答机制
		map.put("hmac",hmac); 
System.out.println("backUrl=====>"+map.get("p8_Url"));
		mad.addAllObjects(map);
		mad.setViewName("/payment/B2B/yibao/reqpay");
		return mad;
	}

	/**
	 * 交完费后走自动出单接口或核保出单接口(易宝支付回调地址)
	 * @param businessnos
	 * @param orderno
	 * @param classcode
	 * @return
	 */
	@RequestMapping("/callBack")
	public ModelAndView callBack(@RequestParam String businessnos,
			@RequestParam String orderno, @RequestParam String classcode) {
		ModelAndView mad = new ModelAndView();
		try {
			String merchantNo = request.getParameter("p1_MerId");// 商户号
			String se         = request.getParameter("r3_Amt");// 支付金额-->结算金额
			String keyValue   = Configuration.getInstance().getValue("keyValue"); // 商家密钥
			String r6_Order   = request.getParameter("r6_Order");// 商户订单号
			String r7_Uid     = request.getParameter("r7_Uid");// 易宝支付会员ID
			String r0_Cmd     = request.getParameter("r0_Cmd"); // 业务类型
			String r1_Code    = request.getParameter("r1_Code");// 支付结果
			String r2_TrxId   = request.getParameter("r2_TrxId");// 易宝支付交易流水号
			String r4_Cur     = request.getParameter("r4_Cur");// 交易币种
			String r5_Pid     = new String(formatString( request.getParameter("r5_Pid")).getBytes("iso-8859-1"), "gbk");// 商品名称
			String r8_MP      = new String(formatString( request.getParameter("r8_MP")).getBytes("iso-8859-1"), "gbk");// 商户扩展信息
			String r9_BType   = request.getParameter("r9_BType");// 交易结果返回类型
			String hmac       = request.getParameter("hmac");// 签名数据
			String dataType   = request.getParameter("dataType");//支付类型 1:投保支付 2:批改支付
			
			boolean flag =  PaymentForOnlineService.verifyCallback(hmac, merchantNo,
					r0_Cmd, r1_Code, r2_TrxId, se, r4_Cur, r5_Pid, r6_Order,
					r7_Uid, r8_MP, r9_BType, keyValue);
			// 如果验证签名数据是正确的，更新数据，否则返回页面报错信息
			System.out.println("merchantNo==>"+merchantNo); System.out.println("se==>"+se);
			System.out.println("keyValue==>"+keyValue); System.out.println("r6_Order==>"+r6_Order);
			System.out.println("r7_Uid==>"+r7_Uid); System.out.println("r0_Cmd==>"+r0_Cmd);
			System.out.println("r1_Code==>"+r1_Code); System.out.println("r2_TrxId==>"+r2_TrxId);
			System.out.println("r4_Cur==>"+r4_Cur); System.out.println("r5_Pid==>"+r5_Pid);
			System.out.println("r8_MP==>"+r8_MP); System.out.println("r9_BType==>"+r9_BType);
			System.out.println("hmac==>"+hmac);
			System.out.println("dataType==>"+dataType);
			System.out.println("flag==>"+flag);
			System.out.println("his==>"+session.getAttribute("his"));
			if (flag == true) {
				if("1".equals(dataType)){
					// 转换结算金额的格式 
					double settleAmount = Double.parseDouble(se);
	
					GuPolicyMain guPolicyMain = new GuPolicyMain();
					guPolicyMain.setPayFlag("1");// 支付标志为已支付--1
					guPolicyMain.setActualPremium(settleAmount);// 实际保费--结算金额
					guPolicyMain.setBusinessNo(businessnos);
					guPolicyMainService.updateByBusinessNo(guPolicyMain);
					// GpMainOrder gm = new GpMainOrder();
					// gm.setUpdateTime(new Date());
					// gm.setMerchantOrderNo(businessnos);
					// gpMainOrderService.updateByMerchantOrderNo(gm);
					GpOrderDetail go = new GpOrderDetail();
					go.setMerchantNo(merchantNo);// 商户号
					go.setSettleCurrency("CNY");// 结算币别（人民币）
					go.setSettleAmount(settleAmount);// 结算金额
					go.setEndDate(new Date());// 支付成功的时间
					go.setOrderStatus("100");// 100是支付成功的状态
					go.setBusinessNo(orderno);
					detailService.updateByBusinessNo(go);
					
					
					
					/**如果交易成功“1”，则处理出单接口逻辑信息 ，否则不处理出单接口**/
					//if (r1_Code.equals("1")) {
				/**********								处理接口入参数据									**********/
					GuPolicyMain m = mainMapper.selectByPrimaryKey(businessnos);
					GgInsureConfig ggInsureConfig = new GgInsureConfig();
					ggInsureConfig.setInsuranceCode(m.getInsurerCode());
					List<GgInsureConfig> insurConfigList = ggInsureConfigService.getInsurance(ggInsureConfig);
					String insurConfigFlag = insurConfigList.get(0).getFlag();
					
					if ("3".equals(insurConfigFlag) || "4".equals(insurConfigFlag)) {//核保后出单
						
						insureAfterUtil.underWriteAfter(businessnos);
					}
					if ("2".equals(insurConfigFlag)) {//自动核保并出单
						
						insureAfterUtil.insuranceSingle(businessnos);
					}
				}else if("2".equals(dataType)){
					detailService.updatePayFlag(businessnos);
				}
				//查询用户角色选择回到什么页面 2:企业用户3:第三方(经纪公司)4:保险公司 
				GgUser user = (GgUser) session.getAttribute("ggUser");
				String userInd = user.getUserInd();
				if("2".equals(userInd)) {
					mad.setViewName("/enterprise/enterpriseMainPage");
				}
				if("3".equals(userInd)) {
					mad.setViewName("/dsmanager/mainPage");
					
				}
				if("4".equals(userInd)) {
					mad.setViewName("/policyUser/mainPage");
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
			
		return mad;
	}

				//} else if (r1_Code.equals("2")) {
					// 如果在发起交易请求时	设置使用应答机制时，必须应答以"success"开头的字符串，大小写不敏感
					//System.out.println("SUCCESS");
					// 产品通用接口支付成功返回-电话支付返回	
					//
				//}
			//}else {
				//System.out.println("交易签名被篡改");
			//}

		//} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		//}
					
					
			

	
					
	String formatString(String text){
		String text2 = "";
		try {
			text2 = (text == null) ? "" : new String(
					java.net.URLDecoder.decode(text.trim(), "gb2312").toString()
							.getBytes("iso8859_1"), "gbk");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return text2;
	}
}
