package com.vem.controller.model;

import javax.persistence.*;

/**
 * Created by alex on 12/15/17.
 */
@Entity
public class Applicant {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tenantId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "accepted")
    private boolean accepted;

    @Column(name = "job")
    private String job;

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
