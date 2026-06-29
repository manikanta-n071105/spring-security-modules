package com.bank.springsec.dto;

import lombok.Getter;

@Getter

public class LoginResponse {

    private String message;

    public LoginResponse(String message) {
        this.message = message;
    }
}
