package com.laibold.roadtrippackliste.model.packingList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.model.trip.Trip;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * PackingList that is shared ba multiple Travellers.
 * Every Trip contains exactly one.
 */
@Entity
public class SharedPackingList extends PackingList {

    @OneToOne
    @JsonIgnore
    private Trip trip;

    public SharedPackingList() {
    }

    public SharedPackingList(long id, long version, List<Item> items, Trip trip) {
        super(id, version, items);
        this.trip = trip;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
