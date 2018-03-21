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
<style>
.button bg-blue margin-left {
	background: white;
}
</style>
<script src="${basePath }/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="${basePath }/edit/addUpdateNewsandTrends" name="fma"
				method="POST" style="position:relative;" id="fma"
				enctype="multipart/form-data">
				<c:forEach items="${sessionScope.pagination.resultList }" var="docpeList" varStatus="dt">
					<div class="form-group">
						<div class="label">
							<label>属性：</label>
						</div>
						<div class="field">
							<li>首页<!--  onchange="changesearch()" --> <select
								name="s_ishome" id="s_ishome" class="input"
								style="width:60px; line-height:17px; display:inline-block">
									<c:if test="${docpeList.ISINDEX == '1' }">
										<option value="1">是</option>
										<option value="0">否</option>
									</c:if>
									<c:if test="${docpeList.ISINDEX != '1' }">
										<option value="0">否</option>
										<option value="1">是</option>
									</c:if>
							</select> &nbsp;&nbsp; 推荐<!--  onchange="changesearch()" --> <select
								name="s_isvouch" id="s_isvouch" class="input"
								style="width:60px; line-height:17px;display:inline-block">
									<c:if test="${docpeList.ISRECOMMEND == '1' }">
										<option value="1">是</option>
										<option value="0">否</option>
									</c:if>
									<c:if test="${docpeList.ISRECOMMEND != '1' }">
										<option value="0">否</option>
										<option value="1">是</option>
									</c:if>
							</select> &nbsp;&nbsp; 置顶<!--  onchange="changesearch()" --> <select
								name="s_istop" id="s_istop" class="input"
								style="width:60px; line-height:17px;display:inline-block">
									<c:if test="${docpeList.ISTOP == '1' }">
										<option value="1">是</option>
										<option value="0">否</option>
									</c:if>
									<c:if test="${docpeList.ISTOP != '1' }">
										<option value="0">否</option>
										<option value="1">是</option>
									</c:if>
							</select>
							</li>
							<div class="tips"></div>
						</div>

					</div>
					<input type="text" class="input w50" value="${docpeList.DOCID }"
						name="docId" id="docId" style="display: none;" />
					<%-- <div class="form-group">
						<div class="label">
							<label>期数：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${docpeList.EXPECTNO }" name="EXPNO" id="EXPNO"
								data-validate="required:请输入页面显示的位置" readonly="readonly" />

							<div class="tips"></div>
						</div>
					</div> --%>

					<%-- <div class="form-group">
						<div class="label">
							<label>显示位置：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${docpeList.DISPLAYNO }" name="DISPLAYNO" id="DISPLAYNO"
								data-validate="required:请输入页面显示的位置" />
							<div class="tips"></div>
						</div>
					</div> --%>

					<div class="form-group">
						<div class="label">
							<label>分类标题：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="<tlds:name codeType="docType" codeCode="${docpeList.docType }"/>"
								name="cid" id="cid" readonly="readonly" /> <input type="text"
								class="input w50" value="${docpeList.DOCTYPE }" name="cctvcid"
								id="cctvcid" style="display: none;" />
							<div class="tips"></div>
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>标题：</label>
						</div>
						<div class="field">
							<input type="text" class="input w100" value="${docpeList.TITLE }"
								name="title" id="title" data-validate="required:请输入标题" />
							<div class="tips"></div>
						</div>
					</div>

					<if condition="$iscid eq 1">

					<%-- <div class="form-group">
						<div class="label">
							<label>描述：</label>
						</div>
						<div class="field">
							<textarea name="DECRIPTION" id="DECRIPTION" class="input"
								style="height:80px; border:1px solid #ddd;">${docpeList.DECRIPTION }</textarea>
							<span style="color: red;">限定500字以内</span>
							<div class="tips"></div>
						</div>
					</div> --%>

					<div class="form-group">
						<div class="label">
							<label>内容：</label>
						</div>
						<div class="field">
							<textarea name="content" id="content" class="input"
								style="height:200px; border:1px solid #ddd;">${docpeList.DOCCONTENT }</textarea>
							<div class="tips"></div>
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>图片：</label>
						</div>

						<div class="field">
							<select name="nodis" id="nodis" class="input w50">
								<c:if
									test="${docpeList.IMAGEPATH == null || docpeList.IMAGEPATH == ''}">
									<option value="0">无图片</option>
								</c:if>
								<c:if
									test="${docpeList.IMAGEPATH != null && docpeList.IMAGEPATH != ''}">
									<option value="1">有图片</option>
								</c:if>
							</select>
							<c:if
								test="${docpeList.IMAGEPATH == null || docpeList.IMAGEPATH == '' }">
								<input type="file" class="button bg-white margin-left"
									id="photo" name="photo" value="+ 浏览上传"
									style="float:left;margin-left: 100px;display: ;">
								<div class="tipss" id="photozi" style="display: ;">图片尺寸：500*500</div>
							</c:if>
							<c:if
								test="${docpeList.IMAGEPATH != null && docpeList.IMAGEPATH != '' }">
								<input type="text" id="url1" name="img" class="input tips"
									style="width:50%; float:left;display: "
									value="${docpeList.IMAGEPATH }" data-toggle="hover"
									data-place="right" data-image="" readonly="readonly" />
								<a href="javascript:upoto();" id="u">修改</a>
								<br>
							</c:if>

							<input type="file" class="button bg-white margin-left"
								id="photo1" name="photo1" value="+ 浏览上传"
								style="float:left;margin-left: 100px;display: none;">
							<div class="tipss" id="photozi1" style="display: none;">图片尺寸：500*500</div>
						</div>
					</div>

					</if>
				</c:forEach>
				<div class="clear"></div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<a class="button bg-main icon-check-square-o"
							href="javascript:submit();">提交</a> <a
							class="button bg-main icon-check-square-o"
							href="javascript:history.go(-1);">返回</a>
					</div>
				</div>

			</form>
		</div>
	</div>

