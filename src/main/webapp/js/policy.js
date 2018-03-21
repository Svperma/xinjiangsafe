 //获取可投保保险公司
  function getInsureY(riskCode,areaCode){
	  var obj = document.getElementById("insureSpace");
	  obj.innerHTML = "";
	  $.ajax({
			type:"post",
			url:"getInsure",
			data:JSON.stringify({
				"riskCode":riskCode,
				"areaCode":areaCode
				}),
			dataType:"json",
			contentType:"application/json;charset=UTF-8",
			success:function(data){
				for(var i=0;i<data.length;i++){
					var item = data[i];
					var a = document.createElement("a");
					a.setAttribute("class","a10");
					a.setAttribute("onClick","getInsureMain('"+item.insuranceCode+"','"+riskCode+"')");
					a.setAttribute("id",item.insuranceCode);
					var img = document.createElement("img");
					img.src = "/images/"+item.insuranceCode+".jpg";
					a.appendChild(img);
					obj.appendChild(a);
					
				}
				document.getElementById("showInsure").style.display="block";
				document.getElementById("riskTemp").className="a10 cur";
				document.getElementById("riskCode").value=riskCode;
				document.getElementById("areaCode").value=areaCode;
			},
			error:function(){
				alert("查询可投保保险公司失败请重试!");
			}
		});
  }
  //获取保险公司详情
  function getInsureMain(insureCode,riskCode){
	  var obj = document.getElementById("insureTxt");
	  obj.innerHTML = "";
	  $.ajax({
			type:"post",
			url:"getInsureText",
			data:JSON.stringify({
				"insureCode":insureCode,
				"riskCode":riskCode
				}),
			dataType:"json",
			contentType:"application/json;charset=UTF-8",
			success:function(data){
				for(var i=0;i<data.length;i++){
					var item = data[i];
					var br = document.createElement("br");
					var br1 = document.createElement("br");
					var img = document.createElement("img");
					img.src = item.businesslicensepath;
					img.setAttribute("width","200px");
					img.setAttribute("height","140px");
					var img2 = document.createElement("img");
					img2.src = item.certificatepath;
					img2.setAttribute("width","200px");
					img2.setAttribute("height","140px");
					var p = document.createElement("p");
					p.style="float:left; font-weight:bold;";
					p.innerHTML="备案名称:"+item.beianname;
					var p2 = document.createElement("p");
					p2.style="float:left; font-weight:bold; margin-left:50px;";
					p2.innerHTML="备案号:"+item.beianno;
					var p3 = document.createElement("p");
					p3.style="float:left; margin-left:50px;";
					var a = document.createElement("a");
					a.style="clear:both; color:#333; background-color:#FFFFFF; text-decoration:underline;";
					a.href="#";
					a.text="查看条款";
					p3.appendChild(a);
					var p4 = document.createElement("p");
					p4.style="clear:both; margin-top:10px;";
					var a2 = document.createElement("a");
					a2.href="#";
					a2.text="下一步";
					a2.setAttribute("onClick","goPolicyPage()");
					p4.appendChild(a2);
					obj.appendChild(img);
					obj.appendChild(img2);
					obj.appendChild(br);
					obj.appendChild(p);
					obj.appendChild(p2);
					obj.appendChild(p3);
					obj.appendChild(br1);
					obj.appendChild(p4);
				document.getElementById(insureCode).className="a10 cur";
				}
				document.getElementById("insureTxt").style.display="block";
				document.getElementById("insureCode").value=insureCode;
			},
			error:function(){
				alert("查询保险公司详情失败请重试!");
			}
		});
  }