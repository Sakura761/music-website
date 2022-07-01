package com.sakura.service.impl;

import com.sakura.dao.ConsumerDao;
import com.sakura.domain.Consumer;
import com.sakura.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerDao consumerDao;
    @Override
    public boolean insertUser(Consumer consumer) {
       return consumerDao.addUser(consumer) > 0;
    }

    @Override
    public Consumer selectByUsername(String username) {
        Consumer consumer = consumerDao.selectByUsername(username);
        return consumer;
    }

    @Override
    public int verifyPassword(String username, String password) {
        int res = consumerDao.verifyPassword(username, password);
        return res;
    }

    @Override
    public boolean updateUser(Consumer consumer) {
        return consumerDao.updateUser(consumer) > 0;
    }

    @Override
    public Consumer getUSerById(int id) {
        return consumerDao.getUserById(id);
    }

    @Override
    public boolean updateAvator(Consumer consumer) {
        return consumerDao.updateUser(consumer) > 0;
    }

    @Override
    public boolean deleteUser(int id) {
        return consumerDao.deleteUser(id) > 0;
    }
}
