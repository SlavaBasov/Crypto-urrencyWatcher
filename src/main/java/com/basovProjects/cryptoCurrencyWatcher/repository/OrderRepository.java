package com.basovProjects.cryptoCurrencyWatcher.repository;

import com.basovProjects.cryptoCurrencyWatcher.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUsernameAndCryptocurrency_Id(String username, Long cryptocurrencyId);
    void deleteById(Long id);
}
