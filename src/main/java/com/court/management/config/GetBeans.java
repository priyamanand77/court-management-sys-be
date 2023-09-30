package com.court.management.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetBeans {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
