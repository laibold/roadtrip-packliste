package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.exception.badRequest.ItemMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.RequestBodyMissingException;
import com.laibold.roadtrippackliste.model.exception.notFound.ItemNotFoundException;
import com.laibold.roadtrippackliste.model.exception.notFound.PackingListNotFoundException;
import com.laibold.roadtrippackliste.model.packingList.PackingList;
import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.TravellerPackingList;
import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import com.laibold.roadtrippackliste.model.requests.packingList.CheckItemRequest;
import com.laibold.roadtrippackliste.persistence.packingList.SharedPackingListRepository;
import com.laibold.roadtrippackliste.persistence.packingList.TravellerPackingListRepository;
import com.laibold.roadtrippackliste.persistence.packingList.item.ItemRepository;
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
    ItemRepository itemRepository;

    public TravellerPackingList addItem(long tripId, long travellerId, Item item) {
        if (item == null) {
            throw new RequestBodyMissingException();
        }
        if (item.getName() == null) {
            throw new ItemMissingException();
        }

        Optional<TravellerPackingList> oPackingList = packingListRepository.getByTripIdAndTravellerId(tripId, travellerId);
        if (oPackingList.isPresent()) {
            TravellerPackingList list = oPackingList.get();
            list.addItem(item);
            return packingListRepository.save(list);
        } else {
            throw new PackingListNotFoundException();
        }
    }

    public String removeItem(long itemId) {
        Optional<Item> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            Item item = oItem.get();
            itemRepository.delete(item);
            return "success";
        } else {
            throw new ItemNotFoundException();
        }
    }

    public Item setChecked(long itemId, CheckItemRequest request) {
        if (request == null) {
            throw new RequestBodyMissingException();
        }

        Item item;
        Optional<Item> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            item = oItem.get();
            item.setChecked(request.isChecked());
            return itemRepository.save(item);
        } else {
            throw new ItemNotFoundException();
        }
    }

    public void remove(TravellerPackingList list) {
        packingListRepository.delete(list);
    }
}
