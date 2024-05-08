package com.ism.ecom.data.fixtures;


import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.repositories.CategorieRepository;

import groovy.transform.builder.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)

public class CategorieFixtures implements CommandLineRunner {
    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categorieList=new ArrayList<Categorie>();
        for (int i = 0; i < 5; i++) {
            //
            categorieList.add(Categorie
            .builder()
            .libelle(String.format("Categorie %d",i))
            .build());
        }
        categorieRepository.saveAllAndFlush(categorieList);
    }
}
