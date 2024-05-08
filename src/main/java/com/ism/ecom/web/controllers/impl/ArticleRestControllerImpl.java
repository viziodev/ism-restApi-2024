package com.ism.ecom.web.controllers.impl;

import com.ism.ecom.web.controllers.ArticleRestController;
import com.ism.ecom.web.dto.response.ArticleAllResponseDto;
import com.ism.ecom.web.dto.RestResponse;
import com.ism.ecom.data.entities.Article;
import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.repositories.CategorieRepository;
import com.ism.ecom.services.ArticleService;
import com.ism.ecom.web.dto.request.ArticlePanierDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class ArticleRestControllerImpl implements ArticleRestController {
    private final ArticleService articleService;
    private final CategorieRepository categorieRepository;
    @Override
    public ResponseEntity<Map<Object, Object>> listerArticleParLibelle(String libelle) {
        Article article = articleService.getArticleByLibelle(libelle);
        Map<Object, Object> response;
        if (article == null){
            response= RestResponse.response(null, HttpStatus.NO_CONTENT);
        }else {
            response= RestResponse.response(ArticlePanierDto.toDto(article),HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerArticle() {
        List<Article> articles = articleService.getArticlesFormComande();
        List<ArticleAllResponseDto> list = articles.stream().map(ArticleAllResponseDto::toDto).toList();
        return new ResponseEntity<>(RestResponse.response(list,HttpStatus.OK), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerArticleParCategorie( @PathVariable Long categorieId) {
        Categorie categorie= categorieRepository.findById(categorieId).orElse(null);

       Map<Object, Object> response;
        if (categorie == null){
            response= RestResponse.response(null, HttpStatus.NO_CONTENT);
        }else {
            List<Article> articles = articleService.getArticlesByCategorie(categorie);
            List<ArticleAllResponseDto> list = articles.stream().map(ArticleAllResponseDto::toDto).toList();
            response= RestResponse.response(list,HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
