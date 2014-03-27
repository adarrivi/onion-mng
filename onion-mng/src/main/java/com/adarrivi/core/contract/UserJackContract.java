package com.adarrivi.core.contract;

import java.util.List;

import com.adarrivi.core.entity.User;

public interface UserJackContract {

    void save(User user);

    List<User> findAll();
}
