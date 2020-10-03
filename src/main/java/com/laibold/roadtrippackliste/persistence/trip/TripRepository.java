package com.laibold.roadtrippackliste.persistence.trip;

import com.laibold.roadtrippackliste.model.trip.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {
}
