package com.impuls8.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.impuls8.ecommerce.jwt.config.JwtFilter;

@SpringBootApplication
public class SkateStaffApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkateStaffApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/users/*");
		registrationBean.addUrlPatterns("/api/products/*");
		registrationBean.addUrlPatterns("/api/admin/*");
		registrationBean.addUrlPatterns("/api/iduser/*");
		
		return registrationBean;
	}//jwtFilter
	
}
