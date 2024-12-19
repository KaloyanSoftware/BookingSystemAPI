package org.booking.bookingsystemapi.service.userService;

import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.domain.UserPrincipal;
import org.booking.bookingsystemapi.repository.UserRepository;
import org.booking.bookingsystemapi.service.logDataService.LogDataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@Qualifier("originalUserService")
public class OriginalUserService implements UserService{
    private UserRepository userRepository;

    private LogDataService logDataService;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public OriginalUserService(UserRepository userRepository, LogDataService logDataService) {
        this.userRepository = userRepository;
        this.logDataService = logDataService;
    }

    @Override
    public List<User> fetchAllUsers() {
        logDataService.saveLogData("User","GET");
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(Long id) {
        logDataService.saveLogData("User","GET");
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsername(username);

        if(foundUser == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(foundUser);

    }

    @Override
    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        logDataService.saveLogData("User","POST");
        return user;
    }

    @Override
    public User updateUser(User currentUserBody, User updateRequestUserBody) {
        if (!Objects.equals(updateRequestUserBody.getFirstName(), currentUserBody.getFirstName())
        && updateRequestUserBody.getFirstName() != null) {
            currentUserBody.setFirstName(updateRequestUserBody.getFirstName());
        }
        if (!Objects.equals(updateRequestUserBody.getLastName(), currentUserBody.getLastName())
        && updateRequestUserBody.getLastName() != null) {
            currentUserBody.setLastName(updateRequestUserBody.getLastName());
        }
        if (!Objects.equals(updateRequestUserBody.getEmail(), currentUserBody.getEmail())
        && updateRequestUserBody.getEmail() != null) {
            currentUserBody.setEmail(updateRequestUserBody.getEmail());
        }
        if (!Objects.equals(updateRequestUserBody.getPhone(), currentUserBody.getPhone())
        && updateRequestUserBody.getPhone() != null) {
            currentUserBody.setPhone(updateRequestUserBody.getPhone());
        }
        if (!Objects.equals(updateRequestUserBody.getPassword(), currentUserBody.getPassword())
                && updateRequestUserBody.getPassword() != null) {
            currentUserBody.setPassword(encoder.encode(updateRequestUserBody.getPassword()));
        }
        if (!Objects.equals(updateRequestUserBody.getUsername(), currentUserBody.getUsername())
                && updateRequestUserBody.getUsername() != null) {
            currentUserBody.setUsername(updateRequestUserBody.getUsername());
        }

        // Save the updated user
        logDataService.saveLogData("User","PUT");
        return saveUser(currentUserBody);
    }


    @Override
    public void deleteUserById(Long id) {
        logDataService.saveLogData("User","DELETE");
        userRepository.deleteById(id);
    }
}
