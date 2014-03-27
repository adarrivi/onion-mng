package com.adarrivi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adarrivi.core.action.CreateUserAction;
import com.adarrivi.core.action.FindAllAction;
import com.adarrivi.core.entity.User;
import com.adarrivi.external.jpa.JpaConfiguration;

public class JpaMain {

    private static final Logger LOG = LoggerFactory.getLogger(JpaMain.class);

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JpaConfiguration.class);
        applicationContext.registerShutdownHook();
        FindAllAction findAllAction = applicationContext.getBean(FindAllAction.class);
        CreateUserAction createUserAction = applicationContext.getBean(CreateUserAction.class);
        for (int i = 0; i < 5; i++) {
            createUserAction.createUser(new User("user number " + i, 25));
        }
        LOG.debug("User list: {}", findAllAction.findAll());
    }
}
