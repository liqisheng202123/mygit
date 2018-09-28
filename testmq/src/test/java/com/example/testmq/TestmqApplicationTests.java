package com.example.testmq;

import com.example.testmq.util.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestmqApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Autowired
	private Producer producer;

	@Test
	public void test(){
		for(int i=0; i<100; i++){
			producer.sendMessage("mytest", "myname is chhliu!!!");
		}
	}

}
