package com.rfics.unit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties
@PropertySource("classpath:resources.properties")
@Data
public class Config {

	private String excel1;
	
	private String excel2;
	
	private String excel3;
	
	private String excel4;
	
	private String excel5;

	private String uploadPath;
}
