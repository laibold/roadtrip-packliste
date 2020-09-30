package com.laibold.roadtrippackliste.persistence.item;

import com.laibold.roadtrippackliste.model.item.SharedItem;
import org.springframework.data.repository.CrudRepository;

public interface SharedItemRepository extends CrudRepository<SharedItem, String> {
}
