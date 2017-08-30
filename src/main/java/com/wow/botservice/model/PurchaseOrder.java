package com.wow.botservice.model;

/**
 * Created by amar on 29/08/17.
 */
public class PurchaseOrder {

    private String poNbr;
    private String status;

    public String getPoNbr() {
        return poNbr;
    }

    public void setPoNbr(String poNbr) {
        this.poNbr = poNbr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
