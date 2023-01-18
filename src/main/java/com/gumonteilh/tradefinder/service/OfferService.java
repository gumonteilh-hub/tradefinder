package com.gumonteilh.tradefinder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumonteilh.tradefinder.repository.OfferRepository;
import com.gumonteilh.tradefinder.helpers.LightOffer;
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

    public Optional<Offer> getOffer(Long id) {
        return offerRepository.findById(id);
    }

    public Iterable<Offer> getOffersFromUser(String user) {
        // todo
        return null;
    }
/*
    public Offer save(Long lookingForId, Long forTradeId, String author) {
        Pokemon lookingForPokemon = pokemonService.getPokemon(lookingForId).orElseThrow(); 
        Pokemon forTradePokemon = pokemonService.getPokemon(forTradeId).orElseThrow();
        return offerRepository.save(new Offer(lookingForPokemon, forTradePokemon, author));
    }

    public Offer save(Pokemon lookingForPokemon, Pokemon forTradePokemon, String author) {
        return offerRepository.save(new Offer(lookingForPokemon, forTradePokemon, author));
    }
 */
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public void delete(Long id) {
        offerRepository.deleteById(id);
    }

    public Offer update(Offer offer, LightOffer newLightOffer) {
        offer.setAuthor(newLightOffer.getAuthor());
        offer.setLookingForPokemon(pokemonService.getPokemon(newLightOffer.getLookingForId()).get());
        offer.setForTradePokemon(pokemonService.getPokemon(newLightOffer.getForTradeId()).get());
        return offerRepository.save(offer);
    }

    public Iterable<Offer> getOffersFromPokemonId (Long pokemonId, Boolean lookingFor) {
        Pokemon pokemon  = pokemonService.getPokemon(pokemonId).orElseThrow();

        if(lookingFor) {
            return offerRepository.findAllWithLookingForPokemonId(pokemon);
        } else {
            return offerRepository.findAllWithForTradePokemonId(pokemon);
        }
        
    }
    
}
