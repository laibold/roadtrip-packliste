package com.laibold.roadtrippackliste.model.requests.trip;

/**
 * Request for adding or removing an existing traveller to/from an existing Trip.
 * Needs ids of existing Traveller and Trip.
 */
public class TravellerTripRequest {
    private long travellerId;
    private long tripId;

    public TravellerTripRequest() {
    }

    public long getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(long travellerId) {
        this.travellerId = travellerId;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }
}
