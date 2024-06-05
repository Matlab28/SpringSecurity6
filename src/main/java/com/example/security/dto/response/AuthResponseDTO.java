package com.example.security.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponseDTO {

    private String token;

    public AuthResponseDTO(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}