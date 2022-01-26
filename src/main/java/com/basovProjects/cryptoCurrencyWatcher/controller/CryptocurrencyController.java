package com.basovProjects.cryptoCurrencyWatcher.controller;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import com.basovProjects.cryptoCurrencyWatcher.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptocurrencyController {

    CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping("/cryptocurrency/{id}")
    public ResponseEntity<Cryptocurrency> getCryptocurrency(@PathVariable("id") Long id) throws ObjectNotFoundException {
        Cryptocurrency cryptocurrencyFound = cryptocurrencyService.findById(id);
        ResponseEntity<Cryptocurrency> cryptocurrency = ResponseEntity.ok().body(cryptocurrencyFound);
        return cryptocurrency;
    }
}
