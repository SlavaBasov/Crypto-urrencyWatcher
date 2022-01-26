package com.basovProjects.cryptoCurrencyWatcher.service;

import com.basovProjects.cryptoCurrencyWatcher.model.User;

public interface UserService {
    boolean save(User user);
    User findById(Long id);
}
