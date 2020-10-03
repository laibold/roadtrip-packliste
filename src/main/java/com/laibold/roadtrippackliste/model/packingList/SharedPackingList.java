package com.laibold.roadtrippackliste.model.packingList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.model.trip.Trip;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
public class SharedPackingList extends PackingList {

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
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
