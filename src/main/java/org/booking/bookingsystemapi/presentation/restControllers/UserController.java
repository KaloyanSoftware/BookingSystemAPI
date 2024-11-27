package org.booking.bookingsystemapi.presentation.restControllers;

import lombok.extern.java.Log;
import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log
@RestController
@RequestMapping("/bookingApi/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.fetchUserById(Long.parseLong(id)));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
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
