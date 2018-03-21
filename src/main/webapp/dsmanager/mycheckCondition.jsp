<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE >
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.form.js"></script>
<link href="${basePath }/css/styleCopy.css" type="text/css" rel="stylesheet">
<link href="${basePath }/css/WdatePicker.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${basePath }/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath }/js/readXml.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<script type="text/javascript" src="/js/select2cssCopy.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${basePath }/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
		<link href="${basePath }/css/1.css"rel="stylesheet">
		<link href="http://www.jq22.com/jquery/font-awesome.4.6.0.css"rel="stylesheet">
		<link rel="stylesheet" type="text/css" media="all" href="${basePath }/css/daterangepicker-bs3.css"/>
		<script type="text/javascript" src="${basePath }/js/moment.js"></script><!-- - 触发事件 -- -->
		<script type="text/javascript" src="${basePath }/js/daterangepicker.js"></script>
<html>
<head>
  <base href="<%=basePath%>">
</head>
<script type="text/javascript">
 

function getBusinessClassByClassCode(upperId,id){
	var classCode = $j("#"+upperId).val();
	if(classCode == null || classCode == ""){
		alert("请选择行业大类");
		return;
	}
	$j("#"+id).length = 1;
	$j.ajax({
		type:"get",
		url:"/codeControl/getGgCodeByObj?codeType=IndustryType&remark="+classCode,
		data:{},
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		success:function(data){
			var select = $j("#"+id);
			var ul = $j("#options_"+id);
			document.getElementById("select_info_" + id).innerHTML = "选择行业小类";
			$j(ul).empty();
			document.getElementById(id).length = 1;
			$j(ul).append("<li class='open_selected' style='cursor:pointer'>选择行业小类</li>");
			for(var i=0;i<data.length;i++){
				var op = document.createElement("option");
				op.value = data[i].codeCode;
				op.text = data[i].codeCName;
				$j(select).append(op);
				var li = document.createElement("li");
				$j(li).attr("class","open");
				$j(li).attr("id","selected_languageh");
				$j(li).css("cursor","pointer");
				li.onmouseover = function() {
					this.style.color = "#fff";
					this.style.backgroundColor = "#1ec2ff";
				};
				li.onmouseout = function() {
					this.style.color = "#79A2BD";
					this.style.backgroundColor = "";
				};
				li.onclick = function() {
					document.getElementById("select_info_" + id).innerHTML = this.innerHTML;
					var indexs = $j(this).index();
					$j("#" + id).get(0).selectedIndex = indexs; //设置Select索引值为1的项选中 
				};
				li.innerHTML = data[i].codeCName;
				$j(ul).append(li);
			}
		},
		error:function(){
			alert("error")
		}
	});
}
 </script>
 <body>
   <input type="hidden" id="province" value="${sessionScope.ggUser.province }">
