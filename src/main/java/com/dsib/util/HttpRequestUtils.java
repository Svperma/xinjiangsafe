package com.dsib.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 接口请求工具类
 */
public class HttpRequestUtils {
	/**
	 * post请求
	 * 
	 * @param url
	 *            url地址
	 * @param formparams
	 * @return
	 */
	public static JSONObject httpPost(String url, List<NameValuePair> formparams) {
		// post请求返回结果
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost httppost = new HttpPost(url);
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			HttpResponse result = httpClient.execute(httppost);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity());
					System.out.println("调用接口返回的值====" + str);
					System.out
							.println("---------------------------------------------------------");
					/** 把json字符串转换成json对象 **/
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					System.out.println("post请求提交失败:" + url);
				}
			}
		} catch (IOException e) {
			System.out.println("post请求提交失败:" + url);
		}
		return jsonResult;
	}
}