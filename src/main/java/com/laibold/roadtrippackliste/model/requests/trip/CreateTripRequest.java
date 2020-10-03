package com.laibold.roadtrippackliste.model.requests.trip;

import com.laibold.roadtrippackliste.model.trip.Trip;

/**
 * Request for creating a new Trip.
 * Needs Trip object and id of an existing traveller.
 */
public class CreateTripRequest {

    private Trip trip;
    private long travellerId;

    public CreateTripRequest() {
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public long getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(long id) {
        this.travellerId = id;
    }

}
