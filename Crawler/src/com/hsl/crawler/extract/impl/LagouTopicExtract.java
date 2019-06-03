package com.hsl.crawler.extract.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hsl.crawler.extract.BaseTopicExtract;

public class LagouTopicExtract implements BaseTopicExtract{

	/***
	 * 提取每页的数量的路径为：root -> content -> pageSize 
	 */
	@Override
	public int extractCountOfEachPage(String jsonString) {
		jsonString = jsonString.replace("null", "\"\"");
		JsonParser parser = new JsonParser();
		// root 节点
		JsonElement root = parser.parse(jsonString);
		JsonObject positionResult = root.getAsJsonObject();
		int countOfEachPage = positionResult
				.get("content").getAsJsonObject()
				.get("pageSize").getAsInt();
		return countOfEachPage;
	}

	/***
	 * 提取总数量的路径为：root -> content -> positionResult -> totalCount
	 */
	@Override
	public int extractTotalCount(String jsonString) {
		jsonString = jsonString.replace("null", "\"\"");
		JsonParser parser = new JsonParser();
		// root 节点
		JsonElement root = parser.parse(jsonString);
		JsonObject positionResult = root.getAsJsonObject();
		int totalCount = positionResult
				.get("content").getAsJsonObject()
				.get("positionResult").getAsJsonObject()
				.get("totalCount").getAsInt();
		return totalCount;
	}

}
