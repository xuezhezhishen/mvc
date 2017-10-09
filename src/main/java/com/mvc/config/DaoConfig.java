package com.mvc.config;

//import com.mvc.dao.hibernate.impl.CP_Hibernate4DAOImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Spencer.hong on 2017/6/16.
 */
@Configuration
//启用注解事务管理,使用CGLib代理
@EnableTransactionManagement(proxyTargetClass = true)
@Import({DataSourceConfig.class})
public class DaoConfig {

    private static final Logger logger = Logger.getLogger(DaoConfig.class);
    @Resource(name = "dataSource")
    public DataSource dataSource;
    @Value("${hibernate.dialect}")
    String hibernate_dialect;
    @Value("${hibernate.show_sql}")
    String hibernate_show_sql;

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

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean() {
        logger.info("sessionFactory");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        String[] packagesToScan = new String[]{"com.mvc.entity"};
        sessionFactory.setPackagesToScan(packagesToScan);

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", hibernate_dialect);
        hibernateProperties.setProperty("hibernate.show_sql",
            hibernate_show_sql);
        hibernateProperties.setProperty(
            "hibernate.current_session_context_class",
            "org.springframework.orm.hibernate5.SpringSessionContext");
        // 二级缓存
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
        hibernateProperties.setProperty("hibernate.cache.use_query_cache", "true");
//        hibernateProperties.setProperty("hibernate.cache.provider_class",
//                "org.hibernate.cache.EhCacheProvider");
        hibernateProperties.setProperty("hibernate.cache.region.factory_class",
                "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//        hibernateProperties.setProperty("hibernate.cache.region.factory_class",
//                "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");


        sessionFactory.setHibernateProperties(hibernateProperties);

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

    @Bean(name = "transactionManager")
    public HibernateTransactionManager hibernateTransactionManager() {
        logger.info("transactionManager");
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }
}