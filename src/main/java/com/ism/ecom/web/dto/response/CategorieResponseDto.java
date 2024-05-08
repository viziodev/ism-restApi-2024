package com.ism.ecom.web.dto.response;
import com.ism.ecom.data.entities.Categorie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieResponseDto {
    private Long id;
    private String libelle;


    public static  CategorieResponseDto toDto(Categorie categorie){
        return CategorieResponseDto.builder()
        .libelle(categorie.getLibelle())
        .id(categorie.getId())
        .build();
    }

}
