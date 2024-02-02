package com.example.logisticbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVM {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
