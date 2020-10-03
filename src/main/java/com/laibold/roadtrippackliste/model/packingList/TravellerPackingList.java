package com.laibold.roadtrippackliste.model.packingList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.model.trip.Trip;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
public class TravellerPackingList extends PackingList{

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Traveller traveller;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Trip trip;

    public TravellerPackingList() {
    }

    public TravellerPackingList(Traveller traveller, Trip trip) {
        super();
        this.traveller = traveller;
        this.trip = trip;
    }

    public TravellerPackingList(long id, long version, List<Item> items, Traveller traveller, Trip trip) {
        super(id, version, items);
        this.traveller = traveller;
        this.trip = trip;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
