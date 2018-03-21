<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css"
	href="${basePath }/etpcss/style.css">
<link href="${basePath }/etpcss/bootstrap-combined.min.css"
	rel="stylesheet">
	<style>
  	#tab-a .a-a{
  		cursor: pointer;color: #4C4C4C;font-size: 15px;
  	}
  	#tab-a .a-a:hover{
  		color:red;
  	}
  </style>
<link rel="stylesheet" type="text/css" media="screen"
	href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<html>
  <body>
  
  <form action="${basePath}/insurePolicy/getPlaceValue" enctype="multipart/form-data" method="post" name="fom">
	  <input type="hidden" name="province" id="province" value="${ggUser.province }"/>
	  <input type="hidden" name="city" id="city" value="${ggUser.city }"/>
	  <input type="hidden" name="county" id="county" value="${ggUser.county }"/>
	  <input type="hidden" name="sumAmount" id="sumAmount" value="${policyManager.sumAmount}"/>
	  <input type="hidden" name="riskCode" id="riskCode" value="${policyManager.riskCode }"/>
	  <input type="hidden" name="areaCode" id="areaCode" value="${policyManager.areaCode }"/>
	  <input type="hidden" name="amount" id="amount" value="${policyManager.amount }"/>
	  <input type="hidden" name="startDate" id="startDate" value="${startDate }"/>
	  <input type="hidden" name="endDate" id="endDate" value="${endDate }"/>
	  <input type="hidden" name="itemOne" id="itemOne" value="${policyManager.itemOne }"/>
	  <input type="hidden" name="itemTwo" id="itemTwo" value="${policyManager.itemTwo }"/>
	  <input type="hidden" name="itemThree" id="itemThree" value="${policyManager.itemThree }"/>
	  <input type="hidden" name="itemFour" id="itemFour" value="${policyManager.itemFour }"/>
	  <input type="hidden" name="toTalk" id="toTalk" value="${policyManager.toTalk }"/>
	  <input type="hidden" name="toTalkName" id="toTalkName" value="${policyManager.toTalkName }"/>
	  <input type="hidden" name="pepSum" id="pepSum" value="${policyManager.pepSum }"/>
	  <input type="hidden" name="pepSums" id="pepSums" value="${pepList }"/>
	  <input type="hidden" name="sanamount" id="sanamount" value="${sanamount }"/>
	  <input id="inName" name="inName" type="hidden" value="${policyManager.inName }">
	  <input id="inLinkName" name="inLinkName" type="hidden" value="${policyManager.inLinkName }">
	  <input id="inAddress" name="inAddress" type="hidden" value="${policyManager.inAddress }">
	  <input id="inEmail" name="inEmail" type="hidden" value="${policyManager.inEmail }">
	  <input id="inTelePhone" name="inTelePhone" type="hidden" value="${policyManager.inTelePhone }">
	  <input id="inBusinessLicenseNo" name="inBusinessLicenseNo" type="hidden" value="${policyManager.inBusinessLicenseNo }">
	  <input id="inSafetyLicenseNo" name="inSafetyLicenseNo" type="hidden" value="${policyManager.inSafetyLicenseNo }">
	  <input id="alName" name="alName" type="hidden" value="${policyManager.alName }">
	  <input id="alLinkName" name="alLinkName" type="hidden" value="${policyManager.alLinkName }">
	  <input id="alAddress" name="alAddress" type="hidden" value="${policyManager.alAddress }">
	  <input id="alEmail" name="alEmail" type="hidden" value="${policyManager.alEmail }">
	  <input id="alTelePhone" name="alTelePhone" type="hidden" value="${policyManager.alTelePhone }">
	  <input id="alBusinessLicenseNo" name="alBusinessLicenseNo" type="hidden" value="${policyManager.alBusinessLicenseNo }">
	  <input id="alSafetyLicenseNo" name="alSafetyLicenseNo" type="hidden" value="${policyManager.alSafetyLicenseNo }">
	  <input id="classCode" name="classCode" type="hidden" value="${TempClassCode }">
	  <input id="businessClass" name="businessClass" type="hidden" value="${TempBusinessClass }">
	  <input id="standardLevel" name="standardLevel" type="hidden" value="${TempStandardLevel }">
	  <input id="TempClassCode" name="TempClassCode" type="hidden" value="${TempClassCode }">
	  <input id="TempBusinessClass" name="TempBusinessClass" type="hidden" value="${TempBusinessClass }">
	  <input id="TempStandardLevel" name="TempStandardLevel" type="hidden" value="${TempStandardLevel }">
  <div class="maincont_mid_cont_right" style="height:600px;">
			<div class="maincont_mid_cont_right_top" style="  text-align: left;  height: 80px; padding-top: 10px;">
            </div>
               <div class="maincont_mid_cont_right_main" style="background:#fff;'">
                <div style="text-align:left;font-size:20px;margin-left:75px;padding-bottom: 40px;">
                报价状态：
                </div> 
                <div>
                	<table width="80%" style="border:1px solid #CCC;text-align:center;margin:0 auto;" align="center" id="tab-a">
                    	<tr style="border-bottom:1px solid #CCC;">
                            <td style="border-right:1px solid #CCC;">保险公司</td>
                            <td style="border-right:1px solid #CCC;">保费(元)</td>
                            <td style="border-right:1px solid #CCC;">操作</td>
                            <td style="border-right:1px solid #CCC;">综合评分</td>
                            <td style="border-right:1px solid #CCC;">综合评价</td>
                            <td style="border-right:1px solid #CCC;">查看资质</td>
