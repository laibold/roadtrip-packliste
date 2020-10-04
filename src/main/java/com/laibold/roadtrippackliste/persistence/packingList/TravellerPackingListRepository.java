package com.laibold.roadtrippackliste.persistence.packingList;

import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.TravellerPackingList;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TravellerPackingListRepository extends CrudRepository<TravellerPackingList, Long> {
    Optional<TravellerPackingList> getByTripIdAndTravellerId(long tripId, long travellerId);
}
