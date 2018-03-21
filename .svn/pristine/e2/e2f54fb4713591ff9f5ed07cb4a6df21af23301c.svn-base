package com.dsib.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonParser;

public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0 || "".equals(str)
				|| str.matches("\\s*") || "null".equals(str);
	}

	/**
	 * 非空判断
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * String 转Date
	 */
	public static Date strToDate(String str) {
		str += " 23:59:59";
		SimpleDateFormat da = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		Date sta = null;
		try {
			sta = da.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sta;
	}

	public static void printForJson(Map obj) {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getResponse();
		response.setContentType("text/html;charset=utf-8");

		PrintWriter pw = null;
		try {
			String json = JsonParser.class.cast(obj).toString();
			pw = response.getWriter();
			pw.write(json);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			pw = null;
		}
	}

	public static String getUUID() {
		String str = "";
		UUID ud = UUID.randomUUID();
		str = ud.toString().replace("-", "").toUpperCase();
		return str;
	}

	public static String date2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = sdf.format(date);
		return str;
	}

	public synchronized static String getBusinessNo() {
		String str = new Long(new Date().getTime()).toString();
		str = str + Long.toString(getRandom(100000000, 999999999));
		str = str.substring(0, 20);
		return str;
	}

	private static long getRandom(final long min, final long max) {
		Random rand = new Random();
		long tmp = Math.abs(rand.nextInt());
		return tmp % (max - min + 1) + min;

	}

	// 判断身份证：要么是15位，要么是18位，最后一位可以为字母，并写程序提出其中的年月日。
	public static void IDCard(String String) {
		while (true) {
			// 提示用户输入身份证号
			System.out.println("请输入身份证号码：");
			// 通过流处理获得用户身份证号
			BufferedReader consoleReader = new BufferedReader(
					new InputStreamReader(System.in));
			String idNum = null;
			try {
				idNum = consoleReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为字母）
			Pattern idNumPattern = Pattern
					.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
			// 通过Pattern获得Matcher
			Matcher idNumMatcher = idNumPattern.matcher(idNum);
			// 判断用户输入是否为身份证号
			if (idNumMatcher.matches()) {
				System.out.println("您的出生年月日是：");
				// 如果是，定义正则表达式提取出身份证中的出生日期
				Pattern birthDatePattern = Pattern
						.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");// 身份证上的前6位以及出生年月日
				// 通过Pattern获得Matcher
				Matcher birthDateMather = birthDatePattern.matcher(idNum);
				// 通过Matcher获得用户的出生年月日
				if (birthDateMather.find()) {
					String year = birthDateMather.group(1);
					String month = birthDateMather.group(2);
					String date = birthDateMather.group(3);
					// 输出用户的出生年月日
					System.out.println(year + "年" + month + "月" + date + "日");
				}
			} else {
				// 如果不是，输出信息提示用户
				System.out.println("您输入的并不是身份证号");
			}
		}
	}
	
	/**
	 * 校验是否是一个社会统一信用代码的格式
	 * @param businessLicenseNo
	 * @return
	 */
	public static boolean isBusinessLicenseNo(String businessLicenseNo) {
		String regex = "[^_IOZSVa-z\\W]{2}\\d{6}[^_IOZSVa-z\\W]{10}";
		boolean b = businessLicenseNo.matches(regex);
		return b;
	}
	
	

	// 验证身份证号码
	public static boolean idCardNumber(String number) {
		String rgx = "^\\d{15}|^\\d{17}([0-9]|X|x)$";
		Pattern p = Pattern.compile(rgx);
		Matcher m = p.matcher(number);
		return m.matches();
	}

	// 验证手机号
	public static boolean phoneNumber(String number) {
		String rgx = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(rgx);
		Matcher m = p.matcher(number);
		return m.matches();
	}
	/**   
     * 功能：身份证的有效验证   
     * @param IDStr 身份证号   
     * @return 有效：返回"" 无效：返回String信息   
     * @throws ParseException   
     */    
    @SuppressWarnings("unchecked")     
    public static String IDCardValidate(String IDStr) throws ParseException {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位。";
            return errorInfo;
        }
        // =======================(end)========================
    
        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return errorInfo;
        }
        // =======================(end)========================     
    
        // ================ 出生年月是否有效 ================     
        String strYear = Ai.substring(6, 10);// 年份     
        String strMonth = Ai.substring(10, 12);// 月份     
        String strDay = Ai.substring(12, 14);// 月份     
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "身份证生日无效。";     
            return errorInfo;     
        }     
        GregorianCalendar gc = new GregorianCalendar();     
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                || (gc.getTime().getTime() - s.parse(
                        strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
            errorInfo = "身份证生日不在有效范围。";     
            return errorInfo;     
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效";     
            return errorInfo;     
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效";     
            return errorInfo;     
        }
        // =====================(end)=====================     
    
        // ================ 地区码时候有效 ================     
        Hashtable h = GetAreaCode();     
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "身份证地区编码错误。";     
            return errorInfo;     
        }
        // ==============================================     
    
        // ================ 判断最后一位的值 ================     
        int TotalmulAiWi = 0;     
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi     
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))     
                    * Integer.parseInt(Wi[i]);     
        }
        int modValue = TotalmulAiWi % 11;     
        String strVerifyCode = ValCodeArr[modValue];     
        Ai = Ai + strVerifyCode;     
    
        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                errorInfo = "身份证无效，不是合法的身份证号码";     
                return errorInfo;     
            }
        } else {
            return "";     
        }
        // =====================(end)=====================     
        return "";     
    }
    /**   
     * 功能：设置地区编码   
     * @return Hashtable 对象   
     */    
    @SuppressWarnings("unchecked")     
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();     
        hashtable.put("11", "北京");     
        hashtable.put("12", "天津");     
        hashtable.put("13", "河北");     
        hashtable.put("14", "山西");     
        hashtable.put("15", "内蒙古");     
        hashtable.put("21", "辽宁");     
        hashtable.put("22", "吉林");     
        hashtable.put("23", "黑龙江");     
        hashtable.put("31", "上海");     
        hashtable.put("32", "江苏");     
        hashtable.put("33", "浙江");     
        hashtable.put("34", "安徽");     
        hashtable.put("35", "福建");     
        hashtable.put("36", "江西");     
        hashtable.put("37", "山东");     
        hashtable.put("41", "河南");     
        hashtable.put("42", "湖北");     
        hashtable.put("43", "湖南");     
        hashtable.put("44", "广东");     
        hashtable.put("45", "广西");     
        hashtable.put("46", "海南");     
        hashtable.put("50", "重庆");     
        hashtable.put("51", "四川");     
        hashtable.put("52", "贵州");     
        hashtable.put("53", "云南");     
        hashtable.put("54", "西藏");     
        hashtable.put("61", "陕西");     
        hashtable.put("62", "甘肃");     
        hashtable.put("63", "青海");     
        hashtable.put("64", "宁夏");     
        hashtable.put("65", "新疆");     
        hashtable.put("71", "台湾");     
        hashtable.put("81", "香港");     
        hashtable.put("82", "澳门");     
        hashtable.put("91", "国外");     
        return hashtable;     
    }
    /**   
     * 功能：判断字符串是否为数字   
     * @param str   
     * @return   
     */    
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");     
        Matcher isNum = pattern.matcher(str);     
        if (isNum.matches()) {     
            return true;     
        } else {
            return false;     
        }
    }
    /**   
     * 功能：判断字符串是否为日期格式   
     * @param str   
     * @return   
     */    
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern     
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");     
        Matcher m = pattern.matcher(strDate);     
        if (m.matches()) {
            return true;     
        } else {
            return false;     
        }
    }
    
