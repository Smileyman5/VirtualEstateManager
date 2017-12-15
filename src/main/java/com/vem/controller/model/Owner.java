package com.vem.controller.model;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

/**
 * Created by alex on 12/15/17.
 */
@Entity
public class Owner {
    @Id
    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "price")
    private double price;

    @Column(name = "deed_data")
    private Blob deedData;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;


    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Blob getDeedData() {
        return deedData;
    }

    public void setDeedData(Blob deedData) {
        this.deedData = deedData;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
