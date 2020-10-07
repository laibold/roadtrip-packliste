package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.exception.badRequest.RequestBodyMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerIdMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerNameMissingException;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.persistence.traveller.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Service for Travellers
 */
@Component
public class TravellerService {
    @Autowired
    private TravellerRepository repository;

    /**
     * Adds Traveller to Repository
     *
     * @param traveller Traveller to add
     */
    public Traveller add(Traveller traveller) {
        if (traveller == null) {
            throw new RequestBodyMissingException();
        }
        if (traveller.getName() == null) {
            throw new TravellerNameMissingException();
        }
        return repository.save(traveller);
    }

    /**
     * Gets all Travellers from Repository
     *
     * @return List of Travellers
     */
    public List<Traveller> getTravellers() {
        return (List<Traveller>) repository.findAll();
    }

    /**
     * Gets Traveller by its id
     *
     * @param id id
     * @return Optional
     */
    public Optional<Traveller> getTraveller(long id) {
        return repository.findById(id);
    }

}
