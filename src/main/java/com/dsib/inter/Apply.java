package com.dsib.inter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dsib.controller.BaseController;

public class Apply extends BaseController{
	
	private static String upmaxdatetime = null;
	//String relatively=this.getClass().getClassLoader().getResource("/").getPath();//System.getProperty("user.dir"); 
	
//	String url = relatively+"/src/main/resources/merchantInfo.properties";
//	private static String url = request.getSession().getServletContext().getRealPath("src/main/resources/DataConfig.properties");
//			Thread.currentThread().getContextClassLoader()
//			.getResource("/").getPath();
//	private  String pro_text = url.replaceFirst("/", "")
//			+ "DataConfig.properties";

	/**
	 * 获取merchanInfo.properties文件里的值
	 * @param str properties文件里的键
	 * @return
	 */
	public static String proread(String str) { // 参数获取配置文件的 键值
		String relatively=Apply.class.getClassLoader().getResource("/").getPath();
		String url = relatively+"/merchantInfo.properties";
		System.out.println(relatively);
		Properties pro = new Properties();
		InputStream in = null;
		try {
			Apply c = new Apply();
			in = new FileInputStream(url);
			pro.load(in);
			upmaxdatetime = pro.getProperty(str).trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return upmaxdatetime;
	}
}
