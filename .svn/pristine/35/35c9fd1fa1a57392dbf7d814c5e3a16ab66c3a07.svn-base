<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%> --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
</head>
<script type="text/javascript">
function upoto() {
		document.getElementById("url1").style.display = "none";
		document.getElementById("u").style.display = "none";
		document.getElementById("photozi1").style.display = "";
		document.getElementById("photo1").style.display = "";
	}
</script>
<body>
	<div class="panel admin-panel margin-top" id="add" style="display: ">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 修改内容</strong>
		</div>
		<div class="body-content">
			<form class="form-x" action="${basePath }/edit/addUpdateNewsandTrends" name="fma" id="fma"
				method="POST" style="position:relative;" enctype="multipart/form-data">

				<c:forEach items="${sessionScope.pagination.resultList }" var="img" varStatus="vs">
					<div class="padding border-bottom">
						<ul class="search" style="padding-left:10px;">
							<li>
							首页 
							<select name="s_ishome" id="s_ishome" class="input"
								style="width:60px; line-height:17px; display:inline-block">
									<c:if test="${img.ISINDEX == '1' }">
										<option value="1">是</option>
										<option value="0">否</option>
									</c:if>
									<c:if test="${img.ISINDEX != '1' }">
										<option value="0">否</option>
										<option value="1">是</option>
									</c:if>
							</select> &nbsp;&nbsp; 
							推荐 
							<select name="s_isvouch" id="s_isvouch" class="input"
								style="width:60px; line-height:17px;display:inline-block">
									<c:if test="${img.ISRECOMMEND =='1'}">
										<option value="1">是</option>
										<option value="0">否</option>
									</c:if>
									<c:if test="${img.ISRECOMMEND !='1'}">
										<option value="0">否</option>
										<option value="1">是</option>
									</c:if>
							</select> &nbsp;&nbsp; 
							置顶 
							<select name="s_istop" id="s_istop" class="input"
								style="width:60px; line-height:17px;display:inline-block">
									<c:if test="${img.ISTOP =='1'}">
										<option value="1">是</option>
										<option value="0">否</option>
									</c:if>
									<c:if test="${img.ISTOP !='1'}">
										<option value="0">否</option>
										<option value="1">是</option>
									</c:if>
							</select>
							</li>
						</ul>
					</div>
					<div class="form-group">
						<div class="label">
							<label>产品分类：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="图片轮播" name="cid"
								id="cid" readonly="readonly" /> 
							<input type="text" value="${img.DOCTYPE }" name="cctvcid" id="cctvcid"
								style="display: none;" />
							<div class="tips"></div>
						</div>
					</div>
					<%-- <div class="form-group">
						<div class="label">
							<label>排序：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="DISPLAYNO" id="DISPLAYNO"
								value="${img.DISPLAYNO }" data-validate="required:,number:排序必须为数字" />
							<div class="tips"></div>
						</div>
					</div> --%>

					<div class="form-group">
						<div class="label">
							<label>标题：</label>
						</div>
						<div class="field">
							<input type="hidden" class="input w50" value="${img.DOCID }"
								name="docId" id="docId" /> 
							<input type="text" class="input w50" value="${img.TITLE }" name="title" id="title"
								data-validate="required:请输入标题" />
							<div class="tips"></div>
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>内容：</label>
						</div>
						<div class="field">
							<textarea type="text" class="input" name="content" id="content"
								style="height:120px;" value="">${img.DOCCONTENT }
							</textarea>
							<div class="tips"></div>
						</div>

						<%-- <div class="form-group">
							<div class="label">
								<label>描述：</label>
							</div>
							<div class="field">
								<textarea type="text" class="input" name="DECRIPTION" id="DECRIPTION"
									style="height:120px;" value="">${img.DECRIPTION }
								</textarea>
								<div class="tips"></div>
							</div>
						</div> --%>

						<div class="form-group">
							<div class="label">
								<label>图片：</label>
							</div>
							<div class="field">
								<select name="nodis" id="nodis" class="input w50">
									<c:if test="${img.IMAGEPATH == null || img.IMAGEPATH == ''}">
										<option value="0">无图片</option>
									</c:if>
									<c:if test="${img.IMAGEPATH != null && img.IMAGEPATH != ''}">
										<option value="1">有图片</option>
									</c:if>
								</select>
								<c:if test="${img.IMAGEPATH == null || img.IMAGEPATH == '' }">
									<input type="file" class="button bg-white margin-left" id="photo" name="photo" value="+ 浏览上传"
										style="float:left;margin-left: 100px;display: ;">
									<div class="tipss" id="photozi" style="display: ;">图片尺寸：500*500</div>
								</c:if>
								<c:if test="${img.IMAGEPATH != null && img.IMAGEPATH != '' }">
									<input type="text" id="url1" name="img" class="input tips" style="width:50%; float:left;display: "
										value="${img.IMAGEPATH }" data-toggle="hover" data-place="right" data-image="" readonly="readonly" />
									<a href="javascript:upoto();" id="u">修改</a>
									<br>
								</c:if>

								<input type="file" class="button bg-white margin-left"
									id="photo1" name="photo1" value="+ 浏览上传" style="float:left;margin-left: 100px;display: none;">
								<div class="tipss" id="photozi1" style="display: none;">图片尺寸：500*500</div>
							</div>
						</div>
				</c:forEach>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<a class="button bg-main icon-check-square-o"
							href="javascript:submitadv();">提交
						</a>
						<a class="button bg-main icon-check-square-o"
							href="javascript:history.go(-1);">返回
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	/* function photo() {
		document.getElementById("image2").text = "";
		document.getElementById("div2").style.display = "none";
		document.getElementById("div3").style.display = "";
	}
	function hide() {
		document.getElementById("div3").style.display = "none";
		document.getElementById("div2").style.display = "";
	} */
	function submitadv() {
		var s_ishome = document.getElementById("s_ishome").value;
		var s_isvouch = document.getElementById("s_isvouch").value;
		var s_istop = document.getElementById("s_istop").value;
		var cid = document.getElementById("cctvcid").value;//
		var displayNo = document.getElementById("DISPLAYNO").value;//排序
		var title = document.getElementById("title").value;
		var content = document.getElementById("content").value;
		var decription = document.getElementById("DECRIPTION").value;

		var nodis = document.getElementById("nodis").value;

		if (s_ishome == "" && s_isvouch == "" && s_istop == "") {
			alert("请选择至少一个属性");
			return;
		}//if ((s_ishome != "1" && s_ishome != "") || (s_isvouch != "1" && s_isvouch != "") || (s_istop != "1" && s_istop != "")){
		if ((s_ishome == "0" && s_isvouch == "0" && s_istop == "0")) {
			alert("请选择至少一个属性");
			return;
		}
		if (displayNo == "" || displayNo == "0") {
			alert("请输入要显示的位置");
			return;
		}
		if (cid == "") {
			alert("请选择分类标题");
			return;
		}
		if (title == "") {
			alert("请输入标题");
			return;
		}
		if (decription == "") {
			alert("请输入描述信息");
			return;
		}
		if (content == "") {
			alert("请输入内容");
			return;
		}
		if (nodis == "0") {
			var url = "${basePath }/edit/addUpdateNewsandTrends";
			var form = document.forms["fma"];
			form.action = url;
			form.submit();
		}
		if (nodis == "1") {
			var photo1 = document.getElementById("photo1").value;
			if (document.getElementById("url1").style.display == "none"
					&& photo1 == "") {
				alert("请选择要上传的文件");
				return;
			} else {
				var url = "${basePath }/edit/addUpdateNewsandTrends";
				var form = document.forms["fma"];
				form.action = url;
				form.submit();
			}
		}
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