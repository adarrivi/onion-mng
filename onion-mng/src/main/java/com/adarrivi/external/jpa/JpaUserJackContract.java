package com.adarrivi.external.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adarrivi.core.contract.UserJackContract;
import com.adarrivi.core.entity.User;

@Service
@Transactional(readOnly = true)
public class JpaUserJackContract implements UserJackContract {

    @Autowired
    private JpaUserDao hsqlDbUserDao;
    @Autowired
    private UserJpaUserEntityAdapter userHsqlDbUserEntityAdapter;

    @Override
    @Transactional
    public void save(User user) {
        JpaUserEntity hsqlDbUserEntity = userHsqlDbUserEntityAdapter.toEntity(user);
        hsqlDbUserDao.save(hsqlDbUserEntity);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (JpaUserEntity hsqldbUserEntity : hsqlDbUserDao.findAll()) {
            users.add(userHsqlDbUserEntityAdapter.toUser(hsqldbUserEntity));
        }
        return users;
    }
}
