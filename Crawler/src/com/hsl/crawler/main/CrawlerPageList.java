package com.hsl.crawler.main;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hsl.crawler.base.constant.Constant;
import com.hsl.crawler.entity.Page;
import com.hsl.crawler.entity.Topic;
import com.hsl.crawler.entity.TopicExample;
import com.hsl.crawler.extract.impl.LagouTopicExtract;
import com.hsl.crawler.mapper.PageMapper;
import com.hsl.crawler.mapper.TopicMapper;
import com.hsl.crawler.util.LagouUtil;
import com.hsl.crawler.util.LoadProperties;

public class CrawlerPageList {
	// 公共部分
	@Autowired
	private PlatformTransactionManager transactionManager;
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
	// 特有的
	@Autowired
	private TopicMapper topicMapper;
	@Autowired
	private PageMapper pageMapper;
	// 内容提取
	@Autowired
	private LagouTopicExtract lagouTopicExtract;
	
	// 爬虫主入口
	public void crawler(){
		TopicExample example = new TopicExample();
		example.createCriteria().andStatusEqualTo(0);
		List<Topic> list = topicMapper.selectByExample(example);

		for(Topic topic:list){
			LagouUtil.refreshCookie(httpClient, get, cookieStore);
			try {
				String content = LagouUtil.getPageContentForPost(httpClient,
						post, 1, topic.getKeyword());
				int countOfEachPage = lagouTopicExtract.extractCountOfEachPage(content);
				int totalCount = lagouTopicExtract.extractTotalCount(content);
				int totalPage = (int)Math.ceil((double) totalCount / (double)countOfEachPage);
				// 开启事务
				TransactionDefinition def = new DefaultTransactionDefinition();
				TransactionStatus status = transactionManager.getTransaction(def);
				try{
					// 保存page
					for(int i=1;i <= totalPage ; i++){
						Page page = new Page();
						page.setTopicid(topic.getTopicid());
						page.setPage(i);
						page.setStatus(Constant.WAITING_CRAWlE);
						pageMapper.insert(page);
					}
					topic.setStatus(Constant.SUCCESSFULLY_CRAWLED);
					topicMapper.updateByPrimaryKey(topic);
					// 正常爬取，提交事务
					transactionManager.commit(status);
				}catch(Exception e){
					e.printStackTrace();
					transactionManager.rollback(status);
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CrawlerPageList crawler = (CrawlerPageList)context.getBean("crawlerPageList");
		crawler.crawler();
	}
}
