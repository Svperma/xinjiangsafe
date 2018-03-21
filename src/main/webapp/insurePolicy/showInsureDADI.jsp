<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="${basePath }/etpcss/tb.css"> 
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
 <style>
	.para-tab img{
		width:50px;height:50px;
	}
	.para-tab img:hover{
		position:absolute;
		left:70%;
		width:400px;
		height:400px;
	}
	*{
	margin:0;
	padding:0;
	list-style:none;
	text-decoration:none;
	font-family:'微软雅黑';
}
body{
	background-color:#ededed;
}
.panel{
	width:80%;
	padding:20px;
	background-color:#fff;
	margin:0 auto;
	
}
.panel-h2{
	width:60%;
	height:60px;
	padding:5px;
	margin:0 auto;
	line-height:60px;
	text-align:center;
}
.panel-h2-2{
	width:30%;
	margin:0 auto;
	text-align:center;
}
.panel-h3{
	width:25%;
	height:40px;
	padding:5px;
	margin:0 auto;
	line-height:40px;
	text-align:center;
}
.para{
	width:100%;
	padding:5px 0;
}
.para-title{
	font-size:18px;
	font-weight:bold;
	margin:0 20px;
}
.text-title{
	font-size:18px;
	font-weight:bold;
}
.para-title2{
	font-size:18px;
	font-weight:bold;
	margin:10px 0;
}
.kong{
	margin-left:120px;
}
.para-text{
	
}
.text-sl{
	font-size:18px;
	margin:5px 30px;
}
.para-careful{
	width:50%;
	margin:0 auto;
}
.careful-text{
	font-size:18px;
	font-weight:bold;
	margin:5px 0;
}
.para-careful2{
	width:80%;
	margin:0 auto;
}
.careful-text2{
	font-size:18px;
	margin:5px 0;
}
.new-text{
	font-size:18px;
	margin-left:25px;
}
.para-tab{
	width:100%;
}
.para-tab td,.para-tab th{
	border:1px solid #333;
}
 </style>
