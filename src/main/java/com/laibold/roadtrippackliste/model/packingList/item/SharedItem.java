package com.laibold.roadtrippackliste.model.packingList.item;

import com.laibold.roadtrippackliste.model.traveller.Traveller;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Item for SharedPackingList, can be checked by several Travellers
 */
@Entity
public class SharedItem extends Item {

    @ManyToOne
    private Traveller packingTraveller;

    public SharedItem() {
        super();
    }

    public SharedItem(long id, long version, String name, Traveller packingTraveller) {
        super(id, version, name);
        this.packingTraveller = packingTraveller;
    }

    public SharedItem(Traveller packingTraveller) {
        this.packingTraveller = packingTraveller;
    }

    public Traveller getPackingTraveller() {
        return packingTraveller;
    }

    public void setPackingTraveller(Traveller packingTraveller) {
        this.packingTraveller = packingTraveller;
    }

    public void setChecked(boolean checked, Traveller traveller){
        this.packingTraveller = traveller;
        setChecked(checked);
    }

}
