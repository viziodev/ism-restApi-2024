package com.ism.ecom.web.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.repositories.CategorieRepository;import com.ism.ecom.web.controllers.CategorieRestController;
import com.ism.ecom.web.dto.RestResponse;

import com.ism.ecom.web.dto.response.CategorieResponseDto;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CategorieRestControllerImpl implements CategorieRestController {
     private final CategorieRepository categorieRepository;
    @Override
    public ResponseEntity<Map<Object, Object>> listerCategorie() {
        List<Categorie>  categories=  categorieRepository.findAll();
        Map<Object, Object>  response= RestResponse.response(categories.stream().map(CategorieResponseDto::toDto),HttpStatus.OK);
    
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
