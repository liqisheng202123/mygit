package com.example.mybaits.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Redis缓存配置类
 * @author szekinwin
 *
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

//    /*定义缓存数据 key 生成策略的bean
//    包名+类名+方法名+所有参数
//    */
    /**
     * 生成key的策略【自定义第三种】
     * 使用范围：仅适用于选取第一个参数做键的情况
     * 由于reposotory上不能直接使用spel表达式作key，故而采用key的生成策略的方式来替换
     *
     * 使用时在注解@Cacheable(value = "admins",keyGenerator = "firstParamKeyGenerator")中指定
     * @return
     */
    @Bean(name = "firstParamKeyGenerator")
    public KeyGenerator firstParamKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(params[0].toString());
                for (Object obj:params) {

                }
                return sb.toString();
//                Map<String,Object> map = new HashMap<>();
//                Field[] declaredFields = params[0].getClass().getDeclaredFields();
//                for (Field field : declaredFields) {
//                    field.setAccessible(true);
//                    try {
//                        if (field.get(params) != null)
//                            map.put(field.getName(), field.get(params));
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return map.toString();
            }
        };
    }

    /*要启用spring缓存支持,需创建一个 CacheManager的 bean，CacheManager 接口有很多实现，这里Redis 的集成，用 RedisCacheManager这个实现类
    Redis 不是应用的共享内存，它只是一个内存服务器，就像 MySql 似的，
    我们需要将应用连接到它并使用某种“语言”进行交互，因此我们还需要一个连接工厂以及一个 Spring 和 Redis 对话要用的 RedisTemplate，
    这些都是 Redis 缓存所必需的配置，把它们都放在自定义的 CachingConfigurerSupport 中
     */
//    @Bean
//    @Override
//    public CacheManager cacheManager(RedisConnectionFactory factory) {
//        RedisCacheManager cacheManager = RedisCacheManager.create(factory);
//        return cacheManager;
//    }

    //1.项目启动时此方法先被注册成bean被spring管理
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();  // 生成一个默认配置，通过config对象即可对缓存进行自定义配置
        config = config.entryTtl(Duration.ofMinutes(1))     // 设置缓存的默认过期时间，也是使用Duration设置
                .disableCachingNullValues();     // 不缓存空值

        // 设置一个初始化的缓存空间set集合
        Set<String> cacheNames =  new HashSet<>();
        cacheNames.add("my-redis-cache1");
        cacheNames.add("my-redis-cache2");

        // 对每个缓存空间应用不同的配置
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        configMap.put("my-redis-cache1", config);
        configMap.put("my-redis-cache2", config.entryTtl(Duration.ofSeconds(120)));

        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)     // 使用自定义的缓存配置初始化一个cacheManager
                .initialCacheNames(cacheNames)  // 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置
                .withInitialCacheConfigurations(configMap)
                .build();
        return cacheManager;
    }
}
