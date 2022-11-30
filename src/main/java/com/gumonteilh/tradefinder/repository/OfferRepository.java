package com.gumonteilh.tradefinder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gumonteilh.tradefinder.modele.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long>{
    
}
