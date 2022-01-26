package com.basovProjects.cryptoCurrencyWatcher.service;

import com.basovProjects.cryptoCurrencyWatcher.model.Order;

public interface OrderService {
    boolean save(Order order);
    boolean findById(Long id);
    boolean delete(Long id);
}
