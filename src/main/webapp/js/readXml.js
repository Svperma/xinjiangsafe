// 功能介绍 读取xml
 var loadXML = function (xmlFile) {
            var xmlDoc;
            if (window.ActiveXObject) {
                xmlDoc = new ActiveXObject('Microsoft.XMLDOM');//IE浏览器
                xmlDoc.async = false;
                xmlDoc.load(xmlFile);
            }
            else if (isFirefox=navigator.userAgent.indexOf("Firefox")>0) { //火狐浏览器
            //else if (document.implementation && document.implementation.createDocument) {//这里主要是对谷歌浏览器进行处理
                xmlDoc = document.implementation.createDocument('', '', null);
                xmlDoc.load(xmlFile);
            }
            else{ //谷歌浏览器
              var xmlhttp = new window.XMLHttpRequest();
                xmlhttp.open("GET",xmlFile,false);
                xmlhttp.send(null);
                if(xmlhttp.readyState == 4){
                xmlDoc = xmlhttp.responseXML.documentElement;
                } 
            }

            return xmlDoc;
        }

        // 首先对xml对象进行判断
      var  checkXMLDocObj = function (xmlFile) {
            var xmlDoc = loadXML(xmlFile);
			var elements = "";
            if (xmlDoc == null) {
                alert('您的浏览器不支持xml文件读取,于是本页面禁止您的操作,推荐使用IE5.0以上可以解决此问题!');
				return;
            }else{
				elements = xmlDoc.getElementsByTagName("content");
			}
            return elements;
        }
	var cText = "";
	var jsonStr = "{'gongshilan':'<h4>以图表的形式展现信息</h4><br/>按条件查询：根据省，市，县区及某一时间段<br/>结果：以图表的形式显示查询结果',"+
	"'qiyezhuangkuang':'<h4>企业状况</h4><br/>企业的综合信息<br/>查询条件：根据省，市，县区，保单状态，保险公司，行业类型，企业名称，组织机构代码<br/><br/>查询结果：企业的信息"+
	"保单信息等，点击《查看》按钮，查看企业和保单的详细信息，其中，红色字体部分表示该证件或保单已失效。<br/><br/>报表下载：根据选择的条件，下载数据报表'"+
	",'anquanpinggu':'<h4>企业安全评估</h4><br/>对企业进行安全评估<br/>查询条件：根据省，市，县区，企业安全级别，整改进度，企业名称，评估时间进行查询<br/><br/>查询结果：专家对"+
	"企业的评估结果及整改建议,《发送消息》按钮，给企业发送消息，督促企业整改等<br/>点击专家意见，查看详细内容<br/><br/>企业评估：录入对企业的评估内容及整改意见，"+
	"对企业定级<br/><br/>报表下载：根据查询条件下载数据报表',"+
	"'anquanpaicha':'<h4>企业安全排查</h4><br/>查看企业自查情况<br/>查询条件：根据省，市，县区，企业安全级别，企业名称，排查时间进行查询<br/><br/>查询结果：企业自己排查的时间，"+
	"排查内容等，点击《查看》按钮，查看详情',"+
	"'chengbaozhuangkuang':'<h4>承保状况</h4><br/>统计各保险公司的承保状况<br/>查询条件：根据省，市，县区，保险公司名称，时间段<br/><br/>查询结果：以保险公司"+
	"为单位，显示承保统计数据，点击承保企业数，查看所承保企业明细，点击援助金，查看援助金的使用明细，点击投诉与反馈数，查看该保险公司的投诉与反馈<br/><br/>"+
	"报表下载：根据选择条件，下载数据报表',"+
	"'peian':'<h4>赔案综合报表</h4><br/>统计各地区理赔情况<br/>查询条件：根据省，市，县区，保险公司名称，企业名称，时间段<br/><br/>查询结果：以地区为单位"+
	"统计本地区的理赔案件<br/><br/>报表下载：根据选择条件，下载数据报表',"+
	"'chulizhongxin':'<h4>事故处理中心</h4><br/>查看企业安全事故<br/>查询条件：根据省，市，县区，企业名称，时间段<br/><br/>查询结果：企业事故详情及处理事故的"+
	"负责人，点击《查看》，查看事故的处理结果<br/><br/>报表下载：根据选择条件，下载数据报表',"+
	"'zhuanjiaku':'<h4>专家库</h4><br/>维护专家数据<br/>查询条件：根据省，市，县区，专家姓名<br/><br/>查询结果：各专家的信息，"+
	"点击《编辑》，修改专家信息，点击《删除》，删除专家<br/><br/>添加专家：新增专家',"+
	"'weiyuanhui':'<h4>调解委员会</h4><br/>维护调解委员会数据<br/>查询条件：根据省，市，县区，委员会姓名<br/><br/>查询结果：各调解委员会的信息，"+
	"点击《查看》，查看委员会信息，点击《删除》，删除该委员会<br/><br/>添加调解委员会：新增调解委员会',"+
	"'yonghuguanli':'<h4>用户管理</h4><br/>管理用户<br/>查询条件：根据省，市，县区，用户名称<br/><br/>查询结果：用户信息，"+
	"点击《编辑》，修改用户信息，点击《删除》，删除该用户<br/><br/>添加用户：新增监管用户'}";
	function createDiv(id,nodeName){
		jsonObj = eval('('+jsonStr+')');
		var obj = document.getElementById(id);
		var top = obj.offsetTop;
		var left = obj.offsetLeft;
		cText = eval("jsonObj."+nodeName);
		var div = document.createElement("div");
		div.id = "showId";
		div.innerHTML = cText;
		div.style.width = "200px";
		div.style.position = "absolute";
		div.style.zIndex = "9999";
		div.style.backgroundColor = "white";
		div.style.border = "gray solid 1px";
		div.style.borderRadius = "5px";
		div.style.top = (top+obj.offsetHeight+100)+"px";
		div.style.left= (left)+"px";
		var a = document.createElement("a");
		a.innerHTML = "关闭";
		a.style.cssFloat = "right";
		a.style.backgroundColor = "blue";
		a.style.width = "200px";
		a.style.color = "white";
		a.style.cursor = "pointer";
		a.style.marginTop = "20px";
		a.onclick = function(){
			document.body.removeChild(document.getElementById("showId"));	
		}
		div.appendChild(a);
		
		document.body.appendChild(div);
	}