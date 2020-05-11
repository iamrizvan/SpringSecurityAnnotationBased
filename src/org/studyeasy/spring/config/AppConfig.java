package org.studyeasy.spring.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class AppConfig {

	@Bean("dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dateSource = new DriverManagerDataSource();
		dateSource.setDriverClassName("com.mysql.jdbc.Driver");
		dateSource.setUrl("jdbc:mysql://localhost:3306/project?useSSL=false");
		dateSource.setUsername("root");
		dateSource.setPassword("root");
		return dateSource;
	}
}







