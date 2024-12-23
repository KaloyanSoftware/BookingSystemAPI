package org.booking.bookingsystemapi.service.userService;

import org.booking.bookingsystemapi.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    User saveUser(User user);

    User updateUser(User currentUserBody, User updateRequestUserBody);

    void deleteUserById(Long id);
}
