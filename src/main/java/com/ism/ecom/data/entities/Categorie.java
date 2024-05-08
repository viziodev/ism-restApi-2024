package com.ism.ecom.data.entities;

import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "categories")
@Builder
public class Categorie extends  AbstractEntity {
    @Column(unique = true,nullable = false,length = 50)
    private String libelle;
    @OneToMany(mappedBy ="categorie")
    private List<Article> articles; 

}
