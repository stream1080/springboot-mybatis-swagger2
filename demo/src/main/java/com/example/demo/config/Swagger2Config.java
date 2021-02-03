package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 告诉Spring容器，这个类是一个配置类
@EnableSwagger2 // 启用Swagger2功能
public class Swagger2Config {

    /**
     * 配置Swagger2相关的bean
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))// com包下所有API都交给Swagger2管理
                .paths(PathSelectors.any()).build();
    }

    /**
     * API文档地址：http://127.0.0.1:8080/swagger-ui.html#/
     *
     * 此处主要是API文档页面显示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目API") // 标题
                .description("整个项目的各个API") // 描述
                .termsOfServiceUrl("http://www.baidu.com") // 服务网址，一般写公司地址
                .version("1.0") // 版本
                .build();
    }
}