package com.ism.ecom.data.repositories;

import com.ism.ecom.data.entities.Article;
import com.ism.ecom.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {
           List<Article> findAllByActiveTrue();
           Article findArticleByLibelleAndActiveTrue(String libelle);


}
