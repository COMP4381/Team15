package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration

public class SwaggerConfig {

	@Bean
	public Docket VideoApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.paths(regex("/Users.*"))

				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("JobsTube",
				"This API build to help students and Compaines to let the student try good internship in special domain according to their skills that published from their videos in our API YoutubeJobs",
				"V1", "", "+972-0000-90900",
				"All the Videos Here is Publish for all the people and you can share it or you can leave any beautifu comment as a feadbak for students",
				"https://www.youtube.com/playlist?list=PLqU7T7osXwjMFT8OeIzkcjlRQl0a3wBFs");
	}

}
