package com.hsl.crawler.extract.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.hsl.crawler.extract.BasePositionDetailExtract;

/***
 * @author 17646
 * 用于提取工作具体描述（是每个页面进行的）
 */
public class LagouPositionDetailExtract implements BasePositionDetailExtract{
	
	/***
	 * @param string 获得职位的详细描述，每一行用";"分隔
	 * 解析过程如下：elementClass=job-detail 存储到list中
	 */
	@Override
	public String extractContent(String html){
		Document doc = Jsoup.parse(html);
		List<String> list = new ArrayList<String>();
		Elements elements = doc.getElementsByClass("job-detail");
		for(int i=0;i<elements.size();i++){
			// 提取元素中的内容，去掉标签以后的结果
			String text = elements.get(i).text();
			list.add(text);
			/*Elements inner = elements.get(i).getElementsByTag("p");
			Iterator<Element> iterator = inner.iterator();
			while(iterator.hasNext()){
				Element e = iterator.next();
				list.add(e.html());
				System.out.println("===" + e.html() + "===");
			}*/
		}
		StringBuilder sb = new StringBuilder();
		for(String str:list){
			sb.append(str + ";");
		}
		return sb.toString();
	}
}
