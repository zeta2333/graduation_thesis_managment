package usts.cs2020.config.knife4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-22 3:13 PM
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {
    // 访问地址：http://localhost:6815/doc.html
    @Bean
    public Docket adminApiConfig() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token")
                .description("用户token")
                .defaultValue("")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        // 添加head参数end

        Docket adminApi = new Docket(DocumentationType.SWAGGER_2)
                .groupName("thesis_management")
                .apiInfo(adminApiInfo())
                .select()
                // 只显示admin路径下的页面
                .apis(RequestHandlerSelectors.basePackage("usts.cs2020"))
                .paths(PathSelectors.regex("/system/.*"))
                .build()
                .globalOperationParameters(pars);
        return adminApi;
    }

    private ApiInfo adminApiInfo() {

        return new ApiInfoBuilder()
                .title("毕业论文管理系统-API文档")
                .description("本文档描述了毕业论文管理系统微服务接口定义")
                .version("1.0")
                .contact(new Contact("Pycro", "https://www.usts.edu.cn", "pycro6815@163.com"))
                .build();
    }


}