package yike;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Sets;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	
	@Bean
	public Docket configSpringfoxDocketForAgent() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("代理商接口")
				.protocols(Sets.newHashSet("http"))
//				.enable(Constants.SWAGGER_ENABLE)
				.forCodeGeneration(true).select().paths(regex("/account/.*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("洽客学院")// 标题
				.description("spring boot 全集")// 描述
				.termsOfServiceUrl("http://www.qiakr.com")//
				.contact(new Contact("lyy", "http://www.qiakr.com", "yufeng@qiakr.com"))// 联系
				.version("1.0")// 版本
				.build();
	}
}
