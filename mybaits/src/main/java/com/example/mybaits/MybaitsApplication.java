package com.example.mybaits;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan("com.example.mybaits.*")
@EnableCaching
public class MybaitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybaitsApplication.class, args);
	}
}
