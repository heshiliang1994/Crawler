package com.hsl.crawler.base.request;

import org.apache.http.client.methods.HttpPost;

public interface HttpPostFactory {
	public HttpPost instance();
	public HttpPost updateCookie(HttpPost post, String cookie);
}
