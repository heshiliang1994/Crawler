package com.hsl.crawler.base.request.impl;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;

public class HttpRequestRetryHandlerImpl implements HttpRequestRetryHandler{

	@Override
	public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
		if(executionCount > 5){
			// 如果已经重试了5次，就放弃
			return false;
		}
		// 如果服务器丢掉了连接，那么就重试
		if(exception instanceof NoHttpResponseException){
			return true;
		}
		// 不要重试SSL握手异常
		if(exception instanceof SSLHandshakeException){
			return false;
		}
		// 超时
		if(exception instanceof InterruptedIOException){
			return false;
		}
		// 目标主机不可达
		if(exception instanceof UnknownHostException){
			return false;
		}
		// SSL 异常
		if (exception instanceof SSLException) {
			return false;
		}
		HttpClientContext clientContext = HttpClientContext.adapt(context);
		HttpRequest request = clientContext.getRequest();
		// 如果请求是幂等的，就再次尝试
		// HTTP 幂等方法是指无论调用多少次都不会有不同结果的 HTTP 方法
		if(!(request instanceof HttpEntityEnclosingRequest)){
			return true;
		}
		return false;
	}

}
