package com.jst.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	@Bean
	public Docket accessToken() {
		return

		new Docket(DocumentationType.SWAGGER_2).groupName("demo").select()
				.apis(RequestHandlerSelectors.basePackage("com.jst.demo.controller")).paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return

		new ApiInfoBuilder().title("捷顺金科").description("智能停车").termsOfServiceUrl("www.jsfintech.cn")
				.contact(new Contact("lixin", "www.jsfintech.cn", "xin.li@jieshunpay.cn")).version("1.0").build();
	}
}
