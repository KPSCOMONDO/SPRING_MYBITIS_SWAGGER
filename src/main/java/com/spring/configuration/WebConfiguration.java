package com.spring.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@MapperScan("com.spring.repository")
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public DataSource getDataSource(){
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName("org.postgresql.Driver");
         dataSource.setUrl("jdbc:postgresql://localhost:5432/MyDB");
         dataSource.setUsername("postgres");
         dataSource.setPassword("123");
         return dataSource;
    }
    @Bean
    public DataSourceTransactionManager transactionManager(){
    	return new DataSourceTransactionManager(getDataSource());
    }
    @Bean 
    public SqlSessionFactoryBean sessionFactory(){
    	SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        return sessionFactory;
    }
    
    @Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("PUT", "DELETE","GET" , "POST")
			.allowedHeaders("header1", "header2", "header3")
			.exposedHeaders("header1", "header2")
			.allowCredentials(false).maxAge(3600);
	}
    
}
