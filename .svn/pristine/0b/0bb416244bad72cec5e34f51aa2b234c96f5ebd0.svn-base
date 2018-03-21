<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css"
	href="${basePath }/etpcss/style.css">
<link href="${basePath }/etpcss/bootstrap-combined.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="${basePath }/etpcss/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${basePath }/js/bootstrap-datetimepicker.js"></script>
<html>
  <body>
  <form action="" enctype="multipart/form-data" method="post" name="fom">
  <div class="maincont_mid_cont_right" style="height:600px;">
			<div class="maincont_mid_cont_right_top" style="  text-align: left;  height: 80px; padding-top: 10px;">
            </div>
               <div class="maincont_mid_cont_right_main" style="background:#fff;'">
                <div style="text-align:left;font-size:20px;margin-left:75px;padding-bottom: 40px;">
                报价状态：
                </div> 
                <div>
                	<table width="80%" style="border:1px solid #CCC;text-align:center;margin:0 auto;" align="center">
                    	<tr style="border-bottom:1px solid #CCC;">
                            <td style="border-right:1px solid #CCC;">保险公司</td>
                            <td style="border-right:1px solid #CCC;">报价状态</td>
                            <td style="border-right:1px solid #CCC;">总保费(元)</td>
                            <td style="border-right:1px solid #CCC;">主险保费(元)</td>
                            <td style="border-right:1px solid #CCC;">附加第三者责任保险保费(元)</td>
                            <td style="border-right:1px solid #CCC;">附加从业人员医疗费用保险保费(元)</td>
                            <td style="border-right:1px solid #CCC;">附加救援费用保险保费(元)</td>
                            <td style="border-right:1px solid #CCC;">附加法律费用保险保费(元)</td>
                            <td style="border-right:1px solid #CCC;">操作</td>
                        </tr>
                        
                        <c:forEach items="${guPolicyInsurePremiumList }" var="gList" varStatus="rowIndex">
				      	  <tr style="border-bottom:1px solid #CCC;">
				          <td style="border-right:1px solid #CCC;" align=center><img src="/images/${gList.insureCode }.jpg" />
				          <input type="hidden" name="insureCode" value="${gList.insureCode }"> 
				          </td>
				          <td style="border-right:1px solid #CCC;" align=center>
				          <c:if test="${gList.flag == 1 }">
				          报价完成
				          </c:if>
				          <c:if test="${gList.flag != 1 }">
				          待报价
				          </c:if>
				          </td>	
				          <td style="border-right:1px solid #CCC;" align=center>${gList.sumPremium }</td>	
				          <td style="border-right:1px solid #CCC;" align=center>${gList.premium }</td>	
				          <td style="border-right:1px solid #CCC;" align=center>${gList.itemkindOne }</td>	
				          <td style="border-right:1px solid #CCC;" align=center>${gList.itemkindTwo }</td>	
				          <td style="border-right:1px solid #CCC;" align=center>${gList.itemkindThree }</td>	
				          <td style="border-right:1px solid #CCC;" align=center>${gList.itemkindFour }</td>	
				          <td style="border-right:1px solid #CCC;" align=center>
				          <div class="maincont_mid_cont_right_bot" style="width: 100%;padding:0px;">
				          	<c:if test="${gList.flag == 1 }">
								<a style="cursor: pointer;display: block;
								margin: auto;width: 108px;height: 22px;padding: 5px 0px;float: none;" onclick="seeInsure('${gList.businessNo }','${gList.insureCode }','${gList.valNo }')">确认投保</a>
							</c:if>
						  </div>
						  </td>	
				          </tr>
				        </c:forEach>
                    </table>
                </div>   
				<div style="text-align:right;">
			    </div>
			</div>
		</div>
	</form>
	<script type="text/javascript"> 
		function seeInsure(gf,fg,gg){
			fom.action = "${basePath}/dsmanager/getThisType?insureCodes="+fg+"&businessNo="+gf+"&valNo="+gg;
			fom.target = "mainFrame";
			fom.submit();
		}
	</script>
</body>
</html>
