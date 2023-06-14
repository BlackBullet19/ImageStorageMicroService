package org.microService.storage.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "org.microService.storage.repository.imageInfo",
        entityManagerFactoryRef = "imageEntityManager",
        transactionManagerRef = "imageTransactionManager"
)
public class ImageInfoConfiguration {

    private final Environment env;

    @Autowired
    public ImageInfoConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean imageEntityManager() {
        LocalContainerEntityManagerFactoryBean entityManageBean
                = new LocalContainerEntityManagerFactoryBean();
        entityManageBean.setDataSource(imageDataSource());
        entityManageBean.setPackagesToScan("org.microService.storage.entity.imageInfo");

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        entityManageBean.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        entityManageBean.setJpaPropertyMap(properties);

        return entityManageBean;
    }

    @Primary
    @Bean
    public DataSource imageDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("postgres.url"));
        dataSource.setUsername(env.getProperty("postgres.username"));
        dataSource.setPassword(env.getProperty("postgres.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager imageTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                imageEntityManager().getObject());
        return transactionManager;
    }
}
