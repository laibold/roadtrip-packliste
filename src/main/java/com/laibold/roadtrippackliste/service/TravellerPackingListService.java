package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.packingList.PackingList;
import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.TravellerPackingList;
import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import com.laibold.roadtrippackliste.persistence.packingList.SharedPackingListRepository;
import com.laibold.roadtrippackliste.persistence.packingList.TravellerPackingListRepository;
import com.laibold.roadtrippackliste.persistence.packingList.item.SharedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Service for TravellerPackingLists
 */
@Component
public class TravellerPackingListService {
    @Autowired
    TravellerService travellerService;

    @Autowired
    TravellerPackingListRepository packingListRepository;

    @Autowired
    SharedItemRepository itemRepository;

    public TravellerPackingList addItem(long tripId, long travellerId, SharedItem item) {
        Optional<TravellerPackingList> oPackingList = packingListRepository.getByTripIdAndTravellerId(tripId, travellerId);
        if (oPackingList.isPresent()) {
            TravellerPackingList list = oPackingList.get();
            list.addItem(item);
            return packingListRepository.save(list);
        } //TODO error handling
        return null;
    }


}
