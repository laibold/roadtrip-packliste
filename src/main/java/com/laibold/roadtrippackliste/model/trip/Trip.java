package com.laibold.roadtrippackliste.model.trip;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.laibold.roadtrippackliste.model.packingList.*;
import com.laibold.roadtrippackliste.model.traveller.Traveller;

import javax.persistence.*;
import java.util.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
public class Trip {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    @Column
    private String name;

    @ManyToMany
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Traveller> travellers = new HashSet<>();

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private SharedPackingList sharedItemPackingList = new SharedPackingList();

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<TravellerPackingList> travellerPackingLists = new HashSet<>();

    public Trip() {
        this.sharedItemPackingList.setTrip(this);
    }

    public Trip(long id, long version, String name, Set<Traveller> travellers) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.sharedItemPackingList.setTrip(this);
        this.travellers = travellers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(Set<Traveller> travellers) {
        this.travellers = travellers;
        for (Traveller traveller : travellers) {
            this.addTravellerPackingList(traveller);
        }
    }

    public void addTraveller(Traveller traveller) {
        this.travellers.add(traveller);
        this.addTravellerPackingList(traveller);
    }

    public SharedPackingList getSharedItemPackingList() {
        return sharedItemPackingList;
    }

    public void setSharedItemPackingList(SharedPackingList sharedItemPackingList) {
        this.sharedItemPackingList = sharedItemPackingList;
    }

    public Set<TravellerPackingList> getTravellerPackingLists() {
        return travellerPackingLists;
    }

    public void setTravellerPackingLists(Set<TravellerPackingList> travellerPackingLists) {
        this.travellerPackingLists = travellerPackingLists;
    }

    private void addTravellerPackingList(Traveller traveller) {
        this.travellerPackingLists.add(new TravellerPackingList(traveller, this));
    }

}