</body>
<script type="text/javascript">
	function upoto() {
		document.getElementById("url1").style.display = "none";
		document.getElementById("u").style.display = "none";
		document.getElementById("photozi1").style.display = "";
		document.getElementById("photo1").style.display = "";
		// 		var a = document.getElementById("url1").value;
		// 		var c = document.getElementById("photo1").value;

		/* var b = document.getElementById("photozi1").value; */
	}
	function nois() {
		var nodis = document.getElementById("nodis").value;
		if (nodis != "" || nodis != "0") {
			document.getElementById("photo").style.display = "";
			document.getElementById("photozi").style.display = "";
		} else {
			document.getElementById("photo").style.display = "none";
			document.getElementById("photozi").style.display = "none";
		}
	}
	function submit() {
		var s_ishome = document.getElementById("s_ishome").value;
		var s_isvouch = document.getElementById("s_isvouch").value;
		var s_istop = document.getElementById("s_istop").value;
// 		var expectNo = document.getElementById("EXPNO").value;
// 		var displayNo = document.getElementById("DISPLAYNO").value;
		var cid = document.getElementById("cctvcid").value;
		var title = document.getElementById("title").value;
// 		var decription = document.getElementById("DECRIPTION").value;
		var content = document.getElementById("content").value;

		var nodis = document.getElementById("nodis").value;

		// 		var nodis = document.getElementById("nodis").value;

		if (s_ishome == "" && s_isvouch == "" && s_istop == "") {
			alert("请选择至少一个属性1");
			return;
		}//if ((s_ishome != "1" && s_ishome != "") || (s_isvouch != "1" && s_isvouch != "") || (s_istop != "1" && s_istop != "")){
		if ((s_ishome == "0" && s_isvouch == "0" && s_istop == "0")) {
			alert("请选择至少一个属性2");
			return;
		}
		/* if (expectNo == "") {
			alert("请选择期数");
			return;
		} */
		/* if (displayNo == "" || displayNo == "0") {
			alert("请输入要显示的位置");
			return;
		} */
		if (cid == "") {
			alert("请选择分类标题");
			return;
		}
		if (title == "") {
			alert("请输入标题");
			return;
		}
		/* if (decription == "") {
			alert("请输入描述信息");
			return;
		} */
		if (content == "") {
			alert("请输入内容");
			return;
		}/* if (nodis == "1" && photo == "") {
							alert("请选择文件");
							return;
						} */

		if (nodis == "0") {
// 			var photo = document.getElementById("photo").value;
		
// 			if (photo != "") {
				var url = "${basePath }/edit/addUpdateNewsandTrends";
				var form = document.forms["fma"];
				form.action = url;
				form.submit();
// 			}
		}if (document.getElementById("url1").style.display=="none" && nodis == "1") {
			var photo1 = document.getElementById("photo1").value;
			if ( photo1 == "") {
				alert("请选择要上传的文件");
				return;
			}else{
				var url = "${basePath }/edit/addUpdateNewsandTrends";
				var form = document.forms["fma"];
				form.action = url;
				form.submit();
			}
		}
		var url = "${basePath }/edit/addUpdateNewsandTrends";
				var form = document.forms["fma"];
				form.action = url;
				form.submit();
	}
</script>
<script type="text/javascript">
	function browseFolder(path) {
		try {
			var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939"; //选择框提示信息
			var Shell = new ActiveXObject("Shell.Application");
			//var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑
			var Folder = Shell.BrowseForFolder(0, Message, 0); //起始目录为：桌面
			if (Folder != null) {
				Folder = Folder.items(); // 返回 FolderItems 对象
				Folder = Folder.item(); // 返回 Folderitem 对象
				Folder = Folder.Path; // 返回路径
				if (Folder.charAt(Folder.length - 1) != "\\") {
					Folder = Folder + "\\";
				}
				document.getElementById(path).value = Folder;
				return Folder;
			}
		} catch (e) {
			alert(e.message);
		}
	}
</script>
</html>
