package org.booking.bookingsystemapi.presentation.restControllers;

import lombok.extern.java.Log;
import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.service.userService.UserAuthenticationService;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log
@RestController
@RequestMapping("/bookingApi/users")
public class UserController {
    private final UserService userService;

    private UserAuthenticationService userAuthenticationService;

    public UserController(UserService userService, UserAuthenticationService userAuthenticationService) {
        this.userService = userService;
        this.userAuthenticationService = userAuthenticationService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.fetchUserById(Long.parseLong(id)));
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        log.info("Requested login: " + user.getUsername());
        return userAuthenticationService.verify(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User updateRequestUser) {
        return ResponseEntity.ok(userService.updateUser(userService.fetchUserById(Long.parseLong(id)), updateRequestUser));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }
}
