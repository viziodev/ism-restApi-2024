package com.ism.ecom.data.repositories;

import com.ism.ecom.data.entities.Article;
import com.ism.ecom.data.entities.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article,Long> {
           List<Article> findAllByActiveTrue();
           Article findArticleByLibelleAndActiveTrue(String libelle);
           List<Article> findAllByCategorie(Categorie categorie);


}
