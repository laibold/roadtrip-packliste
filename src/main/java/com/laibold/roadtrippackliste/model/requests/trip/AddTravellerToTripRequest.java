package com.laibold.roadtrippackliste.model.requests.trip;

public class AddTravellerToTripRequest {
    private long TravellerId;
    private long TripId;

    public AddTravellerToTripRequest() {
    }

    public long getTravellerId() {
        return TravellerId;
    }

    public void setTravellerId(long travellerId) {
        TravellerId = travellerId;
    }

    public long getTripId() {
        return TripId;
    }

    public void setTripId(long tripId) {
        TripId = tripId;
    }
}
