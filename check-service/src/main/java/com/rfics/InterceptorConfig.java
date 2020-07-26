//package com.rfics;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import com.rfics.filter.LoginInterceptor;
//
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurationSupport {
//	
//	@Bean
//	public LoginInterceptor myInterceptor() {
//		return new LoginInterceptor();
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(myInterceptor()).addPathPatterns("/**").excludePathPatterns(",", "/error", "/login",
//				"/logout", "/api/vehical", "/photo/getPhotos", "/evaluation/getEvaluationData", 
//				"/file/fileDownload");
//		super.addInterceptors(registry);
//	}
//}
