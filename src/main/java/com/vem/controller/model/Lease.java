package com.vem.controller.model;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

/**
 * Created by alex on 12/15/17.
 */
@Entity
public class Lease {
    @Id
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "rent")
    private double rent;

    @Column(name = "lease_data")
    private Blob leaseData;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public Blob getLeaseData() {
        return leaseData;
    }

    public void setLeaseData(Blob leaseData) {
        this.leaseData = leaseData;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
