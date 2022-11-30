package com.gumonteilh.tradefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gumonteilh.tradefinder.modele.Pokemon;
import com.gumonteilh.tradefinder.service.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{id}")
    public Pokemon pokemon(@PathVariable String id){
        return pokemonService.getPokemon((Long.parseLong(id))).orElseThrow();
    }
}
