package com.basovProjects.cryptoCurrencyWatcher.service;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Order;

public interface OrderService {
    boolean save(Order order);
    Order findById(Long id) throws ObjectNotFoundException;
    boolean deleteById(Long id) throws ObjectNotFoundException;
    boolean delete(Order order);
}
