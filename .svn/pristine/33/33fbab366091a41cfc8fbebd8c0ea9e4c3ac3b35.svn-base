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
<link rel="stylesheet" type="text/css" media="screen"
	href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<html>
  <body>
  <form action="${basePath}/dsmanager/getPlaceValue" enctype="multipart/form-data" method="post" name="fom">
	 <%--  <input type="hidden" name="riskCode" id="riskCode" value="${policyManager.riskCode }"/>
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
	<input id="inName" name="inName" type="hidden" value="${tempUser.inName }">
	<input id="inLinkName" name="inLinkName" type="hidden" value="${tempUser.inLinkName }">
	<input id="inAddress" name="inAddress" type="hidden" value="${tempUser.inAddress }">
	<input id="inEmail" name="inEmail" type="hidden" value="${tempUser.email }">
	<input id="inTelePhone" name="inTelePhone" type="hidden" value="${tempUser.telephone }">
	<input id="inBusinessLicenseNo" name="inBusinessLicenseNo" type="hidden" value="${tempUser.businessLicenseNo }">
	<input id="province" name="province" type="hidden" value="${tempUser.province }">
	<input id="city" name="city" type="hidden" value="${tempUser.city }">
	<input id="county" name="county" type="hidden" value="${tempUser.county }">
	<input id="classCode" name="classCode" type="hidden" value="${tempUser.classCode }">
	<input id="businessClass" name="businessClass" type="hidden" value="${tempUser.businessClass }">
	<input id="standardLevel" name="standardLevel" type="hidden" value="${tempUser.standardLevel }">
	<input id="safetyLicenseNo" name="safetyLicenseNo" type="hidden" value="${tempUser.safetyLicenseNo }">
	<input id="standardLevelImg" name="standardLevelImg" type="hidden" value="${standardLevelImg }"> --%>
  <div class="maincont_mid_cont_right" style="height:600px;">
			<div class="maincont_mid_cont_right_top" style="  text-align: left;  height: 80px; padding-top: 10px;">
            </div>
               <div class="maincont_mid_cont_right_main" style="background:#fff;'">
                <div style="text-align:left;font-size:20px;margin-left:75px;padding-bottom: 40px;">
                报价状态：
                </div> 
                <div>
                	<table width="80%" style="border:1px solid #CCC;text-align:center;margin:0 auto;" align="center">
                    	<tr style="border-bottom:1px solid #CCC;">
                            <td style="border-right:1px solid #CCC;">保险公司</td>
                            <td style="border-right:1px solid #CCC;">保费(元)</td>
                            <td style="border-right:1px solid #CCC;">操作</td>
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
						  </td>	
				          <td style="border-right:1px solid #CCC;" align=center>
				          <div class="maincont_mid_cont_right_bot" style="width: 100%;padding:0px;">
								<a style="cursor: pointer;display: block;margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;" onclick="seeInsure('${policyManager.riskCode }','${gList.insurancecode }')">查看资质</a>
						  </div>
						  </td>	
				          </tr>
				        </c:forEach>
                    </table>
                </div>   
                <div class="maincont_mid_cont_right_bot" style="width: 100%;margin-top:20px;">
                	<p style="color: red;width: 400px;margin: 0 auto;">注：提交报价单后，请十分钟后查看报价结果</p>
					<a style="cursor:pointer; display: block;margin: auto;width: 128px;height: 22px;padding: 5px 0px;float: none;" onclick="goSashbya()">提交报价单</a>
				</div>
				<div style="text-align:right;">
			    </div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function goZus(o,h) {
			fom.action = "${basePath}/dsmanager/getPlaceValue?insureCode="+o+"&paymentFlag="+h;
			fom.target = "mainFrame";
			fom.submit();
		}
		function goSashbya() {
			fom.action = "${basePath}/dsmanager/insertPolicyTemp";
			fom.target = "mainFrame";
			fom.submit();
		}
		function seeInsure(gf,fg){
			var url = "${basePath}/insurePolicy/getInManager?insureCode="+fg+"&riskCode="+gf;
			window.open(url, "", "height=600,width=600,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes,left=80");
		}
	</script>
</body>
</html>
