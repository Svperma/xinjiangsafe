<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<link href="${basePath }/css/styleCopy.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${basePath }/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath }/js/readXml.js"></script>
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<script type="text/javascript" src="/js/select2cssCopy.js"></script>
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
       	<div class="neicont_img"><img src="images/icotit1.jpg">企业查询</div>
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
							<option value="" selected="selected">选择是否投保</option>
								<option value="0">已投保</option>
								<option value="1">未投保</option>
						</select>
					</div>
			</div>
		<input id="qiyeming" name="qiyeming" class="select_list_inputa"
					style="height: 28px;  width: 150px; margin-left: -245px;" type="text" maxlength="20" value="请输入企业名称"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: rgb(153, 153, 153);"/>
		<input id="xinyongdaima" name="xinyongdaima" class="select_list_inputa"
					style="height: 28px;  width: 150px;" type="text" maxlength="20" value="请输入信用代码"
					onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: rgb(153, 153, 153);"/>
		</div>
		<div  class="select_list_all">
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
						<select name="inserdCode" id="inserdCode">
							<option value="" selected="selected">保险公司</option>
							<c:forEach items="${list_CICompanycode}" var="gginsurerconfig" varStatus="st">
								<option value="${gginsurerconfig.insuranceCode }">${gginsurerconfig.insuranceName }</option>
							</c:forEach>
						</select>
					</div>
			</div>
			<div class="select_list" style="margin-left:30px;">
					<a href="javascript:queryPreventive();">查询</a>
				</div>
				<div class="select_list">
					<a class="select_list_alink" href="javascript:exportExcel();">报表下载</a>
				</div>
			</div>
		</form>
	</div>
</div> 
	<iframe name="resultFrame" style="background-color:#F1F1F1;margin-top:10px;" src="/dsmanager/companyQueryResult.jsp" width="100%" frameborder="0" height="100%">
	</iframe>
<script type="text/javascript">
	/* 查询方法 */
	function queryPreventive(){
		var url = "${basePath }/dsmanager/companyQueryResult";
		var form = document.forms["fm"];
		form.action = url;
		form.submit();
	}
</script>
<script type="text/javascript">
	function exportExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/dsmanager/exportCompany";
		fm.submit();
	}
</script>
  </body>
</html>
