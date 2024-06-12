package com.ipap.springboot3senderawareapi.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CallerProperties.class)
public class AppConfig {
}
