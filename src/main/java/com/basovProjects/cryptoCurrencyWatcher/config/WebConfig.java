package com.basovProjects.cryptoCurrencyWatcher.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.basovProjects.cryptoCurrencyWatcher"})
public class WebConfig implements WebMvcConfigurer {
}
