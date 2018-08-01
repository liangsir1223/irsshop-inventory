package com.iresearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.iresearch.irsshop.inventory.config.InitListener;

@SpringBootApplication
@MapperScan(basePackages = { "com.iresearch.irsshop" }, annotationClass = Repository.class)
public class IrsInventoryApplication {
	
	@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean(){
	    ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
	    servletListenerRegistrationBean.setListener(new InitListener());
	    return servletListenerRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(IrsInventoryApplication.class, args);
	}
}