package com.hsl.crawler.log;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class Logging {
	private Logger logger = Logger.getLogger(Logging.class); 
	/***
	 * AOP：前置处理
	 */
	public void beforeAdvice(JoinPoint jp){
		// String method = jp.getTarget().getClass().getName()+"."+jp.getSignature().getName();
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		logger.info("Logging Info: " + method + "(" + Arrays.toString(args) + ")");
	}
	
	/***
	 * AOP：后置处理
	 */
	public void afterAdvice(JoinPoint jp){
		
	}
	
	/***
	 * AOP：后置返回处理
	 */
	public void afterReturningAdvice(JoinPoint jp, Object returnVal){
		// jp.getTarget().getClass().getName()获取类名
		// String method = jp.getTarget().getClass().getName()+"."+jp.getSignature().getName();
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		logger.info("Logging Info: " + method + "(" + Arrays.toString(args) + ") , return = " + returnVal);
	}
	
	/***
	 * AOP：抛出异常处理
	 */
	public void afterThrowingAdvice(JoinPoint jp, Exception err){
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		logger.info("Logging Info: " + method + "(" + Arrays.toString(args) + ") , Exception = " +
		err.getMessage());
//		err.printStackTrace();
	}
}
