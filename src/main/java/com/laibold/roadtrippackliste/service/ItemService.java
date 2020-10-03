package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.persistence.packingList.item.ItemRepository;
import com.laibold.roadtrippackliste.persistence.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service for Items
 */
@Component
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    /**
     * Adds Item to Repository
     * @param item Item to add
     */
    public void add(Item item) {
        itemRepository.save(item);
    }

//    public List<Item> getItemsByTrip() {
//        return (List<Item>) repository.findAllBy();
//    }

}
