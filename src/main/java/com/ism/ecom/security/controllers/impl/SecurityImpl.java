package com.ism.ecom.security.controllers.impl;

import com.ism.ecom.security.controllers.Security;
import com.ism.ecom.security.controllers.dtos.AuthentificationRequestDto;
import com.ism.ecom.security.controllers.dtos.TokenResponseDto;
import com.ism.ecom.security.data.entities.AppUser;
import com.ism.ecom.security.services.JwtService;
import com.ism.ecom.security.services.SecurityService;
import com.ism.ecom.web.dto.RestResponse;
import com.ism.ecom.web.dto.request.ArticlePanierDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SecurityImpl implements Security {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public    ResponseEntity<Map<Object, Object>> authenticateAndGetToken(AuthentificationRequestDto authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        Map<Object, Object> response;
        if (authentication.isAuthenticated()) {
            TokenResponseDto token = TokenResponseDto.builder()
                    .token(jwtService.generateToken(authRequest.getUsername()))
                    .build();
            response= RestResponse.response(token,HttpStatus.OK);

        } else {
            response= RestResponse.response(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
