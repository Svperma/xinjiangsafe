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
<script type="text/javascript" src="${basePath }/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
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
       	<div class="neicont_img"><img src="images/icotit1.jpg">综合报表</div>
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
			<input type="text" style="width:150px;height: 30px;margin-left: -449px;" name="startDate" id="startDate"
			 onclick="WdatePicker({dateFmt:'yyyy/MM/dd'});" value="选择开始日期" class="select_list_inputa Wdate">
			<input type="text" style="width:150px;height: 30px;" name="endDate" id="endDate" 
			onclick="WdatePicker({dateFmt:'yyyy/MM/dd'});" value="选择结束日期" class="select_list_inputa Wdate">
		</div>
		<div  class="select_list_all">
				
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
				<div class="select_list">
					<a class="select_list_alink" href="javascript:exportExcel();">报表下载</a>
				</div>
			</div>
		</form>
	</div>
</div> 
<script type="text/javascript">
	function exportExcel() {
		var fm = document.forms["fm"];
		fm.action = "${basePath}/dsmanager/exportGarbage";
		fm.submit();
	}
</script>
  </body>
</html>
