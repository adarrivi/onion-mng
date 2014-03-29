package com.adarrivi.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.core.dao.UserJackContract;
import com.adarrivi.core.entity.User;

@Service
public class FindAllAction {

    @Autowired
    private UserJackContract userJackContract;

    public List<User> findAll() {
        return userJackContract.findAll();
    }
}
