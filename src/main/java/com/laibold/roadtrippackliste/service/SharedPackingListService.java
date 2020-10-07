package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.exception.badRequest.ItemMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.RequestBodyMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerIdMissingException;
import com.laibold.roadtrippackliste.model.exception.notFound.ItemNotFoundException;
import com.laibold.roadtrippackliste.model.exception.notFound.SharedPackingListNotFoundException;
import com.laibold.roadtrippackliste.model.exception.notFound.TravellerNotFoundException;
import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import com.laibold.roadtrippackliste.model.requests.packingList.CheckItemRequest;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.persistence.packingList.SharedPackingListRepository;
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
        if (item == null) {
            throw new RequestBodyMissingException();
        }
        if (item.getName() == null) {
            throw new ItemMissingException();
        }

        Optional<SharedPackingList> oPackingList = packingListRepository.getByTripId(tripId);
        if (oPackingList.isPresent()) {
            SharedPackingList list = oPackingList.get();
            list.addItem(item);
            return packingListRepository.save(list);
        } else {
            throw new SharedPackingListNotFoundException();
        }
    }

    public String removeItem(long itemId) {
        Optional<SharedItem> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            SharedItem item = oItem.get();
            itemRepository.delete(item);
            return "success";
        } else {
            throw new ItemNotFoundException();
        }
    }

    public SharedItem setChecked(long itemId, CheckItemRequest request) {
        if (request == null) {
            throw new RequestBodyMissingException();
        }
        if (request.getTravellerId() == 0) {
            throw new TravellerIdMissingException();
        }

        Traveller traveller;
        SharedItem item;
        Optional<SharedItem> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            item = oItem.get();
        } else {
            throw new ItemNotFoundException();
        }
        Optional<Traveller> oTraveller = travellerService.getTraveller(request.getTravellerId());
        if (oTraveller.isPresent()) {
            traveller = oTraveller.get();
            item.setChecked(request.isChecked(), traveller);
            return itemRepository.save(item);
        } else {
            throw new TravellerNotFoundException();
        }
    }
}
