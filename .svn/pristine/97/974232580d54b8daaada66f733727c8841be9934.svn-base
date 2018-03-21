package com.dsib.submitInterface;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsib.entity.GgPaymentConfig;
import com.dsib.entity.GpMainOrder;
import com.dsib.entity.GpOrderDetail;
import com.dsib.entity.GuPolicyMain;
import com.dsib.inter.Apply;
import com.dsib.service.GgPaymentConfigService;
import com.dsib.service.GpMainOrderService;
import com.dsib.service.GpOrderDetailService;

/**
 * 提交支付接口  和  支付完返回的数据包接收方法
 * @author Administrator
 *
 */
@Component
public class SubmitPayment {
	
	@Resource(name = "ggPaymentConfigService")
	private GgPaymentConfigService ggPaymentConfigService;
	
	@Resource(name = "gpMainOrderService")
	private GpMainOrderService gpMainOrderService;
	
	@Resource(name = "gpOrderDetailService")
	private GpOrderDetailService detailService;
	
	@Autowired
	HttpSession session;

	/**
	 * 去支付方法
	 * @param guPolicyMain
	 * @return
	 */
	public String goToPayment(GuPolicyMain guPolicyMain) {
		
		Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("paymentCardType", "03");
			List<GgPaymentConfig> list = ggPaymentConfigService
					.getPayCom(conditionMap);//获取支付通道

			List<GpMainOrder> mainList = gpMainOrderService
					.selectByBusinessNo(guPolicyMain.getBusinessNo());
			List<GpOrderDetail> orderDetail = detailService
					.selectByMainInMerchantOrderNo(guPolicyMain.getBusinessNo());

			if (orderDetail.size() > 0) {
				detailService.deleteByBusinessNo(guPolicyMain.getBusinessNo());
			}
			if (mainList.size() > 0) {
				gpMainOrderService.deleteByBusinessNo(guPolicyMain.getBusinessNo());
			}
			
			String merchantNo = Apply.proread("p1_MerId");
			
			// 插入订单主表
			GpMainOrder gpMainOrder = new GpMainOrder();
			gpMainOrder.setBusinessNo(guPolicyMain.getBusinessNo());
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
			detail.setOrderAmount(guPolicyMain.getSpreadsheetPremium());
			detailService.insertOrederDetail(detail);
			session.setAttribute("resultList", list);
			session.setAttribute("gpOrderDetail", detail);
			session.setAttribute("businessNo", guPolicyMain.getBusinessNo());
			return "/payment/preparePay";
	}
	
}
