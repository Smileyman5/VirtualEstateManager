package com.vem.controller.dao;

import com.vem.controller.model.Landlord;
import com.vem.controller.model.Rental;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
public interface RentalDao {
    public void add(Rental rental);
    public void edit(Rental rental);
    public void delete(Rental rental);
    public Rental getRental(int rentalId);
    public List<Rental> getAllRentals();
}
