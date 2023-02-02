package com.gumonteilh.tradefinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gumonteilh.tradefinder.modele.Pokemon;
import com.gumonteilh.tradefinder.service.PokemonService;

@RestController
@CrossOrigin(origins = "https://poketrade-dff2b.web.app/", maxAge = 3600)
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{id}")
    public Pokemon pokemon(@PathVariable String id){
        return pokemonService.getPokemon((Long.parseLong(id))).orElseThrow();
    }

    @GetMapping("/")
    public Iterable<Pokemon> getAllPokemon(){
        return pokemonService.getAllPokemon();
    }
}
