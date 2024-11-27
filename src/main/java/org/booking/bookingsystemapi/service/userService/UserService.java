package org.booking.bookingsystemapi.service.userService;

import org.booking.bookingsystemapi.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    User saveUser(User user);

    void updateUser(User currentUserBody, User updateRequestUserBody);

    void deleteUserById(Long id);
}