<html>
  <body>
      <div class="panel">
		<table  border="0" cellspacing="0" cellpadding="0" class="para-tab" style="position:relative;">
			<tr style="background-color:#00a6e3;color:#fff;text-align:center;">
				<th>备案名称</th>
				<th>备案号</th>
				<th>经营许可证</th>
				<th>营业执照</th>
			</tr>
			<tr style="text-align:center;">
				<td>${ggInsurance.beianname }</td>
				<td>${ggInsurance.beianno }</td>
				<td><img src="${ggInsurance.certificatepath }"></td>
				<td><img src="${ggInsurance.businesslicensepath }"></td>
			</tr>
		</table>
	  </div>
      <div class="panel">
		<h2 class="panel-h2">新疆维吾尔自治区安全生产责任保险条款</h2>
		<h3 class="panel-h3">总则</h3>
		<div class="para">
			<span class="para-title">第一条</span>
			<span class="para-text">
				本保险合同由投保单、保险单或其他保险凭证及所附条款、与本合同有关的投保文件、声明、批注、附贴批单及其他书面文件构成。凡涉及本保险合同的约定，均应采用书面形式。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第二条</span>
			<span class="para-text">
				凡在新疆境内依法设立，依法成立并登记注册的煤矿、非煤矿山、危险化学品、烟花爆竹、交通运输、建筑施工、民用爆炸物品、金属冶炼、渔业生产等工矿商贸高危行业或领域从事生产、经营等活动的企业均可作为本保险合同的被保险人。
			</span>
		</div>
		<h3 class="panel-h3">保险责任</h3>
		<div class="para">
			<span class="para-title">第三条</span>
			<span class="para-text">
				在保险期间内，被保险人在生产经营活动过程中，发生生产安全事故或职业病伤害，造成本保险单明细表中列明的从业人员人身伤害的，依照中华人民共和国法律（不包括港澳台地区法律）应由被保险人承担的以下经济赔偿责任，保险人按照本保险合同约定负责赔偿：
			</span>
		</div>
		<div class="para">
			<div class="text-sl">（一）死亡赔偿金;</div>
			<div class="text-sl">（二）残疾赔偿金;</div>
		</div>
		<h3 class="panel-h3">责任免除</h3>
		<div class="para-careful">
			<div class="careful-text">第四条 下列损失、费用和责任，保险人不负赔偿责任：</div>
			<div class="careful-text">（一）安全生产监督管理部门未认定为生产安全事故的事故（事件）造成的损失；</div>
			<div class="careful-text">（二）在事故统计直报系统不能查询的事故（事件）造成的损失；</div>
			<div class="careful-text">（三）安全生产监督管理部门未认定为职业病伤害造成的损失；</div>
			<div class="careful-text">（四）超过本保险合同约定的报案时限才报案的保险责任事故造成的损失；</div>
			<div class="careful-text">（五）医疗费用，精神损害赔偿，罚款、罚金及惩罚性赔款、间接损失；</div>
			<div class="careful-text">（六）其他不属于本保险责任范围内的损失、费用和责任，保险人不负责赔偿。</div>
		</div>
		<h3 class="panel-h3">赔偿限额与免赔额</h3>
		<div class="para">
			<span class="para-title">第五条</span>
			<span class="para-text">
				赔偿限额是保险人按照与投保人约定的对发生保险责任范围内的事故造成的损失予以赔偿的最高金额。赔偿限额包括累计赔偿限额、每次事故赔偿限额、每人死亡赔偿限额、每人残疾赔偿限额，由投保人与保险人协商确定，并在保险单中载明。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第六条</span>
			<span class="para-text">
				每次事故免赔额由投保人与保险人在签订保险合同时协商确定，并在保险单中载明。
			</span>
		</div>
		<h3 class="panel-h3">保险期间</h3>
		<div class="para">
			<span class="para-title">第七条</span>
			<span class="para-text">
				除另有约定外，保险期间为一年，以保险单载明的起讫时间为准。
			</span>
		</div>
		<h3 class="panel-h3">保险人义务</h3>
		<div class="para">
			<span class="para-title">第八条</span>
			<span class="para-text">
				本保险合同成立后，保险人应当及时向投保人签发保险单或其他保险凭证。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第九条</span>
			<span class="para-text">
				保险人应定期组织对被保险人的安全管理、安全教育和保险知识的培训、宣传，监督督促被保险人及时排查安全隐患，预防事故发生，避免和减少损失。对发现的不安全因素和隐患应及时提出整改报告，并提交安全生产监督管理部门。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十条</span>
			<span class="para-text">
				保险人按照本保险条款第二十条规定，认为被保险人提供的有关索赔的证明和资料不完整的，保险人应当及时一次性通知投保人、被保险人补充提供。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十一条 </span>
			<span class="para-text">
				保险人依本条款第十四条取得合同解除权，自保险人知道有解除事由之日起，超过三十日不行使自行消灭。保险人在保险合同订立时已经知道投保人未如实告知的情况的，保险人不得解除合同；发生保险事故的，保险人应当承担赔偿责任。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十二条 </span>
			<span class="para-text">
				保险人收到被保险人的赔偿请求后，应当及时就该请求是否符合保险责任的规定作出核定；情形复杂的，应当在三十日内做出核定，但合同另有约定的除外。
	保险人应当将核定结果通知被保险人。对属于保险责任的，在与被保险人达成有关赔偿金额的协议后十日内，履行赔偿义务。本保险合同对赔偿期限有约定的，保险人应当按照约定履行赔偿义务。保险人依照前款约定作出核定后，对不属于保险责任的，应当自作出核定之日起三日内向被保险人发出拒绝赔偿保险金通知书，并说明理由。
	保险人未履行本条规定义务的，除支付保险金外，应当赔偿被保险人因此受到的损失。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十三条 </span>
			<span class="para-text">
				保险人自收到赔偿保险金的请求和有关证明、资料之日起三十日内，对其赔偿保险金的数额不能确定的，应当根据已有证明和资料可以确定的数额先予支付；保险人最终确定赔偿的数额后，应当支付相应的差额。
			</span>
		</div>
		<h3 class="panel-h3">投保人、被保险人义务</h3>
		<div class="para">
			<span class="para-title">第十四条 </span>
			<span class="para-text">
				投保人应履行如实告知义务，如实回答保险人就被保险人的有关情况提出的询问，并如实填写投保单，提供被保险人的从业人员名单。
			</span>
		</div>
		<div class="para">
			<div class="para-title2"><span class="kong"></span>投保人故意或者因重大过失未履行前款规定的如实告知义务，足以影响保险人决定是否同意承保或者提高保险费率的，保险人有权解除合同。</div>
			<div class="para-title2"><span class="kong"></span>投保人故意不履行如实告知义务的，保险人对于合同解除前发生的保险事故，不承担赔偿或者给付保险金的责任，并不退还保险费。</div>
			<div class="para-title2"><span class="kong"></span>投保人因重大过失未履行如实告知义务，对保险事故的发生有严重影响的，保险人对于合同解除前发生的保险事故，不承担赔偿或者给付保险金的责任，但应当退还保险费。</div>
		</div>
		<div class="para">
			<span class="para-title">第十五条 </span>
			<span class="para-text">
				投保人应按照合同约定缴纳保险费。
			</span>
			<span class="text-title">投保人在约定交费日后交付保险费的，保险人对交费之前发生的保险事故不承担保险责任。</span>
		</div>
		<div class="para">
			<span class="para-title">第十六条 </span>
			<span class="para-text">
				被保险人应严格遵守有关安全生产的法律法规以及其他相关法律、法规及规定，加强管理，采取合理的预防措施，尽力避免或减少责任事故的发生。保险人可以对被保险人遵守前款约定的情况进行检查，向投保人、被保险人提出消除不安全因素和隐患的书面建议，投保人、被保险人应该认真付诸实施。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十七条</span>
			<span class="para-text">
				在保险合同有效期内，被保险人的从业人员发生变动，投保人应按合同约定及时通知保险人，保险人应及时办理批改手续，并按合同约定调整保险费。
			</span>
		</div>
		<div class="para">
			<div class="para-title2"><span class="kong"></span>被保险人未履行前款约定的通知义务，导致保险人未批改的，发生保险事故时，保险人对投保时提供的从业人员名单范围以外的从业人员伤害不负责赔偿。</div>
		</div>
		<div class="para">
			<span class="para-title">第十八条 </span>
			<span class="para-text">
				在保险合同有效期内，如足以影响保险人决定是否继续承保或是否增加保险费的保险合同重要事项变更，被保险人应及时书面通知保险人，保险人有权要求增加保险费或者解除合同。
			</span>
			<div class="para-title2"><span class="kong"></span>被保险人未履行前款约定的通知义务的，因上述保险合同重要事项变更而导致保险事故发生的，保险人不承担赔偿保险金的责任。</div>
		</div>
		<div class="para">
			<span class="para-title">第十九条</span>
			<span class="para-text">
				事故发生时，被保险人应当及时通知安全生产监督管理部门，尽力采取必要的措施，防止或者减少损失。发生生产安全事故或按照职业病防治法规定被诊断、鉴定为职业病，投保人、被保险人应当自事故发生之日或者被诊断、鉴定为职业病之日起30日内，通知保险人。
			</span>
			<div class="para-title2"><span class="kong"></span>投保人、被保险人未在前款约定的时限内通知保险人，对属于保险责任事故伤害的，保险人也不负责赔偿。</div>
		</div>
		<div class="para">
			<span class="para-title">第二十条</span>
			<span class="para-text">
				被保险人向保险人请求赔偿时，应提交下列索赔材料：
			</span>
			<div class="para-careful2">
				<div class="careful-text2">（一）安全生产监督管理部门出具的生产安全事故或者职业病伤害认定书；</div>
				<div class="careful-text2">（二）索赔申请书；</div>
				<div class="careful-text2">（三）保险单；</div>
				<div class="careful-text2">（四）伤亡从业人员名单及身份证明、劳动关系证明（用工合同或工资发放证明等）；</div>
				<div class="careful-text2">（五）从业人员死亡的，提供公安部门或保险人认可的医疗机构出具的死亡证明。若为宣告死亡，须提供人民法院出具的宣告死亡证明；</div>
				<div class="careful-text2">（六）从业人员残疾的，提供伤残鉴定机构或具有伤残鉴定资格的医疗机构出具的残疾鉴定证明；</div>
				<div class="careful-text2">（七）被保险人所能提供的其他与确认保险事故性质、原因、损失程度等有关的证明和资料。</div>
			</div>
		</div>
		<h3 class="panel-h3">赔偿处理</h3>
		<div class="para">
			<span class="para-title">第二十一条</span>
			<span class="para-text">
				险人以下列方式之一确定的被保险人的赔偿责任为基础，按照保险合同的约定进行赔偿：
			</span>
			<div class="para-careful2">
				<div class="careful-text2">（一）安全生产监督管理部门出具的事故调查报告中认定属于生产安全事故或职业病伤害；</div>
				<div class="careful-text2">（二）被保险人和向其提出损害赔偿请求的受害人协商并经保险人确认；</div>
				<div class="careful-text2">（三）仲裁机构裁决；</div>
				<div class="careful-text2">（四）人民法院判决；</div>
				<div class="careful-text2">（五）保险人认可的其它方式。</div>
			</div>
		</div>
		<div class="para">
			<span class="para-title">第二十二条</span>
			<span class="para-text">
				发生本保险合同约定的保险事故时，被保险人对伤亡人员依法应承担的经济赔偿责任，保险人按照以下方式赔付：
			</span>
			<div class="para-careful2">
				<div class="careful-text2">（一）发生人员死亡的，保险人按每人死亡赔偿限额赔付；</div>
				<div class="careful-text2">（二）发生人员残疾的，保险人按劳动保障部门依据《职工工伤与职业病致残程度鉴定标准》（GB/T 16180-2014）出具的《伤残等级鉴定书》确定的伤残等级对应的赔偿限额赔付。</div>
				<div class="careful-text2" style="font-weight:bold;">（三）被保险人的从业人员在从事与业务有关的工作过程中，只有在保险期间内按照职业病防治法规定被诊断、鉴定为职业病，且安全生产监督管理部门出具了属于职业病伤害的认定书，保险人才负责在约定的限额内赔偿。</div>
				<div class="careful-text2" style="font-weight:bold;">（四）在保险期间内，无论发生一次或多次保险事故，保险人对单个从业人员支付的残疾赔偿金之和不超过本保单约定的最高的每人残疾赔偿限额。</div>
				<div class="careful-text2" style="font-weight:bold;">在保险期间内，保险人对单个从业人员因同一保险事故造成两处或两处以上的残疾时，按最重的伤残等级赔付残疾赔偿金。无论发生一次或多次保险事故，保险人对单个从业人员已赔付伤残赔偿金的，在赔付死亡赔偿金时，需扣除已赔付的伤残赔偿金。</div>
			</div>
		</div>
		<div class="para">
			<span class="para-title">第二十三条</span>
			<span class="para-text">
				保险人对每次事故各项损失的赔偿金额之和不超过每次事故赔偿限额，保险人对多次事故的赔偿金额之和不超过累计赔偿限额。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第二十四条</span>
			<span class="para-text">
				在保险责任明确但损失金额尚不能最终确定的情况下，经被保险人申请，保险人可以预先支付赔款，具体预付比例、时间等由双方另行约定。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第二十五条</span>
			<span class="para-text" style="font-weight:bold;">
				被保险人向保险人请求赔偿的诉讼时效期间为二年，自其知道或者应当知道保险事故发生之日起计算。
			</span>
		</div>
		<h3 class="panel-h3">争议处理</h3>
		<div class="para">
			<span class="para-title">第二十六条</span>
			<span class="para-text">
				因履行本保险合同发生的争议，由当事人协商解决。协商不成的，提交安全生产监管部门指定的或由安全生产监管部门成立的调解机构调解；协商、调解不成的，依法向中华人民共和国人民法院起诉。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第二十七条 </span>
			<span class="para-text">
				本保险合同的争议处理适用中华人民共和国法律（不包括港、澳、台地区）。
			</span>
		</div>
		<h3 class="panel-h3">其他事项</h3>
		<div class="para">
			<span class="para-title">第二十八条</span>
			<span class="para-text">
				保险合同成立后，除本保险合同规定的情形及法律另有规定的情形外，保险人不得解除合同。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第二十九条</span>
			<span class="para-text">
				除被保险人被依法关闭、破产、解散而自动解除保险合同的，被保险人不得解除合同。上述原因解除保险合同的，则保险人按日比例计算已生效期间的保险费，退还未了责任的保险费。已发生保险事故，且保险人履行完赔偿责任的，保险人不退还保险费。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第三十条</span>
			<span class="para-text">
				在本保险合同有效期内，本保险自动适用国家立法机关、司法机关或其他行政主管部门新颁布的对安全生产责任保险定性、定责、定损产生影响的法律法规。本保险合同有效期内，本保险自动适用自治区安全生产监督管理部门依法制定的有关安全生产责任保险的规范性文件。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第三十一条</span>
			<span class="para-text">
				本保险合同约定与《中华人民共和国保险法》等法律规定相悖之处，以法律规定为准。本保险合同未尽事宜，以法律规定为准。
			</span>
		</div>
		<h3 class="panel-h3">释义</h3>
		<div class="para">
			<div class="new-text">本保险合同所涉及的下列术语，其含义为：</div>
			<span class="para-title">【生产安全事故】：</span>
			<span class="para-text">
				本保险中的生产安全事故是指符合《生产安全事故报告和调查处理条例》（国务院令第493号）规定的、在生产经营活动中发生的造成人身伤亡或者直接经济损失的生产安全事故。
			</span>
		</div>
		<div class="para">
			<span class="para-title">【职业病】：</span>
			<span class="para-text">
				是指被保险人的从业人员在从事与业务有关的工作过程中，因接触粉尘、放射性物质和其他有毒、有害物质等因素而引起的疾病。
			</span>
		</div>
		<div class="para">
			<span class="para-title">【从业人员】：</span>
			<span class="para-text">
				是指与被保险人存在劳动关系（包括事实劳动关系）的各种用工形式、各种用工期限劳动者。
			</span>
		</div>
		<div class="para">
			<span class="para-title">【第三者】：</span>
			<span class="para-text">
				是指除保险人、被保险人及其从业人员以外的其他组织或个人。
			</span>
		</div>
		<div class="para">
			<span class="para-title">【每次事故】：</span>
			<span class="para-text">
				指与一次生产安全事故或是同一事件引起的一系列生产安全事故。因同一起火灾、爆炸、渗漏等事故造成多人伤亡，导致多人同时或先后向被保险人索赔的，也视为一次保险事故。
			</span>
		</div>
		<div class="para">
			<h3 class="tab-title">短期费率表</h3>
			<table  border="0" cellspacing="0" cellpadding="0" class="para-tab">
				<tr>
					<th>保险期间</th>
					<th>一个月</th>
					<th>二个月</th>
					<th>三个月</th>
					<th>四个月</th>
					<th>五个月</th>
					<th>六个月</th>
					<th>七个月</th>
					<th>八个月</th>
					<th>九个月</th>
					<th>十个月</th>
					<th>十一个月</th>
					<th>十二个月</th>
				</tr>
				<tr>
					<td>年费率的百分比</td>
					<td>20</td>
					<td>30</td>
					<td>40</td>
					<td>50</td>
					<td>60</td>
					<td>70</td>
					<td>75</td>
					<td>80</td>
					<td>85</td>
					<td>90</td>
					<td>95</td>
					<td>100</td>
				</tr>
			</table>
		</div>
	  </div>
	  <div class="panel" style="margin-top:50px;">
		<h2 class="panel-h2">新疆维吾尔自治区安全生产责任保险条款</h2>
		<h2 class="panel-h2-2">附加第三者责任保险条款</h2>
		<h3 class="panel-h3">总则</h3>
		<div class="para">
			<span class="para-title">第一条</span>
			<span class="para-text">
				本附加险只有在投保了新疆维吾尔自治区安全生产责任保险（以下简称“主险”）的基础上，方可投保。
			</span>
		</div>
		<h3 class="panel-h3">保险责任</h3>
		<div class="para">
			<span class="para-title">第二条</span>
			<span class="para-text">
				在保险期间内，被保险人因发生主险合同约定的生产安全事故，造成第三者的人身伤亡和直接财产损失，依法应由被保险人承担的下列经济赔偿责任，保险人将按照本附加险保险合同的约定负责赔偿：
			</span>
			<div class="para">
				<div class="text-sl">（一）死亡赔偿金、伤残赔偿金；</div>
				<div class="text-sl">（二）医疗费用；</div>
				<div class="text-sl">（三）直接财产损失。</div>
			</div>
		</div>
		<h3 class="panel-h3">责任免除</h3>
		<div class="para">
			<span class="para-title">第三条</span>
			<span class="para-text" style="font-weight:bold;">
				在保险期间内，被保险人因发生主险合同约定的生产安全事故，造成第三者的人身伤亡和直接财产损失，依法应由被保险人承担的下列经济赔偿责任，保险人将按照本附加险保险合同的约定负责赔偿：
			</span>
			<div class="para">
				<div class="text-sl" style="font-weight:bold;">（一）精神损害赔偿、间接损失； </div>
				<div class="text-sl" style="font-weight:bold;">（二）金银、首饰、珠宝、文物、软件、数据、现金、信用卡、票据、单证、有价证券、文件、帐册、技术资料及其他不易鉴定价值的财产；</div>
				<div class="text-sl" style="font-weight:bold;">（三）其他不属于本保险责任范围内的损失、费用和责任，保险人不负责赔偿。</div>
			</div>
		</div>
		<h3 class="panel-h3">赔偿限额及免赔额</h3>
		<div class="para">
			<span class="para-title">第四条</span>
			<span class="para-text">
				赔偿限额包括每次事故赔偿限额、累计赔偿限额、每次事故每人伤亡赔偿限额、每次事故每人医疗费用赔偿限额以及每次事故财产损失赔偿限额，由投保人与保险人协商确定，并在本保险合同中载明。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第五条</span>
			<span class="para-text">
				每次事故财产损失、每次事故每人医疗费用免赔额，由投保人与保险人协商确定，并在本保险合同中载明。
			</span>
		</div>
		<h3 class="panel-h3">赔偿处理</h3>
		<div class="para">
			<span class="para-title">第六条</span>
			<span class="para-text" style="font-weight:bold;">
				被保险人给第三者造成损害，该第三者未向被保险人请求赔偿的，保险人不负责向被保险人赔偿保险金。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第七条</span>
			<span class="para-text">
				被保险人请求赔偿时，除需提供主险合同条款中规定的相关资料外，还应提供第三者的书面赔偿请求、伤亡人员名单、身份证明、财产损失清单，涉及医疗费用的还应提供医院的就诊病历、检查报告、医疗费用项目清单、医疗费用原始支付凭证及其他必要、合理的证明材料。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第八条</span>
			<span class="para-text">
				被保险人对第三者依法应承担的符合本附加险合同签发地政府颁布的工伤保险报销范围的下列医疗费用，保险人在扣除每次事故每人医疗费用免赔额后在每人医疗费用赔偿限额内据实赔偿，医疗费用包括：
			</span>
			<div class="para">
				<div class="text-sl">（一）挂号费、治疗费、手术费、检查费、医药费；</div>
				<div class="text-sl">（二）住院期间的床位费、陪护费、伙食费、取暖费、空调费；</div>
				<div class="text-sl">（三）就（转）诊交通费、急救车费;</div>
				<div class="text-sl">（四）安装假肢、假牙、假眼和残疾用具费用。</div>
				<div class="text-sl">除紧急抢救外，受伤人员均应在二级以上（含二级）医院或保险人认可的医疗机构就诊。</div>
				<div class="text-sl" style="font-weight:bold;">第三者的医疗费用已经从其他保险或者其他途径获得全额或部分赔偿，则保险人仅对剩余部分承担赔偿责任。</div>
			</div>
		</div>
		<div class="para">
			<span class="para-title">第九条</span>
			<span class="para-text">
				保险人对每次事故每人人身伤亡、财产损失、医疗费用的赔偿金额均不超过本附加险合同载明的各自赔偿限额。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十条</span>
			<span class="para-text">
				保险人对每次事故人身伤亡、医疗费用和财产损失的赔偿金额之和不超过本附加险合同载明的每次事故赔偿限额；在保险期间内，保险人对第三者责任的累计赔偿金额不超过本附加险合同载明的累计赔偿限额。
			</span>
		</div>
		<h3 class="panel-h3">其他事项</h3>
		<div class="para">
			<span class="para-title">第十一条 </span>
			<span class="para-text">
				本附加险条款与主险条款相抵触的，以本附加险条款为准；本附加险条款未尽事宜，以主险条款为准。主险合同效力终止，本附加险合同效力亦同时终止；主险合同无效，本附加险合同亦无效。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十二条 </span>
			<span class="para-text">
				凡涉及本附加险合同的约定，均应采用书面形式。
			</span>
		</div>
	  </div>
	  <div class="panel" >
		<h2 class="panel-h2">新疆维吾尔自治区安全生产责任保险</h2>
		<h2 class="panel-h2-2">附加从业人员医疗费用保险条款</h2>
		<h3 class="panel-h3">总则</h3>
		<div class="para">
			<span class="para-title">第一条</span>
			<span class="para-text">
				本附加险只有在投保了新疆维吾尔自治区安全生产责任保险（以下简称“主险”）的基础上，方可投保。
			</span>
		</div>
		<h3 class="panel-h3">保险责任</h3>
		<div class="para">
			<span class="para-title">第二条</span>
			<span class="para-text">
				在保险期间内，被保险人因发生主险合同约定的生产安全事故导致其从业人员的人身伤亡，依法应由被保险人承担的医疗费用，保险人按照本附加险合同约定负责赔偿。
			</span>
		</div>
		<h3 class="panel-h3">责任免除</h3>
		<div class="para">
			<span class="para-title">第三条</span>
			<span class="para-text">
				下列费用，保险人不负责赔偿：
			</span>
			<div class="para-title2"><span class="kong"></span>（一）投保从业人员清单中未列明的从业人员的医疗费用；</div>
			<div class="para-title2"><span class="kong"></span>（二）从业人员因疾病（包括职业病）产生的医疗费用；</div>
			<div class="para-title2"><span class="kong"></span>（三）其他不属于生产安全事故导致的从业人员的医疗费用。</div>
		</div>
		<h3 class="panel-h3">赔偿限额及免赔额</h3>
		<div class="para">
			<span class="para-title">第四条</span>
			<span class="para-text">
				赔偿限额包括每人医疗费用赔偿限额、每次事故赔偿限额以及累计赔偿限额，由投保人与保险人协商确定，并在本附加险合同中载明。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第五条</span>
			<span class="para-text">
				每人医疗费用免赔额由投保人与保险人协商确定，并在本附加险合同中载明。
			</span>
		</div>
		<h3 class="panel-h3">赔偿处理</h3>
		<div class="para">
			<span class="para-title">第六条</span>
			<span class="para-text">
				被保险人请求赔偿时，除需提供主险合同条款中规定的资料外，还应提供医院的就诊病历、检查报告、医疗费用项目清单、医疗费用原始支付凭证。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第七条</span>
			<span class="para-text">
				被保险人对其从业人员依法应承担的符合本附加险合同签发地政府颁布的工伤保险报销范围的下列医疗费用，保险人在扣除每次事故每人医疗费用免赔额后在每人医疗费用赔偿限额内据实赔偿，医疗费用包括：
			</span>
			<div class="para">
				<div class="text-sl">（一）挂号费、治疗费、手术费、检查费、医药费；</div>
				<div class="text-sl">（二）住院期间的床位费、陪护费、伙食费、取暖费、空调费；</div>
				<div class="text-sl">（三）就（转）诊交通费、急救车费;</div>
				<div class="text-sl">（四）安装假肢、假牙、假眼和残疾用具费用。</div>
				<div class="text-sl">除紧急抢救外，受伤人员均应在二级以上（含二级）医院或保险人认可的医疗机构就诊。</div>
				<div class="text-sl">第三者的医疗费用已经从其他保险或者其他途径获得全额或部分赔偿，则保险人仅对剩余部分承担赔偿责任。</div>
			</div>
		</div>
		<div class="para">
			<span class="para-title">第八条</span>
			<span class="para-text" style="font-weight:bold;">
				被保险人对其从业人员依法应承担的符合本附加险合同签发地政府颁布的工伤保险报销范围的下列医疗费用，保险人在扣除每次事故每人医疗费用免赔额后在每人医疗费用赔偿限额内据实赔偿，医疗费用包括：
			</span>
		</div>
		<div class="para">
			<span class="para-title">第九条</span>
			<span class="para-text">
				对于损失金额较大且当地政府或安全生产监督管理部门认定被保险人无力继续支付医疗费用的事故，经被保险人申请，保险人应当根据已有证明和资料，在每人赔偿限额内先行垫付医疗费用，最高不超过每次事故赔偿限额。
			</span>
		</div>
		<h3 class="panel-h3">其他事项</h3>
		<div class="para">
			<span class="para-title">第十条</span>
			<span class="para-text">
				本附加险条款与主险条款相抵触的，以本附加险条款为准；本附加险条款未尽事宜，以主险条款为准。主险合同效力终止，本附加险合同效力亦同时终止；主险合同无效，本附加险合同亦无效。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第十一条</span>
			<span class="para-text">
				凡涉及本附加险合同的约定，均应采用书面形式。
			</span>
		</div>
	  </div>
	  <div class="panel">
		<h2 class="panel-h2">新疆维吾尔自治区安全生产责任保险</h2>
		<h2 class="panel-h2-2">附加救援费用保险条款</h2>
		<h3 class="panel-h3">总则</h3>
		<div class="para">
			<span class="para-title">第一条</span>
			<span class="para-text">
				本附加险只有在投保了新疆维吾尔自治区安全生产责任保险（以下简称“主险”）的基础上，方可投保。
			</span>
		</div>
		<h3 class="panel-h3">保险责任</h3>
		<div class="para">
			<span class="para-title">第二条</span>
			<span class="para-text">
				在保险期间内，因生产安全事故导致从业人员或第三者发生意外，为防止或者减少人员伤亡，应由被保险人承担的因采取救援措施而支出的以下列明的救援费用，保险人按照本附加险合同约定负责赔偿：
			</span>
			<div class="para">
				<div class="text-sl">（一）抢险救援人员的劳务费用；</div>
				<div class="text-sl">（二）救援器材、设备的租赁、使用费用；</div>
				<div class="text-sl">（三）单价低于200元人民币的救援工具购置费用；</div>
				<div class="text-sl">（四）事故现场发生的医疗抢救费用。</div>
			</div>
		</div>
		<h3 class="panel-h3">赔偿限额及免赔额</h3>
		<div class="para">
			<span class="para-title">第三条</span>
			<span class="para-text">
				赔偿限额包括每次事故赔偿限额以及累计赔偿限额，由投保人与保险人协商确定，并在本附加险合同中载明。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第四条</span>
			<span class="para-text">
				每次事故救援费用免赔额由投保人与保险人协商确定，并在本附加险合同中载明。
			</span>
		</div>
		<h3 class="panel-h3">赔偿处理</h3>
		<div class="para">
			<span class="para-title">第五条</span>
			<span class="para-text">
				被保险人请求赔偿时，除需提供主险合同条款中规定的相关资料外，还应提供支付的救援费用原始凭证。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第六条</span>
			<span class="para-text">
				对于每次事故发生的救援费用，保险人按照被保险人实际支出的金额，扣除每次事故免赔额后在每次事故赔偿限额内负责赔偿。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第七条</span>
			<span class="para-text">
				在保险期间内，保险人对被保险人支出的所有救援费用的赔偿金额不超过累计赔偿限额。
			</span>
		</div>
		<h3 class="panel-h3">其他事项</h3>
		<div class="para">
			<span class="para-title">第八条</span>
			<span class="para-text">
				本附加险条款与主险条款相抵触的，以本附加险条款为准；本附加险条款未尽事宜，以主险条款为准。主险合同效力终止，本附加险合同效力亦同时终止；主险合同无效，本附加险合同亦无效。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第九条</span>
			<span class="para-text">
				凡涉及本附加险合同的约定，均应采用书面形式。
			</span>
		</div>
	  </div>
	  <div class="panel" style="margin-top:50px;">
		<h2 class="panel-h2">新疆维吾尔自治区安全生产责任保险</h2>
		<h2 class="panel-h2-2">附加法律费用保险条款</h2>
		<h3 class="panel-h3">总则</h3>
		<div class="para">
			<span class="para-title">第一条</span>
			<span class="para-text">
				本附加险只有在投保了新疆维吾尔自治区安全生产责任保险（以下简称“主险”）的基础上，方可投保。
			</span>
		</div>
		<h3 class="panel-h3">保险责任</h3>
		<div class="para">
			<span class="para-title">第二条</span>
			<span class="para-text">
				在保险期间内，发生可能引起保险合同（包括已投保的附加险）项下赔偿的情形时，被保险人被提起诉讼或仲裁，事先经保险人书面同意支付的合理的、必要的诉讼费、鉴定费、取证费、案件受理费、评估费、公证费、律师费、仲裁费及其他相关费用等（以下简称法律费用），保险人依照本附加险合同约定负责赔偿。
			</span>
		</div>
		<h3 class="panel-h3">赔偿限额及免赔额</h3>
		<div class="para">
			<span class="para-title">第三条</span>
			<span class="para-text">
				赔偿限额包括每次事故赔偿限额以及累计赔偿限额，由投保人与保险人协商确定，并在本附加险合同中载明。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第四条</span>
			<span class="para-text">
				每次事故法律费用免赔额由投保人与保险人协商确定，并在本附加险合同中载明。
			</span>
		</div>
		<h3 class="panel-h3">赔偿处理</h3>
		<div class="para">
			<span class="para-title">第五条</span>
			<span class="para-text">
				被保险人请求赔偿时，除需提供主保险合同条款中规定的相关资料外，还应提供有关能够确定被保险人责任及赔偿金额的有关法律文书或经保险人同意，被保险人与受害人达成的赔偿协议及赔偿金支付凭据。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第六条</span>
			<span class="para-text">
				对于每次事故发生的法律费用，保险人按照被保险人实际支出的金额，扣除每次事故免赔额后在每次事故赔偿限额内负责赔偿。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第七条</span>
			<span class="para-text">
				在保险期间内，保险人对被保险人支出的所有法律费用的赔偿金额不超过累计赔偿限额。
			</span>
		</div>
		<h3 class="panel-h3">其他事项</h3>
		<div class="para">
			<span class="para-title">第八条</span>
			<span class="para-text">
				本附加险条款与主险条款相抵触的，以本附加险条款为准；本附加险条款未尽事宜，以主险条款为准。主险合同效力终止，本附加险合同效力亦同时终止；主险合同无效，本附加险合同亦无效。
			</span>
		</div>
		<div class="para">
			<span class="para-title">第九条</span>
			<span class="para-text">
				凡涉及本附加险合同的约定，均应采用书面形式。
			</span>
		</div>
	  </div>
      <div class="maincont_mid_cont_right_bot" style="width:90%;text-align:center;padding:5px;float:left;">
      	<div style="width:300px;margin:0 auto;">
		  <a style="cursor:pointer;width: 80px;height: 22px;padding: 5px 0px;" onclick="cancelSelect()">关闭</a>
		</div>
	  </div>
    <script type="text/javascript">
 function cancelSelect() {
  	window.parent.close();
 }
  </script>
  </body>
</html>
