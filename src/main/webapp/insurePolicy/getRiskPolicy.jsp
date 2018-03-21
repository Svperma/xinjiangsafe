<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<script type="text/javascript" src="${basePath }/js/policy.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath }/etpcss/style.css">
<link rel="stylesheet" type="text/css" href="${basePath }/css/tab-tou.css">
<html>
<body>
	<form action="" enctype="multipart/form-data" method="post" name="fom">
		<div class="maincont_mid_cont_right" style="height:600px;">
			<input type="hidden" id="riskCode" name="riskCode" value="${Rcode }" /> 
			<input type="hidden" id="insureCode" name="insureCode" value="" /> 
			<input type="hidden" id="areaCode" name="areaCode" value="${Acode }" />
			<div class="tbxy-body">
			<p class="tbxy-body-p">为了维护您的合法权益，根据《中华人民共和国保险法》、《中华人民共和国民法通则》等法律要求，请您知晓以下事项：</p>
			<table class="tbxy-body-tab">
				<tr>
					<td><span class="xing-red">*</span></td>
					<td><a href="#">网上投保注意事项</a></td>
					<td class="width-td">我已认真阅读《网上投保注意事项》,充分理解并接受相关内容</td>
					<td><input id="agFlag" type="checkbox" value="" /></td>
					
				</tr>
<!-- 				<tr> -->
<!-- 					<td><span class="xing-red">*</span></td> -->
<!-- 					<td><a href="#">保险条款</a></td> -->
<!-- 					<td class="width-td">我已认真阅读《新疆维吾尔族自治区安全生产责任保险产品保险条款》,并同意签署</td> -->
<!-- 					<td><input name="agFlag" type="checkbox" value="" /></td> -->
<!-- 				</tr> -->
			</table>
			<div class="tbxy-body-div">
				<h3 class="tbxy-body-div-h3" style="font-size: 18px;">网上投保注意事项</h3>
				<ul class="tbxy-body-div-ul" style="font-size: 18px;">
					<li>1、为简化投保手续，新疆安责险平台将根据您依法注册并取得授权的账户填录的企业（个人）基本信息和保险信息生成的电子投保单、人员清单及平台存储的资质证件作为订立保险合同的依据。</li>
					<li>2、在提交电子投保单前，请对填写内容进行复核，确认内容真实完整，看清楚选择的保险公司，<span class="font-weight">如果投保信息有不实告知，保险公司对发生的事故不承担赔偿或给付保险金责任。</span></li>
					<li>销售人员个人的口头或书面承诺并非保险合同的组成部分，<span class="font-weight">如果与投保单及保险条款等相关资料内容不一致，保险公司也不认可。</span></li>
				</ul>
			</div>
			<div class="btn-a" style="margin-top:20px;"><a style="cursor:pointer;" onclick="goPolicyPage()">我同意</a></div>
		</div>
		</div>
	</form>
</body>
<script type="text/javascript">
  function goPolicyPage(){
      if(document.getElementById("agFlag").checked == false){
    	  alert("您必须仔细阅读条款并同意才可继续投保!");
    	  return;
      }
	  $.ajax({
			type : "post",
			url : "${basePath }/insurePolicy/checkUser",
			data : JSON.stringify({
				"go" : "1",
			}),
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if(data == "1"){
					fom.action = "${basePath}/insurePolicy/getPoilcying";
			 		fom.target = "mainFrame";
					fom.submit();
				}else if(data == "2"){
					alert("已经存在有效的投保单，不能继续投保！");
					return false;
				}else{
					alert("请完善企业信息后再进行投保！");
					return false;
				}
			},
			error : function() {
				alert("查询企业信息失败！");
				return false;
			}
		});
  }
  function getElementCount(fieldName) {
    var count = 0;
    count = document.getElementsByName(fieldName).length;
    return count;
 }
  </script>
</html>
