package com.vem.controller.dao;

import com.vem.controller.model.Landlord;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
public interface LandlordDao {
    public void add(Landlord landlord);
    public void edit(Landlord landlord);
    public void delete(Landlord landlord);
    public Landlord getLandlord(int landlordId);
    public List getAllLandlords();
}
