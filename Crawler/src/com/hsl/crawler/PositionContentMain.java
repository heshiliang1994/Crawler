package com.hsl.crawler;

import java.net.URI;
import java.util.ArrayDeque;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.apache.http.HttpException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import com.hsl.crawler.extract.BasePositionDetailExtract;
import com.hsl.crawler.util.LagouUtil;

public class PositionContentMain {
/*	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HttpGet get = (HttpGet)context.getBean("httpGet");
		JobListMapper jobListMapper = (JobListMapper)context.getBean("jobListMapper");
		JobMapper jobMapper = (JobMapper)context.getBean("jobMapper");
		List<LagouJobList> list = jobListMapper.selectAll();
		PlatformTransactionManager transactionManager = (PlatformTransactionManager) context.getBean("transactionManager");
		BasePositionContentExtract extract = (BasePositionContentExtract)context.getBean("lagouJobContentExtract");
		ArrayDeque<LagouJobList> queue = new ArrayDeque<LagouJobList>();
		int index = 0;
		// 获取新的cookie
		String cookieUri = "https://www.lagou.com/jobs/list_Java?isSchoolJob=1";
		get.setURI(new URI(cookieUri));
		CookieStore cookieStore = (CookieStore)context.getBean("cookieStore");
		HttpClient httpClient = (HttpClient)context.getBean("httpClient");
		LagouUtil.refreshCookie(httpClient, get, cookieStore);
		
		while(index <= list.size() - 1 || ! queue.isEmpty())
		{
			LagouJobList jobl = index < list.size()? list.get(index ++):queue.poll();
			get.setURI(new URI("https://www.lagou.com/jobs/" + jobl.getPositionId() + ".html"));
			// 发起 get 请求获取数据
			Page page = RequestAndResponseUtil.sendRequstAndGetResponseGet(httpClient, get);
			jobl.setStatus(1);
			// 开启事务
			TransactionDefinition def = new DefaultTransactionDefinition();
			TransactionStatus status = transactionManager.getTransaction(def);
			try{
				// 从 page 中提取内容
				String contents[] = extract.extractContent(page.getDoc());
				// 没有获取到数据就重新获取
				if(contents.length == 0){
					System.out.println(page.getDoc().toString());
					throw new Exception();
				}
				StringBuilder sb = new StringBuilder();
				for(String content:contents){
					sb.append(content + " ");
				}
				LagouJob job = new LagouJob();
				job.setContent(sb.toString());
				job.setJoblistid(jobl.getId());
				job.setPositionId(jobl.getPositionId());
				jobMapper.insert(job);
				int c = jobListMapper.update(jobl);
				if(c == 0){
					 throw new Exception();
				}
				transactionManager.commit(status);
				Thread.sleep(5000);
			}catch(Exception e){
				e.printStackTrace();
				transactionManager.rollback(status);
				queue.offer(jobl);
				// 刷新cookie
				System.out.println("ERROR==== " + index);
				get.setURI(new URI(cookieUri));
				LagouUtil.refreshCookie(httpClient, get, cookieStore);
				Thread.sleep(10000);
			}
		}
	}*/
}
