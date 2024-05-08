package com.ism.ecom.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Map;

public interface ArticleRestController {

    @GetMapping("/articles/libelle/{libelle}")//End Point
    ResponseEntity<Map<Object, Object>> listerArticleParLibelle(
            @PathVariable String libelle
    );
    @GetMapping("/articles")//End Point
    ResponseEntity<Map<Object, Object>> listerArticle();

    @GetMapping("/articles/categorie/{categorieId}")//End Point
    ResponseEntity<Map<Object, Object>> listerArticleParCategorie(@PathVariable Long categorieId);
}
