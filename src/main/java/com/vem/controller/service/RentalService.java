package com.vem.controller.service;

import com.vem.controller.dao.RentalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alex on 12/13/2017.
 */
@Service
public class RentalService {
    @Autowired
    private RentalDao rentalDao;

    public String getCurrentRentals() {
        return "Test";
    }
}
