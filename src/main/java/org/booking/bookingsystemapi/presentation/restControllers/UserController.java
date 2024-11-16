package org.booking.bookingsystemapi.presentation.restControllers;


import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
