<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Succee.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
 	
 	<form id="form1" runat="server" action="${basePath }evaluateDangers/select_riskRatingInfo" method="GET" >  
       <!--  <div id='div1'> 
         保存成功 <br> 
        </div>  
    </form>   -->
  
   <div id="div1" style="width:100%;height:100%;position:absolute;top:0px;left:0px;">
<div style="width:600px;height:400px;position:absolute;top:100px;left:30%;z-index:100; border:#999 1px solid;text-align:left;padding-left:50px;background-color:#CCC;">
	<p>1.基本条款</p>
    <p>2.附加条款</p>
    <p>3.法定条款</p>
    <p>4.任意条款</p>
    <p>5.霸王条款</p>
    <!-- <div style="margin-bottom:0px;text-align:center;height:30px;">
    	<input type="checkbox" onClick="disApp(this)">我已阅读并同意此条款&nbsp;&nbsp;
    	<input type="checkbox" onClick="disApp(this)">我不同意此条款<a class="table_buttonb" href="javascript:history.go(-1);"></a>
    </div> -->
</div>
</div>
</form>
</body>
<script type="text/javascript">  
function disApp(o){
		if(o.checked){
			/* document.getElementById("div1").style.display = "none"; */
			 document.getElementById("warning").style.display = "none"; 
		}
	}

//设定倒数秒数  
var t = 10;  
//显示倒数秒数  
function showTime(){  
    t -= 1;  
    document.getElementById('div1').innerHTML= t;  
    if(t==0){  
        location.href='${basePath }/usercorp/select_riskRatingInfo';  
    }  
    //每秒执行一次,showTime()  
    setTimeout("showTime()",1000);  
}  
  
  
//执行showTime()  
showTime();  
</script>  
</html>

