package com.posadskiy.mappurchase;

import com.posadskiy.mappurchase.controller.UserController;
import com.posadskiy.mappurchase.controller.impl.UserControllerImpl;
import com.posadskiy.mappurchase.mapper.UserMapper;
import com.posadskiy.mappurchase.mapper.UserMapperImpl;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SpringConfiguration {

	@Bean
	public UserController userController() {
		return new UserControllerImpl();
	}

	@Bean
	public UserMapper userMapper() {
		return new UserMapperImpl();
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}

}
