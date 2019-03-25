package com.jcombat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jcombat.controller.DemoController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = DemoController.class)
@Configuration
public class SwaggerConfig {
	
	private static final String SWAGGER_API_VERSION = "2.6.1";
	private static final String LINCENSE_TEXT = "License";
	private static final String title ="login api";
	private static final String description = "welcome login API";
	private String pathRegex;
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LINCENSE_TEXT)
				.version(SWAGGER_API_VERSION)
				.build();
	}
	
	@Bean
	public Docket LoginApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.paths(PathSelectors.regex(pathRegex = "/api.*"))
				.build();
	}

}
