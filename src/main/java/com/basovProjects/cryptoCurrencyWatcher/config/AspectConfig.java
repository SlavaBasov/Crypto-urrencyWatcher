package com.basovProjects.cryptoCurrencyWatcher.config;

import com.basovProjects.cryptoCurrencyWatcher.aop.WebServiceLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.basovProjects.cryptoCurrencyWatcher.aop")
public class AspectConfig {
    @Bean
    public WebServiceLogger webServiceLogger() {
        return new WebServiceLogger();
    }
}
