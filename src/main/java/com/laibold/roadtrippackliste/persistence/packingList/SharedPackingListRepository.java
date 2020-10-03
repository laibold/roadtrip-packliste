package com.laibold.roadtrippackliste.persistence.packingList;

import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SharedPackingListRepository extends CrudRepository<SharedPackingList, Long> {
    Optional<SharedPackingList> getByTripId(long TripId);
}
