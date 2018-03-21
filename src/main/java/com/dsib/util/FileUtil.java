package com.dsib.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.poi.hssf.usermodel.HSSFBorderFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUtil {
	
	/**
	 * 是否添加合计行
	 */
	private static Boolean isTotal = false;

	/**
	 * 将数组内容封装成实体类
	 * 
	 * @param objs
	 *            bean的各字段的值，数组中值的顺序必须跟实体类中字段定义的顺序一致
	 * @param cla
	 *            要封装成的类
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	public static Object arrayToBean(Object[] objs, String beanPath)
			throws Exception {
		Object obj = null;
		Class clazz = null;
		// 获取类型
		clazz = Class.forName(beanPath);
		// 获取类的构造方法
		Constructor<?> coin[] = clazz.getConstructors();
		for (int i = 0; i < coin.length; i++) {
			Class<?>[] ts = coin[i].getParameterTypes();
			if (ts.length == objs.length) {
				obj = coin[i].newInstance(objs);
				break;
			}
		}
		return obj;
	}

	public static Object generateObject(HttpServletRequest request, Class cla)
			throws Exception {
		Object obj = cla.newInstance();
		String claName = cla.getSimpleName();
		Method[] methods = cla.getDeclaredMethods();
		for (int i = 0, n = methods.length; i < n; i++) {
			Method m = methods[i];
			String method = m.getName();
			if (method.startsWith("set")) {
				String value = request.getParameter(claName
						+ method.replace("set", ""));

				m.invoke(obj, value);
			} else {
				continue;
			}

		}
		return obj;
	}

	/**
	 * @param list
	 *            list中的元素是数组，
	 * @param index
	 *            数组中开始统计的第一个元素的下标
	 * @param end
	 *            统计结束的最后一个元素的下标，如果为0、负数、大于数组的长度或者小于index，则end等于数组的长度
	 * @author xjg
	 */
	public static double[] countData(List list, int index, int end)
			throws Exception {
		double[] data = new double[1];
		if (list != null && list.size() > 0) {
			String[] obj = (String[]) list.get(0);
			if (index - end >= 0 || end < 0 || end > obj.length) {
				end = obj.length;
			}
			data = new double[end - index];
			for (int i = 0; i < list.size(); i++) {
				int m = 0;
				obj = (String[]) list.get(i);
				for (int n = 0; n < obj.length; n++) {
					if (n >= index && n < end) {
						data[m] = data[m]
								+ ((obj[n] == null || "null".equals(obj[n]
										.trim())) ? 0.00 : Double
										.valueOf(((String) obj[n]).trim()));
						m++;
					}
				}
			}
		}
		return data;
	}

	/**
	 * 生成Excel
	 * 
	 * @param String
	 *            [] title 用于存放Excel的标题
	 * @param List
	 *            list 要到出的数据源
	 * @param Class
	 *            cla 数据源中存放的bean
	 * @param String
	 *            excelName excel的名字
	 * @param isSum
	 *            是否求和
	 * @param startColumnIndex
	 *            开始列的下标
	 * @author xjg
	 */
	public static void exportToExcel(String[] title, List list, Class cla,
			String excelName, HttpServletResponse response) {
		try {
			// 创建一个workbook，对应一个Excel
			HSSFWorkbook workBook = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet sheet = workBook.createSheet(excelName);
			// 标题行
			HSSFRow row = sheet.createRow(0);
			// 单元格样式
			HSSFCellStyle style = workBook.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// style.setWrapText(true);
			style.setVerticalAlignment(HSSFCellStyle.ALIGN_FILL);
			style.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
			style.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
			style.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
			style.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// 标题样式
			HSSFCellStyle titleStyle = workBook.createCellStyle();
			titleStyle.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
			titleStyle.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
			titleStyle.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
			titleStyle.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			titleStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT
					.getIndex());
			HSSFFont font = workBook.createFont();
			font.setBold(true);
			font.setColor(HSSFColor.WHITE.index);
			font.setFontHeightInPoints((short) 12);
			titleStyle.setFont(font);
			titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			String[] strs = new String[title.length];
			// 求和
			/*
			 * double[] count = null; if(isSum){ count = new
			 * double[title.length]; }
			 */
			// 添加标题
			HSSFCell cell = null;
			for (int i = 0; i < title.length; i++) {
				String[] t = title[i].split(":");
				strs[i] = t[0];
				cell = row.createCell(i);
				cell.setCellStyle(titleStyle);
				cell.setCellValue(t[1]);
			}
			// 添加内容
			String claName = cla.getSimpleName();
			if (claName.equals("Map")) {
				doMapClass(sheet, list, 2, style, strs);
			} else {
				doObjectClass(sheet, list, 2, cla, style);
			}
			
			/**
			 * 仅限用于保单查询报表下载的合计
			 */
			if(isTotal){
				total(list, sheet);
				isTotal = false;
			}
			 

			downLoadExcel(workBook, response, excelName + ".xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 仅限用于保单查询报表下载的合计
	 */
	private static void total(List list, HSSFSheet sheet) {
		Integer sumEmployee = 0;
		BigDecimal sumPremium = BigDecimal.valueOf(0.00);
		
		for(int i = 0; i < list.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) list.get(i);
			
			String employee = (String) map.get("EMCOUNT");
			BigDecimal premium = (BigDecimal) map.get("SPREADSHEETPREMIUM");
			
			sumEmployee += Integer.valueOf(StringUtils.isEmpty(employee) == true ? "0" : employee);
			sumPremium = sumPremium.add(premium);
			
		}
		
		//创建最后一行
		int sh = sheet.getLastRowNum();
		HSSFRow lastRow = sheet.createRow(sh+1); 
		
		HSSFRow firstRow = sheet.getRow(0);//获取第一行(标题的行)
		
		for(int i = 0; i < firstRow.getLastCellNum(); i++) {
			
			HSSFCell firstCell_i = firstRow.getCell(i);
			HSSFCell lastCell_i = lastRow.createCell(i);
			
			lastCell_i.setCellStyle(firstCell_i.getCellStyle());
			lastCell_i.setCellType(firstCell_i.getCellType());
			lastCell_i.setCellValue("");
			
			if("保单号".equals(firstCell_i.getStringCellValue())) {
				lastCell_i.setCellValue("合计:");
			}
			if("总保费".equals(firstCell_i.getStringCellValue())) {
				lastCell_i.setCellValue(sumPremium.toString());
			}
			if("投保人数".equals(firstCell_i.getStringCellValue())) {
				lastCell_i.setCellValue(sumEmployee.toString());
			}
		}
	}

	/**
	 * 生成Excel,包含多个sheet
	 * 
	 * @param String
	 *            [] titles 用于存放Excel的标题数组
	 *            例：["name1:标题1,name2:标题2","name3:标题3,name4:标题4"]
	 * @param String
	 *            [] lists 要导出的数据源数组，lists的每一项都是list
	 * @param Class
	 *            [] clas 数据源中存放的数据类型
	 * @param String
	 *            excelName excel的名字
	 * @param String
	 *            [] sheetName sheet的名字
	 * @author xjg
	 */
	public synchronized static void exportMultiToExcel(Object[] titles, Object[] lists,
			Class[] clas, Object[] sheetName, String excelName,
			HttpServletResponse response) {

		if (lists == null || lists.length < 1) {
			return;
		}
		// 创建一个workbook，对应一个Excel
		HSSFWorkbook workBook = new HSSFWorkbook();
		// 单元格样式
		HSSFCellStyle style = workBook.createCellStyle();
		style.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 标题样式
		HSSFCellStyle titleStyle = workBook.createCellStyle();
		titleStyle.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
		titleStyle.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
		titleStyle.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
		titleStyle.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		titleStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT
				.getIndex());
		HSSFFont font = workBook.createFont();
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index);
		font.setFontHeightInPoints((short) 12);
		titleStyle.setFont(font);
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		for (int index = 0; index < sheetName.length; index++) {
			int rowNum = 1;
			// 创建sheet
			String stname = sheetName[index].toString();
			HSSFSheet sheet = workBook.createSheet(stname);
			// 标题行
			HSSFRow row = sheet.createRow(0);
			String[] title = (String[]) titles[index];
			String[] strs = new String[title.length];
			// 添加标题
			HSSFCell cell = null;
			for (int i = 0; i < title.length; i++) {
				String[] t = title[i].split(":");
				strs[i] = t[0];
				cell = row.createCell(i);
				cell.setCellStyle(titleStyle);
				cell.setCellValue(t[1]);
			}

			Class cla = clas[index];
			for (int c = 0, t = lists.length; c < t; c++) {
				List list = (List) lists[index];
				if (list == null || list.size() < 1) {
					continue;
				}
				if (cla.getSimpleName().equals("Map")) {
					doMapClass(sheet, list, rowNum, style, strs);
				} else {
					doObjectClass(sheet, list, rowNum, cla, style);
				}
			}

		}
		try {
			downLoadExcel(workBook, response, excelName + ".xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 根据map对象生成excel内容
	@SuppressWarnings("unchecked")
	private static void doMapClass(HSSFSheet sheet, List list,
			int rowBeginIndex, HSSFCellStyle style, String[] keyName) {
		HSSFRow row = null;
		HSSFCell cell = null;
		Map<String, Object> map = null;
		for (int i = 0, n = list.size(); i < n; i++) {
			row = sheet.createRow(rowBeginIndex + i);//创建行
			map = (Map<String, Object>) list.get(i);
			for (int m = 0, l = keyName.length; m < l; m++) {
				cell = row.createCell(m);//行中的小格
				cell.setCellStyle(style);//设置一个样式
				cell.setCellValue(map.get(keyName[m]) == null ? "" : map.get(
						keyName[m]).toString());//小格里添加内容
			}
			for (int m = 0, l = keyName.length; m < l; m++) {
				sheet.autoSizeColumn(m);
			}
		}
		
	}
	

	// 根据实体类对象生成excel内容
	private static void doObjectClass(HSSFSheet sheet, List list,
			int rowBeginIndex, Class cla, HSSFCellStyle style) {
		try {
			Method[] methods = cla.getDeclaredMethods();
			Object obj = cla.newInstance();
			HSSFRow row = null;
			HSSFCell cell = null;
			for (int m = 0; m < list.size(); m++) {
				obj = list.get(m);
				if (obj == null) {
					continue;
				}
				row = sheet.createRow(rowBeginIndex + m);
				for (int i = 0; i < methods.length; i++) {
					Method method = methods[i];
					String mName = method.getName();
					if (mName.startsWith("get")) {
						Object o = method.invoke(obj);
						cell = row.createCell(i);
						cell.setCellStyle(style);
						cell.setCellValue(o == null ? "" : o.toString());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 下载报表
	protected static void downLoadExcel(HSSFWorkbook workBook,
			HttpServletResponse response, String fileName) throws Exception {
		
		String ieType = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getHeader("USER-AGENT");
		response.reset();
		OutputStream out = response.getOutputStream();
		if (ieType.indexOf("Firefox") > 0) {
			response.setHeader("Content-disposition", "attachment;fileName=\""
					+ new String(fileName.getBytes("GB2312"), "ISO-8859-1")
					+ "\"");
		} else {
			response.setHeader("Content-disposition", "attachment;fileName=\""
					+ URLEncoder.encode(fileName, "UTF-8") + "\"");
		}
		response.setContentType("application/msexcel;charset=UTF-8");
		workBook.write(out);
		out.close();
	}

	/**
	 * 上传文件
	 * 
	 * @param fileData
	 */
	public static String uploadFile(MultipartFile fileData,
			HttpServletRequest request) {
		// 获取文件名
		String fileName = fileData.getOriginalFilename();
		if (fileName == null || "".equals(fileName)) {
			return null;
		}
		// 获取文件的后缀名
		String subfix = fileName.substring(fileName.lastIndexOf("."));
		// 重命名文件
		String newFileName = System.currentTimeMillis() + subfix;
		// 读取配置文件
		String url = Thread.currentThread().getContextClassLoader()
				.getResource("/").getPath();
		PropertiesUtil propertiesUtil = new PropertiesUtil(url.replaceFirst(
				"/", "") + "configure.properties");
		// ftp参数
		String serverName = propertiesUtil.getProperty("servername");
		String ftpUrl = propertiesUtil.getProperty("ftp.ftpurl");
		String port = propertiesUtil.getProperty("ftp.port");
		String userName = propertiesUtil.getProperty("ftp.username");
		String password = propertiesUtil.getProperty("ftp.password");

		// 文件保存的路径
		String remotePath = serverName + "/image/azbxImage/"
				+ String.valueOf(request.getServerPort()) + "/" + newFileName;

		FTPClient client = new FTPClient();
		try {
			// 文件输入流
			InputStream in = fileData.getInputStream();
			// 连接ftp

			client.connect(ftpUrl, Integer.valueOf(port));
			client.login(userName, password);

			int reply = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				client.disconnect();
				System.err.println("连接失败");
			}
			client.changeWorkingDirectory("/");
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();
			client.storeFile(
					"/azbxImage/" + String.valueOf(request.getServerPort())
							+ "/" + newFileName, in);
			in.close();
			client.logout();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (client.isConnected()) {
				try {
					client.disconnect();
				} catch (IOException ioe) {
				}
			}
		}

		return remotePath;
	}

	/**
	 * 多文件上传
	 * 
	 * @param request
	 * @return
	 */
	public static List<String> uploadMultiFiles(HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
		// 多文件上传解析器
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断是否是多文件上传
		if (resolver.isMultipart(request)) {
			// 把request转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 迭代器
			Iterator<String> it = multiRequest.getFileNames();
			MultipartFile file = null;
			String pathName = "";
			while (it.hasNext()) {
				file = multiRequest.getFile(it.next());
				pathName = uploadFile(file, request);
				list.add(pathName);
			}
		}
		return list;
	}

	/**
	 * 批量导入
	 * 
	 * @param in
	 *            输入流
	 * @param rowIndex
	 *            开始遍历行下标
	 * @param cellIndex
	 *            开始遍历的列下标
	 * @return
	 */
	public static List<Object[]> batchImport(InputStream in, int rowIndex,
			int cellIndex) {

		try {
			// 得到excel
			HSSFWorkbook workBook = new HSSFWorkbook(in);
			// 获取第一个sheet
			HSSFSheet sheet = workBook.getSheetAt(0);
			// 获取第一行
			HSSFRow firstRow = sheet.getRow(0);
			// 获取每行的列数
			int cellNum = firstRow.getPhysicalNumberOfCells();
			// 获取行数
			int rowNum = sheet.getPhysicalNumberOfRows();

			List<Object[]> list = new ArrayList<Object[]>();
			// object数组，接收每行的值
			Object[] objs = null;
			HSSFRow row = null;
			HSSFCell cell = null;
			for (int i = rowIndex; i < rowNum; i++) {
				objs = new Object[cellNum - cellIndex];
				row = sheet.getRow(i);
				for (int c = cellIndex, m = 0; c < cellNum; c++, m++) {
					cell = row.getCell(c);
					if (cell == null) {
						objs[m] = "";
						continue;
					}
					int type = cell.getCellType();
					switch (type) {
					case HSSFCell.CELL_TYPE_BLANK:
						objs[m] = "";
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						objs[m] = cell.getBooleanCellValue();
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						objs[m] = cell.getCellFormula();
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
						objs[m] = cell.getNumericCellValue();
						break;
					case HSSFCell.CELL_TYPE_STRING:
						objs[m] = cell.getStringCellValue();
						break;
					default:
						objs[m] = cell.getDateCellValue();
						break;
					}
				}
				list.add(objs);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static Boolean getIsTotal() {
		return isTotal;
	}

	/**
	 * 此方法用于触发是否添加合计行
	 * @param b
	 */
	public static void setIsTotal(Boolean b) {
		isTotal = b;
	}
}
