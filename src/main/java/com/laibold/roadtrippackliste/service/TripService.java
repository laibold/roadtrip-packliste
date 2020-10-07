package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.exception.badRequest.RequestBodyMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerIdMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TripIdMissingException;
import com.laibold.roadtrippackliste.model.exception.notFound.TravellerNotFoundException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TripMissingException;
import com.laibold.roadtrippackliste.model.exception.notFound.TripNotFoundException;
import com.laibold.roadtrippackliste.model.packingList.TravellerPackingList;
import com.laibold.roadtrippackliste.model.requests.trip.TravellerTripRequest;
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
    private TripRepository tripRepository;

    @Autowired
    TravellerService travellerService;

    @Autowired
    TripService tripService;

    @Autowired
    TravellerPackingListService travellerPackingListService;

    /**
     * Adds trip to Repository
     *
     * @param request CreateTripRequest
     * @return New Trip state
     */
    public Trip add(CreateTripRequest request) {
        if (request == null) {
            throw new RequestBodyMissingException();
        }
        if (request.getTrip() == null || request.getTrip().getName() == null) {
            throw new TripMissingException();
        }
        if (request.getTravellerId() == 0) {
            throw new TravellerIdMissingException();
        }
        Optional<Traveller> oTraveller = travellerService.getTraveller(request.getTravellerId());
        Trip trip = request.getTrip();

        if (oTraveller.isPresent()) {
            Traveller traveller = oTraveller.get();
            trip.addTraveller(traveller);
            return tripRepository.save(trip);
        } else {
            throw new TravellerNotFoundException();
        }
    }

    /**
     * Gets all Trips from Repository
     *
     * @return List of Trips
     */
    public List<Trip> getTrips() {
        return (List<Trip>) tripRepository.findAll();
    }

    /**
     * Trip by its id
     *
     * @param id id
     * @return Optional
     */
    public Trip getTrip(long id) {
        Optional<Trip> oTrip = tripRepository.findById(id);
        return oTrip.orElse(null);
    }

    /**
     * Adds existing Traveller to existing Trip
     *
     * @param request AddTravellerToTripRequest
     * @return New Trip state
     */
    public Trip addTravellerToTrip(TravellerTripRequest request) {
        errorHandleTravellerTripRequest(request);
        Optional<Traveller> oTraveller = travellerService.getTraveller(request.getTravellerId());
        Optional<Trip> oTrip = tripRepository.findById(request.getTripId());

        Traveller traveller;
        Trip trip;
        if (oTraveller.isPresent()) {
            traveller = oTraveller.get();
        } else {
            throw new TravellerNotFoundException();
        }
        if (oTrip.isPresent()) {
            Optional<Trip> oRepoTrip = tripRepository.findById(oTrip.get().getId());
            if (oRepoTrip.isPresent()) {
                trip = oRepoTrip.get();
                trip.addTraveller(traveller);
                return tripRepository.save(trip);
            }
        } else {
            throw new TripNotFoundException();
        }
        return null; //dead code but java
    }

    public String removeTravellerFromTrip(TravellerTripRequest request) {
        errorHandleTravellerTripRequest(request);
        Optional<Traveller> oTraveller = travellerService.getTraveller(request.getTravellerId());
        Optional<Trip> oTrip = tripRepository.findById(request.getTripId());

        Traveller traveller;
        Trip trip;
        if (oTraveller.isPresent()) {
            traveller = oTraveller.get();
        } else {
            throw new TravellerNotFoundException();
        }
        if (oTrip.isPresent()) {
            trip = oTrip.get();

            TravellerPackingList list = trip.getTravellerPackingList(traveller);
            travellerPackingListService.remove(list);
            //FIXME list is not being removed

            trip.removeTraveller(traveller);
            tripRepository.save(trip);

            return "success";
        } else {
            throw new TripNotFoundException();
        }
    }

    private void errorHandleTravellerTripRequest(TravellerTripRequest request) {
        if (request == null) {
            throw new RequestBodyMissingException();
        }
        if (request.getTravellerId() == 0) {
            throw new TravellerIdMissingException();
        }
        if (request.getTripId() == 0) {
            throw new TripIdMissingException();
        }
    }

}
