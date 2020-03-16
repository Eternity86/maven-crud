package ru.eternity074.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ru.eternity074.dao.EmpDao;
import ru.eternity074.dao.EmpDaoImpl;

@EnableWebMvc
@Configuration
@ComponentScan({ "ru.eternity074.controllers" })
public class SpringWebMvcConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://192.168.0.107:3306/javatpoint");
		ds.setUrl("jdbc:mariadb://192.168.0.107:3306/javatpoint");
		ds.setUsername("aleksdb");
		ds.setPassword("1gjeOjuW");
		return ds;
	}

	@Bean
	public JdbcTemplate jt() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds());
		return jt;
	}

	@Bean
	public EmpDao dao() {
		EmpDaoImpl dao = new EmpDaoImpl();
		dao.setTemplate(jt());
		return dao;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}

}
