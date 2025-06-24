package com.optimagrowth.license.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "example")
public record ServiceConfig(
        String property
) {
}