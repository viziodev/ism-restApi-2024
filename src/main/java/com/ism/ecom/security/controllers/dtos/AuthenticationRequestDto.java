package com.ism.ecom.security.controllers.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
