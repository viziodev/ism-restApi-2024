package com.ism.ecom.security.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    private  String version;
    @Autowired
    public SwaggerConfig(@Value("${spring.application.version}") String version) {
        this.version = version;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    @Bean
    public OpenAPI openAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .bearerFormat("JWT")
                .scheme("bearer")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization")
                .description("JWT authentication token");
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("jwtScheme", securityScheme))
                .addSecurityItem(new SecurityRequirement().addList("jwtScheme"))
                .info(new Info().title("Cours de Ism")
                        .description("Cours de Ism REST API documentation")
                        .contact(new Contact().name("Birane Baila Wane")
                                .email( "www.douvewane85@gmail.com")
                                .url("www.douvewane85@gmail.com"))
                        .license(new License().name("License of API"))
                        .version(version))

                ;
    }

    @Bean
    public GroupedOpenApi groupeOpenApi() {
        return GroupedOpenApi.builder()
                .group("ism-rest-api")
                .packagesToScan("com.ism.ecom.web.controllers", "com.ism.ecom.security.controllers")
                .packagesToExclude("com.ism.ecom.data")
                .build();
    }
}
