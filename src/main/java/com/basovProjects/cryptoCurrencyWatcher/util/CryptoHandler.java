package com.basovProjects.cryptoCurrencyWatcher.util;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import com.basovProjects.cryptoCurrencyWatcher.service.CryptocurrencyService;
import com.basovProjects.cryptoCurrencyWatcher.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CryptoHandler {

    private final CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService;
    private final OrderService orderService;
    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    public CryptoHandler(CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService, OrderService orderService) {
        this.cryptocurrencyService = cryptocurrencyService;
        this.orderService = orderService;
    }

    public void updatePricesDB() {
        cryptocurrencyService.findAll()
                .forEach(i -> {
                    try {
                        JSONObject json = JsonParser.readJsonFromUrl(
                                String.format("https://api.coinlore.net/api/ticker/?id=%d", i.getId()));
                        Cryptocurrency cryptocurrencyNew = new Cryptocurrency();
                        cryptocurrencyNew.setId(i.getId());
                        cryptocurrencyNew.setSymbol(json.get("symbol").toString());
                        cryptocurrencyNew.setPrice(Double.parseDouble(json.get("price_usd").toString()));
                        cryptocurrencyService.update(cryptocurrencyNew);

                    } catch (IOException | ObjectNotFoundException e) {
                        e.printStackTrace();
                    }
                });
    }

    public void priceChangeChecker() {
        orderService.findAll()
                .forEach(i -> {
                    double percent;
                    if (i.getCryptocurrency().getPrice() > i.getSavedPrice()) {
                        percent = i.getCryptocurrency().getPrice() / i.getSavedPrice() * 100 - 100;
                    } else {
                        percent = (i.getSavedPrice() / i.getCryptocurrency().getPrice() * 100 - 100) * (-1);
                    }
                    if(percent>1 || percent<-1){
                    log.warn(String.format("%s, the price of %s has changed by more than %f percent",
                            i.getUsername(), i.getCryptocurrency().getSymbol(), percent));
                    }
                });
    }

}
