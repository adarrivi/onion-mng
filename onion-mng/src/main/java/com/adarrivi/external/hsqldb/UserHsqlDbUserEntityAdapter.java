package com.adarrivi.external.hsqldb;

import org.springframework.stereotype.Component;

import com.adarrivi.app.contract.UserAdapter;
import com.adarrivi.app.entity.User;

@Component("userHsqlDbUserEntityAdapter")
public class UserHsqlDbUserEntityAdapter implements UserAdapter<HsqlDbUserEntity> {

    @Override
    public User toUser(HsqlDbUserEntity entity) {
        return new User(entity.getName(), entity.getAge());
    }

    @Override
    public HsqlDbUserEntity toEntity(User user) {
        return new HsqlDbUserEntity(user.getName(), user.getAge());
    }

}
