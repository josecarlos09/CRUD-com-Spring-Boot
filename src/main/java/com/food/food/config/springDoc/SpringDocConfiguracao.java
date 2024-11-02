package com.food.food.config.springDoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguracao {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Food API") // Titulo da API
                        .description("API Rest Food, contem as funcionalidades de CRUD de uma operação de pagamento.")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@food.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://food/api/licenca")));
    }
}
