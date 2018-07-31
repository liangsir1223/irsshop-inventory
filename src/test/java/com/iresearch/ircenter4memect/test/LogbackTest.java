
package com.iresearch.ircenter4memect.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

	private final static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

	public static void main(String[] args) {
		logger.info("logback 成功了");
		logger.error("logback 成功了");
		logger.debug("logback 成功了");
		
	}

}
