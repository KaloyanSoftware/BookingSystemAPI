package org.booking.bookingsystemapi.presentation.restControllers;


import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            userService.createUser(user);
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: Handle update and delete user requests (update for chosen fields)
    @PutMapping("/bookingApi/users/{id}")
        public String updateUser(@PathVariable String id) {
        return null;
    }

}
