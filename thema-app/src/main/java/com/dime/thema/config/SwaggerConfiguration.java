package com.dime.thema.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Thema App")
                        .description("API to play game with word")
                        .summary("A word game.")
                        .termsOfService("https://www.termsofservicegenerator.net/")
                        .contact(new Contact().email("contact@3dime.com").name("contact").url("https://www.3dime.com/support"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0"));
    }

}
