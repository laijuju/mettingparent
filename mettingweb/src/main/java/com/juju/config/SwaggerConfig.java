package com.juju.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration      //表示当前文件是一个配置文件，类似于XML
@EnableSwagger2     //
@EnableWebMvc       //
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        System.out.println("执行了createRestApi");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.juju.control")) // 注意修改此处的包名
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        System.out.println("执行了:ApiInfo");
        return new ApiInfoBuilder()
                .title("会议系统接口") // 接口文档的名字
                .description("接口测试") // 说明
                //.termsOfServiceUrl("http://localhost:8080/swagger-ui.html") // 生成接口的地址的访问地址
                .contact("juju") // 无所谓（这里是作者的别称）
                .version("1.0")  //版本号
                .build();           //调用构建的方法进行构建
    }
}
