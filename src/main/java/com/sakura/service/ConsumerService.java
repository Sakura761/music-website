package com.sakura.service;

import com.sakura.domain.Consumer;

public interface ConsumerService {
    boolean insertUser(Consumer consumer);
    Consumer selectByUsername(String username);
    int verifyPassword(String username, String password);
    boolean updateUser(Consumer consumer);
    Consumer getUSerById(int id);
    boolean updateAvator(Consumer consumer);
    boolean deleteUser(int id);
}
