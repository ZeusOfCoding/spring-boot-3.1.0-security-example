package com.pnb.authbackend.services;

import com.pnb.authbackend.models.ApplicationUser;
import com.pnb.authbackend.models.Role;
import com.pnb.authbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service looking for " + username);

        Optional<ApplicationUser> user = userRepository.findByUserName(username);
        System.out.println("user.get() = " + user.get());

        return user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));

    }

}
