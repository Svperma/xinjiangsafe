<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="net.fckeditor.*"%>
<%@ taglib uri="/WEB-INF/FCKeditor.tld" prefix="fck" %>
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>通知管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/calendar/WdatePicker.js"></script>
	<script type="text/javascript" src="/fckeditor/fckeditor.js"></script>
	<script type="text/javascript" src="/fckeditor/editor/js/fckeditorcode_ie.js"></script>
	<script type="text/javascript">
		window.onload = function(){
		 var ofckeditor = new FCKeditor("content");
		ofckeditor.BasePath = "${basePath}/fckeditor/";
		ofckeditor.Height = 400;
		ofckeditor.Width = 850;
		ofckeditor.ReplaceTextarea();
		}
		function getFCKeditorValue(editorName){
			var editor = FCKeditorAPI.GetInstance(editorName);
			return (editor.GetXHTML(true));
		}
		function SetEditorContents(EditorName, ContentStr) {
		   var oEditor = FCKeditorAPI.GetInstance(EditorName) ;
		   oEditor.SetHTML(ContentStr) ;
		}
	</script>
  </head>
  
  <body style="background:#FFFFFF;text-align: center;width:80%;">
    <div style="margin: 0px auto;padding:10px;width: 85%;">	
    <form action="" method="post" name="form1" id="form1" target="mainFrame">
	    	<div  id="addDiv" style="display: block;">
	    		<table>
	    		<tr>
	    			<td>类型：</td>
	    			<td style="padding:8px 0px">
	    			<select id="type" name="type" style="width:50%;">
	    				<option value="1">新闻动态</option>
	    				<option value="2">政策法规</option>
	    				<option value="3">专题报道</option>
	    				<option value="4">案例分析</option>
	    			</select><font size="2" color="red">&nbsp;&nbsp;*&nbsp;&nbsp;</font>
	    			</td></tr>
	    			<tr>
	    				<td>标&nbsp;&nbsp;&nbsp;&nbsp;题：</td>
	    				<td><input name="jgnotice.title" id="title" style="background:#ffffff;width: 80%;height:30px;font-size:16px"><font size="2" color="red">&nbsp;&nbsp;*&nbsp;&nbsp;(标题不能超过50个汉字!)</font></td>
	    			</tr>
	    			<tr>
	    				<td>内&nbsp;&nbsp;&nbsp;&nbsp;容：</td>
	    				<td style="padding:7px 0px">
	    					   <textarea rows="20" cols="60" name="jgnotice.content" id="content" style="width: 80%;"></textarea> 
	    				</td>
	    			</tr>
	    			<!-- <tr> </tr>
	    			<tr>
	    			<td>通知有效期至：</td>
	    			<td >
	    			<input name="notice.jsrq" id="da" type="text" value="" onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})" /> 
	    			</td></tr> -->
	    			
	    			<tr>
	    			<td></td>
	    				<td style="text-align:center">
	    				<div class="select_list_all" style="padding:10px;widht:100%;float:left">
	    				<div class="select_list" style="margin:0 0 0 250px;">
	    					<a href="javascript:void(0)" onclick="add()">发送</a>
	    				</div>
	    				<div class="select_list" style="align:center">
	    					<a href="${basePath }/jianguan/notice/getNotice">返回</a>
	    				</div>
	    				</div>
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
	    </form>	
	    <form action="" method="post" name="form2" id="form2">
	  		
    	</form>
    	</div>
  </body>
  <script type="text/javascript">
  	function add(){
  		var title = document.getElementById("title").value;
  		var content = getFCKeditorValue("content");
  		var usercode=$("#code").val();
  		if(usercode=="" || usercode==null ){
  			alert("收件人不能为空！");
  			return;
  		}
  		if(usercode=="请选择"){
  			alert("请选择收件人！");
  			return;
  		}
  		if(title == "" || title == null){
  			alert("标题不能为空！");
  			return;
  		}else if(title.length > 50){
  			alert("标题不能超过50个汉字！");
  			return;
  		}
  		if(content == "" || content == null){
  			alert("内容不能为空！");
  			return;
  		}else if(content.length > 10000){
  			alert("内容不能超过4000个汉字！");
  			return;
  		}
  		form1.action="${basePath}/jianguan/notice/addNotice"
  		form1.submit();
  	}

	function getDiv(){
		var div = document.getElementById("person");
		var divHeight = 400;
		var divWidth = 500;
		var divTop = (document.body.offsetHeight - divHeight) / 2;
		var divLeft = (document.body.offsetWidth - divWidth) / 3;
		div.style.top = divTop+"px";
		div.style.left = divLeft+"px";
		div.style.display = "block";
		getUser();
	}
	function  getUser(){
		
		$.ajax({
				type:"post",
				url:"${basePath}/jianguan/notice/getUser",
				datetype:"json",
				success:function(data){
				 var result=eval("(" + data + ")");
				 var u=result.u;
				 var div = document.getElementById("userdiv");
				 div.innerHTML="";
				 document.getElementById("selectall").checked=false;
				 for ( var i = 0; i < u.length; i++) {
						var itemObject = u[i];
							var sdiv=document.createElement("div");  
							var input=document.createElement("input");  
							input.type="checkbox";
							input.name="usercode";
							input.id="usercode";
							input.value=itemObject.usercode;
	               			sdiv.appendChild(input);
	               			sdiv.style.height = "20px";  
			                sdiv.style.width = "200px";  
			                sdiv.style.float = "left";  
			                sdiv.style.margin = "10px";  
			                sdiv.style.align = "center";  
			                if(itemObject.role==1){
			                	itemObject.role="财政部门";
			                }else{
			                	itemObject.role="农业部门";
			                }
			                var area=0;
			                if(itemObject.town==null){
				                if(itemObject.county==null){
				                	area=itemObject.city;
				                	if(itemObject.city==null){
				                		area=itemObject.province;
				                	}
				                }else{
				                	area=itemObject.county;
				                }
				             }else{
				                	area=itemObject.town;
				                }
			                /* if(itemObject.city==null){
			                	area=itemObject.province;
			                }else{
			                	area=itemObject.city;
			                } */
							sdiv.appendChild(document.createTextNode(area+"   \t    "+ itemObject.role+"   \t    "+ itemObject.username));
							div.appendChild(sdiv);
					}
				 }
			
			});
	}
	
	function selectAll(){
		var check=document.getElementsByName("usercode");
		if(document.getElementById("selectall").checked){
			for(var i=0;i<check.length;i++){
				check[i].checked=1;
			}
		}else{
			for(var i=0;i<check.length;i++){
				check[i].checked=0;
			}
		
		}
	}
	function ok(){
		var check=document.getElementsByName("usercode");
		document.getElementById("code").value="";
		var value="";
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				value+=check[i].value+",";
			}
		}
		if(value=="请选择"){
			document.getElementById("code").value=value;
		}else{
			document.getElementById("code").value=value.substring(0,value.length-1);
		}
		close();
	}
	function close(){
		var div = document.getElementById("person");
		div.style.display = "none";
	}
	function Cancel(){
		var div = document.getElementById("person");
		div.style.display = "none";
	}
  </script>
</html>
