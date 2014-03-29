package com.adarrivi.core.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.core.dao.UserJackContract;
import com.adarrivi.core.entity.User;

@Service
public class CreateUserAction {

    @Autowired
    private UserJackContract userJackContract;

    public void createUser(User newUser) {
        userJackContract.save(newUser);
    }
}
