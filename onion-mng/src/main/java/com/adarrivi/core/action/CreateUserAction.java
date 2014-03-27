package com.adarrivi.core.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.core.contract.UserJackContract;
import com.adarrivi.core.entity.User;

@Service
public class CreateUserAction {

    @Autowired
    private UserJackContract userJackContract;

    public void createUser(User newUser) {
        userJackContract.save(newUser);
    }
}
