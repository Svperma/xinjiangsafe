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
<link rel="stylesheet" type="text/css" href="${basePath }/css/tab-tou.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${basePath }/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function getClassCode(parentId, childId) {
		var parentVal = "";
		if (parentId != null && parentId != '')
			parentVal = document.getElementById(parentId).value;
		else
			return;
		document.getElementById(childId).length = 0;
		var clcode = document.getElementById("hhhhh").value;
		$.ajax({
			type : "post",
			url : "${basePath}/policyUser/getGgCodeByObj?codeType=IndustryType&remark="
					+ parentVal,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				var obj = document.getElementById(childId);
				for ( var i = 0; i < data.length; i++) {
					var item = data[i];
					var option = document.createElement("option");
					option.value = item.codeCode;
					option.text = item.codeCName;
					if(item.codeCode==clcode){
						option.setAttribute("selected","selected");
					}
					obj.appendChild(option);
				}
			},
			error : function() {
				alert("error");
			}
		});
	}
	 
</script>
<style>
	#itemOne,#itemTwo,#itemThree,#itemFour{
		width:20px;
		height:20px;
	}
</style>
<html>
  <body onload="changeSumAmount();getClassCode('classCode','businessClass');" style="height:100%;background:#fff;">
  <form action="${basePath}/insurePolicy/getPlaceValue" enctype="multipart/form-data" method="post" name="fom">
  <input type="hidden" name="riskCode" id="riskCode" value="${policyManager.riskCode }"/>
  <input type="hidden" name="insureCode" id="insureCode" value="${policyManager.insureCode }"/>
  <input type="hidden" name="areaCode" id="areaCode" value="${policyManager.areaCode }"/>
  <input type="hidden" name="hhhhh" id="hhhhh" value="${ggUserCorp.businessClass }"/>
  <div class="maincont_mid_cont_right">
	 <div class="tab-top-div">
		<h2 class="title-h1">新疆维吾尔自治区安全生产责任保险&nbsp;&nbsp;投保单</h2>
		<c:if test="${sessionScope.resultMap.POLICYNO != null }">
			<p class="title-p">保单号码:</p>
			<c:if test="${sessionScope.resultMap.POLICYNO != null }">
			<p class="title-p">归属机构:</p>
			<p class="title-p">业务员:</p>
			</c:if>
		</c:if>
		<table class="nav-tab">
			<tr>
				<td colspan="8" class="bg-tab-ddd">投保提示：</td>
			</tr>
			<tr>
				<td colspan="2" class="right-border bottom-border top-border">
					1、
				</td>
				<td colspan="6" class="left-border bottom-border top-border">
					请您填写投保单前详细阅读保险条款，特别注意条款中的保险责任、责任免除、投保人被保险人义务、赔偿处理等内容并听取保险人就条款（包括前述需特别注意的内容）所作的说明。。
				</td>
			</tr>
			<tr>
				<td colspan="2" class="right-border bottom-border top-border">
					2、
				</td>
				<td colspan="6" colspan="6" class="left-border bottom-border top-border">
					为保障您的合法权益，请您如实、完整、准确地填写本投保单。投保信息如有变动请及时办理变更手续。
				</td>
			</tr>
			<tr>
				<td colspan="2" class="right-border bottom-border top-border">
					3、
				</td>
				<td colspan="6" class="left-border bottom-border top-border">
					请您按本投保单的约定及时交纳保险费。
				</td>
			</tr>
			<tr>
				<td colspan="8" class="bg-tab-ddd">投保人信息<span style="font-size: 12px;color: red;">(投保人默认为本企业信息,如有错误请修改"企业信息")</span></td>
			</tr>
			<tr>
				<td colspan="1">投保人名称</td>
				<td colspan="7"><input id="alName" name="alName" type="text" readonly="readonly" value="${ggUser.userName }"></td>
			</tr>
			<tr>
				<td colspan="2">联系地址</td>
				<td colspan="2"><input id="alAddress" name="alAddress" type="text" readonly="readonly" value="${ggUser.address }"></td>
				<td colspan="2">邮箱</td>
				<td colspan="2"><input id="alEmail" name="alEmail" type="text" readonly="readonly" value="${ggUserCorp.email }"></td>
			</tr>
			<tr>
				<td colspan="2">联系电话</td>
				<td colspan="2"><input id="alTelePhone" name="alTelePhone" type="text" readonly="readonly" value="${ggUser.telePhone }"></td>
				<td colspan="2">联系人</td>
				<td colspan="2"><input id="alLinkName" name="alLinkName" type="text" readonly="readonly" value="${ggUser.linkName }"></td>
			</tr>
			<tr>
				<td colspan="8" class="bg-tab-ddd">被保险人信息<span style="font-size: 12px;color: red;">(如果不是默认企业信息，请修改)</span></td>
			</tr>
			<tr>
				<td colspan="2">被保险人名称</td>
				<td colspan="2"><input id="inName" name="inName" type="text" value="${ggUser.userName }"></td>
				<td colspan="2">邮箱</td>
				<td colspan="2"><input id="inEmail" name="inEmail" type="text" value="${ggUserCorp.email }"></td>
			</tr>
			<tr>
				<td colspan="2">联系电话</td>
				<td colspan="2"><input id="inTelePhone" name="inTelePhone" type="text" value="${ggUser.telePhone }"></td>
				<td colspan="2">联系人</td>
				<td colspan="2"><input id="inLinkName" name="inLinkName" type="text" value="${ggUser.linkName }"></td>
			</tr>
			<tr>
				<td colspan="1">联系地址</td>
				<td colspan="7"><input id="inAddress" name="inAddress" type="text" value="${ggUser.address }"></td>
			</tr>
			<tr>
				<td colspan="2">行业类别</td>
				<td colspan="2">
					<select style="width: 160px;" name="classCode" id="classCode" 
									onchange="getClassCode('classCode','businessClass')"> 
								<c:forEach items="${list_classCode}" var="cl" varStatus="st">
									<c:if test="${ggUserCorp.classCode == cl.codeCode}">
										<option selected="selected" value="${cl.codeCode}">${cl.codeCName }</option>
									</c:if>
									<c:if test="${ggUserCorp.classCode != cl.codeCode}">
										<option value="${cl.codeCode}">${cl.codeCName }</option>
									</c:if>
								</c:forEach>
					</select>
				</td>
				<td colspan="2">经营范围</td>
				<td colspan="2">
					<select style="width: 160px;" name="businessClass" id="businessClass">
						<c:forEach items="${list_businessClass}" var="bc" varStatus="st">
							<c:if test="${ggUserCorp.businessClass == bc.codeCode}">
								<option selected="selected" value="${bc.codeCode}">${bc.codeCName }</option>
							</c:if>
							<c:if test="${ggUserCorp.businessClass != bc.codeCode}">
								<option value="${bc.codeCode}">${bc.codeCName }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">统一社会信用代码</td>
				<td colspan="2">
					<input id="inBusinessLicenseNo" name="inBusinessLicenseNo" type="text"
					onblur="checkBusinessLienseNo(this)" value="${ggUserCorp.businessLicenseNo }" style="width:50%;">
					<div class="maincont_mid_cont_right_bot" style="display:inline-block;">
						<a style="cursor:pointer;" href="${ggUserCorp.businessLicenseImage }" target="_blank">查看图片</a>
					</div>
				</td>
				<td colspan="2">安全生产许可证号</td>
				<td colspan="2">
					<input id="inSafetyLicenseNo" name="inSafetyLicenseNo" type="text" value="${ggUserCorp.safetyLicenseNo }" style="width:50%;">
					<div class="maincont_mid_cont_right_bot" style="display:inline-block;">
						<a style="cursor:pointer;" href="${ggUserCorp.safetyLicenseImage }" target="_blank">查看图片</a>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">从业人员人数</td>
				<td colspan="2">
					<input readonly="readonly" id="pepSum" name="pepSum" type="text" value="${policyManager.pepSum }" style="width:50%;">
                    <div class="maincont_mid_cont_right_bot" style="display:inline-block;">
						<a style="cursor:pointer;" onclick="goPep()">查看员工</a>
					</div>
					<input type="hidden" name="pepSums" id="pepSums" value="<%=request.getAttribute("pepSums") %>">
				</td>
				<td colspan="2">安全标准化等级</td>
				<td colspan="2">
					<select style="width: 160px;" name="standardLevel" id="standardLevel">
							<c:forEach items="${list_safe}" var="sa" varStatus="st">
								<c:if test="${ggUserCorp.standardLevel == sa.codeCode}">
									<option selected="selected" value="${sa.codeCode}">${sa.codeCName }</option>
								</c:if>
								<c:if test="${ggUserCorp.standardLevel != sa.codeCode}">
									<option value="${sa.codeCode}">${sa.codeCName }</option>
								</c:if>
							</c:forEach>
					</select>
					<div class="maincont_mid_cont_right_bot" style="display:inline-block;">
						<a style="cursor:pointer;" href="${ggUserCorp.standardLevelImage }" target="_blank">查看图片</a>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="8" class="bg-tab-ddd">投保明细</td>
			</tr>
			<tr>
				<td colspan="8" class="bg-tab-ddd">主险：</td>
			</tr>
			<tr>
				<td rowspan="4">安全生产责任保险</td>
				<td colspan="3">每人每次赔偿限额</td>
				<td colspan="4">
					<select id="amount" name="amount" onchange="changeSumAmount()">
                        <option value="315295.92">315295.92元</option>
                        <option value="400000">40万</option>
                        <option value="500000">50万</option>
                        <option value="600000">60万</option>
                        <option value="700000">70万</option>
                        <option value="800000">80万</option>
                        <option value="900000">90万</option>
                        <option value="1000000">100万</option>
                    </select>
				</td>
			</tr>
			<tr>
				<td colspan="3">每次事故赔偿限额</td>
				<td colspan="4"><input readonly="readonly" id="sumAmount" name="sumAmount" type="text" value=""></td>
			</tr>
			<tr>
				<td colspan="3">年度累计赔偿限额</td>
				<td colspan="4"><input readonly="readonly" id="sumAmountTEMP" name="sumAmountTEMP" type="text" value=""></td>
			</tr>
			<tr>
				<td colspan="3">每次事故绝对免赔额</td>
				<td colspan="4">人身伤亡无免赔额</td>
			</tr>
			<tr>
				<td>保险费  ￥：</td>
				<td colspan="7"></td>
			</tr>
			<tr>
				<td colspan="8" class="bg-tab-ddd">附加险（可选）：</td>
			</tr>
			<tr>
				<td colspan="1" class="text-bold">附加险种名称</td>
				<td colspan="3" class="text-bold">赔偿限额</td>
				<td colspan="1" class="text-bold">是否投保</td>
				<td colspan="3" class="text-bold">每次事故免赔额</td>
			</tr>
			<tr>
				<td colspan="1">附加第三者责任保险</td>
				<td colspan="3">
					每次事故及累计赔偿限额<select id="sanamount" name="sanamount" style="width:150px;">
                                    <option value="1000000">100万</option>
                                    <option value="2000000">200万</option>
                                    <option value="3000000">300万</option>
                                    <option value="5000000">500万</option>
                                    <option value="8000000">800万</option>
                                    <option value="10000000">1000万</option>
                                </select>万元，其中：每次事故每人人身伤亡赔偿限额与主险一致；
