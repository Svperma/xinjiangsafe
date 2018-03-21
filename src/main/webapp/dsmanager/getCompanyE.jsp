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
<html>
  <body style="height:100%;background:#fff;">
  <form action="" enctype="multipart/form-data" method="post" name="fom">
  <div class="maincont_mid_cont_right">
	 <div class="tab-top-div">
		<table class="nav-tab">
			<tr>
				<td colspan="3" class="bg-tab-ddd">地区企业数量维护</td>
			</tr>
			<tr>
				<c:forEach items="${xinjiang }" var="mList" varStatus="listS">
					<td colspan="2" >${mList.PROVINCE }企业总数</td>
					<td colspan="1" >
						<input style="width: 300px;height: 50px;" readonly="readonly" id='zongshu' name='zongshu' value='${mList.COMPANY_SUM }' />
						<input type="hidden" value='${mList.AREA_CODE }' name='areaCode'/>
					</td>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="2" class="bg-tab-ddd">区县</td>
				<td colspan="1" class="bg-tab-ddd">企业总数</td>
			</tr>
			<c:forEach items="${chengshi }" var="managerList" varStatus="listSize">
				<tr>
					<td colspan="2">${managerList.PROVINCE }</td>
					<td colspan="1"><input style="width: 300px;height: 30px;" name='sumes' onmouseout="checkNum(${listSize.index });" value='${managerList.COMPANY_SUM }' />
					<input type="hidden" value='${managerList.AREA_CODE }' name='codeCode'/>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" >
					<div class="maincont_mid_cont_right_bot" >
						<a style="cursor:pointer; margin: auto;width: 108px;height: 22px;float: none;" onclick="goZus()">提交</a>
						<a style="cursor:pointer; margin: auto;width: 108px;height: 22px;float: none;" onclick="history.go(-1)">返回</a>
					</div>
				</td>
			</tr>
		</table>
		</br>
		</br>
	 </div>
	</div>
  </form>
    <script type="text/javascript">
    function checkNum(o){
    	var tempv = document.getElementsByName('sumes')[o].value;
		if(""==tempv){
    		alert("请输入数字！");
    		return;
    	}
		if(parseInt(tempv)!=tempv){
			alert("请输入整数！");
			return;
		}
		var index = document.getElementsByName('sumes').length;
		var sumNo = 0;
    	for(var i=0;i<index;i++){
    		var temp = document.getElementsByName('sumes')[i].value;
    		sumNo=sumNo+parseInt(temp);
    	}
    	document.getElementById('zongshu').value=sumNo;
    }
    function goZus(){
    	var index = document.getElementsByName('sumes').length;
    	for(var i=0;i<index;i++){
    		var tempv = document.getElementsByName('sumes')[i].value;
    		if(""==tempv){
        		alert("请输入数字！");
        		return;
        	}
    		if(parseInt(tempv)!=tempv){
    			alert("请输入整数！");
    			return;
    		}
    	}
		fom.action = "${basePath}/dsmanager/conmpanySumAdd";
		fom.target = "mainFrame";
		fom.submit();
  	}

  </script>
  </body>
</html>
