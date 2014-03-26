package com.adarrivi.external.inmemory;

import java.util.AbstractMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.adarrivi.app.contract.UserAdapter;
import com.adarrivi.app.entity.User;

@Component("userEntryMapAdapter")
public class UserEntryMapAdapter implements UserAdapter<Entry<String, Integer>> {

    @Override
    public User toUser(Entry<String, Integer> entity) {
        return new User(entity.getKey(), entity.getValue());
    }

    @Override
    public Entry<String, Integer> toEntity(User user) {
        return new AbstractMap.SimpleEntry<String, Integer>(user.getName(), user.getAge());
    }

}
