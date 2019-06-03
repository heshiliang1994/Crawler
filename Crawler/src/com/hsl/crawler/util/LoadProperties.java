package com.hsl.crawler.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/***
 * 加载配置文件的类
 * @author 17646
 *
 */
public class LoadProperties {
	private Properties properties;
	private Resource resource;
	/***
	 * 构造函数，filepath为classpath中的路径
	 * @param filePath
	 */
	public LoadProperties(String filePath){
		resource = new ClassPathResource(filePath);
		properties = new Properties();
		try {
			properties.load(new FileInputStream(resource.getFile()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String get(String key){
		return (String) properties.get(key);
	}
}
