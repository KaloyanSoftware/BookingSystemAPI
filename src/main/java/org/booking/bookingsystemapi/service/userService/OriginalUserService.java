package org.booking.bookingsystemapi.service.userService;

import org.booking.bookingsystemapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OriginalUserService implements UserService {
    private UserRepository userRepository;

    public OriginalUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
