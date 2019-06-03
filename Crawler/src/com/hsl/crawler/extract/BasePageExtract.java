package com.hsl.crawler.extract;

import java.util.Map;

public interface BasePageExtract {
	public Map<String,String> extractPositionListFromJson(String jsonString) throws Exception;
}