<!--                             <td style="border-right:1px solid #CCC;">状态</td> -->
                        </tr>
                        
                        <c:forEach items="${ggInsuranceDetailList }" var="gList" varStatus="rowIndex">
				      	  <tr style="border-bottom:1px solid #CCC;">
				          <td style="border-right:1px solid #CCC;" align=center><img src="/images/${gList.insurancecode }.jpg" />
				          <input type="hidden" name="insurancecode" value="${gList.insurancecode }"> 
				          </td>
				          <td style="border-right:1px solid #CCC;" align=center>${gList.remark }</td>
				          <td style="border-right:1px solid #CCC;" align=center>
				          <div class="maincont_mid_cont_right_bot" style="width: 100%;padding:0px;">
				          	<c:if test="${gList.remark !='待报价' }">
								<a style="cursor: pointer;display: block;margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;" onclick="goZus('${gList.insurancecode }','${gList.clause }')">确认投保</a>
						  	</c:if>
						  </div>
				          <td style="border-right:1px solid #CCC;" align=center>${gList.flag }</td>	
				          <td style="border-right:1px solid #CCC;" align=center>
				          	<a class="a-a"  onclick="seePingJia('${policyManager.riskCode }','${gList.insurancecode }')">查看评价</a>
				          </td>
						  </td>	
				          <td style="border-right:1px solid #CCC;" align=center>
				          	<a class="a-a"  onclick="seeInsure('${policyManager.riskCode }','${gList.insurancecode }')">查看资质与条款</a>
						  </td>	
				          </tr>
				        </c:forEach>
                    </table>
                </div> 
                <div class="maincont_mid_cont_right_bot" style="width: 100%;margin-top:20px;">
                	<p style="color: red;width: 400px;margin: 0 auto;" >注：有价格的保险公司可以点击相应的“确认投保”按钮直接投保，如果要查看所有保险公司的报价，请点击“提交报价”按钮，十分钟后查看所有报价，并选择一家保险公司投保。</p>
					<a style="cursor:pointer; display: block;margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;" onclick="goSashbya()">提交报价</a>
				</div>  
				<div style="text-align:right;">
			    </div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function goZus(o,h) {
			fom.action = "${basePath}/insurePolicy/getPlaceValue?insureCode="+o+"&paymentFlag="+h;
			fom.target = "mainFrame";
			fom.submit();
		}
		function goSashbya() {
			fom.action = "${basePath}/insurePolicy/insertPolicyTemp";
			fom.target = "mainFrame";
			fom.submit();
		}
		function seeInsure(gf,fg){
			var url = "getInManager?insureCode="+fg+"&riskCode="+gf;
			window.open(url, "");
		}
		function seePingJia(gf,fg){
			var url = "getPingJia?insureCode="+fg+"&riskCode="+gf;
			window.open(url, "");
		}
	</script>
</body>
</html>
