package com.example.redis;

import com.example.redis.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	TestController testController;
	@Test
	public void setTestController(){
		String test = testController.test();
		System.out.println(test);
	}
}
