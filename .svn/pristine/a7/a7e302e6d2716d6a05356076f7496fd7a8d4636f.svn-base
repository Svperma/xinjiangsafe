<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'mypolicyShow.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="${basePath }/js/select2css.js"></script>
<link href="${basePath }/css/etpStyle.css" rel="stylesheet">
<link href="${basePath }/etpcss/bootstrap-combined.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${basePath }/css/tab-tou.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
</head>

<body style="height:100%;background:#fff;">
  <form action="" enctype="multipart/form-data" method="post" name="fom">
  <input type="hidden" id="businessno" value="<%= request.getAttribute("businessno")%>">
	<div class="maincont_mid_cont_right">
  	<div class="tab-top-div">
		<h2 class="title-h1">新疆维吾尔自治区安全生产责任保险&nbsp;&nbsp;<c:if test="${sessionScope.resultMap.POLICYNO != null }">保险单</c:if><c:if test="${sessionScope.resultMap.POLICYNO == null }">投保单</c:if></h2>
		<c:if test="${sessionScope.resultMap.POLICYNO != null }">
			<p class="title-p">保单号码:${sessionScope.resultMap.POLICYNO }</p>
		</c:if>
		<c:if test="${sessionScope.resultMap.ORDERNAME != null }">
			<p class="title-p">归属机构:${sessionScope.resultMap.GUISHU }</p>
			<p class="title-p">业务员:${sessionScope.resultMap.ORDERNAME }</p>
		</c:if>
		<c:if test="${sessionScope.resultMap.PAYBILLNO != null }">
			<a style="font-size: 15px;" target="_blank" href="${sessionScope.resultMap.PAYBILLNO }">查看电子保单</a>
		</c:if>	
		<table class="nav-tab">
			<tr>
				<td colspan="8" class="bg-tab-ddd">投保人信息</td>
			</tr>
			<tr>
				<td colspan="1">投保人名称</td>
				<td colspan="7">${tempUser.companyName }</td>
			</tr>
			<tr>
				<td colspan="2">联系地址</td>
				<td colspan="2">${tempUser.companyAddress }</td>
				<td colspan="2">邮箱</td>
				<td colspan="2">${tempUser.email }</td>
			</tr>
			<tr>
				<td colspan="2">联系电话</td>
				<td colspan="2">${tempUser.telephone }</td>
				<td colspan="2">联系人</td>
				<td colspan="2">${tempUser.linkName }</td>
			</tr>
			<tr>
				<td colspan="8" class="bg-tab-ddd">被保险人信息</td>
			</tr>
			<tr>
				<td colspan="2">被保险人名称</td>
				<td colspan="2">${tempUser.companyName }</td>
				<td colspan="2">邮箱</td>
				<td colspan="2">${tempUser.email }</td>
			</tr>
			<tr>
				<td colspan="2">联系电话</td>
				<td colspan="2">${tempUser.telephone }</td>
				<td colspan="2">联系人</td>
				<td colspan="2">${tempUser.linkName }</td>
			</tr>
			<tr>
				<td colspan="2">联系地址</td>
				<td colspan="2">${tempUser.companyAddress }</td>
				<td colspan="2">归属省份</td>
				<td colspan="2">${list_pro}</td>
			</tr>
			<tr>
				<td colspan="2">归属市</td>
				<td colspan="2">${list_city}</td>
				<td colspan="2">归属县区</td>
				<td colspan="2">${list_county}</td>
			</tr>
			<tr>
				<td colspan="2">行业类别</td>
				<td colspan="2">${list_classCode}</td>
				<td colspan="2">经营范围</td>
				<td colspan="2">${list_businessClass}</td>
			</tr>
			<tr>
				<td colspan="2">统一社会信用代码</td>
				<td colspan="2">${tempUser.businessLicenseNo }</td>
				<td colspan="2">安全生产许可证号</td>
				<td colspan="2">${tempUser.safetyLicenseNo }</td>
			</tr>
			<tr>
				<td colspan="2">从业人员人数</td>
				<td colspan="2">${resultMap.EMCOUNT }人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="maincont_mid_cont_right_bot" style="display:inline-block;">
						<a style="cursor:pointer;" onclick="goPep()">查看员工</a>
					</div>
				</td>
				<td colspan="2">安全标准化等级</td>
				<td colspan="2">${list_safe}
					<div class="maincont_mid_cont_right_bot" style="display:inline-block;">
						<a style="cursor:pointer;" href="${empty standardLevelImg ? '/images/duihuai.png' : standardLevelImg}" target="_blank">查看图片</a>
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
				<td rowspan="5">安全生产责任保险</td>
				<td colspan="3">每人死亡赔偿限额(元)</td>
				<td colspan="4">
					${resultMap.UNITAMOUNT }
				</td>
			</tr>
			<tr>
				<td colspan="3">每次事故赔偿限额(元)</td>
				<td colspan="4">${resultMap.SUMAMOUNT }</td>
			</tr>
			<tr>
				<td colspan="3">年度累计赔偿限额(元)</td>
				<td colspan="4">${resultMap.SUMAMOUNT }</td>
			</tr>
			<tr>
				<td colspan="3">每人残疾赔偿限额</td>
				<td colspan="4">每人残疾赔偿限额=本年度上推第二年度新疆城镇居民人均可支配收入×残疾程度对应的倍数×（实际投保死亡赔偿限额/最低死亡赔偿限额）</td>
			</tr>
			<tr>
				<td colspan="3">每次事故绝对免赔额</td>
				<td colspan="4">人身伤亡无免赔额</td>
			</tr>
			<tr>
				<td>保险费  ￥：</td>
				<td colspan="7">
					<c:forEach items="${sessionScope.pagination.resultList }" var="result" varStatus="th">
						<c:if test="${result.KINDCODE == '0901001' }">
							${result.SPREADSHEETPREMIUM }
						</c:if>
					</c:forEach>
				元</td>
			</tr>
			<tr>
				<td colspan="8" class="bg-tab-ddd">附加险：</td>
			</tr>
			<tr>
				<td colspan="1" class="text-bold">附加险种名称</td>
				<td colspan="3" class="text-bold">赔偿限额(元)</td>
				<td colspan="1" class="text-bold">保费(元)</td>
				<td colspan="3" class="text-bold">每次事故免赔额</td>
			</tr>
			<c:forEach items="${sessionScope.pagination.resultList }" var="result" varStatus="th">
			<c:if test="${result.KINDCODE == '0901002' }">
			<tr>
				<td colspan="1">附加第三者责任保险</td>
				<td colspan="3">每次事故及累计赔偿限额${result.AMOUNT }元，其中：每次事故每人人身伤亡赔偿限额与主险一致；
