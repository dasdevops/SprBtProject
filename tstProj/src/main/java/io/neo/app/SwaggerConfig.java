package io.neo.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;

//import com.google.common.base.Predicate;

//import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
//import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select().apis(RequestHandlerSelectors.basePackage("io.neo.app.controllers"))
	                .paths(regex("/.*"))
	                .build();
	             
	    }


	@SuppressWarnings("unused")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ABC Org API")
				.description("ABC Org Test API reference for developers")
				.contact(new Contact("Veeramanicadas KANNAN", "", "veeramanicadas.kannan@gmail.com"))
				.version("1.0").build();
	}

}