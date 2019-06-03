package com.hsl.crawler.extract.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hsl.crawler.extract.BasePageExtract;

/***
 * @author 17646 从工作列表中提取信息
 */
public class LagouPageExtract implements BasePageExtract {

	/**
	 * 提取步骤为：content -> positionResult -> result -> positionId
	 * 
	 * */
	@Override
	public Map<String, String> extractPositionListFromJson(String jsonString)
			throws Exception {
		jsonString = jsonString.replace("null", "\"\"");
		JsonParser parser = new JsonParser();
		// root 节点
		JsonElement root = parser.parse(jsonString);
		JsonObject positionResult = root.getAsJsonObject();
		JsonArray jarray = positionResult.get("content").getAsJsonObject()
				.get("positionResult").getAsJsonObject().get("result")
				.getAsJsonArray();
		HashMap<String, String> jobs = new HashMap<String, String>();
		for (int i = 0; i < jarray.size(); i++) {
			JsonObject job = jarray.get(i).getAsJsonObject();
			jobs.put(job.get("positionId").toString(), job.toString());
		}
		return jobs;
	}

}
