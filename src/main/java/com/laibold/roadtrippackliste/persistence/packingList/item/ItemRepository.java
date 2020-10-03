package com.laibold.roadtrippackliste.persistence.packingList.item;

import com.laibold.roadtrippackliste.model.packingList.item.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, String> {

}
