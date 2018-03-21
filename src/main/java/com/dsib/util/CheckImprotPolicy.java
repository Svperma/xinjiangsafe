package com.dsib.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.util.StringUtils;

import com.dsib.dao.GuPolicyMainMapper;
import com.dsib.entity.GgCode;
import com.dsib.entity.GuPolicyMain;

public class CheckImprotPolicy {

	/**
	 * 校验数据
	 * 
	 * @param hssfRow
	 *            (批量导入的保单每一行的数据)
	 * @param rowNum
	 *            第几行
	 * @return
	 */
	public String checkPolicy(HSSFRow hssfRow, int rowNum, HttpSession session,
			GuPolicyMainMapper guPolicyMainMapper) {
		StringBuffer resultStr = new StringBuffer(100);

		HSSFCell policyNo = hssfRow.getCell(0);
		HSSFCell startDate = hssfRow.getCell(1);
		HSSFCell endDate = hssfRow.getCell(2);
		HSSFCell appliName = hssfRow.getCell(3);
		HSSFCell appliAddress = hssfRow.getCell(4);
		HSSFCell appliPhoneNo = hssfRow.getCell(5);
		HSSFCell appliLinkName = hssfRow.getCell(6);
		HSSFCell appleEmail = hssfRow.getCell(7);
		HSSFCell insuredName = hssfRow.getCell(8);
		HSSFCell insuredAddress = hssfRow.getCell(9);
		HSSFCell insuredPhoneNo = hssfRow.getCell(10);
		HSSFCell insuredLinkName = hssfRow.getCell(11);
		HSSFCell insuredEmail = hssfRow.getCell(12);
		HSSFCell province = hssfRow.getCell(13);
		HSSFCell city = hssfRow.getCell(14);
		HSSFCell county = hssfRow.getCell(15);
		HSSFCell jobType = hssfRow.getCell(16);
		HSSFCell businessType = hssfRow.getCell(17);
		HSSFCell businesscccCode = hssfRow.getCell(18);
		HSSFCell safeNumber = hssfRow.getCell(19);
		HSSFCell zhuMeiRen = hssfRow.getCell(20);
		HSSFCell zhuMeiCi = hssfRow.getCell(21);
		HSSFCell zhuBaofei = hssfRow.getCell(22);
		// HSSFCell fuSanXianE = hssfRow.getCell(23);
		// HSSFCell fuSanBaoFei = hssfRow.getCell(24);
		// HSSFCell fuYiLiaoXianE = hssfRow.getCell(25);
		// HSSFCell fuYiLiaoBaoFei = hssfRow.getCell(26);
		// HSSFCell fuJiuYuanXianE = hssfRow.getCell(27);
		// HSSFCell fuJiuYuanBaoFei = hssfRow.getCell(28);
		// HSSFCell fuFaLvXianE = hssfRow.getCell(29);
		// HSSFCell fuFaLvBaoFei = hssfRow.getCell(30);
		HSSFCell sumBaoFei = hssfRow.getCell(31);
		HSSFCell EMCOUNT = hssfRow.getCell(32);
		rowNum += 1;// 行数加上 1 否则对应导入的模板行数不对
		if (policyNo == null) {
			resultStr.append("第" + rowNum + "行保单号不能为空;");
		} else {
			GuPolicyMain guPolicyMain = null;
			try {
				guPolicyMain = guPolicyMainMapper
						.selectByPolicyNo(getValue(policyNo));
				if (guPolicyMain != null) {
					resultStr.append("第" + rowNum + "行保单号系统已存在;");
				}
			} catch (Exception e) {
				resultStr.append("第" + rowNum + "行保单号系统已存在;保单号为:" + policyNo);
				e.printStackTrace();
			}

		}
		if (startDate == null) {
			resultStr.append("第" + rowNum + "行起保日期不能为空;");
		} else {
			// 日期格式校验
			String startD = getValue(startDate);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf1.parse(startD);
			} catch (Exception e) {
				resultStr.append("第" + rowNum + "行起保日期格式错误;");
			}
		}
		if (endDate == null) {
			resultStr.append("第" + rowNum + "行终保日期不能为空;");
		} else {
			// 日期格式校验
			String endD = getValue(endDate);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf1.parse(endD);
			} catch (Exception e) {
				resultStr.append("第" + rowNum + "行终保日期格式错误;");
			}
		}
		if (appliName == null) {
			resultStr.append("第" + rowNum + "行投保人姓名不能为空;");
		}
		if (appliAddress == null) {
			resultStr.append("第" + rowNum + "行投保人地址不能为空;");
		}
		if (appliPhoneNo == null) {
			resultStr.append("第" + rowNum + "行投保人联系电话不能为空;");
		}
		if (appliLinkName == null) {
			resultStr.append("第" + rowNum + "行投保联系人姓名不能为空;");
		}
		// if(appleEmail==null){
		// resultStr.append("第"+rowNum+"行投保联系人电子邮箱不能为空;");
		// }
		if (insuredName == null) {
			resultStr.append("第" + rowNum + "行被保险人姓名不能为空;");
		}
		if (insuredAddress == null) {
			resultStr.append("第" + rowNum + "行被保险人地址不能为空;");
		}
		if (insuredPhoneNo == null) {
			resultStr.append("第" + rowNum + "行被保险人联系电话不能为空;");
		}
		if (insuredLinkName == null) {
			resultStr.append("第" + rowNum + "行被保险联系人姓名不能为空;");
		}
		// if(insuredEmail==null){
		// resultStr.append("第"+rowNum+"行被保险人电子邮箱不能为空;");
		// }
		@SuppressWarnings("unchecked")
		Map<String, List<GgCode>> citysMap = (Map<String, List<GgCode>>) session
				.getAttribute("citysMap");
		@SuppressWarnings("unchecked")
		Map<String, List<GgCode>> countysMap = (Map<String, List<GgCode>>) session
				.getAttribute("countysMap");

		Set<String> provinceCodes = citysMap.keySet();// 市级的key是省级的代码

		String provinceCode = substringAreaToCode(province);// 截取导入的省代码
		List<GgCode> cityList = citysMap.get(provinceCode);// 获取省下面的市信息
		Set<String> cityCodes = getAreaCodes(cityList);// 获取某省下的市所有代码

		String cityCode = substringAreaToCode(city);// 截取导入的市代码
		List<GgCode> countyList = countysMap.get(cityCode);// 获取市下面的区县信息
		Set<String> countyCodes = getAreaCodes(countyList);// 获取某市下的所有区县代码

		@SuppressWarnings("unchecked")
		Map<String, List<GgCode>> classCodeMap = (Map<String, List<GgCode>>) session
				.getAttribute("classCodeMap");
		@SuppressWarnings("unchecked")
		Map<String, List<GgCode>> businessClassMap = (Map<String, List<GgCode>>) session
				.getAttribute("businessClassMap");
		
		Set<String> classCodeCodes = classCodeMap.keySet();//行业大类的所有代码
		
		String classCode = substringAreaToCode(jobType);//截取导入保单的行业大类
		List<GgCode> businessCodeList = businessClassMap.get(classCode);//根据行业大类找到所属的经营范围
		Set<String> businessCodes = getAreaCodes(businessCodeList);//所有经营范围的代码
		

		if (province == null) {
			resultStr.append("第" + rowNum + "行归属省不能为空;");
		} else {
			if (getValue(province).length() < 6) {
				resultStr.append("第" + rowNum + "行归属省格式不正确;");
			}
			if (!provinceCodes.contains(provinceCode)) {
				resultStr.append("第" + rowNum + "行归属省代码格式不正确;");
			}
		}
		if (city == null) {
			resultStr.append("第" + rowNum + "行归属市不能为空;");
		} else {
			if (getValue(city).length() < 6) {
				resultStr.append("第" + rowNum + "行归属市格式不正确;");
			}
			if (!cityCodes.contains(cityCode)) {
				resultStr.append("第" + rowNum + "行归属市代码格式不正确;");
			}
		}
		if (county == null) {
			resultStr.append("第" + rowNum + "行归属区县不能为空;");
		} else {
			if (getValue(county).length() < 6) {
				resultStr.append("第" + rowNum + "行归属区县格式不正确;");
			}
			String countyCode = substringAreaToCode(county);
			if (!countyCodes.contains(countyCode)) {
				resultStr.append("第" + rowNum + "行归属区县代码格式不正确;");
			}
		}
		if (jobType == null) {
			resultStr.append("第" + rowNum + "行行业类别不能为空;");
		} else {
			if (getValue(jobType).length() < 6) {
				resultStr.append("第" + rowNum + "行行业类别格式不正确;");
			}
			if(!classCodeCodes.contains(classCode)) {
				resultStr.append("第" + rowNum + "行行业类别代码格式不正确;");
			}
		}
		if (businessType == null) {
			resultStr.append("第" + rowNum + "行经营范围不能为空;");
		} else {
			if (getValue(businessType).length() < 6) {
				resultStr.append("第" + rowNum + "行经营范围格式不正确;");
			}
			String businessCode = substringAreaToCode(businessType);
			if(!businessCodes.contains(businessCode)) {
				resultStr.append("第" + rowNum + "行经营范围代码格式不正确;");
			}
			
		}
		if (businesscccCode == null) {
			resultStr.append("第" + rowNum + "行社会统一信用代码不能为空;");
		} else {
			String businessLicenseNo = getValue(businesscccCode);
			boolean isBusLicenNo = StringUtil
					.isBusinessLicenseNo(businessLicenseNo);
			if (!isBusLicenNo) {
				resultStr.append("第" + rowNum + "行社会统一信用代码不正确;");
			}
		}
		if (safeNumber == null) {
			resultStr.append("第" + rowNum + "行安全生产许可证号不能为空;");
		}
		Pattern pattern = Pattern
				.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		if (zhuMeiRen == null) {
			resultStr.append("第" + rowNum + "行主险每人限额不能为空;");
		} else {
			Matcher isNum = pattern.matcher(getValue(zhuMeiRen));
			if (!isNum.matches()) {
				resultStr.append("第" + rowNum + "行主险每人限额必须为数字;");
			}
		}
		if (rowNum == 428) {
			int i = 0;
		}
		if (zhuMeiCi == null) {
			resultStr.append("第" + rowNum + "行主险每次限额不能为空;");
		} else {
			Matcher isNum = pattern.matcher(getValue(zhuMeiCi));
			if (!isNum.matches()) {
				resultStr.append("第" + rowNum + "行主险每次限额必须为数字;");
			}
		}
		if (zhuBaofei == null) {
			resultStr.append("第" + rowNum + "行主险保费不能为空;");
		}
		if (sumBaoFei == null) {
			resultStr.append("第" + rowNum + "行总保费不能为空;");
		}
		if (EMCOUNT == null) {
			resultStr.append("第" + rowNum + "行投保人数不能为空;");
		} else {
			String emcountStr = getValue(EMCOUNT);
			Matcher isNum = pattern.matcher(getValue(EMCOUNT));
			if (!isNum.matches()) {
				resultStr.append("第" + rowNum + "行投保人数必须为数字;");
			}
			if ("0".equals(emcountStr)) {
				resultStr.append("第" + rowNum + "行投保人数必须大于0;");
			}
		}
		if (resultStr.length() > 0) {
			resultStr.append("\n");
		}
		return resultStr.toString();
	}

	/**
	 * 根据code集合获取地区代码集合
	 * 
	 * @param ggCodes
	 * @return
	 */
	private Set<String> getAreaCodes(List<GgCode> areas) {

		HashSet<String> codecodes = new HashSet<String>();

		if (null == areas || areas.isEmpty()) {
			return codecodes;
		}

		for (GgCode area : areas) {
			codecodes.add(area.getCodeCode());
		}
		return codecodes;
	}

	/**
	 * 获取excel小格里面的值
	 * 
	 * @param hssfCell
	 * @return
	 */
	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			DecimalFormat df = new DecimalFormat("0");
			return String.valueOf(df.format(hssfCell.getNumericCellValue()));
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_FORMULA) {
			double numericCellValue = 0;
			String plainString = null;
			try {
				numericCellValue = hssfCell.getNumericCellValue();
				BigDecimal bd1 = new BigDecimal(numericCellValue);
				plainString = bd1.setScale(2, BigDecimal.ROUND_HALF_UP)
						.toPlainString();
			} catch (Exception e) {
				e.printStackTrace();
				return "ERROR";
			}
			return StringUtils.isEmpty(plainString) == true ? "" : plainString
					.replace(" ", "");
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue()
					.replace(" ", ""));
		}
	}

	/**
	 * 获取批量导入保单的excel里的小格里的址代码
	 * 
	 * @param hssfCell
	 * @return
	 */
	private String substringAreaToCode(HSSFCell hssfCell) {
		String value = getValue(hssfCell);
		String areaCode = value.substring(value.length() - 6);
		return areaCode;
	}

}
