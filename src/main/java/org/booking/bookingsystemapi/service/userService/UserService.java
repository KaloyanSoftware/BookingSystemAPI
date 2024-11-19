package org.booking.bookingsystemapi.service.userService;

import org.booking.bookingsystemapi.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User fetchUserById(Long id);

    User createUser(User user);
}
