package com.basovProjects.cryptoCurrencyWatcher.repository;

import com.basovProjects.cryptoCurrencyWatcher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
