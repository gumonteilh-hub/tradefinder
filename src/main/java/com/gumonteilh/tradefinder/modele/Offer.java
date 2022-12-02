package com.gumonteilh.tradefinder.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Pokemon the user went to receive
     */
    @ManyToOne
    private Pokemon lookingForPokemon;

    /**
     * The Pokemon the user went to send
     */
    @ManyToOne
    private Pokemon forTradePokemon;

    private String author;

    public Offer(Pokemon lookingForPokemon, Pokemon forTradePokemon, String author){
        this.lookingForPokemon = lookingForPokemon;
        this.forTradePokemon = forTradePokemon;
        this.author = author;
    }

    public Offer(){}
}
