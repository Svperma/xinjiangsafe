package com.dsib.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import jxl.read.biff.File;

import org.springframework.beans.factory.config.PropertiesFactoryBean;

public class PropertiesUtil {

	private Properties pro;

	public PropertiesUtil(String config) {
		pro = new Properties();
		try {
			InputStream in = new FileInputStream(config);
			pro.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * get property from config file
	 */
	public String getProperty(String name) {
		String propertyName = this.pro.getProperty(name);
		return propertyName;
	}
	
	
	/**
	 * 从baoxianAddress.properties获取地址
	 * @param key
	 * @return
	 */
	public static String getPropertiesValue(String key) {
		return new PropertiesUtil(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "baoxianAddress.properties").getProperty(key);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
