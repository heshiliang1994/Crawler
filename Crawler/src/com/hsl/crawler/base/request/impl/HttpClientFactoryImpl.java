package com.hsl.crawler.base.request.impl;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;

import com.hsl.crawler.base.request.HttpClientFactory;

public class HttpClientFactoryImpl implements HttpClientFactory {
	
	private RequestConfig config;
	
	/**
	 * 获取 HttpClient 实例
	 **/
	@Override
	public HttpClient instance(){
		HttpClient httpClient = HttpClientBuilder.create().build();
		return httpClient;
	}
	
	/**
	 * 获取 HttpClient 实例，并设置 config
	 * */
	@Override
	public HttpClient instance(RequestConfig config){
		
		HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		return httpClient;
	}
	public RequestConfig getConfig() {
		return config;
	}
	public void setConfig(RequestConfig config) {
		this.config = config;
	}
	
}
