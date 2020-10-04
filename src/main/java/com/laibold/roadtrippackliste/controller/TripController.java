package com.laibold.roadtrippackliste.controller;

import com.laibold.roadtrippackliste.model.requests.trip.AddTravellerToTripRequest;
import com.laibold.roadtrippackliste.model.requests.trip.CreateTripRequest;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.model.trip.Trip;
import com.laibold.roadtrippackliste.service.TravellerService;
import com.laibold.roadtrippackliste.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("trips")
public class TripController {
    @Autowired
    TripService tripService;

    @Autowired
    TravellerService travellerService;

    @PostMapping
    @ResponseBody
    public Trip postTrip(@RequestBody CreateTripRequest request) {
        return tripService.add(request);
    }

    @GetMapping
    @ResponseBody
    public List<Trip> getTrips() {
        return tripService.getTrips();
    }

    @PutMapping("/addTraveller")
    public Trip addTravellerToTrip(@RequestBody AddTravellerToTripRequest request) {
        return tripService.addTravellerToTrip(request);
    }

}
