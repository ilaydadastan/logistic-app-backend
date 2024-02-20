package com.example.logisticbackend.dto;

import lombok.Data;

@Data
public class UserLoginRequestVM {

    private String username;
    private String password;
}
