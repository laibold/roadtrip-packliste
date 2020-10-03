package com.laibold.roadtrippackliste.model.requests.packingList;

public class CheckItemRequest {

    boolean checked;
    long TravellerId;

    public CheckItemRequest() {
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public long getTravellerId() {
        return TravellerId;
    }

    public void setTravellerId(long travellerId) {
        TravellerId = travellerId;
    }

}
