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
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void updateUser(User currentUserBody, User updateRequestUserBody) {
        if(updateRequestUserBody.getFirstName() != null) {
            currentUserBody.setFirstName(updateRequestUserBody.getFirstName());
        }
        if(updateRequestUserBody.getLastName() != null) {
            currentUserBody.setLastName(updateRequestUserBody.getLastName());
        }
        if(updateRequestUserBody.getEmail() != null) {
            currentUserBody.setEmail(updateRequestUserBody.getEmail());
        }
        if(updateRequestUserBody.getPhone() != null) {
            currentUserBody.setPhone(updateRequestUserBody.getPhone());
        }

        saveUser(currentUserBody);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(fetchUserById(id));
    }

}