/**
	 * 校验两个日期是否大于一年
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isOneYear(Date start, Date end) {
        Calendar startday = Calendar.getInstance();
        Calendar endday = Calendar.getInstance();
        startday.setTime(start);
        endday.setTime(end);
        if (startday.after(endday)) {
            return false;
        }
        Calendar time = Calendar.getInstance();
		time.setTime(start);
		time.add(Calendar.DAY_OF_MONTH, 1);
		time.add(Calendar.YEAR, 1);
		time.add(Calendar.DAY_OF_MONTH, -1);
		Date endDate = time.getTime();
		boolean flag = end.before(endDate);
		if(flag){
			return true;
		}else{
			return false;
		}
    }
	
	/** 
     * 汉语中数字大写 
     */  
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆","伍", "陆", "柒", "捌", "玖" };  
      
//    private static final String[] CN_UPPER_NUMBER = { "零", "一", "二", "三", "四",  
//            "五", "六", "七", "八", "九" };  
    /** 
     * 汉语中货币单位大写，这样的设计类似于占位符 
     */  
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",  
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",  
            "佰", "仟" };  
    /** 
     * 特殊字符：整 
     */  
    private static final String CN_FULL = "整";  
    /** 
     * 特殊字符：负 
     */  
    private static final String CN_NEGATIVE = "负";  
    /** 
     * 金额的精度，默认值为2 
     */  
    private static final int MONEY_PRECISION = 2;  
    /** 
     * 特殊字符：零元整 
     */  
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;  
  
    /** 
     * 把输入的金额转换为汉语中人民币的大写 
     *  
     * @param numberOfMoney 
     *            输入的金额 
     * @return 对应的汉语大写 
     */  
    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {  
        StringBuffer sb = new StringBuffer();  
        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or  
        // positive.  
        int signum = numberOfMoney.signum();  
        // 零元整的情况  
        if (signum == 0) {  
            return CN_ZEOR_FULL;  
        }  
        //这里会进行金额的四舍五入  
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)  
                .setScale(0, 4).abs().longValue();  
        // 得到小数点后两位值  
        long scale = number % 100;  
        int numUnit = 0;  
        int numIndex = 0;  
        boolean getZero = false;  
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11  
        if (!(scale > 0)) {  
            numIndex = 2;  
            number = number / 100;  
            getZero = true;  
        }  
        if ((scale > 0) && (!(scale % 10 > 0))) {  
            numIndex = 1;  
            number = number / 10;  
            getZero = true;  
        }  
        int zeroSize = 0;  
        while (true) {  
            if (number <= 0) {  
                break;  
            }  
            // 每次获取到最后一个数  
            numUnit = (int) (number % 10);  
            if (numUnit > 0) {  
                if ((numIndex == 9) && (zeroSize >= 3)) {  
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);  
                }  
                if ((numIndex == 13) && (zeroSize >= 3)) {  
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);  
                }  
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);  
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);  
                getZero = false;  
                zeroSize = 0;  
            } else {  
                ++zeroSize;  
                if (!(getZero)) {  
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);  
                }  
                if (numIndex == 2) {  
                    if (number > 0) {  
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);  
                    }  
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {  
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);  
                }  
                getZero = true;  
            }  
            // 让number每次都去掉最后一个数  
            number = number / 10;  
            ++numIndex;  
        }  
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负  
        if (signum == -1) {  
            sb.insert(0, CN_NEGATIVE);  
        }  
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整  
        if (!(scale > 0)) {  
            sb.append(CN_FULL);  
        }  
        return sb.toString();  
    }  
}
