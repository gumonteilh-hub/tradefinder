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
    private Pokemon LookingForPokemon;

    /**
     * The Pokemon the user went to send
     */
    @ManyToOne
    private Pokemon ForTradePokemon;

    private String author;
}
