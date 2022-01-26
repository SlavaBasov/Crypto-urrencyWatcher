package com.basovProjects.cryptoCurrencyWatcher.util;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import com.basovProjects.cryptoCurrencyWatcher.service.CryptocurrencyService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CryptoHandler {

    private CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService;

    @Autowired
    public CryptoHandler(CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    public boolean updatePricesDB(){
        cryptocurrencyService.findAll()
                .stream()
                .forEach(i->{
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
        return true;
    }

}
