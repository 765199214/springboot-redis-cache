package cn.linkpower.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //启动Swagger
public class SwaggerConfig {
	
	/**
	 * swagger 核心类
	 * @return
	 */
	@Bean
	public Docket createRestApi1(Environment environment) {
		// 适用环境
		Profiles profiles = Profiles.of("dev", "test");
		boolean flag = environment.acceptsProfiles(profiles);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("AAA")
				.apiInfo(apiInfo())
				.enable(flag)//enable是否启动swagger，如果为false，则Swagger不能在浏览器中访问
				.select()
				//RequestHandlerSelectors, 配置要扫描接口的方式
                //basePackage()扫描全部
                //any()扫描全部
                //none()不扫描
                //withClassAnnotation()扫描方法上的注解
				.apis(RequestHandlerSelectors.basePackage("cn.linkpower"))
				//path() 过滤什么路径
				.paths(PathSelectors.any())
				.build();
	}
	
	/**
	 * 分组显示
	 * @return
	 */
	@Bean
	public Docket createRestApi2(Environment environment) {
		// 适用环境
		Profiles profiles = Profiles.of("dev", "test");
		boolean flag = environment.acceptsProfiles(profiles);
				
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("BBB")
				.apiInfo(apiInfo())
				.enable(flag)//enable是否启动swagger，如果为false，则Swagger不能在浏览器中访问
				.select()
				//RequestHandlerSelectors, 配置要扫描接口的方式
                //basePackage()扫描全部
                //any()扫描全部
                //none()不扫描
                //withClassAnnotation()扫描方法上的注解
				.apis(RequestHandlerSelectors.basePackage("cn.linkpower"))
				//path() 过滤什么路径
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 标题
				.title("专注写bug , swagger测试")
				// 创建人基础信息
				.contact(new Contact("专注写bugs", "localhost:80", "123@qq.com"))
				// 版本信息
				.version("1.0.0")
				.description("swagger 测试代码")
				.build();
	}
}
