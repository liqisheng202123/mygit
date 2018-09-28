package com.example.rediscluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisClusterApplication {

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(RedisClusterApplication.class, args);
	}
}
