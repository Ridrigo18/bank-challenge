package com.bankchallenge.business.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginUserDto {
    private String email;
    private String password;
}
