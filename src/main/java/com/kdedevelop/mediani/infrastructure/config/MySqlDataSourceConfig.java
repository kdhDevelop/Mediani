package com.kdedevelop.mediani.infrastructure.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.kdedevelop.mediani", // 첫번째 DB가 있는 패키지(폴더) 경로
        entityManagerFactoryRef = "medianiEntityManagerFactory", // EntityManager 의 이름
        transactionManagerRef = "medianiTransactionManager" // 트랜잭션 매니저의 이름
)
public class MySqlDataSourceConfig {

    public MySqlDataSourceConfig(@Value("${spring.mysql-datasource.ddl-auto}") String STATUS, @Value("${spring.jpa.show-sql}") boolean SQL_SHOW) {
        this.STATUS = STATUS;
        this.SQL_SHOW = SQL_SHOW;
    }

    private final String STATUS;
    private final boolean SQL_SHOW;

    @Bean
    @ConfigurationProperties("spring.mysql-datasource")
    public DataSourceProperties medianiDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource medianiDataSource(){
        return medianiDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean medianiEntityManagerFactory() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(SQL_SHOW);
        hibernateJpaVendorAdapter.setGenerateDdl(true);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", STATUS);
        properties.put("hibernate.format_sql", SQL_SHOW);

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(medianiDataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.kdedevelop.mediani");
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager medianiTransactionManager(@Qualifier("medianiEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }
}
