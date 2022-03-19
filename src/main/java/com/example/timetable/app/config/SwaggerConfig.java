package com.example.timetable.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//	@Bean
//	public Docket postsApi() {
//		return (new Docket(DocumentationType.SWAGGER_2)).groupName("public-api").apiInfo(apiInfo()).select()
//				.paths(postPaths()).build();
//	}


	@Bean
	public Docket productApi() {
		return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.basePackage("com.example.timetable.app")).build();

	}

//	private Predicate<String> postPaths() {
//		return Predicates.or(PathSelectors.regex("/api/posts.*"), PathSelectors.regex("/timetable.*"));
//	}
//
//	private ApiInfo apiInfo() {
//		return (new ApiInfoBuilder()).title("Tinka Limited Trader API").description("Trader reference for developers")
//				.termsOfServiceUrl("http://www.gazetilimited.co.ke").contact("079")
//				.license("Tinka Public License").licenseUrl("info@tinka.co.ke").version("1.0").build();
//	}
}