<input type="hidden" id="city" value="${sessionScope.ggUser.city }">
<input type="hidden" id="county" value="${sessionScope.ggUser.county }">
<input type="hidden" id="comLevel" value="${sessionScope.ggUser.comLevel }">
   	<div class="neicont_main_left_cont">
       	<div class="neicont_img"><img src="images/icotit1.jpg">保单查询</div>
           <div class="neicont_main_left_cont_main">
           <form action="${basePath }/dsmanager/queryPreventive" name="fm" id="fm" method="post" target="resultFrame">
	           <div class="select_list_all">
	           		<div class="select_list" id="c_province1" onclick="findArea('province','province',1,'province1','city1')">
	           			<div id="uboxstyle">
	           					<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
								<input type="hidden" id="hidden_province1" name="hidden_province1"
								value="${sessionScope.province.codeCode }">
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
								<input type="hidden" id="hidden_province1" name="hidden_province1"
								value="">
								</c:if>
								<select name="province1" id="province1">
								<c:if test="${sessionScope.ggUser.comLevel >= 1 }">
								<option value="${sessionScope.province.codeCode }">
									${sessionScope.province.codeCName}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 1 }">
								<option value="选择省份">选择省份</option>
								</c:if>
								</select>
	           			</div>
	           		</div>
	           	<div class="select_list" id="c_city1" onclick="findArea('hidden_province1','city',2,'city1','county1')">
	          			 <div id="uboxstyle">
							<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
											<input type="hidden" id="hidden_city1" name="hidden_city1"
												value="${sessionScope.city.codeCode }">
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 2 }">
										<input type="hidden" id="hidden_city1" name="hidden_city1"
											value="">
							</c:if>
							<select name="city1" id="city1">
								<c:if test="${sessionScope.ggUser.comLevel >= 2 }">
									<option value="${sessionScope.city.codeCode }">${sessionScope.city.codeCName
										}</option>
								</c:if>
								<c:if test="${sessionScope.ggUser.comLevel < 2 }">
									<option value="选择城市">选择城市</option>
								</c:if>
							</select>
						</div>
				</div>
				<div class="select_list" id="c_county1"
					onclick="findArea('hidden_city1','county',3,'county1',null)" >
					<div id="uboxstyle">
						<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
							<input type="hidden" id="hidden_county1" name="hidden_county1"
								value="${sessionScope.county.codeCode }">
						</c:if>
						<c:if test="${sessionScope.ggUser.comLevel < 3 }">
							<input type="hidden" id="hidden_county1" name="hidden_county1"
								value="">
						</c:if>
						<select name="county1" id="county1">
							<c:if test="${sessionScope.ggUser.comLevel >= 3 }">
								<option value="${sessionScope.county.codeCode }">${sessionScope.county.codeCName}
								</option>
							</c:if>
							<c:if test="${sessionScope.ggUser.comLevel < 3 }">
								<option value="选择区县">选择区县</option>
							</c:if>
						</select>
					</div>
				</div>
				<div class="select_list">
						<div id="uboxstyle">
							<select name="whyInsure" id="whyInsure">
								<option value="" selected="selected" style="background:#fff;">请选择保单状态</option>
								<option value="1" style="background:#fff;">有效</option>
								<option value="0" style="background:#fff;">过期</option>
							</select>
						</div>
				</div>
				<div class="select_list" onclick="getBusinessClassByClassCode('classCode','businessClass')">
						<div id="uboxstyle">
							<select name="classCode" id="classCode">
								<option value="" selected="selected">选择行业大类</option>
								<c:forEach items="${list_classCode}" var="code" varStatus="st">
									<option value="${code.codeCode }">${code.codeCName }</option>
								</c:forEach>
							</select>
						</div>
				</div>
				<div class="select_list">
						<div id="uboxstyle">
							<select name="businessClass" id="businessClass" class="hiddenProperty">
								<option value="" selected="selected">选择行业小类</option>
							</select>
						</div>
				</div>
				<div class="select_list">
						<div id="uboxstyle">
							<select name="inserdCode" id="inserdCode" style="display:inline-block;">
								<option value="" selected="selected">保险公司</option>
								<c:forEach items="${list_CICompanycode}" var="gginsurerconfig" varStatus="st">
									<option value="${gginsurerconfig.insuranceCode }">${gginsurerconfig.insuranceName }</option>
								</c:forEach>
							</select>
						</div>
				</div>
				<div class="select_list_all"  style="text-align: center">
						<div class="select_list">
							<div id="uboxstyle">
								<select name="everone1" id="everone1" >
									<option value="" >选择每人最小保额</option>
									<option value="315295.92">315295.92元</option>
			                        <option value="400000">40万</option>
			                        <option value="500000">50万</option>
			                        <option value="600000">60万</option>
			                        <option value="700000">70万</option>
			                        <option value="800000">80万</option>
			                        <option value="900000">90万</option>
			                        <option value="1000000">100万</option>
								</select>
							</div>
						</div>
						<div class="select_list">
							<div id="uboxstyle">
								<select name="everone2" id="everone2">
									<option value="" >选择每人最大保额</option>
									<option value="315295.92">315295.92元</option>
			                        <option value="400000">40万</option>
			                        <option value="500000">50万</option>
			                        <option value="600000">60万</option>
			                        <option value="700000">70万</option>
			                        <option value="800000">80万</option>
			                        <option value="900000">90万</option>
			                        <option value="1000000">100万</option>
								</select>
							</div>
						</div>
					</div>
			</div>
			<div style="width:100%;text-align:left;">
				人数区 间:<input id="renshu1" name="renshu1" class="select_list_inputa" style="width: 80px" placeholder="最小数" value=""/>--
					  <input id="renshu2" name="renshu2" class="select_list_inputa" style="width: 80px" placeholder="最大数" value=""/>
				保费区间:<input id="baofei1" name="baofei1" class="select_list_inputa" style="width: 80px" placeholder="最小数" value=""/>--
					  <input id="baofei2" name="baofei2" class="select_list_inputa" style="width: 80px" placeholder="最大数" value=""/>
				
			</div>
			
			
			<div style="width:100%;text-align:left;">
				<input id="companyName" name="companyName" class="select_list_inputa"
					style="height: 28px;  width: 200px;" type="text"  placeholder="请输入企业名称"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"/>
				<input id="POLICYNO" name="POLICYNO" class="select_list_inputa"
					style="height: 28px;  width: 200px;" type="text"  placeholder="请输入保单号"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"/>
			
				<input type="text"  style="width: 200px"  name="reservation" id="reservation" 
						class="select_list_inputa " placeholder="保险起期"/> 
				<input type="text"  style="width: 200px"  name="reservation1" id="reservation1" 
						class="select_list_inputa " placeholder="保险止期"/> 
				
			</div>

			</div>
			<div class="select_list" style="width:100%;">
				<div class="select_list">
					<a href="javascript:queryPreventive();">查询</a>
				</div>
				<div class="select_list">
					<a class="select_list_alink" style="cursor: pointer;" onclick="goBBBBB()">批量导入保单</a>
				</div>
				<div class="select_list">
					<a class="select_list_alink" href="javascript:exportExcel();">报表下载</a>
				</div>
			</div>
			
		</div>
		
		</form>
	</div>
