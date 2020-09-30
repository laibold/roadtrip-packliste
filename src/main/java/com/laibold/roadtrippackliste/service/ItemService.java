package com.laibold.roadtrippackliste.service;

import com.laibold.roadtrippackliste.model.item.Item;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.persistence.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {
    @Autowired
    ItemRepository repository;

    public void add(Item item) {
        repository.save(item);
    }

    public List<Item> getItemsByTraveller() {
        return (List<Item>) repository.findAllBy();
    }
}
