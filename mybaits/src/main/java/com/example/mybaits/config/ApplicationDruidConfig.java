//package com.example.mybaits.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
////说明这是一个配置文件
//@Configuration
////用来引入properties文件
////@PropertySource(value = "spring.datasource.properties")
//public class ApplicationDruidConfig {
//
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.url}")
//    private String Url;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClass;
//
//    @Value("${spring.datasource.initialSize}")
//    private int initialSize;
//
//    @Value("${spring.datasource.maxActive}")
//    private int maxActive;
//
//    @Value("${spring.datasource.minIdle}")
//    private int minIdle;
//
//    @Value("${spring.datasource.maxWait}")
//    private long maxWait;
//
//    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
//    private long timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
//    private long minEvictableIdleTimeMillis;
//
//    @Bean(name="dataSource")
//    //因为SpringBoot也为我们提供了一个默认的datasource，可谓贴心，当我们需要自己的连接池的时候，可以使用@primary注解，告诉Springboot
//    //优先使用我们自己的DataSource
//    @Primary
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);;
//        dataSource.setUrl(Url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        return dataSource;
//    }
//}
