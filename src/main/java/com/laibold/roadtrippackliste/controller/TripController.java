package com.laibold.roadtrippackliste.controller;

import com.laibold.roadtrippackliste.model.exception.badRequest.RequestBodyMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerIdMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TripIdMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TripMissingException;
import com.laibold.roadtrippackliste.model.exception.notFound.TripNotFoundException;
import com.laibold.roadtrippackliste.model.exception.notFound.TravellerNotFoundException;
import com.laibold.roadtrippackliste.model.requests.trip.TravellerTripRequest;
import com.laibold.roadtrippackliste.model.requests.trip.CreateTripRequest;
import com.laibold.roadtrippackliste.model.trip.Trip;
import com.laibold.roadtrippackliste.service.rest.RestPreconditions;
import com.laibold.roadtrippackliste.service.TravellerService;
import com.laibold.roadtrippackliste.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("trips")
public class TripController {
    @Autowired
    TripService tripService;

    @Autowired
    TravellerService travellerService;

    @PostMapping
    @ResponseBody
    public Trip addTrip(@RequestBody CreateTripRequest request) {
        try {
            return tripService.add(request);
        } catch (RequestBodyMissingException | TravellerNotFoundException |
                TripMissingException | TravellerIdMissingException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    @GetMapping("/{tripId}")
    @ResponseBody
    public Trip getTrip(@PathVariable long tripId) {
        try {
            return RestPreconditions.checkFound(tripService.getTrip(tripId));
        } catch (TripNotFoundException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    //TODO remove trip

    @GetMapping
    @ResponseBody
    public List<Trip> getTrips() {
        return tripService.getTrips();
    }

    @PutMapping("/addTraveller")
    public Trip addTravellerToTrip(@RequestBody TravellerTripRequest request) {
        try {
            return tripService.addTravellerToTrip(request);
        } catch (RequestBodyMissingException | TravellerNotFoundException |
                TripIdMissingException | TravellerIdMissingException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    @DeleteMapping("/removeTraveller")
    @ResponseBody
    public String removeTravellerFromTrip(@RequestBody TravellerTripRequest request) {
        return tripService.removeTravellerFromTrip(request);
    }

}
