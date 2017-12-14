package com.vem.controller.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by alex on 12/13/2017.
 */
@Entity
public class Contract {
    @Id
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "cost")
    private double cost;

    @Column(name = "contract_data")
    private Object contractData;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Object getContractData() {
        return contractData;
    }

    public void setContractData(Object contractData) {
        this.contractData = contractData;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental space) {
        this.rental = rental;
    }
}
