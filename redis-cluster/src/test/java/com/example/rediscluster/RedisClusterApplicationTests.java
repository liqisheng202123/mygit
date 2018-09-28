package com.example.rediscluster;

import com.example.mybaits.order.model.Order;
import com.example.mybaits.util.ParamUtils;
import com.example.rediscluster.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	StringRedisTemplate redisTemplate;

	ValueOperations<String, String> stringRedis;

	@Autowired
	RedisUtil redisUtil;
	@PostConstruct
	public void init(){
		stringRedis=redisTemplate.opsForValue();
	}


	@Test
	public void testString (){
		redisUtil.set("aaa","哈哈哈");
		User user = new User(1,"tom");
		User usera = new User(2,"O(∩_∩)O哈哈~");
		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(usera);
		redisUtil.set("user",usera);
		redisUtil.set("users",list,10*1000);
		System.out.println(redisUtil.get("aaa"));
		System.out.println(redisUtil.get("users"));
	}

	class User{
		private int id;
		private String name;
		public User(){}
		public User(int id,String name){
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
