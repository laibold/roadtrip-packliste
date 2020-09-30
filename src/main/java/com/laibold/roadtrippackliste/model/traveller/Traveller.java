package com.laibold.roadtrippackliste.model.traveller;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Traveller {

    @Id
    @GeneratedValue
    private String id;

    @Version
    private long version;

    @Column
    private String name;

//    @OneToMany(mappedBy = "traveller")
//    private Collection

    public Traveller() {

    }

    public Traveller(String id, long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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
}
