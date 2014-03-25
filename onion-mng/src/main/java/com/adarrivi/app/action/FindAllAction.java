package com.adarrivi.app.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.app.contract.UserJackContract;
import com.adarrivi.app.entity.User;

@Service
public class FindAllAction {

    @Autowired
    private UserJackContract userJackContract;

    public List<User> findAll() {
        return userJackContract.findAll();
    }
}
