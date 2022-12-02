package com.gumonteilh.tradefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gumonteilh.tradefinder.modele.Offer;
import com.gumonteilh.tradefinder.service.OfferService;

@RestController
@RequestMapping("/api/offer")
public class OfferController {
    
    @Autowired
    private OfferService offerService;

    @GetMapping("/")
    public Iterable<Offer> getAllOffers(){
        return offerService.getOffers();
    }

    @PostMapping("/")
    public ResponseEntity<Offer> create(@RequestBody ObjectNode json) {
        Offer offer = offerService.save(json.get("lookingForId").longValue(), json.get("forTradeId").longValue(), json.get("author").toString());
        if(offer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(offer, HttpStatus.CREATED);
        }

    }
}