每次事故每人医疗费用赔偿限额为每人人身伤亡赔偿限额的30%；每次事故财产损失为每次事故及累计赔偿限额的50%；</td>
				<td colspan="1">${result.SPREADSHEETPREMIUM }</td>
				<td colspan="3">每人医疗费用免赔额为人民币500元；
财产损失免赔额为人民币500元</td>
			</tr>
			</c:if>
			</c:forEach>
			<c:forEach items="${sessionScope.pagination.resultList }" var="result" varStatus="th">
			<c:if test="${result.KINDCODE == '0901003' }">
			<tr>
				<td colspan="1">附加从业人员医疗费用保险</td>
				<td colspan="3">每人医疗费用赔偿限额为${result.UNITAMOUNT }元，医疗费用每次事故及累计赔偿限额为${result.AMOUNT }元;</td>
				<td colspan="1">${result.SPREADSHEETPREMIUM }</td>
				<td colspan="3">每人医疗费用免赔额为人民币500元。</td>
			</tr>
			</c:if>
			</c:forEach>
			<c:forEach items="${sessionScope.pagination.resultList }" var="result" varStatus="th">
			<c:if test="${result.KINDCODE == '0901004' }">
			<tr>
				<td colspan="1">附加救援费用保险</td>
				<td colspan="3">每次事故及累计赔偿限额为${result.AMOUNT }元;</td>
				<td colspan="1">${result.SPREADSHEETPREMIUM }</td>
				<td colspan="3">免赔额为人民币2000元。</td>
			</tr>
			</c:if>
			</c:forEach>
			<c:forEach items="${sessionScope.pagination.resultList }" var="result" varStatus="th">
			<c:if test="${result.KINDCODE == '0901005' }">
			<tr>
				<td colspan="1">附加法律费用保险</td>
				<td colspan="3">每次事故及累计赔偿限额为${result.AMOUNT }元;</td>
				<td colspan="1">${result.SPREADSHEETPREMIUM }</td>
				<td colspan="3">免赔额为人民币500元。</td>
			</tr>
			</c:if>
			</c:forEach>
			<tr>
				<td colspan="8">总保险费：${zbf }人民币（大写）：${zongbaofei }</td>
			</tr>
			<tr>
				<td colspan="2">保险期间</td>
				<td colspan="6">自<fmt:formatDate value='${sessionScope.resultMap.STARTDATE }' pattern='yyyy年MM月dd'/>日0时起 至<fmt:formatDate value='${sessionScope.resultMap.ENDDATE }' pattern='yyyy年MM月dd'/>日23：59止(以最终签发的保险单为准)为保证保险合同在拟定的保险起期生效，请您在保险起期前5个工作日前办理投保手续、提交投保资料并支付保费。如您未能按时办理投保手续或保费未能按时到账，导致保险合同未在拟定的保险起期生效，发生保险事故，本公司不承担保险责任。</td>
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
			<form >
			<tr>
				<td colspan="2" rowspan="2">批改内容</td>
				<td style="color: red;" colspan="5">${special.SPECIALPROVISIONS }
					<c:if test="${special.FLAG =='0' }">
						
						<div class="maincont_mid_cont_right_bot" style="width: 50%; display: inline;">
						<span>
							<a style="cursor:pointer; margin: auto;width: 108px;height: 22px;padding:5px 0px;float: none;text-align: center;" onclick="auditing('${special.BUSINESSNO}');">审核通过</a>
							<a style="cursor:pointer; margin: auto;width: 108px;height: 22px;padding:5px 0px;float: none;text-align: center;" onclick="audited('${special.BUSINESSNO}')">审核不通过</a>
						</span>
						<div class="maincont_mid_cont_right_bot" style="width: 100%; display: block;">
							批改意见：<input type="text" id="advice" name="advice" value="${special.ADVISE }" style="border: 1px blue solid; text-align: left;">
						</div>
					</c:if>
					<c:if test="${special.FLAG == '1' }">
						<c:if test="${special.PAYFLAG == '1' }">
							<c:if test="${empty special.CALCULATION}">
								<div class="maincont_mid_cont_right_bot" style="width: 80%;">
									<span style="color: blue;">保费变化量(批减为“-”)：</span><input type="text" value="" id="calculation" name="calculation" style="border: 1px blue solid; width: 200px;">
									<span style="color: blue;">批单号码：</span><input type="text" value="" id="endorsement" name="endorsement" style="border: 1px blue solid; width: 200px;">
									<a style="cursor:pointer; display: block;margin: auto;width: 108px;height: 22px;padding:5px 0px;float: none;text-align: center;" onclick="generate('${special.BUSINESSNO}');">确认</a>
								</div>
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${special.FLAG == '1' }">
						<c:if test="${special.PAYFLAG == '1' }">
							<c:if test="${not empty special.CALCULATION }">
								<div class="maincont_mid_cont_right_bot" style="width: 100%;">
									<span style="color: blue;">保费计算：</span><input type="text" value="${special.CALCULATION }" readonly="readonly" style="border: 1px blue solid; width: 200px;">
									<span style="color: blue;">批单号码：</span><input type="text" value="${special.ENDORSEMENT }" readonly="readonly" style="border: 1px blue solid; width: 200px;">
									<a style="cursor:pointer; display: block;margin: auto;width: 108px;height: 22px;padding:5px 0px;float: none;text-align: center;" onclick="defary('${special.BUSINESSNO}','${special.ENDORSEMENT }');">确认支付</a>
								</div>
							</c:if>
						</c:if>
					</c:if>
				</td>
			</tr>
			
		</table>
		<div style="text-align:left;">
        	<span style="display:inline-block;">争议解决方式：</span>
        				<div style="display:inline-block;width:200px;">
        				 <select id="toTalk" name="toTalk">
                            <option <c:if test="${resultMap.ARGUESOLUTION==1 }">selected</c:if> value="1">诉讼</option>
                            <option <c:if test="${resultMap.ARGUESOLUTION==2 }">selected</c:if> value="2">仲裁</option>
                         </select>
        				</div>
                        <c:if test="${resultMap.ARGUESOLUTION==2 }">
                        <div style="display:inline-block;width:100px;margin-left:2em;">
                        <input id="inp" name="toTalkName" class="select_list_inputa" type="text" maxlength="20" value="${resultMap.ARBITBOARDNAME }" readonly="readonly" style="float:none;height: 30px;">
                        </div>
        				</c:if>
        </div>   
		<div class="maincont_mid_cont_right_bot" style="width: 100%;">
			<a style="cursor:pointer; display: block;margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;" onclick="javascript:history.go(-1);">返回</a>
		</div>
		</br>
		</br>
	 </div>
	</div>
