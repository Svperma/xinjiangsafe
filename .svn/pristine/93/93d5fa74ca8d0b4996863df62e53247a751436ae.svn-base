package com.dsib.inter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dsib.entity.GgUserCorp;
import com.dsib.service.GuInterfaceService;

public class TrimerQuartz {

	@Resource(name = "GuInterface")
	private GuInterfaceService interService;

	public void doSomething() {
		String url = BizInfo.pronumber("getusercorp"); // 获取企业接口
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		String upmaxdatetime = BizInfo.proread("upmaxdatetime");
		System.out.println(upmaxdatetime);
		String threeCode = BizInfo.proread("usercorp");
		pairs.add(new BasicNameValuePair("tertiaryCode", threeCode));// 第三方机构
		pairs.add(new BasicNameValuePair("changeDate", upmaxdatetime));//
		// 传入调用时间
		String json = HttpRequestUtils.httpPost(url, pairs); // 获取的json对象
		System.out.println("JSONOBJECR" + json);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = upmaxdatetime;// 保存更新时间
		System.out.println(json.substring(0, 1));
		if (json.substring(0, 1).equals("[")) {
			List<GgUserCorp> userList = new ArrayList<GgUserCorp>();
			JSONArray arrayResult = (JSONArray) JSONArray.parse(json);
			for (int i = 0; i < arrayResult.size(); i++) {
				JSONObject objectResult = (JSONObject) arrayResult.get(i);
				String address = objectResult.getString("address");
				String businessClass = objectResult.getString("businessClass");
				String businessLicenseImage = objectResult
						.getString("businessLicenseImage");
				String businessLicenseNo = objectResult
						.getString("businessLicenseNo");
				String city = objectResult.getString("city");
				String classCode = objectResult.getString("classCode");
				String county = objectResult.getString("county");
				String emCount = objectResult.getString("emCount");
				String email = objectResult.getString("email");
				String fax = objectResult.getString("fax");
				String flag = objectResult.getString("flag");
				String linkName = objectResult.getString("linkName");
				String moble = objectResult.getString("moble");
				String postCode = objectResult.getString("postCode");
				String province = objectResult.getString("province");
				String remark = objectResult.getString("remark");
				String safetyLevel = objectResult.getString("safetyLevel");
				String safetyLicenseImage = objectResult
						.getString("safetyLicenseImage");
				String safetyLicenseNo = objectResult
						.getString("safetyLicenseNo");
				String scale = objectResult.getString("scale");
				String standardLevelImage = objectResult
						.getString("standardLevelImage");
				JSONObject updateDate = objectResult
						.getJSONObject("updateDate");
				long chang = Long.parseLong(updateDate.getString("time"));// long型的time更新时间
				Date updatetime = new Date(chang);
				String update = sim.format(updatetime);
				System.out.println(update.compareTo(time));
				if (update.compareTo(time) > 0) { // 对配置文件的更新时间进行修改
					time = update;
				}
				String userCode = objectResult.getString("userCode");
				String userName = objectResult.getString("userName");
				String underFlag = objectResult.getString("underFlag");
				GgUserCorp usercorp = new GgUserCorp();
				usercorp.setCompanyAddress(address);
				usercorp.setBusinessClass(businessClass);
				usercorp.setBusinessLicenseImage(businessLicenseImage);
				usercorp.setBusinessLicenseNo(businessLicenseNo);
				usercorp.setCity(city);
				usercorp.setClassCode(classCode);
				usercorp.setCounty(county);
				usercorp.setEmCount(Integer.parseInt(emCount));
				usercorp.setEmail(email);
				usercorp.setFax(fax);
				usercorp.setFlag(flag);
				usercorp.setLinkName(linkName);
				usercorp.setMobile(moble);
				usercorp.setPost(postCode);
				usercorp.setProvince(province);
				usercorp.setRemark(remark);
				usercorp.setStandardLevel(safetyLevel);
				usercorp.setSafetyLicenseImage(safetyLicenseImage);
				usercorp.setSafetyLicenseNo(safetyLicenseNo);
				usercorp.setStandardLevelImage(standardLevelImage);
				usercorp.setClassSize(scale);
				usercorp.setUserCode(userCode);
				usercorp.setCompanyName(userName);
				usercorp.setValidStatus(underFlag);
				userList.add(usercorp);

			}
			MessgeMail message = interService.upDataUserCorp(userList);
			if (message.isItems()) {
				BizInfo.prowrit("upmaxdatetime", time);
				System.out.println("更新的时间" + time);
			} else {
//				SendMail.send(message.getMessge());
			}
		}
		JSONObject objectResulte = JSONObject.parseObject(json);
		if (json.substring(0, 1).equals("{")
				&& !objectResulte.getString("changFlag").equals("N")) {
			JSONObject objectResult = JSONObject.parseObject(json);
			String address = objectResult.getString("address");
			String businessClass = objectResult.getString("businessClass");
			String businessLicenseImage = objectResult
					.getString("businessLicenseImage");
			String businessLicenseNo = objectResult
					.getString("businessLicenseNo");
			String city = objectResult.getString("city");
			String classCode = objectResult.getString("classCode");
			String county = objectResult.getString("county");
			String emCount = objectResult.getString("emCount");
			String email = objectResult.getString("email");
			String fax = objectResult.getString("fax");
			String flag = objectResult.getString("flag");
			String linkName = objectResult.getString("linkName");
			String moble = objectResult.getString("moble");
			String postCode = objectResult.getString("postCode");
			String province = objectResult.getString("province");
			String remark = objectResult.getString("remark");
			String safetyLevel = objectResult.getString("safetyLevel");
			String safetyLicenseImage = objectResult
					.getString("safetyLicenseImage");
			String safetyLicenseNo = objectResult.getString("safetyLicenseNo");
			String scale = objectResult.getString("scale");
			String standardLevelImage = objectResult
					.getString("standardLevelImage");
			JSONObject updateDate = objectResult.getJSONObject("updateDate");
			long chang = Long.parseLong(updateDate.getString("time"));// long型的time更新时间
			Date updatetime = new Date(chang);
			String update = sim.format(updatetime);
			System.out.println(update.compareTo(time));
			if (update.compareTo(time) > 0) { // 对配置文件的更新时间进行修改
				time = update;
			}
			String userCode = objectResult.getString("userCode");
			String userName = objectResult.getString("userName");
			String underFlag = objectResult.getString("underFlag");
			GgUserCorp usercorp = new GgUserCorp();
			usercorp.setCompanyAddress(address);
			usercorp.setBusinessClass(businessClass);
			usercorp.setBusinessLicenseImage(businessLicenseImage);
			usercorp.setBusinessLicenseNo(businessLicenseNo);
			usercorp.setCity(city);
			usercorp.setClassCode(classCode);
			usercorp.setCounty(county);
			usercorp.setEmCount(Integer.parseInt(emCount));
			usercorp.setEmail(email);
			usercorp.setFax(fax);
			usercorp.setFlag(flag);
			usercorp.setLinkName(linkName);
			usercorp.setMobile(moble);
			usercorp.setPost(postCode);
			usercorp.setProvince(province);
			usercorp.setRemark(remark);
			usercorp.setStandardLevel(safetyLevel);
			usercorp.setSafetyLicenseImage(safetyLicenseImage);
			usercorp.setSafetyLicenseNo(safetyLicenseNo);
			usercorp.setStandardLevelImage(standardLevelImage);
			usercorp.setClassSize(scale);
			usercorp.setUserCode(userCode);
			usercorp.setCompanyName(userName);
			usercorp.setValidStatus(underFlag);
			MessgeMail message = interService.upDateUserCorpsign(usercorp);
			if (message.isItems()) {
				BizInfo.prowrit("upmaxdatetime", time);
			} else {
//				SendMail.send(message.getMessge());
			}
		}
	}
}