package com.laibold.roadtrippackliste.model.packingList;

import com.laibold.roadtrippackliste.model.packingList.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PackingList {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    @OneToMany(mappedBy = "packingList")
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
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

}
