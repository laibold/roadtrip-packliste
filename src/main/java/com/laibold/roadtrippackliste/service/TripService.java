package com.laibold.roadtrippackliste.service;

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

    /**
     * Adds trip to Repository
     *
     * @param trip Trip to add
     */
    public Trip add(Trip trip, Optional<Traveller> optionalTraveller) {
        if (optionalTraveller.isPresent()) {
            Traveller traveller = optionalTraveller.get();
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
     * @param oTraveller Optional Traveller
     * @param oTrip Optional Trip
     * @return Trip if addition succeeded
     */
    public Trip addTravellerToTrip(Optional<Traveller> oTraveller, Optional<Trip> oTrip) {
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
