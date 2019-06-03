package com.hsl.crawler.base.request.impl;

import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

import com.hsl.crawler.base.request.HttpGetFactory;

/**
 * httpget 工厂
 **/
public class HttpGetFactoryImpl implements HttpGetFactory{
	/*
	 * httpget请求头
	 * */
	private Map<String, String> headers;
	private int timeout ;
	
	/*
	 * 获取 httpget 实例
	 * */
	@Override
	public HttpGet instance(){
		HttpGet get = new HttpGet();
		// 设置请求头header
		for(Map.Entry<String, String> entry:headers.entrySet()){
			get.setHeader(entry.getKey(), entry.getValue());
		}
		// 设置 httpget 的配置信息
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.build();
		get.setConfig(config);
		return get;
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
	
}
