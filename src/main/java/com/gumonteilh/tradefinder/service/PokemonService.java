package com.gumonteilh.tradefinder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gumonteilh.tradefinder.modele.Pokemon;
import com.gumonteilh.tradefinder.repository.PokemonRepository;

import lombok.Data;

@Service
@Data
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Optional<Pokemon> getPokemon(final Long id){
            return pokemonRepository.findById(id);
    }

    public Iterable<Pokemon> getAllPokemon(){
        return pokemonRepository.findAll();
}
}
