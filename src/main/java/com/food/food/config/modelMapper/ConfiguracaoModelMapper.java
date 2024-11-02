package com.food.food.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoModelMapper {
    @Bean // A anotação @Bean indica que o método modelMapper só será chamado quando necessário (O próprio Spring gerencia isso)
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
