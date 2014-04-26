package com.adarrivi.relational;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.adarrivi.core.usercase.StructureUserCase;

@Configuration
@ComponentScan("com.adarrivi")
@Import(DaoRelationalConfiguration.class)
public class RelationalConfiguration {

    @Bean
    public StructureUserCase structureUserCase() {
        return new StructureUserCase();
    }
}
