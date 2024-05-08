package com.ism.ecom.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface CategorieRestController {
      @GetMapping("/categories")
      ResponseEntity<Map<Object, Object>> listerCategorie();
      
} 
