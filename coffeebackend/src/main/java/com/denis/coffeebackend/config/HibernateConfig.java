package com.denis.coffeebackend.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.denis.coffeebackend.utils.PropertiesClass;

@Configuration
@ComponentScan(basePackages = { "com.denis.coffeebackend.domian" })
@EnableTransactionManagement
public class HibernateConfig {
	private BasicDataSource basicDS;

	public HibernateConfig() {
		Properties usingDb = PropertiesClass.getSettings("usingDb");
		String dbNameConfig = usingDb.getProperty("db.name.config");
		Properties jdbcSettings = PropertiesClass.getSettings(dbNameConfig);

		String dbDriver = jdbcSettings.getProperty("db.driver");
		String dbURL = jdbcSettings.getProperty("db.url");
		String dbUser = jdbcSettings.getProperty("db.user");
		String dbPassword = jdbcSettings.getProperty("db.password");
		String ssl = jdbcSettings.getProperty("db.ssl");

		basicDS = new BasicDataSource();
		basicDS.setDriverClassName(dbDriver);
		basicDS.setUrl(dbURL);
		basicDS.setUsername(dbUser);
		basicDS.setPassword(dbPassword);

		if (ssl != null) {
			basicDS.setConnectionProperties("useSSL=" + ssl);
		}

	}

	private static class DataSourceHolder {
		private static final HibernateConfig HOLDER_INSTANCE = new HibernateConfig();
	}

	public static HibernateConfig getInstance() {
		return DataSourceHolder.HOLDER_INSTANCE;
	}

	public Connection getConnection() throws SQLException {
		return basicDS.getConnection();
	}

	@Bean
	public DataSource getDataSource() {
		return basicDS;
	}

	@Bean
	private SessionFactory getSessionFacory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.denis.coffeebackend.domian");

		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", properties.getProperty("db.dialect"));
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
}
