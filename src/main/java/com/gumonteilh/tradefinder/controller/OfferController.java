package com.gumonteilh.tradefinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gumonteilh.tradefinder.helpers.LightOffer;
import com.gumonteilh.tradefinder.modele.Offer;
import com.gumonteilh.tradefinder.service.OfferService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/offer")
public class OfferController {
    
    @Autowired
    private OfferService offerService;

    @GetMapping("/")
    public Iterable<Offer> getAllOffers(){
        return offerService.getOffers();
    }

    @GetMapping("/{id}")
    public Offer getOffer(@PathVariable Long id){
        return offerService.getOffer(id).orElseThrow();
    }

    @PostMapping("/")
    public ResponseEntity<Offer> create(@RequestBody LightOffer lightOffer) {
        Offer offer = offerService.save(lightOffer.getLookingForId(), lightOffer.getForTradeId(), lightOffer.getAuthor());
        if(offer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(offer, HttpStatus.CREATED);
        }


    @PostMapping("/")
    public ResponseEntity<Offer> create(@RequestBody Offer offer) {
        Offer newOffer = offerService.save(offer);
        if(newOffer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(newOffer, HttpStatus.CREATED);
        }
    }

    @PutMapping(value="/{id}")
    public Offer update(@PathVariable Long id, @RequestBody LightOffer lightOffer) {
        Offer offer = offerService.getOffer(id).orElseThrow();
        return offerService.update(offer, lightOffer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Offer> delete(@PathVariable Long id){
        Offer offer = offerService.getOffer(id).orElseThrow();
        offerService.delete(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }
}
