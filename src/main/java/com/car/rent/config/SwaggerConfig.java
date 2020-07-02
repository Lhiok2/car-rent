package com.car.rent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author nayix
 * @date 2020/7/2 13:10
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("car-rent项目API文档")
                .description("car-rent-1.0项目API文档")
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描basePackage包下面的"/api/"路径下的内容作为接口文档构建的目标
                .apis(RequestHandlerSelectors.basePackage("com.car.rent"))
                .paths(PathSelectors.regex("/api/v1/.*"))
                .build();
    }

}
