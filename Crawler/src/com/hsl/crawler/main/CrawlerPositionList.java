package com.hsl.crawler.main;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.http.HttpException;
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
import com.hsl.crawler.entity.PageExample;
import com.hsl.crawler.entity.PositionWithBLOBs;
import com.hsl.crawler.entity.Topic;
import com.hsl.crawler.extract.BasePageExtract;
import com.hsl.crawler.mapper.PageMapper;
import com.hsl.crawler.mapper.PositionMapper;
import com.hsl.crawler.mapper.TopicMapper;
import com.hsl.crawler.util.LagouUtil;
import com.hsl.crawler.util.LoadProperties;

/***
 * 爬取拉勾网的职位列表（从page表中取记录，一页一页爬取）
 * 
 * @author 17646
 *
 */
public class CrawlerPositionList {

	@Autowired
	private PageMapper pageMapper;
	@Autowired
	private TopicMapper topicMapper;
	@Autowired
	private PositionMapper positionMapper; 
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
	@Autowired
	private BasePageExtract extract;
	
	public void crawler() throws InterruptedException{
		PageExample example = new PageExample();
		example.createCriteria().andStatusEqualTo(0);
		List<Page> list = pageMapper.selectByExample(example);
		Random random = new Random();
		for (Page page : list) {
			Thread.sleep((int)(Math.random() * 10000));
			// 发起网络请求，获取当前page的详细内容
			LagouUtil.refreshCookie(httpClient, get, cookieStore);
			Topic topic = topicMapper.selectByPrimaryKey(page.getTopicid());
			try {
				System.out.println(page.getPage() + " === "+post);
				String content = LagouUtil.getPageContentForPost(httpClient,
						post, page.getPage(), topic.getKeyword());
				Map<String, String> map = extract
						.extractPositionListFromJson(content);
				TransactionDefinition def = new DefaultTransactionDefinition();
				TransactionStatus status = transactionManager.getTransaction(def);
				try{
					for (Entry<String, String> entry : map.entrySet()) {
						PositionWithBLOBs position = new PositionWithBLOBs();
						position.setPageid(page.getPageid());
						position.setPositionid(entry.getKey());
						position.setDescription(entry.getValue());
						position.setStatus(Constant.WAITING_CRAWlE);
						positionMapper.insert(position);
					}
					page.setStatus(Constant.SUCCESSFULLY_CRAWLED);
					pageMapper.updateByPrimaryKey(page);
					// 插入正常，提交
					transactionManager.commit(status);
				} catch (Exception e){
					// 发生错误，回滚
					transactionManager.rollback(status);
					e.printStackTrace();
				}
			} catch (HttpException | IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CrawlerPositionList crawler = (CrawlerPositionList)context.getBean("crawlerPositionList");
		try {
			crawler.crawler();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
