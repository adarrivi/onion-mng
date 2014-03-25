package com.adarrivi.app.contract;

import java.util.List;

import com.adarrivi.app.entity.User;

public interface UserJackContract {

    void save(User user);

    List<User> findAll();
}