</body>
<script type="text/javascript">
	function interpret(id) {
		$.ajax({
					type : "post",
					url : "${basePath }/mypolicy/mypolicyinterpret?id=" + id,
					Date : {},
					dataType : "JSON",
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						$("#" + tr - div2).empty();
						$("#" + tr - div2)
								.HTML(
										"<tr><td>险种名称</td><td>每人保费</td><td>开始时间</td><td>结束时间</td><td>实际保费</td></tr>");
						for ( var i = 0; i <= data.length; i++) {
							var getis = data[i];
							var tr = document.createElement("tr");
							var td = document.createElement("td");
							td.innerHTML = getis.KINDNAME;
							td.innerHTML = getis.UNITPREMIUM;
							td.innerHTML = getis.STARTDATE;
							td.innerHTML = getis.ENDDATE;
							td.innerHTML = getis.ACTUALPREMIUM;

							$("#" + tr - div2).append(tr);
							$("#" + tr - div2).append(td);
						}
					},
				});
	}
	$(document).ready(function() {
		$("#a-td1").click(function() {
			$("#tr-div1").css("display", "block");
		})
	})
	$(document).ready(function() {
		$("#gb-a").click(function() {
			$("#tr-div1").css("display", "none");
		})
	})
	function goPep(){
		var businessno = document.getElementById("businessno").value;
		var url = "insurePolicy/getGuSon?businessno="+businessno;
		window.open(url, "", "height=600,width=600,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes,left=80");
	}
