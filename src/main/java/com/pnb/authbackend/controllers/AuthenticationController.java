package com.pnb.authbackend.controllers;

import com.pnb.authbackend.models.ApplicationUser;
import com.pnb.authbackend.models.dto.UserRegistrationRequestDTO;
import com.pnb.authbackend.services.AuthenticationService;
import com.pnb.authbackend.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser register(@RequestBody UserRegistrationRequestDTO requestDTO){
        return this.authenticationService.register(requestDTO);
    }
}
