package com.mvc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by kage on 2017/9/6.
 */
@Configuration
//db 配置文件
@PropertySource({"classpath:config/properties/db.properties"})
public class MyBatisDataSourceConfig {

    private static final Logger logger = Logger.getLogger(MyBatisDataSourceConfig.class);
    /*
     *db 配置
     */
    @Value("${jdbc.driver}")
    String driverClass;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    String userName;
    @Value("${jdbc.password}")
    String passWord;

    @Bean(name = "myBatisDataSource")
    public DataSource myBatisDataSource() {
        logger.info("mybatis DataSource init");
        DruidDataSource druidDataSource = new DruidDataSource();
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(passWord);
        druidDataSource.setMaxActive(20);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(3000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        try {
            druidDataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
