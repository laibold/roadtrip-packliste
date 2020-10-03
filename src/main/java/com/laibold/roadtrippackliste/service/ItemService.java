package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.persistence.packingList.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Servive for Items
 */
@Component
public class ItemService {
    @Autowired
    ItemRepository repository;

    /**
     * Adds Item to Repository
     * @param item Item to add
     */
    public void add(Item item) {
        repository.save(item);
    }

//    public List<Item> getItemsByTrip() {
//        return (List<Item>) repository.findAllBy();
//    }

}
