<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<link href='${basePath }/ueditor/themes/default/css/ueditor.css' type="text/css" rel="stylesheet" >  
<script type="text/javascript" src="${basePath }/ueditor/ueditor.config.js"></script>    
<script type="text/javascript" src="${basePath }/ueditor/ueditor.all.min.js"></script>    
<script type="text/javascript" src="${basePath }/ueditor/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
        div{
            width:100%;
        }
    </style>
<style>
.button bg-blue margin-left {
	background: white;
}
</style>
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form class="form-x" action="${basePath }/edit/addNewsandTrends" name="fma" id="fma" method="POST"
				style="position:relative;" enctype="multipart/form-data">
				<div class="form-group">
				</div>

				<!-- <div class="form-group">
					<div class="label">
						<label>期数：</label>
					</div>
					<div class="field">
						<select name="expectNo" id="expectNo" class="input w50">
							<option value="">请选择期数</option>
							<option value="0">当前最新期</option>
							<option value="1">新添加一期</option>
						</select>
						<div class="tips"></div>
					</div>
				</div> -->

				<!-- <div class="form-group">
					<div class="label">
						<label>显示位置：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="DISPLAYNO" 
							id="DISPLAYNO" data-validate="required:请输入页面显示的位置" />
						<div class="tips"></div>
					</div>
				</div> -->

				<div class="form-group">
					<div class="label">
						<label>分类标题：</label>
					</div>
					<div class="field">
						<select name="cid" id="cid" class="input w50">
							<option value="">请选择分类</option>
							<c:forEach items="${typeList }" var="docpe" varStatus="dt">
								<option value="${dt.index+1 }">
									<tlds:name codeType="docType" codeCode="${docpe.codeCode }" />
								</option>
							</c:forEach>
						</select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>标题：</label>
					</div>
					<div class="field">
						<input type="text" class="input w100" value="" name="title"
							id="title" data-validate="required:请输入标题" /> 
						<input type="text" class="input w100" value="" name="docType" id="docType"
							data-validate="required:请输入标题" style="display: none;"/>
						<div class="tips"></div>
					</div>
				</div>

				<if condition="$iscid eq 1">
				<!-- <div class="form-group">
					<div class="label">
						<label for="readme">
							描述：</label>
					</div>
					<div class="field">
						<textarea class="input" rows="5" cols="50" name="DECRIPTION" id="DECRIPTION" placeholder="简单描述一下新闻" onblur="queryDECRNum(this);"></textarea>
						<span style="color: red;">限定200字以内</span>
					</div>
				</div> -->
<!-- 				<div> -->
<!-- 				    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script> -->
<!-- 				</div> -->
				<div class="form-group">
					<div class="label">
						<label for="readme">
							内容：</label>
					</div>
					<div class="field">
					 	<script id="content" name="content" type="text/plain" style="width:1024px;height:500px;"></script>	
<!-- 						<textarea class="input" rows="5" cols="50"  -->
<!-- 						style="height:200px; border:1px solid #ddd;"  -->
<!-- 						name="content" id="content" placeholder="" onblur="queryContentNum(this);"></textarea> -->
<!-- 						<span style="color: red;">限定2000字以内</span> -->
<!-- 						<input type="hidden" name="content" id ="content" value="" /> -->
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>图片：</label>
					</div>
					<div class="field">
						<select name="nodis" id="nodis" class="input w50" onchange="nois();">
							<option value="">是否添加图片</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select> 
						<input type="file" class="button bg-white margin-left" id="photo" name="photo" value="+ 浏览上传"
							style="float:left;margin-left: 100px;display: none;">
						<div class="tipss" id="photozi" style="display: none;">图片尺寸：500*500</div>
					</div>
				</div>
				</if>
				
				<div class="clear"></div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<a class="button bg-main icon-check-square-o"
							href="javascript:submit();">提交</a> 
						<a class="button bg-main icon-check-square-o"
							href="javascript:history.go(-1);">返回</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	var ue = UE.getEditor('content');
	function queryContentNum(o) {
		var val = o.value;
		$.ajax({
			type : "get",
			url : "/edit/queryContentNum?contentNum=" + val,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("内容超限，请修改");
// 					o.value = "";
					o.focus();
				}

			},
			error : function() {
				alert("请稍后再试");
			}
		});
	}
	function queryDECRNum(o) {
		var val = o.value;
		$.ajax({
			type : "get",
			url : "/edit/queryDECRNum?DECRNum=" + val,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("内容超限，请修改");
// 					o.value = "";
					o.focus();
				}

			},
			error : function() {
				alert("请稍后再试");
			}
		});
	}
	function nois() {
		var nodis = document.getElementById("nodis").value;
		if ((nodis != null && nodis != "") && (nodis != "0")) {
			document.getElementById("photo").style.display = "";
			document.getElementById("photozi").style.display = "";
		} else {
			document.getElementById("photo").style.display = "none";
			document.getElementById("photozi").style.display = "none";
		}
	}
	function submit() {
// 		var s_ishome = document.getElementById("s_ishome").value;
// 		var s_isvouch = document.getElementById("s_isvouch").value;
// 		var s_istop = document.getElementById("s_istop").value;
		var title = document.getElementById("title").value;
		var photo = document.getElementById("photo").value;
		var cid = document.getElementById("cid").value;
// 		var expectNo = document.getElementById("expectNo").value;
// 		var displayNo = document.getElementById("DISPLAYNO").value;
// 		var decription = document.getElementById("DECRIPTION").value;
		var content = document.getElementById("content").value;
		var nodis = document.getElementById("nodis").value;

// 		if (s_ishome == "" && s_isvouch == "" && s_istop == "") {
// 			alert("请选择至少一个属性");
// 			return;
// 		} if (s_ishome == "" || s_ishome == "0") {
// 			if (s_isvouch == "" || s_isvouch == "0") {
// 				if (s_istop == "" || s_istop == "0") {
// 					alert("请选择至少一个属性!");
// 					return;
// 				}
// 			}
// 		} 
		/* if (expectNo == "") {
			alert("请选择期数");
			return;
		} */ /* if (displayNo == "" || displayNo == "0") {
			alert("请输入要显示的位置(应不小于1)");
			return;
		} */ if (cid == "") {
			alert("请选择分类标题");
			return;
		} if (title == "") {
			alert("请输入标题");
			return;
		} /* if (decription == "") {
			alert("请输入描述信息");
			return;
		} */ if (content == "") {
			alert("请输入内容");
			return;
		} if ((cid == "3") || (cid == "4") || (cid == "5")){
			nodis = "1";
		} if (nodis == "1" && photo == "") {
			alert("请选择图片文件");
			return;
		}
		var url = "${basePath }/edit/addNewsandTrends";
		var form = document.forms["fma"];
		form.action = url;
		form.submit();
	}
	function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
</script>
</html>
