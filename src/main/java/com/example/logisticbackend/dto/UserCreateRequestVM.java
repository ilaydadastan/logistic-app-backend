package com.example.logisticbackend.dto;

import lombok.Data;

@Data
public class UserCreateRequestVM {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

}