每次事故每人医疗费用赔偿限额为每人人身伤亡赔偿限额的30%；每次事故财产损失为每次事故及累计赔偿限额的50%；
				</td>
				<td colspan="1"><input id="itemOne" name="itemOne" type="checkbox"></td>
				<td colspan="3">每人医疗费用免赔额为人民币500元；
财产损失免赔额为人民币1000元</td>
			</tr>
			<tr>
				<td colspan="1">附加从业人员医疗费用保险</td>
				<td colspan="3">
					每人医疗费用赔偿限额为主险每人死亡赔偿限额的30%，医疗费用每次事故及累计赔偿限额为主险每次事故及累计赔偿限额的30%。
				</td>
				<td colspan="1"><input id="itemTwo" name="itemTwo" type="checkbox"></td>
				<td colspan="3">每人医疗费用免赔额为人民币500元。</td>
			</tr>
			<tr>
				<td colspan="1">附加救援费用保险</td>
				<td colspan="3">
					每次事故及累计赔偿限额为主险每次及累计赔偿限额的30%。
				</td>
				<td colspan="1"><input id="itemThree" name="itemThree" type="checkbox"></td>
				<td colspan="3">免赔额为人民币2000元。</td>
			</tr>
			<tr>
				<td colspan="1">附加法律费用保险</td>
				<td colspan="3">
					每次事故及累计赔偿限额为主险每次事故及累计赔偿限额的5%。
				</td>
				<td colspan="1"><input id="itemFour" name="itemFour" type="checkbox"></td>
				<td colspan="3">免赔额为人民币500元。</td>
			</tr>
			<tr>
				<td colspan="8">总保险费：人民币（大写）：</td>
			</tr>
			<tr style="background-color: yellow;">
				<td colspan="2">保险期间</td>
				<td colspan="6">自<input type="text" style="width:120px;height: 30px;" name="startDate" id="startDate" onchange="dateCheck();goEndDate()" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'});" value="<%=request.getAttribute("startDate")%>"
				 class="Wdate">起 至<input type="text" style="width:120px;height: 30px;" name="endDate" id="endDate" onchange="dateCheck()" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'});" value="<%=request.getAttribute("endDate")%>" class="Wdate">止
				 (以最终签发的保险单为准)为保证保险合同在拟定的保险起期生效，请您在保险起期前5个工作日前办理投保手续、提交投保资料并支付保费。如您未能按时办理投保手续或保费未能按时到账，导致保险合同未在拟定的保险起期生效，发生保险事故，本公司不承担保险责任。</td>
				<input type="hidden" name="rDate" id="rDdate" value="<%=request.getAttribute("tempDate")%>">
			</tr>
			<tr>
				<td colspan="2">司法管辖</td>
				<td colspan="6">中华人民共和国司法（港、澳、台除外）</td>
			</tr>
			<tr>
				<td rowspan="7">特别约定</td>
				<td colspan="7">1、本保险项下的赔偿责任不因被保险人非故意地延迟、错误或遗漏向保险公司申报与保险合同有关的重要事项而失效，一旦被保险人得知其疏忽或遗漏应在合理的时间内尽快向保险公司申报。</td>
			</tr>
			<tr>
				<td colspan="7">2、被保险人因为自身无法控制的原因或并非其主观过失的原因而导致违反本保险条款，此保单的保障不受影响。</td>
			</tr>
			<tr>
				<td colspan="7">3、保险人对被保险人举证提出的损失额度有异议的，应当承担相应的举证责任。</td>
			</tr>
			<tr>
				<td colspan="7">4、本保险合同于确认无误的投保信息录入新疆安责险信息平台且保费到达安责险专收账户的次日零时生效。</td>
			</tr>
			<tr>
				<td colspan="7">5、保险人仅对本保单明细表中列明的从业人员的伤亡承担赔偿责任。</td>
			</tr>
			<tr>
				<td colspan="7">6、发生生产安全事故或按照职业病防治法规定被诊断、鉴定为职业病，被保险人应当自事故发生之日或者被诊断、鉴定为职业病之日起30日内，向保险人报案。被保险人未按约定时限报案的，对属于保险责任事故伤害的保险人也不负责赔偿。</td>
			</tr>
			<tr>
				<td colspan="7">7、本保险单未约定事项，以保险人与自治区安全监管局委托的德圣经纪公司签署的《新疆维吾尔自治区安生生产责任保险项目合作协议》为准。</td>
			</tr>
		</table>
		<div style="text-align:left;">
        	争议解决方式：<select id="toTalk" name="toTalk" style="width:150px;" onChange=" if(this.value == '2'){document.getElementById('inp').style.display = '';}else{document.getElementById('inp').style.display = 'none';}">
                            <option value="1">诉讼</option>
                            <option value="2">仲裁</option>
                        </select>
                        <input id="inp" name="toTalkName" class="select_list_inputa" type="text" maxlength="20" value="请输入仲裁委员会名称" onfocus="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#999'}" style="color: rgb(153, 153, 153);float:none;display:none;height: 30px;">
        </div>   
		<div class="maincont_mid_cont_right_bot" style="width: 100%;">
			<a style="cursor:pointer; display: block;margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;" onclick="goZus()">下一步</a>
		</div>
		</br>
		</br>
	 </div>
	</div>
  </form>
    <script type="text/javascript">
    function goEndDate(){
		var StartDate = document.getElementById("startDate").value;
		$.ajax({					
			type : "post",
			url : "${basePath}/policyUser/getEndDate",
			data :JSON.stringify({
				"StartDate":StartDate
				}),
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				document.getElementById("endDate").value = data;
			},
			error : function() {
				alert("终保日期修改失败！")
			}
		});
	}
    function dateCheck(){
    	//日期校验
		var startDate = document.getElementById("startDate").value;
		var endDate = document.getElementById("endDate").value;
		var rDdate = document.getElementById("rDdate").value;
		var dateFlag3 = getDateToDate(rDdate,startDate);
		if(dateFlag3<1){
			alert("起保日期不能小于上一年保单的终保日期!");
			return;
		}
		var nowDate = getFormatDate();
		var dateFlag2 = getDateToDate(nowDate,startDate);
		if(dateFlag2<0){
			alert("起保日期不能小于今天!");
			return;
		}
		var dateFlag = getDateToDate(startDate,endDate);
		$.ajax({					
			type : "post",
			url : "${basePath}/insurePolicy/getDateYear",
			data :JSON.stringify({
				"startDate":startDate,
				"endDate":endDate
				}),
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if(data!=1){
					alert("保险期间不能大于一年!");
					return;
				}
			},
			error : function() {
				alert("日期校验失败！")
				return;
			}
		});
		if(dateFlag<0){
			alert("终保日期不能小于起保日期!");
			return;
		}
    }
    function goZus(){
    
    	if(!checkZus()){
    		alert("投保人及被保险人信息不能为空！");
			return;
    	}
    	
	    var pepSum = document.getElementById("pepSum").value;
	    if(pepSum==0){
	    	alert("至少选择一名员工!");
			return;
	    }
		//日期校验
		var startDate = document.getElementById("startDate").value;
		var endDate = document.getElementById("endDate").value;
		var rDdate = document.getElementById("rDdate").value;
		var dateFlag3 = getDateToDate(rDdate,startDate);
		if(dateFlag3<1){
			alert("起保日期不能小于上一年保单的终保日期!");
			return;
		}
		var nowDate = getFormatDate();
		var dateFlag2 = getDateToDate(nowDate,startDate);
		if(dateFlag2<0){
			alert("起保日期不能小于今天!");
			return;
		}
		var dateFlag = getDateToDate(startDate,endDate);
		if(dateFlag<0){
			alert("终保日期不能小于起保日期!");
			return;
		}
		//end
		$.ajax({					
			type : "post",
			url : "${basePath}/insurePolicy/getDateYear",
			data :JSON.stringify({
				"startDate":startDate,
				"endDate":endDate
				}),
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if(data!=1){
					alert("保险期间不能大于一年!");
					return;
				}else{
					fom.action = "${basePath}/insurePolicy/getPlaceValueBatch";
			 		fom.target = "mainFrame";
					fom.submit();
				}
			},
			error : function() {
				alert("日期校验失败！")
				return;
			}
		});
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
	return iDays+1 ;
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
		document.getElementById("sumAmountTEMP").value=gg*gs;
	}
	
	function checkZus(){
		var inName = document.getElementById("alName").value;
	    if(inName.trim()==""){
			return false;
	    }
	    
		var inLinkName = document.getElementById("alLinkName").value;
	    if(inLinkName.trim()==""){
			return false;
	    }
		var inAddress = document.getElementById("alAddress").value;
	    if(inAddress.trim()==""){
			return false;
	    }
// 		var inEmail = document.getElementById("inEmail").value;
// 	    if(inEmail.trim()==""){
// 			return false;
// 	    }
		var inTelePhone = document.getElementById("alTelePhone").value;
	    if(inTelePhone.trim()==""){
			return false;
	    }
		var alName = document.getElementById("inName").value;
	    if(alName.trim()==""){
			return false;
	    }
		var alLinkName = document.getElementById("inLinkName").value;
	    if(alLinkName.trim()==""){
			return false;
	    }
		var alAddress = document.getElementById("inAddress").value;
	    if(alAddress.trim()==""){
			return false;
	    }
// 		var alEmail = document.getElementById("alEmail").value;
// 	    if(alEmail.trim()==""){
// 			return false;
// 	    }

		var alTelePhone = document.getElementById("inTelePhone").value;
	    if(alTelePhone.trim()==""){
			return false;
	    }
	   
		var alBusinessLicenseNo = document.getElementById("inBusinessLicenseNo").value;
	    if(alBusinessLicenseNo.trim()==""){
			return false;
	    }
	    
	    return true;
	}
		
	/** 校验社会统一信用代码**/
	function checkBusinessLienseNo(label) {
		var regex = /[^_IOZSVa-z\W]{2}\d{6}[^_IOZSVa-z\W]{10}/;
		var businessLienseNo = label.value;
		
		if(!regex.test(businessLienseNo)) {
			alert("无效的社会统一信用代码");
			label.value = "";
			label.onfocus;
			return false;
		}
	}
  </script>
  </body>
</html>
