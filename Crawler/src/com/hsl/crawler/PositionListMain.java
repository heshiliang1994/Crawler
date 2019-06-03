package com.hsl.crawler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.hsl.crawler.base.position.BaseGetPositionList;
import com.hsl.crawler.entity.Page;
import com.hsl.crawler.util.LagouUtil;
import com.hsl.crawler.util.LoadProperties;

public class PositionListMain {
/*	public static void main(String[] args) throws URISyntaxException, FileNotFoundException, IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从工厂中生成httppost，具体header均从工厂中进行配置
		HttpClient httpClient = (HttpClient)context.getBean("httpClient");
		HttpPost post = (HttpPost)context.getBean("httpPost");
		HttpGet get = (HttpGet)context.getBean("httpGet");
		CookieStore cookieStore = (CookieStore)context.getBean("cookieStore");
		// 读取配置文件
		LoadProperties properties = (LoadProperties) context.getBean("loadProperties");
		// 用于 事务 和 保存数据
		PlatformTransactionManager transactionManager = (PlatformTransactionManager) context.getBean("transactionManager"); 
		PositionsMapper mapper = (PositionsMapper)context.getBean("positionMapper");
		// 用于发起get请求获取 job 的详细内容
		BaseGetPositionList list = (BaseGetPositionList)context.getBean("lagouGetJobList");

		// 设置 起始页 和 结束页
		int startPage = 1;
		int endPage = 29;
		// 循环从队列中
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int index = startPage;
		String keyWord = properties.get("kd");
		// 通过分析这个请求地址发现里面在response header中有几个set-Cookie的选项，选项就是用来设置cookie的，因此可以用来更新cookie
		get.setURI(new URI(properties.get("cookieURL")));
		LagouUtil.refreshCookie(httpClient, get, cookieStore);
		
		while(index <= endPage || ! queue.isEmpty()){
			int pn = index <= endPage ? index: queue.poll();
			Page page = LagouUtil.getPage(httpClient, post, pn, keyWord, 1);
			HashMap<String,String> param = new HashMap<String, String>();
			// 如果页码还没有爬取完，则继续爬取，否则就从队列中取再重新爬取
			param.put("first", "false");
			param.put("pn", "" + page);
			param.put("kd", keyWord);
			Map<String,String> jobs;
			try {
				jobs = list.getJobListForPost(httpClient, post, param);
				LagouJobList[] joblist = LagouUtil.toLagouJobList(jobs);
				// 开启事务
				TransactionDefinition def = new DefaultTransactionDefinition();
				TransactionStatus status = transactionManager.getTransaction(def);
				try{
					for(LagouJobList jo:joblist){
						mapper.insert(jo);
					}
					transactionManager.commit(status);
				}catch (DataAccessException e) {
			       System.out.println("Error in creating record, rolling back");
			       transactionManager.rollback(status);
			       throw e;
			    }
			} catch (Exception e) {
				LagouUtil.refreshCookie(httpClient, get, cookieStore);
				queue.add(index);
				e.printStackTrace();
				System.out.println("ERROR===="+index);
				break;
			}
			// 等待 10s 再发起下次请求
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// index ++ ，获取下一页内容
			index ++;
		}
	}*/
}
