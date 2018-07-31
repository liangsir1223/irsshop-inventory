package com.iresearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages = { "com.iresearch.irsshop" }, annotationClass = Repository.class)
public class IrsInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrsInventoryApplication.class, args);
	}
}