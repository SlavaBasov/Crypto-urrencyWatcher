package com.basovProjects.cryptoCurrencyWatcher.service;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;

import java.util.List;

public interface CryptocurrencyService<E,I> {
    boolean update(E e) throws ObjectNotFoundException;
    E findById(I id) throws ObjectNotFoundException;
    E findBySymbol(String symbol) throws ObjectNotFoundException;
    List<E> findAll();
}
