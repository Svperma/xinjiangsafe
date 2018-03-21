package com.dsib.inter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.dsib.controller.BaseController;

public class BizInfo extends BaseController {

	private static String interurladdress = null;
	String relativelyPath=System.getProperty("user.dir"); 
//	String url = relativelyPath+"/src/main/resources/DataConfig.properties";
//	private static String url = request.getSession().getServletContext().getRealPath("src/main/resources/DataConfig.properties");
//			Thread.currentThread().getContextClassLoader()
//			.getResource("/").getPath();
//	private  String pro_text = url.replaceFirst("/", "")
//			+ "DataConfig.properties";

	public static String proread(String str) { // 参数获取配置文件的 键值
		String relatively=Apply.class.getClassLoader().getResource("/").getPath();
		String url = relatively+"/DataConfig.properties";
		Properties pro = new Properties();
		InputStream in = null;
		String upmaxdatetime = "";
		try {
			in = new FileInputStream(url);
			pro.load(in);
		    upmaxdatetime = pro.getProperty(str);
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

	public static String pronumber(String str) {
		
		Properties pro = new Properties();
		InputStream in = null;
		try {
			BizInfo c = new BizInfo();
			in = new FileInputStream(c.relativelyPath);
			pro.load(in);
			interurladdress = pro.getProperty(str).trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return interurladdress;
	}

	public static void prowrit(String url, String str) { // 第一个参数为键名 第二个参数为修改的时间
		String relatively=Apply.class.getClassLoader().getResource("/").getPath();
		String ur = relatively+"/DataConfig.properties";

		Properties pro = new Properties();
		try {
			InputStream in = new FileInputStream(ur);
			pro.load(in);
			in.close();
			OutputStream out = new FileOutputStream(ur);
			pro.setProperty(url, str);
			pro.store(out, url);
			out.flush();
			out.close();
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
