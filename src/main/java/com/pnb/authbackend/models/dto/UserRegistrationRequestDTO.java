package com.pnb.authbackend.models.dto;

import lombok.Data;

@Data
public class UserRegistrationRequestDTO {
    private String userName;
    private String password;
}
