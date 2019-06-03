package com.hsl.crawler.base.position;

import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public interface BaseGetPositionList {
	// 发起get请求获取职位列表，返回的map中，key为positionId，value为该职位的详细信息
	public Map<String,String> getPositionListForGet(HttpClient httpClient,HttpGet get)  throws HttpException ;
	// 发起post请求获取职位列表，返回的map中，key为positionId，value为该职位的详细信息
	public Map<String,String> getPositionListForPost(HttpClient httpClient, HttpPost post, Map<String,String> param)  throws HttpException, Exception ;
}
