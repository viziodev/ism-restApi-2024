package com.ism.ecom.security.controllers;

import com.ism.ecom.security.controllers.dtos.AuthentificationRequestDto;
import com.ism.ecom.security.controllers.dtos.TokenResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface Security {
    @PostMapping("/login")
    ResponseEntity<Map<Object, Object>>  authenticateAndGetToken(@RequestBody AuthentificationRequestDto auth);
}
