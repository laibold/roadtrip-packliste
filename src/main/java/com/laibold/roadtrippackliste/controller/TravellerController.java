package com.laibold.roadtrippackliste.controller;

import com.laibold.roadtrippackliste.model.exception.badRequest.RequestBodyMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerIdMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerNameMissingException;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("travellers")
public class TravellerController {
    @Autowired
    TravellerService service;

    @PostMapping
    public Traveller postTraveller(@RequestBody Traveller traveller) {
        try {
            return service.add(traveller);
        } catch (RequestBodyMissingException | TravellerNameMissingException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    @GetMapping
    @ResponseBody
    public List<Traveller> getTravellers() {
        return service.getTravellers();
    }

    //TODO remove
}
