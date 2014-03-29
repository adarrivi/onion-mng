package com.adarrivi.core.dao;

import java.util.List;

import com.adarrivi.core.entity.User;

public interface UserJackContract {

    void save(User user);

    List<User> findAll();
}
