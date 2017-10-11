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
	private Properties properties;
	private static String dbNameConfig;

	static {
		Properties usingDb = PropertiesClass.getSettings("usingDb");
		dbNameConfig = usingDb.getProperty("db.name.config");
	}

	private static class DataSourceHolder {
		private static final HibernateConfig HOLDER_INSTANCE = new HibernateConfig();
	}

	public static HibernateConfig getInstance() {
		return DataSourceHolder.HOLDER_INSTANCE;
	}

	public Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}

	@Bean("dataSource")
	public DataSource getDataSource() {
		properties = PropertiesClass.getSettings(dbNameConfig);
		;

		BasicDataSource basicDS = new BasicDataSource();

		basicDS.setDriverClassName(properties.getProperty("db.driver"));
		basicDS.setUrl(properties.getProperty("db.url"));
		basicDS.setUsername(properties.getProperty("db.user"));
		basicDS.setPassword(properties.getProperty("db.password"));

		if (properties.getProperty("db.ssl") != null) {
			basicDS.setConnectionProperties("useSSL=" + properties.getProperty("db.ssl"));
		}

		return basicDS;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.denis.coffeebackend.domian");

		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
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
