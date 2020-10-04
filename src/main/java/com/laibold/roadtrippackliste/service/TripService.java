package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.requests.trip.AddTravellerToTripRequest;
import com.laibold.roadtrippackliste.model.requests.trip.CreateTripRequest;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.model.trip.Trip;
import com.laibold.roadtrippackliste.persistence.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Service for Trips
 */
@Component
public class TripService {
    @Autowired
    private TripRepository repository;

    @Autowired
    TravellerService travellerService;

    @Autowired
    TripService tripService;

    /**
     * Adds trip to Repository
     *
     * @param request CreateTripRequest
     * @return New Trip state
     */
    public Trip add(CreateTripRequest request) {
        Optional<Traveller> oTraveller = travellerService.getTraveller(request.getTravellerId());
        Trip trip = request.getTrip();

        if (oTraveller.isPresent()) {
            Traveller traveller = oTraveller.get();
            trip.addTraveller(traveller);
            return repository.save(trip);
        }
        return null;
    }

    /**
     * Gets all Trips from Repository
     *
     * @return List of Trips
     */
    public List<Trip> getTrips() {
        return (List<Trip>) repository.findAll();
    }

    /**
     * Trip by its id
     *
     * @param id id
     * @return Optional
     */
    public Optional<Trip> getTrip(long id) {
        return repository.findById(id);
    }

    /**
     * Adds existing Traveller to existing Trip
     *
     * @param request AddTravellerToTripRequest
     * @return New Trip state
     */
    public Trip addTravellerToTrip(AddTravellerToTripRequest request) {
        Optional<Traveller> oTraveller = travellerService.getTraveller(request.getTravellerId());
        Optional<Trip> oTrip = tripService.getTrip(request.getTripId());

        Traveller traveller;
        Trip trip;
        if (oTraveller.isPresent()) {
            traveller = oTraveller.get();
        } else {
            return null; // Traveller not found
        }
        if (oTrip.isPresent()) {
            Optional<Trip> oRepoTrip = repository.findById(oTrip.get().getId());
            if (oRepoTrip.isPresent()) {
                trip = oRepoTrip.get();
                trip.addTraveller(traveller);
                return repository.save(trip);
            }
        } else {
            return null; // Trip not found
        }
        return null; // dead code
    }

}
