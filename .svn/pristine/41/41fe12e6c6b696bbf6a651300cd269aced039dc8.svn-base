<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>安全生产责任保险服务信息平台</title>
  <script type="text/javascript" src="/js/jquery.min.js"></script>
  <script type="text/javascript" src="/js/index.js"></script>
  <link rel="stylesheet" href="/css/xm1.css">
 </head>
 <body>
	<header>
		<div class="img_1">
            <jsp:include page="${basePath }/news/biaoti.jsp"></jsp:include>
		</div>
	</header>
	<nav>
	  <div class="nav_1">
		
	        <div class="select">
            <div id="select_1">社会查询</div>
            <input id="select_2" type="text" placeholder="请输入企业名称">
            <img onClick="getPolicy()" src="/images/wo-1.png">
            <div style="width:820px;margin-left:14%;background-color:#EAEAEA;z-index:100;position:absolute;border:1px solid #a5e5ff;display:none;" id="showDiv">
            	<table id="policy" border="1" cellpadding="0" cellspacing="0" width="100%"  align="center" style="text-align:center;border:1px solid #ADC9B4;">
                	<TR style=" border-bottom:#ADC9B4 1px solid;">
                        <td>企业名称</td>
                        <td>每次事故责任限额</td>
                        <td>承保公司</td>
                        <td>状态</td>
                    </TR>
                    <TR >
                        <td>乌鲁木齐市加油站</td>
                        <td>120万元</td>
                        <td>中国人民财产保险公司</td>
                        <td>有效</td>
                    </TR>
                </table>
                <div style="text-align:center;"> <img onClick="closeDiv()" src="/images/close.png" style="border:none; width:49px;height:21px;"/></div>
            </div>
        </div>
	 </div>
     <div class="navigation">
     	<div class="navi"><p>安全导航</p></div>
     	<div class="common">
        	<p>国务院安委会成员单位>></p><hr>
        	<div class="row"><a href="http://www.sdpc.gov.cn/" target="_blank" >发展改革委</a><a href="http://www.moe.edu.cn/" target="_blank">教育部</a><a href="http://www.most.gov.cn/" target="_blank">科技部</a><a href="http://www.miit.gov.cn/" target="_blank">工业和信息化部</a><a href="http://www.mps.gov.cn/" target="_blank">公安部</a><a href="http://www.ccdi.gov.cn/" target="_blank">监察部</a><a href="http://www.moj.gov.cn/" target="_blank">司法部</a><a href="http://www.mof.gov.cn/" target="_blank">财政部</a><a href="http://www.mohrss.gov.cn" target="_blank">人力资源社会保障部</a><a href="http://www.mlr.gov.cn/" target="_blank">国土资源部</a></div>
            <div class="row"><a href="http://www.mlr.gov.cn/" target="_blank">环境保护部</a><a href="http://www.mohurd.gov.cn/" target="_blank">住房和城乡建设部</a><a href="http://www.moc.gov.cn/" target="_blank">交通运输部</a><a href="http://www.mwr.gov.cn/" target="_blank">水利部</a><a href="http://www.moa.gov.cn/" target="_blank">农业部</a><a href="http://www.mofcom.gov.cn/" target="_blank">商业部</a><a href="http://www.nhfpc.gov.cn/" target="_blank">卫生计生委</a><a href="http://www.sasac.gov.cn/" target="_blank">国资委</a><a href="http://www.saic.gov.cn/" target="_blank">工商总局</a><a href="http://www.aqsiq.gov.cn/" target="_blank">质检总局</a></div>
            <div class="row">
            	<a href="http://www.chinasarft.gov.cn/" target="_blank">新闻出版广电局</a><a href="http://www.sport.gov.cn/" target="_blank">体育总局</a><a href="http://www.forestry.gov.cn/" target="_blank">林业局</a><a href="http://www.cnta.gov.cn/" target="_blank">旅游局</a><a href="http://www.chinalaw.gov.cn/" target="_blank">法制办</a><a href="http://www.scio.gov.cn/" target="_blank">新闻办</a><a href="http://www.cma.gov.cn/" target="_blank">气象局</a><a href="http://www.nea.gov.cn/" target="_blank">能源局</a><a href="http://www.sastind.gov.cn/" target="_blank">国防科工局</a><a href="http://www.soa.gov.cn/" target="_blank">海洋局</a><a href="http://www.nra.gov.cn/" target="_blank">铁路局</a>
            </div>
            <div class="row">
            	<a href="http://www.caac.gov.cn/" target="_blank">民航局</a><a href="http://cpc.people.com.cn/GB/64114/75332/" target="_blank">中央宣传部</a><a href="http://www.scopsr.gov.cn/" target="_blank">中央编办</a><a href="http://www.acftu.org/" target="_blank">全国总工会</a><a href="http://www.ccyl.org.cn/" target="_blank">共青团中央</a><a href="http://www.women.org.cn/" target="_blank">全国妇联</a>
            </div>
        </div>
        <div class="common">
        	<p>安全生产监管局>></p><hr>
            <div class="row"><a href="http://www.chinasafety.gov.cn/" target="_blank">国家安全生产监督管理总局</a><a href="http://www.xjsafety.gov.cn/" target="_blank">新疆</a><a href="http://www.bjsafety.gov.cn/" target="_blank">北京</a><a href="http://www.tjsafety.gov.cn/" target="_blank">天津</a><a href="http://www.hebsafety.gov.cn/" target="_blank">河北</a><a href="http://www.sxaj.gov.cn/" target="_blank">山西</a><a href="http://www.nmgajj.gov.cn/" target="_blank">内蒙古</a><a href="http://www.lnsafety.gov.cn/" target="_blank">辽宁</a><a href="http://www.jlsafety.gov.cn/" target="_blank">吉林</a><a href="http://www.hlsafety.gov.cn/" target="_blank">黑龙江</a><a href="http://www.shsafety.gov.cn/" target="_blank">上海</a><a href="http://www.jssafety.gov.cn/" target="_blank">江苏</a><a href="http://www.zjsafety.gov.cn/" target="_blank">浙江</a></div>
       <div class="row"><a href="http://www.anhuisafety.gov.cn/" target="_blank">安徽</a><a href="http://www.fjsafety.gov.cn/" target="_blank">福建</a><a href="http://www.jxsafety.gov.cn/" target="_blank">江西</a><a href="http://www.sdaj.gov.cn/" target="_blank">山东</a><a href="http://www.hnsaqscw.gov.cn/" target="_blank">河南</a><a href="http://www.hubeisafety.gov.cn/" target="_blank">湖北</a><a href="http://www.hunansafety.gov.cn/" target="_blank">湖南</a><a href="http://www.gdsafety.gov.cn/" target="_blank">广东</a><a href="http://www.gxajj.gov.cn/" target="_blank">广西</a><a href="http://www.hainan.gov.cn/" target="_blank">海南</a><a href="http://www.cqmj.gov.cn/" target="_blank">重庆</a><a href="http://www.scsafety.gov.cn/" target="_blank">四川</a><a href="http://www.gzaj.gov.cn/" target="_blank">贵州</a></d><a href="http://www.ynsafety.gov.cn/" target="_blank">云南</a><a href="http://www.tibetsafety.gov.cn/" target="_blank">西藏</a><a href="http://www.snsafety.gov.cn/" target="_blank">陕西</a></div>
       <div class="row">
       		<a href="http://www.gssafety.gov.cn/" target="_blank">甘肃</a><a href="http://www.qhsafety.gov.cn/" target="_blank">青海</a><a href="http://www.nxsafety.gov.cn/" target="_blank">宁夏</a><a href="http://www.ajj.dl.gov.cn/" target="_blank">大连/a><a href="http://www.nbsafety.gov.cn/" target="_blank">宁波</a><a href="http://www.xmsafety.gov.cn/" target="_blank">厦门</a><a href="http://www.qdajj.gov.cn/" target="_blank">青岛</a><a href="http://www.szemo.gov.cn/" target="_blank">深圳</a>
       </div>
        <div class="row"><a href="http://www.circ.gov.cn/" target="_blank">中国保险监督管理委员会</a><a href="http://www.circ.gov.cn/web/site37/tab2144/" target="_blank">中国保险监督管理委员会（新疆监管局）</a></div>
        </div>
        <div class="common">
        	<p>省级煤矿安全监察局>></p><hr>
            <div class="row">
            	<a href="http://www.bjsafety.gov.cn/" target="_blank">北京</a><a href="http://www.hebmaj.gov.cn/" target="_blank">河北</a><a href="http://www.sxsafety.gov.cn/" target="_blank">山西</a><a href="http://www.imcoal-safety.gov.cn/" target="_blank">内蒙古</a><a href="http://www.lnmj.gov.cn/" target="_blank">辽宁</a><a href="http://www.jlmj.gov.cn/" target="_blank">吉林</a><a href="http://www.hljmkaj.gov.cn/" target="_blank">黑龙江</a><a href="http://www.jssafety.gov.cn/" target="_blank">江苏</a><a href="http://www.anhuimj.gov.cn/" target="_blank">安徽</a><a href="http://www.fjsafety.gov.cn/" target="_blank">福建</a><a href="http://www.jxmkaqjc.gov.cn/" target="_blank">江西</a><a href="http://www.sdsoal.gov.cn/" target="_blank">山东</a><a href="http://www.hnsafety.gov.cn/" target="_blank">河南</a><a href="http://www.hubeicoal-safety.gov.cn/default.aspx" target="_blank">湖北</a><a href="http://www.hunanaj.gov.cn/" target="_blank">湖南</a></div>
                <div class="row"><a href="http://www.gxmj.gov.cn/" target="_blank">广西</a><a href="http://www.cqmj.gov.cn/" target="_blank">重庆</a><a href="http://www.scsafety.gov.cn/" target="_blank">四川</a><a href="http://www.gzaj.gov.cn/" target="_blank">贵州</a></d><a href="http://www.ynmj.gov.cn/" target="_blank">云南</a><a href="http://www.smaj.gov.cn/" target="_blank">陕西</a><a href="http://www.gscms.chinasafety.gov.cn/" target="_blank">甘肃</a><a href="http://www.qhsafety.gov.cn/" target="_blank">青海</a><a href="http://www.nxmj.gov.cn/" target="_blank">宁夏</a><a href="http://www.xjcms.chinasafety.gov.cn/" target="_blank">新疆</a>
            </div>
            
        </div>
        <div class="common">
        	<p>安全监管总局其他直属事业单位>></p><hr>
            <div class="row">
            	<a href="http://www.ncics.org.cn/" target="_blank">总局国际交流合作中心</a><a href="http://www.chinasafety-archives.org/" target="_blank">总局档案馆</a><a href="http://www.china-safety.org/" target="_blank">总局宣传教育中心</a><a href="http://www.sset.org.cn/" target="_blank">总局培训中心</a><a href="http://www.ctcci.org/" target="_blank">总局研究中心</a><a href="http://www.chinasafety.com.cn/templet/default/" target="_blank">总局通信信息中心</a><a href="http://www.chinasafety.ac.cn/" target="_blank">中国安全生产科学研究院</a>
            </div>
            <div class="row">
            	<a href="http://www.aqb.cn/index.html" target="_blank">中国安全生产报社</a><a href="http://www.nios.com.cn/" target="_blank">总局信息研究院</a><a href="http://www.nrcc.com.cn/" target="_blank">总局化学品登记中心</a><a href="http://www.mtzyy.com.cn/" target="_blank">煤炭总医院</a><a href="http://www.ncist.edu.cn/" target="_blank">华北科技学院</a><a href="http://www.ccmat.cn/home.asp" target="_blank">中国煤矿文工团</a><a href="http://www.niosh.org.cn/" target="_blank">总局职业安全卫生研究中心</a>
            </div>
            <div class="row">
            	<a href="http://demo.syku.cn/" target="_blank">中国煤矿工人昆明疗养院</a><a href="http://www.bdhmklyy.com/" target="_blank">中国煤矿工人北戴河疗养院</a><a href="http://www.dlmklyy.cn/" target="_blank">中国煤矿工人大连疗养院</a>
            </div>
        </div>
        <div class="common">
        	<p>行业协会>></p><hr>
            <div class="row">
            	<a href="http://www.china-safety.org.cn/caws/" target="_blank">中国安全生产协会</a><a href="http://www.chinaropeway.org/" target="_blank">中国索道协会</a><a href="http://www.cosha.org.cn/" target="_blank">中国职业安全健康协会</a><a href="http://www.chemicalsafety.org.cn/" target="_blank">中国化学品安全协会</a><a href="http://www.cemta.cn/" target="_blank">中国民用爆破器材流通协会</a>
                </div><div class="row"><a href="http://www.cfbjjh.org.cn/" target="_blank">中国煤矿尘肺病治疗基金协会</a><a href="#" target="_blank">中国煤炭工业科学技术协会</a><a href="#" target="_blank">中国煤炭工业协会</a><a href="#" target="_blank">中国烟花爆竹协会</a><a href="#" target="_blank">中国建筑业协会建筑安全分会</a>
            </div>
            <div class="row">
            	<a href="#" target="_blank">中国电力企业联合会电力职业安全卫生分会</a><a href="#" target="_blank">中国道路交通安全协会</a><a href="#" target="_blank">中国机械工业安全卫生协会</a>
            </div>
            <div class="row">
            	<a href="#" target="_blank">中国保险行业协会</a><a href="#" target="_blank">中国保险学会</a><a href="#" target="_blank">中国精算师协会</a><a href="#" target="_blank">中国保险资产管理业学会</a>
            </div>
        </div>
        <div class="common">
        	<p>港澳台地区>></p><hr>
            <div class="row">
            	<a href="#" target="_blank">香港职业安全健康局</a><a href="#" target="_blank">澳门劳工事务局</a><a href="#" target="_blank">台湾职业卫生协会</a>
            </div>
        </div>
        <div class="common">
        	<p>专业机构>></p><hr>
            <div class="row">
            
            </div>
        </div>
        <div class="common">
        	<p>安全专业考试>></p><hr>
            <div class="row">
            	<a href="http://www.china-safety.org.cn/caws/aqpjs/aqpjs.htm" target="_blank">安全评价师</a><a href="" target="_blank">注册安全工程师</a>
            </div>
        </div>
        <div class="common">
        	<p>国际安全生产>></p><hr>
            <div class="row">
            	<a href="#" target="_blank">美国矿山安全</a><a href="#" target="_blank">美国职业安全局</a><a href="#" target="_blank">美国化工安全</a><a href="#" target="_blank">美国环保局</a><a href="#" target="_blank">美国国家安全委员会</a><a href="#" target="_blank">国际劳工组织网站</a><a href="#" target="_blank">欧洲过程安全中心</a>
            </div>
            <div class="row">
            	<a href="#" target="_blank">英国安全卫生执行局</a><a href="#" target="_blank">美国化学工程师协会化学安全中心</a><a href="#" target="_blank">美国化学安全和危害调查局</a><a href="#" target="_blank">加拿大石油安全委员会</a><a href="#" target="_blank">澳大利亚应急处理中心</a>
            </div>
            <div class="row">
            	<a href="#" target="_blank">加拿大职业卫生安全中心</a><a href="#" target="_blank">美国联邦应急管理局</a><a href="#" target="_blank">匈牙利国家职业安全及劳动监督委员会</a>
            </div>
        </div>
     </div>
	</nav>
	<jsp:include page="${basePath }/news/footer.jsp"></jsp:include>
 </body>
 <script type="text/javascript">
 	var $j = jQuery.noConflict();
 	function getPolicy(){
 		var name = document.getElementById("select_2").value;
 		if(name == "" || name == "请输入企业名称"){
 			alert("请输入企业名称");
 			return;
 		}
 		$j.ajax({
 			type:"get",
 			url:"${basePath}/getPolicy?name="+name,
 			data:{},
 			dataType:"json",
 			success:function(data){
 				var table = document.getElementById("policy"); 
 				var rowNum=table.rows.length;
			     for (var i=0;i<rowNum;i++)
			     {
			         table.deleteRow(i);
			         rowNum=rowNum-1;
			         i=i-1;
			     }
 				var tr = document.createElement("TR");
 				var td1 = document.createElement("td");
 				td1.innerHTML = "企业名称";
 				var td2 = document.createElement("td");
 				td2.innerHTML = "每次事故责任限额";
 				var td3 = document.createElement("td");
 				td3.innerHTML = "承保公司";
 				var td4 = document.createElement("td");
 				td4.innerHTML = "状态";
 				tr.appendChild(td1);
 				tr.appendChild(td2);
 				tr.appendChild(td3);
 				tr.appendChild(td4);
 				table.appendChild(tr);
 				for(var i=0;i<data.length;i++){
 					var tr1 = document.createElement("TR");
 					var td11 = document.createElement("td");
	 				td11.innerHTML = data[i].APPLINAME;
	 				var td21 = document.createElement("td");
	 				td21.innerHTML = data[i].SUMAMOUNT+"万元";
	 				var td31 = document.createElement("td");
	 				td31.innerHTML = data[i].INSURER;
	 				var td41 = document.createElement("td");
	 				td41.innerHTML = data[i].STATUS;
	 				tr1.appendChild(td11);
	 				tr1.appendChild(td21);
	 				tr1.appendChild(td31);
	 				tr1.appendChild(td41);
	 				table.appendChild(tr1);
 				}
 				document.getElementById("showDiv").style.display = "";
 			 },
 			error:function(){
 				alert("查询异常");
 			}
 		});
 	}
 </script>
</html>
