package com.laibold.roadtrippackliste.persistence.packingList.item;

import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import org.springframework.data.repository.CrudRepository;

public interface SharedItemRepository extends CrudRepository<SharedItem, Long> {
}
