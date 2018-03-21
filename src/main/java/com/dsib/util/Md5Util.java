package com.dsib.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5Util {

	/**
	 * md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			byte[] byt = digest.digest();

			int i = 0;
			StringBuffer buffer = new StringBuffer("");
			for (int offset = 0; offset < byt.length; offset++) {
				i = byt[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buffer.append("0");
				buffer.append(Integer.toHexString(i));
			}
			str = buffer.toString();
		} catch (Exception e) {
		}
		return str.toUpperCase();
	}

	public static String md5Base64(String code) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			return base64Encode(digest.digest(code.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String base64Encode(byte[] by) {
		if (by == null) {
			return null;
		}
		return new BASE64Encoder().encode(by);
	}

	public static void main(String[] args) {
		System.out.println(md5("9999").toUpperCase());
		System.out.println(md5Base64("9999"));
	}
}
