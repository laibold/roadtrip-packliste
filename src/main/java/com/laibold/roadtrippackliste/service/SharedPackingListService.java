package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import com.laibold.roadtrippackliste.model.requests.packingList.CheckItemRequest;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.persistence.packingList.SharedPackingListRepository;
import com.laibold.roadtrippackliste.persistence.packingList.item.ItemRepository;
import com.laibold.roadtrippackliste.persistence.packingList.item.SharedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Service for SharedPackingLists
 */
@Component
public class SharedPackingListService {
    @Autowired
    TravellerService travellerService;

    @Autowired
    SharedPackingListRepository packingListRepository;

    @Autowired
    SharedItemRepository itemRepository;

    public SharedPackingList addItem(long tripId, SharedItem item) {
        Optional<SharedPackingList> oPackingList = packingListRepository.getByTripId(tripId);
        if (oPackingList.isPresent()) {
            SharedPackingList list = oPackingList.get();
            list.addItem(item);
            return packingListRepository.save(list);
        } //TODO error handling
        return null;
    }

    public void removeItem(long itemId) {
        Optional<SharedItem> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            SharedItem item = oItem.get();
            itemRepository.delete(item);
        } //TODO error handling
    }

    public SharedItem setChecked(long itemId, CheckItemRequest request) {
        Traveller traveller;
        SharedItem item;
        Optional<SharedItem> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            item = oItem.get();
        } else {
            return null;
        }
        Optional<Traveller> oTraveller = travellerService.getTraveller(request.getTravellerId());
        if (oTraveller.isPresent()) {
            traveller = oTraveller.get();
            item.setChecked(request.isChecked(), traveller);
            return itemRepository.save(item);
        }
        //TODO error handling
        return null;
    }
}
