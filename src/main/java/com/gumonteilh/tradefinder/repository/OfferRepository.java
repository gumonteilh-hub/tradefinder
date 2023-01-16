package com.gumonteilh.tradefinder.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gumonteilh.tradefinder.modele.Offer;
import com.gumonteilh.tradefinder.modele.Pokemon;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long>{

    @Query("SELECT o FROM Offer o WHERE o.forTradePokemon = ?1")
    Iterable<Offer> findAllWithForTradePokemonId(Pokemon pokemon);
    
}
