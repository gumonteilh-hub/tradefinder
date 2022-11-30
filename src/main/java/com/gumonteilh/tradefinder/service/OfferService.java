package com.gumonteilh.tradefinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumonteilh.tradefinder.repository.OfferRepository;
import com.gumonteilh.tradefinder.modele.Offer;

import lombok.Data;

@Service
@Data
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public Iterable<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Iterable<Offer> getOffersFromUser(String user) {
        // todo
        return null;
    }

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public void delete(Long id) {
        offerRepository.deleteById(id);
    }
    
}
