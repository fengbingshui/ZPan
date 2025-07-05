package com.zhu.pan.swagger2;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口文档配置类
 */
@SpringBootConfiguration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Slf4j
public class Swagger2Config {

    @Autowired
    private Swagger2ConfigProperties properties; // 引用配置类

    @Bean
    public Docket panServerApi() {
        // 创建 Swagger 配置 Docket
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(properties.isShow()) // 控制是否显示 Swagger 文档
                .groupName(properties.getGroupName()) // 配置文档分组名
                .apiInfo(apiInfo()) // 配置 API 的基本信息
                .useDefaultResponseMessages(false) // 禁用默认的响应消息
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage())) // 配置要扫描的包
                .paths(PathSelectors.any()) // 配置扫描路径，所有路径
                .build();
        log.info("The swagger2 have been loaded successfully!"); // 日志记录 Swagger 是否加载成功
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getTitle()) // API 文档标题
                .description(properties.getDescription()) // API 描述
                .termsOfServiceUrl(properties.getTermsOfServiceUrl()) // 服务条款链接
                .contact(new Contact(properties.getContactName(), properties.getContactUrl(), properties.getContactName())) // 联系人信息
                .version(properties.getVersion()) // API 文档版本
                .build();
    }
}
