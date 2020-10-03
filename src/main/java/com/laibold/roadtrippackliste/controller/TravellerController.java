package com.laibold.roadtrippackliste.controller;

import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travellers")
public class TravellerController {
    @Autowired
    TravellerService service;

    @PostMapping
    public Traveller postTraveller(@RequestBody Traveller traveller) {
        return service.add(traveller);
    }

    @GetMapping
    @ResponseBody
    public List<Traveller> getTravellers() {
        return service.getTravellers();
    }

}
