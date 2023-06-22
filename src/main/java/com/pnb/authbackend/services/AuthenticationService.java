package com.pnb.authbackend.services;

import com.pnb.authbackend.models.ApplicationUser;
import com.pnb.authbackend.models.Role;
import com.pnb.authbackend.models.dto.UserRegistrationRequestDTO;
import com.pnb.authbackend.repositories.RoleRepository;
import com.pnb.authbackend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public ApplicationUser register(UserRegistrationRequestDTO requestDTO) {
        Role userRole = this.roleRepository.findRoleByAuthority("USER").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        ApplicationUser user = ApplicationUser.builder()
                .userName(requestDTO.getUserName())
                .password(encoder.encode(requestDTO.getPassword()))
                .authorities(userRoles)
                .build();
        return this.userRepository.save(user);
    }
}
