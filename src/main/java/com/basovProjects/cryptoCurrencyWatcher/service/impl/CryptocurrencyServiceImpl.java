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

    private CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CryptocurrencyServiceImpl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    @Override
    public boolean save(Cryptocurrency cryptocurrency) throws ObjectNotFoundException {
        if(findById(cryptocurrency.getId())==null){
            return false;
        }
        cryptocurrencyRepository.save(cryptocurrency);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Cryptocurrency cryptocurrency) throws ObjectNotFoundException {
        Cryptocurrency foundCryptocurrency = cryptocurrencyRepository.getById(cryptocurrency.getId());
        if(foundCryptocurrency==null){
            save(cryptocurrency);
        }
        foundCryptocurrency.setId(cryptocurrency.getId());
        foundCryptocurrency.setName(cryptocurrency.getName());
        foundCryptocurrency.setCost(cryptocurrency.getCost());
        return true;
    }


    @Override
    public boolean delete(Long id) throws ObjectNotFoundException {
        cryptocurrencyRepository.delete(findById(id));
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
    public List<Cryptocurrency> findAll() {
        return cryptocurrencyRepository.findAll();
    }
}
