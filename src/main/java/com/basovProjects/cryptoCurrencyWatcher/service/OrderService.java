package com.basovProjects.cryptoCurrencyWatcher.service;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Order;

import java.util.List;

public interface OrderService {
    boolean save(Order order) throws ObjectNotFoundException;
    Order findById(Long id) throws ObjectNotFoundException;
    List<Order> findAll();
    boolean deleteById(Long id) throws ObjectNotFoundException;
    boolean delete(Order order);
}
