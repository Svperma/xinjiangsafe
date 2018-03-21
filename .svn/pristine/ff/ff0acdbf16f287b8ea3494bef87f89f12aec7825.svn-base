<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="${basePath }/etpcss/style.css">
<link href="${basePath }/etpcss/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap-datetimepicker.js"></script>   
<script type="text/javascript" src="${basePath }/js/card.js"></script>   
<html>
  <body>
  <form action="${basePath}/insurePolicy/getPlaceValue" enctype="multipart/form-data" method="post" name="fm">
  <div class="maincont_mid_cont_right" style="height:600px;">
  	<table id="sonTab" cellpadding="0" cellspacing="0"  width="100%" border="0" style="margin-top: 10px;">
        <tr class="table_lista">
          	<td align=center>序号</td>
         	<td align=center><input id="letSon" name="letSon" type="checkbox" onclick="changeFalg()"></td>
         	<td align=center>员工姓名</td>
		  	<td align=center>身份证号</td>
        </tr>
        <c:forEach items="${ggEmployeeList }" var="fList" varStatus="rowIndex">
      	  <tr <c:if test="${rowIndex.count%2==0 }">class="table_listb"</c:if>>
      	  <td align=center>${rowIndex.index+1 }</td>
      	  <td ><input name="checkboxSelect" <c:if test="${fList.validStatus == 6}">checked="checked"</c:if> type="checkbox"></td>
          <td align=center><input type="text" name="emName" style="height: 30px;margin-top: 10px;" value="${fList.emName }">
          </td>
          <td align=center><input type="text" name="identityNo" style="height: 30px;width: 150px;margin-top: 10px;" value="${fList.identityNo }">
          </td>	
          </tr>
        </c:forEach>
      </table>
      <div class="maincont_mid_cont_right_bot" style="width:90%;text-align:center;padding:5px;float:left;">
      	<div style="width:300px;margin:0 auto;">
		  <a style="cursor:pointer;width: 80px;height: 22px;padding: 5px 0px;" onclick="selectPep()">选择</a>
		  <a style="cursor:pointer;width: 80px;height: 22px;padding: 5px 0px;" onclick="addSon()">新增</a>
		  <a style="cursor:pointer;width: 80px;height: 22px;padding: 5px 0px;" onclick="cancelSelect()">取消</a>
		</div>
	  </div>
  </div>
  </form>
    <script type="text/javascript">
    function isRepeat(arr){  
        var hash = {};  
        for(var i in arr) {  
        if(hash[arr[i]])  
	        return true;  
	        hash[arr[i]] = true;  
        }  
        return false;  
    }  
    
    function changeFalg(){
    	var fl = document.getElementById("letSon").checked;
    	if(fl==true){
    		for(var i=0;i<fm.checkboxSelect.length;i++){
    			fm.checkboxSelect[i].checked = true;
    		}
    	}else{
    		for(var i=0;i<fm.checkboxSelect.length;i++){
    			fm.checkboxSelect[i].checked = false;
    		}
    	}
 	}
    function selectPep(){
	  var count = getElementCount('checkboxSelect'); 
	  var sonIndex = 0;
	  var Peps="";
	  var sons = 0;
	  if(count == "") {
	    alert("请选择要操作的数据!");
	    return false;
	  }else {
	    var n = 0;
	    var arr=new Array();
	    for(var fg=0;fg<fm.checkboxSelect.length;fg++){
	    	arr[fg] = document.getElementsByName("identityNo")[fg].value;
	    }
	    if(isRepeat(arr)){
	    	alert("存在相同的身份证号码，请修改后重试!");
	    	return false;
	    }
	    for(var i=0;i<fm.checkboxSelect.length;i++){
	      if(fm.checkboxSelect[i].checked == true){
	        n = n+1;
	        sonIndex = i;
	        var emName = document.getElementsByName("emName")[sonIndex].value;
	        if(emName==""){
	        	alert("所选员工名字不能为空!");
	    	    return false;
	        }
	        var identityNo = document.getElementsByName("identityNo")[sonIndex].value;
	        if(!checkCard(identityNo,i+1)){//身份证校验
	        	return false;
	        }
	        Peps+=emName+","+identityNo+";";
	        sons++;
	      }
	    }
	  }
	  var gg = window.parent.opener.document.getElementById("amount").value;
	  var sumAt = 0;
	  sumAt = sons*gg;
	  window.parent.opener.document.getElementById("sumAmount").value=sumAt;
	  window.parent.opener.document.getElementById("pepSum").value=sons;
	  window.parent.opener.document.getElementById("pepSums").value="";
	  window.parent.opener.document.getElementById("pepSums").value=Peps;
	  window.parent.close();
 }
 function addSon(){
	 var count = getElementCount('checkboxSelect'); 
	 var obj = document.getElementById("sonTab");
	 var tr = document.createElement("tr");
	 var td1 = document.createElement("td");
	 td1.setAttribute("align","center");
	 td1.innerHTML=count+1;
	 var td2 = document.createElement("td");
	 td2.setAttribute("align","center");
	 var box = document.createElement("input");
	 box.setAttribute("type","checkbox");
	 box.setAttribute("name","checkboxSelect");
	 box.setAttribute("checked","checked");
	 td2.appendChild(box);
	 var td3 = document.createElement("td");
	 td3.setAttribute("align","center");
	 var input1 = document.createElement("input");
	 input1.setAttribute("type","text");
	 input1.setAttribute("name","emName");
	 input1.setAttribute("style","height: 30px;margin-top: 10px;");
	 var inputg = document.createElement("input");
	 inputg.setAttribute("type","hidden");
	 inputg.setAttribute("name","busNo");
	 td3.appendChild(input1);
	 td3.appendChild(inputg);
	 var td4 = document.createElement("td");
	 td4.setAttribute("align","center");
	 var input2 = document.createElement("input");
	 input2.setAttribute("type","text");
	 input2.setAttribute("name","identityNo");
	 input2.setAttribute("style","height: 30px;width: 150px;margin-top: 10px;");
	 td4.appendChild(input2);
	 tr.appendChild(td1);
	 tr.appendChild(td2);
	 tr.appendChild(td3);
	 tr.appendChild(td4);
	 obj.appendChild(tr);
 }
 function cancelSelect() {
  	window.parent.close();
 }
 function getElementCount(fieldName) {
    var count = 0;
    count = document.getElementsByName(fieldName).length;
    return count;
 }
  </script>
  </body>
</html>
