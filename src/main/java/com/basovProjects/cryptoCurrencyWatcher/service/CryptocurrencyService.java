package com.basovProjects.cryptoCurrencyWatcher.service;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;

import java.util.List;

public interface CryptocurrencyService<E,I> {
    boolean save(E e) throws ObjectNotFoundException;
    boolean update(E e) throws ObjectNotFoundException;
    boolean delete(I id) throws ObjectNotFoundException;
    E findById(I id) throws ObjectNotFoundException;
    List<E> findAll();
}
