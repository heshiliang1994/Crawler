package com.hsl.crawler.base.request.impl;

import java.net.URI;
import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

import com.hsl.crawler.base.request.HttpPostFactory;

/**
 * httppost工厂
 **/
public class HttpPostFactoryImpl implements HttpPostFactory{
	/**
	 * httppost 头信息
	 **/
	private Map<String, String> headers;
	private Map<String, String> params;
	private int timeout ;
	private URI uri;
	
	/**
	 * 获取httppost实例
	 **/
	@Override
	public HttpPost instance(){
		HttpPost post = new HttpPost();
		// 设置uri
		post.setURI(uri);
		// 设置header
		for(Map.Entry<String, String> entry:headers.entrySet()){
			post.setHeader(entry.getKey(), entry.getValue());
		}
		// 设置config
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.build();
		post.setConfig(config);
		return post;
	}
	
	@Override
	public HttpPost updateCookie(HttpPost post, String cookie){
		// 设置header
		for(Map.Entry<String, String> entry:headers.entrySet()){
			if(entry.getKey().equals("Cookie")){
				post.setHeader(entry.getKey(), cookie);	
			}else{
				post.setHeader(entry.getKey(), entry.getValue());
			}
		}
		return post;
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}
	
}
