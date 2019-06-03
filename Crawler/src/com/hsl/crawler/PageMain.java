package com.hsl.crawler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hsl.crawler.entity.Page;
import com.hsl.crawler.mapper.PageMapper;

public class PageMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PageMapper mapper = (PageMapper)context.getBean("pageMapper");
		PlatformTransactionManager transactionManager = (PlatformTransactionManager) context.getBean("transactionManager");
		
		// 开启事务
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try{
			int startPage = 1;
			int endPage = 29;
			for(int i=startPage ; i<=endPage ; i++){
				Page page = new Page();
				page.setPage(i);
				mapper.insertSelective(page);
			}
			transactionManager.commit(status);
		} catch( Exception e){
			transactionManager.rollback(status);
			e.printStackTrace();
		}
	}
}
