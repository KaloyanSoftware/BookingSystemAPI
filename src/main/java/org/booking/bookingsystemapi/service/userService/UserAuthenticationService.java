package org.booking.bookingsystemapi.service.userService;

import lombok.extern.java.Log;
import org.booking.bookingsystemapi.domain.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Log
@Service
public class UserAuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    public UserAuthenticationService(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    public String verify(User user) {
        log.warning("Authenticating user " + user.getUsername());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            log.warning("Successfully authenticated user " + user.getUsername());
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }
}
