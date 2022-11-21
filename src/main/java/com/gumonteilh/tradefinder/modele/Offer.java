package com.gumonteilh.tradefinder.modele;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Offer {

    private User author;

    private Pokemon lFPokemon;

    private Pokemon fTPokemon;

    private Date creationDate;


    Offer (User author, Pokemon lFPokemon, Pokemon fTPokemon) {
        this.author = author;
        this.lFPokemon = lFPokemon;
        this.fTPokemon = fTPokemon;

        this.creationDate = new Date();
    }


    
}
