package com.hsl.crawler.base.request;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;

public interface HttpClientFactory {
	public HttpClient instance();
	public HttpClient instance(RequestConfig config);
	
}
