package com.adarrivi.app.contract;

import com.adarrivi.app.entity.User;

public interface UserAdapter<K> {

    User toUser(K entity);

    K toEntity(User user);

}
