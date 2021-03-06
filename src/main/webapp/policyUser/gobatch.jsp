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
<script type="text/javascript" src="${basePath }/js/jquery.form.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<html>
  <body style="height:100%;background:#fff;">
  <form id="upload" enctype="multipart/form-data" action="<%=path %>/rest/upload/importBuildInfoExcel" method="post" style="padding:50px;width:500px;height:200px;margin:74px auto;position:relative;">
        <h3>保单批量导入</h3>
        </br>
        1.点击模版下载</br>
        2.录入保单数据</br>
        3.选择录好的模版上传</br>
        4.点击从excel导入按钮上传</br>
        </br>
		</br>
        <input name="excelPath" id="excelPath" type="file" />
        <a href="#" id="importBuildInfo" style="padding:8px 15px;background:#00a6e3;color:#fff;">从excel导入</a>
        <a href="/fileSource/policyBatchImport.xls"  style="padding:8px 15px;background:#00a6e3;color:#fff;">模版下载</a>
    </form>
<script type="text/javascript">
	$(document).ready(function(){
	    $("#importBuildInfo").bind("click",function(){
	        var excelPath = $("#excelPath").val();
	        var insurerCode = $("#inserdCodes").val();
	        if(excelPath == null || excelPath == ''){
	            alert("请选择要上传的Excel文件");
	            return;
	        }else{
	        var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase(); 
	            if(fileExtend == '.xls'){
	                $("#upload").ajaxSubmit({
	                      url:"${basePath}/policyUser/checkPolicyExl?insurerCode="+insurerCode,
	                      cache:false,
	                      dataType:'json',
	                      success: function(data) {
							if(data.inBusinessLicenseNo=='1'){
		                        alert("保单批量导入失败！失败原因:"+data.inAddress);
							}else{
		                        alert("保单批量导入成功！");
		                        document.getElementById("showForm").style.display="none";
							}
	                      } ,
	                      error:function(){
	                          alert("保单批量导入失败！请重试");
	                      }
	                   });
	            }else{
	                alert("文件格式需为'.xls'格式");
	               return;
	            }
	        }
	    });
	});
</script>
  </body>
</html>