</div> 
	<iframe name="resultFrame" style="background-color:#F1F1F1;margin-top:10px;" src="/dsmanager/mycheckinitjj" width="100%" frameborder="0" height="100%">
	</iframe>
<script type="text/javascript">
	/* 查询方法 */
	function queryPreventive(){
		var renshu1 =  $j('#renshu1').val();
		var renshu2 =  $j('#renshu2').val();
		var baofei1 = $j('#baofei1').val();
		var baofei2 = $j('#baofei2').val();
		var everone1 = $j('#everone1').val();
		var everone2 = $j('#everone2').val();
		
		var shuzi = /^([1-9][0-9]*)$/;
		
		if((renshu1 != null && renshu1 != "") || (renshu2 != null && renshu2 != "")) {
			if (renshu1 == null || renshu1 == "") {
				alert("最小人数不能为空!");
				return false;
			}
			if(!shuzi.test(renshu1)) {
				alert("请输入大于0的整数");
				return false;
			}
			if (renshu2 == null || renshu2 == "") {
				alert("最大人数不能为空!");
				return false;
			}
			if(!shuzi.test(renshu2)) {
				alert("请输入大于0的整数");
				return false;
			}
			if (Number(renshu2) <= Number(renshu1)) {
				alert("最大人数应不小于最小人数");
				return false;
			}
			
		}
		
		var shuzi1 = /([1-9]\d*(\.\d*[1-9])?)|(0\.\d*[1-9])/;
		if((baofei1 != null && baofei1 != "") || (baofei2 != null && baofei2 != "")) {
			if (baofei1 == null || baofei1 == "") {
				alert("最小保费不能为空!");
				return false;
			}
			if(!shuzi1.test(baofei1)) {
				alert("请输入大于0的整数");
				return false;
			}
			if (baofei2 == null || baofei2 == "") {
				alert("最大保费不能为空!");
				return false;
			}
			if(!shuzi1.test(baofei2)) {
				alert("请输入大于0的整数");
				return false;
			}
			if (Number(baofei2) <= Number(baofei1)) {
				alert("最大保费应不小于最小保费");
				return false;
			}
			
		}
		if((everone1 != null && everone1 != "") || (everone2 != null && everone2 != "")) {
			if (everone1 == null || everone1 == "") {
				alert("最小每人保额不能为空!");
				return false;
			}
			if(!shuzi1.test(everone1)) {
				alert("请输入大于0的整数");
				return false;
			}
			if (everone2 == null || everone2 == "") {
				alert("最大每人保额不能为空!");
				return false;
			}
			if(!shuzi1.test(everone2)) {
				alert("请输入大于0的整数");
				return false;
			}
			if (Number(everone2) <= Number(everone1)) {
				alert("最大每人保额应不小于最小每人保额");
				return false;
			}
			
		}
		
		var url = "${basePath }/dsmanager/mycheckqueryjj";
		var form = document.forms["fm"];
		form.action = url;
		form.submit();
		
	}
	function goBBBBB(){
		var url = "${basePath }/dsmanager/goBBBBB";
		var form = document.forms["fm"];
		form.action = url;
		form.target = "mainFrame";
		form.submit();
	}
</script>
<script type="text/javascript">
	function exportExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/dsmanager/exportPolicy";
		fm.submit();
	}
	
	 $j(document).ready(function() {
			  $j('#reservation').daterangepicker(null, function(start, end, label) {
				console.log(start.toISOString(), end.toISOString(), label);
			  });
		   });
	 $j(document).ready(function() {
			  $j('#reservation1').daterangepicker(null, function(start, end, label) {
				console.log(start.toISOString(), end.toISOString(), label);
			  });
		   });
</script>
  </body>
</html>
