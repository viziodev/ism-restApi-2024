package com.ism.ecom.web.dto.request;

import com.ism.ecom.data.entities.Article;
import lombok.*;

import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ArticlePanierDto {
    private Long idArticle;
    private String libelle;
    private Double montant=0.0;
    private Double quantite;
    private Double quantiteStock;
    private Double prix;
    public static ArticlePanierDto toDto(Article article) {
         return ArticlePanierDto
                 .builder()
                 .idArticle(article.getId())
                 .libelle(article.getLibelle())
                 .quantiteStock(Double.valueOf(article.getQteStock()))
                 .prix(article.getNouveauPrix())
                 .build();
    }

    public  Double calculNewQte(Double newQte){
         quantite+= newQte;
         return quantite;
    }
    public  Double calculMontant(Double newMontant){
        montant+= newMontant;
        return montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticlePanierDto that = (ArticlePanierDto) o;
        return Objects.equals(idArticle, that.idArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticle);
    }
}
