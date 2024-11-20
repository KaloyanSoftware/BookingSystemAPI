package org.booking.bookingsystemapi.presentation.restControllers;


import lombok.extern.java.Log;
import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Log
@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/bookingApi/users/{id}")
    public String retrieveUser(@PathVariable("id") String id) {
        return userService.fetchUserById(Long.parseLong(id)).toString();
    }

    @PostMapping("/bookingApi/users")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: Handle delete user requests
    @PutMapping("/bookingApi/users/{id}")
    public ResponseEntity<String> UpdateUser(@PathVariable("id") String id, @RequestBody User updateRequestUser) {
        log.info(String.format("Requested user body %s",updateRequestUser));
        try {
            userService.updateUser(userService.fetchUserById(Long.parseLong(id)), updateRequestUser);
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bookingApi/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        try {
            userService.deleteUserById(Long.parseLong(id));
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
