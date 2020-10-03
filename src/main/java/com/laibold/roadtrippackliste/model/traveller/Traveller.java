package com.laibold.roadtrippackliste.model.traveller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.laibold.roadtrippackliste.model.trip.Trip;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Traveller {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    @Column
    private String name;

    @ManyToMany(mappedBy = "travellers")
    @JsonIgnore
    private Set<Trip> trips = new HashSet<>();

    public Traveller() {
    }

    public Traveller(long id, long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
//        this.trips = trips;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
}
