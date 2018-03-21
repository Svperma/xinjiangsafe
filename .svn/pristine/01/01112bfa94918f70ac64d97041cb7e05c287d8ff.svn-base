<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="${basePath }/etpcss/style.css">
<link href="${basePath }/etpcss/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${basePath }/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
<style>
	#itemOne,#itemTwo,#itemThree,#itemFour{
		width:20px;
		height:20px;
	}
</style>
<html>
<body>
	<form action="${basePath}/insurePolicy/getPlaceValue"
		enctype="multipart/form-data" method="post" name="fom">
		<input type="hidden" name="riskCode" id="riskCode"
			value="${policyManager.riskCode }" /> <input type="hidden"
			name="insureCode" id="insureCode"
			value="${policyManager.insureCode }" /> 
			<input type="hidden"
			name="areaCode" id="areaCode" value="${policyManager.areaCode }" />
			<input type="hidden"
			name="businessNO" id="businessNO" value="${businessNO }" />
			<input type="hidden"
			name="status" id="status" value="${status }" />
			
		<div class="maincont_mid_cont_right" style="height:600px;">
			<div class="maincont_mid_cont_right_top"
				style="  text-align: left;  height: 80px; padding-top: 10px;">
				<div style="text-align:left;margin-left: 20px;">
  				投保人及被保险人信息：
  				</div>
  				<div class="maincont_mid_cont_right_top" style="  text-align: left;  height: 80px; padding-top: 10px;">
					<table width="100%" style="border:1px solid #CCC;text-align:center;" align="center">
						<tr style="border-bottom:1px solid #CCC;">
							<td style="border-right:1px solid #CCC;">投保人名称</td>
                            <td style="border-right:1px solid #CCC;">联系人</td>
                            <td style="border-right:1px solid #CCC;">联系地址</td>
                            <td style="border-right:1px solid #CCC;">邮箱</td>
                            <td style="border-right:1px solid #CCC;">手机号码</td>
                            <td style="border-right:1px solid #CCC;">统一社会信用代码</td>
                            <td style="border-right:1px solid #CCC;">安全生产许可证号</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td style="border-right:1px solid #CCC;">
							<input id="inName" name="inName" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUser.userName }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="inLinkName" name="inLinkName" style="height: 30px;margin-top:5px;" type="text" value="${ggUser.linkName }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="inAddress" name="inAddress" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUser.address }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="inEmail" name="inEmail" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUserCorp.email }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="inTelePhone" name="inTelePhone" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUser.telePhone }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="inBusinessLicenseNo" name="inBusinessLicenseNo" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUserCorp.businessLicenseNo }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input readonly="readonly" id="inSafetyLicenseNo" name="inSafetyLicenseNo" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUserCorp.safetyLicenseNo }">
							</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td style="border-right:1px solid #CCC;">被保险人名称</td>
                            <td style="border-right:1px solid #CCC;">联系人</td>
                            <td style="border-right:1px solid #CCC;">联系地址</td>
                            <td style="border-right:1px solid #CCC;">邮箱</td>
                            <td style="border-right:1px solid #CCC;">手机号码</td>
                            <td style="border-right:1px solid #CCC;">统一社会信用代码</td>
                            <td style="border-right:1px solid #CCC;">安全生产许可证号</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td style="border-right:1px solid #CCC;">
							<input id="alName" name="alName" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUser.userName }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="alLinkName" name="alLinkName" style="height: 30px;margin-top:5px;" type="text" value="${ggUser.linkName }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="alAddress" name="alAddress" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUser.address }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="alEmail" name="alEmail" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUserCorp.email }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="alTelePhone" name="alTelePhone" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUser.telePhone }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input id="alBusinessLicenseNo" name="alBusinessLicenseNo" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUserCorp.businessLicenseNo }">
							</td>
							<td style="border-right:1px solid #CCC;">
							<input readonly="readonly"  id="alSafetyLicenseNo" name="alSafetyLicenseNo" style="height: 30px;margin-top:5px;width: 160px;" type="text" value="${ggUserCorp.safetyLicenseNo }">
							</td>
						</tr>
					</table>               
                </div>
			</div>
			<div class="maincont_mid_cont_right_top" style=" margin-top:80px; text-align: left;">
				保险期间：
				<input type="text" style="width:120px;height: 30px;" name="startDate" id="startDate" onchange="dateCheck();goEndDate();" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'});" value="<fmt:formatDate value='${sessionScope.resultMap.ENDDATE }' pattern='yyyy/MM/dd'/>" class="Wdate">
               至 
               <input type="text" style="width:120px;height: 30px;" name="endDate" id="endDate" onchange="dateCheck()" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'});" value="<fmt:formatDate value='${sessionScope.resultMap.ENDEND }' pattern='yyyy/MM/dd'/>" class="Wdate">
      			<input type="hidden" name="rDate" id="rDdate" value="<%=request.getAttribute("tempDate")%>">
			</div>
			<div class="maincont_mid_cont_right_main" style="background:#fff;'">
				<div style="text-align:left;">主险：</div>
				<div>
					<table width="100%"
						style="border:1px solid #CCC;text-align:center;" align="center">
						<tr style="border-bottom:1px solid #CCC;">
							<td style="border-right:1px solid #CCC;">主险名称</td>
							<td style="border-right:1px solid #CCC;">投保人数</td>
							<td style="border-right:1px solid #CCC;">每人每次赔偿限额</td>
							<td style="border-right:1px solid #CCC;">每次事故及累计责任限额</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td style="border-right:1px solid #CCC;">${resultMap.KINDEDNAME
								}</td>
							<td style="border-right:1px solid #CCC;"><input id="pepSum"
								name="pepSum" style="height: 30px;" type="text" value=""
								placeholder="${resultMap.EMCOUNT }">
								<input type="hidden" name="pepSums" id="pepSums" value="${tempPep }">
							</td>
							<td style="border-right:1px solid #CCC;"><select id="amount"
								name="amount" style="width:150px;">
									<option value="${sessionScope.resultMap.UNITAMOUNT }"
										selected="selected">${sessionScope.resultMap.UNITAMOUNT/10000
										}万</option>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 300000 }">
										<option value="300000">30万</option>
									</c:if>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 400000 }">
										<option value="400000">40万</option>
									</c:if>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 500000 }">
										<option value="500000">50万</option>
									</c:if>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 600000 }">
										<option value="600000">60万</option>
									</c:if>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 700000 }">
										<option value="700000">70万</option>
									</c:if>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 800000 }">
										<option value="800000">80万</option>
									</c:if>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 900000 }">
										<option value="900000">90万</option>
									</c:if>
									<c:if test="${sessionScope.resultMap.UNITAMOUNT != 1000000 }">
										<option value="1000000">100万</option>
									</c:if>
							</select></td>
							<td style="border-right:1px solid #CCC;"><select
								style="width:150px;" id="sumAmount" name="sumAmount">
									<option value="${sessionScope.resultMap.SUMAMOUNT }"
										selected="selected">${sessionScope.resultMap.SUMAMOUNT/10000
										}万</option>
									<c:forEach items="${ggAmountRateList }" var="ggAmount"
										varStatus="rowIndex">
										<c:if
											test="${sessionScope.resultMap.SUMAMOUNT !=  ggAmount.amount}">
											<option value="${ggAmount.amount }">${ggAmount.rate
												}</option>
										</c:if>
									</c:forEach>
							</select></td>
						</tr>
					</table>
				</div>
				<div style="height:15px;"></div>
				<div style="text-align:left;">附加险：</div>
				<div>
					<table width="100%" style="border:1px solid #CCC;">
						<tr style="border-bottom:1px solid #CCC;">
							<td align=center style="border-right:1px solid #CCC;">序号</td>
							<td align=center style="border-right:1px solid #CCC;">附加险名称</td>
							<td align=center style="border-right:1px solid #CCC;">责任限额</td>
							<td align=center style="border-right:1px solid #CCC;">是否投保</td>
						</tr>
						<c:forEach items="${sessionScope.resultAddMap }" var="addmap"
							varStatus="th">
							<tr style="border-bottom:1px solid #CCC;">
								<td align=center style="border-right:1px solid #CCC;">${th.index
									}</td>
								<td align=center style="border-right:1px solid #CCC;">${addmap.KINDCNAME
									}</td>
								<td align=center style="border-right:1px solid #CCC;">${addmap.REMARK
									}</td>

								<td align=center style="border-right:1px solid #CCC;"><c:if
										test="${addmap.SPREADSHEETPREMIUM != null  }">
										<input id="itemOne" name="itemOne" type="checkbox"
											checked="checked">
									</c:if> <c:if test="${addmap.SPREADSHEETPREMIUM == null  }">
										<input id="itemOne" name="itemOne" type="checkbox">
									</c:if></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div style="height:15px;"></div>
				<div style="text-align:left;">责任限额：</div>
				<div>
					<table width="100%" style="border:1px solid #CCC;">
						<tr style="border-bottom:1px solid #CCC;">
							<td align=center style="border-right:1px solid #CCC;">序号</td>
							<td align=center style="border-right:1px solid #CCC;">限额名称</td>
							<td align=center style="border-right:1px solid #CCC;">责任限额</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td align=center style="border-right:1px solid #CCC;">1</td>
							<td align=center style="border-right:1px solid #CCC;">从业人员责任限额</td>
							<td align=center style="border-right:1px solid #CCC;">最低责任限额为每人每次责任限额30万元</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td align=center style="border-right:1px solid #CCC;">2</td>
							<td align=center style="border-right:1px solid #CCC;">第三者责任限额</td>
							<td align=center style="border-right:1px solid #CCC;">每人责任限额、每次事故责任限额及累计责任限额与主险一致</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td align=center style="border-right:1px solid #CCC;">3</td>
							<td align=center style="border-right:1px solid #CCC;">救援费用责任限额</td>
							<td align=center style="border-right:1px solid #CCC;">每次事故救援费用责任限额最高不超过主险每次事故责任限额的30%</td>
						</tr>
						<tr style="border-bottom:1px solid #CCC;">
							<td align=center style="border-right:1px solid #CCC;">4</td>
							<td align=center style="border-right:1px solid #CCC;">法律费用责任限额</td>
							<td align=center style="border-right:1px solid #CCC;">每次法律费用责任限额为主险每次事故责任限额的5%</td>
						</tr>
					</table>
				</div>
				<div style="height:10px;"></div>
				<div>
					特别约定：
					<textarea style="width:90%;" rows="5"></textarea>
				</div>
				<div style="height:10px;"></div>
				<div style="text-align:left;">
					争议解决方式：<select id="toTalk" name="toTalk" style="width:150px;"
						onChange=" if(this.value == '2'){document.getElementById('inp').style.display = '';}else{document.getElementById('inp').style.display = 'none';}">
						<option value="1">诉讼</option>
						<option value="2">仲裁</option>
					</select> <input id="inp" name="toTalkName" class="select_list_inputa"
						type="text" maxlength="20" value="请输入仲裁委员会名称"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: rgb(153, 153, 153);float:none;display:none;height: 30px;">
				</div>
				<div style="text-align:right;"></div>
				<div class="maincont_mid_cont_right_bot"
					style="width: 100%;margin-top:20px;">
					<a
						style="display: block;margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;"
						onclick="goZus()">提交报价</a> <a class="table_buttonb"
						href="javascript:history.go(-1);">返回</a>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function goZus() {
			//日期校验
			var startDate = document.getElementById("startDate").value;
			var endDate = document.getElementById("endDate").value;
			var starttime = document.getElementById("starttime").innerHTML;
			var dateFlag2 = getDateToDate(starttime, startDate);
			if (dateFlag2 < 0) {
				alert("起保日期不能小于提示时间!");
				return;
			}
			var dateFlag = getDateToDate(startDate, endDate);
			if (dateFlag > 365) {
				alert("保险期间不能大于一年!");
				return;
			}
			if (dateFlag < 0) {
				alert("终保日期不能小于起保日期!");
				return;
			}
			//end
			fom.action = "${basePath}/insurePolicy/getPlaceValue";
			fom.target = "mainFrame";
			fom.submit();
		}
		function getFormatDate() {//格式化日期
			var myDate = new Date();
			var month = myDate.getMonth() + 1;
			var date = myDate.getDate();
			if ((myDate.getMonth() + 1) < 10) {
				month = "0" + (myDate.getMonth() + 1);
			}
			if ((myDate.getDate()) < 10) {
				date = "0" + myDate.getDate();
			}
			var nowDate = myDate.getFullYear() + "-" + month + "-" + date//yyyy-MM-dd
			return nowDate;
		}
		function getInternet() {
			if (navigator.userAgent.indexOf("MSIE") > 0) {
				return "MSIE"; //IE浏览器 
			}
			if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
				return "Firefox"; //Firefox浏览器 
			}
			if (isSafari = navigator.userAgent.indexOf("Chrome") > 0) {
				return "Chrome"; //Safan浏览器 
			}
			if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
				return "Camino"; //Camino浏览器 
			}
			if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
				return "Gecko"; //Gecko浏览器 
			}
		}
		function getDateToDate(startDate, endDate) {
			var btype = getInternet();
			var aDate, oDate1, oDate2, iDays;
			if (btype == "MSIE") {
				aDate = startDate.split('-');
				oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
				aDate = endDate.split('-');
				oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
				iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60
						/ 24);//把相差的毫秒数转换为天数
			} else {
				oDate1 = new Date(startDate).getTime();
				oDate2 = new Date(endDate).getTime();
				iDays = (oDate2 - oDate1) / 1000 / 60 / 60 / 24;
				iDays = Math.round(iDays);
			}
			return iDays + 1;
		}
		
		function goPep(){
			var tempValue = document.getElementById("pepSums").value; 
			var url = "getMySon?gobibi="+tempValue;
			url = encodeURI(encodeURI(url));
			window.open(url, "", "height=600,width=600,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes,left=80");
		}
		
		function changeSumAmount(){
			var gg = document.getElementById("amount").value;
			var gs = document.getElementById("pepSum").value;
			document.getElementById("sumAmount").value=gg*gs;
		}
	</script>
</body>
</html>
