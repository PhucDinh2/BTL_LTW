package com.example.managent_library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.managent_library.common.Constants;
import com.example.managent_library.model.User;
import com.example.managent_library.service.UserService;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initDatabaseEntities();
    }


    private void initDatabaseEntities() {

        if( userService.getAllUsers().size() == 0) {
            userService.addNew(new User(" Admin", "admin", "admin", Constants.ROLE_ADMIN));
            userService.addNew(new User(" Librarian", "librarian", "librarian", Constants.ROLE_LIBRARIAN));
            userService.addNew(new User(" User", "user", "user", Constants.ROLE_USER));
        }

    }
}