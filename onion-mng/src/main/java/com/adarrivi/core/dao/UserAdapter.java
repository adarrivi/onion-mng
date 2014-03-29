package com.adarrivi.core.dao;

import com.adarrivi.core.entity.User;

public interface UserAdapter<K> {

    User toUser(K entity);

    K toEntity(User user);

}
