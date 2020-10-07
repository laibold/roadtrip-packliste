package com.laibold.roadtrippackliste.service.rest;

import com.laibold.roadtrippackliste.model.exception.notFound.TripNotFoundException;
import com.laibold.roadtrippackliste.model.trip.Trip;

public class RestPreconditions {
    public static Trip checkFound(Trip trip) {
        if (trip == null) {
            throw new TripNotFoundException();
        }
        return trip;
    }

}
