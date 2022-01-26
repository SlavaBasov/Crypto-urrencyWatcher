package com.basovProjects.cryptoCurrencyWatcher.controller;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import com.basovProjects.cryptoCurrencyWatcher.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CryptocurrencyController {

    CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<Cryptocurrency>> getAllCryptocurrencies() throws ObjectNotFoundException {
        List<Cryptocurrency> cryptocurrencyListFound = cryptocurrencyService.findAll();
        return ResponseEntity.ok().body(cryptocurrencyListFound);
    }

    @GetMapping("/currencies/currency")
    public ResponseEntity<Cryptocurrency> getCryptocurrency(@RequestParam Long id) throws ObjectNotFoundException {
        Cryptocurrency cryptocurrencyFound = cryptocurrencyService.findById(id);
        return ResponseEntity.ok().body(cryptocurrencyFound);
    }

    @GetMapping("/currencies/notify")
    public ResponseEntity<?> notifyUser(@RequestParam String username, @RequestParam String symbol) throws ObjectNotFoundException {
        Cryptocurrency cryptocurrencyFound = cryptocurrencyService.findBySymbol(symbol);
        return ResponseEntity.ok().body(String.format("OK, %s, %d, %s", symbol, cryptocurrencyFound.getId(), username));
    }

}
