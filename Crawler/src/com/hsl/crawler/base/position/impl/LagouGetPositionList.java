package com.hsl.crawler.base.position.impl;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;

import com.hsl.crawler.base.position.BaseGetPositionList;
import com.hsl.crawler.entity.Page;
import com.hsl.crawler.extract.BasePageExtract;
import com.hsl.crawler.mapper.PageMapper;
import com.hsl.crawler.util.CommonUtil;
import com.hsl.crawler.util.HttpUtil;

public class LagouGetPositionList implements BaseGetPositionList {
	@Autowired
	private BasePageExtract jobListExtract;

	@Override
	public Map<String, String> getPositionListForGet(HttpClient httpClient,
			HttpGet get) {
		return null;
	}

	/***
	 * 解析出 html 中的职位列表，并以Map<String,String>形式返回
	 */
	@Override
	public Map<String, String> getPositionListForPost(HttpClient httpClient,
			HttpPost post, Map<String, String> param) throws HttpException,
			Exception {
		Map<String, String> page = CommonUtil.sendRequstAndGetResponsePost(
				httpClient, post, param);
		/*Map<String, String> jobList = jobListExtract
				.extractPositionListFromJson(page.getHtml());*/
		return null;
	}
}
