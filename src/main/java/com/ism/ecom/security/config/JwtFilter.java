package com.ism.ecom.security.config;

import com.ism.ecom.security.services.impl.JwtService;
import groovy.util.logging.Slf4j;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String authorizationHeader=  request.getHeader("Authorization");
      String token="";
      String username="";
      if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
             token=authorizationHeader.substring(7);
            //Extraire le Username du token
             username= jwtService.extractUsername(token);
             logger.info(username);

      }



        filterChain.doFilter(request, response);

    }
}
