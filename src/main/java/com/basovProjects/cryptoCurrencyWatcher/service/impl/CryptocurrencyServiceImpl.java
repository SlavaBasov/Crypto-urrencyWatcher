package com.basovProjects.cryptoCurrencyWatcher.service.impl;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import com.basovProjects.cryptoCurrencyWatcher.repository.CryptocurrencyRepository;
import com.basovProjects.cryptoCurrencyWatcher.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService<Cryptocurrency, Long> {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CryptocurrencyServiceImpl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    @Override
    @Transactional
    public boolean update(Cryptocurrency cryptocurrency) {
        Cryptocurrency foundCryptocurrency = cryptocurrencyRepository.getById(cryptocurrency.getId());
        foundCryptocurrency.setPrice(cryptocurrency.getPrice());
        foundCryptocurrency.setSymbol(cryptocurrency.getSymbol());
        return true;
    }

    @Override
    public Cryptocurrency findById(Long id) throws ObjectNotFoundException {
        Cryptocurrency cryptocurrency;
        Optional<Cryptocurrency> cryptocurrencyOptional = cryptocurrencyRepository.findById(id);
        if (cryptocurrencyOptional.isPresent()) {
            cryptocurrency = cryptocurrencyOptional.get();
        } else {
            throw new ObjectNotFoundException("Not found the cryptocurrency with id=" + id);
        }
        return cryptocurrency;
    }

    @Override
    public Cryptocurrency findBySymbol(String symbol) throws ObjectNotFoundException {
        Cryptocurrency cryptocurrency = cryptocurrencyRepository.findBySymbol(symbol);
        if(cryptocurrency!=null){
            return cryptocurrency;
        }else {
            throw new ObjectNotFoundException(String.format("Symbol with name %s not found", symbol));
        }
    }

    @Override
    public List<Cryptocurrency> findAll() {
        return cryptocurrencyRepository.findAll();
    }
}
