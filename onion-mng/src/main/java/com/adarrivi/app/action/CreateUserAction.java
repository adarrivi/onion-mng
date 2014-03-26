package com.adarrivi.app.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.app.contract.UserJackContract;
import com.adarrivi.app.entity.User;

@Service
public class CreateUserAction {

    @Autowired
    private UserJackContract userJackContract;

    public void createUser(User newUser) {
        userJackContract.save(newUser);
    }
}