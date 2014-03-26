package com.adarrivi.external.hsqldb;

import java.util.ArrayList;
import java.util.List;

import com.adarrivi.app.contract.UserJackContract;
import com.adarrivi.app.entity.User;

public class HsqlDbUserJackContract implements UserJackContract {

    private HsqlDbUserDao hsqlDbUserDao;
    private UserHsqlDbUserEntityAdapter userHsqlDbUserEntityAdapter;

    public HsqlDbUserJackContract(HsqlDbUserDao hsqlDbUserDao, UserHsqlDbUserEntityAdapter userHsqlDbUserEntityAdapter) {
        this.hsqlDbUserDao = hsqlDbUserDao;
        this.userHsqlDbUserEntityAdapter = userHsqlDbUserEntityAdapter;
    }

    @Override
    public void save(User user) {
        HsqlDbUserEntity hsqlDbUserEntity = userHsqlDbUserEntityAdapter.toEntity(user);
        hsqlDbUserDao.saveAndFlush(hsqlDbUserEntity);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (HsqlDbUserEntity hsqldbUserEntity : hsqlDbUserDao.findAll()) {
            users.add(userHsqlDbUserEntityAdapter.toUser(hsqldbUserEntity));
        }
        return users;
    }
}
