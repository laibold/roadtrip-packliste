package com.laibold.roadtrippackliste.model.item;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private String id;

    @Version
    private long version;

    @Column
    private String name;

    public Item(String id, long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public Item() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
