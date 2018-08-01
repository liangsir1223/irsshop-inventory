package com.iresearch.irsshop.inventory.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统初始化监听器
 * @author Administrator
 *
 */
public class InitListener implements ServletContextListener {

	private final static Logger logger = LoggerFactory.getLogger(InitListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("-----------init----------");
		// 初始化工作线程池和内存队列
		RequestProcessorThreadPool.init();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
