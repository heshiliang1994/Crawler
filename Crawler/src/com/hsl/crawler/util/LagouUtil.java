package com.hsl.crawler.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;

import com.hsl.crawler.base.constant.Constant;
import com.hsl.crawler.base.constant.LagouContant;

public class LagouUtil {
	
	/***
	 * 发起post请求获取page的具体内容
	 * @param httpClient
	 * @param post
	 * @param pn
	 * @param keyWord
	 * @return 返回page内容
	 * @throws IOException 
	 * @throws HttpException 
	 * @throws ClientProtocolException 
	 */
	public static String getPageContentForPost(HttpClient httpClient, HttpPost post, int pn, String keyWord) throws ClientProtocolException, HttpException, IOException{
		HashMap<String,String> param = new HashMap<String, String>();
		// 如果页码还没有爬取完，则继续爬取，否则就从队列中取再重新爬取
		param.put("first", "false");
		param.put(LagouContant.PAGE, "" + pn);
		param.put(LagouContant.KEYWORD, keyWord);
		// 设置httppost的参数和字符编码，避免中文乱码
		Map<String,String> map = CommonUtil.sendRequstAndGetResponsePost(httpClient, post, param);
		return map.get(Constant.RESPONSE_CONTENT);
	}
	
	public static String getPositionDetailForGet(HttpClient httpClient, HttpGet get, String positionId){
		String result = null;
		try {
			get.setURI(new URI("https://www.lagou.com/jobs/" + positionId + ".html"));
			Map<String,String> map = CommonUtil.sendRequstAndGetResponseGet(httpClient, get);
			result = map.get(Constant.RESPONSE_CONTENT);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/***
	 * 将 Map 转换成 LagouJobList 数组
	 * @param jobs
	 * @return
	 */
/*	public static LagouJobList[] toLagouJobList(Map<String,String> jobs){
		LagouJobList[] joblist = new LagouJobList[jobs.size()];
		int index = 0;
		for(Entry<String, String> entry : jobs.entrySet()){
			LagouJobList ljl= new LagouJobList();
			ljl.setPositionId(entry.getKey());
			try {
				String s = new String(entry.getValue().getBytes("UTF-8"),"UTF-8");
				ljl.setContent(s);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
			joblist[index ++]  = ljl;
		}
		return joblist;
	}*/
	
	/***
	 * 刷新cookie
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static HttpPost reBuildHttpPost(HttpClient client, Header[] postHeaders, HttpPost post, HttpGet get) {
		String url = "https://www.lagou.com/";
		try {
			get.setURI(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		HttpResponse response;
		try {
			response = client.execute(get);
			Map<String, String> getHeaders = toMap(response.getAllHeaders());
			String cookie = "";
			if(getHeaders.containsKey("Cookie")){
				cookie = getHeaders.get("Cookie");
			}
			System.out.println(cookie);
			return resetPost(post, postHeaders, cookie);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/***
	 * 重置post
	 * @param post
	 * @param headers
	 * @return
	 */
	private static HttpPost resetPost(HttpPost post, Header[] postHeaders, String cookie){
		for(Header header:postHeaders){
			post.setHeader(header);
		}
		post.setHeader("Cookie", cookie);
		// 设置config
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(5000)
				.build();
		post.setConfig(config);
		return post;
	}
	
	/***
	 * 登录以刷新cookie
	 * @param httpClient
	 * @param get
	 * @param url
	 * @return 返回的是新的cookie，组成为 user_trace_token 和  X_HTTP_TOKEN
	 */
	public static String refreshCookie(HttpClient httpClient, HttpGet get, CookieStore cookieStore){
		System.out.println("刷新cookie==========================");
		String user_trace_token = "";
		String X_HTTP_TOKEN = "";
		CloseableHttpResponse response = null;
		try {
			/*String cookieUri = "https://www.lagou.com/jobs/list_Java?isSchoolJob=1";
			get.setURI(new URI(cookieUri));*/
			// HttpResponse response = 
			response = (CloseableHttpResponse)httpClient.execute(get);
			List<Cookie> cookies = cookieStore.getCookies();
			for(int i=0;i<cookies.size();i++){
				if(cookies.get(i).getName().equals("user_trace_token")){
					user_trace_token = cookies.get(i).getValue();
				} else if(cookies.get(i).getName().equals("X_HTTP_TOKEN")){
					X_HTTP_TOKEN = cookies.get(i).getValue();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "user_trace_token="+user_trace_token+";X_HTTP_TOKEN"+X_HTTP_TOKEN;
	}
	
	public static Map<String, String> toMap(Header[] headers){
		Map<String, String> map = new HashMap<String, String>();
		for(Header header: headers){
			map.put(header.getName(), header.getValue());
		}
		return map;
	}
}
