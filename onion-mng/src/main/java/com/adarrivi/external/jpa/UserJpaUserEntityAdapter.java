package com.adarrivi.external.jpa;

import org.springframework.stereotype.Component;

import com.adarrivi.core.dao.UserAdapter;
import com.adarrivi.core.entity.User;

@Component
public class UserJpaUserEntityAdapter implements UserAdapter<JpaUserEntity> {

    @Override
    public User toUser(JpaUserEntity entity) {
        return new User(entity.getName(), entity.getAge());
    }

    @Override
    public JpaUserEntity toEntity(User user) {
        return new JpaUserEntity(user.getName(), user.getAge());
    }

}
