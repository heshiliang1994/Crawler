package com.hsl.crawler.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsl.crawler.entity.PositionExample;
import com.hsl.crawler.entity.PositionWithBLOBs;
import com.hsl.crawler.extract.BasePositionDetailExtract;
import com.hsl.crawler.mapper.PositionMapper;

public class ExtractPositionDetailAndsSplit {
	@Autowired
	private PositionMapper positionMapper; 
	@Autowired
	private BasePositionDetailExtract extract;
	
	public void split(){
		PositionExample example = new PositionExample();
		example.createCriteria().andStatusEqualTo(1).andPositionidEqualTo("6001283");
		List<PositionWithBLOBs> list = positionMapper.selectByExampleWithBLOBs(example);
		for(PositionWithBLOBs position:list){
			String content = extract.extractContent(position.getHtml());
			position.setContent(content);
			positionMapper.updateByPrimaryKeyWithBLOBs(position);
			System.out.println(content);
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ExtractPositionDetailAndsSplit instance = 
				(ExtractPositionDetailAndsSplit)context.getBean("extractPositionDetailAndsSplit");
		instance.split();
	}
}
