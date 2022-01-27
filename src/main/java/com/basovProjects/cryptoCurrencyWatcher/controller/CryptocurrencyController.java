package com.basovProjects.cryptoCurrencyWatcher.controller;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectAlreadyExistException;
import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import com.basovProjects.cryptoCurrencyWatcher.model.Order;
import com.basovProjects.cryptoCurrencyWatcher.service.CryptocurrencyService;
import com.basovProjects.cryptoCurrencyWatcher.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CryptocurrencyController {

    private final CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService;
    private final OrderService orderService;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService<Cryptocurrency, Long> cryptocurrencyService, OrderService orderService) {
        this.cryptocurrencyService = cryptocurrencyService;
        this.orderService = orderService;
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<Cryptocurrency>> getAllCryptocurrencies() {
        List<Cryptocurrency> cryptocurrencyListFound = cryptocurrencyService.findAll();
        return ResponseEntity.ok().body(cryptocurrencyListFound);
    }

    @GetMapping("/currencies/currency")
    public ResponseEntity<Cryptocurrency> getCryptocurrency(@RequestParam Long id) throws ObjectNotFoundException {
        Cryptocurrency cryptocurrencyFound = cryptocurrencyService.findById(id);
        return ResponseEntity.ok().body(cryptocurrencyFound);
    }

    @GetMapping("/currencies/notify")
    public ResponseEntity<?> notifyUser(@RequestParam String username, @RequestParam String symbol) throws ObjectNotFoundException, ObjectAlreadyExistException {
        Cryptocurrency cryptocurrencyFound = cryptocurrencyService.findBySymbol(symbol);
        boolean result = orderService.save(new Order(cryptocurrencyFound.getPrice(),
                username, cryptocurrencyFound));
        if(result){
            return ResponseEntity.ok().body(String.format("Your order is accepted, %s", username));
        }
        return ResponseEntity.ok().body(String.format("Your order is updated, %s", username));
    }

}
