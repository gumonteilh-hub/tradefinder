package com.gumonteilh.tradefinder.modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.gumonteilh.tradefinder.modele.Enums.Type;

import lombok.Data;

@Entity
@Data
public class Pokemon {
    private int paldeaPokedexNumber;
    @Id
    private Long nationalPokedexNumber;

    private String imageUrl;

    private String nomFrancais;

    private String nomAnglais;

    private Type type1;

    private Type type2;

    /* 
    Pokemon (int paldeaPokedexNumber, String imageUrl, String nomFrancais, String nomAnglais, Type type1, Type type2) {
        this.paldeaPokedexNumber=paldeaPokedexNumber;
        this.imageUrl=imageUrl;
        this.nomFrancais=nomFrancais;
        this.nomAnglais=nomAnglais;
        this.type1=type1;
        this.type2=type2;
    }

    Pokemon (int paldeaPokedexNumber, Long nationalPokedexNumber, String imageUrl, String nomFrancais, String nomAnglais, Type type1) {
        this.paldeaPokedexNumber=paldeaPokedexNumber;
        this.nationalPokedexNumber=nationalPokedexNumber;
        this.imageUrl=imageUrl;
        this.nomFrancais=nomFrancais;
        this.nomAnglais=nomAnglais;
        this.type1=type1;
    }
*/

}
