package com.laibold.roadtrippackliste.model.item;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    @Column
    private String name;

    @Column
    private boolean checked;

    public Item(long id, long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public Item() {

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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
