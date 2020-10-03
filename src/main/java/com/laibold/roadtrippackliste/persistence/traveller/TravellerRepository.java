package com.laibold.roadtrippackliste.persistence.traveller;

import com.laibold.roadtrippackliste.model.traveller.Traveller;
import org.springframework.data.repository.CrudRepository;

public interface TravellerRepository extends CrudRepository<Traveller, Long> {

}
