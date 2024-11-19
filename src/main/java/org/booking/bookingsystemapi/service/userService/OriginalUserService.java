package org.booking.bookingsystemapi.service.userService;

import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OriginalUserService implements UserService {
    private UserRepository userRepository;

    public OriginalUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User fetchUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }


}
