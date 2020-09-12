package com.mentormate.devcamp.application.business.configuration;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration is responsible to create and configure {@link ModelMapper}
 */
@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
