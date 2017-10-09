package com.mvc.config;

//import com.mvc.component.dao.hibernate.impl.CP_Hibernate4DAOImpl;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Spencer.hong on 2017/6/16.
 */
@Configuration
//启用注解事务管理,使用CGLib代理
@EnableTransactionManagement(proxyTargetClass = true)
@Import({MyBatisDataSourceConfig.class})
@PropertySource({"classpath:config/properties/db.properties"})
@MapperScan(basePackages = "com.mvc.component.dao.mybatis.impl")
public class MybatisSessionFactoryConfig {

    private static final Logger logger = Logger.getLogger(MybatisSessionFactoryConfig.class);
    @Resource(name = "myBatisDataSource")
    public DataSource myBatisDataSource;


    /**
     * 描述 : <负责解析资源文件>. <br>
     * <p>
     * <这个类必须有,而且必须声明为static,否则不能正常解析>
     * </p>
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
        logger.info("PropertySourcesPlaceholderConfigurer");
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean(name = "hibernateDAO")
//    public CP_Hibernate4DAOImpl hibernate4Dao() {
//        logger.info("hibernateDAO");
//        CP_Hibernate4DAOImpl dao = new CP_Hibernate4DAOImpl();
//        dao.setSessionFactory(localSessionFactoryBean().getObject());
//        return dao;
//    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean () throws Exception{
        logger.info("sessionFactory");
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(myBatisDataSource);
        sessionFactory.setTypeAliasesPackage("com.mvc.entity");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/mvc/dao/mybatis/impl/*.xml"));
//        sessionFactory.set();
        return sessionFactory;

    }


//    @Bean
//    public JndiObjectFactoryBean jndiObjectFactoryBean(){
//        JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
//        //  factory.setJndiName("java:comp/env/jdbc/demoDB"); //两种方式均可，spring会自动补齐
//        factory.setJndiName("jdbc/demoDB");
//        return factory;
//    }
//
//    @Bean(name = "dataSource")
//    public DataSource dataSource() throws Exception{
//        logger.info("DataSourceJNDI");
//        return (DataSource)jndiObjectFactoryBean().getObject();
//
//    }
//
//    @Bean(name = "mapperScannerConfigurer")
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        logger.info("MapperScannerConfigurer init");
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("com.mvc.component.dao.mybatis.impl");
//        return mapperScannerConfigurer;
//    }

    @Bean(name = "myBatisTransactionManager")
    public DataSourceTransactionManager DataSourceTransactionManager() {
        logger.info("transactionManager");
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(myBatisDataSource);
        return dataSourceTransactionManager;
    }

}