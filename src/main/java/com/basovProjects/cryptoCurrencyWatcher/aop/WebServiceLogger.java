package com.basovProjects.cryptoCurrencyWatcher.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebServiceLogger {

    private final Logger log = LogManager.getLogger(this.getClass());


}
