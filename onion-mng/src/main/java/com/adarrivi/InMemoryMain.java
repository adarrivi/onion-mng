package com.adarrivi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adarrivi.core.entity.User;
import com.adarrivi.core.service.FindAllAction;
import com.adarrivi.core.service.management.CreateUserAction;
import com.adarrivi.external.inmemory.InMemoryConfiguration;

public class InMemoryMain {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryMain.class);

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(InMemoryConfiguration.class);
        applicationContext.registerShutdownHook();
        FindAllAction findAllAction = applicationContext.getBean(FindAllAction.class);
        CreateUserAction createUserAction = applicationContext.getBean(CreateUserAction.class);
        for (int i = 0; i < 5; i++) {
            createUserAction.createUser(new User("user number " + i, 25));
        }
        LOG.debug("User list: {}", findAllAction.findAll());
    }
}
