package com.gumonteilh.tradefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gumonteilh.tradefinder.service.PokemonService;

@RestController
public class PokemonController {
    
    
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon")
    public String pokemon(@RequestParam String id){
        return pokemonService.getPokemon((Long.parseLong(id))).toString();
    }
}
