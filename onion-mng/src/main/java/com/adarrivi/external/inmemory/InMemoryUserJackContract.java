package com.adarrivi.external.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.adarrivi.app.contract.UserAdapter;
import com.adarrivi.app.contract.UserJackContract;
import com.adarrivi.app.entity.User;

//@Component
public class InMemoryUserJackContract implements UserJackContract {

    private Map<String, Integer> userContainer = new HashMap<>();

    @Autowired
    private UserAdapter<Entry<String, Integer>> userEntryMapAdapter;

    @Override
    public void save(User user) {
        userContainer.put(user.getName(), user.getAge());
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        for (Entry<String, Integer> userEntry : userContainer.entrySet()) {
            allUsers.add(userEntryMapAdapter.toUser(userEntry));
        }
        return allUsers;
    }
}