</script>
<script type="text/javascript">
	function auditing(id){
		var advice = document.getElementById("advice").value; 
		$.ajax({
			type:"post",
			dataType:"JSON",
			contentType : "application/json;charset=UTF-8",
			url : "${basegPath }/dsmanager/myapplyAudit?id=" + id,
			data : JSON.stringify({
				"advice": advice,
			}),
			success:function(data){
				if(data == "success"){
					alert("审核成功");
					location.reload([true]);   
				}else{
					alert("审核失败");
				}
			},
			error:function(XMLHttpRequest){
				alert(XMLHttpRequest.status);
			}
		});
	}
	
	function audited(id){
		var advice = document.getElementById("advice").value; 
		$.ajax({
			type:"post",
			dataType:"JSON",
			contentType : "application/json;charset=UTF-8",
			url : "${basePath }/dsmanager/myapplyAudited?id=" + id,
			data : JSON.stringify({
				"advice": advice,
			}),
			success:function(data){
				if(data == "success"){
					alert("提交成功");
				}else{
					alert("提交失败");
				}
			},
		error:function(XMLHttpRequest){
			alert(XMLHttpRequest.status);
		}
	});
	}
	//提交批单号码
	function generate(id){
		alert(1111);
		var calculation = document.getElementById("calculation").value;
		alert(2222);
		var endorsement = document.getElementById("endorsement").value;
		alert(3333);
		$.ajax({
			type:"post",
			dataType:"JSON",
			contentType : "application/json;charset=UTF-8",
			url:"${basePath }/dsmanager/myapplygenerate?id=" + id,
			data:JSON.stringify({
					"calculation":calculation,
					"endorsement":endorsement,	
					}),
			success:function(data){
				if(data == "success"){
					alert("提交成功");
					location.reload([true]);   
				}else{
					alert("提交失败");
				}
			},
			error:function(XMLHttpRequest){
				alert(XMLHttpRequest.status);
		}
	});
	}
	//确认支付
	function defary(id,endorsement){
		confirm(
			alert("确认完成支付？")
		);
		$.ajax({
			type:"post",
			dataType:"JSON",
			contentType : "application/json;charset=UTF-8",
			url:"${basePath }/dsmanager/myapplydefary",
			data:JSON.stringify({
					"id":id,
					"endorsement":endorsement,	
					}),
			success:function(data){
				if(data == "success"){
					alert("完成支付");
					location.reload([true]);   
				}else{
					alert("提交失败");
				}
			},
			error:function(XMLHttpRequest){
				alert(XMLHttpRequest.status);
		}
	});
	}

</script>

</html>
