package com.laibold.roadtrippackliste.model.packingList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laibold.roadtrippackliste.model.packingList.item.Item;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Superclass for PackingList and TravellerPackingList
 */
@Entity
@DiscriminatorOptions(force = true) //otherwise problems with subclasses and JPA/JSON
public abstract class PackingList {

    @Id
    @GeneratedValue
    private long id;

    @Version
    @JsonIgnore
    private long version;

    @OneToMany(mappedBy = "packingList", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public PackingList() {
    }

    public PackingList(long id, long version, List<Item> items) {
        this.id = id;
        this.version = version;
        this.items = items;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        for (Item item : items) {
            this.addItem(item);
        }
    }

    public void addItem(Item item) {
        item.setPackingList(this);
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

}
