package com.imcs.maven.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.imcs.maven")
@PropertySource("classpath:db.properties")
public class AppConfig {
	@Autowired
	Environment env;
	
	@Bean
	public DataSource createDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("MYSQL_DB_DRIVER_CLASS"));
		ds.setUrl(env.getProperty("MYSQL_DB_URL"));
		ds.setUsername(env.getProperty("MYSQL_DB_USERNAME"));
		ds.setPassword(env.getProperty("MYSQL_DB_PASSWORD"));

		// the settings below are optional -- dbcp can work with defaults
		ds.setMinIdle(5);
		ds.setMaxIdle(20);
		ds.setMaxOpenPreparedStatements(180);

		return ds;
	}

}
