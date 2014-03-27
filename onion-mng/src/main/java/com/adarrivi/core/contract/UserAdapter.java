package com.adarrivi.core.contract;

import com.adarrivi.core.entity.User;

public interface UserAdapter<K> {

    User toUser(K entity);

    K toEntity(User user);

}
