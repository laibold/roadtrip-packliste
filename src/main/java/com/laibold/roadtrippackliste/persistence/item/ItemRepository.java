package com.laibold.roadtrippackliste.persistence.item;

import com.laibold.roadtrippackliste.model.item.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, String> {

}
