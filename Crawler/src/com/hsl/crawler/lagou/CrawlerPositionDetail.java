package com.hsl.crawler.lagou;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsl.crawler.entity.PositionExample;
import com.hsl.crawler.entity.PositionWithBLOBs;
import com.hsl.crawler.extract.BasePositionDetailExtract;
import com.hsl.crawler.mapper.PageMapper;
import com.hsl.crawler.mapper.PositionMapper;
import com.hsl.crawler.util.LagouUtil;
import com.hsl.crawler.util.LoadProperties;

public class CrawlerPositionDetail {

	@Autowired
	private PageMapper pageMapper;
	@Autowired
	private PositionMapper positionMapper; 
	@Autowired
	private HttpClient httpClient;
	@Autowired
	private HttpPost post;
	@Autowired
	private HttpGet get;
	@Autowired
	private CookieStore cookieStore;
	@Autowired
	private LoadProperties properties;
	@Autowired
	private BasePositionDetailExtract extract;
	
	public void crawler(){
		PositionExample example = new PositionExample();
		example.createCriteria().andStatusEqualTo(0);
		List<PositionWithBLOBs> list = positionMapper.selectByExampleWithBLOBs(example);
		String cookieURL = properties.get("cookieURL");
		for (PositionWithBLOBs position : list) {
			try {
				Thread.sleep((int)(Math.random() * 10000));
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			System.out.println(position.getPositid() + "====" + get);
			// 发起网络请求，获取当前page的详细内容
			try {
				get.setURI(new URI(cookieURL));
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
			LagouUtil.refreshCookie(httpClient, get, cookieStore);
			try {
				String content = LagouUtil.getPositionDetailForGet(httpClient, get, position.getPositionid());
				String positionDetail = extract.extractContent(content);
				position.setHtml(content);
				position.setContent(positionDetail);
				position.setStatus(1);
				positionMapper.updateByPrimaryKeyWithBLOBs(position);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CrawlerPositionDetail crawler = (CrawlerPositionDetail)context.getBean("crawlerPositionDetail");
		crawler.crawler();
	}
}
