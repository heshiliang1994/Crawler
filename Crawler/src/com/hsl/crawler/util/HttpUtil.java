package com.hsl.crawler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtil {

	/**
	 * @param param key为positionId，value为工作的详细信息
	 * 将Map转换为 List<NameValuePair>
	 * */
	public static List<NameValuePair> buildNameValuePair(Map<String, String> param) {
		List<NameValuePair> listParam = new ArrayList<NameValuePair>();
		for(Entry<String, String> entry : param.entrySet()){
			NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
			listParam.add(pair);
		}
		return listParam;
	}
	
}
