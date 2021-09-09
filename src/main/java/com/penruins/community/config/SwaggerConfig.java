package com.penruins.community.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
  @Bean
  public Docket docket(Environment environment) {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .groupName("默认接口")
            .enable(true)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.penruins.community.controller"))
            .paths(PathSelectors.any())
            .build();
  }
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("社区服务后端接口文档")
            .description("通过此文档可以查看、测试后端api")
            .contact(new Contact("penruins", "", "lx_tdcq_king@icloud.com"))
            .version("v1.0.0")
            .build();
  }
}
