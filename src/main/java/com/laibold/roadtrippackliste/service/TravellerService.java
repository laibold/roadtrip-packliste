package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.persistence.traveller.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TravellerService {
    @Autowired
    private TravellerRepository repository;

    public void add(Traveller traveller) {
        repository.save(traveller);
    }

    public List<Traveller> getTravellers() {
        return (List<Traveller>) repository.findAll();
    }

}
