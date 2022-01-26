package com.basovProjects.cryptoCurrencyWatcher.config;

import com.basovProjects.cryptoCurrencyWatcher.util.CryptoHandler;
import com.basovProjects.cryptoCurrencyWatcher.util.JsonParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
@EnableAsync
@EnableScheduling
public class SchedulingConfig {

    private CryptoHandler cryptoHandler;

    @Autowired
    public SchedulingConfig(CryptoHandler cryptoHandler) {
        this.cryptoHandler = cryptoHandler;
    }

    @Async
    @Scheduled(fixedDelay=5000)
    public void doSomething() throws IOException {
        cryptoHandler.updatePricesDB();
    }
}
