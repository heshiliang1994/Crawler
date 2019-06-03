package com.hsl.crawler.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.hsl.crawler.base.constant.Constant;
import com.hsl.crawler.base.constant.LagouContant;

/***
 * 通用工具类
 * 
 * @author hsl
 */
public class CommonUtil {
	/**
	 * 从html生成一个document的实例
	 **/
	public static Document htmlToDoc(String html) {
		Document doc = Jsoup.parse(html);
		return doc;
	}

	/**
	 * @param param
	 *            key为positionId，value为工作的详细信息 将Map转换为 List<NameValuePair>
	 * */
	public static List<NameValuePair> mapToNameValuePair(
			Map<String, String> param) {
		List<NameValuePair> listParam = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : param.entrySet()) {
			NameValuePair pair = new BasicNameValuePair(entry.getKey(),
					entry.getValue());
			listParam.add(pair);
		}
		return listParam;
	}

	/**
	 * @param httpClient
	 * @param get
	 *            发起get请求返回page
	 * */
	public static Map<String, String> sendRequstAndGetResponseGet(
			HttpClient httpClient, HttpGet get) {
		Map<String, String> hashMap = null;
		CloseableHttpResponse response = null ;
		try{
			response = (CloseableHttpResponse) httpClient.execute(get);
			// response中的详细内容
			hashMap = getAllInfo(response, get.getURI().toURL().toString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hashMap;
	}

	/**
	 * @param httpClient
	 * @param post
	 * */
	public static Map<String, String> sendRequstAndGetResponsePost(
			HttpClient httpClient, HttpPost post, Map<String, String> param){
		// 设置httppost的参数和字符编码，避免中文乱码
		List<NameValuePair> nvps = HttpUtil.buildNameValuePair(param);
		Map<String, String> hashMap = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			// 发起请求
			try(CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(post)){
				hashMap = getAllInfo(response, post.getURI().toURL().toString());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hashMap;
	}

	/**
	 * Header数组转换成HashMap
	 * */
	private static Map<String, String> headersToMap(Header headers[]) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (Header header : headers) {
			hashMap.put(header.getName(), header.getValue());
		}
		return hashMap;
	}

	/***
	 * 将所有有用的信息都保存到hashMap中
	 * 
	 * @param response
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private static Map<String, String> getAllInfo(
			CloseableHttpResponse response, String url) {
		Map<String, String> hashMap = new HashMap<String, String>();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			return null;
		}
		HttpEntity responseBody = response.getEntity();
		Header headers[] = response.getAllHeaders();
		// 将response中的所有header放入hashMap中
		for (Header header : headers) {
			hashMap.put(header.getName(), header.getValue());
		}
		// 将url和responseBody放入hashMap中
		hashMap.put(Constant.RESPONSE_URL, url);
		try {
			hashMap.put(Constant.RESPONSE_CONTENT,
					EntityUtils.toString(responseBody));
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		} finally{
			if(response != null){
				try {
					response.close();
					System.out.println(response);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return hashMap;
	}
}
