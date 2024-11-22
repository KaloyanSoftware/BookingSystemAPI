package org.booking.bookingsystemapi.service.userService;

import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void updateUser(User currentUserBody, User updateRequestUserBody) {
        if (!Objects.equals(updateRequestUserBody.getFirstName(), currentUserBody.getFirstName())) {
            currentUserBody.setFirstName(updateRequestUserBody.getFirstName());
        }
        if (!Objects.equals(updateRequestUserBody.getLastName(), currentUserBody.getLastName())) {
            currentUserBody.setLastName(updateRequestUserBody.getLastName());
        }
        if (!Objects.equals(updateRequestUserBody.getEmail(), currentUserBody.getEmail())) {
            currentUserBody.setEmail(updateRequestUserBody.getEmail());
        }
        if (!Objects.equals(updateRequestUserBody.getPhone(), currentUserBody.getPhone())) {
            currentUserBody.setPhone(updateRequestUserBody.getPhone());
        }

        // Save the updated user
        saveUser(currentUserBody);
    }


    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
