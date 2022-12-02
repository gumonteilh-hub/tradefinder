package com.gumonteilh.tradefinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumonteilh.tradefinder.repository.OfferRepository;
import com.gumonteilh.tradefinder.modele.Offer;
import com.gumonteilh.tradefinder.modele.Pokemon;

import lombok.Data;

@Service
@Data
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private PokemonService pokemonService;

    public Iterable<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Iterable<Offer> getOffersFromUser(String user) {
        // todo
        return null;
    }

    public Offer save(Long lookingForId, Long forTradeId, String author) {
        Pokemon lookingForPokemon = pokemonService.getPokemon(lookingForId).orElseThrow(); 
        Pokemon forTradePokemon = pokemonService.getPokemon(forTradeId).orElseThrow();
        System.out.println(forTradePokemon.toString());
        return offerRepository.save(new Offer(lookingForPokemon, forTradePokemon, author));
    }

    public void delete(Long id) {
        offerRepository.deleteById(id);
    }
    
}
