package com.adarrivi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.adarrivi.app.action.CreateUserAction;
import com.adarrivi.app.action.FindAllAction;
import com.adarrivi.app.entity.User;
import com.adarrivi.external.hsqldb.HsqlDbConfiguration;

@Component
public class HsqlDbMain {

    private static final Logger LOG = LoggerFactory.getLogger(HsqlDbMain.class);
    @Autowired
    private CreateUserAction createUserAction;
    @Autowired
    private FindAllAction findAllAction;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HsqlDbConfiguration.class);
        applicationContext.registerShutdownHook();
        HsqlDbMain mainBean = applicationContext.getBean(HsqlDbMain.class);
        mainBean.start();
    }

    private void start() {
        logAllUsers();
        addNewUsers(5);
        logAllUsers();
    }

    private void logAllUsers() {
        LOG.debug("User list: {}", findAllAction.findAll());

    }

    private void addNewUsers(int number) {
        for (int i = 0; i < number; i++) {
            createUserAction.createUser(new User("user number " + i, 25));
        }
    }
}
