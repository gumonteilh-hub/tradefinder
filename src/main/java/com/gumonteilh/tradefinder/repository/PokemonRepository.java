package com.gumonteilh.tradefinder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gumonteilh.tradefinder.modele.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
}
