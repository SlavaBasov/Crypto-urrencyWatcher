package com.basovProjects.cryptoCurrencyWatcher.service.impl;

import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import com.basovProjects.cryptoCurrencyWatcher.model.Order;
import com.basovProjects.cryptoCurrencyWatcher.repository.OrderRepository;
import com.basovProjects.cryptoCurrencyWatcher.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean save(Order order) {
        Order foundOrder = orderRepository.findByUsernameAndCryptocurrency_Id(order.getUsername(),
                order.getCryptocurrency().getId());
        if(foundOrder!=null){
            return false;
        }
        orderRepository.save(order);
        return true;
    }

    @Override
    public Order findById(Long id) throws ObjectNotFoundException {
        Order order;
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            order = orderOptional.get();
        }else {
            throw new ObjectNotFoundException("Not found the object with id=" + id);
        }
        return order;
    }

    @Override
    public boolean deleteById(Long id){
        orderRepository.deleteById(id);
        return false;
    }

    public boolean delete(Order order){
        orderRepository.delete(order);
        return false;
    }
}
