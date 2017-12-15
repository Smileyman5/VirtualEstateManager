package com.vem.controller.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by alex on 12/15/17.
 */
@Entity
public class Application {
    @Id
    @Column(name = "move_date")
    private Date moveDate;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public Date getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(Date moveDate) {
        this.moveDate = moveDate;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
