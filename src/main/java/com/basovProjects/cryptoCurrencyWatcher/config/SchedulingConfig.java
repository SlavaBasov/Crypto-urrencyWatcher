package com.basovProjects.cryptoCurrencyWatcher.config;

import com.basovProjects.cryptoCurrencyWatcher.util.CryptoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class SchedulingConfig {

    private final CryptoHandler cryptoHandler;

    @Autowired
    public SchedulingConfig(CryptoHandler cryptoHandler) {
        this.cryptoHandler = cryptoHandler;
    }

    @Async
    @Scheduled(fixedDelay=60*1000)
    public void doSomething() {
        cryptoHandler.updatePricesDB();
        cryptoHandler.priceChangeChecker();
    }
}
