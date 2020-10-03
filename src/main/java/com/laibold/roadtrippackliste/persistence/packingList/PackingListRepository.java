package com.laibold.roadtrippackliste.persistence.packingList;

import com.laibold.roadtrippackliste.model.packingList.PackingList;
import org.springframework.data.repository.CrudRepository;

public interface PackingListRepository extends CrudRepository<PackingList, Long> {

}
