package com.basovProjects.cryptoCurrencyWatcher.repository;

import com.basovProjects.cryptoCurrencyWatcher.model.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {
    Cryptocurrency findBySymbol(String symbol);
}
