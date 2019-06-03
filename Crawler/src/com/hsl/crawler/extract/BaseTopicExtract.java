package com.hsl.crawler.extract;

public interface BaseTopicExtract {
	public int extractCountOfEachPage(String jsonString);
	public int extractTotalCount(String jsonString);
}
