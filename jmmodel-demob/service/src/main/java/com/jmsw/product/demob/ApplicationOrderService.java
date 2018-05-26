package com.jmsw.product.demob;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/25 11:44
 * @Description 启动程序
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableTransactionManagement(proxyTargetClass = true)
public class ApplicationOrderService extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationOrderService.class);
    }

    @Bean
    public Docket docket(@Value("${swagger.enable:true}")boolean enableSwagger) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("积木三维模型云DemoB")
                                .description("当前API版本" + OrderConfiguration.CURRENT_VERSION + " 兼容API版本" + OrderConfiguration.COMPATIBLE_VERSION)
                                .version(OrderConfiguration.CURRENT_VERSION)
                                .build())
                .select().apis(RequestHandlerSelectors.basePackage(ApplicationOrderService.class.getPackage().getName())).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationOrderService.class, args);
    }
}
