package org.booking.bookingsystemapi.config;

import lombok.extern.java.Log;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@Log
public class Test implements CommandLineRunner {

    private UserService userService;

    public Test(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args){
        log.warning("Misho Somov pass: " + userService.fetchUserById(5L).getPassword());
    }
}
