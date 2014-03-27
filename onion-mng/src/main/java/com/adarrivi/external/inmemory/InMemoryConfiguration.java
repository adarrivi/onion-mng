package com.adarrivi.external.inmemory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.adarrivi.core", "com.adarrivi.external.inmemory" })
public class InMemoryConfiguration {

}
