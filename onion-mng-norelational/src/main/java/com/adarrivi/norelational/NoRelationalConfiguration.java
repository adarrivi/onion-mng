package com.adarrivi.norelational;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.adarrivi.core", "com.adarrivi.norelational" })
public class NoRelationalConfiguration {

}
