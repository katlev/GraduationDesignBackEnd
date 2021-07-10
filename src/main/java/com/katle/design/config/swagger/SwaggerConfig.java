package com.katle.design.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author alan
 * @date 2020/12/7
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.katle.design.controller"})
public class SwaggerConfig {
    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        Contact contact =new Contact("KATLE","http://localhost:8080","1352727943@qq.com");
        return new ApiInfoBuilder()
                .title("毕业设计管理系统")
                .description("毕业设计管理系统API接口的描述")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
